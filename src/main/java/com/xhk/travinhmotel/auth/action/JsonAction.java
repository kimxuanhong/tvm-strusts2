package com.xhk.travinhmotel.auth.action;

import org.apache.struts2.convention.annotation.*;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

@Results(
        value = {
                @Result(
                        name = SUCCESS,
                        type = "json",
                        params = {
                                "root", "params.jsonData",
                                "contentType", "application/json",
                                "encoding", "UTF-8"
                        }
                ),
                @Result(
                        name = ERROR,
                        type = "json",
                        params = {
                                "root", "params.jsonData",
                                "contentType", "application/json",
                                "encoding", "UTF-8",
                                "errorCode", "500"
                        }
                )
        }
)
@InterceptorRefs(
        value = {
                @InterceptorRef(value = "defaultStack"),
                @InterceptorRef(
                        value = "json",
                        params = {
                                "enableSMD", "true",
                                "contentType", "application/json",
                                "encoding", "UTF-8",
                        }
                )
        }
)
@ExceptionMappings(
        value = {
                @ExceptionMapping(exception = "java.lang.Exception", result = ERROR)
        }
)
@ParentPackage("api-controllers")
public abstract class JsonAction extends BaseAction {

    public void addJsonParam(Object jsonData) {
        addParam("jsonData", jsonData);
    }
}

