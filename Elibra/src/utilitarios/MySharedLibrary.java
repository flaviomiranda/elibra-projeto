package utilitarios;

import com.sun.jna.*;

public interface MySharedLibrary extends Library{  
     
           void ConfiguraTaxaSerial(int i);  
     
           int IniciaPorta(String PORTA);  
     
           int BematechTX(String texto);  
     
           int ConfiguraModeloImpressora(int i);  
     
           int FormataTX(String texto, int i, int j, int k, int l, int m);  
     
           int FechaPorta();  
     
           int PrinterReset();  
           
           int SelecionaQualidadeImpressao(int i);
     
           int AjustaLarguraPapel(int i);  
     
           int HabilitaEsperaImpressao(int i);  
     
           int Le_Status();  
          
           int AcionaGuilhotina(int i);
   }  