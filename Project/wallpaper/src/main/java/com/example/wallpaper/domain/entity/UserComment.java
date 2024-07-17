package com.example.wallpaper.domain.entity;

import com.example.wallpaper.common.Constants;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_comment")
public class UserComment {

    private int mark;
    private User user;
    private Date date;
    private Order order;
    private String comment;

    public UserComment(
            int mark,
            User user,
            Date date,
            Order order,
            String comment
    ) {
        if (mark > Constants.MAX_MARK) throw new IllegalArgumentException("Mark must be lower " + Constants.MAX_MARK);
        if (mark < 0) throw new IllegalArgumentException("Mark must be upper 0");

        this.mark = mark;
        this.user = user;
        this.date = date;
        this.order = order;
        this.comment = comment;
    }

    protected UserComment() {
    }

    @EmbeddedId
    @OneToOne(optional = false)
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @EmbeddedId
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "mark", nullable = false)
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Column(name = "comment", length = 500)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
