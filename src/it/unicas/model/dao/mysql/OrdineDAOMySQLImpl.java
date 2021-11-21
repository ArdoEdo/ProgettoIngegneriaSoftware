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

public class OrdineDAOMySQLImpl implements DAO<Ordine>{

    private OrdineDAOMySQLImpl(){}

    private static DAO dao =null;
    private static Logger logger = null;

    public static void main(String args[]) throws DAOException, SQLException {

        OrdineDAOMySQLImpl c = new OrdineDAOMySQLImpl();




    }

    /**
     * Funzione di select
     *
     * @param
     * @return
     * @throws DAOException
     * @throws SQLException
     */
    @Override
    public List<Ordine> select(Ordine a) throws DAOException, SQLException {

        ArrayList<Ordine> lista = new ArrayList<>();
        Statement st = DAOMySQLSettings.getStatement();
        String sql = "SELECT * FROM ordine ";
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

    @Override
    public void update(Ordine a) throws DAOException {

    }

    @Override
    public void insert(Ordine a) throws DAOException {
        String query="INSERT INTO ordine (id_ordine,tavolo_numero_tavolo,tavolo_locazione_tavolo" +
                "prodotto_id_prodotto,ordine_preparato) VALUES ('"+
                a.getId_ordine()+"','"+a.getTavolo_numero_tavolo()+"','"+a.getTavolo_locazione_tavolo()+"','"+
                a.getProdotto_id_prodotto()+"','"+a.isOrdine_preparato()+"')";
       logger.info("SQL: " + query);


    }

    /**
     *
     * @param a
     * @throws DAOException
     * la delete cancella istanze di ordini una volta che è stato eseguito il pagamento correttamente
     * la ricerca avviene per numero tavolo e locazione quindi in generale n istanze
     */
    @Override
    public void delete (Ordine a) throws DAOException {

        if(a.getTavolo_numero_tavolo()==null|| a.getTavolo_locazione_tavolo()==null){
            throw new DAOException("Nella delete numero_tavolo/locazione_tavolo non può essere null");
        }

        String query = "DELETE FROM ordine where tavolo_numero_tavolo='"+a.getTavolo_numero_tavolo()+"'" +
                "and tavolo_locazione_tavolo='"+a.getTavolo_locazione_tavolo()+"'";

        logger.info("SQL:"+query);
        executeUpdate(query);
    }

    /**
     * tale funzione generica può essere usata per insert,delete e update
     * @param query
     * @throws DAOException
     */
    private void executeUpdate(String query) throws DAOException{
        try {
            Statement st = DAOMySQLSettings.getStatement();
            //int n = st.executeUpdate(query); esito query

            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException e) {
            throw new DAOException("In insert(): " + e.getMessage());
        }
    }



}
