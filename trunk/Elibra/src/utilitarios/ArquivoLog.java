package utilitarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;


public class ArquivoLog {

    String nomeArquivo = "arqLog.dat";

    public void GravaLog (String msg, String msgerro)
    {
        String arqlog = lerArquivo();
        if(arqlog == null)
            arqlog = "";
        String timestamp = obtemTimeStamp();
        arqlog += System.getProperty("line.separator") + timestamp + " - " + msg;
        arqlog += System.getProperty("line.separator") + timestamp + " - " + msgerro;

        try {
            FileWriter fw = new FileWriter(new File("./log/"+nomeArquivo));
            fw.write(arqlog);
            fw.close();
        }
        catch(IOException io)
        {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar LOG");
        }
      }


    public void GravaLog (String msg, Exception e)
    {
        String arqlog = lerArquivo();
        if(arqlog == null)
            arqlog = "";
        String timestamp = obtemTimeStamp();
        arqlog += System.getProperty("line.separator") + timestamp +  " - " + msg;
        arqlog += System.getProperty("line.separator") + timestamp +  " - " + e.getMessage();
        arqlog += System.getProperty("line.separator") + timestamp +  " - " + e.getLocalizedMessage();
        arqlog += System.getProperty("line.separator") + timestamp +  " - " + e.getCause();
        arqlog += System.getProperty("line.separator") + timestamp +  " - " + e.getClass();
        try {
            FileWriter fw = new FileWriter(nomeArquivo);
            fw.write(arqlog);
            fw.close();
        }
        catch(IOException io)
        {
            JOptionPane.showMessageDialog(null, "Erro ao Gerar LOG");
        }
      }

        public String lerArquivo()
    {
        String arqlog = "";
        try {
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);

            while(true)
            {
                String txt = br.readLine();
                if(txt == null)
                    break;
                arqlog += txt + System.getProperty("line.separator");
            }
            br.close();
            fr.close();
            return(arqlog);
        }
        catch(IOException iox)
        {
            JOptionPane.showMessageDialog(null, iox.getMessage());
        }
        return(null);
    } 
    
    public String obtemHoraFormatada()
    {
        Locale locale = new Locale("pt","BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
        String txt = formatador.format(calendar.getTime());    
        return txt;
    } 
  public String obtemTimeStamp()
    {
        Locale locale = new Locale("pt","BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy'-'MM'-'dd'-'HH'.'mm'.'ss",locale);
        String txt = formatador.format(calendar.getTime());    
        return txt;
    }


}