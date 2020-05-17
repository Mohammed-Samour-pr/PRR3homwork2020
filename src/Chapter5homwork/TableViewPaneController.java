/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5homwork;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
    private EntityManagerFactory emf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcmajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcgerade.setCellValueFactory(new PropertyValueFactory("grade"));
        this.emf = Persistence.createEntityManagerFactory("Chapter4PU2");
        EntityManager em = emf.createEntityManager();
        List<Student> std = em.createNamedQuery("Student.findall").getResultList();
        tableView.getItems().setAll(std);
        tableView.getSelectionModel().selectedItemProperty().addListener(
                event -> showSelectedStudent()
        );

    }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws SQLException {
        Student std = new Student(Integer.parseInt(txtFieldID.getText()), txtFieldName.getText(),
                txtFieldmajor.getText(),
                Double.parseDouble(txtFieldgrade.getText()));
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(std);
        em.getTransaction().commit();
        em.close();
        tableView.getItems().clear();
        referachTable();
    }

    @FXML
    private void buttonUpdateHandle(ActionEvent event) throws SQLException {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("update Student s set s.name= :name,s.major= :major,s.grade= :grade where s.id= :id");
        query.setParameter("id", Integer.parseInt(txtFieldID.getText()))
                .setParameter("name", txtFieldName.getText())
                .setParameter("major", txtFieldmajor.getText())
                .setParameter("grade", Double.parseDouble(txtFieldgrade.getText()));
        query.executeUpdate();
        em.getTransaction().commit();
        tableView.getItems().clear();
        referachTable();
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) throws SQLException {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("Delete from Student s where s.id= :id");
        query.setParameter("id", Integer.parseInt(txtFieldID.getText()));
        query.executeUpdate();
        em.getTransaction().commit();
        tableView.getItems().clear();
        referachTable();
    }

    public void referachTable() {
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcmajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcgerade.setCellValueFactory(new PropertyValueFactory("grade"));
        this.emf = Persistence.createEntityManagerFactory("Chapter4PU2");
        EntityManager em = emf.createEntityManager();
        List<Student> std = em.createNamedQuery("Student.findall").getResultList();
        tableView.getItems().setAll(std);

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
