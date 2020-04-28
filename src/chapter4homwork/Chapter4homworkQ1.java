/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4homwork;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class Chapter4homworkQ1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane paneTableView = FXMLLoader.load(getClass().getResource("TableViewPane.fxml"));
        Pane textarea = FXMLLoader.load(getClass().getResource("TextAreaQuery.fxml"));
        Map<String, Pane> mapPanes = new TreeMap<>();
        mapPanes.put("tableView", paneTableView);
        mapPanes.put("TextAreaQuery", textarea);
        Scene scene = new Scene(mapPanes.get("tableView"));
        stage.setTitle("Streams and Database App");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
