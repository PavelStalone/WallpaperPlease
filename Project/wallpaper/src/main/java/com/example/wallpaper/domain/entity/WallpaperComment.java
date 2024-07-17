package com.example.wallpaper.domain.entity;

import com.example.wallpaper.common.Constants;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "wallpaper_comment")
public class WallpaperComment extends BaseEntity {

    private int mark;
    private User user;
    private Date date;
    private String comment;
    private Wallpaper wallpaper;

    public WallpaperComment(
            int mark,
            User user,
            Date date,
            String comment,
            Wallpaper wallpaper
    ) {
        if (mark > Constants.MAX_MARK) throw new IllegalArgumentException("Mark must be lower " + Constants.MAX_MARK);
        if (mark < 0) throw new IllegalArgumentException("Mark must be upper 0");

        this.mark = mark;
        this.user = user;
        this.date = date;
        this.comment = comment;
        this.wallpaper = wallpaper;
    }

    protected WallpaperComment() {
    }

    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(optional = false)
    @PrimaryKeyJoinColumn(name = "wallpaper_id", referencedColumnName = "id")
    public Wallpaper getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(Wallpaper wallpaper) {
        this.wallpaper = wallpaper;
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
