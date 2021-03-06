/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5homwork;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Chapter5homwork extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Pane paneTableView = FXMLLoader.load(getClass().getResource("TableViewPane.fxml"));
            Pane textarea = FXMLLoader.load(getClass().getResource("TextAreaQuery.fxml"));
            Map<String, Pane> mapPanes = new TreeMap<>();
            mapPanes.put("TableView", paneTableView);
            mapPanes.put("TextAreaQuery", textarea);
            Scene scene = new Scene(mapPanes.get("TextAreaQuery"));
            stage.setTitle("Streams and Database App");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
