package Sample.View.Components;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Ball  extends Circle{
    private double x;
    private double y;
    private double dx=0;
    private double dy=0;

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }


    private double radius = 25;
    private double mass = 1;
    private Color color;
    private boolean solid;
    private int ballNumber;
    //Sound ballHit = new Sound();
    Boolean pocketed = false;
    private Circle ball=new Circle();

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    private String colour;

    private int theta = 225;

    public int getTheta() {
        return theta;
    }



    double slowDownSpeed = 0.02;// Double sets the slow down speed for each of
    // the balls

    int distance = 100;// this sets the boundaries for the balls to bounce
    private double xVelocity;
    private double yVelocity;
    // off the walls inside of the playing area and not the JFrame.

    // Constructor
    public Ball(double x, double y, double radius, double mass,  Color ballColor, boolean solid,
                int ballNumber) {
        super(x,y,radius);

        setMass(mass);
        this.setFill(ballColor);
        this.solid = solid;
        this.ball=ball;
        this.x=x;
        this.y=y;
        this.ballNumber=ballNumber;
        //Label label = new Label("8");
        //        this.setFill(Color.GOLD);
        //        this.setStroke(Color.GRAY);
        //        this.radiusProperty().bind(label.widthProperty());
        //        pane.getChildren().addAll(this, label);
    }

    // Getters and Setters


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }




    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setColor(Color ballColor) {
        this.color = ballColor;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public boolean getSolid() {
        return solid;
    }

    public void setBallNumber(int ballNumber) {
        this.ballNumber = ballNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }



    public void move(double dx, double dy, ArrayList<Ball> poolBalls,double thata,double speed){
        this.setCenterX(this.getCenterX()+dx);
        this.setCenterY(this.getCenterY()+dy);
    }

    public void move(){
        this.setCenterX(this.getCenterX()+dx);
        this.setCenterY(this.getCenterY()+dy);


        if (this.hitToptWall() || this.hitBottomWall()) {
            dy*=(-1);
        }
        if (this.hitLeftBall() || this.hitRightWall()) {
            dx*=(-1);
        }
    }

    public boolean hitRightWall(){
        return this.getCenterX()+this.getRadius()>=1260;
    }
    public boolean hitLeftBall(){
        return this.getCenterX()-this.getRadius()<=150;
    }
    public boolean hitToptWall(){
        return this.getCenterY()-this.getRadius()<=50;
    }
    public boolean hitBottomWall(){
        return this.getCenterY()+this.getRadius()>=690;
    }


    public boolean hasCollision(Ball block) {
        return block.getBoundsInParent().intersects(this.getLayoutBounds());
    }
}
