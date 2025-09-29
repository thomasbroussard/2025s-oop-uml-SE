package fr.epita.geometry.launcher;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Triangle;

public class Launcher {

    public static void main(String[] args) {
        Circle c1 = new Circle(3d);

        Triangle t1 = new Triangle(3d, 3d, 3d, 4d);

        double totalArea = c1.getArea();
        totalArea = totalArea + t1.getArea();

        System.out.println("total area: " + totalArea);
    }
}
