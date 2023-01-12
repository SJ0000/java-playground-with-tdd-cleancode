package coordinate.domain;

import java.util.List;

public class Triangle extends AbstractShape{


    public Triangle(List<Point> points) {
        super(points);
    }

    public double getArea(){
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);
        double area = heronsFormula(p1.distance(p2), p1.distance(p3), p2.distance(p3));

        return Math.round(area*100)/100;
    }

    private double heronsFormula(double a, double b, double c){
        double s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    @Override
    public String getReport() {
        return "삼각형 넓이는 " + getArea();
    }
}
