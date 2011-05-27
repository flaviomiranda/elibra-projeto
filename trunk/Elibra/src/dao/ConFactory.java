package dao;

import java.sql.Connection;   
import java.sql.DriverManager;   
import java.sql.PreparedStatement;
import java.sql.SQLException;   

import utilitarios.TrataErro;
  
public class ConFactory {   
      
   public static final int ORACLE = 0;   
   private static final String OracleDriver = "oracle.jdbc.driver.OracleDriver";   
  
   private static Connection conexao(String url, String nome, String senha, int banco) throws ClassNotFoundException, SQLException {   
      switch (banco) {         
      case ORACLE:            
         Class.forName(OracleDriver);   
         break;   
      }   
      return DriverManager.getConnection(url, nome, senha);   
   }
   
   public static Connection conectar(int banco) {   
	      try {   
	         return ConFactory.conexao("jdbc:oracle:thin:@localhost:1521:XE", "rafael", "rafael", banco);
	      } 
	      catch (ClassNotFoundException e) {   
	    	  TrataErro.imprimeErro("Erro ao carregar o driver", e);
	    	  return null;
	      } 
	      catch (SQLException e) {   
	    	  TrataErro.imprimeErro("Erro ao conectar", e);
	    	  return null;
	      }   
	   }   
	  
	   public static void fechar(Connection con, PreparedStatement comando) {   
	      try {   
	         comando.close();
  	         con.close();
	         System.out.println("Conexao Fechada");
	      } catch (SQLException e) {   
	         TrataErro.imprimeErro("Erro ao fechar conexao", e.getMessage());
	      }   
	   }   

   
   
   
   
   
}  
