package app.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author pickjob@126.com
 * @time 2020-02-23
 */
public class MyAuthenticationToken implements AuthenticationToken {
    private String token;

    public MyAuthenticationToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
