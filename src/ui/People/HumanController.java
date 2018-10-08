package ui.People;

import com.kingkingyyk.SampleCMS;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.People.Human;
import utils.AutoCompleteComboBoxListener;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.net.URL;
import java.util.ResourceBundle;

public class HumanController implements Initializable {
    public static HumanController ctrl=new HumanController();

    @FXML private Button btnSearch;
    @FXML private TextField tfUser;
    @FXML private ComboBox cbUserType;
    @FXML private ComboBox cbSearchUser;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cbUserType.getItems().addAll("Staff", "Teacher", "Student");

        //String username = cbSearchUser.getEditor().getCharacters().toString();
        //username = "%" + username.toLowerCase() + "%";
        CriteriaBuilder cb = SampleCMS.session.getCriteriaBuilder();
        CriteriaQuery<Human> criteria = cb.createQuery(Human.class);
        Root<Human> humanRoot = criteria.from(Human.class);
        criteria.select(humanRoot);

        for (Human human : SampleCMS.session.createQuery(criteria).getResultList()) {
            //System.out.println(human.getName());
            cbSearchUser.getItems().add(human);
        }
        new AutoCompleteComboBoxListener<>(cbSearchUser);
        /*
        cbSearchUser.getEditor().setOnKeyTyped((event) -> onSearchUser(event));
        cbSearchUser.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue==null) {
                cbSearchUser.valueProperty().set(oldValue);
                cbSearchUser.hide();
            }
        });
        */
    }

    @FXML
    private void onSearchClicked() {
        String username = tfUser.getText();
        if(username.length() != 0){

            username = "%" + username.toLowerCase() + "%";
            CriteriaBuilder cb= SampleCMS.session.getCriteriaBuilder();
            CriteriaQuery<Human> criteria = cb.createQuery(Human.class);
            Root<Human> humanRoot=criteria.from(Human.class);
            criteria.select(humanRoot);
            criteria.where(cb.like(cb.lower(humanRoot.get("name")), username));


            for(Human human : SampleCMS.session.createQuery(criteria).getResultList())
            {
                System.out.println(human.getName());
            }
        }

    }

    @FXML
    private void onResetClicked(){
    }

    @FXML void onApplyClicked(){
    }
/*
    private void onSearchUser(KeyEvent e)
    {
        KeyCode keyCode = e.getCode();
        if (cbSearchUser.getEditor().getText().length()>0) {
            if(keyCode.equals(KeyCode.ENTER))
            {
                if (cbSearchUser.isShowing()) cbSearchUser.getSelectionModel().select(0);
                //cbSearchUser.getSelectionModel().getSelectedItem()
                onCbSearchUserSelect();
                //cbSearchUser.show();
                //cbSearchUser.getSelectionModel().select(cbSearchUser.getSelectionModel().getSelectedIndex());
            }
            else {
                String username = cbSearchUser.getEditor().getCharacters().toString();
                username = "%" + username.toLowerCase() + "%";
                CriteriaBuilder cb = SampleCMS.session.getCriteriaBuilder();
                CriteriaQuery<Human> criteria = cb.createQuery(Human.class);
                Root<Human> humanRoot = criteria.from(Human.class);
                criteria.select(humanRoot);
                criteria.where(cb.like(cb.lower(humanRoot.get("name")), username));

                //System.out.print(username);
                cbSearchUser.getItems().clear();
                for (Human human : SampleCMS.session.createQuery(criteria).getResultList()) {
                    //System.out.println(human.getName());
                    cbSearchUser.getItems().add(human);
                }

                cbSearchUser.show();
            }
        }

    }

    @FXML
    private void onCbSearchUserSelect(){
        System.out.println(cbSearchUser.getEditor().getSelectedText());
        //if cbSearchUser.getSelectionModel().getSelectedItem().toString()
    }
    */
}
