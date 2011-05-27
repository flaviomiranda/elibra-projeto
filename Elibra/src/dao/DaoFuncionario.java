package dao;

import java.sql.*;
import model.Funcionario;

import utilitarios.TrataErro;

public class DaoFuncionario {


public Funcionario selectFuncionario(double codigo)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT CD_FUNC, NM_FUNC, CD_ACESSO FROM TFUNCIONARIO WHERE CD_FUNC = ?");
			ps.setDouble(1, codigo);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
			    return new Funcionario(rs.getDouble(1),rs.getString(2),rs.getDouble(3));
			}else
			{
			    return null;
			}   
		    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no SELECT na TFUNCIONARIO", e.getMessage());
			return null;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}	
}   