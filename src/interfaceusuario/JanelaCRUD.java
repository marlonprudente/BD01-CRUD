package interfaceusuario;

import acesso.GerenciadorTransacoes;
import entidades.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

public class JanelaCRUD extends javax.swing.JFrame {
    //Operação realizado pelos dialogues: Nenhuma, visualizando elementos, adicionando elementos, alterando elementos;
    private final byte  OP_NENHUM       = 0, 
                        OP_VISUALIZAR   = 1, 
                        OP_ADICIONAR    = 2, 
                        OP_ALTERAR      = 3;
    
    private byte    opDialog_usuario        = OP_NENHUM,
                    opDialog_livro          = OP_NENHUM,
                    opDialog_genero         = OP_NENHUM,
                    opDialog_pedido         = OP_NENHUM,
                    opDialog_pedidoDetalhe  = OP_NENHUM;
    
    private final GerenciadorTransacoes gerTrans;
    private AbstractListModel listaUsuarios;
    private AbstractListModel listaLivros;
    private AbstractListModel listaPedidos;
    private AbstractListModel listaNula;
    
    public JanelaCRUD(GerenciadorTransacoes gerTrans) {
        this.pack();
        this.setLocationRelativeTo(null);
        this.gerTrans = gerTrans;
        
        listaUsuarios = new AbstractListModel(){
            @Override
            public int getSize() {return gerTrans.getListaUsuarios().size();}
            @Override
            public Object getElementAt(int index) {return gerTrans.getListaUsuarios().get(index);}
        };
        
        listaLivros = new AbstractListModel(){
            @Override
            public int getSize() {return gerTrans.getListaLivros().size();}
            @Override
            public Object getElementAt(int index) {return gerTrans.getListaLivros().get(index);}
        };
        
        listaPedidos = new AbstractListModel(){
            @Override
            public int getSize() {return gerTrans.getListaPedidos().size();}
            @Override
            public Object getElementAt(int index) {return gerTrans.getListaPedidos().get(index);}
        };

        listaNula = new AbstractListModel(){
            @Override
            public int getSize() {return 0;}
            @Override
            public Object getElementAt(int index) {return null;}
        };    
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog_usuarios = new javax.swing.JDialog();
        jScrollPane_propUsuarios = new javax.swing.JScrollPane();
        jPanel_propUsuarios = new javax.swing.JPanel();
        jPanel_propUsuarioPedidos = new javax.swing.JPanel();
        jScrollPane_propUsuariosPedidos = new javax.swing.JScrollPane();
        jList_propUsuariosPedidos = new javax.swing.JList();
        jPanel_propUsuariosCampos = new javax.swing.JPanel();
        jLabel_propUsuarioId = new javax.swing.JLabel();
        jFormattedTextField_propUsuarioId = new javax.swing.JFormattedTextField();
        jLabel_propUsuarioNome = new javax.swing.JLabel();
        jTextField_propUsuarioNome = new javax.swing.JTextField();
        jLabel_propUsuarioEndereco = new javax.swing.JLabel();
        jTextField_propUsuarioEndereco = new javax.swing.JTextField();
        jLabel_propUsuarioBairro = new javax.swing.JLabel();
        jTextField_propUsuarioBairro = new javax.swing.JTextField();
        jLabel_propUsuarioCidade = new javax.swing.JLabel();
        jTextField_propUsuarioCidade = new javax.swing.JTextField();
        jLabel_propUsuarioUf = new javax.swing.JLabel();
        jComboBox_propUsuarioUf = new javax.swing.JComboBox();
        jLabel_propUsuarioCep = new javax.swing.JLabel();
        jFormattedTextField_proUsuarioCep = new javax.swing.JFormattedTextField();
        jLabel_propUsuarioFone = new javax.swing.JLabel();
        jFormattedTextField_propUsuarioFone = new javax.swing.JFormattedTextField();
        jLabel_propUsuarioLogin = new javax.swing.JLabel();
        jTextField_propUsuarioLogin = new javax.swing.JTextField();
        jLabel_propUsuarioSenha = new javax.swing.JLabel();
        jTextField_propUsuarioSenha = new javax.swing.JTextField();
        jToggleButton_propsUsuariosAlterar = new javax.swing.JToggleButton();
        jButton_propUsuariosOk = new javax.swing.JButton();
        jButton_propUsuariosCancelar = new javax.swing.JButton();
        jScrollPane_lista = new javax.swing.JScrollPane();
        jList_lista = new javax.swing.JList();
        jButton_adicionar = new javax.swing.JButton();
        jButton_visualizar = new javax.swing.JButton();
        jButton_excluir = new javax.swing.JButton();
        jComboBox_tabelas = new javax.swing.JComboBox();
        jMenuBar_menu = new javax.swing.JMenuBar();
        jMenu_arquivo = new javax.swing.JMenu();
        jMenu_editar = new javax.swing.JMenu();

        jDialog_usuarios.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jDialog_usuarios.setModal(true);
        jDialog_usuarios.setType(java.awt.Window.Type.UTILITY);
        jDialog_usuarios.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialog_usuarios_fecharDialog(evt);
            }
        });

        jPanel_propUsuarioPedidos.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedidos"));

        jList_propUsuariosPedidos.setEnabled(false);
        jScrollPane_propUsuariosPedidos.setViewportView(jList_propUsuariosPedidos);

        javax.swing.GroupLayout jPanel_propUsuarioPedidosLayout = new javax.swing.GroupLayout(jPanel_propUsuarioPedidos);
        jPanel_propUsuarioPedidos.setLayout(jPanel_propUsuarioPedidosLayout);
        jPanel_propUsuarioPedidosLayout.setHorizontalGroup(
            jPanel_propUsuarioPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_propUsuariosPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );
        jPanel_propUsuarioPedidosLayout.setVerticalGroup(
            jPanel_propUsuarioPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_propUsuariosPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );

        jPanel_propUsuariosCampos.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuário"));

        jLabel_propUsuarioId.setText("ID:");

        jFormattedTextField_propUsuarioId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField_propUsuarioId.setText("99");
        jFormattedTextField_propUsuarioId.setEnabled(false);

        jLabel_propUsuarioNome.setText("Nome:");

        jTextField_propUsuarioNome.setText("--");
        jTextField_propUsuarioNome.setEnabled(false);

        jLabel_propUsuarioEndereco.setText("Endereço:");

        jTextField_propUsuarioEndereco.setText("--");
        jTextField_propUsuarioEndereco.setEnabled(false);

        jLabel_propUsuarioBairro.setText("Bairro:");

        jTextField_propUsuarioBairro.setText("--");
        jTextField_propUsuarioBairro.setEnabled(false);

        jLabel_propUsuarioCidade.setText("Cidade:");

        jTextField_propUsuarioCidade.setText("--");
        jTextField_propUsuarioCidade.setEnabled(false);

        jLabel_propUsuarioUf.setText("UF:");

        jComboBox_propUsuarioUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
        jComboBox_propUsuarioUf.setEnabled(false);

        jLabel_propUsuarioCep.setText("CEP:");

        try {
            jFormattedTextField_proUsuarioCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField_proUsuarioCep.setText("00000-000");
        jFormattedTextField_proUsuarioCep.setEnabled(false);

        jLabel_propUsuarioFone.setText("Fone:");

        try {
            jFormattedTextField_propUsuarioFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField_propUsuarioFone.setText("0000-0000");
        jFormattedTextField_propUsuarioFone.setEnabled(false);

        jLabel_propUsuarioLogin.setText("Login:");

        jTextField_propUsuarioLogin.setText("--");
        jTextField_propUsuarioLogin.setEnabled(false);

        jLabel_propUsuarioSenha.setText("Senha:");

        jTextField_propUsuarioSenha.setText("--");
        jTextField_propUsuarioSenha.setEnabled(false);

        javax.swing.GroupLayout jPanel_propUsuariosCamposLayout = new javax.swing.GroupLayout(jPanel_propUsuariosCampos);
        jPanel_propUsuariosCampos.setLayout(jPanel_propUsuariosCamposLayout);
        jPanel_propUsuariosCamposLayout.setHorizontalGroup(
            jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_propUsuariosCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_propUsuariosCamposLayout.createSequentialGroup()
                        .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_propUsuariosCamposLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel_propUsuarioId))
                            .addComponent(jLabel_propUsuarioNome, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_propUsuarioNome)
                            .addComponent(jFormattedTextField_propUsuarioId)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_propUsuariosCamposLayout.createSequentialGroup()
                        .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_propUsuarioBairro)
                            .addComponent(jLabel_propUsuarioEndereco)
                            .addComponent(jLabel_propUsuarioCidade)
                            .addComponent(jLabel_propUsuarioUf)
                            .addComponent(jLabel_propUsuarioCep)
                            .addComponent(jLabel_propUsuarioFone)
                            .addComponent(jLabel_propUsuarioLogin)
                            .addComponent(jLabel_propUsuarioSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_propUsuarioBairro)
                            .addComponent(jTextField_propUsuarioCidade)
                            .addComponent(jTextField_propUsuarioEndereco)
                            .addComponent(jComboBox_propUsuarioUf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField_proUsuarioCep)
                            .addComponent(jFormattedTextField_propUsuarioFone)
                            .addComponent(jTextField_propUsuarioLogin)
                            .addComponent(jTextField_propUsuarioSenha, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel_propUsuariosCamposLayout.setVerticalGroup(
            jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_propUsuariosCamposLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_propUsuarioId)
                    .addComponent(jFormattedTextField_propUsuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_propUsuarioNome)
                    .addComponent(jTextField_propUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_propUsuarioEndereco)
                    .addComponent(jTextField_propUsuarioEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_propUsuarioBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_propUsuarioBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_propUsuarioCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_propUsuarioCidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_propUsuarioUf)
                    .addComponent(jComboBox_propUsuarioUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField_proUsuarioCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_propUsuarioCep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField_propUsuarioFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_propUsuarioFone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_propUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_propUsuarioLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_propUsuariosCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_propUsuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_propUsuarioSenha)))
        );

        javax.swing.GroupLayout jPanel_propUsuariosLayout = new javax.swing.GroupLayout(jPanel_propUsuarios);
        jPanel_propUsuarios.setLayout(jPanel_propUsuariosLayout);
        jPanel_propUsuariosLayout.setHorizontalGroup(
            jPanel_propUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_propUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_propUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_propUsuariosCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_propUsuarioPedidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_propUsuariosLayout.setVerticalGroup(
            jPanel_propUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_propUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_propUsuariosCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_propUsuarioPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane_propUsuarios.setViewportView(jPanel_propUsuarios);

        jToggleButton_propsUsuariosAlterar.setText("Alterar");
        jToggleButton_propsUsuariosAlterar.setEnabled(false);

        jButton_propUsuariosOk.setText("Ok");
        jButton_propUsuariosOk.setEnabled(false);
        jButton_propUsuariosOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_propUsuariosOk_aceitar(evt);
            }
        });

        jButton_propUsuariosCancelar.setText("Cancelar");
        jButton_propUsuariosCancelar.setEnabled(false);
        jButton_propUsuariosCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_propUsuariosCancelar_pressionado(evt);
            }
        });

        javax.swing.GroupLayout jDialog_usuariosLayout = new javax.swing.GroupLayout(jDialog_usuarios.getContentPane());
        jDialog_usuarios.getContentPane().setLayout(jDialog_usuariosLayout);
        jDialog_usuariosLayout.setHorizontalGroup(
            jDialog_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_usuariosLayout.createSequentialGroup()
                .addComponent(jToggleButton_propsUsuariosAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_propUsuariosOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_propUsuariosCancelar))
            .addComponent(jScrollPane_propUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
        );

        jDialog_usuariosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton_propUsuariosCancelar, jButton_propUsuariosOk});

        jDialog_usuariosLayout.setVerticalGroup(
            jDialog_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_usuariosLayout.createSequentialGroup()
                .addComponent(jScrollPane_propUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDialog_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton_propsUsuariosAlterar)
                    .addComponent(jButton_propUsuariosOk)
                    .addComponent(jButton_propUsuariosCancelar)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList_lista.setModel(listaUsuarios);
        jList_lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList_lista_selecionada(evt);
            }
        });
        jScrollPane_lista.setViewportView(jList_lista);

        jButton_adicionar.setText("Adicionar");
        jButton_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_adicionar_novoUsuario(evt);
            }
        });

        jButton_visualizar.setText("Visualizar");
        jButton_visualizar.setEnabled(false);

        jButton_excluir.setText("Excluir");
        jButton_excluir.setEnabled(false);
        jButton_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_excluir_pressionado(evt);
            }
        });

        jComboBox_tabelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuários", "Livros", "Pedidos" }));
        jComboBox_tabelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_tabelas_selecaoEfetuada(evt);
            }
        });

        jMenu_arquivo.setText("Arquivo");
        jMenuBar_menu.add(jMenu_arquivo);

        jMenu_editar.setText("Editar");
        jMenuBar_menu.add(jMenu_editar);

        setJMenuBar(jMenuBar_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_lista)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox_tabelas, 0, 131, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_adicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_visualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_excluir)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton_adicionar, jButton_excluir, jButton_visualizar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_adicionar)
                    .addComponent(jButton_visualizar)
                    .addComponent(jButton_excluir)
                    .addComponent(jComboBox_tabelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_lista, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_tabelas_selecaoEfetuada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_tabelas_selecaoEfetuada
        switch(jComboBox_tabelas.getSelectedIndex()){
            case 0:
                jList_lista.setModel(listaUsuarios); 
                break;
            case 1:
                jList_lista.setModel(listaLivros);
                break;
            case 2:
                jList_lista.setModel(listaPedidos);
                break;
            default:
                System.out.println("ERROR: ComboBox out of range");
            break;
        }
    }//GEN-LAST:event_jComboBox_tabelas_selecaoEfetuada

    private void jButton_adicionar_novoUsuario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_adicionar_novoUsuario
        switch(jComboBox_tabelas.getSelectedIndex()){
            case 0:
                opDialog_usuario = OP_ADICIONAR;
                novoUsuario();
                jList_lista.setModel(listaNula);
                jList_lista.setModel(listaUsuarios);
                break;
            case 1:
                break;
            case 2:
                break;
            default:
                System.out.println("ERROR: ComboBox out of range");
            break;
        }
    }//GEN-LAST:event_jButton_adicionar_novoUsuario

    private void jList_listaValueChanged(javax.swing.event.ListSelectionEvent evt) {                                         
    }                                        
    private void jDialog_usuarios_fechar(java.awt.event.WindowEvent evt) {                                         
    }                                        
    private void jButton_propUsuariosOk_aceitarAdicao(java.awt.event.ActionEvent evt) {                                                      
    }                                                     
    private void jButton_propUsuariosCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                                             
    }                                                            

    private void jButton_excluir_pressionado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_excluir_pressionado
        int opcao = JOptionPane.showOptionDialog(jDialog_usuarios, "Deseja mesmo remover este elemento?",
                        "Remover elemento", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if(opcao == 0)
        {
            switch(jComboBox_tabelas.getSelectedIndex()){
                case 0:
                    Usuarios usuario = (Usuarios) jList_lista.getSelectedValue();
                    gerTrans.removerUsuario(usuario);
                    jList_lista.setModel(listaNula);
                    jList_lista.setModel(listaUsuarios);
                    break;
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("ERROR: ComboBox out of range");
                break;
            }
        }
    }//GEN-LAST:event_jButton_excluir_pressionado
                                          
    private void jList_lista_selecionada(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_lista_selecionada
        if(jList_lista.isSelectionEmpty())
        {
            jButton_excluir.setEnabled(false);
            jButton_visualizar.setEnabled(false);
        }
        else
        {
            jButton_excluir.setEnabled(true);
            jButton_visualizar.setEnabled(true);
        }
    }//GEN-LAST:event_jList_lista_selecionada

    private void jDialog_usuarios_fecharDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog_usuarios_fecharDialog
        if(opDialog_usuario == OP_ADICIONAR)
        {
            int opcao = JOptionPane.showOptionDialog(jDialog_usuarios, "Deseja realmente remover alterações efetuadas?",
                "Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(opcao == 1)                    
                return;
        }
        opDialog_usuario = OP_NENHUM;
        evt.getWindow().dispose();
    }//GEN-LAST:event_jDialog_usuarios_fecharDialog

    private void jButton_propUsuariosOk_aceitar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_propUsuariosOk_aceitar
        try {
            if(opDialog_usuario == OP_ADICIONAR)
            {
                if(jFormattedTextField_propUsuarioId.getText() == null)
                JOptionPane.showMessageDialog(jDialog_usuarios, "O valor de ID não poder ser nulo.", "Atenção", JOptionPane.INFORMATION_MESSAGE);            
                else if(Integer.parseInt(jFormattedTextField_propUsuarioId.getText()) == 0)
                    JOptionPane.showMessageDialog(jDialog_usuarios, "O valor de ID não poder ser zero.", "Atenção",  JOptionPane.INFORMATION_MESSAGE);
                else if(gerTrans.isIdUtilizado(Usuarios.class, Integer.parseInt(jFormattedTextField_propUsuarioId.getText())))
                    JOptionPane.showMessageDialog(jDialog_usuarios, "O valor de ID deve ser único.", "Atenção",  JOptionPane.INFORMATION_MESSAGE);
                else 
                {
                    int opcao = JOptionPane.showOptionDialog(jDialog_usuarios, "Deseja adicionar um usuário com estas propriedades?",
                        "Adicionar usuário", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if(opcao == 0)                    
                    {
                        Usuarios usuario = new Usuarios();
                        inserirUsuario(usuario);
                        gerTrans.adicionarUsuario(usuario);    
                        opDialog_usuario = OP_NENHUM;
                        WindowListener[] w = (WindowListener[])jDialog_usuarios.getListeners(WindowListener.class);
                        if(w[0] != null)
                            w[0].windowClosing(new WindowEvent(jDialog_usuarios,WindowEvent.WINDOW_CLOSING));
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(JanelaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_propUsuariosOk_aceitar

    private void jButton_propUsuariosCancelar_pressionado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_propUsuariosCancelar_pressionado
        WindowListener[] w = (WindowListener[])jDialog_usuarios.getListeners(WindowListener.class);
        if(w[0] != null)
            w[0].windowClosing(new WindowEvent(jDialog_usuarios,WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jButton_propUsuariosCancelar_pressionado

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_adicionar;
    private javax.swing.JButton jButton_excluir;
    private javax.swing.JButton jButton_propUsuariosCancelar;
    private javax.swing.JButton jButton_propUsuariosOk;
    private javax.swing.JButton jButton_visualizar;
    private javax.swing.JComboBox jComboBox_propUsuarioUf;
    private javax.swing.JComboBox jComboBox_tabelas;
    private javax.swing.JDialog jDialog_usuarios;
    private javax.swing.JFormattedTextField jFormattedTextField_proUsuarioCep;
    private javax.swing.JFormattedTextField jFormattedTextField_propUsuarioFone;
    private javax.swing.JFormattedTextField jFormattedTextField_propUsuarioId;
    private javax.swing.JLabel jLabel_propUsuarioBairro;
    private javax.swing.JLabel jLabel_propUsuarioCep;
    private javax.swing.JLabel jLabel_propUsuarioCidade;
    private javax.swing.JLabel jLabel_propUsuarioEndereco;
    private javax.swing.JLabel jLabel_propUsuarioFone;
    private javax.swing.JLabel jLabel_propUsuarioId;
    private javax.swing.JLabel jLabel_propUsuarioLogin;
    private javax.swing.JLabel jLabel_propUsuarioNome;
    private javax.swing.JLabel jLabel_propUsuarioSenha;
    private javax.swing.JLabel jLabel_propUsuarioUf;
    private javax.swing.JList jList_lista;
    private javax.swing.JList jList_propUsuariosPedidos;
    private javax.swing.JMenuBar jMenuBar_menu;
    private javax.swing.JMenu jMenu_arquivo;
    private javax.swing.JMenu jMenu_editar;
    private javax.swing.JPanel jPanel_propUsuarioPedidos;
    private javax.swing.JPanel jPanel_propUsuarios;
    private javax.swing.JPanel jPanel_propUsuariosCampos;
    private javax.swing.JScrollPane jScrollPane_lista;
    private javax.swing.JScrollPane jScrollPane_propUsuarios;
    private javax.swing.JScrollPane jScrollPane_propUsuariosPedidos;
    private javax.swing.JTextField jTextField_propUsuarioBairro;
    private javax.swing.JTextField jTextField_propUsuarioCidade;
    private javax.swing.JTextField jTextField_propUsuarioEndereco;
    private javax.swing.JTextField jTextField_propUsuarioLogin;
    private javax.swing.JTextField jTextField_propUsuarioNome;
    private javax.swing.JTextField jTextField_propUsuarioSenha;
    private javax.swing.JToggleButton jToggleButton_propsUsuariosAlterar;
    // End of variables declaration//GEN-END:variables

private void novoUsuario() {
        jDialog_usuarios.pack();
        jDialog_usuarios.setLocationRelativeTo(null);

        jDialog_usuarios.setTitle("Adicionar Usuário");

        jFormattedTextField_propUsuarioId.setEnabled(true);
        jTextField_propUsuarioNome.setEnabled(true);
        jTextField_propUsuarioEndereco.setEnabled(true);
        jTextField_propUsuarioBairro.setEnabled(true);
        jTextField_propUsuarioCidade.setEnabled(true);
        jTextField_propUsuarioLogin.setEnabled(true);
        jTextField_propUsuarioSenha.setEnabled(true);
        jComboBox_propUsuarioUf.setEnabled(true);
        jFormattedTextField_proUsuarioCep.setEnabled(true);
        jFormattedTextField_propUsuarioFone.setEnabled(true);

        jButton_propUsuariosOk.setEnabled(true);
        jButton_propUsuariosCancelar.setEnabled(true);

        jDialog_usuarios.setVisible(true);

        jFormattedTextField_propUsuarioId.setEnabled(false);
        jTextField_propUsuarioNome.setEnabled(false);
        jTextField_propUsuarioEndereco.setEnabled(false);
        jTextField_propUsuarioBairro.setEnabled(false);
        jTextField_propUsuarioCidade.setEnabled(false);
        jTextField_propUsuarioLogin.setEnabled(false);
        jTextField_propUsuarioSenha.setEnabled(false);
        jComboBox_propUsuarioUf.setEnabled(false);
        jFormattedTextField_proUsuarioCep.setEnabled(false);
        jFormattedTextField_propUsuarioFone.setEnabled(false);

        jButton_propUsuariosOk.setEnabled(false);
        jButton_propUsuariosCancelar.setEnabled(false);            
    }

    private void inserirUsuario(Usuarios usuario) {
        try {
            usuario.setUsuario_id(Integer.parseInt(jFormattedTextField_propUsuarioId.getText()));
            usuario.setNome(jTextField_propUsuarioNome.getText());           
            usuario.setNome(jTextField_propUsuarioNome.getText());
            usuario.setEndereco(jTextField_propUsuarioEndereco.getText());
            usuario.setBairro(jTextField_propUsuarioBairro.getText());
            usuario.setCidade(jTextField_propUsuarioCidade.getText());
            usuario.setLogin(jTextField_propUsuarioLogin.getText());
            usuario.setSenha(jTextField_propUsuarioSenha.getText());
            usuario.setUf(jComboBox_propUsuarioUf.getSelectedItem().toString());
            usuario.setCep(jFormattedTextField_proUsuarioCep.getText(0,5)+jFormattedTextField_proUsuarioCep.getText(6,3));
            usuario.setFone(jFormattedTextField_propUsuarioFone.getText(0,4)+jFormattedTextField_propUsuarioFone.getText(5,4));
        } catch (BadLocationException ex) {
            Logger.getLogger(JanelaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
