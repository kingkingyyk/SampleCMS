package ui.SubjectEnrollment;

import com.kingkingyyk.SampleCMS;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.People.Teacher;
import model.SubjectEnrollment.Subject;
import model.SubjectEnrollment.TeacherSubject;
import org.hibernate.Criteria;
import utils.AutoCompleteComboBoxListener;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherSubjectController implements Initializable{
    public static TeacherSubjectController ctrl=new TeacherSubjectController();
    @FXML private ComboBox<Teacher> cbSearchTeacher;
    @FXML private ListView<Subject> lstSubject;
    @FXML private ListView<TeacherSubject> lstTeacherSubject;
    @FXML private Button btnAddSubject;
    @FXML private Button btnRemoveSubject;

    private ObservableList subjectList;
    private Teacher lastTeacher;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        CriteriaBuilder cb = SampleCMS.session.getCriteriaBuilder();
        CriteriaQuery<Teacher> criteria = cb.createQuery(Teacher.class);
        Root<Teacher> teacherRoot = criteria.from(Teacher.class);
        criteria.select(teacherRoot);

        for (Teacher teacher : SampleCMS.session.createQuery(criteria).getResultList()) {
            //System.out.println(human.getName());
            cbSearchTeacher.getItems().add(teacher);
        }

        CriteriaQuery<Subject> criteria2 = cb.createQuery(Subject.class);
        Root<Subject> subjectRoot = criteria2.from(Subject.class);
        criteria2.select(subjectRoot);
        subjectList.addAll(SampleCMS.session.createQuery(criteria2).getResultList());


        new AutoCompleteComboBoxListener<>(cbSearchTeacher);
    }

    @FXML
    private void onCbSearchTeacherSelected(){
        if(cbSearchTeacher.getValue() instanceof Teacher){
            lastTeacher = cbSearchTeacher.getValue();
        }

        if(lastTeacher!=null) {
            System.out.println(lastTeacher.getName());
            System.out.println(cbSearchTeacher.getEditor().getText());
            if (lastTeacher.getName().equals(cbSearchTeacher.getEditor().getText())) {
                lstTeacherSubject.getItems().clear();

                for(TeacherSubject ts : lastTeacher.getTeacherSubjects()){
                    lstTeacherSubject.getItems().add(ts);
                }
            }
        }
    }

    @FXML
    private void onBtnRemoveSubjectClicked(){

    }

    @FXML
    private void onBtnAddSubjectClicked(){
        Teacher currentTeacher = cbSearchTeacher.getSelectionModel().getSelectedItem();

        //currentTeacher.setTeacherSubjects();
        //Criteria criteria = SampleCMS.session.createQuery();
        //lstSubject.getSelectionModel().getSelectedItems()

    }
}
