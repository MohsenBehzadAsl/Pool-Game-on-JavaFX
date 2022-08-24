package Sample.View.Components;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
public class Goals extends Rectangle {
    private static Goals instance;
    private double friction;

    public double getFriction() {
        return friction;
    }

    public static Goals getInstance(){
        if (instance==null){
            instance=new Goals();
        }
        return instance;
    }
    public Goals() {
        super(150,50,1110,640);
        this.setFill(Color.rgb(21,122,3,1));
    }


    public Arc[] getPockets() {
        Arc arcs[] = new Arc[6];
        int x = 150;
        int y = 50;
        int hNum = 0;
        for (int i = 0; i < 6; i++) {
            if (i == 3) {
                y += 640;
                hNum = 0;
            }
            Circle circle = new Circle();
            circle.setCenterX(x+hNum*(1110/2));
            circle.setCenterY(y);
            circle.setRadius(35);
            circle.setFill(Color.rgb(12,61,2,1));
            Arc arc = new Arc();
            arc.setCenterX(x+hNum*(1110/2));
            arc.setCenterY(y);
            arc.setRadiusX(45);
            arc.setRadiusY(45);

            if (i==1){
                arc.setStartAngle(-180.0f);
                arc.setLength(180.0f);
            }else if (i==4){
                arc.setStartAngle(0.0f);
                arc.setLength(180.0f);
            }else if (i==0){
                arc.setType(ArcType.ROUND);
                arc.setStartAngle(0.0f);
                arc.setLength(-90.0f);
            }else if (i==3){
                arc.setType(ArcType.ROUND);
                arc.setStartAngle(0.0f);
                arc.setLength(90.0f);
            }else if (i==2){
                arc.setType(ArcType.ROUND);
                arc.setStartAngle(-180.0f);
                arc.setLength(90.0f);
            }else if (i==5){
                arc.setType(ArcType.ROUND);
                arc.setStartAngle(-180.0f);
                arc.setLength(-90.0f);
            }

            arc.setFill(Color.rgb(12,61,2,1));

            arcs[i]=arc;
            //circles[i] = new Circle(x+hNum*(1020/2), y, 35, Color.rgb(12,61,2,1));

            hNum++;
        }
        return arcs;
    }


    public Arc[] getPockets2() {
        Arc arcs[] = new Arc[6];
        int x = 150;
        int y = 50;
        int hNum = 0;
        for (int i = 0; i < 6; i++) {
            if (i == 3) {
                y += 640;
                hNum = 0;
            }
            Circle circle = new Circle();
            circle.setCenterX(x+hNum*(1110/2));
            circle.setCenterY(y);
            circle.setRadius(35);
            circle.setFill(Color.rgb(239,12,12,1));
            Arc arc = new Arc();
            arc.setCenterX(x+hNum*(1110/2));
            arc.setCenterY(y);
            arc.setRadiusX(20);
            arc.setRadiusY(20);

            if (i==1){
                arc.setStartAngle(-180.0f);
                arc.setLength(180.0f);
            }else if (i==4){
                arc.setStartAngle(0.0f);
                arc.setLength(180.0f);
            }else if (i==0){
                arc.setType(ArcType.ROUND);
                arc.setStartAngle(0.0f);
                arc.setLength(-90.0f);
            }else if (i==3){
                arc.setType(ArcType.ROUND);
                arc.setStartAngle(0.0f);
                arc.setLength(90.0f);
            }else if (i==2){
                arc.setType(ArcType.ROUND);
                arc.setStartAngle(-180.0f);
                arc.setLength(90.0f);
            }else if (i==5){
                arc.setType(ArcType.ROUND);
                arc.setStartAngle(-180.0f);
                arc.setLength(-90.0f);
            }

            arc.setFill(Color.rgb(239,12,12,1));

            arcs[i]=arc;
            //circles[i] = new Circle(x+hNum*(1020/2), y, 35, Color.rgb(12,61,2,1));

            hNum++;
        }
        return arcs;
    }
}
