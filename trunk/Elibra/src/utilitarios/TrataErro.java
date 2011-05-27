package utilitarios;

import javax.swing.JOptionPane;

public class TrataErro {

   public static void imprimeErro(String msg, String msgErro) {   
		      System.err.println(msg);   
		      System.out.println(msgErro); 
		      ArquivoLog al = new ArquivoLog();
		      al.GravaLog(msg, msgErro);

		      JOptionPane.showMessageDialog(null, "Ocorreu um Erro, entre em contato com o Administrador", "Erro crítico", 0);
		      System.exit(0);   
   }
   public static void imprimeErro(String msg, Exception e) {
		      System.err.println(msg);
		      ArquivoLog al = new ArquivoLog();
		      al.GravaLog(msg, e);
		      JOptionPane.showMessageDialog(null, "Ocorreu um Erro, entre em contato com o Administrador", "Erro crítico", 0);
		      System.exit(0);
   }
}
