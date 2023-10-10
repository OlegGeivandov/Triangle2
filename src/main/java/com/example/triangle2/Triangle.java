package com.example.triangle2;

public class Triangle {
    double sideA;
    double sideB;
    double sideC;
    double area;
    boolean isTriangle;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        isTriangle = checkIsTriangle();
        area = calculateArea();
    }

    boolean checkIsTriangle(){
        return  (sideA<=sideB+sideC&&sideB<=sideC+sideA&&sideC<=sideA+sideB);
    }

    double calculateP(){
        return (sideA+sideB+sideC)/2;
    }

    double calculateArea(){
        return  Math.sqrt(calculateP()*(calculateP()-sideA)*(calculateP()-sideB)*calculateP()-sideC);
    }
}
