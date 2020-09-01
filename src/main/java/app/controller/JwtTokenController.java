package app.controller;

import app.config.properties.JwtProperties;
import app.dao.UserDao;
import app.model.MyResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "JWT示例")
@RequestMapping("/v1/token")
@RestController
public class JwtTokenController {
    private static final Logger logger = LogManager.getLogger(JwtTokenController.class);
    @Autowired private UserDao userDao;
    @Autowired private JwtProperties jwtProperties;


    @ApiOperation("认证")
    @ApiImplicitParam(name = "account", value = "登录账号", defaultValue = "china", required = true)
    @PostMapping("/authz")
    public MyResponse auth(String account) throws Exception {
        JwtClaims claims = new JwtClaims();
        claims.setExpirationTime(NumericDate.fromSeconds( System.currentTimeMillis() / 1000 + 60 * 60 * 24 * 365));
        claims.setSubject(userDao.getUserIdByAccount(account) + "");
        claims.setClaim("account", account);
        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setKey(jwtProperties.getRsaPrivateKey());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        return MyResponse.success(jws.getCompactSerialization());
    }


    @ApiOperation("受保护的资源-可以通过")
    @RequiresPermissions("v1:token:authc")
    @GetMapping("/authc1")
    public MyResponse authc1() {
        return MyResponse.success("通过权限校验");
    }

    @ApiOperation("受保护的资源-永远通不过")
    @RequiresPermissions("~~~~")
    @GetMapping("/authc2")
    public MyResponse authc2() {
        return MyResponse.success("永远通不过");
    }

}
