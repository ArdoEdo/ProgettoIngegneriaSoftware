package it.unicas.view;

import it.unicas.MainApp;
import javafx.fxml.FXML;

import javafx.scene.control.*;
public class AdminOverviewController {

    @FXML
    private TextField UserName;
    @FXML
    private TextField PassWord;
    @FXML
    private Button Login;


    private MainApp mainApp;


    public TextField getUserName() {
        return UserName;
    }

    public void setUserName(TextField userName) {
        UserName = userName;
    }

    public void login() {
        String userName = UserName.getText();
        String passWord = PassWord.getText();

        Alert mes = new Alert(Alert.AlertType.INFORMATION);
        if(userName.equals("admin") && passWord.equals("admin1234")){
            mes.setContentText("Benveuto " + userName);
            mes.setTitle("WELCOME");
            mes.show();

        }

        else{
            mes.setContentText("username e password errati!");
            mes.setTitle("Errore");
            mes.show();

        }


    }



}
