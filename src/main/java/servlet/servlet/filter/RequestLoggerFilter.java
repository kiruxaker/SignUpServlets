package servlet.servlet.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RequestLoggerFilter implements Filter{

    private static final Logger LOGGER = Logger.getLogger(RequestLoggerFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("Creating RequestLoggerFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)){
                LOGGER.error("Is not http resp/req");
        } else {
            HttpServletRequest req = (HttpServletRequest) request;

            LOGGER.info(String.format("User %s, is requesting %s",
                    req.getSession().getAttribute("currentUserName"),
                    req.getRequestURI()));
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        LOGGER.info("Destroying filter");
    }
}
