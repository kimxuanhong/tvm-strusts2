package com.xhk.travinhmotel.auth.entity;


import javax.persistence.*;

@Entity
public class Contact extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String content;

    private String reply;

    @ManyToOne
    @JoinColumn(name = "motel_id")
    private Motel motel;

    @ManyToOne
    private Customer createBy;

    @ManyToOne
    private Staff updateBy;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Motel getMotel() {
        return motel;
    }

    public void setMotel(Motel motel) {
        this.motel = motel;
    }

    public Customer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Customer createBy) {
        this.createBy = createBy;
    }

    public Staff getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Staff updateBy) {
        this.updateBy = updateBy;
    }
}
