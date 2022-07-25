package com.xhk.travinhmotel.auth.action;

import org.apache.struts2.convention.annotation.*;

import static com.opensymphony.xwork2.Action.ERROR;

//@Results(
//        value = {
//                @Result(
//                        name = ERROR,
//                        type = "tiles",
//                        location = "error.index"
//                )
//        }
//)
@ExceptionMappings(
        value = {
                @ExceptionMapping(exception = "java.lang.Exception", result = ERROR),
        }
)
@ParentPackage("web-controllers")
public abstract class WebAction extends BaseAction {
}

