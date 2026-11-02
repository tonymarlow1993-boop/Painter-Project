import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;

public class Mandala {
    public void drawConcentricCircles(PainterAPI painter, int radius, int gap) {

    }
    public void drawBridge(PainterAPI painter, int width) {

    }
    public void drawSpiral(PainterAPI painter, int radius, int degree) {

    }
    public void drawSquareFrame(PainterAPI painter, int length, int radius){

    }
    public void drawBeads(PainterAPI painter, int gap, int radius){

    }
    public void drawTriangleFrame(PainterAPI painter, int length, int radius){

    }
    public static void main(String[] args) {
        CanvasAPI canvas = Graphics.createCanvas(800, 600, "My First Drawing");

        PainterAPI painter = canvas.getPainter();
        painter.setSpeed(0); // Lower number means faster, zero means as fast as possible.
        for (int i = 0; i < 54; i++){

            painter.circle(40);
            painter.turnRight(13);


        }

        

    }
}
