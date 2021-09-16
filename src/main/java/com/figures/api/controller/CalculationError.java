package com.figures.api.controller;

public class CalculationError extends CalculationResult {
    private String errorMessage;

    public CalculationError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

