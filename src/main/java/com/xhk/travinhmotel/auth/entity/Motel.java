package com.xhk.travinhmotel.auth.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Motel extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String thumbnail;

    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Staff getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Staff createBy) {
        this.createBy = createBy;
    }

    public Staff getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Staff updateBy) {
        this.updateBy = updateBy;
    }

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    private Staff createBy;

    @ManyToOne
    private Staff updateBy;
}
