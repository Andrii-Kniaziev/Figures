package com.figures.api.model.utils;

public class Validator {
    public static boolean checkGreaterZero(double...args) {
        boolean accumulator = true;

        for(double d: args){
            accumulator = (d > 0) && accumulator;
        }

        return accumulator;
    }
}

