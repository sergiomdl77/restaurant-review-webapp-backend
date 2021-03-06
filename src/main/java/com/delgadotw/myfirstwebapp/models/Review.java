package com.delgadotw.myfirstwebapp.models;

import javax.persistence.*;
import java.lang.String;

@Entity
@Table(name = "REVIEW")
public class Review
{
    @Id
    @Column(name = "RV_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rvId;
    @Column(name = "RS_ID")
    private long restaurantId;
    @Column(name = "M_ID")
    private String memberId;
    @Column(name = "RV_DATE")
    private String rvDate;
    @Column(name = "COMMENT")
    private String comment;
    @Column(name = "SCORE")
    private int score;

    public Review() {
    }

    // The generated Id (rvId) must not be part of this constructor, because it won't be passed as
    // an argument since it is automatically generated.
    public Review(long restaurantId, String memberId, String rvDate, String comment, int score) {
        this.restaurantId = restaurantId;
        this.memberId = memberId;
        this.rvDate = rvDate;
        this.comment = comment;
        this.score = score;
    }

    public long getRvId() {
        return rvId;
    }

    public void setRvId(long rvId) {
        this.rvId = rvId;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getRvDate() {
        return rvDate;
    }

    public void setRvDate(String rvDate) {
        this.rvDate = rvDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}



