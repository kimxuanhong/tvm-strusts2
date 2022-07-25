package com.xhk.travinhmotel.auth.action.base;

import com.xhk.travinhmotel.auth.action.dto.JsonResponse;
import org.apache.struts2.convention.annotation.*;

import static com.opensymphony.xwork2.Action.*;

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
                                "root", "params.jsonDataError500",
                                "statusCode", "500"
                        }
                ),
                @Result(
                        name = LOGIN,
                        type = "json",
                        params = {
                                "root", "params.jsonDataError401",
                                "statusCode", "401",
                        }
                )
        }
)
@InterceptorRefs(
        value = {
                @InterceptorRef(value = "appDefaultStack"),
                @InterceptorRef(
                        value = "json",
                        params = {
                                "enableSMD", "true"
                        }
                )
        }
)
@ExceptionMappings(
        value = {
                @ExceptionMapping(exception = "java.lang.Exception", result = ERROR),
                @ExceptionMapping(exception = "java.lang.NullPointerException", result = ERROR)
        }
)
@ParentPackage("api-controllers")
public abstract class JsonAction extends BaseAction {
    protected JsonAction() {
        addParam("jsonDataError401", new JsonResponse("401", "401 Unauthorized"));
        addParam("jsonDataError500", new JsonResponse("500", "500 Server Error"));
    }

    public void addJsonParam(Object jsonData) {
        addParam("jsonData", jsonData);
    }
}