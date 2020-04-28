/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter2homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class app5 extends Application {

    Stage s1;
    Scene Scene1, Scene2;
    public Label Labe5;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label welcome = new Label("Welcome");
        welcome.setId("wlcom");

        Label username = new Label("User Name ");
        TextField name_field = new TextField();
        HBox username_box = new HBox(10, username, name_field);
        username_box.setAlignment(Pos.CENTER);

        Label Passowrd = new Label("Passowrd ");
        TextField Passowrd_field = new TextField();
        HBox Passowrd_box = new HBox(10, Passowrd, Passowrd_field);
        Passowrd_box.setAlignment(Pos.CENTER);

        Button signin = new Button("Sign In");
        Button exit = new Button("Exit");
        HBox signin_exit_box = new HBox(10, signin, exit);
        signin.setId("button");
        exit.setId("button");
        signin_exit_box.setAlignment(Pos.CENTER);

        GridPane gridPane_login = new GridPane();
        gridPane_login.add(welcome, 1, 0);
        gridPane_login.add(username_box, 1, 1);
        gridPane_login.add(Passowrd_box, 1, 2);
        gridPane_login.add(signin_exit_box, 1, 3);
        gridPane_login.setAlignment(Pos.CENTER);
        gridPane_login.setVgap(20);
        Scene Login = new Scene(gridPane_login, 450, 400);
        Login.getStylesheets().add("style.css");
        primaryStage.setTitle("Login Page");

        signin.setOnAction(sign -> {
            File validationFile;
            Scanner input;
            try {
                validationFile = new File("validationFile.txt");
                if (!validationFile.exists()) {
                    validationFile.createNewFile();
                }
                input = new Scanner(validationFile);
                boolean Found = false;

                while (input.hasNextLine()) {
                    String[] validate = input.nextLine().split(" ");
                    if (name_field.getText().equals(validate[0]) && Passowrd_field.getText().equals(validate[1])) {
                        Found = true;
                        System.out.println("isValidate");
                        Button add = new Button("Add Student");
                        Button view = new Button("View Student");
                        add.setId("button");
                        view.setId("button");
                        VBox addAndView = new VBox(6, add, view);
                        addAndView.setAlignment(Pos.CENTER);
                        Scene IntirnalLogin = new Scene(addAndView, 450, 400);
                        IntirnalLogin.getStylesheets().add("style.css");
                        primaryStage.setTitle("Options Page");
                        primaryStage.setScene(IntirnalLogin);
                    }
                }
                if (!Found) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Your Acount not Saved in validationFile", ButtonType.OK);
                    alert.show();

                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        });

        exit.setOnAction(ex -> {
            primaryStage.close();
        });

        primaryStage.setScene(Login);
        primaryStage.show();
    }

}
