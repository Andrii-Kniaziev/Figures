package com.figures.api.controller;

import com.figures.api.model.figures.Circle;
import com.figures.api.model.figures.Figure;
import com.figures.api.model.figures.Rectangle;
import com.figures.api.model.figures.Square;
import com.figures.api.model.figures.Triangle;
import com.figures.api.model.types.CalculationType;
import com.figures.api.model.utils.Validator;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@RestController
@CrossOrigin
@Validated
public class FigureCalculationController {

    @GetMapping("/square/{calculationType}")
    public ResponseEntity<CalculationResult> squareRestService(@PathVariable("calculationType") CalculationType calculationType,
            @RequestParam("a") double a) {

        if (Validator.checkGreaterZero(a)) {
            return ResponseEntity.ok().body(createCalculationResponse(new Square(a), calculationType));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new CalculationError("Side of square must be greater than zero"));
        }
    }

    @GetMapping("/circle/{calculationType}")
    public ResponseEntity<CalculationResult> circleRestService(@PathVariable("calculationType") CalculationType calculationType,
            @RequestParam("r") double radius) {

        if (Validator.checkGreaterZero(radius)) {
            return ResponseEntity.ok().body(createCalculationResponse(new Circle(radius), calculationType));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new CalculationError("Radius of circle must be greater than zero"));
        }
    }

    @GetMapping("/rectangle/{calculationType}")
    public ResponseEntity<CalculationResult> rectangleRestService(@PathVariable("calculationType") CalculationType calculationType,
            @RequestParam("a") double a, @RequestParam("b") double b) {

        if (Validator.checkGreaterZero(a, b)) {
            return ResponseEntity.ok().body(createCalculationResponse(new Rectangle(a, b), calculationType));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new CalculationError("Sides of rectangle must be greater than zero"));
        }
    }

    @GetMapping("/triangle/{calculationType}")
    public ResponseEntity<CalculationResult> triangleRestService(@PathVariable("calculationType") CalculationType calculationType,
            @RequestParam("a") double a, @RequestParam("b") double b, @RequestParam("c") double c) {

        if (Validator.checkGreaterZero(a, b, c)) {
            return ResponseEntity.ok().body(createCalculationResponse(new Triangle(a, b, c), calculationType));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new CalculationError("Sides of triangle must be greater than zero"));
        }
    }

    private CalculationResponse createCalculationResponse(Figure figure, CalculationType calculationType) {
        double calculationResult = calculationType == CalculationType.AREA ? figure.getArea()
                : figure.getPerimetr();
        return new CalculationResponse(calculationType, calculationResult);
    }
}

