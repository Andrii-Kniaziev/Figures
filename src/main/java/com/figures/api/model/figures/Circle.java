package com.figures.api.model.figures;

import com.figures.api.model.types.FigureType;

public class Circle extends Figure {
    private Double radius;
    
    public Circle(Double radius) {
        super(FigureType.CIRCLE);
        this.radius = radius;
    }
    
    @Override
    public Double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public Double calculatePerimetr() {
        return 2 * Math.PI * radius;
    }
}

