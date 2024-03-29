/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.philips.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author efsantos
 */
public class MainScreen extends javax.swing.JFrame {

    private static List<String> ltItemsPasta = new ArrayList<String>();
    private static List<String> ltScriptsSelecionados = new ArrayList<String>();

    private static List<String> pegaArquivos(String jarFolder) {
        //System.out.println(jarFolder);
        final File folder = new File(jarFolder);

        List<String> result = new ArrayList();

        search(".*\\.sql", folder, result);
        search(".*\\.txt", folder, result);

        return result;
    }

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
    }

    public static void search(final String pattern, final File folder, List<String> result) {
        //System.out.println(folder.getAbsolutePath());
        for (final File f : folder.listFiles()) {

            if (f.isDirectory()) {
                search(pattern, f, result);
            }

            if (f.isFile()) {
                if (f.getName().matches(pattern)) {
                    result.add(f.getAbsolutePath());
                }
            }

        }
    }

    private static String readFile(String pathname) {
        try { 
            File file = new File(pathname);            
            Reader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader in = new BufferedReader(reader);
            String line = null;
            StringBuilder rslt = new StringBuilder();
            while ((line = in.readLine()) != null) {
                rslt.append(line + "\n");
            }  
            return rslt.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "deu pau";
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaScriptsSelecionados = new javax.swing.JList();
        removeBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaPasta = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConcat = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jScrollPane2.setViewportView(listaScriptsSelecionados);

        removeBtn.setText("<-");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        addBtn.setText("->");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(listaPasta);

        jLabel1.setText("Arquivos de texto salvo");

        jLabel2.setText("Arquivos incluidos no script total");

        jLabel3.setText("Script concatenado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(removeBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeBtn)
                        .addGap(0, 333, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane4))
                .addGap(12, 12, 12)
                .addComponent(jLabel3))
        );

        txtConcat.setColumns(20);
        txtConcat.setRows(5);
        jScrollPane1.setViewportView(txtConcat);

        jLabel4.setText("Made by Eduardo Felipe dos Santos.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane1))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        int[] valores = listaScriptsSelecionados.getSelectedIndices();
        if (valores.length == 1) {
            String valor = (String) this.listaScriptsSelecionados.getSelectedValue();
            this.ltItemsPasta.add(valor);
            this.ltScriptsSelecionados.remove(this.listaScriptsSelecionados.getSelectedIndex());
            Collections.sort(ltItemsPasta);
        } else if (valores.length > 1) {
            String[] valoresSelecionados = Arrays.copyOf(this.listaScriptsSelecionados.getSelectedValues(), this.listaScriptsSelecionados.getSelectedValues().length, String[].class);
            this.ltItemsPasta.addAll(Arrays.asList(valoresSelecionados));
            for (int i = 0; i < valores.length; i++) {
                this.ltScriptsSelecionados.remove(valoresSelecionados[i]);
            }
        }
        atualizaListaScriptsSelecionados();
        atualizaPastaOrigens();
        try {
            atualizaConcatScripts();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_removeBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        int[] valores = listaPasta.getSelectedIndices();
        if (valores.length == 1) {
            String valor = (String) this.listaPasta.getSelectedValue();
            this.ltScriptsSelecionados.add(valor);
            this.ltItemsPasta.remove(listaPasta.getSelectedIndex());

        } else if (valores.length > 1) {
            String[] valoresSelecionados = Arrays.copyOf(this.listaPasta.getSelectedValues(), this.listaPasta.getSelectedValues().length, String[].class);
            this.ltScriptsSelecionados.addAll(Arrays.asList(valoresSelecionados));
            for (int i = 0; i < valores.length; i++) {
                this.ltItemsPasta.remove(valoresSelecionados[i]);
            }

        }
        atualizaListaScriptsSelecionados();
        atualizaPastaOrigens();
        try {
            atualizaConcatScripts();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                MainScreen painel = new MainScreen();

                painel.addItemsList(painel.pegaArquivos(new Utils().getJarFolder()));
                painel.atualizaPastaOrigens();
                painel.setVisible(true);
            }

        });
        //System.out.println(readFile("C:\\Users\\efsantos\\Desktop\\Inconsistências\\CPOEREC_TASASDE_FK_I.sql"));
        pegaArquivos(new Utils().getJarFolder());

    }

    public void atualizaPastaOrigens() {
        Collections.sort(ltItemsPasta);
        listaPasta.setModel(new javax.swing.AbstractListModel() {
            String variaveis[] = ltItemsPasta.toArray(new String[0]);

            public int getSize() {
                return variaveis.length;
            }

            public Object getElementAt(int i) {
                return variaveis[i];
            }
        });
    }

    public void atualizaListaScriptsSelecionados() {

        Collections.sort(ltScriptsSelecionados);
        listaScriptsSelecionados.setModel(new javax.swing.AbstractListModel() {
            String variaveis[] = ltScriptsSelecionados.toArray(new String[0]);

            public int getSize() {
                return variaveis.length;
            }

            public Object getElementAt(int i) {
                return variaveis[i];
            }
        });
    }

    private void addItemsList(List<String> values) {
        ltItemsPasta.addAll(values);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList listaPasta;
    private javax.swing.JList listaScriptsSelecionados;
    private javax.swing.JButton removeBtn;
    private javax.swing.JTextArea txtConcat;
    // End of variables declaration//GEN-END:variables

    private void atualizaConcatScripts() throws IOException {
        this.txtConcat.setText("");
        StringBuilder sb1 = new StringBuilder();
        for (String string : ltScriptsSelecionados) {
            sb1.append(readFile(string));
        }
        this.txtConcat.setText(sb1.toString());
    }

}
