package com.xhk.travinhmotel.auth.action.web;

import com.xhk.travinhmotel.auth.action.base.WebAction;
import com.xhk.travinhmotel.auth.dao.CategoryDao;
import com.xhk.travinhmotel.auth.dao.CityDao;
import com.xhk.travinhmotel.auth.dao.DistrictDao;
import com.xhk.travinhmotel.auth.dao.UtilityDao;
import com.xhk.travinhmotel.auth.entity.Category;
import com.xhk.travinhmotel.auth.entity.City;
import com.xhk.travinhmotel.auth.entity.District;
import com.xhk.travinhmotel.auth.entity.Utility;
import com.xhk.travinhmotel.auth.security.Secured;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import java.util.List;

@Namespace("/home")
public class HomeAction extends WebAction {

    private static final long serialVersionUID = 1L;

    @Secured
    @Action(value = "index", results = {
            @Result(name = SUCCESS, location = "home.index", type = "tiles")
    })
    public String index() {
        List<Category> categories = CategoryDao.getInstance().findAll();
        addParam("categories", categories);
        List<City> cities = CityDao.getInstance().findAll();
        addParam("cities", cities);
        List<District> districts = DistrictDao.getInstance().findAll();
        addParam("districts", districts);
        List<Utility> utilities = UtilityDao.getInstance().findAll();
        addParam("utilities", utilities);

        return SUCCESS;
    }
}