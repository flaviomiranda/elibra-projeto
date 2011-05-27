package dao;

import java.sql.*;
import model.Login;

import utilitarios.TrataErro;

public class DaoLogin {

	public boolean validarLogin(String login, String senha)
	{
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT LOGIN, CD_FUNC, SENHA FROM TLOGIN WHERE LOGIN= ? AND SENHA= ?");
			ps.setString(1, login);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		}
		catch (SQLException e) {
			TrataErro.imprimeErro("Erro ao Validar Login conexão", e.getMessage());
			return false;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
	}

                public Login selectLogin(String login)
        {
		Connection con = ConFactory.conectar(0);
		Login l=null;
                PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("SELECT LOGIN, CD_FUNC, SENHA FROM TLOGIN WHERE LOGIN= ?");
                        ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
                        rs.next();
			return new Login(rs.getString(1),rs.getDouble(2), rs.getString(3));
                    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no Select na TLOGIN", e.getMessage());
			return l;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
        }

        public int alterarSenha(String login, String senha)
        {
		Connection con = ConFactory.conectar(0);
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("UPDATE TLOGIN SET SENHA = ? WHERE LOGIN = ?");
                        ps.setString(1, senha);
			ps.setString(2, login);
			ps.executeUpdate();
			return 0;
                    }
			catch (SQLException e) {
			TrataErro.imprimeErro("Erro no UPDATE na TLOGIN", e.getMessage());
			return 99;
		}
		finally{
			ConFactory.fechar(con,ps);
		}
        }
	
}
