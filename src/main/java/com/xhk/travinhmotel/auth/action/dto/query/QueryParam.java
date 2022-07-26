package com.xhk.travinhmotel.auth.action.dto.query;

import com.xhk.travinhmotel.auth.action.dto.Direction;
import com.xhk.travinhmotel.auth.action.dto.QueryPredicate;
import com.xhk.travinhmotel.auth.action.dto.filter.FilterParam;
import com.xhk.travinhmotel.auth.utils.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class QueryParam<T extends FilterParam> {

    private int size = Integer.MAX_VALUE;

    private int index;

    private String sort;

    private Direction order = Direction.ASC;

    private T filter;

    public Map<String, Object> buildFilterParams() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Object> params = new HashMap<>();
        List<String> listField = ObjectUtils.getListField(AccountQueryParam.class);
        for (String field : listField) {
            params.put(field, ObjectUtils.getFieldFromObject(getFilter(), field));
        }

        return params;
    }

    public final QueryPredicate build() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Object> params = this.buildFilterParams();
        return new QueryPredicate(params, size, index, sort, order);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Direction getOrder() {
        return order;
    }

    public void setOrder(Direction order) {
        this.order = order;
    }

    public T getFilter() {
        return filter;
    }

    public void setFilter(T filter) {
        this.filter = filter;
    }
}
