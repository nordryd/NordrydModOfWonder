package com.nordryd.nmow.util;

import java.util.Random;

public class Randomizer {
    private static final Random RNG = new Random();

    public static boolean coinToss() {
        return RNG.nextBoolean();
    }

    public static boolean oneInThree(){
        return RNG.nextDouble() < 0.75;
    }
}
