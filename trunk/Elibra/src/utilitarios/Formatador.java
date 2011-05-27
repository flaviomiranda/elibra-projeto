

package utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Formatador {
   
    
   public static String formataVirgula2(double x) {
            String y =  String.format("%.2f", x);
            y = y.replace(".", ",");
            return y;
   }
   public static String formataVirgula3(double x) {
            String y =  String.format("%.3f", x);
            y = y.replace(".", ",");
            return y;
   }
   public static String formataPonto(double x) {
            return String.format("%.2f", x);
   }

   public static String linhaTracejada(int x){
           String saida="";
           for(int i =0; i<x ; i++)
               {
               saida+="-";
    }
   return saida;
    }
   
   public static String incluiEspacos(String variavel, int x){
           for(int i =0; i<x ; i++)
               {
               variavel+=" ";
               }
   return variavel;
   }

   public static String zerosEsquerda(int valor) {
    NumberFormat formatter = new DecimalFormat("000");
    String s = formatter.format(valor);
    return s;
    }
    public static String brancosEsquerda(int valor) {
    NumberFormat formatter = new DecimalFormat("####");
    String s = formatter.format(valor);
    return s;
}

   public static String SubString(String valor, int posini, int posfim)
    {
       if(valor.length() < posfim)
       {
           do{
           valor+=" ";
           } while (valor.length() < posfim);
       }
       return valor.substring(posini,posfim);
   }

   public static String tamanhoDe(String valor, int qtd)
    {
       do{
         valor+=" ";
       }while(valor.length() < qtd);
       return valor;
   }

   public static String tamanhoDeEsquerda(String valor, int qtd)
    {
       String aux="";
       int cont=valor.length();
       do{
         aux+=" ";
         cont++;
       }while(cont < qtd);
       aux+=valor;
       return aux;
   }

}
