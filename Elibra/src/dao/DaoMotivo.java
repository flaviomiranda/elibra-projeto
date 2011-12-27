package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import model.Categoria;
import model.Motivo;

import utilitarios.TrataErro;

public class DaoMotivo {

public Categoria selectMotivo(double codigo)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_MOTIVO, DS_MOTIVO FROM TMOTIVO WHERE CD_MOTIVO = ?");
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
			TrataErro.imprimeErro("Erro no SELECT na TMOTIVO", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public Categoria selectMotivoNome(String nome)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_MOTIVO, DS_MOTIVO FROM TMOTIVO WHERE UPPER(DS_MOTIVO) LIKE ?");
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
			TrataErro.imprimeErro("Erro no SELECT na TMOTIVO", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}
	
public Map<String, Motivo> selectAllMotivoMap()
	{
            Map<String, Motivo> mapMotivo = new TreeMap<String, Motivo>();
            Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_MOTIVO, DS_MOTIVO FROM TMOTIVO ORDER BY DS_MOTIVO");
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
                            do{
                                mapMotivo.put(rs.getString(2), new Motivo(rs.getDouble(1),rs.getString(2)));
                             }while(rs.next());}
		  return mapMotivo;
		  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TMOTIVO", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}
public Map<Integer, Motivo> selectAllMotivoMapCod()
	{
            Map<Integer, Motivo> mapMotivo = new TreeMap<Integer, Motivo>();
            Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_MOTIVO, DS_MOTIVO FROM TMOTIVO ORDER BY DS_MOTIVO");
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
                            do{
                                mapMotivo.put((int)rs.getDouble(1), new Motivo(rs.getDouble(1),rs.getString(2)));
                             }while(rs.next());}
		  return mapMotivo;
		  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TMOTIVO", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public ArrayList<Motivo> selectAllMotivo()
	{
            ArrayList<Motivo> listamotivo = new ArrayList<Motivo>();
            Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_MOTIVO, DS_MOTIVO FROM TMOTIVO ORDER BY DS_MOTIVO");
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
                            do{
                                listamotivo.add(new Motivo(rs.getDouble(1),rs.getString(2)));
                             }while(rs.next());}
		  return listamotivo;
		  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TMOTIVO", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}



public double selectMaxMotivo()
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT MAX (CD_MOTIVO) AS MAXIMO FROM TMOTIVO");
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			    return rs.getDouble("MAXIMO");
			else
			    return 0;
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT MAX na TMOTIVO", e.getMessage());
			return 0;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}	   
	
public int insertMotivo(Motivo m)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("INSERT INTO TMOTIVO VALUES (?, ?)");
			ps.setDouble(1, m.getCD_MOTIVO());
			ps.setString(2, m.getDS_MOTIVO());
			ps.executeUpdate();
			return 0;                  
			  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no INSERT na TMOTIVO", e.getMessage());
			return 99;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}	
}   