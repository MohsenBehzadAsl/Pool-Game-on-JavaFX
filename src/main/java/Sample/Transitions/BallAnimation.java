package Sample.Transitions;


import Sample.View.Components.Ball;

import Sample.View.Components.Cue;

import Sample.View.Main;
import Sample.View.Main2;
import javafx.animation.Transition;
import javafx.util.Duration;

import java.util.ArrayList;


public class BallAnimation extends Transition {
    private ArrayList<Ball> ball;
    private Cue cue;
    public static int kkk=970;
    public static int t=0;

    public BallAnimation(ArrayList<Ball> ball, Cue cue) {
        this.ball = ball;
        this.cue=cue;
        this.setCycleDuration(Duration.millis(100));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        // v is between 0 and 1
        for (int i=0;i<11;i++) {
            ball.get(i).move();
            if (ball.get(i).getDx() < 0) {
                ball.get(i).setDx(ball.get(i).getDx() + 0.01);
                if (ball.get(i).getDx() > 0)
                    ball.get(i).setDx(0);
            } else if (ball.get(i).getDx() > 0) {
                ball.get(i).setDx(ball.get(i).getDx() - 0.01);
                if (ball.get(i).getDx() < 0)
                    ball.get(i).setDx(0);
            }
            if (ball.get(i).getDy() < 0) {
                ball.get(i).setDy(ball.get(i).getDy() + 0.01);
                if (ball.get(i).getDy() > 0)
                    ball.get(i).setDy(0);
            } else if (ball.get(i).getDy() > 0) {
                ball.get(i).setDy(ball.get(i).getDy() - 0.01);
                if (ball.get(i).getDy() < 0)
                    ball.get(i).setDy(0);
            }

        }


        for (int i = 0; i < 11; i++) {
            for (int j = i + 1; j < 11; j++) {
                ballCollision(ball.get(i), ball.get(j));
            }
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 6; j++) {
                if (ball.get(i).getLayoutBounds().intersects(Main2.getPockets2()[j].getLayoutBounds())){
                    ball.get(i).setCenterX(kkk);ball.get(i).setCenterY(759);ball.get(i).setDx(0);ball.get(i).setDy(0);ball.get(i).setRadius(20);
                    kkk+=47;
                    if (ball.get(i).getBallNumber()==8) {
                        Main2.scoreNum = String.valueOf(Integer.parseInt(Main2.scoreNum) + ball.get(i).getBallNumber() * 4);
                        Main2.score.setText("Score: " + Main2.scoreNum);
                    }else {
                        Main2.scoreNum = String.valueOf(Integer.parseInt(Main2.scoreNum) + ball.get(i).getBallNumber() * 2);
                        Main2.score.setText("Score: " + Main2.scoreNum);
                    }
                    if (i==0){
                        for (int p=0;p<11;p++) {
                            ball.get(p).setDx(0);ball.get(p).setDy(0);
                        }
                        Main2.finishN();
                    }
                    t++;
                    if (t==10)
                    Main2.finishP();
                }
            }
        }

        isMove();
    }



    public  void isMove(){
        for (int i=0;i<11;i++) {
            if (ball.get(i).getDx()==0 && ball.get(i).getDy()==0){

            }else{
                return;
            }
        }

        if (!Main2.finished) {
            Main2.really=true;
            cue.setVisible(true);
            cue.setX(ball.get(0).getCenterX() - 400);
            cue.setY(ball.get(0).getCenterY() - 2);
            cue.updateCue((int) ball.get(0).getCenterY() - 400, (int) ball.get(0).getCenterY() - 2);
        }
    }
    public static void ballCollision(Ball ball1,Ball ball2) {
        if (true) {
            double TxVector;
            double ell = 1;
            double TyVector;
            double d = Math.sqrt((ball2.getCenterX() - ball1.getCenterX()) * (ball2.getCenterX() - ball1.getCenterX()) + (ball1.getCenterY() - ball2.getCenterY()) * (ball1.getCenterY() - ball2.getCenterY()));
            if (d <= 2 * ball1.getRadius()) {
                double Dbg = (2 * ball1.getRadius() - d)/10 ;
                double NxVector = (ball1.getCenterX() - ball2.getCenterX()) / Math.sqrt((ball1.getCenterX() - ball2.getCenterX()) * (ball1.getCenterX() - ball2.getCenterX()) + (ball1.getCenterY() - ball2.getCenterY()) * (ball1.getCenterY() - ball2.getCenterY()));
                double NyVector = (ball1.getCenterY() - ball2.getCenterY()) / Math.sqrt((ball1.getCenterX() - ball2.getCenterX()) * (ball1.getCenterX() - ball2.getCenterX()) + (ball1.getCenterY() - ball2.getCenterY()) * (ball1.getCenterY() - ball2.getCenterY()));
                if (NyVector != 0) {
                    TyVector = -NxVector / NyVector / Math.sqrt(1 + (NxVector / NyVector) * (NxVector / NyVector));
                    TxVector = 1 / Math.sqrt(1 + (NxVector / NyVector) * (NxVector / NyVector));
                } else {
                    TxVector = 0;
                    TyVector = 1;
                }
                double d1tb= ball1.getDx() * TxVector + ball1.getDy() * TyVector;
                double d2tb= ball2.getDx() * TxVector + ball2.getDy() * TyVector;
                double d1nb= ball1.getDx() * NxVector + ball1.getDy() * NyVector;
                double d2nb= ball2.getDx() * NxVector + ball2.getDy() * NyVector;
                double d1ta;
                double d2ta;
                double d1na;
                double d2na;
                d1ta = d1tb;
                d2ta = d2tb;
                d2na = ((1 + ell) / 2) * d1nb + ((1 - ell) / 2) * d2nb;
                d1na = ((1 - ell) / 2) * d1nb + ((1 + ell) / 2) * d2nb;
                ball1.setCenterX(ball1.getCenterX()+ Dbg * NxVector);
                ball1.setCenterY(ball1.getCenterY()+ Dbg * NyVector);
                ball2.setCenterX(ball2.getCenterX()+ Dbg * NxVector);
                ball2.setCenterY(ball2.getCenterY()+ Dbg * NyVector);
                ball1.setDx(d1na * NxVector + d1ta * TxVector);
                ball1.setDy(d1na * NyVector + d1ta * TyVector);
                ball2.setDx(d2na * NxVector + d2ta * TxVector);
                ball2.setDy(d2na * NyVector + d2ta * TyVector);



            }

        }
    }
}

