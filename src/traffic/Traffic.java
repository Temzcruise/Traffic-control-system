package traffic;

import java.awt.TextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.animation.*;
import javafx.util.Duration;


/**
 *
 * @author Group 5
 */
public class Traffic extends Application {
    static String lane1Color;
    static String lane2Color;
    static String lane3Color;
    static String lane4Color;
    
    static String priorityLane = "";
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Random random = new Random();
        
        // Vehicles
        final Image car = new Image(new FileInputStream("C:\\Users\\Rosemary\\Documents\\NetBeansProjects\\Traffic\\src\\traffic\\car.png"));
        final Image ambulance = new Image(new FileInputStream("C:\\Users\\Rosemary\\Documents\\NetBeansProjects\\Traffic\\src\\traffic\\ambulance.png"));
        final Image rotated_car = new Image(new FileInputStream("C:\\Users\\Rosemary\\Documents\\NetBeansProjects\\Traffic\\src\\traffic\\rotated_car.png"));
        final Image rotated_ambulance = new Image(new FileInputStream("C:\\Users\\Rosemary\\Documents\\NetBeansProjects\\Traffic\\src\\traffic\\rotated_ambulance.png"));
        
        /*
        LANES
        */
        // Horizontal, for cars moving to the left.
        Rectangle lane1a = new Rectangle(0, 275, 625, 50); // Left of intersection.
        Rectangle lane1b = new Rectangle(725, 275, 700, 50); // Right of intersection.
        
        // Horizontal, for cars moving to the right.
        Rectangle lane2a = new Rectangle(0, 325, 625, 50); // Left of intersection.
        Rectangle lane2b = new Rectangle(725, 325, 700, 50); // Right of intersection.
        
        lane1a.setFill(javafx.scene.paint.Color.WHITE);
        lane1a.setStroke(javafx.scene.paint.Color.BLACK);
        lane1a.setStrokeWidth(1);
        
        lane1b.setFill(javafx.scene.paint.Color.WHITE);
        lane1b.setStroke(javafx.scene.paint.Color.BLACK);
        lane1b.setStrokeWidth(1);
        
        lane2a.setFill(javafx.scene.paint.Color.WHITE);
        lane2a.setStroke(javafx.scene.paint.Color.BLACK);
        lane2a.setStrokeWidth(1);
        
        lane2b.setFill(javafx.scene.paint.Color.WHITE);
        lane2b.setStroke(javafx.scene.paint.Color.BLACK);
        lane2b.setStrokeWidth(1);
        
        // Vertical, for cars moving down.
        Rectangle lane3a = new Rectangle(625, 0, 50, 275); // Above intersection.
        Rectangle lane3b = new Rectangle(625, 375, 50, 500); // Below intersection.
        
        // Vertical, for cars moving up.
        Rectangle lane4a = new Rectangle(675, 0, 50, 275); // Above intersection.
        Rectangle lane4b = new Rectangle(675, 375, 50, 500); // Below intersection.
        
        lane3a.setFill(javafx.scene.paint.Color.WHITE);
        lane3a.setStroke(javafx.scene.paint.Color.BLACK);
        lane3a.setStrokeWidth(1);
        
        lane3b.setFill(javafx.scene.paint.Color.WHITE);
        lane3b.setStroke(javafx.scene.paint.Color.BLACK);
        lane3b.setStrokeWidth(1);
        
        lane4a.setFill(javafx.scene.paint.Color.WHITE);
        lane4a.setStroke(javafx.scene.paint.Color.BLACK);
        lane4a.setStrokeWidth(1);
        
        lane4b.setFill(javafx.scene.paint.Color.WHITE);
        lane4b.setStroke(javafx.scene.paint.Color.BLACK);
        lane4b.setStrokeWidth(1);
        
        Group group = new Group();
        Node[] children = {
            lane1a, lane1b, lane2a, lane2b,
            lane3a, lane3b, lane4a, lane4b,
        };
        
