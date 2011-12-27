package telas;

import dao.DaoCategoria;
import dao.DaoEstorno;
import dao.DaoMarca;
import dao.DaoMotivo;
import dao.DaoProduto;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Estorno;
import model.Funcionario;
import model.Marca;
import model.Motivo;
import model.Produto;
import utilitarios.Formatador;

public class TelaTroca extends javax.swing.JDialog {
    
    Funcionario funcionarioglobal;

    public TelaTroca(java.awt.Frame parent, boolean modal, Produto p, Funcionario f) {
        super(parent, modal);
        initComponents();
        funcionarioglobal = f;
        preencherCbbMotivo();
        carregaConsulta(p);
    }

    public void carregaConsulta(Produto p)
    {
        //tipo 1 = Codigo de Barras 
         txtCodigoBarras.setText(p.getCD_BARRA_PROD());
         txtVlUnit.setText(Formatador.formataVirgula2(p.getVL_PROD()));
         txtProduto.setText(p.getNM_PROD());
 }
    public void preencherCbbMotivo()
    {
        DaoMotivo daomotivo = new DaoMotivo();
        ArrayList<Motivo> almotivo = daomotivo.selectAllMotivo();
         cbbMotivo.removeAllItems();
        cbbMotivo.addItem("Selecionar...");
        for(int k =0;k <almotivo.size();k++)
        {
            cbbMotivo.addItem(almotivo.get(k).getDS_MOTIVO());
        }
        cbbMotivo.addItem("<Cadastrar Novo Motivo>");
    }

    public Motivo obtemMotivoSelecionado()
    {
        DaoMotivo daomotivo = new DaoMotivo();
        TreeMap<String, Motivo> mapmotivo = (TreeMap<String, Motivo>) daomotivo.selectAllMotivoMap();
        return mapmotivo.get(cbbMotivo.getSelectedItem().toString());
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
        cbbMotivo = new javax.swing.JComboBox();
        txtVlUnit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 12));
        lblTitulo.setText("Troca Produto");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCodigoBarras.setEnabled(false);
        txtCodigoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBarrasActionPerformed(evt);
            }
        });

        jLabel2.setText("Código:");

        jLabel3.setText("Motivo:");

        jLabel4.setText("Descrição:");

        jLabel5.setText("Valor:");

        cbbMotivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        cbbMotivo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMotivoItemStateChanged(evt);
            }
        });
        cbbMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMotivoActionPerformed(evt);
            }
        });

        txtVlUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVlUnitKeyTyped(evt);
            }
        });

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        jLabel6.setText("Produto:");

        txtProduto.setEnabled(false);
        txtProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbMotivo, 0, 229, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(txtVlUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtVlUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cbbMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        btnCancelar.setText("Voltar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
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
                        .addGap(139, 139, 139)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                        .addComponent(btnConfirmar)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnConfirmar))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    private void txtCodigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBarrasActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbbMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMotivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMotivoActionPerformed


    private void cbbMotivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMotivoItemStateChanged
        // TODO add your handling code here:
        int qtdelementos = cbbMotivo.getItemCount();
        int elementosel = cbbMotivo.getSelectedIndex();
        if (qtdelementos == 0)
            return;

        if (elementosel != 0)
        {
            if(elementosel + 1 == qtdelementos)
            {
                String novomotivo = JOptionPane.showInputDialog(null, "Digite o novo motivo a ser cadastrado", "Cadastro de novo Motivo", JOptionPane.QUESTION_MESSAGE);
                if(novomotivo !=null)
                {
                    DaoMotivo damotivo = new DaoMotivo();
                    double seq = damotivo.selectMaxMotivo();
                    seq = seq + 1;
                    if (damotivo.insertMotivo(new Motivo(seq, novomotivo)) == 0)
                        JOptionPane.showMessageDialog(null, "Motivo incluido com sucesso!!");
                    preencherCbbMotivo();
                 }
            }
                 
        }
    }//GEN-LAST:event_cbbMotivoItemStateChanged

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
                //valida campos para inclusao
        if(txtCodigoBarras.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Obrigatório informar código!");
        else
        {
            if(txtVlUnit.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Obrigatório informar valor unitário!");
            else
            {
             if(cbbMotivo.getSelectedIndex() == 0)
                    JOptionPane.showMessageDialog(null, "Obrigatório selecionar o motivo!");
             else
              {
                    if(txtDescricao.getText().equals(""))
                        JOptionPane.showMessageDialog(null, "Obrigatório informar descrição!");
                    else
                    {String codigobarras = txtCodigoBarras.getText();
                    DaoProduto daoproduto = new DaoProduto();
                    Produto p = daoproduto.selectCodigoBarraProduto(codigobarras);
                    String descricao = txtDescricao.getText();
                    double motivo = obtemMotivoSelecionado().getCD_MOTIVO();
                    String valorunitariotxt = txtVlUnit.getText();
                    valorunitariotxt = valorunitariotxt.replaceAll(",", ".");
                    double valorunitario = Double.parseDouble(valorunitariotxt);
                    DaoEstorno daoestorno = new DaoEstorno();
                    double cdest = daoestorno.selectMaxEstorno();
                    cdest ++;
                    daoestorno.insertEstorno(new Estorno(cdest, motivo, p.getCD_PROD(), funcionarioglobal.getCD_FUNC(), null, valorunitario,descricao, null));
                    JOptionPane.showMessageDialog(null, "Troca registrada com sucesso!");
                    dispose();
                   }
                  }
                }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtVlUnitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVlUnitKeyTyped
        // TODO add your handling code here:
        String desc = txtVlUnit.getText();
        if (desc.length() >= 60)
            txtVlUnit.setText(desc.substring(0, 59));
}//GEN-LAST:event_txtVlUnitKeyTyped

    private void txtProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoActionPerformed
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
    private javax.swing.JComboBox cbbMotivo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCodigoBarras;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtVlUnit;
    // End of variables declaration//GEN-END:variables

}
