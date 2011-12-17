

package utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

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

    public static String zerosEsquerda6(int valor) {
    NumberFormat formatter = new DecimalFormat("000000");
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
       if (valor.length() > qtd)
       {
           return valor.substring(0, qtd);
       }else{

       do{
         valor+=" ";
       }while(valor.length() < qtd);
       return valor;
        }
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

   public static String obtemHoraFormatada(int i)
    {
       // 1 = DATA
       // 2 = HORA
       String txt="";
        Locale locale = new Locale("pt","BR");
        GregorianCalendar calendar = new GregorianCalendar();
        if (i == 1){
        SimpleDateFormat formatador = new SimpleDateFormat("dd'/'MM'/'yyyy",locale);
        txt = formatador.format(calendar.getTime());
        }
        else{if( i==2){
             SimpleDateFormat formatador = new SimpleDateFormat("HH':'mm':'ss",locale);
             txt = formatador.format(calendar.getTime());
            }

        }
        return txt;
    }


}
