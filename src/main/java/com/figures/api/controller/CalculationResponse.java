package com.figures.api.controller;

import com.figures.api.model.types.CalculationType;

public class CalculationResponse {
    private CalculationType calculationType;
    private Double result;

    public CalculationResponse(CalculationType calculationType, Double result) {
        this.calculationType = calculationType;
        this.result = result;
    }

    public CalculationType getCalculationType() {
        return calculationType;
    }

    public Double getResult() {
        return result;
    }
}

