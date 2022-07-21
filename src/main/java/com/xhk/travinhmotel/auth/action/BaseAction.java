package com.xhk.travinhmotel.auth.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.opensymphony.xwork2.Action.ERROR;

@ExceptionMappings(
        value = {
                @ExceptionMapping(exception = "java.lang.Exception", result = ERROR),
        }
)
public abstract class BaseAction extends ActionSupport implements Parameterizable, ServletRequestAware, ServletResponseAware {
    private static final long serialVersionUID = 1L;
    protected final transient Logger log = LogManager.getLogger(this.getClass());

    protected transient HttpServletRequest request;
    protected transient HttpServletResponse response;

    private Map<String, Object> params = new LinkedHashMap<>();

    public void addParam(String key, Object value) {
        this.params.put(key, value);
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }


    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}