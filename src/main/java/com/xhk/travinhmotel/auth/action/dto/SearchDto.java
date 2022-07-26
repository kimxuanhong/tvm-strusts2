package com.xhk.travinhmotel.auth.action.dto;

import java.math.BigDecimal;

public class SearchDto {
    private BigDecimal price_min;
    private BigDecimal price_max;
    private Integer acreage_min;
    private Integer acreage_max;
    private Long district;
    private Long province;
    private Long category;
    private Long[] convenient;
    private String name;

    public BigDecimal getPrice_min() {
        return price_min;
    }

    public void setPrice_min(BigDecimal price_min) {
        this.price_min = price_min;
    }

    public BigDecimal getPrice_max() {
        return price_max;
    }

    public void setPrice_max(BigDecimal price_max) {
        this.price_max = price_max;
    }

    public Integer getAcreage_min() {
        return acreage_min;
    }

    public void setAcreage_min(Integer acreage_min) {
        this.acreage_min = acreage_min;
    }

    public Integer getAcreage_max() {
        return acreage_max;
    }

    public void setAcreage_max(Integer acreage_max) {
        this.acreage_max = acreage_max;
    }

    public Long getDistrict() {
        return district;
    }

    public void setDistrict(Long district) {
        this.district = district;
    }

    public Long getProvince() {
        return province;
    }

    public void setProvince(Long province) {
        this.province = province;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long[] getConvenient() {
        return convenient;
    }

    public void setConvenient(Long[] convenient) {
        this.convenient = convenient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
