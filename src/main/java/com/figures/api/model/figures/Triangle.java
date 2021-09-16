package com.figures.api.model.figures;

import com.figures.api.model.types.FigureType;

public class Triangle extends Figure {
    private double side1;
    private double side2;
    private double side3;
    
    public Triangle(double side1, double side2, double side3) {
        super(FigureType.TRIANGLE);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculateArea() {
        double halfPerim = calculatePerimetr() / 2;
        return Math.sqrt(halfPerim * (halfPerim - side1) * (halfPerim - side2) * (halfPerim - side3));
    }

    @Override
    public double calculatePerimetr() {
        return side1 + side2 + side3;
    }
    
}
