package com.xhk.travinhmotel.auth.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/home")
public class HomeAction extends WebAction {

    private static final long serialVersionUID = 1L;

    private String productName;

    @Action(value = "index", results = {
            @Result(name = SUCCESS, location = "home.index", type = "tiles")
    })
    public String index() {
        productName = "kimxuanhong";
        return SUCCESS;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}