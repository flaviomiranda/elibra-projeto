package telas;

import dao.DaoFormaPagamento;
import dao.DaoFuncionario;
import dao.DaoLogin;
import dao.DaoProduto;
import dao.DaoVenda;
import dao.DaoVendaProduto;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.ChaveCarrinho;
import model.FormaPagamento;
import model.Funcionario;
import model.Login;
import model.Produto;
import model.Venda;
import model.VendaProduto;
import utilitarios.Formatador;
import utilitarios.ImprimirCupom;
import utilitarios.TrataErro;

public class TelaCaixa extends javax.swing.JDialog {

    ArrayList<ChaveCarrinho> itenscarrinho = new ArrayList<ChaveCarrinho>();
    Map<Integer, Produto> produtoscarrinho = new TreeMap<Integer, Produto>();
    ArrayList<String> notafiscal = new ArrayList<String>();
    Login login;
    double totalgeral = 0;
    double valortotal = 0;
    double valordesconto = 0;
    int flalterouqtd = 0;
    int seqglo=0;

    public TelaCaixa(java.awt.Frame parent, boolean modal, String l) {
        super(parent, modal);
        initComponents();
        DaoLogin daologin = new DaoLogin();
        login = daologin.selectLogin(l);
        DaoFuncionario daofuncionario = new DaoFuncionario();
        Funcionario f = daofuncionario.selectFuncionario(login.getCD_FUNC());
        lblOperador.setText(f.getNM_FUNC());
            txtCodigoBarras.addKeyListener(new KeyAdapter() {
            @Override
             public void keyPressed(java.awt.event.KeyEvent e) {
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_ENTER:
                    {
                    if(!txtCodigoBarras.getText().equals(""))
                        tratarTeclaEnter();
                    break;
                    }
                     case KeyEvent.VK_F1:
                    {
                        dispose();
                    break;
                    }
                      case KeyEvent.VK_F2:
                    {
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
                        TelaProdutoConsulta tpc = new TelaProdutoConsulta(null, true, p);
                        tpc.setLocationRelativeTo(null);
                        tpc.setVisible(true);
                    break;
                    }
                     case KeyEvent.VK_F3:
                    {
                        encerraVenda();
                    break;
                    }
                     case KeyEvent.VK_F4:
                    {
                        cancelaItem();
                    break;
                    }
                     case KeyEvent.VK_F5:
                    {
                        alteraQuantidade();
                    break;
                    }
                     case KeyEvent.VK_F6:
                    {
                        concedeDesconto();
                    break;
                    }
                     case KeyEvent.VK_F7:
                     {
                           try {
                                    Runtime.getRuntime().exec("calc");
                                }
                           catch (IOException iox) {
                                    TrataErro.imprimeErro("Erro ao abrir Calculadora", iox.getMessage());
                         }
                     }

                }

            }
            }
            );
            txtNotaFiscal.setAutoscrolls(false);
    }

    public void concedeDesconto()
    {
        String txtdesconto = (String) JOptionPane.showInputDialog(null, "Digite o valor(R$) do desconto", "Desconto", JOptionPane.QUESTION_MESSAGE, null, null, valordesconto);
        if (txtdesconto == null)
            return;
        if (txtdesconto.equals(""))
            return;
        //txtdesconto.replace("%", "0");
        txtdesconto = txtdesconto.replaceAll(",", ".");
        double desconto = Double.parseDouble(txtdesconto);
        valordesconto = desconto;
        reMontaNota();
        exibetotais();
    }

    public void cancelaItem()
    {
        String codigotxt = JOptionPane.showInputDialog(null, "Digite o Código do Produto");
        if (codigotxt == null)
            return;
        if (codigotxt.equals(""))
            return;
        ArrayList<Integer> itemqtdcarrinho = new ArrayList<Integer>();
        int totqtd=0;
            for (int x=0; x< itenscarrinho.size(); x++)
        {
            ChaveCarrinho cc = itenscarrinho.get(x);
            if (cc.getCodigobarra().equals(codigotxt))
            {
                itemqtdcarrinho.add(x);
                totqtd += cc.getQuantidade();
            }
        }
        if (itemqtdcarrinho.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Produto não consta na venda");
            return;
        }
        String qtdtxt = JOptionPane.showInputDialog(null, "Foram passdos " + totqtd + " itens, quantos deseja cancelar?" );
        if (qtdtxt == null)
            return;
        if (qtdtxt.equals(""))
            return;
        int qtd = Integer.parseInt(qtdtxt);
        if (qtd == 0 || qtd > totqtd)
        {
            JOptionPane.showMessageDialog(null, "Quantidade digitada inválida");
            return;
        }
        for(int y=itemqtdcarrinho.size()-1; y>=0; y--)
        {
            int seqitenscarrinho = itemqtdcarrinho.get(y);
            ChaveCarrinho cc = itenscarrinho.get(seqitenscarrinho);
            int qtdprodcc = cc.getQuantidade();
            if (qtdprodcc < qtd)
                {
                qtd -= qtdprodcc;
                itenscarrinho.remove(seqitenscarrinho);
                produtoscarrinho.remove(cc.getSequencia());
                }
            else
            {
                if (qtdprodcc == qtd)
                {
                    itenscarrinho.remove(seqitenscarrinho);
                    produtoscarrinho.remove(cc.getSequencia());
                    break;
                }
                else
                {
                    qtdprodcc = qtdprodcc - qtd;
                    cc.setQuantidade(qtdprodcc);
                    itenscarrinho.set(seqitenscarrinho, cc);
                    break;
                }
            }

        }
            reMontaNota();
            exibeNota();
            JOptionPane.showMessageDialog(null, "Item cancelado com Sucesso");
    }

    public void reMontaNota()
    {
        notafiscal.clear();
        totalgeral=0;
        for(int x=0;x<itenscarrinho.size();x++)
        {
            ChaveCarrinho cc = itenscarrinho.get(x);
            Produto p = produtoscarrinho.get(cc.getSequencia());
            totalgeral += p.getVL_PROD() * cc.getQuantidade();
            incluiItemNota(p, cc.getQuantidade(), x);
            
        }
    }


    public void encerraVenda()
    {
        if (itenscarrinho.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado na venda!");
            return;
        }

        int op = JOptionPane.showConfirmDialog(null, "Deseja Concluir a Venda?");
        if (op !=JOptionPane.YES_OPTION)
            return;
        String formapagamento = obtemFormaPagamento();
        if (formapagamento == null)
            return;
        else
            if (formapagamento.equals("0"))
            {
             JOptionPane.showMessageDialog(null, "Forma de Pagamento Invalida!");
             return;
            }
        DaoVenda daovenda = new DaoVenda();
        double cdvenda = daovenda.selectMaxVenda();
        cdvenda ++;
        double cdformapagamento = Double.parseDouble(formapagamento);
        if (cdformapagamento == 4)
        {
            String dinreceb = JOptionPane.showInputDialog(null, "Informe o Dinheiro Recebido", "Valor Recebido", JOptionPane.QUESTION_MESSAGE);
            if (dinreceb == null || dinreceb.equals("") || dinreceb.equals("0"))
                return;
            dinreceb = dinreceb.replaceAll(",", ".");
            double dinrecebido = Double.parseDouble(dinreceb);
            if (dinrecebido < (totalgeral - valordesconto))
            {
                JOptionPane.showMessageDialog(null, "Valor recebido é menor que valor a ser pago");
                return;
            }
            else{
                double troco = dinrecebido - (totalgeral - valordesconto);
                String trocotxt = Formatador.formataVirgula2(troco);
                JOptionPane.showMessageDialog(null, "O troco a ser devolvido é de: R$"+ trocotxt, "Troco", JOptionPane.PLAIN_MESSAGE);
            }


        }
        Venda v = new Venda(cdvenda, cdformapagamento, login.getCD_FUNC(), 0,valordesconto, null);
        daovenda.insertVenda(v);
        for(int x=0; x < itenscarrinho.size(); x++)
        {
            DaoVendaProduto daovendaproduto = new DaoVendaProduto();
            ChaveCarrinho cc = itenscarrinho.get(x);
            Produto p = produtoscarrinho.get(cc.getSequencia());
            daovendaproduto.insertVendaProduto(new VendaProduto(cdvenda, x+1, p.getCD_PROD(), cc.getQuantidade(), p.getVL_PROD()));
            DaoProduto daoproduto = new DaoProduto();
            double qtdatual = p.getQTD_PROD();
            p.setQTD_PROD(qtdatual - cc.getQuantidade());
            daoproduto.updateProduto(p);
        }
        imprimirCupom(v);
        JOptionPane.showMessageDialog(null, "Venda Realizada com Sucesso!");
        novavenda();
    }

    public void imprimirCupom(Venda v)
    {
        ImprimirCupom ic = new ImprimirCupom();
        ic.iniciarImpressao(v);
    }

    public void novavenda()
    {
        limpaTela();
        totalgeral = 0;
        valortotal = 0;
        valordesconto = 0;
        lblImagemProduto.setIcon(null);
        itenscarrinho.clear();
        produtoscarrinho.clear();
        notafiscal.clear();
        txtNotaFiscal.setText("");
        lblTotalGeral.setText(null);
        lblMensagem.setText("Nova venda..."); 
    }

    public String obtemFormaPagamento(){
        DaoFormaPagamento daoformapagamento = new DaoFormaPagamento();
        ArrayList<FormaPagamento> listaformapagamento = daoformapagamento.selectAllFormaPagamento();
        String formapagamentox = "Escolha a Forma de Pagamento: ";
        for(int x=0; x<listaformapagamento.size(); x++)
        {
            FormaPagamento fp = listaformapagamento.get(x);
            formapagamentox += "\n" + (int) fp.getCD_FORM_PGMTO() + " - " + fp.getNM_FORM_PGMTO();
        }
        String opx = JOptionPane.showInputDialog(null, formapagamentox);
            if( opx == null)
                return null;
        if(opx.equals(""))
                return "0";

        int op = Integer.parseInt(opx);
        if ( daoformapagamento.FormaPagamento(op) == null)
                return "0";
        else
            return String.valueOf(op);
    }

    public void alteraQuantidade()
    {
        String qtdtxt = JOptionPane.showInputDialog(null, "Digite a Quantidade", "Quantidade", JOptionPane.QUESTION_MESSAGE);
        if (qtdtxt == null)
            return;
        if (qtdtxt.equals(""))
            return;
        double qtd = Double.parseDouble(qtdtxt);
        if (qtd == 0)
            return;
        txtQuantidade.setText(Formatador.formataVirgula3(qtd));
        flalterouqtd = 1;
    }


    public void tratarTeclaEnter()
    {
        if (!txtQuantidade.getText().equals("1,000") && flalterouqtd == 0)
            txtQuantidade.setText("1,000");
        flalterouqtd = 0;
        DaoProduto daoproduto = new DaoProduto();
        String codigobarras = txtCodigoBarras.getText();
        Produto p = daoproduto.selectCodigoBarraProduto(codigobarras);
        if (p == null){
            lblMensagem.setText("Produto não cadastrado");
            limpaTela();
            return;
        }
        adicionaCarrinho(p);
        carregaTela(p);
        exibeNota();
        txtCodigoBarras.setText(null);
        Icon icon = new ImageIcon("imgNaoDisponivel.jpg");
        lblImagemProduto.setIcon(icon);
        lblMensagem.setText("Produto incluido com sucesso...");
    }

    public void exibeNota(){
        String notafiscalxtxt = "";
        int qtdlinhainicio=0;

        if(notafiscal.size() >= 22)
          qtdlinhainicio =  notafiscal.size() - 22;

        for(int i=0;i<22 ; i++)
        {
            if(qtdlinhainicio >= notafiscal.size())
                break;
            notafiscalxtxt += " " + notafiscal.get(qtdlinhainicio)+"\n";
            qtdlinhainicio++;
        }
        txtNotaFiscal.setText(notafiscalxtxt);        
        //label de totais
            exibetotais();
    }

    public void exibetotais()
    {
        txtValorTotal.setText(Formatador.formataVirgula2(valortotal));
        txtSubtotal.setText(Formatador.formataVirgula2(valortotal));
        double desconto = valordesconto;
        double totalgeraldesc = totalgeral - desconto;
        lblTotalGeral.setText(Formatador.formataVirgula2(totalgeraldesc));
    }


    public void limpaTela()
    {
        lblDescricao.setText(null);
        txtCodigoBarras.setText(null);
        txtQuantidade.setText(null);
        txtValorUnitario.setText(null);
        txtValorTotal.setText(null);
        txtSubtotal.setText(null);
    }

    public void carregaTela(Produto p){
        lblDescricao.setText(Formatador.SubString(p.getNM_PROD().toUpperCase(),0,37));
        txtValorUnitario.setText(Formatador.formataVirgula2(p.getVL_PROD()));
    }
    public void adicionaCarrinho(Produto p)
    {
        int seq = itenscarrinho.size();
        String quantidadetxt = txtQuantidade.getText();
        quantidadetxt = quantidadetxt.replaceAll(",", ".");
        int qtd = (int) Double.parseDouble(quantidadetxt);
        ChaveCarrinho chavecarrinho = new ChaveCarrinho(seqglo, p.getCD_BARRA_PROD(), qtd);
        //salva produto e quantidades
        produtoscarrinho.put(seqglo, p);
        seqglo++;
        itenscarrinho.add(chavecarrinho);
        //calcula valor total e valor geral
        valortotal = qtd*p.getVL_PROD();
        totalgeral += valortotal;
        incluiItemNota(p, qtd, seq+1);
    }

     public void incluiItemNota(Produto p, int qtd, int seq)
    {
      if (notafiscal.isEmpty())
      {
          String cabec1="";
          cabec1 = Formatador.incluiEspacos(cabec1, 16);
          cabec1 += "** CUPOM FISCAL **";
          cabec1 = Formatador.incluiEspacos(cabec1, 16);
          String cabec2 ="ITEM CODIGO         DESCRIÇÃO";
          String cabec3 ="QTD.     UN      VL.UNIT.(R$)       VL.ITEM(R$)";
          notafiscal.add(Formatador.linhaTracejada(48));
          notafiscal.add(cabec1);
          notafiscal.add(Formatador.linhaTracejada(48));
          notafiscal.add(cabec2);
          notafiscal.add(cabec3);
          notafiscal.add(Formatador.linhaTracejada(48));
      }
          String det1="";
          String det2="";
          det1=Formatador.zerosEsquerda(seq)+ "  "+ Formatador.tamanhoDe(p.getCD_BARRA_PROD(),13) + "  " + Formatador.SubString(p.getNM_PROD(), 0, 28);
          det2=Formatador.tamanhoDeEsquerda(Formatador.formataVirgula3(qtd),8)+ " UND x   "+ Formatador.tamanhoDeEsquerda(Formatador.formataVirgula2(p.getVL_PROD()),11);
          det2+="          " + Formatador.tamanhoDeEsquerda(Formatador.formataVirgula2(p.getVL_PROD()*qtd),10);
          notafiscal.add(det1);
          notafiscal.add(det2);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescricao = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblImagemProduto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoBarras = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        txtValorTotal = new javax.swing.JTextField();
        txtValorUnitario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblOperador = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblTotalGeral = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblMensagem = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotaFiscal = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblDescricao.setBackground(new java.awt.Color(255, 255, 255));
        lblDescricao.setFont(new java.awt.Font("Tahoma", 1, 36));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagemProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagemProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel2.setText("Código");

        txtCodigoBarras.setFont(new java.awt.Font("Tahoma", 1, 18));
        txtCodigoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBarrasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel3.setText("Quantidade");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel4.setText("Valor Unitário");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel5.setText("Valor Total");

        txtQuantidade.setFont(new java.awt.Font("Tahoma", 1, 18));
        txtQuantidade.setFocusable(false);

        txtValorTotal.setFont(new java.awt.Font("Tahoma", 1, 18));
        txtValorTotal.setFocusable(false);

        txtValorUnitario.setFont(new java.awt.Font("Tahoma", 1, 18));
        txtValorUnitario.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel6.setText("Subtotal");

        txtSubtotal.setFont(new java.awt.Font("Tahoma", 1, 18));
        txtSubtotal.setFocusable(false);
        txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 30));
        jLabel9.setText("Elibra Comércio de Salvados de Sinistro LTDA");

        jLabel1.setText("Operador: ");

        lblOperador.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOperador, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblOperador))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel7.setText("Total Geral");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTotalGeral.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTotalGeral.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTotalGeral, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTotalGeral, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblMensagem.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensagem.setText("Nova venda...");
        lblMensagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        jLabel10.setText("F1 - Menu");

        jLabel11.setText("F5 - Altera Quantidade");

        jLabel12.setText("F3 - Encerra Venda");

        jLabel14.setText("F2 - Pesquisa Produto");

        jLabel15.setText("F4 - Cancela Item");

        jLabel16.setText("F6 - Concede Desconto");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel17.setText("Mensagem");

        txtNotaFiscal.setColumns(48);
        txtNotaFiscal.setFont(new java.awt.Font("Courier New", 1, 14));
        txtNotaFiscal.setRows(23);
        txtNotaFiscal.setAutoscrolls(false);
        txtNotaFiscal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtNotaFiscal.setFocusable(false);
        jScrollPane1.setViewportView(txtNotaFiscal);

        jLabel18.setText("F7 - Calculadora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDescricao)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(292, 292, 292))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(11, 11, 11))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(360, 360, 360)
                                    .addComponent(jLabel17))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel17))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(jLabel11)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBarrasActionPerformed

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblImagemProduto;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblOperador;
    private javax.swing.JLabel lblTotalGeral;
    private javax.swing.JTextField txtCodigoBarras;
    private javax.swing.JTextArea txtNotaFiscal;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables

}