        group.getChildren().addAll(children);
        
        /*
        LANE 1 TRAFFIC LIGHT
        */
        Timeline timeline5 = new Timeline();
        timeline5.setCycleCount(1);
        timeline5.setAutoReverse(false);
        
        final Rectangle trafficLight1 = new Rectangle(725, 275, 20, 50);
        group.getChildren().add(trafficLight1);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                switch (lane1Color) {
                    case "Green":
                        trafficLight1.setFill(Color.GREEN);
                        break;
                    case "Yellow":
                        trafficLight1.setFill(Color.YELLOW);
                        break;
                    case "Red":
                        trafficLight1.setFill(Color.RED);
                        break;
                }
                Timeline timeline = new Timeline();
                timeline.setCycleCount(1);
                timeline.setAutoReverse(false);
                KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), this);
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            }
        });

        timeline5.getKeyFrames().add(keyFrame);
        
        timeline5.play();
        
        /*
        LANE 2 TRAFFIC LIGHT
        */
        Timeline timeline6 = new Timeline();
        timeline6.setCycleCount(1);
        timeline6.setAutoReverse(false);
        
        final Rectangle trafficLight2 = new Rectangle(605, 325, 20, 50);
        group.getChildren().add(trafficLight2);

        keyFrame = new KeyFrame(Duration.seconds(0.5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                switch (lane2Color) {
                    case "Green":
                        trafficLight2.setFill(Color.GREEN);
                        break;
                    case "Yellow":
                        trafficLight2.setFill(Color.YELLOW);
                        break;
                    case "Red":
                        trafficLight2.setFill(Color.RED);
                        break;
                }
                Timeline timeline = new Timeline();
                timeline.setCycleCount(1);
                timeline.setAutoReverse(false);
                KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), this);
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            }
        });

        timeline6.getKeyFrames().add(keyFrame);
        
        timeline6.play();
        
        /*
        LANE 3 TRAFFIC LIGHT
        */
        Timeline timeline7 = new Timeline();
        timeline7.setCycleCount(1);
        timeline7.setAutoReverse(false);
        
        final Rectangle trafficLight3 = new Rectangle(625, 255, 50, 20);
        group.getChildren().add(trafficLight3);

        keyFrame = new KeyFrame(Duration.seconds(0.5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                switch (lane3Color) {
                    case "Green":
                        trafficLight3.setFill(Color.GREEN);
                        break;
                    case "Yellow":
                        trafficLight3.setFill(Color.YELLOW);
                        break;
                    case "Red":
                        trafficLight3.setFill(Color.RED);
                        break;
                }
                Timeline timeline = new Timeline();
                timeline.setCycleCount(1);
                timeline.setAutoReverse(false);
                KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), this);
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            }
        });

        timeline7.getKeyFrames().add(keyFrame);
        
        timeline7.play();
        
        /*
        LANE 4 TRAFFIC LIGHT
        */
        Timeline timeline8 = new Timeline();
        timeline8.setCycleCount(1);
        timeline8.setAutoReverse(false);
        
        final Rectangle trafficLight4 = new Rectangle(675, 375, 50, 20);
        group.getChildren().add(trafficLight4);

        keyFrame = new KeyFrame(Duration.seconds(0.5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                switch (lane4Color) {
                    case "Green":
                        trafficLight4.setFill(Color.GREEN);
                        break;
                    case "Yellow":
                        trafficLight4.setFill(Color.YELLOW);
                        break;
                    case "Red":
                        trafficLight4.setFill(Color.RED);
                        break;
                }
                Timeline timeline = new Timeline();
                timeline.setCycleCount(1);
                timeline.setAutoReverse(false);
                KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), this);
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
            }
        });

        timeline8.getKeyFrames().add(keyFrame);
        
        timeline8.play();
        
        /*
        MOVING LANE 1 VEHICLES
        */
        Timeline timeline1 = new Timeline();
        timeline1.setCycleCount(1);
        timeline1.setAutoReverse(false);

        for (int i=0; i < 10; i++) {
            final ImageView v = new ImageView(random.nextInt(20) > 1 ? car : ambulance);
            v.setFitHeight(40);
            v.setFitWidth(40);
            v.setX(1000 + 200*i);
            v.setY(280);
            
            final int j = i;
            group.getChildren().add(v);
            
            KeyValue xValue = new KeyValue(v.xProperty(), v.getX()-1);
            
            keyFrame = new KeyFrame(Duration.seconds(0.005), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    KeyValue xValue;
                    if (priorityLane == "" && v.getImage() == ambulance && v.getX() > 800) {
                        makePriorityRequest("lane1");
                    }
                    if (lane1Color != "Green" && v.getX() > 725 && v.getX() < 775 + j*50) {
                        xValue = new KeyValue(v.xProperty(), v.getX());
                    }
                    else {
                        v.setX(v.getX()-1);
                        xValue = new KeyValue(v.xProperty(), v.getX()-1);
                    }
                    Timeline timeline = new Timeline();
                    timeline.setCycleCount(1);
                    timeline.setAutoReverse(false);
                    KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005), this, xValue);
                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();
                }
            }, xValue);
            
            timeline1.getKeyFrames().add(keyFrame);
        }
        
        timeline1.play();
        
        /*
        MOVING LANE 2 VEHICLES
        */
        Timeline timeline2 = new Timeline();
        timeline2.setCycleCount(1);
        timeline2.setAutoReverse(false);

        for (int i=0; i < 10; i++) {
            final ImageView v = new ImageView(random.nextInt(20) > 1 ? car : ambulance);
            v.setFitHeight(40);
            v.setFitWidth(40);
            v.setX(570 - 200*i);
            v.setY(330);
            
            final int j = i;
            group.getChildren().add(v);
            
            KeyValue xValue = new KeyValue(v.xProperty(), v.getX()+1);
            
            keyFrame = new KeyFrame(Duration.seconds(0.005), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    KeyValue xValue;
                    if (priorityLane == "" && v.getImage() == ambulance && v.getX() < 500) {
                        makePriorityRequest("lane2");
                    }
                    if (lane2Color != "Green" && v.getX() < 625 && v.getX() > 565 - j*50) {
                        xValue = new KeyValue(v.xProperty(), v.getX());
                    }
                    else {
                        v.setX(v.getX()+1);
                        xValue = new KeyValue(v.xProperty(), v.getX()+1);
                    }
                    Timeline timeline = new Timeline();
                    timeline.setCycleCount(1);
                    timeline.setAutoReverse(false);
                    KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005), this, xValue);
                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();
                }
            }, xValue);
            
            timeline2.getKeyFrames().add(keyFrame);
        }
        
        timeline2.play();
        
        /*
        MOVING LANE 3 VEHICLES
        */
        Timeline timeline3 = new Timeline();
        timeline3.setCycleCount(1);
        timeline3.setAutoReverse(false);

        for (int i=0; i < 10; i++) {
            final ImageView v = new ImageView(random.nextInt(20) > 1 ? rotated_car : rotated_ambulance);
            v.setFitHeight(40);
            v.setFitWidth(40);
            v.setX(630);
            v.setY(220 - 100*i);
            
            final int j = i;
            group.getChildren().add(v);
            
            KeyValue yValue = new KeyValue(v.yProperty(), v.getY()+1);
            
            keyFrame = new KeyFrame(Duration.seconds(0.005), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    KeyValue yValue;
                    if (priorityLane == "" && v.getImage() == rotated_ambulance && v.getY() < 150) {
                        makePriorityRequest("lane3");
                    }
                    if (lane3Color != "Green" && v.getY() < 225 && v.getY() > 175 - j*50) {
                        yValue = new KeyValue(v.yProperty(), v.getY());
                    }
                    else {
                        v.setY(v.getY()+1);
                        yValue = new KeyValue(v.yProperty(), v.getY()+1);
                    }
                    Timeline timeline = new Timeline();
                    timeline.setCycleCount(1);
                    timeline.setAutoReverse(false);
                    KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005), this, yValue);
                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();
                }
            }, yValue);
            
            timeline3.getKeyFrames().add(keyFrame);
        }
        
        timeline3.play();
        
        /*
        MOVING LANE 4 VEHICLES
        */
        Timeline timeline4 = new Timeline();
        timeline4.setCycleCount(1);
        timeline4.setAutoReverse(false);

        for (int i=0; i < 10; i++) {
            final ImageView v = new ImageView(random.nextInt(20) > 1 ? rotated_car : rotated_ambulance);
            v.setFitHeight(40);
            v.setFitWidth(40);
            v.setX(680);
            v.setY(500 + 100*i);
            
            final int j = i;
            group.getChildren().add(v);
            
            KeyValue yValue = new KeyValue(v.yProperty(), v.getY()-1);
            
            keyFrame = new KeyFrame(Duration.seconds(0.005), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    KeyValue yValue;
                    if (priorityLane == "" && v.getImage() == rotated_ambulance && v.getY() > 400) {
                        makePriorityRequest("lane4");
                    }
                    if (lane4Color != "Green" && v.getY() > 375 && v.getY() < 425 + j*50) {
                        yValue = new KeyValue(v.yProperty(), v.getY());
                    }
                    else {
                        v.setY(v.getY()-1);
                        yValue = new KeyValue(v.yProperty(), v.getY()-1);
                    }
                    Timeline timeline = new Timeline();
                    timeline.setCycleCount(1);
                    timeline.setAutoReverse(false);
                    KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.005), this, yValue);
                    timeline.getKeyFrames().add(keyFrame);
                    timeline.play();
                }
            }, yValue);
            
            timeline4.getKeyFrames().add(keyFrame);
        }
        
        timeline4.play();
        
        Scene scene = new Scene(group, 300, 250);
        
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        
        primaryStage.setTitle("Traffic Management Simulation");
        primaryStage.setScene(scene);
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.show();
    }
    
    void makePriorityRequest(String lane) {
        priorityLane = lane;
    }

    public static void main(String[] args) {
        lane1Color = "Green";
        lane2Color = "Green";
        lane3Color = "Red";
        lane4Color = "Red";
        
        Timer trafficLight = new Timer();
        trafficLight.schedule(new TrafficLightTask(), 0, 1000);
        
        launch(args);
    }
    
    static class TrafficLightTask extends TimerTask {
        int timeElapsed = 0;
        String lanesInMotion;
        
        public TrafficLightTask () {
            this.lanesInMotion = "lane1, lane2";
        }
        
        @Override
        public void run() {
            timeElapsed++;
            if (timeElapsed == 4) {
                Traffic.priorityLane = "";
                lane1Color = "Yellow";
                lane2Color = "Yellow";
                lane3Color = "Yellow";
                lane4Color = "Yellow";
            }
            if (timeElapsed == 5) {
                timeElapsed = 0;
                switch (lanesInMotion) {
                    case "lane1, lane2":
                        lanesInMotion = "lane3, lane4";
                        lane1Color = "Red";
                        lane2Color = "Red";
                        lane3Color = "Green";
                        lane4Color = "Green";
                        break;
                    case "lane3, lane4":
                        lanesInMotion = "lane1, lane2";
                        lane1Color = "Green";
                        lane2Color = "Green";
                        lane3Color = "Red";
                        lane4Color = "Red";
                        break;
                }
            }
            if (Traffic.priorityLane.equals("lane1") || Traffic.priorityLane.equals("lane2")) {
                lanesInMotion = "lane3, lane4";
                return;
            }
            else if (Traffic.priorityLane.equals("lane3") || Traffic.priorityLane.equals("lane4")) {
                lanesInMotion = "lane1, lane2";
                return;
            }
            
        }
    }

}
