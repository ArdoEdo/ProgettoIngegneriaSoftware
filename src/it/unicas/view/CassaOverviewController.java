package it.unicas.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;


public class CassaOverviewController {

    @FXML
    private ComboBox comboBox;



    @FXML
    private void initialize(){
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("Bancone","Interno","Esterno");
        //comboBox.getSelectionModel().select("Interno");


    }







}
