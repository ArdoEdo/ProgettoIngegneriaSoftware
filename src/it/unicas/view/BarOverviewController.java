package it.unicas.view;

import it.unicas.MainApp;
import it.unicas.model.Ordine;
import it.unicas.model.ProdottiOrdinati;
import it.unicas.model.Prodotto;
import it.unicas.model.dao.DAOException;
import it.unicas.model.dao.mysql.ProdottiOrdinatiDAOMySQLImpl;
import it.unicas.model.dao.mysql.ProdottoDAOMySQLImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.util.List;

public class BarOverviewController {

    @FXML
    private TableView<ProdottiOrdinati> barTableView;
    @FXML
    private TableColumn<ProdottiOrdinati, String> nomeColumn;
    @FXML
    private TableColumn<ProdottiOrdinati, Integer> quantitaColumn;
    @FXML
    private TableColumn<ProdottiOrdinati, Integer> numeroTavoloColumn;
    @FXML
    private Button preparatoButton;


    private MainApp mainApp;
    public BarOverviewController(){}

    @FXML
    private void initialize(){

        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nome_prodottoProperty());
        quantitaColumn.setCellValueFactory(cellData-> cellData.getValue().quantita_prodotto_orProperty().asObject());
        numeroTavoloColumn.setCellValueFactory(cellData-> cellData.getValue().tavolo_numero_tavoloProperty().asObject());

        barTableView.setPlaceholder(new Label("Non ci sono ordini"));
    }

    public void setMainApp(MainApp mainApp) {

        this.mainApp = mainApp;
        barTableView.setItems(mainApp.getProdottiOrdinatiData());
        caricaOrdineBar();

    }

    @FXML
    private void caricaOrdineBar() {
        ProdottiOrdinati tempProdottiOrdinati = new ProdottiOrdinati();
        tempProdottiOrdinati.setTipo_prodotto("bevanda");
        System.out.println(tempProdottiOrdinati.getTipo_prodotto());
        //caricaButton.setDisable(true);
        List<ProdottiOrdinati> list = null;
        try {

            list = ProdottiOrdinatiDAOMySQLImpl.getInstance().join(tempProdottiOrdinati);
            mainApp.getProdottiOrdinatiData().clear();
            mainApp.getProdottiOrdinatiData().addAll(list);
            System.out.println(list);

        } catch (DAOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(list.size()>0){
            preparatoButton.setDisable(false);
        }

    }

    @FXML
    private void preparatoButtonPressed(){
        int selected_index = barTableView.getSelectionModel().getSelectedIndex();
        ProdottiOrdinati tempProdottiOrdinati = new ProdottiOrdinati();
        if(selected_index != -1) {
            tempProdottiOrdinati.setId_ordine(mainApp.getProdottiOrdinatiData().get(selected_index).getId_ordine());
            try {

                ProdottiOrdinatiDAOMySQLImpl.getInstance().update(tempProdottiOrdinati);
                //System.out.println(list);

            } catch (DAOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            barTableView.getItems().remove(selected_index);

        }
        if(barTableView.getItems().size()==0)
            barTableView.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("ORDINE PREPARATO!");
        alert.setHeaderText("L'ordine è stato preparato.");
        //alert.setContentText("Ora è possibile effettuare un nuovo ordine");

        alert.showAndWait();
    }


}
