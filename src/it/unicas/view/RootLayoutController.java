package it.unicas.view;

import it.unicas.MainApp;
import it.unicas.model.Prodotto;
import it.unicas.model.dao.DAOException;
import it.unicas.model.dao.mysql.DAOMySQLSettings;
import it.unicas.model.dao.mysql.ProdottoDAOMySQLImpl;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.sql.SQLException;
import java.util.List;

public class RootLayoutController {
    // Reference to the main application
    @FXML
    private TableView<Prodotto> prodottoTableView;
    @FXML
    private TableColumn<Prodotto, String> nomeColumn;
    @FXML
    private TableColumn<Prodotto, Float> prezzoColumn;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        prodottoTableView.setItems(mainApp.getProdottoData());
    }

    public RootLayoutController(){};
    @FXML
    private void initialize(){
        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nome_prodottoProperty());
        /*prezzoColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prodotto, Float>, ObservableValue<Float>>() {
            public ObservableValue<Float> call(TableColumn.CellDataFeatures<Prodotto, Float> p) {
                // p.getValue() returns the Person instance for a particular TableView row
                return p.getValue().prezzo_prodottoProperty();
            }
        });*/
        Prodotto prodotto = new Prodotto();
        try {
            List<Prodotto> list = ProdottoDAOMySQLImpl.getInstance().select(prodotto);
            mainApp.getProdottoData().clear();
            mainApp.getProdottoData().addAll(list);
        } catch (DAOException | SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Error during DB interaction");
            alert.setHeaderText("Error during search ...");
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }





    }



}
