/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Main;

import javax.swing.JTable;

import utils.DatabaseHandler;

/**
 *
 * @author Abcd
 */
public class InvisibleFrame extends javax.swing.JFrame {

    /**
     * Creates new form InvisibleFrame
     */
    public InvisibleFrame() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);
       

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );

        pack();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    
    
    
    public int calculateTotalSales(JTable table, int index) {
	    int total = 0;
	    
	    // Get the number of rows in the table
	    int rowCount = table.getRowCount();
	    
	    // Column index for the second column (assuming a zero-based index)
	    int columnIndex = index; // 1 represents the second column
	    
	    // Iterate through the rows and sum the values in the second column
	    for (int row = 0; row < rowCount; row++) {
	        Object value = table.getValueAt(row, columnIndex);
	        
	        if (value instanceof Number) {
	            total += ((Number) value).doubleValue();
	        }
	        // If your cells contain non-numeric data, you might need additional validation.
	        // For example, you can check the type of the cell value before adding it to the total.
	    }
	    
	    return total;
	}
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    	databaseHandler = new DatabaseHandler();
		databaseHandler.Connect();
    	  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvisibleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvisibleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvisibleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvisibleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      
  
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvisibleFrame().setVisible(true);
                databaseHandler.table_load("catcomparison", table);
            }
        });
    }
    
	
    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    static javax.swing.JTable table;
    private static DatabaseHandler databaseHandler;
    // End of variables declaration                   
}
