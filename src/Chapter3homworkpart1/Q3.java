/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter3homworkpart1;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class Q3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("login page .. ");
        Label label = new Label("welcome");
        label.setId("welcome");
        GridPane GP = new GridPane();
        GP.add(label, 0, 0);

        Label name = new Label("username");
        GP.add(name, 0, 1);

        TextField inname = new TextField();
        GP.add(inname, 1, 1);

        Label password = new Label("password");
        GP.add(password, 0, 2);

        TextField inpassword = new TextField();
        GP.add(inpassword, 1, 2);

        Button Sign_up = new Button("Sign up");
        Sign_up.setOnAction(E -> {
            File F;
            Scanner input;

            try {
                F = new File("names.txt");
                if (!F.exists()) {
                    F.createNewFile();
                }
                input = new Scanner(F);
                boolean isFound = false;
                while (input.hasNextLine()) {
                    String[] data = input.nextLine().split(" ");
                    if (inname.getText().equals(data[0]) && inpassword.getText().equals(data[1])) {
                        isFound = true;
                        Button adds = new Button("Add Student");
//                         List<student> list = new ArrayList<>();
                        adds.setOnAction(event -> {
                            GridPane grid_pane = new GridPane();
                            Label student_data = new Label("student_data");
                            student_data.setStyle("-fx-font-weight: bold ;");
                            grid_pane.add(student_data, 0, 0);

                            Label id_s = new Label("id : ");
                            grid_pane.add(id_s, 0, 1);
                            TextField id_input = new TextField("");

                            grid_pane.add(id_input, 1, 1);
                            Label name_s = new Label("name : ");
                            grid_pane.add(name_s, 0, 2);
                            TextField name_input = new TextField("");

                            grid_pane.add(name_input, 1, 2);
                            Label major_s = new Label("major : ");
                            grid_pane.add(major_s, 0, 3);

                            TextField major_input = new TextField("");
                            grid_pane.add(major_input, 1, 3);

                            Label geade_s = new Label("geade : ");
                            grid_pane.add(geade_s, 0, 4);
                            TextField geade_input = new TextField("");
                            grid_pane.add(geade_input, 1, 4);
                            grid_pane.setHgap(8);
                            grid_pane.setVgap(8);
                            Button Add, Reset, Exit;
                            Add = new Button("add");
                            Reset = new Button("Reset");
                            Exit = new Button("Exit");
                            ListView listView = new ListView();

                            Add.setOnAction(e -> {
                                if (id_input.getText().equals(null) && name_input.getText().equals(null) && major_input.getText().equals(null) && geade_input.getText().equals(null)) {
                                }
                                Student_class ss = new Student_class();
                                ss.setId(Integer.parseInt(id_input.getText()));
                                ss.setName(name_input.getText());
                                ss.setMajor(major_input.getText());
                                ss.setGeade(Double.parseDouble(geade_input.getText()));
                                listView.getItems().addAll(ss);

                                Collections.sort(listView.getItems(), new Comparator<Student_class>() {
                                    @Override
                                    public int compare(Student_class o1, Student_class o2) {
                                        if (o1.getGeade() == o2.getGeade()) {
                                            return 0;
                                        } else if (o1.getGeade() > o2.getGeade()) {
                                            return -1;
                                        } else if (o1.getGeade() < o2.getGeade()) {
                                            return 1;
                                        }
                                        return 0;
                                    }
                                });

                            });
                            HBox buttons_HB = new HBox(5, Add, Reset, Exit);
                            grid_pane.add(buttons_HB, 1, 5);
                            HBox HB = new HBox(10, grid_pane, listView);
                            HB.setPadding(new Insets(20));
                            Scene scene = new Scene(HB, 550, 400);
                            primaryStage.setTitle("Student Entry page ");
                            scene.getStylesheets().add("StyleSheet.css");
                            primaryStage.setScene(scene);
                            primaryStage.show();
                        });
                        Button views = new Button("view Student");
                        VBox vb = new VBox(10, adds, views);
                        vb.setAlignment(Pos.CENTER);
                        Scene scene = new Scene(vb, 300, 250);
                        primaryStage.setTitle("options page");
                        primaryStage.setScene(scene);
                        scene.getStylesheets().add("StyleSheet.css");
                        primaryStage.show();
                    }
                }
                if (!isFound) {

                    Alert alert = new Alert(Alert.AlertType.WARNING, "not found !!! ", ButtonType.OK);
                    alert.showAndWait();
                }

            } catch (IOException ex) {

            }
        });

        Button buttone = new Button("Exit");
        HBox hbox = new HBox(10, Sign_up, buttone);
        hbox.setAlignment(Pos.CENTER);
        GP.add(hbox, 0, 2);
        GP.setAlignment(Pos.CENTER);
        GP.setVgap(15);
        GP.setHgap(5);
        VBox VB = new VBox(30, GP, hbox);
        VB.setPadding(new Insets(30, 0, 0, 0));
        Scene scene = new Scene(VB, 300, 250);

        primaryStage.setScene(scene);
        scene.getStylesheets().add("StyleSheet.css");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
