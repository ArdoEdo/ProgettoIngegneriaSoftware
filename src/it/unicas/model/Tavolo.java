package it.unicas.model;

import it.unicas.model.dao.DAOException;
import it.unicas.model.dao.mysql.DAOMySQLSettings;
import it.unicas.model.dao.mysql.OrdineDAOMySQLImpl;
import javafx.beans.property.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Tavolo {
    private IntegerProperty numero_tavolo;
    private BooleanProperty occupato;
    private StringProperty locazione_tavolo;

    public Tavolo(){}

    public Tavolo(Integer numero_tavolo,Boolean occupato,String locazione_tavolo){
        //this.numero_tavolo= new SimpleIntegerProperty(numero_tavolo);
        this.occupato= new SimpleBooleanProperty(occupato);
        this.locazione_tavolo= new SimpleStringProperty(locazione_tavolo);
        if(numero_tavolo != null){
            this.numero_tavolo = new SimpleIntegerProperty(numero_tavolo);
        }
        else{
            this.numero_tavolo = null;
        }
    }

    public Integer getNumero_tavolo() {
        return numero_tavolo.get();
    }

    public IntegerProperty numero_tavoloProperty() {
        return numero_tavolo;
    }

    public void setNumero_tavolo(Integer numero_tavolo) {
        if(this.numero_tavolo==null){
            this.numero_tavolo=new SimpleIntegerProperty();
        }
        this.numero_tavolo.set(numero_tavolo);
    }

    public Boolean isOccupato() {
        return occupato.get();
    }

    public BooleanProperty occupatoProperty() {
        return occupato;
    }

    public void setOccupato(Boolean occupato) {
        if(this.occupato==null){
            this.occupato= new SimpleBooleanProperty();
        }
        this.occupato.set(occupato);
    }

    public String getLocazione_tavolo() {
        return locazione_tavolo.get();
    }

    public StringProperty locazione_tavoloProperty() {
        return locazione_tavolo;
    }

    public void setLocazione_tavolo(String locazione_tavolo) {
        if(this.locazione_tavolo==null){
            this.locazione_tavolo= new SimpleStringProperty();
        }
        this.locazione_tavolo.set(locazione_tavolo);
    }

    @Override
    public String toString() {
        return "Tavolo{" +
                "numero_tavolo=" + numero_tavolo +
                ", occupato=" + occupato +
                ", locazione_tavolo=" + locazione_tavolo +
                '}';
    }


    public static void main(String[] args) throws DAOException  {




    }


}
