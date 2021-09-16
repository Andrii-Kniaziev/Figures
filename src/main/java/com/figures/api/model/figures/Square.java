package com.figures.api.model.figures;

import com.figures.api.model.types.FigureType;

public class Square extends Figure {
    private Double a;
    
    public Square(Double a) {
        super(FigureType.SQUARE);
        this.a = a;
    }
    
    @Override
    public Double calculateArea() {
        System.out.println("Square area");
        return Math.pow(a, 2);
    }

    @Override
    public Double calculatePerimetr() {
        return a * 4;
    }
}
