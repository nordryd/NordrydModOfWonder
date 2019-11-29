package com.nordryd.nmow.items.builders;

public class FoodProperties {
    private int amount;
    private float saturation;
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
