package fr.epita.geometry.datamodel;

public class Triangle implements IShape {
    private Double base, sideB, sideC;
    private Double height;


    public Triangle(Double base, Double sideB, Double sideC, Double height) {
        this.base = base;
        this.sideB = sideB;
        this.sideC = sideC;
        this.height = height;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getSideB() {
        return sideB;
    }

    public void setSideB(Double sideB) {
        this.sideB = sideB;
    }

    public Double getSideC() {
        return sideC;
    }

    public void setSideC(Double sideC) {
        this.sideC = sideC;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getArea() {
        return base * this.height / 2;
    }

    @Override
    public Double getPerimeter() {
        return sideB + sideC + base;
    }
}
