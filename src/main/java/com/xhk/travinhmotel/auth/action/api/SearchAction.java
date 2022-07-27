package com.xhk.travinhmotel.auth.action.api;

import com.xhk.travinhmotel.auth.action.base.JsonAction;
import com.xhk.travinhmotel.auth.action.base.WebAction;
import com.xhk.travinhmotel.auth.action.dto.SearchDto;
import com.xhk.travinhmotel.auth.dao.MotelDao;
import com.xhk.travinhmotel.auth.entity.Motel;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;

@Namespace("/api/motel")
@Action(value = "search",results = {
        @Result(name = SUCCESS, location = "motel.search", type = "tiles")
})
public class SearchAction extends WebAction {
    private static final long serialVersionUID = 1L;

    private SearchDto search;

    @Override
    public String execute() throws Exception {
        List<Motel> motels = MotelDao.getInstance().findAll();
        addParam("motels", motels);
        addParam("totals", motels.size());

        return SUCCESS;
    }

    public SearchDto getSearch() {
        return search;
    }

    public void setSearch(SearchDto search) {
        this.search = search;
    }
}