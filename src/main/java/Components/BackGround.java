package Components;

import Dao.TransactionDao;
import Utils.RoundedPanels;
import java.awt.Color;
import Utils.Estructurs.Pila;
import com.raven.model.ModelTransaction;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BackGround extends RoundedPanels {

    private final Pila<ModelTransaction> pilaTransacciones = new Pila<>();
    private final TransactionDao transactionDao = new TransactionDao();
    Color fondoNormal = new Color(224, 236, 248);
    Color fondoHover = new Color(191, 219, 243);

    public BackGround() {
        super(20, new Color(153, 153, 153));
        initComponents();
        /*table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Descripción", "Fecha", "Monto", "Tipo"}
        ) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });*/
        cargarTransaccionesIniciales();
    }

    private void cargarTransaccionesIniciales() {
        List<ModelTransaction> listaBD = transactionDao.listar();
        for (ModelTransaction t : listaBD) {
            pilaTransacciones.push(t);
        }
        actualizarTablaDesdePila();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CardBalanceT = new Components.Card();
        CardIngresoT = new Components.Card();
        CardGastosT = new Components.Card();
        jSeparator1 = new javax.swing.JSeparator();
        BtIngreso = new javax.swing.JButton();
        BtEgreso = new javax.swing.JButton();
        BtDeshacer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new Utils.Table();
        jLabel1 = new javax.swing.JLabel();

        CardBalanceT.setColor1(new java.awt.Color(235, 51, 73));
        CardBalanceT.setColor2(new java.awt.Color(244, 92, 67));

        CardIngresoT.setColor1(new java.awt.Color(17, 153, 142));
        CardIngresoT.setColor2(new java.awt.Color(56, 239, 125));

        CardGastosT.setColor1(new java.awt.Color(142, 45, 226));
        CardGastosT.setColor2(new java.awt.Color(74, 0, 224));

        BtIngreso.setBackground(new java.awt.Color(224, 236, 248));
        BtIngreso.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BtIngreso.setForeground(new java.awt.Color(30, 41, 59));
        BtIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.png"))); // NOI18N
        BtIngreso.setText(" Nuevo Ingreso");
        BtIngreso.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BtIngresoMouseMoved(evt);
            }
        });
        BtIngreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtIngresoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtIngresoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtIngresoMouseExited(evt);
            }
        });
        BtIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIngresoActionPerformed(evt);
            }
        });

        BtEgreso.setBackground(new java.awt.Color(224, 236, 248));
        BtEgreso.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BtEgreso.setForeground(new java.awt.Color(30, 41, 59));
        BtEgreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/less.png"))); // NOI18N
        BtEgreso.setText(" Nuevo Gasto");
        BtEgreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtEgresoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtEgresoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtEgresoMouseExited(evt);
            }
        });
        BtEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEgresoActionPerformed(evt);
            }
        });

        BtDeshacer.setBackground(new java.awt.Color(224, 236, 248));
        BtDeshacer.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BtDeshacer.setForeground(new java.awt.Color(30, 41, 59));
        BtDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/deshacer.png"))); // NOI18N
        BtDeshacer.setText(" Deshacer");
        BtDeshacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtDeshacerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtDeshacerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtDeshacerMouseExited(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Roboto SemiCondensed ExtraBold", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("HISTORIAL  DE TRANSACCIONES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CardBalanceT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CardIngresoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CardGastosT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(BtEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(BtDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CardGastosT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CardIngresoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CardBalanceT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtDeshacerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtDeshacerMouseClicked
        // Verificar si la Pila no contiene movimientos
        if (pilaTransacciones.Vacia()) {
            JOptionPane.showMessageDialog(this,
                    "No hay transacciones recientes para deshacer.",
                    "Pila Vacía",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Desapilar el registro (POP)
        ModelTransaction transaccionEliminada = pilaTransacciones.prop();

        //Eliminar físicamente de PostgreSQL vía DAO
        if (transaccionEliminada.getId() > 0) {
            transactionDao.eliminar(transaccionEliminada.getId());
        }

        // Actualizar vista y tarjetas
        actualizarTablaDesdePila();

        JOptionPane.showMessageDialog(this,
                "Se deshizo correctamente la transacción: " + transaccionEliminada.getDescription(),
                "Operación Exitosa",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BtDeshacerMouseClicked

    private void BtIngresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtIngresoMouseClicked
        abrirFormularioModal("Ingreso");
    }//GEN-LAST:event_BtIngresoMouseClicked

    private void BtIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIngresoActionPerformed

    }//GEN-LAST:event_BtIngresoActionPerformed

    private void BtEgresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtEgresoMouseClicked
        abrirFormularioModal("Gasto");
    }//GEN-LAST:event_BtEgresoMouseClicked

    private void actualizarTablaDesdePila() {
        table.clear();
        List<ModelTransaction> listaTransacciones = pilaTransacciones.aLista();
        for (ModelTransaction transaccion : listaTransacciones) {
            table.addTransactionRow(transaccion);
        }
        actualizarTarjetasResumen();
    }

    public void registrarTransaccion(ModelTransaction nuevaTransaccion) {
        boolean guardadoEnBD = transactionDao.agregar(nuevaTransaccion);

        if (guardadoEnBD) {
            // B. Si se guardó en BD con éxito, se apila en la Pila LIFO en memoria
            pilaTransacciones.push(nuevaTransaccion);

            // C. Refrescar el JTable leyendo la Pila
            actualizarTablaDesdePila();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar el registro en PostgreSQL.",
                    "Error de BD",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void BtIngresoMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_BtIngresoMouseEntered
        BtIngreso.setBackground(fondoHover);
    }// GEN-LAST:event_BtIngresoMouseEntered

    private void BtIngresoMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_BtIngresoMouseExited
        BtIngreso.setBackground(fondoNormal);
    }// GEN-LAST:event_BtIngresoMouseExited

    private void BtEgresoMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_BtEgresoMouseEntered
        BtEgreso.setBackground(fondoHover);
    }// GEN-LAST:event_BtEgresoMouseEntered

    private void BtEgresoMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_BtEgresoMouseExited
        BtEgreso.setBackground(fondoNormal);
    }// GEN-LAST:event_BtEgresoMouseExited

    private void BtDeshacerMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_BtDeshacerMouseEntered
        BtDeshacer.setBackground(fondoHover);
    }// GEN-LAST:event_BtDeshacerMouseEntered

    private void BtDeshacerMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_BtDeshacerMouseExited
        BtDeshacer.setBackground(fondoNormal);
    }// GEN-LAST:event_BtDeshacerMouseExited

    private void BtIngresoMouseMoved(java.awt.event.MouseEvent evt) {
    }

    private void BtEgresoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void abrirFormularioModal(String tipo) {
        java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
        DlgTransaction dialog = new DlgTransaction(parentFrame, true, tipo); // Envía "Ingreso" o "Gasto"
        dialog.setVisible(true);

        ModelTransaction nueva = dialog.getTransaccionGuardada();
        if (nueva != null) {
            registrarTransaccion(nueva); // Apila y guarda en PostgreSQL
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtDeshacer;
    private javax.swing.JButton BtEgreso;
    private javax.swing.JButton BtIngreso;
    private Components.Card CardBalanceT;
    private Components.Card CardGastosT;
    private Components.Card CardIngresoT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private Utils.Table table;
    // End of variables declaration//GEN-END:variables

    private void actualizarTarjetasResumen() {
        double totalIngresosMes = 0;
        double totalGastosMes = 0;

        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();
        int anioActual = fechaActual.getYear();

        // Nombre del mes en español
        String nombreMes = fechaActual.getMonth()
                .getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        nombreMes = nombreMes.substring(0, 1).toUpperCase() + nombreMes.substring(1);

        java.util.List<ModelTransaction> lista = pilaTransacciones.aLista();
        for (ModelTransaction t : lista) {
            String fechaStr = t.getDate();

            if (fechaStr != null && !fechaStr.trim().isEmpty()) {
                try {
                    LocalDate fechaTransaccion = null;

                    // Soporte para formato "YYYY-MM-DD" o "DD/MM/YYYY" / "DD-MM-YYYY"
                    if (fechaStr.contains("-") && fechaStr.indexOf("-") == 4) {
                        // Formato ISO: 2026-11-11
                        fechaTransaccion = LocalDate.parse(fechaStr);
                    } else if (fechaStr.contains("/")) {
                        // Formato Latino: 11/11/2026
                        java.time.format.DateTimeFormatter fmt = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        fechaTransaccion = LocalDate.parse(fechaStr, fmt);
                    } else if (fechaStr.contains("-")) {
                        // Formato Latino con guiones: 11-11-2026
                        java.time.format.DateTimeFormatter fmt = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        fechaTransaccion = LocalDate.parse(fechaStr, fmt);
                    }

                    // Si la fecha se parseó correctamente y pertenece al mes/año actual
                    if (fechaTransaccion != null
                            && fechaTransaccion.getMonthValue() == mesActual
                            && fechaTransaccion.getYear() == anioActual) {

                        if (t.getType().equalsIgnoreCase("Ingreso")) {
                            totalIngresosMes += t.getAmount();
                        } else if (t.getType().equalsIgnoreCase("Gasto")) {
                            totalGastosMes += t.getAmount();
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Error parseando fecha '" + fechaStr + "': " + e.getMessage());
                }
            }
        }

        double balanceTotal = totalIngresosMes - totalGastosMes;

        // Cargar íconos
        javax.swing.Icon iconAhorro = new javax.swing.ImageIcon(getClass().getResource("/Images/Ahorrosx32.png"));
        javax.swing.Icon iconGasto = new javax.swing.ImageIcon(getClass().getResource("/Images/Billetesx32.png"));
        javax.swing.Icon iconIngreso = new javax.swing.ImageIcon(getClass().getResource("/Images/Dinerox32.png"));

        // Se envía 'nombreMes' a las 3 tarjetas usando el constructor de 4 parámetros
        CardBalanceT.setData(new Utils.Model_Card(iconAhorro, "Balance Total", nombreMes, (long) balanceTotal));
        CardIngresoT.setData(new Utils.Model_Card(iconIngreso, "Ingresos", nombreMes, (long) totalIngresosMes));
        CardGastosT.setData(new Utils.Model_Card(iconGasto, "Gastos", nombreMes, (long) totalGastosMes));
    }
}
