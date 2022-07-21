package com.xhk.travinhmotel.auth.action;

import java.util.Map;

public interface Parameterizable {
    void addParam(String var1, Object var2);

    void setParams(Map<String, Object> var1);

    Map<String, Object> getParams();
}
