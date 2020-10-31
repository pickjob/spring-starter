package spring.starter.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.NumericDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.starter.base.consts.SecurityConsts;
import spring.starter.base.model.MyResponse;
import spring.starter.web.configuration.properties.JwtProperties;

/**
 * @author pickjob@126.com
 * @date 2020-06-26
 */
@Tag(name = "认证示例")
@RequestMapping("/v1/auth")
@RestController
public class AuthenticationController {
    private static final Logger logger = LogManager.getLogger(AuthenticationController.class);
    @Autowired private JwtProperties jwtProperties;

    @Operation(
            summary = "认证",
            parameters = @Parameter(name = "account", description = "登录账号", in = ParameterIn.QUERY, required = true, example = "china")
    )
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public MyResponse authentication(String account) throws Exception {
        JwtClaims claims = new JwtClaims();
        claims.setExpirationTime(NumericDate.fromSeconds( System.currentTimeMillis() / 1000 + 60 * 60 * 24));
        claims.setSubject("subject");
        claims.setClaim("account", account);
        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setKey(jwtProperties.getRsaPrivateKey());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        return MyResponse.success(jws.getCompactSerialization());
    }

    @Operation(
            summary = "受保护的资源-可以通过"
    )
    @RequiresPermissions(SecurityConsts.PERMISSION_AUTH_PASS)
    @GetMapping("/pass")
    public MyResponse authPass() {
        logger.info("Permission passed!");
        return MyResponse.success("Permission passed!");
    }

    @Operation(
            summary = "受保护的资源-永远通不过"
    )
    @RequiresPermissions("~~~~")
    @GetMapping("/never-pass")
    public MyResponse authNeverPass() {
        logger.info("Permission passed!");
        return MyResponse.success("Permission never passed!");
    }

}
