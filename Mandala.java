import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;
import java.util.Random;
import java.awt.Color;

public class Mandala {
    public void drawConcentricCircles(PainterAPI p, int radius, int gap, Random rand) {
        p.liftPen();
        p.turnLeft(90);
        p.backward(radius);
        p.turnRight(90);
        p.lowerPen();
        for (int i = 0; i < 4; i++) {
            int r = rand.nextInt(0, 256);
            int g = rand.nextInt(0, 256);
            int b = rand.nextInt(0, 256);
            Color color = new Color(r, g, b);
            p.setPenColor(color);
            p.circle(radius);
            p.liftPen();
            p.turnLeft(90);
            p.backward(gap);
            p.turnRight(90);
            p.lowerPen();
            radius += gap;
        }
    }

    public void drawConcentricSquares(PainterAPI p, int length, int gap, Random rand) {
        p.liftPen();
        p.backward(length / 2);
        p.turnLeft(90);
        p.backward(length / 2);
        p.turnRight(90);
        p.lowerPen();
        for (int i = 0; i < 3; i++) {
            int r = rand.nextInt(0, 256);
            int g = rand.nextInt(0, 256);
            int b = rand.nextInt(0, 256);
            Color color = new Color(r, g, b);
            p.setPenColor(color);
            for (int j = 0; j < 4; j++) {
                p.forward(length);
                p.turnLeft(90);
            }
            p.liftPen();
            p.backward(gap / 2);
            p.turnLeft(90);
            p.backward(gap / 2);
            p.turnRight(90);
            p.lowerPen();
            length += gap;
        }
    }

    public void drawBridge(PainterAPI p, int innerRadius, int outerRadius, Random rand) {
        double distant = Math.sqrt((outerRadius * outerRadius) + (innerRadius * innerRadius)
                - (2 * innerRadius * outerRadius * Math.cos(Math.toRadians(40))));
        int distance = (int) Math.round(distant);
        int turnTotal = 0;
        p.turnLeft(117);
        for (int i = 0; i < 18; i++) {
            int r = rand.nextInt(0, 256);
            int g = rand.nextInt(0, 256);
            int b = rand.nextInt(0, 256);
            Color color = new Color(r, g, b);
            p.setPenColor(Color.BLACK);

            p.turnLeft(130);
            p.forward(distance); // Draw bridge line
            p.turnRight(120);
            p.forward(distance); // Draw bridge line back to the inner circle
            turnTotal += 10;
        }
        p.turnRight(turnTotal);
    }

    public void drawSpiral(PainterAPI p, int radius, int degree, Random rand) {
        int totalTurned = 0;
        for (int i = 0; i < 54; i++) {
            int r = rand.nextInt(0, 256);
            int b = rand.nextInt(0, 256);
            Color color = new Color(r, 0, b);
            p.setPenColor(color);
            p.circle(radius);
            p.turnRight(degree);
            totalTurned += degree;

        }
        p.turnLeft(totalTurned);
    }

    public void drawSunburst(PainterAPI p, int length, Random rand) {
        int totalTurned = 0;

        p.liftPen();
        p.backward(length / 2);
        p.lowerPen();
        for (int i = 0; i < 108; i++) {
            int g = rand.nextInt(0, 256);
            int b = rand.nextInt(0, 256);
            Color color = new Color(0, g, b);
            p.setPenColor(color);
            p.forward(length);
            p.turnRight(193);
            totalTurned += 193;
        }
        p.turnLeft(totalTurned);

    }

    public void drawBeads(PainterAPI p, int innerRadius, int outerRadius, Random rand) {
        int midRadius = (outerRadius + innerRadius) / 2;
        int beadRadius = ((outerRadius - innerRadius) / 2);
        int numberOfBeads = 20;

        for (int i = 0; i < numberOfBeads; i++) {
            int r = rand.nextInt(0, 255);
            int g = rand.nextInt(0, 256);
            int b = rand.nextInt(0, 256);
            Color color = new Color(r, g, b);
            p.setPenColor(color);

            int angle = 360 / numberOfBeads;
            p.turnLeft(angle);
            p.liftPen();
            p.forward(midRadius - 3.5);
            p.lowerPen();
            p.startFill(color);
            p.circle(beadRadius);
            p.finishFill();
            p.liftPen();
            p.backward(midRadius - 3.5);
            p.lowerPen();

        }

    }

    public void drawTriangleFrame(PainterAPI p, int length, int radius) {

    }

    public void move(PainterAPI p, int x, int y) {
        p.liftPen();
        p.moveTo(x, y);
        p.lowerPen();
    }

    public static void main(String[] args) {
        CanvasAPI canvas = Graphics.createCanvas(1500, 1500, "Mandala");

        PainterAPI p = canvas.getPainter();
        Random rand = new Random();

        Mandala mandala1 = new Mandala();
        Mandala mandala2 = new Mandala();
        Mandala mandala3 = new Mandala();
        Mandala mandala4 = new Mandala();
        p.setSpeed(0); // Lower number means faster, zero means as fast as possible.

        mandala1.move(p, -375, 375);
        mandala1.drawSpiral(p, 70, 13, rand);
        mandala1.move(p, -375, 375);
        mandala1.drawConcentricCircles(p, 140, 40, rand);
        mandala1.move(p, -375, 375);
        mandala1.drawBeads(p, 140, 180, rand);
        mandala1.move(p, -375, 375);
        mandala1.move(p, -375, 375);
        mandala1.drawBeads(p, 220, 260, rand);

        mandala2.move(p, 375, 375);
        mandala2.drawSpiral(p, 50, 13, rand);
        mandala2.move(p, 375, 375);
        mandala2.drawConcentricCircles(p, 100, 30, rand);
        mandala2.move(p, 375, 375);
        mandala2.drawBeads(p, 100, 130, rand);
        mandala2.move(p, 375, 375);
        mandala2.drawBeads(p, 160, 190, rand);
        mandala2.drawSunburst(p, 285, rand);

        mandala3.move(p, -375, -375);
        mandala3.drawSunburst(p, 200, rand);
        mandala3.move(p, -375, -365);
        mandala3.drawConcentricSquares(p, 200, 30, rand);

        mandala4.move(p, 375, -375);
        mandala4.drawSunburst(p, 280, rand);
        mandala4.move(p, 375, -360);
        mandala4.drawConcentricSquares(p, 280, 40, rand);

    }
}
