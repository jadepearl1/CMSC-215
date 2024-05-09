public class Time {
    
    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 5.5);
        System.out.println("The area of the circle is: " + c1.getArea());
        System.out.println("The perimeter of the circle is: " + c1.getPerimeter());
    
        if(c1.contains(3, 3))
            System.out.println("The point (3,3) is inside circle c1.");
        else
            System.out.println("The point (3,3) is not inside circle c1.");
            
        if(c1.contains(new Circle2D(4, 5, 10.5)))
            System.out.println("The new circle is inside c1.");
        else
            System.out.println("The new circle is not inside c1.");
        
        if(c1.overlaps(new Circle2D(3, 5, 2.3)))
            System.out.println("The new circle overlaps c1.");
        else
            System.out.println("The new circle does not overlap c1.");
    }    
}
class Circle2D {
    //data values
    private double x;
    private double y;
    private double radius;
    
    public Circle2D() {
        this.x = 0.0;
        this.y = 0.0;
        this.radius = 1.0;
    }
    
    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double getArea() {
        return (radius * radius * 3.14159);
    }
    //perimeter is the same as the circumference of a circle
    public double getPerimeter() {
        return (2.0 * 3.14159 * radius);
    }
    //returns true if designated point is inside a given circle
    public boolean contains(double x, double y) {
        if(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2) == this.radius
         || Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2)) < this.radius)
            return true;
        else
            return false;
    }
    //returns true if a designated circle is inside the circle in question
    public boolean contains(Circle2D circle) {
        if(Math.sqrt(Math.pow((this.x - circle.x), 2) + Math.pow((this.y - circle.y), 2)) + circle.radius <= this.radius)
            return true;
        else
            return false;
    }
    //returns true if a given circle overlaps another circle
    public boolean overlaps(Circle2D circle) {
        if(Math.sqrt(Math.pow((this.x - circle.x), 2) + Math.pow((this.y - circle.y), 2)) <= (this.radius - circle.radius)
        || Math.sqrt(Math.pow((this.x - circle.x), 2) + Math.pow((this.y - circle.y), 2)) <= (circle.radius - this.radius)
        || Math.sqrt(Math.pow((this.x - circle.x), 2) + Math.pow((this.y - circle.y), 2)) < (this.radius + circle.radius)
        || Math.sqrt(Math.pow((this.x - circle.x), 2) + Math.pow((this.y - circle.y), 2)) == (this.radius + circle.radius))
            return true;
        else
            return false;
    }
}