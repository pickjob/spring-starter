package spring.starter.web.configuration.shiro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.starter.base.consts.SecurityConsts;
import spring.starter.web.configuration.properties.JwtProperties;

import java.util.List;

/**
 * @author pickjob@126.com
 * @date 2020-02-23
 */
@Component
public class MyRealms extends AuthorizingRealm {
    private static final Logger logger = LogManager.getLogger(MyRealms.class);
    @Autowired private JwtProperties jwtProperties;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                .setRequireExpirationTime()
                .setAllowedClockSkewInSeconds(30)
                .setRequireSubject()
                .setVerificationKey(jwtProperties.getRsaPublicKey())
                .setJwsAlgorithmConstraints(AlgorithmConstraints.ConstraintType.PERMIT, AlgorithmIdentifiers.RSA_USING_SHA256)
                .build();
        try {
            JwtClaims jwtClaims = jwtConsumer.processToClaims(((MyJwtToken)token).getToken());
            logger.info("jwtClaims: {}", jwtClaims);
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(jwtClaims.getSubject(), token.getCredentials(), getName());
            return authenticationInfo;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AuthenticationException("认证失败");
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        List<String> roles = SecurityConsts.SECURITY_ROLES;
        List<String> permissions = SecurityConsts.SECURITY_PERMISSIONS;
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roles);
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof MyJwtToken;
    }
}
