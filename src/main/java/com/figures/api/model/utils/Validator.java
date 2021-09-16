package com.figures.api.model.utils;

public class Validator {
    public static Boolean checkGreaterZero(Double...args) {
        Boolean accumulator = true;

        for(Double d: args){
            accumulator = (d > 0) && accumulator;
        }

        return accumulator;
    }
}

