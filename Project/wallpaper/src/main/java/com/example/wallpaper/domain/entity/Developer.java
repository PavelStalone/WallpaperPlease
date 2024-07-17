package com.example.wallpaper.domain.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "developers")
public class Developer extends BaseEntity {

    private User user;
    private Date date;
    private boolean wantWork;
    private Set<WorkResult> workResults;
    private Set<ActiveOrder> activeOrders;

    public Developer(
            User user,
            Date date,
            boolean wantWork
    ) {
        this.user = user;
        this.date = date;
        this.wantWork = wantWork;
    }

    protected Developer() {
    }

    @OneToMany(mappedBy = "developer", targetEntity = ActiveOrder.class, fetch = FetchType.LAZY)
    public Set<ActiveOrder> getActiveOrders() {
        return activeOrders;
    }

    public void setActiveOrders(Set<ActiveOrder> activeOrders) {
        this.activeOrders = activeOrders;
    }

    @OneToMany(mappedBy = "developer", targetEntity = WorkResult.class, fetch = FetchType.LAZY)
    public Set<WorkResult> getWorkResults() {
        return workResults;
    }

    public void setWorkResults(Set<WorkResult> workResults) {
        this.workResults = workResults;
    }

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "is_want_work", nullable = false)
    public boolean isWantWork() {
        return wantWork;
    }

    public void setWantWork(boolean wantWork) {
        this.wantWork = wantWork;
    }
}
