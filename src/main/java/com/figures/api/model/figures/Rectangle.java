package com.figures.api.model.figures;

import com.figures.api.model.types.FigureType;

public class Rectangle extends Figure {
    private double side1;
    private double side2;
    
    public Rectangle(double side1, double side2) {
        super(FigureType.RECTANGLE);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getArea() {
        return side1 * side2;
    }

    @Override
    public double getPerimeter() {
        return (side1 + side2) * 2;
    }
}

