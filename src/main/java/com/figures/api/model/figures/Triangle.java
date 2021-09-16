package com.figures.api.model.figures;

import com.figures.api.model.types.FigureType;

public class Triangle extends Figure {
    private Double side1;
    private Double side2;
    private Double side3;
    
    public Triangle(Double side1, Double side2, Double side3) {
        super(FigureType.TRIANGLE);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public Double calculateArea() {
        Double halfPerim = calculatePerimetr() / 2;
        return Math.sqrt(halfPerim * (halfPerim - side1) * (halfPerim - side2) * (halfPerim - side3));
    }

    @Override
    public Double calculatePerimetr() {
        return side1 + side2 + side3;
    }
    
}
