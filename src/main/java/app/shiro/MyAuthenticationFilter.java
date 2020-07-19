package app.shiro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.BearerHttpAuthenticationFilter;

import javax.servlet.ServletRequest;

/**
 * @author pickjob@126.com
 * @date 2020-03-04
 */
public class MyAuthenticationFilter extends BearerHttpAuthenticationFilter {
    private static final Logger logger = LogManager.getLogger(MyAuthenticationFilter.class);

    @Override
    protected AuthenticationToken createBearerToken(String token, ServletRequest request) {
        return new MyJwtToken(token);
    }
}
