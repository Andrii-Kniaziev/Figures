package com.figures.api.model.figures;

import com.figures.api.model.types.FigureType;

public abstract class Figure implements Calculable {
    public FigureType figureType;

    public Figure(FigureType figureType) {
        this.figureType = figureType;
    }
}

