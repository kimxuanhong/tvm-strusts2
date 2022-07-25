package com.xhk.travinhmotel.auth.config;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;
    private static final transient Logger log = LogManager.getLogger(LogInterceptor.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        log.info("Logger");
        String className = invocation.getAction().getClass().getName();
        long startTime = System.currentTimeMillis();
        log.debug("Before calling action: {}", className);

        String result = invocation.invoke();

        long endTime = System.currentTimeMillis();
        log.debug("After calling action: {} Time taken: {} ms", className, endTime - startTime);

        return result;
    }

    @Override
    public void destroy() {
        log.debug("Destroying SecurityInterceptor...");
    }

    @Override
    public void init() {
        log.debug("Initializing SecurityInterceptor...");
    }
}