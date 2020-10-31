package spring.starter.web.configuration.shiro;

import org.apache.shiro.authc.BearerToken;

/**
 * @author pickjob@126.com
 * @date 2020-02-23
 */
public class MyJwtToken extends BearerToken {

    public MyJwtToken(String token) {
        super(token);
    }

    @Override
    public String toString() {
        return "[MyJwtToken=" + getToken() + "]";
    }
}
