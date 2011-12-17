package utilitarios;

import dao.DaoFormaPagamento;
import dao.DaoFuncionario;
import dao.DaoProduto;
import dao.DaoVenda;
import dao.DaoVendaProduto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import model.ChaveCarrinho;
import model.Produto;
import model.Venda;
import model.VendaProduto;

  public class ImprimirCupom {

      Venda venda;
      String arqnotafiscal;
      double totvenda;
    private Bematech4200 bematech4200 = new Bematech4200();
          
       public int iniciarImpressao(Venda v){
            venda = v;

          if(bematech4200.verificarStatus() == 0){  //verifica se conexao esta ok
              bematech4200.preparaImpressora();
              arqnotafiscal="";
              imprimirCabecalho();
              imprimirDetalhes();
              if (v.getVL_DESC() > 0)
                  imprimirRodapeDesc();
              else
                  imprimirRodape();
              bematech4200.acionaGuilhotina(1);//0 corta parcialmente, 1 corta o papel completamente
              bematech4200.fecharPorta();
              geraNotaFiscal();
           }  
           else  
               JOptionPane.showMessageDialog(null, "Impressão de Dados das Atendentes cancelada!" , "Erro de Impressão", JOptionPane.ERROR_MESSAGE);

            return(1);
     
       }

       private void geraNotaFiscal()
      {
        String arqlog = arqnotafiscal;
        if(arqlog == null)
            arqlog = "";

        try {
            FileWriter fw = new FileWriter(new File("./notas/"+(int)venda.getCD_VENDA() +".txt"));
            fw.write(arqlog);
            fw.close();
        }
        catch(IOException io)
        {
            JOptionPane.showMessageDialog(null, "Erro ao criar cupom eletronico");
        }
       }

       private void imprimirDetalhes()
      {
           String msg ="";
           totvenda=0;
           ArrayList<VendaProduto> vendaproduto = new ArrayList<VendaProduto>();
            DaoVendaProduto daovendaproduto = new DaoVendaProduto();
            vendaproduto = daovendaproduto.selectVendaProduto(venda.getCD_VENDA());
            DaoProduto daoproduto = new DaoProduto();
            for (int x=0;x<vendaproduto.size();x++)
            {
               String qtx;
                String descx;
                String vlunitx;
                String vlx;
                VendaProduto vprod = vendaproduto.get(x);
                Produto p = daoproduto.selectProduto((int)vprod.getCD_PROD());
                //formata variaveis do relatorio
                /*
                qtx = Formatador.brancosEsquerda((int)vprod.getQTD_PROD());
                descx = Formatador.SubString(p.getNM_PROD(), 0, 49);
                vlunitx = Formatador.formataVirgula2((int)vprod.getVL_UNIT_PROD());
                totvenda += vprod.getCD_PROD() * vprod.getVL_UNIT_PROD();
                vlx = Formatador.formataVirgula2(vprod.getCD_PROD() * vprod.getVL_UNIT_PROD());
                msg = "\n "+ qtx + " " + descx + " " + vlunitx + " " + vlx;*/

                msg="\n"+Formatador.zerosEsquerda((int)vprod.getNSEQ_VENDA_PROD())+ "  "+ Formatador.tamanhoDe(p.getCD_BARRA_PROD(),13) + "  " + Formatador.SubString(p.getNM_PROD(), 0, 28);                arqnotafiscal += msg;
                bematech4200.bematechTx(msg);
                msg="\n"+Formatador.tamanhoDeEsquerda(Formatador.formataVirgula3((int)vprod.getQTD_PROD()),8)+ " UND x   "+ Formatador.tamanhoDeEsquerda(Formatador.formataVirgula2(p.getVL_PROD()),11);
                msg+="          " + Formatador.tamanhoDeEsquerda(Formatador.formataVirgula2(p.getVL_PROD()*(int)vprod.getQTD_PROD()),10);
                arqnotafiscal += msg;
                bematech4200.bematechTx(msg);
                totvenda += vprod.getQTD_PROD() * vprod.getVL_UNIT_PROD();
            }
      }

       private void imprimirCabecalho() {
           String msg ="";
           msg = "\nELIBRA COMERCIO DE SALVADOS DE SINISTRO LTDA";
           arqnotafiscal += msg;
           //bematech4200.formataTX(msg,2, 0, 0, 1, 1);
           bematech4200.bematechTx(msg);
           msg = "\nAV. BOTUQUARA, 245 CEP:04135-20";
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           msg = "\nBOSQUE DA SAUDE - SAO PAULO-SP TEL:(11)3571-0500";
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           msg = "\n------------------------------------------------";
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           String dt = Formatador.obtemHoraFormatada(1);
           String hr = Formatador.obtemHoraFormatada(2);
           msg = "\n"+dt + " " + hr + "                   COD:" +Formatador.zerosEsquerda6((int)venda.getCD_VENDA());
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           msg = "\n------------------------------------------------";
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           msg ="\nITEM CODIGO         DESCRICAO";
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           msg ="\nQTD.     UN      VL.UNIT.(R$)       VL.ITEM(R$)";
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           msg = "\n------------------------------------------------";
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
       }  

         private void imprimirRodape() {
           String msg ="";
           msg = "\n------------------------------------------------";
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           msg = Formatador.tamanhoDe("\nTOTAL ", 38);
           msg += "R$ " + Formatador.formataVirgula2(totvenda);
           arqnotafiscal += msg;
           //bematech4200.bematechTx(msg);
           bematech4200.formataTX(msg, 2, 0, 0, 0, 1);
           DaoFormaPagamento daoformapagamento = new DaoFormaPagamento();
           msg = "\nFORMA DE PAGAMENTO: " + (daoformapagamento.FormaPagamento(venda.getCD_FORM_PGMTO())).getNM_FORM_PGMTO().toUpperCase();
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           DaoFuncionario daofuncionario = new DaoFuncionario();
           msg = "\nOPERADOR: " + daofuncionario.selectFuncionario(venda.getCD_FUNC()).getNM_FUNC().toUpperCase();
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           msg = "\n------------------------------------------------";
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           msg = "\nESTE CUPOM NAO POSSUI VALOR FISCAL";
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
       }

          private void imprimirRodapeDesc() {
           String msg ="";
           msg = "\n------------------------------------------------";
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           msg = Formatador.tamanhoDe("\nTOTAL ", 38);
           msg += "R$ " + Formatador.formataVirgula2(totvenda);
           arqnotafiscal += msg;
           bematech4200.formataTX(msg, 2, 0, 0, 0, 1);
           msg = Formatador.tamanhoDe("\nDESCONTO ", 38);
           msg += "R$-" + Formatador.formataVirgula2(venda.getVL_DESC());
           arqnotafiscal += msg;
           bematech4200.formataTX(msg, 2, 0, 0, 0, 1);
           msg = Formatador.tamanhoDe("\nTOTAL COM DESCONTO ", 38);
           double totcomdesc = totvenda - venda.getVL_DESC();
           msg += "R$ " + Formatador.formataVirgula2(totcomdesc);
           arqnotafiscal += msg;
           bematech4200.formataTX(msg, 2, 0, 0, 0, 1);
           DaoFormaPagamento daoformapagamento = new DaoFormaPagamento();
           msg = "\nFORMA DE PAGAMENTO: " + (daoformapagamento.FormaPagamento(venda.getCD_FORM_PGMTO())).getNM_FORM_PGMTO().toUpperCase();
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           DaoFuncionario daofuncionario = new DaoFuncionario();
           msg = "\nOPERADOR: " + daofuncionario.selectFuncionario(venda.getCD_FUNC()).getNM_FUNC().toUpperCase();
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           msg = "\n------------------------------------------------";
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
           msg = "\nESTE CUPOM NAO POSSUI VALOR FISCAL";
           arqnotafiscal += msg;
           bematech4200.bematechTx(msg);
       }

}
