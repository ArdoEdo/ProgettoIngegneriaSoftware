package it.unicas.view;

import it.unicas.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class RootLayoutController {
    private MainApp mainApp;
    @FXML
    private Tab barTab;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    private void handleExit() {

        //mainApp.handleExit();

    }

}
