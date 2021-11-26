package it.unicas.view;

import it.unicas.MainApp;
import javafx.fxml.FXML;


public class RootLayoutController {

    // Reference to the main application
    private MainApp mainApp;



    public void setMainApp(MainApp mainApp){
        System.out.println("Ho segnato il valore della MainApp RootLayC");
        this.mainApp = mainApp;

    }


    @FXML
    private void handleShowCucina(){
        mainApp.showCucinaOverview();


    }

    @FXML
    private void handleShowOrdine(){
       mainApp.showOrdineOverview();


    }

    @FXML
    private void handleShowBar(){
        mainApp.showBarOverview();


    }
    @FXML
    private void handleShowCassa(){
        mainApp.showCassaOverview();

    }

    @FXML
    private void handleShowAdmin(){
        mainApp.showAdminOverview();

    }






}
