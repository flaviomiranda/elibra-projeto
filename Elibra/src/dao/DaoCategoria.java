package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import model.Categoria;

import utilitarios.TrataErro;

public class DaoCategoria {

public Categoria selectCategoria(double codigo)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_CAT, DS_CAT FROM TCATEGORIA WHERE CD_CAT = ?");
			ps.setDouble(1, codigo);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
			    return new Categoria(rs.getDouble(1),rs.getString(2));
			}else
			{
			    return null;
			}   
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TCATEGORIA", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public Categoria selectCategoriaNome(String nome)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_CAT, DS_CAT FROM TCATEGORIA WHERE UPPER(DS_CAT) LIKE ?");
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
			    return new Categoria(rs.getDouble(1),rs.getString(2));
			}else
			{
			    return null;
			}   
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TCATEGORIA", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}
	
public Map<String, Categoria> selectAllCategoriaMap()
	{
            Map<String, Categoria> mapCategoria = new TreeMap<String, Categoria>();
            Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_CAT, DS_CAT FROM TCATEGORIA ORDER BY DS_CAT");
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
                            do{
                                mapCategoria.put(rs.getString(2), new Categoria(rs.getDouble(1),rs.getString(2)));
                             }while(rs.next());}
		  return mapCategoria;
		  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TCATEGORIA", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public Map<Integer, Categoria> selectAllCategoriaMapCod()
{
    Map<Integer, Categoria> mapCategoria = new TreeMap<Integer, Categoria>();
    Connection con = ConFactory.conectar(0);
	PreparedStatement ps = null;
	try {
		ps = con.prepareStatement("SELECT CD_CAT, DS_CAT FROM TCATEGORIA ORDER BY CD_CAT");
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
                        do{
                            mapCategoria.put((int)rs.getDouble(1), new Categoria(rs.getDouble(1),rs.getString(2)));
                         }while(rs.next());}
	  return mapCategoria;
	  }
		catch (SQLException e) {
		TrataErro.imprimeErro("Erro no SELECT na TCATEGORIA", e.getMessage());
		return null;
	}
	finally{
		ConFactory.fechar(con,ps);
	}
}

public ArrayList<Categoria> selectAllCategoria()
	{
            ArrayList<Categoria> lista = new ArrayList<Categoria>();
            Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_CAT, DS_CAT FROM TCATEGORIA ORDER BY DS_CAT");
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
                            do{
                                lista.add(new Categoria(rs.getDouble(1),rs.getString(2)));
                             }while(rs.next());}
		  return lista;
		  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TCATEGORIA", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public double selectMaxCategoria()
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT MAX (CD_CAT) AS MAXIMO FROM TCATEGORIA");
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			    return rs.getDouble("MAXIMO");
			else
			    return 0;
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT MAX na TCATEGORIA", e.getMessage());
			return 0;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}	   
	
public int insertCategoria(Categoria c)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("INSERT INTO TCATEGORIA VALUES (?, ?)");
			ps.setDouble(1, c.getCD_CAT());
			ps.setString(2, c.getDS_CAT());
			ps.executeUpdate();
			return 0;                  
			  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no INSERT na TCATEGORIA", e.getMessage());
			return 99;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}	
}   