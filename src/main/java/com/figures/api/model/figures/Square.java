package com.figures.api.model.figures;

import com.figures.api.model.types.FigureType;

public class Square extends Figure {
    private double a;
    
    public Square(double a) {
        super(FigureType.SQUARE);
        this.a = a;
    }
    
    @Override
    public double getArea() {
        return Math.pow(a, 2);
    }

    @Override
    public double getPerimeter() {
        return a * 4;
    }
}
