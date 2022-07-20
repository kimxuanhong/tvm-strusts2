package com.xhk.travinhmotel.auth.entity;

import javax.persistence.*;

@Entity
public class Staff extends AbstractEntity {
    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Account account;

    private String salePhone;

    @ManyToOne
    @JoinColumn(name = "permission_id")
    private StaffPermission permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getSalePhone() {
        return salePhone;
    }

    public void setSalePhone(String salePhone) {
        this.salePhone = salePhone;
    }

    public StaffPermission getPermission() {
        return permission;
    }

    public void setPermission(StaffPermission permission) {
        this.permission = permission;
    }
}
