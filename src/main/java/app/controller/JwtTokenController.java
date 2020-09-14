package app.controller;

import app.config.properties.JwtProperties;
import app.dao.primary.PrimaryUserDao;
import app.model.MyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.NumericDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pickjob@126.com
 * @date 2020-06-26
 */
@Tag(name = "JWT示例")
@RequestMapping("/v1/token")
@RestController
public class JwtTokenController {
    private static final Logger logger = LogManager.getLogger(JwtTokenController.class);
    @Autowired private PrimaryUserDao primaryUserDao;
    @Autowired private JwtProperties jwtProperties;

    @Operation(
            summary = "认证",
            parameters = @Parameter(name = "account", description = "登录账号", in = ParameterIn.QUERY, required = true, example = "china")
    )
    @PostMapping("/authz")
    public MyResponse auth(String account) throws Exception {
        JwtClaims claims = new JwtClaims();
        claims.setExpirationTime(NumericDate.fromSeconds( System.currentTimeMillis() / 1000 + 60 * 60 * 24));
        claims.setSubject(primaryUserDao.getUserIdByAccount(account) + "");
        claims.setClaim("account", account);
        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setKey(jwtProperties.getRsaPrivateKey());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        return MyResponse.success(jws.getCompactSerialization());
    }


    @Operation(
            summary = "受保护的资源-可以通过",
            security = { @SecurityRequirement(name = "auth") }
    )
    @RequiresPermissions("v1:token:authc")
    @GetMapping("/authc1")
    public MyResponse authc1() {
        return MyResponse.success("通过权限校验");
    }

    @Operation(
            summary = "受保护的资源-永远通不过",
            security = { @SecurityRequirement(name = "auth") }
    )
    @RequiresPermissions("~~~~")
    @GetMapping("/authc2")
    public MyResponse authc2() {
        return MyResponse.success("永远通不过");
    }

}
