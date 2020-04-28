/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter2homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class app3 extends Application {

    Stage stage;
    TextArea textArea;
    ObservableList<String> observableList;
    ObservableList<Integer> integers;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Menu File = new Menu("_File");
        MenuItem open = new MenuItem("_open");
        MenuItem Close = new CheckMenuItem("_Close");
        MenuItem Exit = new MenuItem("_Exit");
        File.getItems().addAll(open, Close, Exit);

        textArea = new TextArea();
        open.setOnAction(event -> {
            try {
                FileChooser File_open = new FileChooser();
                File selest = File_open.showOpenDialog(primaryStage);
                Scanner in = new Scanner(selest);
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    textArea.appendText(line);
                    textArea.setWrapText(true);
                }
            } catch (FileNotFoundException ex) {
            }
        });
        Close.setOnAction(e -> {
            textArea.setText("");
        });
        Exit.setOnAction(event -> {
            primaryStage.close();
        });
        Menu Edit = new Menu("_Edit");
        MenuItem Font = new MenuItem("_Font");
        MenuItem color = new CheckMenuItem("_color");
        Edit.getItems().addAll(Font, color);
        MenuBar mb = new MenuBar();
        mb.getMenus().addAll(File, Edit);
        BorderPane loyout = new BorderPane();
        loyout.setTop(mb);
        loyout.setCenter(textArea);
        Font.setOnAction(event -> {
            Font font = new Font(10);
            integers = FXCollections.observableArrayList();
            integers.addAll(10, 15, 20, 25, 30);
            ChoiceDialog dialog = new ChoiceDialog();
            dialog.getItems().addAll(integers);
            dialog.setSelectedItem(integers.get(0));
            Button button = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
            button.setOnAction(e -> {
                textArea.setFont(new Font((int) dialog.getSelectedItem()));
            });
            dialog.setHeaderText("font size ?? ");
            dialog.setTitle("Font");
            dialog.show();
        });
        color.setOnAction(e -> {
            observableList = FXCollections.observableArrayList();
            observableList.addAll("red", "activeborder", "cyan", "deepskyblue", "limegreen");
            ChoiceDialog dialog = new ChoiceDialog();
            dialog.getItems().addAll(observableList);
            dialog.setSelectedItem(observableList.get(0));
            Button but = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
            but.setOnAction(event -> {
                textArea.setStyle("-fx-text-fill : " + dialog.getSelectedItem().toString());
            });
            dialog.setHeaderText("font color ?? ");
            dialog.setTitle("color");
            dialog.setContentText("");
            dialog.show();
        });
        Scene scene = new Scene(loyout, 400, 350);
        primaryStage.setTitle("File open ....");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
