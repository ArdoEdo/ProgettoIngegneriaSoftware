package it.unicas;

import it.unicas.model.Prodotto;
import it.unicas.view.RootLayoutController;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MainApp extends Application {
    private Stage primaryStage;
    public MainApp(){}

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Pub App");
        initRootLayout();
        //showProdottoOverview();
        this.primaryStage.show();
    }

    ;
    private ObservableList<Prodotto> prodottoData= FXCollections.observableArrayList();
    private ObservableList<Prodotto> getProdottoData(){return prodottoData;};
    private AnchorPane rootLayout;

    public void initRootLayout()  {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            primaryStage.setOnCloseRequest(event -> {
                event.consume();
                handleExit();
            });


            // Give the controller access to the main app.
           /* RootLayoutController controller = loader.getController();
            controller.setMainApp(this);*/



        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void handleExit() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Are you sure?");
        alert.setHeaderText("Exit");
        alert.setContentText("Exit from application.");

        ButtonType buttonTypeOne = new ButtonType("Yes");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            System.exit(0);
        }

    }


    public static void main(String[] args) {
        launch(args);
	// write your code here
    }


}
