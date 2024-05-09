package com.jadepearl;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class Project3 extends Application {

    private TextField distField = new TextField();
    private TextField gasField = new TextField();
    private TextField milesField = new TextField();
    private TextField numDaysField = new TextField();
    private TextField hotelField = new TextField();
    private TextField foodField = new TextField();
    private TextField attractField = new TextField();
    private TextField totalField = new TextField();

    public void start(Stage primaryStage) {

        //properties for the UI
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(10);
        pane.setVgap(10);
        distField.setAlignment(Pos.CENTER_RIGHT);
        gasField.setAlignment(Pos.CENTER_RIGHT);
        milesField.setAlignment(Pos.CENTER_RIGHT);
        numDaysField.setAlignment(Pos.CENTER_RIGHT);
        hotelField.setAlignment(Pos.CENTER_RIGHT);
        foodField.setAlignment(Pos.CENTER_RIGHT);
        attractField.setAlignment(Pos.CENTER_RIGHT);
        totalField.setAlignment(Pos.CENTER_RIGHT);
        totalField.setEditable(false);

        pane.add(new Label("Distance:"), 0, 0);
        pane.add(distField, 1, 0);
        ComboBox<String> distCombo = new ComboBox<>();
        pane.add(distCombo, 2, 0);
        distCombo.getItems().addAll("miles", "kilometers");
        distCombo.setValue("miles");


        pane.add(new Label("Gasoline Cost:"), 0, 1);
        pane.add(gasField, 1, 1);
        ComboBox<String> gasCombo = new ComboBox<>();
        pane.add(gasCombo, 2, 1);
        gasCombo.getItems().addAll("dollars/gal", "dollars/liter");
        gasCombo.setValue("dollars/gal");

        pane.add(new Label("Gas Mileage"), 0, 2);
        pane.add(milesField, 1, 2);
        ComboBox<String> mileCombo = new ComboBox<>();
        pane.add(mileCombo, 2, 2);
        mileCombo.getItems().addAll("miles/gallon", "kilometers/liter");
        mileCombo.setValue("miles/gallon");

        pane.add(new Label("Number of Days:"), 0, 3);
        pane.add(numDaysField, 1, 3);
        pane.add(new Label("Hotel Cost"), 0, 4);
        pane.add(hotelField, 1, 4);
        pane.add(new Label("Food Cost"), 0, 5);
        pane.add(foodField, 1, 5);
        pane.add(new Label("Attractions"), 0, 6);
        pane.add(attractField, 1, 6);

        Button btnCalc = new Button("Calculate");
        pane.add(btnCalc, 1, 7);
        GridPane.setHalignment(btnCalc, HPos.CENTER);
        btnCalc.setMaxWidth(Double.MAX_VALUE);
        btnCalc.setOnAction(e -> {
            double distance = Double.parseDouble(distField.getText());
            double gas = Double.parseDouble(gasField.getText());
            double miles = Double.parseDouble(milesField.getText());
            int days = Integer.parseInt(numDaysField.getText());
            double hotel = Double.parseDouble(hotelField.getText());
            double food = Double.parseDouble(foodField.getText());
            double attractions = Double.parseDouble(attractField.getText());
            TripCost trip = new TripCost(distance, gas, miles, days, hotel, food, attractions);
            totalField.setText(String.format("$%.2f", trip.totalCost())); }
        );

        pane.add(new Label("Total Trip Cost"), 0, 8);
        pane.add(totalField, 1, 8);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Trip Cost Estimator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}