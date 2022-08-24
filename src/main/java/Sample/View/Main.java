package Sample.View;


import Sample.Transitions.BallAnimation;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Main extends Application {


    private static Stage stage;
    static TextField playerNameText=new TextField();

    Label playerName=new Label("Please set your character and name");

    static String label="e0";



    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;


        Pane pane = FXMLLoader.load(getClass().getResource("/Sample/fxml/main1.fxml"));


        playerNameText.setPromptText("Player Name");playerNameText.setLayoutX(590);playerNameText.setLayoutY(350);playerNameText.setPrefWidth(256);playerNameText.setPrefHeight(45);
        playerNameText.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.ENTER)){
                    if (playerNameText.getText().isEmpty()){
                        playerNameText.setText("");
                        playerNameText.setPromptText("please fill player name TextField");
                    }else{
                        try {
                            new Main2().start(stage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        pane.getChildren().add(playerNameText);

        playerName.setLayoutX(550);playerName.setLayoutY(50);playerName.setPrefWidth(310);playerName.setPrefHeight(45); playerName.setStyle("-fx-background-color:  rgba(236,9,206,0.67);");playerName.setAlignment(Pos.CENTER);
        pane.getChildren().add(playerName);


        javafx.scene.shape.Rectangle rectangle=new Rectangle(636,131,150,180);
        rectangle.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/"+label+".png").toExternalForm())));
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        pane.getChildren().add(rectangle);

        Button button6 =new Button();
        button6.setLayoutX(49);
        button6.setLayoutY(440);
        button6.setPrefHeight(156);
        button6.setPrefWidth(150);
        button6.setBackground(Background.fill(new ImagePattern(new Image(getClass().getResource("/Sample/png/e3.png").toExternalForm()))));
        button6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label="e3";
                rectangle.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/"+label+".png").toExternalForm())));
            }
        });
        pane.getChildren().add(button6);

        Button button5=new Button();
        button5.setLayoutX(49);
        button5.setLayoutY(252);
        button5.setPrefHeight(156);
        button5.setPrefWidth(150);
        button5.setBackground(Background.fill(new ImagePattern(new Image(getClass().getResource("/Sample/png/e2.png").toExternalForm()))));
        button5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label="e2";
                rectangle.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/"+label+".png").toExternalForm())));
            }
        });
        pane.getChildren().add(button5);


        Button button4 =new Button();
        button4.setLayoutX(49);
        button4.setLayoutY(65);
        button4.setPrefHeight(156);
        button4.setPrefWidth(150);
        button4.setBackground(Background.fill(new ImagePattern(new Image(getClass().getResource("/Sample/png/e1.png").toExternalForm()))));
        button4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label="e1";
                rectangle.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/"+label+".png").toExternalForm())));
            }
        });
        pane.getChildren().add(button4);

        Button button3 =new Button();
        button3.setLayoutX(1236);
        button3.setLayoutY(440);
        button3.setPrefHeight(156);
        button3.setPrefWidth(150);
        button3.setBackground(Background.fill(new ImagePattern(new Image(getClass().getResource("/Sample/png/e6.png").toExternalForm()))));
        button3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label="e6";
                rectangle.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/"+label+".png").toExternalForm())));
            }
        });
        pane.getChildren().add(button3);

        Button button2 =new Button();
        button2.setLayoutX(1236);
        button2.setLayoutY(252);
        button2.setPrefHeight(156);
        button2.setPrefWidth(150);
        button2.setBackground(Background.fill(new ImagePattern(new Image(getClass().getResource("/Sample/png/e5.png").toExternalForm()))));
        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label="e5";
                rectangle.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/"+label+".png").toExternalForm())));
            }
        });
        pane.getChildren().add(button2);

        Button button1 =new Button();
        button1.setLayoutX(1236);
        button1.setLayoutY(65);
        button1.setPrefHeight(156);
        button1.setPrefWidth(150);
        button1.setBackground(Background.fill(new ImagePattern(new Image(getClass().getResource("/Sample/png/e4.png").toExternalForm()))));
        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label="e4";
                rectangle.setFill(new ImagePattern(new Image(getClass().getResource("/Sample/png/"+label+".png").toExternalForm())));
            }
        });
        pane.getChildren().add(button1);


        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Sharif Pool Game");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    public void startNewGame(MouseEvent mouseEvent) throws Exception {
        if (playerNameText.getText().isEmpty()){
            playerNameText.setText("");
            playerNameText.setPromptText("please fill player name TextField");
        }else{
            new Main2().start(stage);
        }

    }
    public void exit(MouseEvent mouseEvent) {
        System.exit(0);
    }

}
