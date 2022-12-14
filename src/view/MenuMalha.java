package view;

import controller.ControllerMalha;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.MalhaViaria;

/**
 *
 * @author Lucas de Liz, Matheus Maas
 */
public class MenuMalha extends javax.swing.JFrame {

    private static SimuladorMalha viewSimuladorMalha;
    private ControllerMalha criarMalha;
    private static MenuMalha instance = null;

    /**
     * Creates new form viewMenuMalha
     */
    //Singleton
    public static MenuMalha getInstance() {
        if (instance == null) {
            instance = new MenuMalha();
        }
        return instance;
    }

    private MenuMalha() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonMalha1 = new javax.swing.JButton();
        jButtonMalha2 = new javax.swing.JButton();
        jButtonMalha3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonBuscarMalha = new javax.swing.JButton();
        jTextFieldDiretorio = new javax.swing.JTextField();
        jButtonIniciarSimu = new javax.swing.JButton();
        jLabelTitulo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTitulo.setText("Clique na Malha Que Deseja Simular");

        jButtonMalha1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonMalha1.setText("Malha 1");
        jButtonMalha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMalha1ActionPerformed(evt);
            }
        });

        jButtonMalha2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonMalha2.setText("Malha 2");
        jButtonMalha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMalha2ActionPerformed(evt);
            }
        });

        jButtonMalha3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonMalha3.setText("Malha 3");
        jButtonMalha3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMalha3ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Informe o Caminho da Malha");

        jButtonBuscarMalha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonBuscarMalha.setText("Buscar");
        jButtonBuscarMalha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarMalhaActionPerformed(evt);
            }
        });

        jTextFieldDiretorio.setEditable(false);
        jTextFieldDiretorio.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDiretorio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButtonIniciarSimu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonIniciarSimu.setText("Iniciar");
        jButtonIniciarSimu.setPreferredSize(new java.awt.Dimension(150, 35));
        jButtonIniciarSimu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarSimuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldDiretorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscarMalha)
                .addGap(9, 9, 9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonIniciarSimu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBuscarMalha)
                    .addComponent(jTextFieldDiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonIniciarSimu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jLabelTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTitulo1.setText("ou Escolha uma Malha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonMalha3)
                            .addComponent(jButtonMalha1)
                            .addComponent(jButtonMalha2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 122, Short.MAX_VALUE)
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(135, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTitulo1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonMalha1)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonMalha2)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonMalha3))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMalha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMalha1ActionPerformed
        this.setVisible(false);
        criarMalha = new ControllerMalha(MalhaViaria.getInstance());
        try {
            criarMalha.setCaminhoMalha("src/exemplosMalhas/malha-exemplo-1.txt");
            viewSimuladorMalha = SimuladorMalha.getInstance();
            viewSimuladorMalha.setExtendedState(JFrame.MAXIMIZED_BOTH);
            viewSimuladorMalha.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuMalha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonMalha1ActionPerformed

    private void jButtonMalha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMalha2ActionPerformed
        this.setVisible(false);
        criarMalha = new ControllerMalha(MalhaViaria.getInstance());
        try {
            criarMalha.setCaminhoMalha("src/exemplosMalhas/malha-exemplo-2.txt");
            viewSimuladorMalha = SimuladorMalha.getInstance();
            viewSimuladorMalha.setExtendedState(JFrame.MAXIMIZED_BOTH);
            viewSimuladorMalha.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuMalha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonMalha2ActionPerformed

    private void jButtonMalha3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMalha3ActionPerformed
        this.setVisible(false);
        criarMalha = new ControllerMalha(MalhaViaria.getInstance());
        try {
            criarMalha.setCaminhoMalha("src/exemplosMalhas/malha-exemplo-3.txt");
            viewSimuladorMalha = SimuladorMalha.getInstance();
            viewSimuladorMalha.setExtendedState(JFrame.MAXIMIZED_BOTH);
            viewSimuladorMalha.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuMalha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonMalha3ActionPerformed

    private void jButtonBuscarMalhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarMalhaActionPerformed
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
        FileFilter fileFilter = new FileNameExtensionFilter(".txt", "txt");
        fileChooser.setFileFilter(fileFilter);
        int retorno = fileChooser.showOpenDialog(this);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            String absolutePath = fileChooser.getSelectedFile().getAbsolutePath();
            try {

                jTextFieldDiretorio.setText(absolutePath);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonBuscarMalhaActionPerformed

    private void jButtonIniciarSimuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarSimuActionPerformed
        this.setVisible(false);
        criarMalha = new ControllerMalha(MalhaViaria.getInstance());
        try {
            criarMalha.setCaminhoMalha(jTextFieldDiretorio.getText());
            viewSimuladorMalha = SimuladorMalha.getInstance();
            viewSimuladorMalha.setExtendedState(JFrame.MAXIMIZED_BOTH);
            viewSimuladorMalha.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuMalha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonIniciarSimuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarMalha;
    private javax.swing.JButton jButtonIniciarSimu;
    private javax.swing.JButton jButtonMalha1;
    private javax.swing.JButton jButtonMalha2;
    private javax.swing.JButton jButtonMalha3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldDiretorio;
    // End of variables declaration//GEN-END:variables
}
