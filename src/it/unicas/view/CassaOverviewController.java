package it.unicas.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;


public class CassaOverviewController {

    @FXML
    private ComboBox comboBoxCucina;



    @FXML
    private void initialize(){
        comboBoxCucina.getItems().removeAll(comboBoxCucina.getItems());
        comboBoxCucina.getItems().addAll("Bancone","Interno","Esterno");
        //comboBox.getSelectionModel().select("Interno");


    }







}
