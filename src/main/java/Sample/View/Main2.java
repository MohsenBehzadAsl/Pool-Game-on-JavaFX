package Sample.View;

import Sample.Transitions.BallAnimation;
import javafx.geometry.Pos;
import Sample.View.Components.Ball;
import Sample.View.Components.Cue;
import Sample.View.Components.Goals;
import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.ArrayList;

import static Sample.View.Main.label;
import static Sample.View.Main.playerNameText;

public class Main2{
    public static ArrayList<Ball> poolBalls;
    private static Cue cue ;
    private int thata=0;
    Label player=new Label();
    public static Label score=new Label();
    Label pocketBalls=new Label();
    String playerName=new String();
    public static String scoreNum=new String("0");
    public static String shotNum=new String("0");
    Label shootsNum =new Label();
    public static boolean finished=false;
    private static Stage stage;
    static Pane pane;

    public static boolean really=true;

    public static Arc[] getPockets2() {
        return pockets2;
    }

    public void setPockets2(Arc[] pockets2) {
        this.pockets2 = pockets2;
    }

    static Arc[] pockets2;

    public void start(Stage stage) throws Exception {
        this.stage=stage;

        pane = FXMLLoader.load(getClass().getResource("/Sample/fxml/main2.fxml"));
        player.setText("Player: " + Main.playerNameText.getText().toString());player.setFont(Font.font(30));player.setLayoutX(0);player.setLayoutY(735);player.setPrefWidth(256);player.setPrefHeight(40); player.setStyle("-fx-background-color:  rgba(4,45,250,0.84);");player.setAlignment(Pos.CENTER);
        pane.getChildren().add(player);
        score.setText("Score: "+ scoreNum);score.setFont(Font.font(30));score.setLayoutX(256);score.setLayoutY(735);score.setPrefWidth(256);score.setPrefHeight(40); score.setStyle("-fx-background-color:  rgba(4,45,250,0.84);");score.setAlignment(Pos.CENTER);
        pane.getChildren().add(score);
        shootsNum.setText("shots: "+shotNum);shootsNum.setFont(Font.font(30));shootsNum.setLayoutX(512);shootsNum.setLayoutY(735);shootsNum.setPrefWidth(256);shootsNum.setPrefHeight(40); shootsNum.setStyle("-fx-background-color:  rgba(4,45,250,0.84);");shootsNum.setAlignment(Pos.CENTER_LEFT);
        pane.getChildren().add(shootsNum);
        pocketBalls.setText("Pocket Balls: ");pocketBalls.setFont(Font.font(30));pocketBalls.setLayoutX(768);pocketBalls.setLayoutY(735);pocketBalls.setPrefWidth(662);pocketBalls.setPrefHeight(40); pocketBalls.setStyle("-fx-background-color:  rgba(4,45,250,0.84);");pocketBalls.setAlignment(Pos.CENTER_LEFT);
        pane.getChildren().add(pocketBalls);

        Goals goals = Goals.getInstance();
        pane.getChildren().add(goals);
        Arc[] pockets = goals.getPockets();
        pane.getChildren().addAll(pockets);
        pockets2 = goals.getPockets2();
        Rectangle[] rectangles = creatBoundedRectangle();
        pane.getChildren().addAll(rectangles);
        poolBalls = creatBalls();
        pane.getChildren().addAll(poolBalls);


        cue=new Cue((int) poolBalls.get(0).getX(),(int) poolBalls.get(0).getY()-2);
        cue.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/cue.png").toExternalForm())));


        cue.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!finished) {
                    RotateTransition rotateTransition = new RotateTransition();
                    rotateTransition.setNode(cue);
                    rotateTransition.setAxis(Rotate.Z_AXIS);
                    rotateTransition.setByAngle(Math.atan2((int) poolBalls.get(0).getCenterY() - mouseEvent.getY(), (int) poolBalls.get(0).getCenterX() - mouseEvent.getX()) * 180 / Math.PI);
                    cue.updateCue((int) mouseEvent.getSceneX(), (int) mouseEvent.getSceneY());


                    if (cue.getyPos() > (int) poolBalls.get(0).getCenterY()) {
                        thata = -(int) (Math.atan2((int) poolBalls.get(0).getCenterY() - cue.getyPos(), (int) poolBalls.get(0).getCenterX() - cue.getxPos()) * 180 / Math.PI);
                    } else {
                        thata = 360 - (int) (Math.atan2((int) poolBalls.get(0).getCenterY() - cue.getyPos(), (int) poolBalls.get(0).getCenterX() - cue.getxPos()) * 180 / Math.PI);
                    }

                    rotateTransition.play();
                }
            }
        });






        pane.getChildren().add(cue);


        Rectangle rectangle20=new Rectangle(7,600,110,130);
        rectangle20.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/"+label+".png").toExternalForm())));
        rectangle20.setArcHeight(20);
        rectangle20.setArcWidth(20);
        pane.getChildren().add(rectangle20);


        Rectangle rectangle=new Rectangle(1335,120,50,520);
        rectangle.setFill(Color.WHITE);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        pane.getChildren().add(rectangle);
        Rectangle rectangle1=new Rectangle(1350,140,20,480);
        rectangle1.setFill(Color.BLACK);
        rectangle1.setArcHeight(20);
        rectangle1.setArcWidth(20);
        pane.getChildren().add(rectangle1);
        Circle circle=new Circle(1360,225,33);
        circle.setFill(Color.BLACK);

        circle.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!finished) {
                    circle.setCenterY(mouseEvent.getY());
                    if (circle.getCenterY() < 170) {
                        circle.setCenterY(170);
                    } else if (circle.getCenterY() > 590) {
                        circle.setCenterY(590);
                    }
                }
            }
        });
        pane.getChildren().add(circle);


        Button button=new Button();
        button.setText("SHOT");
        button.setLayoutX(1320);
        button.setLayoutY(680);
        button.setFont(new Font(20));




        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!finished && really) {
                    really=false;
                    BallAnimation animation = new BallAnimation(poolBalls, cue);
                    animation.play();
                    poolBalls.get(0).setDx((590.0 - circle.getCenterY()) / 30 * Math.cos(Math.toRadians(thata)));
                    poolBalls.get(0).setDy((590.0 - circle.getCenterY()) / 30 * Math.sin(Math.toRadians(thata)) * (-1));
                    cue.setVisible(false);
                    if (Integer.parseInt(shotNum) >= 15) {
                        if (Integer.parseInt(scoreNum) >= 10) {
                            scoreNum = String.valueOf(Integer.parseInt(scoreNum) - 10);
                            score.setText("Score: " + scoreNum);
                        } else {
                            finished = true;
                            cue.setVisible(false);
                            Label finished = new Label("You lost");
                            Button buttonFinished=new Button("restart");
                            Button menu=new Button("Menu");
                            Button exit=new Button("Exit");

                            finished.setFont(Font.font(30));finished.setLayoutX(640);finished.setLayoutY(250);finished.setPrefWidth(150);finished.setPrefHeight(60); finished.setStyle("-fx-background-color:  rgb(239,12,12);");finished.setAlignment(Pos.CENTER);
                            pane.getChildren().add(finished);

                            buttonFinished.setLayoutX(640);
                            buttonFinished.setLayoutY(320);
                            buttonFinished.setPrefWidth(150);
                            buttonFinished.setPrefHeight(60);
                            buttonFinished.setBackground(Background.fill(Color.PURPLE));
                            buttonFinished.setFont(Font.font(30));
                            buttonFinished.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    try {
                                        shotNum="0";scoreNum="0";help();BallAnimation.kkk=970;BallAnimation.t=0;
                                        new Main2().start(stage);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });

                            menu.setLayoutX(640);
                            menu.setLayoutY(390);
                            menu.setPrefWidth(150);
                            menu.setPrefHeight(60);
                            menu.setBackground(Background.fill(Color.PURPLE));
                            menu.setFont(Font.font(30));
                            menu.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    try {
                                        label="e0";
                                        playerNameText.setText("");playerNameText.setPromptText("Player Name");
                                        shotNum="0";scoreNum="0";help();BallAnimation.kkk=970;BallAnimation.t=0;
                                        new Main().start(stage);

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });

                            exit.setLayoutX(640);
                            exit.setLayoutY(460);
                            exit.setPrefWidth(150);
                            exit.setPrefHeight(60);
                            exit.setBackground(Background.fill(Color.PURPLE));
                            exit.setFont(Font.font(30));
                            exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    System.exit(0);
                                }
                            });

                            pane.getChildren().add(menu);pane.getChildren().add(exit);pane.getChildren().add(buttonFinished);
                        }

                    }
                    if (!finished) {
                        shotNum = String.valueOf(Integer.parseInt(shotNum) + 1);
                        shootsNum.setText("Shots: " + shotNum);
                    }
                }
            }
        });


        System.out.println(poolBalls.get(0).getDx());System.out.println(poolBalls.get(0).getDy());System.out.println();
        pane.getChildren().add(button);

        Scene scene = new Scene(pane);

        stage.setScene(scene);

    }


    private static boolean collides(Circle c1, Circle c2) {
        return Math.pow(c1.getCenterX() - c2.getCenterX(), 2) + Math.pow(c1.getCenterY() - c2.getCenterY(), 2) <= Math.pow(c1.getRadius() + c2.getRadius(), 2);
    }

    public Rectangle[] creatBoundedRectangle() {
        Rectangle[] rectangles = new Rectangle[4];
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                Rectangle rectangle = new Rectangle(125, 25, 1155, 25);
                rectangle.setFill(Color.rgb(114, 76, 38, 1));
                rectangles[i] = rectangle;
            } else if (i == 1) {
                Rectangle rectangle = new Rectangle(125, 690, 1155, 25);
                rectangle.setFill(Color.rgb(114, 76, 38, 1));
                rectangles[i] = rectangle;
            } else if (i == 2) {
                Rectangle rectangle = new Rectangle(125, 25, 25, 690);
                rectangle.setFill(Color.rgb(114, 76, 38, 1));
                rectangles[i] = rectangle;
            } else if (i == 3) {
                Rectangle rectangle = new Rectangle(1257, 25, 25, 690);
                rectangle.setFill(Color.rgb(114, 76, 38, 1));
                rectangles[i] = rectangle;
            }

        }


        return rectangles;
    }

    public ArrayList<Ball> creatBalls() {
        ArrayList<Ball> balls=new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            if (i == 0) {
                Ball ball = new Ball(300, 370, 25, 1, Color.WHITE, true, 0);
                ball.setColour("white");
                ball.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/0.png").toExternalForm())));
                balls.add(ball);
            } else if (i == 1) {
                Ball ball = new Ball(918, 370, 25, 1,  Color.BLACK, true, 1);
                ball.setColour("orange");
               ball.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/1.png").toExternalForm())));
                balls.add(ball);
            } else if (i == 2) {
                Ball ball = new Ball(965, 343, 25, 1,  Color.BLACK, true, 2);
                ball.setColour("orange");
                ball.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/2.png").toExternalForm())));
                balls.add(ball);
            } else if (i == 3) {
                Ball ball = new Ball(963, 397, 25, 1, Color.BLACK, true, 3);
                ball.setColour("orange");
                ball.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/3.png").toExternalForm())));
                balls.add(ball);
            } else if (i == 4) {
                Ball ball = new Ball(1014, 318, 25, 1,  Color.BLACK, true, 4);
                ball.setColour("orange");
                ball.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/4.png").toExternalForm())));
                balls.add(ball);
            } else if (i == 5) {
                Ball ball = new Ball(1013, 372, 25, 1,  Color.BLACK, true, 5);
                ball.setColour("orange");
                ball.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/5.png").toExternalForm())));
                balls.add(ball);
            } else if (i == 6) {
                Ball ball = new Ball(1012, 427, 25, 1,  Color.BLACK, true, 6);
                ball.setColour("orange");
                ball.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/6.png").toExternalForm())));
                balls.add(ball);
            } else if (i == 7) {
                Ball ball = new Ball(1064, 293, 25, 1,  Color.BLACK, true, 7);
                ball.setColour("orange");
                ball.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/7.png").toExternalForm())));
                balls.add(ball);
            } else if (i == 8) {
                Ball ball = new Ball(1063, 347, 25, 1,  Color.BLACK, true, 8);
                ball.setColour("black");
                ball.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/8.png").toExternalForm())));
                balls.add(ball);
            } else if (i == 9) {
                Ball ball = new Ball(1063, 402, 25, 1, Color.BLACK, true, 9);
                ball.setColour("orange");
                ball.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/9.png").toExternalForm())));
                balls.add(ball);
            } else if (i == 10) {
                Ball ball = new Ball(1062, 454, 25, 1, Color.BLACK, true, 10);
                ball.setColour("orange");
                ball.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/10.png").toExternalForm())));
                balls.add(ball);
            }

        }
        return balls;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(String scoreNum) {
        this.scoreNum = scoreNum;
    }

    public static void finishP(){
        for (int p=0;p<11;p++) {
            poolBalls.get(p).setDx(0);poolBalls.get(p).setDy(0);
        }
        finished = true;
        cue.setVisible(false);
        Label finished = new Label("You won");
        Button buttonFinished=new Button("restart");
        Button menu=new Button("Menu");
        Button exit=new Button("Exit");

        finished.setFont(Font.font(30));finished.setLayoutX(640);finished.setLayoutY(250);finished.setPrefWidth(150);finished.setPrefHeight(60); finished.setStyle("-fx-background-color:  rgb(54,239,12);");finished.setAlignment(Pos.CENTER);
        pane.getChildren().add(finished);

        buttonFinished.setLayoutX(640);
        buttonFinished.setLayoutY(320);
        buttonFinished.setPrefWidth(150);
        buttonFinished.setPrefHeight(60);
        buttonFinished.setBackground(Background.fill(Color.PURPLE));
        buttonFinished.setFont(Font.font(30));
        buttonFinished.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    shotNum="0";scoreNum="0";help();BallAnimation.kkk=970;BallAnimation.t=0;
                    new Main2().start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        menu.setLayoutX(640);
        menu.setLayoutY(390);
        menu.setPrefWidth(150);
        menu.setPrefHeight(60);
        menu.setBackground(Background.fill(Color.PURPLE));
        menu.setFont(Font.font(30));
        menu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    label="e0";
                    playerNameText.setText("");playerNameText.setPromptText("Player Name");
                    shotNum="0";scoreNum="0";help();BallAnimation.kkk=970;BallAnimation.t=0;
                    new Main().start(stage);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        exit.setLayoutX(640);
        exit.setLayoutY(460);
        exit.setPrefWidth(150);
        exit.setPrefHeight(60);
        exit.setBackground(Background.fill(Color.PURPLE));
        exit.setFont(Font.font(30));
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.exit(0);
            }
        });

        pane.getChildren().add(menu);pane.getChildren().add(exit);pane.getChildren().add(buttonFinished);
    }

    public static void finishN(){

        finished = true;
        Label finished = new Label("You lost");
        Button buttonFinished=new Button("restart");
        Button menu=new Button("Menu");
        Button exit=new Button("Exit");

        finished.setFont(Font.font(30));finished.setLayoutX(640);finished.setLayoutY(250);finished.setPrefWidth(150);finished.setPrefHeight(60); finished.setStyle("-fx-background-color:  rgb(239,12,12);");finished.setAlignment(Pos.CENTER);
        pane.getChildren().add(finished);

        buttonFinished.setLayoutX(640);
        buttonFinished.setLayoutY(320);
        buttonFinished.setPrefWidth(150);
        buttonFinished.setPrefHeight(60);
        buttonFinished.setBackground(Background.fill(Color.PURPLE));
        buttonFinished.setFont(Font.font(30));
        buttonFinished.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    shotNum="0";scoreNum="0";help();BallAnimation.kkk=970;BallAnimation.t=0;
                    new Main2().start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        menu.setLayoutX(640);
        menu.setLayoutY(390);
        menu.setPrefWidth(150);
        menu.setPrefHeight(60);
        menu.setBackground(Background.fill(Color.PURPLE));
        menu.setFont(Font.font(30));
        menu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    label="e0";
                    playerNameText.setText("");playerNameText.setPromptText("Player Name");
                    shotNum="0";scoreNum="0";help();BallAnimation.kkk=970;BallAnimation.t=0;
                    new Main().start(stage);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        exit.setLayoutX(640);
        exit.setLayoutY(460);
        exit.setPrefWidth(150);
        exit.setPrefHeight(60);
        exit.setBackground(Background.fill(Color.PURPLE));
        exit.setFont(Font.font(30));
        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.exit(0);
            }
        });

        pane.getChildren().add(menu);pane.getChildren().add(exit);pane.getChildren().add(buttonFinished);
    }

    public static void help(){
        finished=false;
        really=true;
    }


}
