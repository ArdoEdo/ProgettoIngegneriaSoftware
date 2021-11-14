package it.unicas.model.dao.mysql;

import it.unicas.model.Ordine;
import it.unicas.model.dao.DAO;
import it.unicas.model.dao.DAOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OrdineDAOMySQLImpl {

    private OrdineDAOMySQLImpl(){}

    private static DAO dao =null;
    private static Logger logger = null;

    public static void main(String args[]) throws DAOException, SQLException {

        OrdineDAOMySQLImpl c = new OrdineDAOMySQLImpl();


        List<Ordine> list = c.select(null);
        //test di stampa
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }

    private List<Ordine> select(Ordine a) throws DAOException, SQLException {

        ArrayList<Ordine> lista = new ArrayList<>();
        Statement st = DAOMySQLSettings.getStatement();
        String sql = "select * from ordine";
        ResultSet rs=st.executeQuery(sql);

        while(rs.next()){
            lista.add(new Ordine(rs.getInt("id_ordine"),
                    rs.getInt("tavolo_numero_tavolo"),
                    rs.getString("tavolo_locazione_tavolo"),
                    rs.getInt("prodotto_id_prodotto"),
                    rs.getBoolean("ordine_preparato")));
        }
        DAOMySQLSettings.closeStatement(st);
        return lista;
    }


}
