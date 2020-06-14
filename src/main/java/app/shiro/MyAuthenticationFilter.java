package app.shiro;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pickjob@126.com
 * @time 2020-03-04
 */
public class MyAuthenticationFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(MyAuthenticationFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
//        String authToken = req.getHeader("Auth-Token");
//        MyAuthenticationToken token = new MyAuthenticationToken(authToken);
//        Subject subject = SecurityUtils.getSubject();
//        subject.login(token);
        chain.doFilter(req, resp);
    }
}
