package dao;

import java.sql.*;
import java.util.ArrayList;
import model.VendaProduto;

import utilitarios.TrataErro;

public class DaoVendaProduto {


public ArrayList<VendaProduto> selectVendaProduto(double codigo)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_VENDA, NSEQ_VENDA_PROD, CD_PROD, QTD_PROD, VL_UNIT_PROD FROM TVENDA_PROD WHERE CD_VENDA = ?");
			ps.setDouble(1, codigo);
			ResultSet rs = ps.executeQuery();
			ArrayList<VendaProduto>  lista = new ArrayList<VendaProduto>();
			if (rs.next())
			{
			    do{
			        lista.add(new VendaProduto(rs.getDouble(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5)));
			    }while(rs.next());
			    return lista;
			}else
			{
			    return null;
			}   
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no select na TVENDA_PROD", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}	  
	
public int insertVendaProduto(VendaProduto p)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("INSERT INTO TVENDA_PROD(CD_VENDA, NSEQ_VENDA_PROD, CD_PROD, QTD_PROD, VL_UNIT_PROD) VALUES (?, ?, ?, ?, ?)");
			ps.setDouble(1, p.getCD_VENDA());
			ps.setDouble(2, p.getNSEQ_VENDA_PROD());
			ps.setDouble(3, p.getCD_PROD());
			ps.setDouble(4, p.getQTD_PROD());
			ps.setDouble(5, p.getVL_UNIT_PROD());
			ps.executeUpdate();
			return 0;                  
			  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no INSERT na TVENDA_PROD", e.getMessage());
			return 99;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}	
}   