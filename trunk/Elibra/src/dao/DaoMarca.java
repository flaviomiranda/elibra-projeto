package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import model.Marca;

import utilitarios.TrataErro;

public class DaoMarca {


public Marca selectMarca(double codigo)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_MARCA, NM_MARCA FROM TMARCA WHERE CD_MARCA = ?");
			ps.setDouble(1, codigo);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
			    return new Marca(rs.getDouble(1),rs.getString(2));
			}else
			{
			    return null;
			}   
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TMARCA", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public Marca selectMarcaNome(String nome)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_MARCA, NM_MARCA FROM TMARCA WHERE UPPER(NM_MARCA) LIKE ?");
                        ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
			    return new Marca(rs.getDouble(1),rs.getString(2));
			}else
			{
			    return null;
			}   
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TMARCA", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}
	
public ArrayList<Marca> selectAllMarca()
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_MARCA, NM_MARCA FROM TMARCA ORDER BY NM_MARCA");
                        ResultSet rs = ps.executeQuery();
			ArrayList<Marca> lista = new ArrayList<Marca>();
			if(rs.next()){
                        do{
			    lista.add(new Marca(rs.getDouble(1),rs.getString(2)));
		    }while(rs.next()); }
		  return lista;
		  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TMARCA", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public Map<String,Marca> selectAllMarcaMap()
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_MARCA, NM_MARCA FROM TMARCA ORDER BY NM_MARCA");
                        ResultSet rs = ps.executeQuery();
			Map<String,Marca> map = new TreeMap<String,Marca>();
			if(rs.next()){
                        do{
			    map.put(rs.getString(2), new Marca(rs.getDouble(1),rs.getString(2)));
		    }while(rs.next()); }
		  return map;
		  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TMARCA", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public Map<Integer,Marca> selectAllMarcaMapCod()
{
	Connection con = ConFactory.conectar(0);
	PreparedStatement ps = null;
	try {
		ps = con.prepareStatement("SELECT CD_MARCA, NM_MARCA FROM TMARCA ORDER BY CD_MARCA");
		ResultSet rs = ps.executeQuery();
		Map<Integer,Marca> map = new TreeMap<Integer,Marca>();
		if(rs.next()){
                    do{
		    map.put((int)rs.getDouble(1), new Marca(rs.getDouble(1),rs.getString(2)));
	    }while(rs.next()); }
	  return map;
	  }
		catch (SQLException e) {
		TrataErro.imprimeErro("Erro no SELECT na TMARCA", e.getMessage());
		return null;
	}
	finally{
		ConFactory.fechar(con,ps);
	}
}

public double selectMaxMarca()
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT MAX (CD_MARCA) AS MAXIMO FROM TMARCA");
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			    return rs.getDouble("MAXIMO");
			else
			    return 0;
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT MAX na TMARCA", e.getMessage());
			return 0;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}	   
	
public int InsertMarca(Marca m)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("INSERT INTO TMARCA VALUES (?, ?)");
			ps.setDouble(1, m.getCD_MARCA());
			ps.setString(2, m.getNM_MARCA());
                        ps.executeUpdate();
			return 0;                  
			  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no INSERT na TMARCA", e.getMessage());
			return 99;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}	
}   