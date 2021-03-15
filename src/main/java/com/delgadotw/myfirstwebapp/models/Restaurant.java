package com.delgadotw.myfirstwebapp.models;

import javax.persistence.*;

@Entity
@Table(name="RESTAURANT")
public class Restaurant
{
    @Id
    @Column(name = "RS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LOC_STATE")
    private String locState;
    @Column(name = "LOC_ZIP_CODE")
    private String locZipCode;
    @Column(name = "AVG_SCORE")
    private float avgScore;
    @Column(name = "FOOD_TYPE")
    private String foodType;
    @Column(name = "AMBIANCE")
    private String ambiance;
    @Column(name = "PRICE_LEVEL")
    private String priceLevel;

    public Restaurant() {
    }

    public Restaurant(long id, String name, String locState, String locZipCode, float avgScore, String foodType, String ambiance, String priceLevel) {
        this.id = id;
        this.name = name;
        this.locState = locState;
        this.locZipCode = locZipCode;
        this.avgScore = avgScore;
        this.foodType = foodType;
        this.ambiance = ambiance;
        this.priceLevel = priceLevel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocState() {
        return locState;
    }

    public void setLocState(String locState) {
        this.locState = locState;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    public String getLocZipCode() {
        return locZipCode;
    }

    public void setLocZipCode(String locZipCode) {
        this.locZipCode = locZipCode;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getAmbiance() {
        return ambiance;
    }

    public void setAmbiance(String ambiance) {
        this.ambiance = ambiance;
    }

    public String getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(String priceLevel) {
        this.priceLevel = priceLevel;
    }
}
