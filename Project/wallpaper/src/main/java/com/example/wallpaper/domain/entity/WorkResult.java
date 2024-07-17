package com.example.wallpaper.domain.entity;

import com.example.wallpaper.common.Constants;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "work_result")
public class WorkResult {

    private int mark;
    private Date date;
    private Order order;
    private String comment;
    private Developer developer;

    public WorkResult(
            int mark,
            Date date,
            Order order,
            String comment,
            Developer developer
    ) {
        if (mark > Constants.MAX_MARK) throw new IllegalArgumentException("Mark must be lower " + Constants.MAX_MARK);
        if (mark < 0) throw new IllegalArgumentException("Mark must be upper 0");

        this.mark = mark;
        this.date = date;
        this.order = order;
        this.comment = comment;
        this.developer = developer;
    }

    protected WorkResult() {
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
    @JoinColumn(name = "developer_id", referencedColumnName = "id", nullable = false)
    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
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
