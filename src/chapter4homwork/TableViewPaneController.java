/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4homwork;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class TableViewPaneController implements Initializable {

    @FXML
    private TextField txtFieldID;
    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldmajor;
    @FXML
    private TextField txtFieldgrade;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, Integer> tcID;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student, String> tcmajor;
    @FXML
    private TableColumn<Student, Double> tcgerade;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonDelete;
    Statement statement;
    ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prr3", "root", "");
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcmajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcgerade.setCellValueFactory(new PropertyValueFactory("grade"));
        try {
            rs = this.statement.executeQuery("select * from student");
            while (rs.next()) {
                Student std = new Student();
                std.setId(rs.getInt("id"));
                std.setName(rs.getString("name"));
                std.setMajor(rs.getString("major"));
                std.setGrade(rs.getDouble("grade"));
                tableView.getItems().add(std);
            }
        } catch (SQLException ex) {
        }
        tableView.getSelectionModel().selectedItemProperty().addListener(
                event -> showSelectedStudent()
        );

    }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws SQLException {
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldmajor.getText();
        String grade = txtFieldgrade.getText();
        String sql = "Insert Into student values(" + id + ",'" + name + "','" + major + "'," + grade + ")";
        this.statement.executeUpdate(sql);
        tableView.getItems().clear();
        referachTable();
    }

    @FXML
    private void buttonUpdateHandle(ActionEvent event) throws SQLException {
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldmajor.getText();
        String grade = txtFieldgrade.getText();
        String sql = "Update Student Set name='" + name + "', major='"
                + major + "', grade=" + grade + " Where id=" + id;
        this.statement.executeUpdate(sql);
        tableView.getItems().clear();
        referachTable();
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) throws SQLException {
        Integer id = Integer.parseInt(txtFieldID.getText());
        String sql = "Delete from student where id=" + id;
        this.statement.executeUpdate(sql);
        tableView.getItems().clear();
        referachTable();

    }

    public void referachTable() {
        try {
            rs = this.statement.executeQuery("select * from student");
            while (rs.next()) {
                Student std = new Student();
                std.setId(rs.getInt("id"));
                std.setName(rs.getString("name"));
                std.setMajor(rs.getString("major"));
                std.setGrade(rs.getDouble("grade"));
                tableView.getItems().add(std);
            }
        } catch (SQLException ex) {
        }

    }

    private void showSelectedStudent() {
        Student student = tableView.getSelectionModel().getSelectedItem();
        if (student != null) {
            txtFieldID.setText(String.valueOf(student.getId()));
            txtFieldName.setText(student.getName());
            txtFieldmajor.setText(student.getMajor());
            txtFieldgrade.setText(String.valueOf(student.getGrade()));
        }

    }
}
