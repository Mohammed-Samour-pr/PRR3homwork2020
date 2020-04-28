package Chapter3homworkpart2.Q4;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

/**
 * StudentCell Controller class
 *
 * @author 
 */
public class StudentCellController extends ListCell<Student> {

    private FXMLLoader mLLoader;

    @FXML
    private Label c_la_id;
    @FXML
    private Label c_la_name;
    @FXML
    private Label c_la_major;
    @FXML
    private Label c_la_grade;
    @FXML
    private AnchorPane cell_root;

    @Override
    protected void updateItem(Student student, boolean empty) {
        super.updateItem(student, empty);

        if (student == null || empty) {
            setText(null);
            setGraphic(null);
        } else {
            
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("StudentCell.fxml"));
                mLLoader.setController(this);
                try {
                    cell_root = mLLoader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            c_la_id.setStyle("-fx-font-weight: normal;-fx-font-size: 12;");
            c_la_id.setText("" + student.getId());
            
            c_la_name.setStyle("-fx-font-weight: normal;-fx-font-size: 12;");
            c_la_name.setText(student.getName() + "");
            
            c_la_major.setStyle("-fx-font-weight: normal;-fx-font-size: 12;");
            c_la_major.setText(student.getMajor() + "");
            
            c_la_grade.setStyle("-fx-font-weight: normal;-fx-font-size: 12;");
            c_la_grade.setText(student.getGrade() + "");

            setText(null);
            setGraphic(cell_root);
        }

    }

}
