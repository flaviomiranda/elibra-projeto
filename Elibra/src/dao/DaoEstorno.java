package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Estorno;
import utilitarios.TrataErro;

public class DaoEstorno {

public Estorno selectEstorno(int codigo)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT NSEQ_ESTNO, CD_MOTIVO, CD_PROD, CD_FUNC, HR_EST, VL_UNIT_PROD, DS_MOTVO_ESTNO, DT_EST FROM TESTORNO WHERE NSEQ_ESTNO = ?");
			ps.setInt(1, codigo);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
			    return new Estorno(rs.getDouble(1),rs.getDouble(2),rs.getDouble(3),rs.getDouble(4), rs.getString(5), rs.getDouble(6), rs.getString(7), rs.getString(8));
			}else
			{
			    return null;
			}   
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no select na TESTORNO", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}	

public double selectMaxEstorno()
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
                        ps = con.prepareStatement("SELECT MAX (NSEQ_ESTNO) AS MAXIMO FROM TESTORNO");
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			    return rs.getDouble("MAXIMO");
			else
			    return 0;
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no select na TESTORNO", e.getMessage());
			return 0;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}	   
	
public int insertEstorno(Estorno e)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("INSERT INTO TESTORNO (NSEQ_ESTNO, CD_MOTIVO, CD_PROD, CD_FUNC, HR_EST, VL_UNIT_PROD, DS_MOTVO_ESTNO, DT_EST) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP, ?, ?, CURRENT_DATE)");
			ps.setDouble(1, e.getNSEQ_ESTNO());
			ps.setDouble(2, e.getCD_MOTIVO());
                        ps.setDouble(3, e.getCD_PROD());
			ps.setDouble(4, e.getCD_FUNC());
			//ps.setString(5, e.getHR_EST());
                        ps.setDouble(6, e.getVL_UNIT_PROD());
                        ps.setString(7, e.getDS_MOTVO_ESTNO());
                        //ps.setString(7, e.getDT_EST());
			ps.executeUpdate();
			return 0;                  
	           }
			catch (SQLException x) {
			TrataErro.imprimeErro("Erro no INSERT na TESTORNO", x.getMessage());
			return 99;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}
}   