package com.xhk.travinhmotel.auth.action.dto;

import java.util.Map;

public class QueryPredicate {
    private Map<String, Object> params;
    private int size;
    private int index;
    private String sort;
    private Direction order;

    public QueryPredicate() {
    }

    public QueryPredicate(Map<String, Object> params, int size, int index, String sort, Direction order) {
        this.params = params;
        this.size = size;
        this.index = index;
        this.sort = sort;
        this.order = order;
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

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
