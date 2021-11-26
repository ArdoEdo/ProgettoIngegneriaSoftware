package it.unicas.model;



import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Prodotto {

    private IntegerProperty id_prodotto;
    private StringProperty nome_prodotto;
    private StringProperty tipo_prodotto;
    private BooleanProperty alcolico;
    private FloatProperty prezzo_prodotto;
    private IntegerProperty quantita_prodotto;



    public Prodotto(){};

    public Prodotto(Integer id_prodotto,String nome_prodotto, String tipo_prodotto,Boolean alcolico, Float prezzo_prodotto){

        this.nome_prodotto = new SimpleStringProperty(nome_prodotto);
        this.tipo_prodotto = new SimpleStringProperty(tipo_prodotto);
        this.alcolico = new SimpleBooleanProperty(alcolico);
        this.prezzo_prodotto = new SimpleFloatProperty(prezzo_prodotto);
        this.quantita_prodotto = new SimpleIntegerProperty(1);
        if (id_prodotto != null){
            this.id_prodotto = new SimpleIntegerProperty(id_prodotto);
        } else {
            this.id_prodotto = null;
        }
    }

    public Integer getId_prodotto() {
        if (id_prodotto == null) {
            this.id_prodotto =new SimpleIntegerProperty(-1);
        }
        return id_prodotto.get();
    }

    public IntegerProperty id_prodottoProperty() {
        return id_prodotto;
    }

    public void setId_prodotto(Integer id_prodotto) {
        if(this.id_prodotto == null) {
            this.id_prodotto = new SimpleIntegerProperty();
        }
        this.id_prodotto.set(id_prodotto);
    }

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

    public boolean isAlcolico() {
        return alcolico.get();
    }

    public BooleanProperty alcolicoProperty() {
        return alcolico;
    }

    public void setAlcolico(Boolean alcolico) {
        if(this.alcolico == null) {
            this.alcolico = new SimpleBooleanProperty();
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

    public int getQuantita_prodotto() {
        if(quantita_prodotto == null)
            quantita_prodotto = new SimpleIntegerProperty();
        return quantita_prodotto.get();
    }

    public IntegerProperty quantita_prodottoProperty() {
        return quantita_prodotto;
    }

    public void setQuantita_prodotto(int quantita_prodotto) {
        if (quantita_prodotto == 0){
            this.quantita_prodotto = new SimpleIntegerProperty();
        }
        this.quantita_prodotto.set(quantita_prodotto);
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id_prodotto=" + id_prodotto +
                ", nome_prodotto=" + nome_prodotto +
                ", tipo_prodotto=" + tipo_prodotto +
                ", alcolico=" + alcolico +
                ", prezzo_prodotto=" + prezzo_prodotto +
                '}';
    }

    public static void main(String[] args) {
        Prodotto prodotto = new Prodotto();
        List<Prodotto> prodotti = new ArrayList<>();

        System.out.println("Prodotto aggiunto");


    }



}
