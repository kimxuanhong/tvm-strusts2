package com.xhk.travinhmotel.auth.action.base;

import org.apache.struts2.convention.annotation.*;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.LOGIN;

@Results(
        value = {
                @Result(name = ERROR, location = "error.index", type = "tiles"),
                @Result(name = LOGIN, type = "redirectAction", params = {"actionName", "index", "namespace", "/auth"}),
        }
)
@ExceptionMappings(
        value = {
                @ExceptionMapping(exception = "java.lang.Exception", result = ERROR),
        }
)
@ParentPackage("web-controllers")
public abstract class WebAction extends BaseAction {
}

