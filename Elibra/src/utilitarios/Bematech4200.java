package utilitarios;


import javax.swing.JOptionPane;
import com.sun.jna.*;

public class Bematech4200 {

    MySharedLibrary lib = (MySharedLibrary) Native.loadLibrary("mp2032", MySharedLibrary.class);

       public int preparaImpressora()
       {
        lib.HabilitaEsperaImpressao(1);
        /*int HabilitaEsperaImpressao(int i) 
           + RETORNO:   1 (um)         : OK 
                       -2 (menos dois) : Parâmetro Inválido 
    
                Esta função habilita ou desabilita o envio do caracter ETX (03h), 
            que mantém a impressora ocupada até o término da impressão de todo o 
            texto (string). 
  
           + Parâmetro do tipo INTEIRO: 
           0 (zero)   : Desabilitado 
           1 (um)     : Habilitado 
           */
        
         lib.ConfiguraModeloImpressora(5);//Bematech MP 4200 TH nao-fiscal
         lib.IniciaPorta("COM5");
         //lib.SelecionaQualidadeImpressao(4);
        return 0;
       }

   public int verificarStatus() {  
     
           boolean status = true;  
           preparaImpressora();
           
           /* PORTA PARALELA
           + Códigos do Status da Impressora: ON-LINE                        : 144 
                                              OFF-LINE                       : 79 
                                              Fim de Papel                   : 40 
                                              Desligado ou Cabo Desconectado : 0 
            
   ////////////////////////////////////////////////////////////////////////////////           */
         
           int statusint = lib.Le_Status();
           if(statusint == 79){
    
               JOptionPane.showMessageDialog(null, "A impressora está OFF-LINE!" , "Status da Impressora", JOptionPane.ERROR_MESSAGE);  
     
               status = false;  
   
           }  
           else if(statusint == 40){

               do{
                   JOptionPane.showMessageDialog(null, "O PAPEL da impressora está no FIM! Troque a Bobina!" , "Status da Impressora", JOptionPane.ERROR_MESSAGE);
                   

               }while(lib.Le_Status() == 40);

               status = false;
     
           }  
          else if(statusint == 0){
     
               JOptionPane.showMessageDialog(null, "A impressora está DESLIGADA ou o cabo está DESCONECTADO!" , "Status da Impressora", JOptionPane.ERROR_MESSAGE);  
     
               status = false;  
     
           }  
     
            fecharPorta();
     
           if(status == true)  
               return(0);
           else 
           {
               TrataErro.imprimeErro("Erro ao chamar metodo de inicializacao, retorno: "+status);
                return(1);
           }
     }  

       public int fecharPorta()
       {
          int ret =  lib.FechaPorta();
          if (ret != 1)
               TrataErro.imprimeErro("Erro ao chamar metodo de fechar porta, retorno: "+ret);
           return ret;

       }

       public int bematechTx(String x)
       {
           int ret =  lib.BematechTX(x);
           if (ret != 1)
               TrataErro.imprimeErro("Erro ao chamar metodo de impressao bematechTx, retorno: "+ret);
           return ret;
       }

       public int acionaGuilhotina(int x)
       {
           int ret = lib.AcionaGuilhotina(x);
           if (ret != 1)
               TrataErro.imprimeErro("Erro ao acionar guilhotina, retorno: "+ret);
           return ret;
       }
       
       public int SelecionaQualidadeImpressao(int x)
       {
           int ret = lib.AcionaGuilhotina(x);
           if (ret != 1)
               TrataErro.imprimeErro("Erro ao acionar guilhotina, retorno: "+ret);
           return ret;
       }
       
       
       public int formataTX(String texto, int i, int j, int k, int l, int m){
                return lib.FormataTX(texto, i, j,k, l, m);
       }
   }  
