package com.xhk.travinhmotel.auth.security;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SecurityInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;
    private static final transient Logger log = LogManager.getLogger(SecurityInterceptor.class);

    @Override
    @SuppressWarnings("unchecked")
    public String intercept(ActionInvocation invocation) throws Exception {

        String className = invocation.getAction().getClass().getName();
        long startTime = System.currentTimeMillis();
        log.debug("Before calling action: {}", className);

        Method method = invocation.getAction().getClass().getMethod(invocation.getProxy().getMethod());

        Secured role = method.getAnnotation(Secured.class);

        if (Objects.nonNull(role)) {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();

            String loginStatus = (String) session.getAttribute("loginStatus");
            List<Role> userRoles = (List<Role>) session.getAttribute("userRoles");
            List<Role> funRoles = Arrays.asList(role.value());

            boolean isLogin = loginStatus == null || !loginStatus.equals("true");
            boolean isGrand = userRoles != null && (userRoles.stream().anyMatch(x -> funRoles.stream().anyMatch(y -> y.equals(x))) || (funRoles.size()==1 && funRoles.get(0).equals(Role.GUEST)));

            if (isLogin || !isGrand) {
                return Action.LOGIN;
            }
        }

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