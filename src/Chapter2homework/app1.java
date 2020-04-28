/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter2homework;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class app1 extends Application {

    ListView<String> listView1, listView2;
    private Button copy;
    private int selectedIndex;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        listView1 = new ListView<>();
        listView2 = new ListView<>();
        copy = new Button("Copy >>>");
        VBox vBox = new VBox(copy);
        vBox.setAlignment(Pos.CENTER);
        HBox box = new HBox(10, listView1, vBox, listView2);
        Scene s = new Scene(box);
        listView1.getItems().addAll("mohammed1", "m ", "a ", "as");
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        copy.setOnAction((event) -> {
            listView2.getItems().addAll(listView1.getSelectionModel().getSelectedItems());
        });
        primaryStage.setTitle("Multiple selection lists");
        primaryStage.setScene(s);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
