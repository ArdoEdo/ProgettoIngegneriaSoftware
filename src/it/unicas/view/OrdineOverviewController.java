package it.unicas.view;

import com.mysql.cj.xdevapi.Table;
import it.unicas.MainApp;
import it.unicas.model.Ordine;
import it.unicas.model.Prodotto;
import it.unicas.model.Tavolo;
import it.unicas.model.dao.DAOException;
import it.unicas.model.dao.mysql.ProdottoDAOMySQLImpl;
import it.unicas.model.dao.mysql.TavoloDAOMySQLImpl;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdineOverviewController {
    @FXML
    private TableView<Prodotto> ordineTableView;
    @FXML
    private TableView<Prodotto> riepilogoOrdine;
    @FXML
    private TableColumn<Prodotto, String> nomeColumn;
    @FXML
    private TableColumn<Prodotto, Float> prezzoColumn;
    @FXML
    private TableColumn<Prodotto, String> dxNomeColumn;
    @FXML
    private TableColumn<TableColumn,Integer> quantitaColumn;
    @FXML
    private ComboBox comboBoxLocazione;
    @FXML
    private ComboBox comboBoxTavolo;
    @FXML
    private Button caricaButton;
    @FXML
    private Button aggiungiButton;
    @FXML
    private Button rimuoviButton;
    @FXML
    private Button ordinaButton;


    boolean okClicked;


private MainApp mainApp;

//chiamata prima del metodo initialize
public OrdineOverviewController(){
}

//chiamata dopo il caricamento dell fxml
    @FXML
    private void initialize(){

    //inizializzo il comboBox menu
        comboBoxLocazione.getItems().clear();
        comboBoxLocazione.getItems().addAll("Bancone","Interno","Esterno");


        ordineTableView.setPlaceholder(new Label("Caricare il menu"));
        riepilogoOrdine.setPlaceholder(new Label("I prodotti aggiunti verranno visualizzati qui"));


        //inizializzo la tabella ordineTableView con la colonna nomecolumn
        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nome_prodottoProperty());
        dxNomeColumn.setCellValueFactory(cellData -> cellData.getValue().nome_prodottoProperty());
        prezzoColumn.setCellValueFactory(cellData -> cellData.getValue().prezzo_prodottoProperty().asObject());


    }

    public void setMainApp(MainApp mainApp) {

        this.mainApp = mainApp;

        //  La tabella si è iscritta
        // sull'observableList prodottoData
        ordineTableView.setItems(mainApp.getProdottoData());

}

@FXML
private void caricaMenu() {
    Prodotto tempProdotto = new Prodotto(0, "", "", true, .0f);

    caricaButton.setDisable(true);
    List<Prodotto> list = null;
    try {
        System.out.println(mainApp);
        list = ProdottoDAOMySQLImpl.getInstance().select(tempProdotto);
        mainApp.getProdottoData().clear();
        mainApp.getProdottoData().addAll(list);

    } catch (DAOException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    @FXML
    private void aggiungiButtonPressed() {
        SimpleIntegerProperty quantita= new SimpleIntegerProperty(1);
        int selected_index = ordineTableView.getSelectionModel().getSelectedIndex();

        quantitaColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TableColumn, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<TableColumn, Integer> tableColumnIntegerCellDataFeatures) {
                return quantita.asObject();
            }

        });

        //se selezioni un item effettua l'aggiunta
        if(selected_index!=-1) {
            riepilogoOrdine.getItems().add(ordineTableView.getItems().get(selected_index));

            if(riepilogoOrdine.getItems().size()>0 && comboBoxTavolo.getValue()!=null)
                ordinaButton.setDisable(false);

            /*  CONTROLLO PRESENZA DI PRODOTTI UGUALI
            FUNZIONANTE PERCHE' TOGLIE I DOPPIONI DALLA LISTA CORRETTAMENTE
            MANCANTE: MEDOTO INCREMENTO VALORE QUANTITA

            //quantita.set(1);
            int sizeRiepilogoOrdine = riepilogoOrdine.getItems().size();
            //System.out.println("Size riepilogo ordine:" + sizeRiepilogoOrdine);
            System.out.println(riepilogoOrdine.getItems().get(sizeRiepilogoOrdine - 1).getNome_prodotto());

            for( int i=0;i<sizeRiepilogoOrdine;++i)  {
                if (sizeRiepilogoOrdine > 1 && i!=sizeRiepilogoOrdine-1){
                    if (riepilogoOrdine.getItems().get(sizeRiepilogoOrdine - 1).getNome_prodotto() ==
                            riepilogoOrdine.getItems().get(i).getNome_prodotto()) {
                        riepilogoOrdine.getItems().remove(sizeRiepilogoOrdine - 1);
                        System.out.println(riepilogoOrdine.getColumns().get(1).getCellData(i));
                        break;
                    }}
            }*/
        }
    }

    @FXML
    private void rimuoviButtonPressed(){

        int selected_index = riepilogoOrdine.getSelectionModel().getSelectedIndex();
        if(selected_index!=-1)
            riepilogoOrdine.getItems().remove(selected_index);
        if(riepilogoOrdine.getItems().size()==0)
            ordinaButton.setDisable(true);
    }

    @FXML
    private void locazioneSelected(){

        List<Tavolo> list = null;
        Tavolo tavolo = new Tavolo(null, false, comboBoxLocazione.getValue().toString());
        try {
            System.out.println(mainApp);
            list = TavoloDAOMySQLImpl.getInstance().select(tavolo);
            mainApp.getTavoloData().clear();
            mainApp.getTavoloData().addAll(list);
            System.out.println(comboBoxLocazione.getValue().toString());
            System.out.println(list);
            comboBoxTavolo.getItems().clear();
            for( int i = 0; i<list.size(); i++) {
                comboBoxTavolo.getItems().add(list.get(i).getNumero_tavolo());
            }

        } catch (DAOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        comboBoxTavolo.setDisable(false);

    }

    @FXML
    private void tavoloSelected(){

    if (riepilogoOrdine.getItems().size()>0)
    ordinaButton.setDisable(false);


}

    @FXML
    private void inviaOrdine(){
        if(comboBoxLocazione.getSelectionModel().toString()=="Interno"
                && Integer.parseInt(comboBoxTavolo.getSelectionModel().toString())>0 &&
                Integer.parseInt(comboBoxTavolo.getSelectionModel().toString())<15){
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Ordine Errato");
            alert.setHeaderText("Errore invio ordine");
            alert.setContentText("Per favore scegliere un tavolo disponibile");

            alert.showAndWait();
        }
        List <Ordine> tempListOrdine= new ArrayList<Ordine>();

        for(int i=0;i<riepilogoOrdine.getItems().size();i++){
            tempListOrdine.get(i).setId_ordine(null);
            tempListOrdine.get(i).setTavolo_numero_tavolo(Integer.parseInt(comboBoxTavolo.getValue().toString()));
            tempListOrdine.get(i).setTavolo_locazione_tavolo(comboBoxLocazione.getValue().toString());

            //Trovare metodo per estrarre ID prodotto da mainapp.getProdottoData()
            //tempListOrdine.get(i).setProdotto_id_prodotto(mainApp.getProdottoData().get(i).);
             tempListOrdine.get(i).setOrdine_preparato(false);
        }
















    }



}
