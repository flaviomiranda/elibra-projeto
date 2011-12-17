
package telas;

import dao.DaoCategoria;
import dao.DaoMarca;
import dao.DaoProduto;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Marca;
import model.Produto;
import utilitarios.Formatador;

public class TelaProdutoConsulta extends javax.swing.JDialog {

    public TelaProdutoConsulta(java.awt.Frame parent, boolean modal, Produto p) {
        super(parent, modal);
        initComponents();
        btnConfirmar.setVisible(false);
        preencherCbbCategoria();
        preencherCbbMarca();
        carregaConsulta(p);
    }

    public void carregaConsulta(Produto p)
    {
        //tipo 1 = Codigo de Barras 
         txtCodigoBarras.setText(p.getCD_BARRA_PROD());
         txtDescricao.setText(p.getNM_PROD());
         txtQuantidade.setText(Integer.toString((int)p.getQTD_PROD()));
         txtValorUnitario.setText(Formatador.formataVirgula2(p.getVL_PROD()));
         DaoMarca daomarca = new DaoMarca();
         Marca m = daomarca.selectMarca(p.getCD_MARCA());
         DaoCategoria daocategoria = new DaoCategoria();
         Categoria c = daocategoria.selectCategoria(p.getCD_CAT());
         cbbCategoria.setSelectedItem(c.getDS_CAT());
         cbbMarca.setSelectedItem(m.getNM_MARCA());
         Date dtvalidade = p.getDT_VAL_PROD();
         String dtvalidadetxt="";
         if (dtvalidade != null){
            SimpleDateFormat formatador = new SimpleDateFormat("dd'/'MM'/'yyyy");
            dtvalidadetxt = formatador.format(dtvalidade);
            dtvalidadetxt = dtvalidadetxt.substring(3);
         }
         txtDataValidade.setText(dtvalidadetxt);     
 }
    public void preencherCbbCategoria()
    {
        DaoCategoria daocategoria = new DaoCategoria();
        ArrayList<Categoria> alcategoria = daocategoria.selectAllCategoria();
         cbbCategoria.removeAllItems();
        cbbCategoria.addItem("Selecionar...");
        for(int k =0;k <alcategoria.size();k++)
        {
            cbbCategoria.addItem(alcategoria.get(k).getDS_CAT());
        }
        cbbCategoria.addItem("<Cadastrar Nova Categoria>");
    }

    public Categoria obtemCategoriaSelecionada()
    {
        DaoCategoria daocategoria = new DaoCategoria();
        TreeMap<String, Categoria> mapcategoria = (TreeMap<String, Categoria>) daocategoria.selectAllCategoriaMap();
        return mapcategoria.get(cbbCategoria.getSelectedItem().toString());
    }

    public void preencherCbbMarca()
    {
        DaoMarca daomarca = new DaoMarca();
        ArrayList<Marca> almarca = daomarca.selectAllMarca();
        cbbMarca.removeAllItems();
        cbbMarca.addItem("Selecionar...");
        for(int k =0;k <almarca.size();k++)
        {
            cbbMarca.addItem(almarca.get(k).getNM_MARCA());
        }
        cbbMarca.addItem("<Cadastrar Nova Marca>");
    }
    
