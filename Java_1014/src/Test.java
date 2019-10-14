public class Test {
    public static void main(String[] args) {
        Shape shape1 = new Flower();
        Shape shape2 = new Rect();
        Shape shape3 = new Cycle();
        drawShape(shape1);
        drawShape(shape2);
        drawShape(shape3);

    }
    public static void drawShape(Shape shape) {
        shape.Draw();
    }
}
