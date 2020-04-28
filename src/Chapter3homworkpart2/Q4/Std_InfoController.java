/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter3homworkpart2.Q4;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;

/**
 * FXML Controller class
 *
 * @author B
 */
public class Std_InfoController implements Initializable {

    private ObservableList<Student> list;
    @FXML
    private FlowPane pane;
    @FXML
    private TextArea textArea;
    @FXML
    private Button sort_name;
    @FXML
    private Button sort_name_grade;
    @FXML
    private Button sort_name_grade_2;
    @FXML
    private Button calc_avg;
    @FXML
    private Button group_by_major;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sort_name.setOnAction(this::sort_by_name);
        sort_name_grade.setOnAction(this::sort_by_name_grade);
        sort_name_grade_2.setOnAction(this::sort_by_name_grade_2);
        calc_avg.setOnAction(this::calc_avg);
        group_by_major.setOnAction(this::group_by_major);
    }

    public Std_InfoController(ObservableList<Student> list) {
        this.list = list;
    }

    @FXML
    private void sort_by_name(ActionEvent event) {
        textArea.setText("");
        list.stream().sorted(
                Comparator.comparing(s -> s.getName())).collect(Collectors.toList())
                .forEach(s -> textArea.appendText(s.toString() + "\n"));
    }

    @FXML
    private void sort_by_name_grade(ActionEvent event) {
        textArea.setText("");
        list.stream().sorted(
                Comparator
                        .comparing(Student::getName)
                        .thenComparing(Student::getGrade)).collect(Collectors.toList())
                .forEach(s -> textArea.appendText(s.toString() + "\n"));
    }

    @FXML
    private void sort_by_name_grade_2(ActionEvent event) {
        textArea.setText("");
        list.stream()
                .filter(s -> s.getGrade() >= 80 && s.getGrade() <= 90)
                .sorted(Comparator
                        .comparing(Student::getName)
                        .thenComparing(Student::getGrade))
                .collect(Collectors.toList())
                .forEach(s -> textArea.appendText(s.toString() + "\n"));
    }

    @FXML
    private void calc_avg(ActionEvent event) {
        double average
                = list.stream().mapToDouble(s -> s.getGrade())
                        .average().getAsDouble();
        textArea.setText("Average: " + Math.round(average * 100) / 100.00);
    }

    @FXML
    private void group_by_major(ActionEvent event) {
        textArea.setText("");
        list.stream()
                .collect(Collectors.groupingBy(Student::getMajor))
                .forEach((major, std_major) -> {
                    textArea.appendText("\n\n"+major + "\n" + "----------------------------\n");
                    std_major.forEach(s -> textArea.appendText("\n" + s.toString()));
                });
    }
}
