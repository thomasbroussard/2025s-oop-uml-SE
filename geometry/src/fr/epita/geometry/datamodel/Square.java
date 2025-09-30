package fr.epita.geometry.datamodel;

public class Square implements IShape {
    Double side;

    public Double getSide() {
        return side;
    }

    public void setSide(Double side) {
        this.side = side;
    }

    public Square(Double side) {
        this.side = side;
    }

    @Override
    public Double getArea() {
        return this.side * this.side;
    }

    @Override
    public Double getPerimeter() {
        return this.side * 4;
    }
}
