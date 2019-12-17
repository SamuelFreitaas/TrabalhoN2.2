/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import contoller.LivroController;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.bean.Livro;
import model.bean.Vendedor;

/**
 *
 * @author USUARIO
 */
public class TelaCadastroLivro extends javax.swing.JInternalFrame {

    private javax.swing.table.DefaultTableModel tabelaModelo;
    private LivroController lController;
    private Livro lSelecionado = new Livro();
    private boolean podeEditar = false;

    public TelaCadastroLivro() {
        this.CriarTabelaModelo();
        initComponents();
        lController = new LivroController();
        lController.listarTodos(tabelaModelo);
        limparCampos();

    }

    public void CriarTabelaModelo() {

        this.tabelaModelo = new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null}
                },
                new String[]{
                    "ID", "ISBN", "Título", "Autor", "Categoria", "Paginas", "Preço", "Status"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.Integer.class,
                java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.Integer.class,
                java.lang.Double.class, java.lang.String.class
            };

            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        };
    }

    public void limparCampos() {
        lSelecionado = new Livro(); // Limpar livro selecionado

        ISBNText.setText("");
        tituloText.setText("");
        autorText.setText("");
        paginasText.setText("");
        categoriaText.setText("");
        precoText.setText("");
        String status_index = "Disponível";
        statusLista.getModel().setSelectedItem(status_index);

        //tabelaDeLivros.getSelectionModel().clearSelection();
        this.desabilitarCamposEdicao();
        lController.listarTodos(tabelaModelo);
    }

    public void desabilitarCamposEdicao() {
        this.ISBNText.setEnabled(false);
        this.tituloText.setEnabled(false);
        this.autorText.setEnabled(false);
        this.paginasText.setEnabled(false);
        this.categoriaText.setEnabled(false);
        this.precoText.setEnabled(false);
        this.statusLista.setEnabled(false);

        this.podeEditar = false;

    }

    public void habilitarCamposEdicao() {
        this.ISBNText.setEnabled(true);
        this.tituloText.setEnabled(true);
        this.autorText.setEnabled(true);
        this.paginasText.setEnabled(true);
        this.categoriaText.setEnabled(true);
        this.precoText.setEnabled(true);
        this.statusLista.setEnabled(true);

        this.podeEditar = true;

    }

    public void preencherLivro(Livro l, int id, int ISBN, String titulo, String autor, int paginas, String categoria, double preco, boolean status) {
        if (ISBN != 0 && titulo != null && autor != null && paginas != 0 && categoria != null && preco != 0) {
            l.setId(id);
            
            l.setISBN(ISBN); 
            l.setTitulo(titulo);
            l.setAutor(autor);
            
            l.setPaginas(paginas);
            l.setCategoria(categoria);
            
            l.setPreco(preco);
            l.setStatus(status);
        } else {
            this.limparCampos();
        }
    }
    
    public void preencherSelecionado(ListSelectionEvent e) {
        int linha = tabelaLivros.getSelectedRow();
        try {
            int id = Integer.parseInt(tabelaModelo.getValueAt(linha, 0).toString());
            int ISBN = Integer.parseInt(tabelaModelo.getValueAt(linha, 1).toString());
            String titulo = tabelaModelo.getValueAt(linha, 2).toString();
            String autor = tabelaModelo.getValueAt(linha, 3).toString();
            int paginas = Integer.parseInt(tabelaModelo.getValueAt(linha, 4).toString());
            String categoria = tabelaModelo.getValueAt(linha, 5).toString();
            double preco = Double.parseDouble(tabelaModelo.getValueAt(linha, 6).toString());
            boolean status = tabelaModelo.getValueAt(linha, 7).toString().equals("Disponível");

            this.preencherLivro(lSelecionado, id, ISBN, titulo, autor, paginas, categoria, preco, status);

            this.preencherCampos();
            this.habilitarCamposEdicao();
        } catch (Exception erro) {
            this.limparCampos();
        }
    }
    
    public void preencherCampos() {
        ISBNText.setText(String.valueOf(lSelecionado.getISBN()));
        tituloText.setText(lSelecionado.getTitulo());
        autorText.setText(lSelecionado.getAutor());
        categoriaText.setText(lSelecionado.getAutor());
        paginasText.setText(String.valueOf(lSelecionado.getPaginas()));
        precoText.setText(String.valueOf(lSelecionado.getPreco()));
        String status_index = lSelecionado.isStatus() ? "Disponível" : "Indisponível";
        statusLista.getModel().setSelectedItem(status_index);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabelaDeLivros = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ISBNText = new javax.swing.JTextField();
        tituloText = new javax.swing.JTextField();
        paginasText = new javax.swing.JTextField();
        autorText = new javax.swing.JTextField();
        categoriaText = new javax.swing.JTextField();
        precoText = new javax.swing.JTextField();
        statusLista = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnProcurar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        tabelaLivros.setModel(tabelaModelo);
        tabelaDeLivros.setViewportView(tabelaLivros);

        jLabel1.setText("ISBN");

        jLabel2.setText("TÍTULO");

        jLabel3.setText("AUTOR");

        jLabel4.setText("QUANTIDADE DE PÁGINAS");

        jLabel5.setText("CATEGORIA");

        jLabel6.setText("STATUS");

        jLabel7.setText("PREÇO");

        ISBNText.setText("0000-00");
        ISBNText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBNTextActionPerformed(evt);
            }
        });

        tituloText.setText("Título do livro");
        tituloText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloTextActionPerformed(evt);
            }
        });

        paginasText.setText("Quantidade de páginas");
        paginasText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paginasTextActionPerformed(evt);
            }
        });

        autorText.setText("Autor do livro");
        autorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autorTextActionPerformed(evt);
            }
        });

        categoriaText.setText("Categoria");
        categoriaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaTextActionPerformed(evt);
            }
        });

        precoText.setText("00,00");
        precoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precoTextActionPerformed(evt);
            }
        });

        statusLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponível", "Indisponível" }));
        statusLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusListaActionPerformed(evt);
            }
        });

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnProcurar.setText("PROCURAR");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        jLabel8.setText("R$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabelaDeLivros)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(categoriaText, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(paginasText, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(tituloText)
                            .addComponent(ISBNText)
                            .addComponent(autorText, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(statusLista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(precoText, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProcurar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(ISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tituloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(autorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(paginasText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(categoriaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(precoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(statusLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(tabelaDeLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabelaLivros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                preencherSelecionado(e);
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ISBNTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBNTextActionPerformed

    private void tituloTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloTextActionPerformed

    private void paginasTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paginasTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paginasTextActionPerformed

    private void autorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autorTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autorTextActionPerformed

    private void categoriaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriaTextActionPerformed

    private void precoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precoTextActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (!this.podeEditar) {
            JOptionPane.showMessageDialog(this, "Selecione um livro na tabela ou clique em NOVO.\nÉ preciso preencher todos os campos.");
            return;
        }

        int id = lSelecionado.getId();
        int ISBN = Integer.parseInt(ISBNText.getText());
        String titulo = tituloText.getText();
        String autor = autorText.getText();
        int paginas = Integer.parseInt(paginasText.getText());
        String categoria = categoriaText.getText();
        double preco = Double.parseDouble(precoText.getText());
        boolean status = statusLista.getSelectedItem().toString().equals("Disponível");

        this.preencherLivro(lSelecionado, id, ISBN, titulo, autor, paginas, categoria, preco, status);

        if (lSelecionado != null && !(titulo.equals("") || autor.equals(""))) {
            System.out.println(lSelecionado);
            if (this.tabelaModelo == null) {
                System.out.println("A tabela é nula");
            }
            if (lSelecionado.getId() != 0) {
                // atualizar
                lController.salvar(this.tabelaModelo, lSelecionado, false);
            } else {
                // criar novo
                lController.salvar(this.tabelaModelo, lSelecionado, true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "É preciso preencher todos os campos.");
        }
        
        
        limparCampos();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void statusListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusListaActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitarCamposEdicao();
        this.ISBNText.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       if (lSelecionado == null) {
            JOptionPane.showMessageDialog(this, "O livro selecionado não existe no banco de dados.\nTente selecionar um livro da tabela abaixo." );
        } else {
            lController.excluir(tabelaModelo, lSelecionado);
        }

        limparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        Object[] possibilities = {"Todos", "Pelo Código", "Pelo ISBN"};
        String escolha = (String) JOptionPane.showInputDialog(
                this,
                "Escolha o tipo de busca\n"
                + "que deseja efetuar",
                "Buscar Livro",
                JOptionPane.QUESTION_MESSAGE,
                null,
                possibilities,
                possibilities[0]);
        
        escolha = escolha == null ? "" : escolha;

        switch (escolha) {
            case "Pelo Código":
                int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Código do Livro: "));
                lController.listarPorId(tabelaModelo, id);
                break;
            case "Pelo ISBN":
                int ISBN = Integer.parseInt(JOptionPane.showInputDialog(this, "ISBN do Livro: "));
                lController.listarPorISBN(tabelaModelo, ISBN);
                break;
            default:
                lController.listarTodos(tabelaModelo);
        }
    }//GEN-LAST:event_btnProcurarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ISBNText;
    private javax.swing.JTextField autorText;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField categoriaText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField paginasText;
    private javax.swing.JTextField precoText;
    private javax.swing.JComboBox<String> statusLista;
    private javax.swing.JScrollPane tabelaDeLivros;
    private javax.swing.JTable tabelaLivros;
    private javax.swing.JTextField tituloText;
    // End of variables declaration//GEN-END:variables
}
