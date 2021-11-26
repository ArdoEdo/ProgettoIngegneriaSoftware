package it.unicas.model;


import javafx.beans.property.*;

public class Ordine {

    private IntegerProperty id_ordine;
    private IntegerProperty tavolo_numero_tavolo;
    private StringProperty tavolo_locazione_tavolo;
    private IntegerProperty prodotto_id_prodotto;
    private IntegerProperty ordine_preparato;
    private IntegerProperty quantita_prodotto_or;



    public Ordine(){}

    /**
     il campo id_ordine dovrebbe essere sempre null perché gestito dal db con autoincrement
     */
    public Ordine(Integer id_ordine,Integer tavolo_numero_tavolo, String tavolo_locazione_tavolo,Integer prodotto_id_prodotto,Integer ordine_preparato, Integer quantita_prodotto_or){
        this.tavolo_numero_tavolo= new SimpleIntegerProperty(tavolo_numero_tavolo);
        this.tavolo_locazione_tavolo= new SimpleStringProperty(tavolo_locazione_tavolo);
        this.prodotto_id_prodotto = new SimpleIntegerProperty(prodotto_id_prodotto);
        this.ordine_preparato= new SimpleIntegerProperty(ordine_preparato);
        this.quantita_prodotto_or = new SimpleIntegerProperty(quantita_prodotto_or);

        if (id_ordine != null){
            this.id_ordine = new SimpleIntegerProperty(id_ordine);
        } else {
            this.id_ordine = null;
        }
    }


    public Integer getId_ordine(){
    if(id_ordine == null)
        id_ordine=new SimpleIntegerProperty();

        return id_ordine.get();
    }

    public void setId_ordine(Integer id_ordine) {

        if (this.id_ordine == null){
            this.id_ordine = new SimpleIntegerProperty();
        }
            this.id_ordine.set(id_ordine);
    }

    public IntegerProperty id_ordineProperty() {
        return id_ordine;
    }


    public Integer getTavolo_numero_tavolo() {
        return tavolo_numero_tavolo.get();
    }

    public void setTavolo_numero_tavolo(Integer tavolo_numero_tavolo) {
        if (this.tavolo_numero_tavolo == null){
            this.tavolo_numero_tavolo = new SimpleIntegerProperty();
        }

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
        if (this.tavolo_locazione_tavolo == null){
            this.tavolo_locazione_tavolo = new SimpleStringProperty();
        }
        this.tavolo_locazione_tavolo.set(tavolo_locazione_tavolo);
    }

    public Integer getProdotto_id_prodotto() {
        return prodotto_id_prodotto.get();
    }

    public IntegerProperty prodotto_id_prodottoProperty() {
        return prodotto_id_prodotto;
    }

    public void setProdotto_id_prodotto(Integer prodotto_id_prodotto) {
        if (this.prodotto_id_prodotto == null){
            this.prodotto_id_prodotto = new SimpleIntegerProperty();
        }
        this.prodotto_id_prodotto.set(prodotto_id_prodotto);
    }

    public Integer isOrdine_preparato() {
        return ordine_preparato.get();
    }

    public IntegerProperty ordine_preparatoProperty() {
        return ordine_preparato;
    }

    public void setOrdine_preparato(Integer ordine_preparato) {
        if (this.ordine_preparato == null){
            this.ordine_preparato = new SimpleIntegerProperty();
        }

        this.ordine_preparato.set(ordine_preparato);
    }

    public int getQuantita_prodotto_or() {
        return quantita_prodotto_or.get();
    }

    public IntegerProperty quantita_prodotto_orProperty() {
        return quantita_prodotto_or;
    }

    public void setQuantita_prodotto_or(Integer quantita_prodotto_or) {
        if (this.quantita_prodotto_or == null){
            this.quantita_prodotto_or = new SimpleIntegerProperty();
        }
        this.quantita_prodotto_or.set(quantita_prodotto_or);
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id_ordine=" + id_ordine +
                ", tavolo_numero_tavolo=" + tavolo_numero_tavolo +
                ", tavolo_locazione_tavolo=" + tavolo_locazione_tavolo +
                ", prodotto_id_prodotto=" + prodotto_id_prodotto +
                ", ordine_preparato=" + ordine_preparato +
                ", quantita_prodotto_or=" + quantita_prodotto_or +
                '}';
    }

    public static void main(String[] args) {




    }
}
