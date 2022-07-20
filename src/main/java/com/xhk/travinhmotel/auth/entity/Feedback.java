package com.xhk.travinhmotel.auth.entity;

import javax.persistence.*;


@Entity
public class Feedback extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private int rating;

    @ManyToOne
    @JoinColumn(name = "motel_id")
    private Motel motel;

    @ManyToOne
    private Customer createBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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
}