    public Marca obtemMarcaSelecionada()
    {
        DaoMarca daomarca = new DaoMarca();
        TreeMap<String, Marca> mapmarca = (TreeMap<String, Marca>) daomarca.selectAllMarcaMap();
        return mapmarca.get(cbbMarca.getSelectedItem().toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtCodigoBarras = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbbCategoria = new javax.swing.JComboBox();
        cbbMarca = new javax.swing.JComboBox();
        txtDescricao = new javax.swing.JTextField();
        txtValorUnitario = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        txtDataValidade = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("##/####");
            txtDataValidade = new javax.swing.JFormattedTextField(cpf);
        }
        catch (Exception e){
        }
        btnCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitulo.setText("Consulta de Produto");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCodigoBarras.setEnabled(false);
        txtCodigoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBarrasActionPerformed(evt);
            }
        });

        jLabel2.setText("Código:");

        jLabel3.setText("Categoria:");

        jLabel4.setText("Marca:");

        jLabel5.setText("Descrição:");

        jLabel6.setText("Valor Unitário:");

        jLabel7.setText("Quantidade:");

        jLabel8.setText("Data de Validade:");

        cbbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        cbbCategoria.setEnabled(false);
        cbbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbCategoriaItemStateChanged(evt);
            }
        });
        cbbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbCategoriaActionPerformed(evt);
            }
        });

        cbbMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        cbbMarca.setEnabled(false);
        cbbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMarcaItemStateChanged(evt);
            }
        });

        txtDescricao.setEnabled(false);
        txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescricaoKeyTyped(evt);
            }
        });

        txtValorUnitario.setEnabled(false);
        txtValorUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorUnitarioActionPerformed(evt);
            }
        });

        txtQuantidade.setEnabled(false);

        txtDataValidade.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbbMarca, javax.swing.GroupLayout.Alignment.LEADING, 0, 229, Short.MAX_VALUE)
                        .addComponent(txtValorUnitario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addComponent(txtDataValidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbbCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodigoBarras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnCancelar.setText("Voltar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jButton1.setText("Alterar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnConfirmar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(jButton1)
                    .addComponent(btnConfirmar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    private void txtCodigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBarrasActionPerformed

    private void txtValorUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorUnitarioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbCategoriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    txtDescricao.setEnabled(true);
    cbbCategoria.setEnabled(true);
    cbbMarca.setEnabled(true);
    txtValorUnitario.setEnabled(true);
    txtQuantidade.setEnabled(true);
    txtDataValidade.setEnabled(true);
    btnCancelar.setText("Cancelar");
    btnConfirmar.setVisible(true);
    txtDescricao.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed


    private void cbbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbCategoriaItemStateChanged
        // TODO add your handling code here:
        int qtdelementos = cbbCategoria.getItemCount();
        int elementosel = cbbCategoria.getSelectedIndex();
        if (qtdelementos == 0)
            return;

        if (elementosel != 0)
        {
            if(elementosel + 1 == qtdelementos)
            {
                String novacategoria = JOptionPane.showInputDialog(null, "Digite a Nova Categoria a ser Cadastrada", "Cadastro de Nova Categoria", JOptionPane.QUESTION_MESSAGE);
                if(novacategoria !=null)
                {
                    DaoCategoria daocategoria = new DaoCategoria();
                    double seq = daocategoria.selectMaxCategoria();
                    seq = seq + 1;
                    if (daocategoria.insertCategoria(new Categoria(seq, novacategoria)) == 0)
                        JOptionPane.showMessageDialog(null, "Categoria Incluida com Sucesso!!");
                    preencherCbbCategoria();
                 }
            }
                 
        }
    }//GEN-LAST:event_cbbCategoriaItemStateChanged

    private void cbbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMarcaItemStateChanged
        // TODO add your handling code here:
        int qtdelementos = cbbMarca.getItemCount();
        int elementosel = cbbMarca.getSelectedIndex();
        if (qtdelementos == 0)
            return;

        if (elementosel != 0)
        {
            if(elementosel + 1 == qtdelementos)
            {
                String novamarca = JOptionPane.showInputDialog(null, "Digite a Nova Marca a ser Cadastrada", "Cadastro de Nova Marca", JOptionPane.QUESTION_MESSAGE);
                cbbMarca.setSelectedIndex(0);
                if(novamarca !=null)
                {
                    DaoMarca daomarca = new DaoMarca();
                    Marca m = daomarca.selectMarcaNome(novamarca.toUpperCase());
                    if (m !=null)
                    {
                        JOptionPane.showMessageDialog(null, "Marca Já Existe");
                        return;
                    }
                    double seq = daomarca.selectMaxMarca();
                    seq = seq + 1;
                    if (daomarca.InsertMarca(new Marca(seq, novamarca)) == 0)
                        JOptionPane.showMessageDialog(null, "Marca Incluida com Sucesso!!");
                        preencherCbbMarca();
                 }
            }
              
        }
    }//GEN-LAST:event_cbbMarcaItemStateChanged

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
                //valida campos para inclusao
        if(txtCodigoBarras.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Obrigatório Informar Código!");
        else
        {
            if(txtDescricao.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Obrigatório Informar Descrição!");
            else
            {
             if(cbbCategoria.getSelectedIndex() == 0)
                    JOptionPane.showMessageDialog(null, "Obrigatório Selecionar a Categoria!");
             else
              {
                if(cbbMarca.getSelectedIndex() == 0)
                    JOptionPane.showMessageDialog(null, "Obrigatório Selecionar a Marca!");
                else
                {
                 if(txtValorUnitario.getText().equals(""))
                   JOptionPane.showMessageDialog(null, "Obrigatório Informar o Valor Unitário!");
                 else
                 {
                    if(txtQuantidade.getText().equals(""))
                   JOptionPane.showMessageDialog(null, "Obrigatório Informar a Quantidade!");
                    else
                    {
                    String codigobarras = txtCodigoBarras.getText();
                    String descricao = txtDescricao.getText();
                    double categoria = obtemCategoriaSelecionada().getCD_CAT();
                    double marca = obtemMarcaSelecionada().getCD_MARCA();
                    String valorunitariotxt = txtValorUnitario.getText();
                    valorunitariotxt = valorunitariotxt.replaceAll(",", ".");
                    double valorunitario = Double.parseDouble(valorunitariotxt);
                    double quantidade = Double.parseDouble(txtQuantidade.getText());
                    Date dtvalidade = null;
                    if (txtDataValidade != null){
                    String txtdatavalidade = txtDataValidade.getText();
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    
                    try {
                        dtvalidade = (java.util.Date) format.parse(txtdatavalidade);
                        } catch (ParseException ex) {
                        }
                    }
                    DaoProduto daoproduto = new DaoProduto();
                    Produto p = daoproduto.selectCodigoBarraProduto(codigobarras);
                    daoproduto.updateProduto(new Produto(p.getCD_PROD(),categoria, marca, codigobarras,descricao, quantidade, valorunitario, dtvalidade ));
                    JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso!");
                    dispose();
                   }
                  }
                }
               }
              }
            }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoKeyTyped
        // TODO add your handling code here:
        String desc = txtDescricao.getText();
        if (desc.length() >= 60)
            txtDescricao.setText(desc.substring(0, 59));
    }//GEN-LAST:event_txtDescricaoKeyTyped
/*
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaProdutoInclusao dialog = new TelaProdutoInclusao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
       
    }
 * 
 */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox cbbCategoria;
    private javax.swing.JComboBox cbbMarca;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCodigoBarras;
    private javax.swing.JTextField txtDataValidade;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables

}
