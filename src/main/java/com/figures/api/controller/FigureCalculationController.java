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
    public ResponseEntity<?> squareRestService(@PathVariable("calculationType") CalculationType calculationType,
            @RequestParam("a") Double a) {

        if (Validator.checkGreaterZero(a)) {
            return createResponse(new Square(a), calculationType);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new CalculationError("Side of square must be greater than zero"));
        }
    }

    @GetMapping("/circle/{calculationType}")
    public ResponseEntity<?> circleRestService(@PathVariable("calculationType") CalculationType calculationType,
            @RequestParam("a") Double radius) {

        if (Validator.checkGreaterZero(radius)) {
            return createResponse(new Circle(radius), calculationType);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new CalculationError("Radius of circle must be greater than zero"));
        }
    }

    @GetMapping("/rectangle/{calculationType}")
    public ResponseEntity<?> rectangleRestService(
            @PathVariable("calculationType") CalculationType calculationType, @RequestParam("a") Double a,
            @RequestParam("b") Double b) {

        if (Validator.checkGreaterZero(a,b)) {        
            return createResponse(new Rectangle(a, b), calculationType);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new CalculationError("Sides of rectangle must be greater than zero"));
        }
    }

    @GetMapping("/triangle/{calculationType}")
    public ResponseEntity<?> triangleRestService(
            @PathVariable("calculationType") CalculationType calculationType, @RequestParam("a") Double a,
            @RequestParam("b") Double b, @RequestParam("c") Double c) {
        
        if (Validator.checkGreaterZero(a, b, c)) {
            return createResponse(new Triangle(a, b, c), calculationType);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new CalculationError("Sides of triangle must be greater than zero"));
        }
    }

    public ResponseEntity<CalculationResponse> createResponse(Figure figure, CalculationType calculationType) {
        CalculationResponse response = null;

        if (calculationType == CalculationType.AREA) {
            response = new CalculationResponse(calculationType, figure.calculateArea());
            return ResponseEntity.ok(response);
        } else {
            response = new CalculationResponse(calculationType, figure.calculatePerimetr());
            return ResponseEntity.ok(response);
        }
    }
}

