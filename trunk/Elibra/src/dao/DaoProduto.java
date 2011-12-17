package dao;

import model.Produto;
import java.util.*;
import java.sql.*;
import utilitarios.TrataErro;

public class DaoProduto {

public Produto selectProduto(int codigo)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_PROD, CD_CAT, CD_MARCA, CD_BARRA_PROD, NM_PROD, QTD_PROD, VL_PROD, DT_VAL_PROD FROM TPRODUTO WHERE CD_PROD = ?");
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
			    return new Produto(rs.getDouble(1),rs.getDouble(2), rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7),rs.getDate(8));
			}else
			{
			    return null;
			}   
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no select na TPRODUTO", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public Produto selectCodigoBarraProduto(String  codigo)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_PROD, CD_CAT, CD_MARCA, CD_BARRA_PROD, NM_PROD, QTD_PROD, VL_PROD, DT_VAL_PROD FROM TPRODUTO WHERE CD_BARRA_PROD = ?");
			ps.setString(1, codigo);
			System.out.println(codigo);
                        ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
			    return new Produto(rs.getDouble(1),rs.getDouble(2), rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7),rs.getDate(8));
			}else
			{
			    return null;
			}
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no select na TPRODUTO", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}
	
public ArrayList<Produto> selectAllProduto()
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_PROD, CD_CAT, CD_MARCA, CD_BARRA_PROD, NM_PROD, QTD_PROD, VL_PROD, DT_VAL_PROD FROM TPRODUTO ORDER BY NM_PROD");
			ResultSet rs = ps.executeQuery();
			ArrayList<Produto> lista = new ArrayList<Produto>();
			if (rs.next())
                        {
                            do{
                                lista.add(new Produto(rs.getDouble(1),rs.getDouble(2), rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7),rs.getDate(8)));
                              }while(rs.next());
                        }
		  return lista;
		  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no select na TPRODUTO", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public TreeMap<Double,Produto> selectAllProdutoMap()
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_PROD, CD_CAT, CD_MARCA, CD_BARRA_PROD, NM_PROD, QTD_PROD, VL_PROD, DT_VAL_PROD FROM TPRODUTO ORDER BY NM_PROD");
			ResultSet rs = ps.executeQuery();
			TreeMap<Double,Produto> mapproduto = new TreeMap<Double,Produto>();
			if (rs.next())
                        {
                            do{
                                mapproduto.put(rs.getDouble(1),new Produto(rs.getDouble(1),rs.getDouble(2), rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7),rs.getDate(8)));
                              }while(rs.next());
                        }
		  return mapproduto;
		  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no select na TPRODUTO", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}


public double selectMaxProduto()
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT MAX (CD_PROD) AS MAXIMO FROM TPRODUTO");
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			    return rs.getDouble("MAXIMO");
			else
			    return 0;
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no select na TPRODUTO", e.getMessage());
			return 0;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}	   
	
public int insertProduto(Produto p)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("INSERT INTO TPRODUTO(CD_PROD, CD_CAT, CD_MARCA, CD_BARRA_PROD, NM_PROD, QTD_PROD, VL_PROD, DT_VAL_PROD) VALUES (?,?, ?, ?, ?, ?, ?, ?)");
			ps.setDouble(1, p.getCD_PROD());
			ps.setDouble(2, p.getCD_CAT());
                        ps.setDouble(3, p.getCD_MARCA());
			ps.setString(4, p.getCD_BARRA_PROD());
			ps.setString(5, p.getNM_PROD());
			ps.setDouble(6, p.getQTD_PROD());
                        ps.setDouble(7, p.getVL_PROD());
			if (p.getDT_VAL_PROD() != null)
                            ps.setDate(8, new java.sql.Date (p.getDT_VAL_PROD().getTime()));
                        else
                            ps.setDate(8, null);
			ps.executeUpdate();
			return 0;
			  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no insert na TPRODUTO", e.getMessage());
			return 99;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public int updateProduto(Produto p)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("UPDATE TPRODUTO SET CD_CAT = ?, CD_MARCA = ?, CD_BARRA_PROD = ?, NM_PROD = ?, QTD_PROD = ?, VL_PROD = ?, DT_VAL_PROD = ? WHERE CD_PROD = ?");
			ps.setDouble(1, p.getCD_CAT());
                        ps.setDouble(2, p.getCD_MARCA());
			ps.setString(3, p.getCD_BARRA_PROD());
			ps.setString(4, p.getNM_PROD());
			ps.setDouble(5, p.getQTD_PROD());
                        ps.setDouble(6, p.getVL_PROD());
		        if (p.getDT_VAL_PROD() != null)
                            ps.setDate(7, new java.sql.Date (p.getDT_VAL_PROD().getTime()));
                        else
                            ps.setDate(7, null);
			ps.setDouble(8, p.getCD_PROD());
			ps.executeUpdate();
			return 0;
			  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no UPDATE na TPRODUTO", e.getMessage());
			return 99;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public Produto selectProdutoCodigo(String codigo)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_PROD, CD_CAT, CD_MARCA, CD_BARRA_PROD, NM_PROD, QTD_PROD, VL_PROD, DT_VAL_PROD FROM TPRODUTO WHERE CD_BARRA_PROD = ?");
			ps.setString(1, codigo);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			    return new Produto(rs.getDouble(1),rs.getDouble(2), rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7),rs.getDate(8));
                        else
                            return null;
                    }
			catch (SQLException e) {
                            TrataErro.imprimeErro("Erro no select na TPRODUTO", e.getMessage());
                            return null;
                            }
		finally{
			ConFactory.fechar(con,ps);
		}
	}
	
public ArrayList<Produto> selectAllProdutoDescricao(String descricao)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			descricao = descricao.toUpperCase();
			ps = con.prepareStatement("SELECT CD_PROD, CD_CAT, CD_MARCA, CD_BARRA_PROD, NM_PROD, QTD_PROD, VL_PROD, DT_VAL_PROD FROM TPRODUTO WHERE UPPER(NM_PROD) LIKE ? ORDER BY NM_PROD");
			ps.setString(1, "%"+descricao+"%");
			ResultSet rs = ps.executeQuery();
			ArrayList<Produto> lista = new ArrayList<Produto>();
			if (rs.next())
                        {
                            do {
			    lista.add(new Produto(rs.getDouble(1),rs.getDouble(2), rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7),rs.getDate(8)));
                                }while(rs.next());
                        }
		  return lista;
		  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no select na TPRODUTO", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}
}   