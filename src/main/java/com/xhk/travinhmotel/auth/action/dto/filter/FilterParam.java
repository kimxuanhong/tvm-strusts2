package com.xhk.travinhmotel.auth.action.dto.filter;

import java.util.ArrayList;
import java.util.List;

public abstract class FilterParam {
    private List<Long> ids = new ArrayList<>();

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
