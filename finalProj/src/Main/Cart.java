package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import utils.DatabaseHandler;
import utils.Product;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class Cart{
	
	private JTextField descField;
	private JTextField priceField;
	private static JTextField totpriceField;
	private static JSpinner qtyField;
	private int recqty;
	private JTextField skuField;
	double sum ;
	public Cart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frmAddItems = new JFrame();
		frmAddItems.setResizable(false);
		frmAddItems.setTitle("Add Items");
		frmAddItems.setBounds(100, 100, 450, 342);
		frmAddItems.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddItems.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel body = new JPanel();
		body.setBackground(new Color(233, 233, 233));
		body.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmAddItems.getContentPane().add(body, BorderLayout.CENTER);
		body.setLayout(null);
		
		JPanel top = new JPanel();
		top.setBounds(0, 0, 714, 64);
		body.add(top);
		top.setBorder(new EmptyBorder(0, 5, 0, 83));
		top.setBackground(new Color(48, 62, 71));
		top.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Add Items");
		lblNewLabel_3.setBounds(15, 11, 130, 37);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Gilroy ExtraBold", Font.BOLD, 26));
		top.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Description:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(29, 120, 85, 14);
		body.add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrice.setBounds(74, 149, 40, 14);
		body.add(lblPrice);
		
		JLabel lblQuanitity = new JLabel("Quantity:");
		lblQuanitity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuanitity.setBounds(48, 209, 66, 19);
		body.add(lblQuanitity);
		
		descField = new JTextField();
		descField.setEditable(false);
		descField.setBounds(124, 119, 259, 20);
		body.add(descField);
		descField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setEditable(false); 
		priceField.setColumns(10);
		priceField.setBounds(124, 149, 259, 20);
		body.add(priceField);
		
		JButton btnNewButton = new JButton("Add To Cart");
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JTable cartble = Dashboard.bringTable();
				DefaultTableModel model = new DefaultTableModel();
				model =(DefaultTableModel)cartble.getModel();
				int lol = Integer.parseInt(Dashboard.getdataqty());
				int mess = Integer.parseInt(qtyField.getValue().toString());
				int qtyChange = lol - mess;
				if( lol >= mess ) {
					
						
						
						
					
					
						
							model.addRow(new Object[]{
									
									descField.getText(),
									qtyField.getValue().toString(),
									priceField.getText(),
									totpriceField.getText(),		
									
							});
								
							
							
							for(int i = 0; i < cartble.getRowCount(); i++ ) {
									String val = cartble.getValueAt(i , 3).toString();
									sum += Double.parseDouble(val);
							}
									
							Dashboard.totalAmount.setText(Double.toString(sum));
							frmAddItems.dispose();
									
						
				}else {
					JOptionPane.showInternalMessageDialog(null, "Stock Not Enough");
				}
						
			}
				
		});
		btnNewButton.setBounds(125, 257, 96, 23);
		body.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmAddItems.dispose();
			}
		});
		btnClose.setBounds(231, 257, 96, 23);
		body.add(btnClose);
		
		JLabel totalpriceLabel = new JLabel("Total Price:");
		totalpriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalpriceLabel.setBounds(33, 176, 81, 14);
		body.add(totalpriceLabel);
		
		totpriceField = new JTextField();
		totpriceField.setEditable(false);
		totpriceField.setColumns(10);
		totpriceField.setBounds(124, 176, 259, 20);
		body.add(totpriceField);
		
		qtyField = new JSpinner();
		qtyField.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				int qty = Integer.parseInt(qtyField.getValue().toString());
				double price = Double.parseDouble(priceField.getText());
					
				double tot = qty * price;
				totpriceField.setText(String.valueOf(tot));
				
			}
		});
		qtyField.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		qtyField.setBounds(124, 205, 120, 23);
		body.add(qtyField);
		
		JLabel lblSku = new JLabel("SKU:");
		lblSku.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSku.setBounds(79, 95, 85, 14);
		body.add(lblSku);
		
		skuField = new JTextField();
		skuField.setEditable(false);
		skuField.setColumns(10);
		skuField.setBounds(124, 88, 259, 20);
		body.add(skuField);
		frmAddItems.setLocationRelativeTo(null);
		frmAddItems.setVisible(true);
	}
	public boolean isCartItemAlreadyExist(JTable table) {
		for(int row = 0; row < table.getRowCount(); row++) {
			String cartDesc = table.getValueAt(row, 0).toString();
			String newItemDesc = descField.getText();
			if(cartDesc.contains(newItemDesc)) {
				return true;
			}
		}
		return false;
	}
	
	public void setSku(String sku) {
		skuField.setText(sku);
	}
	
	public void setdesc(String a) {
		descField.setText(a);
		
	}
	
	public void setprice(String a) {
		priceField.setText(a);
	}
	
	public void setTot(String a) {
		totpriceField.setText(a);
	}
	
	public String getprice() {
		return priceField.getText();
	}
	
	public int getQtyValue() {
		return (int) qtyField.getValue();
	}
	public static String getTot() {
		return totpriceField.getText();
	}
	
}
