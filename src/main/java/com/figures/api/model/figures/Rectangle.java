package com.figures.api.model.figures;

import com.figures.api.model.types.FigureType;

public class Rectangle extends Figure {
    private Double side1;
    private Double side2;
    
    public Rectangle(Double side1, Double side2) {
        super(FigureType.RECTANGLE);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public Double calculateArea() {
        return side1 * side2;
    }

    @Override
    public Double calculatePerimetr() {
        return (side1 + side2) * 2;
    }
}

