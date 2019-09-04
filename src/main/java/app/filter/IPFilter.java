package app.filter;

import app.common.RequestAttributeEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class IPFilter implements Filter {
	private static Logger logger = LogManager.getLogger(IPFilter.class);
	private static final String UNKOWN = "unknown";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String ip = null;
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            ip = req.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || UNKOWN.equalsIgnoreCase(ip)) {
                ip = req.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || UNKOWN.equalsIgnoreCase(ip)) {
                ip = req.getHeader("X-Forwarded-For");
            }
            if (ip == null || ip.length() == 0 || UNKOWN.equalsIgnoreCase(ip)) {
                ip = req.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || UNKOWN.equalsIgnoreCase(ip)) {
                ip = req.getHeader("X-Real-IP");
            }
            if (ip == null || ip.length() == 0 || UNKOWN.equalsIgnoreCase(ip)) {
                ip = req.getRemoteAddr();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        request.setAttribute(RequestAttributeEnum.IP.getAttributeName(), ip);
        chain.doFilter(request, response);
    }
}
