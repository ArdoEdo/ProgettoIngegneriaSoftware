package it.unicas.model.dao.mysql;

import it.unicas.model.Ordine;
import it.unicas.model.ProdottiOrdinati;
import it.unicas.model.Prodotto;
import it.unicas.model.dao.DAO;
import it.unicas.model.dao.DAOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProdottiOrdinatiDAOMySQLImpl implements DAO<ProdottiOrdinati> {

    private ProdottiOrdinatiDAOMySQLImpl(){};
    private static DAO dao =null;
    private static Logger logger = null;

    public static DAO getInstance(){
        if (dao == null){
            dao = new ProdottiOrdinatiDAOMySQLImpl();
            logger = Logger.getLogger(ProdottiOrdinatiDAOMySQLImpl.class.getName());
        }
        return dao;
    }




    @Override
    public List<ProdottiOrdinati> select(ProdottiOrdinati a) throws DAOException, SQLException {
        return null;
    }

    @Override
    public void update(ProdottiOrdinati a) throws DAOException, SQLException {


        Statement st = DAOMySQLSettings.getStatement();
        String sql = "UPDATE ordine set ordine.ordine_preparato = '1' where ordine.id_ordine ='"+a.getId_ordine()+"'";
        int rs=st.executeUpdate(sql);
        DAOMySQLSettings.closeStatement(st);


    }

    @Override
    public void insert(ProdottiOrdinati a) throws DAOException, SQLException {

    }

    @Override
    public void delete(ProdottiOrdinati a) throws DAOException {

    }

    @Override
    public List<ProdottiOrdinati> join(ProdottiOrdinati a) throws DAOException, SQLException {
        ArrayList<ProdottiOrdinati> list = new ArrayList<ProdottiOrdinati>();
        Statement st = DAOMySQLSettings.getStatement();
        String sql = "SELECT prodotto.nome_prodotto, prodotto.tipo_prodotto,prodotto.alcolico,prodotto.prezzo_prodotto," +
                "ordine.quantita_prodotto_or,ordine.tavolo_locazione_tavolo,ordine.tavolo_numero_tavolo,ordine.ordine_preparato,\n" +
                "ordine.id_ordine, ordine.prodotto_id_prodotto FROM prodotto inner join ordine on prodotto.id_prodotto = ordine.prodotto_id_prodotto" +
                " and ordine.ordine_preparato = '0' and prodotto.tipo_prodotto ='"+a.getTipo_prodotto()+"'";
        ResultSet rs=st.executeQuery(sql);

        while(rs.next()){
            list.add(new ProdottiOrdinati(rs.getString("nome_prodotto"),
                    rs.getString("tipo_prodotto"),
                    rs.getInt("alcolico"),
                    rs.getFloat("prezzo_prodotto"),
                    rs.getInt("id_ordine"),
                    rs.getInt("prodotto_id_prodotto"),
                    rs.getInt("quantita_prodotto_or"),
                    rs.getString("tavolo_locazione_tavolo"),
                    rs.getInt("tavolo_numero_tavolo"),
                    rs.getInt("ordine_preparato")));

        }
        DAOMySQLSettings.closeStatement(st);
        return list;

    }


    public static void main(String args[]) throws DAOException, SQLException {
        ProdottiOrdinatiDAOMySQLImpl prodottiOrdinati = new ProdottiOrdinatiDAOMySQLImpl();
        ProdottiOrdinati p = new ProdottiOrdinati();
        List<ProdottiOrdinati> list = prodottiOrdinati.join(p);
        System.out.println(list);




    }
}
