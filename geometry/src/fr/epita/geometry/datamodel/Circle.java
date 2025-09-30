package fr.epita.geometry.datamodel;

public class Circle implements IShape {

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

    public Double getArea(){
       return Math.pow(this.radius, 2) * Math.PI;
    }

    public Double getPerimeter() {
        return  2 * Math.PI * radius;
    }

    public void saveToDB(){

    }

}
