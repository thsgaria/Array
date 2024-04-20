/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import bancoDados.Banco;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class FilmeJFrame extends javax.swing.JFrame {

    /**
     * Creates new form FilmeJFrame
     */
    private int idEscolhido = -1;

    public FilmeJFrame() {
        initComponents();
        listarFilmes();
        popularComboBoxCategorias();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFilmes = new javax.swing.JTable();
        jLabelListafilmes = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonApagar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelNome.setText("Nome");

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jTableFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Categoria", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableFilmes);
        if (jTableFilmes.getColumnModel().getColumnCount() > 0) {
            jTableFilmes.getColumnModel().getColumn(0).setResizable(false);
            jTableFilmes.getColumnModel().getColumn(1).setResizable(false);
            jTableFilmes.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabelListafilmes.setText("Lista de Filmes");

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButtonApagar.setText("Apagar");
        jButtonApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarActionPerformed(evt);
            }
        });

        jLabel1.setText("Categoria");

        jComboBoxCategoria.setSelectedIndex(-1);
        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jButtonApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabelListafilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 145, Short.MAX_VALUE)
                        .addComponent(jButtonCadastrar))
                    .addComponent(jTextFieldNome)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelListafilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonApagar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabelNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCadastrar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1))
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed

        try {
            var nome = jTextFieldNome.getText();
            var categoria = (String)jComboBoxCategoria.getSelectedItem();
            var parts = categoria.split(" - ");
            var idCategoria = Integer.parseInt(parts[0]);
            
            var conexao = Banco.conectar();
            String query;
            if (idEscolhido == -1) {
            query = "INSERT INTO filmes (id_categoria, nome) VALUES (?, ?)";
            var prepareStatement = conexao.prepareStatement(query);
            prepareStatement.setInt(1,idCategoria);
            prepareStatement.setString(2,nome);
            prepareStatement.execute();
            } else {
            query = "UPDATE filmes SET id_categoria = ?, nome = ? WHERE id = ?";
            var prepareStatement = conexao.prepareStatement(query);
            prepareStatement.setInt(1,idCategoria);
            prepareStatement.setString(2,nome);
            prepareStatement.setInt(3, idEscolhido);
            prepareStatement.execute(); 
                idEscolhido = -1;
            }
            listarFilmes();
            JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso");

            JOptionPane.showMessageDialog(null, nome);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButtonCadastrarActionPerformed
    private void listarFilmes() {
        try {

            var jdbcUrl = "jdbc:mysql://localhost:3306/locadora";
            var jdbcUsuario = "root";
            var jdbcSenha = "admin";

            var conexao = DriverManager.getConnection(jdbcUrl, jdbcUsuario, jdbcSenha);
            var query = """
                        SELECT filmes.id,
                        categorias.nome AS 'categoria',
                        filmes.nome FROM filmes 
                        INNER JOIN categorias ON (filmes.id_categoria = categorias.id);""";
            var statement = conexao.createStatement();
            var dados = statement.executeQuery(query);//Tipo ResultSet
            var modeloTabela = (DefaultTableModel) jTableFilmes.getModel();
            //remover todos os elementos
            modeloTabela.setRowCount(0);
            while (dados.next()) {
                var id = Integer.parseInt(dados.getString("id"));
                var nome = dados.getString("nome");
                var categoriaNome = dados.getString("categoria");
                modeloTabela.addRow(new Object[]{
                    id, categoriaNome, nome
                });

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        private void popularComboBoxCategorias() {
            try {
            var conexao = Banco.conectar();
            var query = "SELECT id, nome FROM categorias";
            var statement = conexao.createStatement();
            var dados = statement.executeQuery(query);
            while (dados.next()){
                var categoriaNome = dados.getString("nome");
                var categoriaId = dados.getInt("id");
                jComboBoxCategoria.addItem(categoriaId + " - "+categoriaNome);
                    }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jButtonApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarActionPerformed
            try {
            var conexao = Banco.conectar();
            var indiceLinhaSelecionada = jTableFilmes.getSelectedRow();
            var idEscolhidoParaApagar = Integer.parseInt(jTableFilmes.getValueAt(indiceLinhaSelecionada, 0).toString());
            var query = "DELETE FROM filmes WHERE id = ?";
            var prepareStatement = conexao.prepareCall(query);
            prepareStatement.setInt(1,idEscolhidoParaApagar);
            prepareStatement.execute();
            listarFilmes();
            JOptionPane.showMessageDialog(null, "Filme apagado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonApagarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        var indiceLinhaSelecionada = jTableFilmes.getSelectedRow();
        idEscolhido = Integer.parseInt(jTableFilmes.getValueAt(indiceLinhaSelecionada, 0).toString());
        try {
       var conexao = Banco.conectar();
            var query = """
                        SELECT filmes.id,
                        filmes.id_categoria,
                        filmes.nome FROM filmes
                        WHERE id = """ + idEscolhido;
            var statement = conexao.createStatement();
            var dados = statement.executeQuery(query);//Tipo ResultSet
            var categoriaNome = jTableFilmes.getValueAt(indiceLinhaSelecionada, 1).toString();
            if(dados.next()){
                var nome = dados.getString("nome");
                var idCategoria = dados.getInt("id_categoria");
                jTextFieldNome.setText(nome);
                var mensagem = idCategoria + " - " + categoriaNome;
                for (int i = 0; i < jComboBoxCategoria.getItemCount(); i++) {
                var item = (String)jComboBoxCategoria.getItemAt (i);
                if (mensagem.equals(item)){
                    jComboBoxCategoria.setSelectedItem(item);
                }
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(FilmeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FilmeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FilmeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FilmeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FilmeJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApagar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelListafilmes;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableFilmes;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
