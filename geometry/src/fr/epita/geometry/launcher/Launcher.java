package fr.epita.geometry.launcher;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.IShape;
import fr.epita.geometry.datamodel.Square;
import fr.epita.geometry.datamodel.Triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Launcher {

    public static void main(String[] args) {
        IShape c1 = new Circle(3d);

        IShape t1 = new Triangle(3d, 3d, 3d, 4d);

        IShape s1 = new Square(3d);

        s1.getArea();

        List<IShape> list = new ArrayList<>();

        double totalArea = 0.0;

        for (IShape s : list) {
            totalArea = totalArea + s.getArea();
        }


        System.out.println("total area: " + totalArea);
    }
}
