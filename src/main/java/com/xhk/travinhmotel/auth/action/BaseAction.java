package com.xhk.travinhmotel.auth.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BaseAction extends ActionSupport implements Parameterizable, Serializable {
    private static final long serialVersionUID = 1L;
    
    private Map<String, Serializable> params = new HashMap<>();

    public void addParam(String key, Serializable value) {
        this.params.put(key, value);
    }

    public Map<String, Serializable> getParams() {
        return this.params;
    }

    public void setParams(Map<String, Serializable> params) {
        this.params = params;
    }
}