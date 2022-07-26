package com.xhk.travinhmotel.auth.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Motel extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private String phone;
    private String description;
    private Integer acreage;
    private Boolean status;
    private String thumbnail;
    private BigDecimal price;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "create_by_id")
    private Account createBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "update_by_id")
    private Account updateBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "motel", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Feedback> feedback;

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

    public Account getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Account createBy) {
        this.createBy = createBy;
    }

    public Account getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Account updateBy) {
        this.updateBy = updateBy;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAcreage() {
        return acreage;
    }

    public void setAcreage(Integer acreage) {
        this.acreage = acreage;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(Set<Feedback> feedback) {
        this.feedback = feedback;
    }
}
