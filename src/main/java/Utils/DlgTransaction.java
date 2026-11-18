package Utils;

import com.raven.model.ModelTransaction;
import java.awt.Frame;
import javax.swing.ImageIcon;

public class DlgTransaction extends javax.swing.JDialog {

    private ModelTransaction transaccionGuardada = null;
    private ModelTransaction transaccionAEditar = null;
    private String tipo;

    public DlgTransaction(Frame parent, boolean modal, String tipo) {
        super(parent, modal);
        this.tipo = tipo;
        initComponents();
        lblTitulo.setText("Nuevo " + tipo);
        setLocationRelativeTo(parent);
    }
// Constructor 2 Para editar una transacción existente

    public DlgTransaction(Frame parent, boolean modal, ModelTransaction transaccion) {
        super(parent, modal);
        this.transaccionAEditar = transaccion;
        this.tipo = transaccion.getType();
        initComponents();

        // Precargar los datos actuales en las cajas de texto
        lblTitulo.setText("Editar " + tipo);
        txtDescription.setText(transaccion.getDescription());
        txtAmount.setText(String.valueOf(transaccion.getAmount()));
        txtDate.setText(transaccion.getDate());

        setLocationRelativeTo(parent);
    }

    public ModelTransaction getTransaccionGuardada() {
        return transaccionGuardada;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        lblAmount = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Roboto", 1, 18));
        lblTitulo.setText("Nueva Transacción");

        lblDescription.setText("Descripción:");
        lblAmount.setText("Monto ($):");
        lblDate.setText("Fecha (DD/MM/AAAA):");

        txtDate.setText("09/11/2026");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblTitulo)
                                        .addComponent(lblDescription)
                                        .addComponent(txtDescription)
                                        .addComponent(lblAmount)
                                        .addComponent(txtAmount)
                                        .addComponent(lblDate)
                                        .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblTitulo)
                                .addGap(18, 18, 18)
                                .addComponent(lblDescription)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAmount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String desc = txtDescription.getText().trim();
            double amount = Double.parseDouble(txtAmount.getText().trim());
            String date = txtDate.getText().trim();

            if (desc.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía.");
                return;
            }

            String categoria = (transaccionAEditar != null) ? transaccionAEditar.getCategory() : "General";
            String iconPath = tipo.equalsIgnoreCase("Ingreso") ? "/Images/plus.png" : "/Images/less.png";
            ImageIcon icon = new ImageIcon(getClass().getResource(iconPath));

            transaccionGuardada = new ModelTransaction(icon, desc, categoria, date, tipo, amount);
            if (transaccionAEditar != null) {
                transaccionGuardada.setId(transaccionAEditar.getId());
            }

            dispose();

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingresa un monto válido.");
        }
    }

    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDescription;
}
