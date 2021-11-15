package it.unicas.model.dao.mysql;

import it.unicas.model.Ordine;
import it.unicas.model.Tavolo;
import it.unicas.model.dao.DAO;
import it.unicas.model.dao.DAOException;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class TavoloDAOMySQLImpl {
    private TavoloDAOMySQLImpl(){}

    private static DAO dao =null;
    private static Logger logger = null;

    public static void main(String args[]) throws DAOException, SQLException {

        TavoloDAOMySQLImpl c = new TavoloDAOMySQLImpl();

        List<Tavolo> list = c.select(null);
        //test di stampa
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }






}

    private List<Tavolo> select(Object o) {
        

    }

    private List<Tavolo> insert(Object o) {


    }

    private List<Tavolo> update(Object o) {


    }

    private List<Tavolo> delete(Object o) {


    }
    }
