package com.nordryd.nmow.items.properties;

public class FoodProperties {
    private int amount = 2;
    private float saturation = 0.6f;
    private boolean isWolfFood = false;

    public int amount() {
        return amount;
    }

    public FoodProperties amount(final int amount) {
        this.amount = amount;
        return this;
    }

    public float saturation() {
        return saturation;
    }

    public FoodProperties saturation(final float saturation) {
        this.saturation = saturation;
        return this;
    }

    public boolean isWolfFood() {
        return isWolfFood;
    }

    public FoodProperties makeWolfFood() {
        this.isWolfFood = true;
        return this;
    }
}
