package it.unicas.model.dao.mysql;

import it.unicas.model.Prodotto;
import it.unicas.model.dao.DAO;
import it.unicas.model.dao.DAOException;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProdottoDAOMySQLImpl implements DAO<Prodotto> {

    private ProdottoDAOMySQLImpl(){};
    private static DAO dao =null;
    private static Logger logger = null;

    public static DAO getInstance(){
        if (dao == null){
            dao = new ProdottoDAOMySQLImpl();
            logger = Logger.getLogger(ProdottoDAOMySQLImpl.class.getName());
        }
        return dao;
    }

    public static void main(String args[]) throws DAOException, SQLException {




    }

    @Override
    public List<Prodotto> select(Prodotto a) throws DAOException, SQLException {
        ArrayList<Prodotto> lista = new ArrayList<>();
        Statement st = DAOMySQLSettings.getStatement();
        String sql = "SELECT * FROM prodotto";

        logger.info("SQL:"+ sql);
        ResultSet rs=st.executeQuery(sql);

        while(rs.next()){
            lista.add(new Prodotto(rs.getInt("id_prodotto"),
                    rs.getString("nome_prodotto"),
                    rs.getString("tipo_prodotto"),
                    rs.getBoolean("alcolico"),
                    rs.getFloat("prezzo_prodotto")));

        }
        DAOMySQLSettings.closeStatement(st);

        return lista;

    }

    @Override
    public void update(Prodotto a) throws DAOException {

    }

    @Override
    public void insert(Prodotto a) throws DAOException {

    }

    @Override
    public void delete(Prodotto a) throws DAOException {

    }
}
