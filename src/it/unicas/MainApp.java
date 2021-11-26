package it.unicas;

import it.unicas.model.Prodotto;
import it.unicas.model.Tavolo;
import it.unicas.view.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    /**
     * Lista osservabile di Prodotti
     */
    private ObservableList<Prodotto> prodottoData= FXCollections.observableArrayList();
    private ObservableList<Tavolo> tavoloData= FXCollections.observableArrayList();

    /**
     * Costruttore
     */
    public MainApp(){}

    public ObservableList<Prodotto> getProdottoData(){return prodottoData;}
    public ObservableList<Tavolo> getTavoloData(){return tavoloData;}


    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Pub App");
        initRootLayout();
        showOrdineOverview();

        this.primaryStage.show();

    }


    public void initRootLayout()  {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout=(BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            primaryStage.setOnCloseRequest(event -> {
                event.consume();
                handleExit();
            });

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            System.out.println(this.toString());
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


    public void showOrdineOverview() {


        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Ordine.fxml"));
           // AnchorPane anchorPane = (AnchorPane) loader.load();
            rootLayout.setCenter( loader.load());

            // Get controller and set the mainapp reference.
            OrdineOverviewController controller = loader.getController();
            controller.setMainApp(this);
           // return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            //return false;
        }
    }

    public void showCucinaOverview() {

        try {
            // Load the fxml file and create a new stage for the popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Cucina.fxml"));
            rootLayout.setCenter(loader.load());

            // Set the Colleghis into the controller.
            //CucinaOverviewController controller = loader.getController();
            //return controller.isOkClicked();


        } catch (IOException e) {
            e.printStackTrace();
            //return false;
        }

    }

    public void showBarOverview() {


        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Bar.fxml"));
            // AnchorPane anchorPane = (AnchorPane) loader.load();
            rootLayout.setCenter( loader.load());

            // Get controller and set the mainapp reference.
            BarOverviewController controller = loader.getController();
            //controller.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void showCassaOverview() {


        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Cassa.fxml"));
            // AnchorPane anchorPane = (AnchorPane) loader.load();
            rootLayout.setCenter( loader.load());

            // Get controller and set the mainapp reference.
            CassaOverviewController controller = loader.getController();
            //controller.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
	// write your code here
    }


}
