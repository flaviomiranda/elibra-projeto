package dao;

import java.sql.*;
import java.util.ArrayList;
import model.FormaPagamento;
import utilitarios.TrataErro;

public class DaoFormaPagamento {

    public int insertFormaPagamento(FormaPagamento f)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("INSERT INTO TFORM_PGMTO VALUES (?, ?)");
			ps.setDouble(1, f.getCD_FORM_PGMTO());
			ps.setString(2, f.getNM_FORM_PGMTO());
			ps.executeUpdate();
			return 0;
			  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no INSERT na TFORM_PGMTO", e.getMessage());
			return 99;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}


    public FormaPagamento FormaPagamento(double codigo)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_FORM_PGMTO, NM_FORM_PGMTO FROM TFORM_PGMTO WHERE CD_FORM_PGMTO = ?");
			ps.setDouble(1, codigo);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
			    return new FormaPagamento(rs.getDouble(1),rs.getString(2));
			}else
			{
			    return null;
			}   
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TFORM_PGMTO", e);
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

public double selectMaxFormaPagamento()
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT MAX (CD_FORM_PGMTO) AS MAXIMO FROM TFORM_PGMTO");
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			    return rs.getDouble("MAXIMO");
			else
			    return 0;
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT MAX na TFORM_PGMTO", e);
			return 0;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

	
public FormaPagamento FormaPagamentoNome(String nome)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_FORM_PGMTO, NM_FORM_PGMTO FROM TFORM_PGMTO WHERE UPPER(NM_FORM_PGMTO) LIKE ?");
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
			    return new FormaPagamento(rs.getDouble(1),rs.getString(2));
			}else
			{
			    return null;
			}   
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TFORM_PGMTO", e);
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}
    
public ArrayList<FormaPagamento> selectAllFormaPagamento()
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_FORM_PGMTO, NM_FORM_PGMTO FROM TFORM_PGMTO ORDER BY CD_FORM_PGMTO");
                        ResultSet rs = ps.executeQuery();
			ArrayList<FormaPagamento> lista = new ArrayList<FormaPagamento>();
			if(rs.next()){
                        do{
			    lista.add(new FormaPagamento(rs.getDouble(1),rs.getString(2)));
		    }while(rs.next()); }
		  return lista;
		  }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TFORM_PGMTO", e);
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}
}   