package it.unicas.model.dao.mysql;

import it.unicas.model.Tavolo;
import it.unicas.model.dao.DAO;
import it.unicas.model.dao.DAOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    private List<Tavolo> select(Tavolo t) throws SQLException {


            ArrayList<Tavolo> lista = new ArrayList<>();
            Statement st = DAOMySQLSettings.getStatement();
            String sql = "SELECT * FROM tavolo ";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                lista.add(new Tavolo(rs.getInt("numero_tavolo"),
                        rs.getBoolean("occupato"),
                        rs.getString("locazione_tavolo")));
            }
            DAOMySQLSettings.closeStatement(st);


            return lista;


    }

    private List<Tavolo> insert(Object o) {
        return null;

    }

    private List<Tavolo> update(Object o) {
        return null;

    }

    private List<Tavolo> delete(Object o) {

        return null;
    }
    }
