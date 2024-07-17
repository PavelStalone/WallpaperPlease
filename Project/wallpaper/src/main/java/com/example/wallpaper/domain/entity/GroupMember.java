package com.example.wallpaper.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "group_members")
public class GroupMember {

    private int rank;
    private Group group;
    private Developer developer;

    public GroupMember(
            int rank,
            Group group,
            Developer developer
    ) {
        this.rank = rank;
        this.group = group;
        this.developer = developer;
    }

    protected GroupMember() {
    }

    @EmbeddedId
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @EmbeddedId
    @OneToOne
    @JoinColumn(name = "developer_id", referencedColumnName = "id", nullable = false)
    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    @Column(name = "rank", nullable = false)
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
