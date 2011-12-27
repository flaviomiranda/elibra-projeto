package utilitarios;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.print.*;
import java.util.ArrayList;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import utilitarios.TrataErro;

public class Impressao {

    private static PrintService impressora;

    public Impressao() {
        //detectaImpressoras();
    }
    
    public int escolheImpressora()
    {
        int ret =0;
        ArrayList<PrintService> listaimpressora = listaImpressoras();
        if (!listaimpressora.isEmpty()){
            String impressoras="";
            for(int x=0; x< listaimpressora.size(); x++)
            {
                impressoras+=(x + ")  " + listaimpressora.get(x).getName() +"\n");
            }
            String opx = JOptionPane.showInputDialog(null, "Escolha a impressora que deseja utilizar: \n" + impressoras);
            int op=0;
            try {
            op = Integer.parseInt(opx);
                }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Opção inválida");
                ret =  2;
            } 
            if (op > listaimpressora.size())
            {
                JOptionPane.showMessageDialog(null, "Opção inválida");
                ret =  2;
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Não foram encontradas impressoras instaladas");
            ret = 3;
            }
        return ret;
    }
       
      
   

    public ArrayList<PrintService> listaImpressoras() {
        ArrayList<PrintService> lista = new ArrayList<PrintService>();
        try {
            
            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
            for (PrintService p: ps) {
                 lista.add(p);
                }
            }
        catch (Exception e) {
            TrataErro.imprimeErro("Erro ao listar impressoras", e.getMessage());
        }
        finally{
            return lista;
        }
    }

    public void detectaImpressoras() {
        try {
            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
            /*for (PrintService p: ps) {
                System.out.println("Impressora encontrada: " + p.getName());
                if (p.getName().contains("Text") || p.getName().contains("PDFCreator"))  {
                    System.out.println("Impressora Selecionada: " + p.getName());
                    impressora = p;
                    break;
                }
            }*/
            impressora = PrintServiceLookup.lookupDefaultPrintService();
        } catch (Exception e) {
           TrataErro.imprimeErro("Erro ao listar impressoras", e.getMessage());
        }
    }

    public synchronized boolean imprime(String texto) {
        detectaImpressoras();
        if (impressora == null) {
                TrataErro.imprimeErro("Nennhuma impressora foi encontrada. Instale uma impressora padr�o \r\n(Generic Text Only) e reinicie o programa.", "erro");
        } else {
            try {
                PrintRequestAttributeSet printerAttributes = new HashPrintRequestAttributeSet();
                printerAttributes.add(new JobName("Impressao", null));
                printerAttributes.add(OrientationRequested.LANDSCAPE);
                printerAttributes.add(MediaSizeName.ISO_A4); // informa o tipo de folha
                DocPrintJob dpj = impressora.createPrintJob();
                InputStream stream = new ByteArrayInputStream(texto.getBytes());
                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                Doc doc = new SimpleDoc(stream, flavor, null);
                dpj.print(doc,(PrintRequestAttributeSet)printerAttributes);
                return true;
            } catch (PrintException e) {
                TrataErro.imprimeErro("Erro ao imprimir documento", e.getMessage());
            }
        }
        return false;
    }
}