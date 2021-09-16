package com.figures.api.model.figures;

import com.figures.api.model.types.FigureType;

public class Circle extends Figure {
    private double radius;
    
    public Circle(double radius) {
        super(FigureType.CIRCLE);
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

