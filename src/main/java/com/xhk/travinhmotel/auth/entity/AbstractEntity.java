package com.xhk.travinhmotel.auth.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.OffsetDateTime;

import static java.time.OffsetDateTime.now;


@MappedSuperclass
@Where(clause = "delete_flag = false")
public class AbstractEntity {

    @Basic(optional = false)
    @Column(name = "delete_flag")
    private boolean deleteFlag;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @PrePersist
    public void onPersist() {
        updatedAt = createdAt = now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = now();
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}


