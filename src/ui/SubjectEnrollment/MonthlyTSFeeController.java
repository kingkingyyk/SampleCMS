package ui.SubjectEnrollment;

import com.kingkingyyk.SampleCMS;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.util.converter.DoubleStringConverter;
import model.People.Teacher;
import model.SubjectEnrollment.MonthlyTSFee;
import model.SubjectEnrollment.TeacherSubject;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.net.URL;
import java.util.ResourceBundle;

public class MonthlyTSFeeController implements Initializable{
    public static MonthlyTSFeeController ctrl=new MonthlyTSFeeController();

    @FXML private TreeTableView ttblTSMonth;
    @FXML private TreeTableColumn<Teacher, String> ttblcolTeacher;
    @FXML private TreeTableColumn<MonthlyTSFee, String> ttblcolYear;
    @FXML private TreeTableColumn<MonthlyTSFee, String> ttblcolMonth;
    @FXML private TreeTableColumn<MonthlyTSFee, Double> ttblcolFee;
    @FXML private TreeTableColumn<MonthlyTSFee, Double> ttblcolCommision;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        CriteriaBuilder cb= SampleCMS.session.getCriteriaBuilder();
        CriteriaQuery<Teacher> criteria = cb.createQuery(Teacher.class);
        Root<Teacher> teacherRoot=criteria.from(Teacher.class);
        criteria.select(teacherRoot);

        //criteria.where(cb.like(cb.lower(humanRoot.get("name")), username));
        ttblcolTeacher.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));

        ttblcolFee.setCellValueFactory(new TreeItemPropertyValueFactory<>("fee"));
        ttblcolFee.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn(new DoubleStringConverter()));
        ttblcolFee.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<MonthlyTSFee, Double>>() {

            @Override
            public void handle(TreeTableColumn.CellEditEvent<MonthlyTSFee, Double> event) {
                MonthlyTSFee mTSFee = event.getRowValue().getValue();
                Double newFee = event.getNewValue();
                mTSFee.setFee(newFee);
                HibernateUtils.saveOrUpdate(mTSFee);
            }
        });



        ttblcolCommision.setCellValueFactory(new TreeItemPropertyValueFactory<>("commision"));
        ttblcolMonth.setCellValueFactory( cellData -> {
            TreeItem<MonthlyTSFee> rowItem = cellData.getValue();
            if (rowItem != null && (rowItem.getValue() instanceof MonthlyTSFee)) {
                MonthlyTSFee f = rowItem.getValue() ;
                return new SimpleStringProperty(f.getMonth().getMonth());
            }else {
                return new SimpleStringProperty("");
            }
        });
        ttblcolYear.setCellValueFactory( cellData -> {
            TreeItem<MonthlyTSFee> rowItem = cellData.getValue();
            if (rowItem != null && (rowItem.getValue() instanceof MonthlyTSFee)) {
                MonthlyTSFee f = rowItem.getValue() ;
                return new SimpleStringProperty(f.getMonth().getYear());
            }else {
                return new SimpleStringProperty("");
            }
        });

        for(Teacher teacher : SampleCMS.session.createQuery(criteria).getResultList())
        {

            TreeItem<Object> itemTeacher = new TreeItem<>(teacher);
            ttblTSMonth.setRoot(itemTeacher);
            //itemTeacher.getChildren().add(itemTeacher);
            for(TeacherSubject ts : teacher.getTeacherSubjects()){
                TreeItem<Object> itemSubject = new TreeItem<>(ts.getSubject());
                itemTeacher.getChildren().add(itemSubject);

                for(MonthlyTSFee mTSFee : ts.getMonthlyTSFees()){
                    TreeItem<Object> itemTSFee = new TreeItem<>(mTSFee);
                    //TreeItem<Object> itemTSFeeMonth = new TreeItem<>(mTSFee.getMonth());
                    itemSubject.getChildren().add(itemTSFee);
                    //itemSubject.getChildren().add(itemTSFeeMonth);
                }
            }

        }

    }

}
