package it.unicas.view;
import it.unicas.MainApp;
import it.unicas.model.Prodotto;
import it.unicas.model.dao.DAOException;
import it.unicas.model.dao.mysql.ProdottoDAOMySQLImpl;
import javafx.fxml.FXML;

import javafx.scene.control.*;

import java.sql.SQLException;
import java.util.List;

public class AdminOverviewController2 {

    @FXML
    private TextField nome_prod;
    @FXML
    private TextField tipo_prod;
    @FXML
    private TextField prezzo;
    @FXML
    private TextField locazione;
    @FXML
    private CheckBox alcolico ;
    @FXML
    private Spinner spinner;
    @FXML
    private TableView<Prodotto> prodottiTableView;
    @FXML
    private TableColumn<Prodotto, String> nomeColumn;
    @FXML
    private TableColumn<Prodotto, Float> prezzoColumn;

    private MainApp mainApp;


    public AdminOverviewController2(){
    }


    @FXML
    private void initialize(){

        //inizializzo il comboBox menu

        prodottiTableView.setPlaceholder(new Label("Lista Prodotti"));

        //inizializzo la tabella ordineTableView con la colonna nomecolumn
        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nome_prodottoProperty());
        prezzoColumn.setCellValueFactory(cellData -> cellData.getValue().prezzo_prodottoProperty().asObject());

    }



    public void setMainApp(MainApp mainApp) {

        this.mainApp = mainApp;
        //  La tabella si è iscritta
        // sull'observableList prodottoData
        prodottiTableView.setItems(mainApp.getProdottoData());

    }


    @FXML
    private void AddTavolo() {
        String LocTav = locazione.getText();
        int Spin = (int) spinner.getValue();

        Alert mes = new Alert(Alert.AlertType.INFORMATION);
        if (( LocTav.equals("interno") || LocTav.equals("esterno") || LocTav.equals("bancone")) && Spin > 0) {

            mes.setContentText("Numero Tavoli aggiunti in "+ LocTav + " sono " + Spin);
            mes.setTitle("Caricamento effettuato");
            mes.show();

        }
    }


    @FXML
    private void RimTavolo() {
        String LocTav = locazione.getText();
        int Spin = (int) spinner.getValue();

        Alert mes = new Alert(Alert.AlertType.INFORMATION);
        if (( LocTav.equals("interno") || LocTav.equals("esterno") || LocTav.equals("bancone")) && Spin > 0) {

            mes.setContentText("Numero Tavoli rimossi da "+ LocTav + " sono " + Spin);
            mes.setTitle("Caricamento effettuato");
            mes.show();

        }
    }


    @FXML
    private void rimuoviButtonMenu() {

        int selected_index = prodottiTableView.getSelectionModel().getSelectedIndex();

        Alert mes = new Alert(Alert.AlertType.INFORMATION);
        if(selected_index == -1){
            mes.setContentText("Selezionare una riga della Tabella Prodotti");
            mes.setTitle("Errore");
            mes.show();

        }
        else{
            //vedere primaryStage e Query
        }

    }

    @FXML
    private void aggiungiButtonMenu() {

        Alert mes = new Alert(Alert.AlertType.INFORMATION);

        String nomeProd = nome_prod.getText();
        String tipoProd = tipo_prod.getText();
        String prezzoProd = prezzo.getText();
        Boolean Alcool = alcolico.isSelected();
        //int prezzoProd = Integer.parseInt(prezzo.getText());

        if(nomeProd.length() != 0 && tipoProd.length() != 0 && prezzoProd.length() != 0){


            mes.setContentText("Premere 'Carica' per aggiornare la lista");
            mes.setTitle("Inserimento prodotto effettuato");
            mes.show();

            //FARE LA QUERY

        }

        else{
            mes.setContentText("Completare tutti i campi di 'Aggiungi prodotto'!");
            mes.setTitle("Errore");
            mes.show();

        }




    }


    @FXML
    private void caricaBut() {
        Prodotto temp = new Prodotto(0, "", "", true, .0f);
        List<Prodotto> list = null;
        try {
            System.out.println(mainApp);
            list = ProdottoDAOMySQLImpl.getInstance().select(temp);
            mainApp.getProdottoData().clear();
            mainApp.getProdottoData().addAll(list);

        } catch (DAOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
