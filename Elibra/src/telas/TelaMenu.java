package telas;

import dao.DaoCategoria;
import dao.DaoFormaPagamento;
import dao.DaoFuncionario;
import dao.DaoLogin;
import dao.DaoMarca;
import dao.DaoProduto;
import dao.DaoVenda;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import model.Categoria;
import model.FormaPagamento;
import model.Funcionario;
import model.Login;
import model.Marca;
import model.Produto;
import model.Venda;
import relatorios.RelatorioPeriodo;
import relatorios.RelatorioRelacaoProdutos;
import utilitarios.Formatador;
import utilitarios.TrataErro;

public class TelaMenu extends javax.swing.JFrame {

    String loginglobal;
    Funcionario f;
    public TelaMenu() {
        initComponents();
    }
    public TelaMenu(String login) {
        initComponents();
        loginglobal = login;
        DaoLogin daologin = new DaoLogin();
        Login l = daologin.selectLogin(loginglobal);
        DaoFuncionario daofuncionario = new DaoFuncionario();
        f = daofuncionario.selectFuncionario(l.getCD_FUNC());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem12 = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        jButton1.setText("Nova Venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Consulta Preço");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jMenu1.setText("Conta");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenu1MouseReleased(evt);
            }
        });

        jMenuItem1.setText("Alterar Senha");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseReleased(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setText("Logout");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseReleased(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Produto");

        jMenu5.setText("Consultar por");

        jMenuItem4.setText("Código");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseReleased(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuItem5.setText("Descrição");
        jMenuItem5.setEnabled(false);
        jMenu5.add(jMenuItem5);

        jMenuItem6.setText("Categoria");
        jMenuItem6.setEnabled(false);
        jMenu5.add(jMenuItem6);

        jMenu2.add(jMenu5);
        jMenu2.add(jSeparator2);

        jMenuItem3.setText("Cadastrar");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem3MouseReleased(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Relatórios");

        jMenuItem7.setText("Relação de Produtos");
        jMenuItem7.setEnabled(false);
        jMenuItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem7MouseReleased(evt);
            }
        });
        jMenu6.add(jMenuItem7);
        jMenu6.add(jSeparator7);

        jMenuItem13.setText("Vendas Periodo");
        jMenuItem13.setEnabled(false);
        jMenuItem13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem13MouseReleased(evt);
            }
        });
        jMenu6.add(jMenuItem13);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Serviços");

        jMenu8.setText("Incluir");

        jMenuItem9.setText("Categoria");
        jMenuItem9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem9MouseReleased(evt);
            }
        });
        jMenuItem9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMenuItem9KeyReleased(evt);
            }
        });
        jMenu8.add(jMenuItem9);
        jMenu8.add(jSeparator3);

        jMenuItem8.setText("Forma de Pagamento");
        jMenuItem8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem8MouseReleased(evt);
            }
        });
        jMenu8.add(jMenuItem8);
        jMenu8.add(jSeparator4);

        jMenuItem10.setText("Marca");
        jMenuItem10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem10MouseReleased(evt);
            }
        });
        jMenu8.add(jMenuItem10);
        jMenu8.add(jSeparator5);

        jMenuItem11.setText("Motivo Estorno");
        jMenuItem11.setEnabled(false);
        jMenu8.add(jMenuItem11);

        jMenu7.add(jMenu8);
        jMenu7.add(jSeparator6);

        jMenuItem12.setText("Configura Impressão");
        jMenuItem12.setEnabled(false);
        jMenu7.add(jMenuItem12);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addGap(122, 122, 122))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseReleased
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(this, "Deseja fazer logout?");
        if (resp == JOptionPane.YES_OPTION)
        {
            this.dispose();
            TelaLogin l = new TelaLogin(null, true);
            l.setLocationRelativeTo(null);
            l.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem2MouseReleased

    private void jMenuItem3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MouseReleased
        // TODO add your handling code here:
            
            TelaProdutoInclusao l = new TelaProdutoInclusao(null, true);
            l.setLocationRelativeTo(null);
            l.setVisible(true);
    }//GEN-LAST:event_jMenuItem3MouseReleased

    private void jMenu1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseReleased
        // TODO add your handling code here:
            TelaAlteraSenha t = new TelaAlteraSenha(null, true,loginglobal);
            t.setLocationRelativeTo(null);
            t.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseReleased

    private void jMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseReleased
        // TODO add your handling code here:
            TelaAlteraSenha l = new TelaAlteraSenha(null, true, loginglobal);
            l.setLocationRelativeTo(null);
            l.setVisible(true);
    }//GEN-LAST:event_jMenuItem1MouseReleased

    private void jMenuItem4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseReleased
        // TODO add your handling code here:
        String codigobarra = JOptionPane.showInputDialog(null, "Digite o Código de Barras");
        if (codigobarra == null)
            return;
        DaoProduto daoproduto = new DaoProduto();
        Produto p = daoproduto.selectCodigoBarraProduto(codigobarra);
         if (p == null)
         {
             JOptionPane.showMessageDialog(null, "Produto não Cadastrado!");
             return;
         }
        TelaProdutoConsulta tpc = new TelaProdutoConsulta(this, true, p);
        tpc.setLocationRelativeTo(null);
        tpc.setVisible(true);
    }//GEN-LAST:event_jMenuItem4MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String codigo = JOptionPane.showInputDialog("Digite o Código de Barras");
        if (codigo == null)
            return;
        DaoProduto daoproduto = new DaoProduto();
        Produto p = daoproduto.selectCodigoBarraProduto(codigo);
         if (p == null)
         {
             JOptionPane.showMessageDialog(null, "Produto não Cadastrado!");
             return;
         }
          JOptionPane.showMessageDialog(null, "Produto.: " + p.getNM_PROD() + "\nValor......: R$ " + Formatador.formataVirgula2(p.getVL_PROD()), "Consulta Preço Produto", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            TelaCaixa l = new TelaCaixa(null, true, loginglobal);
            l.setLocationRelativeTo(null);
            l.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem7MouseReleased
 /*
        if (f.getCD_ACESSO() == 0)
        {
            Exception e = null;
            JOptionPane.showMessageDialog(null,"Você não possui acesso, consulte administrador");
            TrataErro.imprimeErro("O login: " + loginglobal + "tentou acessar o relatorio de relacao de produtos e nao possui acesso", e);
        }
        RelatorioRelacaoProdutos rrp = new RelatorioRelacaoProdutos(null, true);
        rrp.setLocationRelativeTo(null);
        rrp.setVisible(true);
   */     
    }//GEN-LAST:event_jMenuItem7MouseReleased

    private void jMenuItem9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuItem9KeyReleased

    }//GEN-LAST:event_jMenuItem9KeyReleased

    private void jMenuItem10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem10MouseReleased

