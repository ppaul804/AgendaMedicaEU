/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UsuarioController;
import Entidades.Perfil;
import Entidades.Usuario;
import java.awt.Component;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danilo
 */
public class TelaCadastroUsuario extends javax.swing.JFrame {

    UsuarioController usuarioController = new UsuarioController();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel tabelaPadrao;
    DefaultTableCellRenderer renderizadorDeCelula = new DefaultTableCellRenderer();
    
    
    public TelaCadastroUsuario() throws SQLException {
        
        initComponents();
        
        setLocationRelativeTo(null);
        
        renderizadorDeCelula.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Centralizar cabeçalho da tabela
        tabelaUsuariosCadastrados.getTableHeader().setDefaultRenderer(renderizadorDeCelula);
        
        //Centralizar algumas colunas da tabela
        for(int i = 0; i < tabelaUsuariosCadastrados.getColumnCount(); i++) {
            if(i != 2) 
                tabelaUsuariosCadastrados.getColumnModel().getColumn(i).setCellRenderer(renderizadorDeCelula);
        }
        
        
        for(Perfil perfil : usuarioController.listarTodosPerfis()) {
            comboBoxPerfil.addItem(perfil);
            
            System.out.println(perfil);
        }
        
        tabelaPadrao = (DefaultTableModel)tabelaUsuariosCadastrados.getModel();
        
        atualizarTabela();
              
    }
    
    private void atualizarTabela() throws SQLException {
        
        for(Usuario usuario : usuarioController.listarTodosUsuarios()){
            tabelaPadrao.addRow(new Object[] {
                usuario.getId(),
                usuario.getCpf(),
                usuario.getNome(),
                usuario.getUsername(),
                usuario.getSenha(),
                usuario.getTelefone(),
                usuario.getMatricula(),
                usuario.getPerfil(),
                sdf.format(usuario.getDataNascimento())
            });
        }
        
    }
    
    
    private void limparFormulario() {
        
        for (int i = 0; i < painelDados.getComponentCount(); i++) {
            //Varre todos os componentes do painel
            
            Component componente = painelDados.getComponent(i);
            
            if(componente instanceof JTextField) {
                //Apaga os valores
                JTextField field = (JTextField)componente;
                field.setText(null);
            }
            
            if(componente instanceof JFormattedTextField) {
                //Apaga os valores
                JFormattedTextField fieldFormated = (JFormattedTextField)componente;
                fieldFormated.setText(null);
            }
        }
    }
    
