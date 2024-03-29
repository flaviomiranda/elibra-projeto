
import dao.DaoCategoria;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.Categoria;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJDialog.java
 *
 * Created on May 8, 2011, 12:20:47 AM
 */

/**
 *
 * @author Rafael Fioretti
 */
public class NewJDialog extends javax.swing.JDialog {

    /** Creates new form NewJDialog */
    public NewJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //DaoCategoria daocategoria = new DaoCategoria();
        //TreeMap<String, Categoria> mapcateg = (TreeMap) daocategoria.selectAllCategoriaMap();
        
        
        ArrayList<Categoria> listacateg = new ArrayList<Categoria>();
        listacateg.add(new Categoria(1, "Categoria 1"));
        listacateg.add(new Categoria(2, "Categoria 2"));
        String arraycateg[] = new String[listacateg.size()];
        for(int x=0; x<listacateg.size(); x++)
            arraycateg[x] = listacateg.get(x).getDS_CAT();
                
        String y = (String) JOptionPane.showInputDialog(null, "Selecione em qual categoria será incluida a Marca", "Inclusão Marca", JOptionPane.QUESTION_MESSAGE, null, arraycateg, rootPaneCheckingEnabled) ;
        System.out.println(y);
        TreeMap<String,Integer> tree = new TreeMap<String,Integer>();
        tree.put("1", 10);
        tree.put("2", 20);
        tree.put("3", 30);
        tree.put("4", 40);
        tree.put("5", 50);
        Iterator<String> s = tree.keySet().iterator();
        while(s.hasNext())
        {
            System.out.println(s.next());
        }


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextArea1.setBackground(new java.awt.Color(231, 226, 221));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("texto\ntexto\n");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJDialog dialog = new NewJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
