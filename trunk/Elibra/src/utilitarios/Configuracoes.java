package utilitarios;

import java.io.*;

public class Configuracoes {

    static String nomearquivo = "configuracao.txt";
    
    public static void setParametro(String p, String v)
    {
        String arquivo = lerArquivo();
        arquivo +=p+"="+v;
        try {
            FileWriter fw = new FileWriter(nomearquivo);
            fw.write(arquivo);
            fw.close();
        }
        catch(IOException io)
        {
            TrataErro.imprimeErro("Erro ao gravar arquivo de Erro", io.getMessage());
        }   
    }

    public static String lerArquivo()
    {
        String texto = "";
        try {
            FileReader fr = new FileReader(nomearquivo);
            BufferedReader br = new BufferedReader(fr);
            while(true)
            {
                String linha = br.readLine();
                if(linha == null)
                    break;
                texto += linha + "\n";
            }
            br.close();
            fr.close();
            return(texto);
        }
        catch(IOException iox)
        {
            TrataErro.imprimeErro("Erro ao ler arquivo: " + nomearquivo, iox.getMessage());
        }
        return(null);
    }
        
     public static String getParametro(String p)
    {
        String texto = "";
        try {
            FileReader fr = new FileReader(nomearquivo);
            BufferedReader br = new BufferedReader(fr);
            while(true)
            {
                String linha = br.readLine();
                if(linha == null)
                    break;
                else
                {
                    int y=0;
                    for(int x=0;x<linha.length(); x++)
                    {
                        if (linha.substring(x,x+1).equals("="));
                        {
                            y=x;
                            break;
                        }
                    }
                    if (linha.substring(0,y).equals(p));
                       {
                        texto = linha.substring(y+1,linha.length());
                        break;
                        }
                
                }
            }
            br.close();
            fr.close();
            return(texto);
        }
        catch(IOException iox)
        {
            TrataErro.imprimeErro("Erro ao buscar parametro no arquivo: " + nomearquivo, iox.getMessage());
        }
        return(null);                       
    }
}