package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Produto;
import model.Venda;

import utilitarios.TrataErro;

public class DaoVenda {

public Venda selectVenda(int codigo)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_VENDA, CD_FORM_PGMTO, CD_FUNC, CD_CLI, VL_DESCONTO, HR_VENDA, QTD_PARCELA, DT_VENDA, VL_VENDA FROM TVENDA WHERE CD_VENDA = ?");
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
			    return new Venda(rs.getDouble(1),rs.getDouble(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5), rs.getString(6), rs.getDouble(7), rs.getString(8), rs.getDouble(9));
			}else
			{
			    return null;
			}   
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no select na TVENDA", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}	

public double selectMaxVenda()
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
                        ps = con.prepareStatement("SELECT MAX (CD_VENDA) AS MAXIMO FROM TVENDA");
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			    return rs.getDouble("MAXIMO");
			else
			    return 0;
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no select na TVENDA", e.getMessage());
			return 0;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}	   
	
public int insertVenda(Venda v)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("INSERT INTO TVENDA(CD_VENDA, CD_FORM_PGMTO, CD_FUNC, CD_CLI, VL_DESCONTO, HR_VENDA, QTD_PARCELA, DT_VENDA, VL_VENDA) VALUES (?,?,?,?,?,CURRENT_TIMESTAMP, ?, CURRENT_DATE,?)");


			ps.setDouble(1, v.getCD_VENDA());
			ps.setDouble(2, v.getCD_FORM_PGMTO());
                        ps.setDouble(3, v.getCD_FUNC());
                        //ps.setDouble(3, 1);
			ps.setDouble(4, v.getCD_CLI());
                        //ps.setDouble(4, 1);
			ps.setDouble(5, v.getVL_DESC());
                        //ps.setString(6, v.getHR_VENDA());
                        ps.setDouble(6, v.getQTD_PARCELA());
                        ps.setDouble(7, v.getVL_VENDA());
			ps.executeUpdate();
			return 0;                  
	           }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no INSERT na TVENDA", e.getMessage());
			return 99;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public ArrayList<Venda> selectAllVendaBetweenDate (String dtinicio, String dtfim)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_VENDA, CD_FORM_PGMTO, CD_FUNC, CD_CLI, VL_DESCONTO, HR_VENDA, QTD_PARCELA, DT_VENDA, VL_VENDA FROM TVENDA WHERE DT_VENDA >= ? AND DT_VENDA <= ? ORDER BY CD_VENDA");
			ps.setString(1, dtinicio);
                        ps.setString(2, dtfim);
			ArrayList<Venda> lista = new ArrayList<Venda>();
                        ResultSet rs = ps.executeQuery();
			if (rs.next())
			{

                            do{
                                lista.add(new Venda(rs.getDouble(1),rs.getDouble(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5), rs.getString(6), rs.getDouble(7), rs.getString(8), rs.getDouble(9)));
                            }while(rs.next() );
                            return lista;
			}else
			{
			    return lista;
			}
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no select na TVENDA", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public ArrayList<Venda> selectAllVendaDia ()
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_VENDA, CD_FORM_PGMTO, CD_FUNC, CD_CLI, VL_DESCONTO, HR_VENDA, QTD_PARCELA, DT_VENDA, VL_VENDA FROM TVENDA WHERE DT_VENDA = CURRENT_DATE ORDER BY CD_VENDA");
			ArrayList<Venda> lista = new ArrayList<Venda>();
                        ResultSet rs = ps.executeQuery();
			if (rs.next())
			{

                            do{
                                lista.add(new Venda(rs.getDouble(1),rs.getDouble(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5), rs.getString(6), rs.getDouble(7), rs.getString(8), rs.getDouble(9)));
                            }while(rs.next() );
                            return lista;
			}else
			{
			    return lista;
			}
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no select na TVENDA", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}



}   