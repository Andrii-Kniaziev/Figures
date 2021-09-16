package com.figures.api.controller;

import com.figures.api.model.types.CalculationType;

public class CalculationResponse extends CalculationResult {
    private CalculationType calculationType;
    private double result;

    public CalculationResponse(CalculationType calculationType, double result) {
        this.calculationType = calculationType;
        this.result = result;
    }

    public CalculationType getCalculationType() {
        return calculationType;
    }

    public double getResult() {
        return result;
    }
}

