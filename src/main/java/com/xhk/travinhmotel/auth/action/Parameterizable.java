package com.xhk.travinhmotel.auth.action;

import java.io.Serializable;
import java.util.Map;

public interface Parameterizable {
    void addParam(String var1, Serializable var2);
    void setParams(Map<String, Serializable> var1);
    Map<String, Serializable> getParams();
}
