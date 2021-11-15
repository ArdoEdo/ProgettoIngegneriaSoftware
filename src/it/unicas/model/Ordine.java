package it.unicas.model;

import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;

//bella POLSETISPACCO
public class Ordine {

    private IntegerProperty id_ordine;
    private IntegerProperty tavolo_numero_tavolo;
    private StringProperty tavolo_locazione_tavolo;
    private IntegerProperty prodotto_id_prodotto;
    private BooleanProperty ordine_preparato;


    public Ordine(){}

    /**
     il campo id_ordine dovrebbe essere sempre null perché gestito dal db con autoincrement
     */
    public Ordine(Integer id_ordine,Integer tavolo_numero_tavolo, String tavolo_locazione_tavolo,Integer prodotto_id_prodotto,Boolean ordine_preparato){
        this.id_ordine=new SimpleIntegerProperty(id_ordine);
        this.tavolo_numero_tavolo= new SimpleIntegerProperty(tavolo_numero_tavolo);
        this.tavolo_locazione_tavolo= new SimpleStringProperty(tavolo_locazione_tavolo);
        this.prodotto_id_prodotto = new SimpleIntegerProperty(prodotto_id_prodotto);
        this.ordine_preparato= new SimpleBooleanProperty(ordine_preparato);

        if (id_ordine != null){
            this.id_ordine = new SimpleIntegerProperty(id_ordine);
        } else {
            this.id_ordine = null;
        }
    }


    public int getId_ordine() {
        return id_ordine.get();
    }

    public void setId_ordine(Integer id_ordine) {

        if (id_ordine != null){
            this.id_ordine = new SimpleIntegerProperty(id_ordine);
        }
        this.id_ordine.set(id_ordine);
    }

    public IntegerProperty id_ordineProperty() {
        return id_ordine;
    }


    public Integer getTavolo_numero_tavolo() {
        return tavolo_numero_tavolo.get();
    }

    public void setTavolo_numero_tavolo(int tavolo_numero_tavolo) {
        this.tavolo_numero_tavolo.set(tavolo_numero_tavolo);
    }

    public IntegerProperty tavolo_numero_tavoloProperty() {
        return tavolo_numero_tavolo;
    }

    public String getTavolo_locazione_tavolo() {
        return tavolo_locazione_tavolo.get();
    }

    public StringProperty tavolo_locazione_tavoloProperty() {
        return tavolo_locazione_tavolo;
    }

    public void setTavolo_locazione_tavolo(String tavolo_locazione_tavolo) {
        this.tavolo_locazione_tavolo.set(tavolo_locazione_tavolo);
    }

    public int getProdotto_id_prodotto() {
        return prodotto_id_prodotto.get();
    }

    public IntegerProperty prodotto_id_prodottoProperty() {
        return prodotto_id_prodotto;
    }

    public void setProdotto_id_prodotto(int prodotto_id_prodotto) {
        this.prodotto_id_prodotto.set(prodotto_id_prodotto);
    }

    public boolean isOrdine_preparato() {
        return ordine_preparato.get();
    }

    public BooleanProperty ordine_preparatoProperty() {
        return ordine_preparato;
    }

    public void setOrdine_preparato(boolean ordine_preparato) {
        this.ordine_preparato.set(ordine_preparato);
    }

    public String toString(){

        return id_ordine.getValue().toString() +','+ tavolo_numero_tavolo.getValue().toString() +','+ tavolo_locazione_tavolo.getValue() +','+ prodotto_id_prodotto.getValue().toString() +','+ ordine_preparato.getValue().toString() ;


    }
    public static void main(String[] args) {
        Ordine ordine= new Ordine();


        System.out.println("Ordine finito");


    }


}
