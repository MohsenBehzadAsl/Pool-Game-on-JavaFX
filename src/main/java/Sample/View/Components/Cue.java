package Sample.View.Components;

import Sample.View.Main2;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Thomas on 2017-06-02.
 *
 * Class is a representation of a pool cue. Handles positioning, mechanics
 * and rendering
 *
 * <p> Implements MouseListener to listen for mouse button presses/releases</p>
 */
public class Cue extends Rectangle {

    Rectangle rectangle=new Rectangle();
    // Dimensions of the cue
    private static final int CUE_WIDTH = 400;
    private static final int CUE_HEIGHT = 10;

    // X and Y coordinates for the cue
    private int xPos;
    private int yPos;

    // Value of how far the cue is drawn back
    private int drawBack_xPos;

    // Flag to determine if cue is drawn back
    private boolean drawnBack;

    //
    private boolean ballsMoving = false;

    private static boolean MOUSE_HELD_DOWN;

    // Value between 0 and 360
    private static int angle = 180;

    double power = 0;

    private Color color = Color.BLACK;

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public Cue(int x, int y) {
        super(x-400,y,800,10);
        xPos=x;
        yPos=y;
        MOUSE_HELD_DOWN = false;
        drawnBack = false;
        drawBack_xPos = 0;
    }
    public void updateCue(int x,int y){
        xPos=x;
        yPos=y;

    }


}
