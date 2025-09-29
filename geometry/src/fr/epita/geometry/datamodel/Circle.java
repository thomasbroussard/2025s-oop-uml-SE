package fr.epita.geometry.datamodel;

public class Circle {

    private Double radius;

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Circle(Double radius) {
        this.radius = radius;
    }

    public double getArea(){
       return Math.pow(this.radius, 2) * Math.PI;
    }

    public double getPerimeter() {
        return  2 * Math.PI * radius;
    }

}
