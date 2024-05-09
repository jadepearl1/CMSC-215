package com.jadepearl;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class Project4 extends Application {

    private Interval<Time> int1;
    private Interval<Time> int2;

    private TextField t1Start = new TextField();
    private TextField t1End = new TextField();
    private TextField t2Start = new TextField();
    private TextField t2End = new TextField();
    private TextField tCheck = new TextField();
    private TextField output = new TextField();

    public void start(Stage primaryStage) {
        // properties for the UI
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(10);
        pane.setVgap(10);
        t1Start.setAlignment(Pos.CENTER);
        t1End.setAlignment(Pos.CENTER);
        t2Start.setAlignment(Pos.CENTER);
        t2End.setAlignment(Pos.CENTER);
        tCheck.setAlignment(Pos.CENTER);
        GridPane.setColumnSpan(tCheck, 2);
        output.setAlignment(Pos.CENTER_LEFT);
        GridPane.setColumnSpan(output, 3);
        output.setEditable(false);

        pane.add(new Label("Start Time"), 1, 0);
        pane.add(new Label("End Time"), 2, 0);

        pane.add(new Label("Time Interval 1"), 0, 1);
        pane.add(t1Start, 1, 1);
        pane.add(t1End, 2, 1);

        pane.add(new Label("Time Interval 2"), 0, 2);
        pane.add(t2Start, 1, 2);
        pane.add(t2End, 2, 2);

        Button btnComp = new Button("Compare Intervals");
        pane.add(btnComp, 0, 3);
        GridPane.setHalignment(btnComp, HPos.CENTER);
        btnComp.setMaxWidth(Double.MAX_VALUE);
        GridPane.setColumnSpan(btnComp, 3);
        btnComp.setOnAction(e -> {
            try {
                Time t1S = new Time(t1Start.getText());
                Time t1E = new Time(t1End.getText());
                Time t2S = new Time(t2Start.getText());
                Time t2E = new Time(t2End.getText());
                int1 = new Interval<Time>(t1S, t1E);
                int2 = new Interval<Time>(t2S, t2E);
                String result;
                if (int1.subinterval(int2)) {
                    result = "Interval 1 is a sub-interval of interval 2";
                } else if (int1.subinterval(int2)) {
                    result = "Interval 2 is a sub-interval of Interval 1";
                } else if (int1.overlaps(int2)) {
                    result = "The intervals overlap";
                } else {
                    result = "The intervals are disjoint";
                }
                output.setText(result);
            } catch (InvalidTime ex) {
                output.setText(ex.getMessage());
            }
        });

        pane.add(new Label("Time to Check"), 0, 4);
        pane.add(tCheck, 1, 4);

        pane.add(output, 0, 6);

        Button btnCheck = new Button("Check Time");
        pane.add(btnCheck, 0, 5);
        GridPane.setHalignment(btnCheck, HPos.CENTER);
        btnCheck.setMaxWidth(Double.MAX_VALUE);
        GridPane.setColumnSpan(btnCheck, 3);
        btnCheck.setOnAction(e -> {
            try {
                Time t1S = new Time(t1Start.getText());
                Time t1E = new Time(t1End.getText());
                Time t2S = new Time(t2Start.getText());
                Time t2E = new Time(t2End.getText());
                int1 = new Interval<Time>(t1S, t1E);
                int2 = new Interval<Time>(t2S, t2E);
                String result;
                Time currentTime = new Time(tCheck.getText());
                if(int1.within(currentTime) && int2.within(currentTime)) {
                    result = "Both intervals contains the time " + currentTime;
                }
                else if(int1.within(currentTime)) {
                    result = "Only interval 1 contains the time " + currentTime;
                }
                else if (int2.within(currentTime)) {
                    result = "Only interval 2 contains the time " + currentTime;
                }
                else {
                    result = "Neither interval contains the time " + currentTime;
                }
                output.setText(result);
            } catch (InvalidTime ex) {
                output.setText(ex.getMessage());
            }
        });
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Time Interval Checker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}