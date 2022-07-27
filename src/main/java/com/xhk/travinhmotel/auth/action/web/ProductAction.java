package com.xhk.travinhmotel.auth.action.web;

import com.xhk.travinhmotel.auth.action.base.WebAction;
import com.xhk.travinhmotel.auth.dao.MotelDao;
import com.xhk.travinhmotel.auth.entity.Motel;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import java.util.List;

@Namespace("/product")
public class ProductAction extends WebAction {

    private static final long serialVersionUID = 1L;

    @Action(value = "detail", results = {
            @Result(name = SUCCESS, location = "product.detail", type = "tiles")
    })
    public String index() {
        return SUCCESS;
    }

    @Action(value = "newest", results = {
            @Result(name = SUCCESS, location = "product.list", type = "tiles")
    })
    public String getNewest() {
        List<Motel> motels = MotelDao.getInstance().findAll();
        addParam("motels", motels);

        return SUCCESS;
    }

}