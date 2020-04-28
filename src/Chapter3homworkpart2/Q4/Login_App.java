package Chapter3homworkpart2.Q4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author 
 */
public class Login_App extends Application {

    Button btn_add_std = new Button("Add Student");
    Button btn_view_std = new Button("View Student");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);

        Label label_wel = new Label("Welcome");
        label_wel.setId("wel");

        Label label_username = new Label("Username");
        TextField tf_username = new TextField();
        HBox userBox = new HBox(10, label_username, tf_username);

        Label label_pass = new Label("Password");
        TextField tf_pass = new TextField();
        HBox passBox = new HBox(10, label_pass, tf_pass);

        Button btn_signIn = new Button("Sign In");
        Button btn_exit = new Button("Exit");
        HBox btns = new HBox(10, btn_signIn, btn_exit);
        btns.setAlignment(Pos.BASELINE_RIGHT);

        Label label_error = new Label();
        label_error.setId("error");

        btn_signIn.setOnAction(event -> {
            String username = tf_username.getText();
            String pass = tf_pass.getText();
            try {
                Scanner sc = new Scanner(new File("files\\users.txt"));
                while (sc.hasNext()) {
                    String[] user = sc.nextLine().split("  ");
                    if (username.equalsIgnoreCase(user[0]) && pass.equals(user[1])) {
                        optionScreen(primaryStage);
                        break;
                    } else {
                        label_error.setText("Wrong Username or Password");
                    }
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        });

        btn_exit.setOnAction(event -> {
            primaryStage.close();
        });

        root.add(label_wel, 0, 0);
        root.add(userBox, 0, 1);
        root.add(passBox, 0, 2);
        root.add(label_error, 0, 4);
        root.add(btns, 0, 3);

        GridPane.setHalignment(userBox, HPos.CENTER);
        GridPane.setHalignment(passBox, HPos.CENTER);
        GridPane.setHalignment(btns, HPos.RIGHT);

        btn_add_std.setOnAction(event -> {
            add_screen(primaryStage);
        });

        primaryStage.setTitle("Login Page");
        Scene scene = new Scene(root, 800, 600);

        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void optionScreen(Stage stage) {
        stage.setTitle("Option Page");
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(20);
        Scene scene = new Scene(gp, 800, 600);
        gp.add(btn_add_std, 0, 4);
        gp.add(btn_view_std, 0, 5);
        GridPane.setHalignment(btn_add_std, HPos.CENTER);
        GridPane.setHalignment(btn_view_std, HPos.CENTER);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
    }

    private void add_screen(Stage stage) {
        ArrayList<Student> students = new ArrayList<>();

        stage.setTitle("Student Entry Page");

        VBox form = new VBox(10);
        Label label_std = new Label("Student Data");
        label_std.setStyle("-fx-font-size: 20");
        Label label_id = new Label("Id:");
        Label label_name = new Label("Name:");
        Label label_major = new Label("Major:");
        Label label_grade = new Label("Grade:");

        TextField tf_id = new TextField();
        TextField tf_name = new TextField();
        TextField tf_major = new TextField();
        TextField tf_grade = new TextField();

        HBox box_id = new HBox(32, label_id, tf_id);
        HBox box_name = new HBox(10, label_name, tf_name);
        HBox box_major = new HBox(10, label_major, tf_major);
        HBox box_grade = new HBox(10, label_grade, tf_grade);

        Button add_btn = new Button("Add");
        Button reset_btn = new Button("Reset");
        Button exit_btn = new Button("Exit");
        HBox box_btns = new HBox(10, add_btn, reset_btn, exit_btn);
        Label error = new Label();

        ListView<Student> student_list_view = new ListView<>(FXCollections.observableList(students));

        student_list_view.setCellFactory(new Callback<ListView<Student>, ListCell<Student>>() {
            @Override
            public ListCell<Student> call(ListView<Student> param) {
                return new StudentCellController();
            }
        });

        student_list_view.setMinWidth(400);
        student_list_view.setMaxHeight(400);

        Button stds_info = new Button("Students Info Using Lambda");
        stds_info.setOnAction(event -> {
            try {
                Stage stage1 = new Stage();
                FXMLLoader mLLoader = new FXMLLoader(getClass().getResource("std_Info.fxml"));
                Std_InfoController controller = new Std_InfoController(student_list_view.getItems());
                mLLoader.setController(controller);
                Scene scene = new Scene(mLLoader.load(), 800, 600);
                scene.getStylesheets().add("style.css");
                stage1.setTitle("Student Info");
                stage1.setScene(scene);
                stage1.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
        HBox lambda_queries = new HBox(stds_info);
        lambda_queries.setAlignment(Pos.BASELINE_RIGHT);

        add_btn.setOnAction(event -> {
            if (!isEmpty(tf_id)) {
                if (!isEmpty(tf_name)) {
                    if (!isEmpty(tf_major)) {
                        if (!isEmpty(tf_grade)) {
                            Student student = new Student(Integer.parseInt(tf_id.getText()),
                                    tf_name.getText(), tf_major.getText(), Math.round(Double.parseDouble(tf_grade.getText()) * 100) / 100.0);
                            student_list_view.getItems().add(student);

                            student_list_view.getItems().setAll(
                                    student_list_view.getItems().stream()
                                            .sorted()
                                            .collect(Collectors.toList())
                            );

                        } else {
                            error.setText("Please Fill Grade Field !");
                        }
                    } else {
                        error.setText("Please Fill Major Field !");
                    }
                } else {
                    error.setText("Please Fill Name Field !");
                }
            } else {
                error.setText("Please Fill ID Field !");
            }
        });

        reset_btn.setOnAction(event -> {
            tf_id.clear();
            tf_name.clear();
            tf_major.clear();
            tf_grade.clear();
        });

        exit_btn.setOnAction(event -> {
            optionScreen(stage);
        });

        box_btns.setAlignment(Pos.BASELINE_RIGHT);
        form.getChildren().addAll(label_std, box_id, box_name, box_major, box_grade, error, box_btns, lambda_queries);

        HBox root = new HBox(30, form, student_list_view);
        root.setPadding(new Insets(50, 20, 50, 60));

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
    }

    private boolean isEmpty(TextField field) {
        return field.getText().trim().equals("");
    }

}
