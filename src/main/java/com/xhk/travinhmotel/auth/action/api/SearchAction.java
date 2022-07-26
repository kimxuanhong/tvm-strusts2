package com.xhk.travinhmotel.auth.action.api;

import com.xhk.travinhmotel.auth.action.base.JsonAction;
import com.xhk.travinhmotel.auth.action.dto.SearchDto;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

@Namespace("/api/motel")
@Action(value = "search")
public class SearchAction extends JsonAction {
    private static final long serialVersionUID = 1L;

    private SearchDto search;

    @Override
    public String execute() throws Exception {
        addJsonParam(search);
        return SUCCESS;
    }

    public SearchDto getSearch() {
        return search;
    }

    public void setSearch(SearchDto search) {
        this.search = search;
    }
}