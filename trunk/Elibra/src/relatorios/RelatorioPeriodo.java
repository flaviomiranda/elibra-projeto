/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RelatorioRelacaoProdutos.java
 *
 * Created on 27/05/2011, 13:05:00
 */
package relatorios;

import dao.DaoCategoria;
import utilitarios.Formatador;
import dao.DaoMarca;
import dao.DaoProduto;
import dao.DaoVendaProduto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;
import model.Categoria;
import model.Marca;
import model.Produto;
import model.Venda;
import model.VendaProduto;
import utilitarios.Formatador;
import utilitarios.Impressao;


public class RelatorioPeriodo extends javax.swing.JDialog {

    /** Creates new form RelatorioRelacaoProdutos */
    public RelatorioPeriodo(java.awt.Frame parent, boolean modal, ArrayList<Venda> lista) {
        super(parent, modal);
        initComponents();
        carregaRelatorio(lista);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCabecalho = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRelatorio = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCabecalho.setFont(new java.awt.Font("Courier New", 1, 12));
        lblCabecalho.setText("Descrição                                                     Categoria                       Marca                           Quantidade  Vl Unit.   \t DT VENC.");

        txtRelatorio.setColumns(20);
        txtRelatorio.setFont(new java.awt.Font("Courier New", 0, 12));
        txtRelatorio.setRows(5);
        txtRelatorio.setText("\n");
        jScrollPane1.setViewportView(txtRelatorio);

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Imprimir");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Relação de Produtos Cadastrados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCabecalho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE))
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 962, Short.MAX_VALUE)
                            .addComponent(jButton2)
                            .addGap(18, 18, 18)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(331, 331, 331))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(lblCabecalho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String texto = txtRelatorio.getText();
        System.out.println(texto);
        Impressao p = new Impressao();
        p.imprime(texto);
    }//GEN-LAST:event_jButton2ActionPerformed
    public void carregaRelatorio(ArrayList<Venda> lista)
    {
    	DaoCategoria daocategoria = new DaoCategoria();
    	DaoMarca daomarca = new DaoMarca();
    	DaoProduto daoproduto = new DaoProduto();
    	TreeMap<Integer,Categoria> mapcateg = (TreeMap) daocategoria.selectAllCategoriaMapCod();
    	TreeMap<Integer,Marca> mapmarca = (TreeMap) daomarca.selectAllMarcaMap();
        TreeMap<Double,Produto> mapproduto = daoproduto.selectAllProdutoMap();
        String det="";
        for(int x=0; x<lista.size();x++)
        {
            Venda v = lista.get(x);
            det+="Detalhe da Venda: " + v.getCD_VENDA() + "\n";
            DaoVendaProduto daovendaproduto = new DaoVendaProduto();
            ArrayList<VendaProduto> listavendaproduto = new ArrayList<VendaProduto>();
            listavendaproduto = daovendaproduto.selectVendaProduto(v.getCD_VENDA());
            for(int y=0;y<listavendaproduto.size();y++)
            {
                VendaProduto vp = listavendaproduto.get(y);
                Produto p = mapproduto.get(vp.getCD_PROD());
                Marca m = mapmarca.get((int)p.getCD_MARCA());
    		Categoria c = mapcateg.get((int)p.getCD_CAT());
            Date dtvalidade = p.getDT_VAL_PROD();
            String dtvalidadetxt="";
            if (dtvalidade != null){
               SimpleDateFormat formatador = new SimpleDateFormat("dd'/'MM'/'yyyy");
               dtvalidadetxt = formatador.format(dtvalidade);
               dtvalidadetxt = dtvalidadetxt.substring(3);
            }
            String qtdprod = Integer.toString((int)p.getQTD_PROD());
            qtdprod = Formatador.tamanhoDe(qtdprod, 10);
            String vlunit = Formatador.formataVirgula2(p.getVL_PROD());
            vlunit = Formatador.tamanhoDe(vlunit, 7);
            String lin =  Formatador.tamanhoDe(p.getNM_PROD(),60)+ "  " + Formatador.tamanhoDe(c.getDS_CAT(),30) + "  " +  Formatador.tamanhoDe(m.getNM_MARCA(),30) + "  " +
    		qtdprod + "  R$ " + vlunit + "  " + dtvalidadetxt + "\n";
            det +=lin;
            }
            txtRelatorio.setText(det);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCabecalho;
    private javax.swing.JTextArea txtRelatorio;
    // End of variables declaration//GEN-END:variables
}