    private void refreshTabela() throws SQLException {
        
        new TelaCadastroUsuario().setVisible(true);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDados = new javax.swing.JPanel();
        labelCPF = new javax.swing.JLabel();
        txtCPFformatado = new javax.swing.JFormattedTextField();
        labelNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        labelUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        labelTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        labelDataNascimento = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        labelPerfil = new javax.swing.JLabel();
        comboBoxPerfil = new javax.swing.JComboBox<>();
        buttonCadastrar = new javax.swing.JButton();
        labelBanner = new javax.swing.JLabel();
        scrollPaneTabela = new javax.swing.JScrollPane();
        tabelaUsuariosCadastrados = new javax.swing.JTable();
        buttonAlterar = new javax.swing.JButton();
        buttonHome = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar Usuário");
        setResizable(false);

        painelDados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formulário de Cadastro de Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        labelCPF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCPF.setText("CPF:");

        try {
            txtCPFformatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNome.setText("NOME:");

        labelUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelUsername.setText("USERNAME:");

        labelSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelSenha.setText("SENHA:");

        labelTelefone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTelefone.setText("TELEFONE:");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelDataNascimento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelDataNascimento.setText("DATA DE NASCIMENTO:");

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelPerfil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelPerfil.setText("PERFIL:");

        comboBoxPerfil.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboBoxPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPerfilActionPerformed(evt);
            }
        });

        buttonCadastrar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        buttonCadastrar.setText("Cadastrar");
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(labelUsername)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosLayout.createSequentialGroup()
                                .addComponent(labelTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefone))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosLayout.createSequentialGroup()
                                .addComponent(labelPerfil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(labelSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSenha))
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(labelDataNascimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataNascimento))))
                    .addComponent(buttonCadastrar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addComponent(labelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(labelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPFformatado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCPFformatado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername)
                    .addComponent(labelSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTelefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(buttonCadastrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelBanner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/banner.PNG"))); // NOI18N

        tabelaUsuariosCadastrados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabelaUsuariosCadastrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CPF", "NOME", "USERNAME", "SENHA", "TELEFONE", "MATRÍCULA", "PERFIL", "DATA DE NASCIMENTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaUsuariosCadastrados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        scrollPaneTabela.setViewportView(tabelaUsuariosCadastrados);
        if (tabelaUsuariosCadastrados.getColumnModel().getColumnCount() > 0) {
            tabelaUsuariosCadastrados.getColumnModel().getColumn(0).setResizable(false);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(1).setResizable(false);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(2).setResizable(false);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(3).setResizable(false);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(4).setResizable(false);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(5).setResizable(false);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(5).setPreferredWidth(130);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(6).setResizable(false);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(7).setResizable(false);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(7).setPreferredWidth(120);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(8).setResizable(false);
            tabelaUsuariosCadastrados.getColumnModel().getColumn(8).setPreferredWidth(135);
        }

        buttonAlterar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        buttonAlterar.setText("Alterar");
        buttonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAlterarActionPerformed(evt);
            }
        });

        buttonHome.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        buttonHome.setText("Home");
        buttonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHomeActionPerformed(evt);
            }
        });

        buttonExcluir.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPaneTabela))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(buttonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBanner, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarActionPerformed
        
        Usuario usuario = new Usuario();
        usuario.setCpf(txtCPFformatado.getText().replace("-", "").replace(".", "").trim()); 
        usuario.setNome(txtNome.getText().trim());
        usuario.setUsername(txtUsername.getText().trim().toLowerCase());
        usuario.setSenha(String.valueOf(txtSenha.getPassword()).trim());
        usuario.setTelefone(txtTelefone.getText());
        usuario.setPerfil((Perfil) comboBoxPerfil.getSelectedItem());
        
        try {
            usuario.setDataNascimento(sdf.parse(txtDataNascimento.getText()));
            
            if(usuarioController.cadastrarUsuario(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com Sucesso!");
                limparFormulario();
                refreshTabela();
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "A data de nascimento deve ser preenchida");
            try {
                refreshTabela();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }
        } catch (SQLException ex) {
            try {
                refreshTabela();
            } catch (SQLException ex1) {
                System.out.println(ex1);
            }
            System.out.println(ex);
        }
        
        
    }//GEN-LAST:event_buttonCadastrarActionPerformed

    private void comboBoxPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxPerfilActionPerformed

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
        
        int linhaSelecionada = -1;
        
        linhaSelecionada = tabelaUsuariosCadastrados.getSelectedRow();
        
        if(linhaSelecionada >= 0) {
            
            int idUsuario = (Integer)tabelaUsuariosCadastrados.getValueAt(linhaSelecionada, 0);
            
            try {
                usuarioController.excluir(idUsuario);
                refreshTabela();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha!");
        }
        
    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void buttonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAlterarActionPerformed
        
        int linhaSelecionada = -1;
        
        linhaSelecionada = tabelaUsuariosCadastrados.getSelectedRow();
        
        if(linhaSelecionada >= 0) {
            
            int idUsuario = (Integer)tabelaUsuariosCadastrados.getValueAt(linhaSelecionada, 0);
            
            try {
                Usuario usuarioDoBanco = usuarioController.buscarPorId(idUsuario);
                
                usuarioController.abrirTelaAlterarUsuario(usuarioDoBanco);
                
                dispose();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha!");
        }
        
    }//GEN-LAST:event_buttonAlterarActionPerformed

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        
        dispose();
        new TelaPrincipal().setVisible(true);
        
    }//GEN-LAST:event_buttonHomeActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaCadastroUsuario().setVisible(true);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAlterar;
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonHome;
    private javax.swing.JComboBox<Perfil> comboBoxPerfil;
    private javax.swing.JLabel labelBanner;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelDataNascimento;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPerfil;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JPanel painelDados;
    private javax.swing.JScrollPane scrollPaneTabela;
    private javax.swing.JTable tabelaUsuariosCadastrados;
    private javax.swing.JFormattedTextField txtCPFformatado;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
