package com.figures.api.model.figures;

import com.figures.api.model.types.FigureType;

public class Square extends Figure {
    private double a;
    
    public Square(double a) {
        super(FigureType.SQUARE);
        this.a = a;
    }
    
    @Override
    public double calculateArea() {
        return Math.pow(a, 2);
    }

    @Override
    public double calculatePerimetr() {
        return a * 4;
    }
}
