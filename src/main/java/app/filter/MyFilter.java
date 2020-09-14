package app.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author pickjob@126.com
 * @date 2019-02-21
 */
public class MyFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(MyFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        logger.info("request: {}", req.getServletPath());
        chain.doFilter(request, response);
    }
}
