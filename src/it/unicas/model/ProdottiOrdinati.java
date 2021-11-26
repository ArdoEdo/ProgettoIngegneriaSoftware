package it.unicas.model;

import javafx.beans.property.*;

public class ProdottiOrdinati {

    //da Prodotto
    private StringProperty nome_prodotto;
    private StringProperty tipo_prodotto;
    private IntegerProperty alcolico;
    private FloatProperty prezzo_prodotto;
    // da Ordine
    private IntegerProperty id_ordine;
    private IntegerProperty prodotto_id_prodotto;
    private IntegerProperty quantita_prodotto_or;
    private StringProperty tavolo_locazione_tavolo;
    private IntegerProperty tavolo_numero_tavolo;
    private IntegerProperty ordine_preparato;




    public ProdottiOrdinati(){}

    public ProdottiOrdinati(String nome_prodotto, String tipo_prodotto, Integer alcolico, Float prezzo_prodotto,Integer id_ordine,Integer prodotto_id_prodotto, Integer quantita_prodotto_or,String tavolo_locazione_tavolo ,Integer tavolo_numero_tavolo, Integer ordine_preparato) {
        this.nome_prodotto = new SimpleStringProperty(nome_prodotto);
        this.tipo_prodotto = new SimpleStringProperty(tipo_prodotto);
        this.alcolico = new SimpleIntegerProperty(alcolico);
        this.prezzo_prodotto = new SimpleFloatProperty(prezzo_prodotto);
        this.id_ordine = new SimpleIntegerProperty(id_ordine);
        this.prodotto_id_prodotto = new SimpleIntegerProperty(prodotto_id_prodotto);
        this.quantita_prodotto_or = new SimpleIntegerProperty(quantita_prodotto_or);
        this.tavolo_locazione_tavolo = new SimpleStringProperty(tavolo_locazione_tavolo);
        this.tavolo_numero_tavolo = new SimpleIntegerProperty(tavolo_numero_tavolo);
        this.ordine_preparato = new SimpleIntegerProperty(ordine_preparato);
    }

    //get e set da Prodotto
    public String getNome_prodotto() {
        return nome_prodotto.get();
    }

    public StringProperty nome_prodottoProperty() {
        return nome_prodotto;
    }

    public void setNome_prodotto(String nome_prodotto) {
        this.nome_prodotto.set(nome_prodotto);
    }

    public String getTipo_prodotto() {
        return tipo_prodotto.get();
    }

    public StringProperty tipo_prodottoProperty() {
        return tipo_prodotto;
    }

    public void setTipo_prodotto(String tipo_prodotto) {
        if(this.tipo_prodotto == null) {
            this.tipo_prodotto = new SimpleStringProperty();
        }
        this.tipo_prodotto.set(tipo_prodotto);
    }

    public Integer isAlcolico() {
        return alcolico.get();
    }

    public IntegerProperty alcolicoProperty() {
        return alcolico;
    }

    public void setAlcolico(Integer alcolico) {
        if(this.alcolico == null) {
            this.alcolico = new SimpleIntegerProperty();
        }
        this.alcolico.set(alcolico);
    }

    public Float getPrezzo_prodotto() {
        return prezzo_prodotto.get();
    }

    public FloatProperty prezzo_prodottoProperty() {
        return prezzo_prodotto;
    }

    public void setPrezzo_prodotto(Float prezzo_prodotto) {
        if(this.prezzo_prodotto == null) {
            this.prezzo_prodotto = new SimpleFloatProperty();
        }
        this.prezzo_prodotto.set(prezzo_prodotto);
    }

    // get e set da Ordine
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

    @Override
    public String toString() {
        return "ProdottiOrdinati{" +
                "nome_prodotto=" + nome_prodotto +
                ", tipo_prodotto=" + tipo_prodotto +
                ", alcolico=" + alcolico +
                ", prezzo_prodotto=" + prezzo_prodotto +
                ", quantita_prodotto_or=" + quantita_prodotto_or +
                ", tavolo_numero_tavolo=" + tavolo_numero_tavolo +
                ", ordine_preparato=" + ordine_preparato +
                '}';
    }




}
