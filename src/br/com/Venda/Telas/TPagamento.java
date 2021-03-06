/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Venda.Telas;

import br.com.Produto.Model.ProdutoBLL;
import br.com.Conexao.JDBC.ModuloConexao;
import br.com.Venda.Model.vendaBLL;
import br.com.Venda.Model.vendaDTO;
import static br.com.Venda.Telas.TelaVenda.VendNome;
import static br.com.Venda.Telas.TelaVenda.VendProduto;
import static br.com.Venda.Telas.TelaVenda.VendQtd;
import static br.com.Venda.Telas.TelaVenda.VendTable3;
import static br.com.Venda.Telas.TelaVenda.VendAdd;
import static br.com.Venda.Telas.TelaVenda.ValorFinal;
import static br.com.Venda.Telas.TelaVenda.VendValorItem;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import java.sql.*;
import javazoom.jl.player.*;
import javazoom.jl.decoder.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.player.Player;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author T69779848134
 */
public class TPagamento extends javax.swing.JFrame {

    ModuloConexao conexao = new ModuloConexao();
    PreparedStatement pst;
    ResultSet rs;

    private void Venda() {
        conexao.conector();
        String sql = "insert into venda (codvenda,nome,descricao,qtdp,valor_Item,valor_sub_total, valor_total, forma_pg)\n"
                + "select C.codvenda, C.nome, C.descricao, qtdp, valor_Item, valor_sub_total, valor_total, T.forma_pg from carrinho C, teste T where C.id_cr = T.id_t;";

        try {
            PreparedStatement pst = conexao.conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Erro! " + e.getMessage());
        }
    }

    // metodo para "getar" pegar o que vao para o banco
    private void MostraTotal() {
        conexao.conector();
        try {
            conexao.executaSQL("select valor_total from carrinho order by nome desc;");  // string para habilitar os get's
            conexao.rs.last();

            TxtvalorFinal.setText(conexao.rs.getString("valor_total"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void som() {
        try {
            File file = new File("C:\\ProjetoVenda-6.5-MySQL\\src\\br\\com\\Audio\\Cr.mp3");
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bu = new BufferedInputStream(fis);

            try {
                Player player = new Player(bu);
                player.play();
            } catch (Exception e) {
                System.out.println("Erro ao tentar reproduzir o som" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar reproduzir o som" + e.getMessage());
        }
    }

    private void excluir() {
        String sql = "truncate teste ;";
        try {
            pst = conexao.conn.prepareStatement(sql);
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo deu Errado" + e.getMessage());

        }
    }

    private void excluir2() {
        String sql = "truncate carrinho ;";
        try {
            pst = conexao.conn.prepareStatement(sql);
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo deu Errado" + e.getMessage());

        }
    }

    public void pesquisaCarrinho(String sql) {
        conexao.conector();
        try {
            pst = conexao.conn.prepareStatement(sql);
            rs = pst.executeQuery();
            //  a linha abaixo usa a biblioteca rs2xml.jar                           
            VendTable3.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    vendaBLL bll = new vendaBLL();
    ProdutoBLL bl2 = new ProdutoBLL();
    vendaDTO dto = new vendaDTO();

    /**
     * Creates new form TPagamento
     */
    public TPagamento() {
        initComponents();
        MostraTotal();
        DinheiroTxt.setText("0.0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        CboCont = new javax.swing.JComboBox<>();
        BtnFinal = new javax.swing.JButton();
        TxtvalorFinal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DinheiroTxt = new javax.swing.JTextField();
        TrocoTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Painel");
        setBackground(new java.awt.Color(213, 0, 0));
        setFont(new java.awt.Font("Agency FB", 0, 12)); // NOI18N
        setForeground(new java.awt.Color(235, 5, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Por favor - Escolha a Forma de Pagamento");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        CboCont.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CboCont.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Débito", "Crédito", "Fiado" }));
        CboCont.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BtnFinal.setBackground(new java.awt.Color(153, 153, 153));
        BtnFinal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnFinal.setText("Finalizar");
        BtnFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFinalActionPerformed(evt);
            }
        });

        TxtvalorFinal.setFont(new java.awt.Font("Tahoma", 1, 56)); // NOI18N
        TxtvalorFinal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TxtvalorFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtvalorFinalActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(217, 0, 0));
        jLabel3.setText("Valor Total:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(217, 0, 0));
        jLabel4.setText("Troco:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(217, 0, 0));
        jLabel5.setText("Á vista:");

        DinheiroTxt.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        DinheiroTxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DinheiroTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DinheiroTxtKeyPressed(evt);
            }
        });

        TrocoTxt.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        TrocoTxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TrocoTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TrocoTxtFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Ex: 50.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TxtvalorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DinheiroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TrocoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CboCont, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CboCont, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DinheiroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(32, 32, 32)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtvalorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(TrocoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4)))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFinalActionPerformed
        String cbo = CboCont.getSelectedItem().toString();
        bll.SalvaCarrinho(cbo);
        Venda();
        VendNome.setEnabled(true);
        VendTable3.setVisible(false);
        VendAdd.setEnabled(false);
        excluir();// TODO add your handling code here:
        excluir2();
        this.dispose();
        som();


    }//GEN-LAST:event_BtnFinalActionPerformed

    private void TxtvalorFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtvalorFinalActionPerformed

    }//GEN-LAST:event_TxtvalorFinalActionPerformed

    private void TrocoTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TrocoTxtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TrocoTxtFocusGained

    private void DinheiroTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DinheiroTxtKeyPressed
        float Al = Float.parseFloat(TxtvalorFinal.getText());
        float Bl = Float.parseFloat(DinheiroTxt.getText());
        float C1 = (float) (Bl - Al);
        TrocoTxt.setText(String.valueOf(C1));

    }//GEN-LAST:event_DinheiroTxtKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TPagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnFinal;
    public static javax.swing.JComboBox<String> CboCont;
    private javax.swing.JTextField DinheiroTxt;
    private javax.swing.JTextField TrocoTxt;
    private javax.swing.JTextField TxtvalorFinal;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
