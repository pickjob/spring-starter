package spring.starter.web.configuration.shiro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.BearerHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import spring.starter.base.consts.SecurityConsts;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * @author pickjob@126.com
 * @date 2020-03-04
 */
public class MyAuthenticationFilter extends BearerHttpAuthenticationFilter {
    private static final Logger logger = LogManager.getLogger(MyAuthenticationFilter.class);

    @Override
    protected String getAuthzHeader(ServletRequest request) {
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        String securityHeader = httpRequest.getHeader(SecurityConsts.SECURITY_HEADER);
        logger.info("Security-Header: {}", securityHeader);
        return securityHeader;
    }

    @Override
    protected AuthenticationToken createBearerToken(String token, ServletRequest request) {
        return new MyJwtToken(token);
    }
}
