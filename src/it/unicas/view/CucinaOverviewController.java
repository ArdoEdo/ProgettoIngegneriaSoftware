package it.unicas.view;

import it.unicas.MainApp;
import it.unicas.model.ProdottiOrdinati;
import it.unicas.model.dao.DAOException;
import it.unicas.model.dao.mysql.ProdottiOrdinatiDAOMySQLImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;
import java.util.List;

public class CucinaOverviewController {

    @FXML
    private TableView<ProdottiOrdinati> cucinaTableView;
    @FXML
    private TableColumn<ProdottiOrdinati, String> nomeColumn;
    @FXML
    private TableColumn<ProdottiOrdinati, Integer> quantitaColumn;
    @FXML
    private TableColumn<ProdottiOrdinati, Integer> numeroTavoloColumn;
    @FXML
    private Button preparatoButton;


    private MainApp mainApp;
    public CucinaOverviewController(){}

    @FXML
    private void initialize(){

        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nome_prodottoProperty());
        quantitaColumn.setCellValueFactory(cellData-> cellData.getValue().quantita_prodotto_orProperty().asObject());
        numeroTavoloColumn.setCellValueFactory(cellData-> cellData.getValue().tavolo_numero_tavoloProperty().asObject());

    }

    public void setMainApp(MainApp mainApp) {

        this.mainApp = mainApp;
        cucinaTableView.setItems(mainApp.getProdottiOrdinatiData());
        caricaOrdineCucina();

    }

    @FXML
    private void caricaOrdineCucina() {

        ProdottiOrdinati tempProdottiOrdinati = new ProdottiOrdinati();
        tempProdottiOrdinati.setTipo_prodotto("snack");
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
        int selected_index = cucinaTableView.getSelectionModel().getSelectedIndex();
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

            cucinaTableView.getItems().remove(selected_index);

        }
        if(cucinaTableView.getItems().size()==0)
            cucinaTableView.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("ORDINE PREPARATO!");
        alert.setHeaderText("L'ordine è stato preparato.");
        //alert.setContentText("Ora è possibile effettuare un nuovo ordine");

        alert.showAndWait();
    }






}