//        DaoCategoria daocategoria = new DaoCategoria();
//        TreeMap<String, Categoria> mapcateg = (TreeMap) daocategoria.selectAllCategoriaMap();
//        ArrayList<Categoria> listacateg = daocategoria.selectAllCategoria();
//        String arraycateg[] = new String[listacateg.size()];
//        for(int x=0; x<listacateg.size(); x++)
//            arraycateg[x] = listacateg.get(x).getDS_CAT();
//
//        String categsel = (String) JOptionPane.showInputDialog(null, "Selecione em qual categoria será incluida a Marca", "Inclusão Marca", JOptionPane.QUESTION_MESSAGE, null, arraycateg, rootPaneCheckingEnabled) ;
//        if (categsel == null)
//            return;
//        Categoria c = mapcateg.get(categsel);
        
        String novamarca = JOptionPane.showInputDialog(null, "Digite a Nova Marca a ser Cadastrada", "Cadastro de Nova Marca", JOptionPane.QUESTION_MESSAGE);
        if(novamarca == null || novamarca.equals(""))
            return;
        DaoMarca daomarca = new DaoMarca();
        Marca m = daomarca.selectMarcaNome(novamarca.toUpperCase());
        if (m != null)
        {
            JOptionPane.showMessageDialog(null, "Marca Já Existe");
        }
        double seq = daomarca.selectMaxMarca();
        seq = seq + 1;       
        if (daomarca.InsertMarca(new Marca(seq, novamarca)) == 0)
            JOptionPane.showMessageDialog(null, "Marca Incluida com Sucesso!!");    
    }//GEN-LAST:event_jMenuItem10MouseReleased

    private void jMenuItem8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem8MouseReleased
        if (f.getCD_ACESSO() == 0)
        {
            JOptionPane.showMessageDialog(null,"Você não possui acesso, consulte administrador");
            return;
        }
        else
        {
           String formapgto = JOptionPane.showInputDialog(null, "Digite a Nova Forma de Pagamento");
           if (formapgto == null || formapgto.equals(""))
               return;
           DaoFormaPagamento daoformapagamento = new DaoFormaPagamento();
           FormaPagamento fp = daoformapagamento.FormaPagamentoNome(formapgto.toUpperCase());
           if (fp != null)
           {
               JOptionPane.showMessageDialog(null, "Forma de Pagamento Já Existe");
               return;
           }
            else
           {
               double seq = daoformapagamento.selectMaxFormaPagamento();
               seq++;
               if (daoformapagamento.insertFormaPagamento(new FormaPagamento(seq, formapgto)) == 0)
                        JOptionPane.showMessageDialog(null, "Forma de Pagamento Incluida com Sucesso!!");
            }
        }
    }//GEN-LAST:event_jMenuItem8MouseReleased

    private void jMenuItem13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem13MouseReleased
   
 /*     if (f.getCD_ACESSO() == 0)
        {
            JOptionPane.showMessageDialog(null,"Você não possui acesso, consulte administrador");
            return;
        }
 */
        String dtinicio = JOptionPane.showInputDialog(null, "Digite o Dia Inicial da Pesquisa(DD/MM/AAAA)");
        if (dtinicio == null || dtinicio.equals(""))
            return;
        String dtfim = JOptionPane.showInputDialog(null, "Digite o Dia Final da Pesquisa(DD/MM/AAAA)");
        if (dtfim == null || dtfim.equals(""))
            return;
        //recebe dados a ser pesquisado
        DaoVenda daovenda = new DaoVenda();
        ArrayList<Venda> lista = new ArrayList<Venda>();
        lista = daovenda.selectAllVendaBetweenDate(dtinicio, dtfim);
        if (lista.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Não Houveram Vendas neste Período");
            return;
        }
        RelatorioPeriodo rp = new RelatorioPeriodo(null, true,lista);
        rp.setLocationRelativeTo(null);
        rp.setVisible(true);

    }//GEN-LAST:event_jMenuItem13MouseReleased

    private void jMenuItem9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem9MouseReleased

         String novacategoria = JOptionPane.showInputDialog(null, "Digite a Nova Categoria a ser Cadastrada", "Cadastro de Nova Categoria", JOptionPane.QUESTION_MESSAGE);
                if(novacategoria !=null && !novacategoria.equals(""))
                {
                    DaoCategoria daocategoria = new DaoCategoria();
                    Categoria c = daocategoria.selectCategoriaNome(novacategoria.toUpperCase());
                    if (c != null)
                    {
                        JOptionPane.showMessageDialog(null, "Categoria Já Existe");
                        return;
                    }
                    double seq = daocategoria.selectMaxCategoria();
                    seq = seq + 1;
                    if (daocategoria.insertCategoria(new Categoria(seq, novacategoria)) == 0)
                        JOptionPane.showMessageDialog(null, "Categoria Incluida com Sucesso!!");
                 }
    }//GEN-LAST:event_jMenuItem9MouseReleased

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    // End of variables declaration//GEN-END:variables

}
