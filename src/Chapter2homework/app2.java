/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter2homework;

import com.sun.javafx.scene.control.skin.LabeledText;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class app2 extends Application {

    double asd;
    int Fahrenheit;
    int Kelvin;
    Label labele2 = new Label();
    String aaa;
    TextField textField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label labele = new Label("Entere Celsius temperature ");
        HBox box1 = new HBox(10, labele);
        textField = new TextField();
        HBox box2 = new HBox(textField);
        RadioButton Fahrenheit = new RadioButton("Fahrenheit");
        RadioButton Kelvin = new RadioButton("Kelvin");
        HBox box3 = new HBox(30, Fahrenheit, Kelvin);
        textField.setAlignment(Pos.TOP_CENTER);
        Fahrenheit.setSelected(true);
        ToggleGroup radioGroup = new ToggleGroup();
        Fahrenheit.setToggleGroup(radioGroup);
        Kelvin.setToggleGroup(radioGroup);

        Fahrenheit.setOnMouseClicked((event) -> {
            String s = textField.getText().toString();
            double celsius = Double.parseDouble(s);
            double fahrenheit2 = (celsius * 9 / 5 + 32);
            labele2.setText("New Temperaturer in is :" + fahrenheit2);
        });

        Kelvin.setOnMouseClicked((event) -> {
            String s = textField.getText().toString();
            double celsius = Double.parseDouble(s);
            double kelvin2 = (celsius + 273.15);
            labele2.setText(" New Temperaturer in is :" + kelvin2);
        });

        HBox box = new HBox(labele2);
        VBox radioHBox = new VBox(40, box1, box2, box3, labele2);
        radioHBox.setPadding(new Insets(30));
        Scene scene = new Scene(radioHBox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
