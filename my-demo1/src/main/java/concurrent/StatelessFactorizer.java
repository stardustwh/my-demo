package concurrent;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

public class StatelessFactorizer implements Servlet {
    private final AtomicLong count = new AtomicLong(0);
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        count.incrementAndGet();

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
