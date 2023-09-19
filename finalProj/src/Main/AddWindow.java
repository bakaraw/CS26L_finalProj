package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import utils.ActivityLogs;
import utils.DatabaseHandler;
import utils.Product;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddWindow extends JFrame {

	private JPanel Body;
	private Product category = new Product();
	private String chosenCat = category.getCategoryByIndex(0);
	private JTextField skuField;
	private JTextField descField;
	private JTextField stockbyField;
	private JTextField priceField;
	private JTextField qtyField;
	private JTable inventoryTable;
	private JTable logsTable;
	static DatabaseHandler handler = new DatabaseHandler();
	private static AddWindow obj=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWindow frame = new AddWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 364, 414);
		setLocationRelativeTo(null);
		Body = new JPanel();
		Body.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Body);
		Body.setLayout(null);
		
		JPanel top = new JPanel();
		top.setLayout(null);
		top.setBorder(new EmptyBorder(0, 5, 0, 83));
		top.setBackground(new Color(48, 62, 71));
		top.setBounds(0, 0, 348, 64);
		Body.add(top);
		
		JLabel lblNewLabel_3 = new JLabel("Add Product");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Gilroy ExtraBold", Font.BOLD, 26));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(15, 11, 160, 37);
		top.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("SKU:");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(95, 107, 35, 20);
		Body.add(lblNewLabel);
		
		JLabel lblDescription = new JLabel("DESCRIPTION:");
		lblDescription.setVerticalAlignment(SwingConstants.TOP);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescription.setBounds(21, 138, 109, 20);
		Body.add(lblDescription);
		
		JLabel lblStockInBy = new JLabel("STOCK IN BY:");
		lblStockInBy.setVerticalAlignment(SwingConstants.TOP);
		lblStockInBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStockInBy.setBounds(28, 170, 102, 20);
		Body.add(lblStockInBy);
		
		JLabel lblCategory = new JLabel("CATEGORY:");
		lblCategory.setVerticalAlignment(SwingConstants.TOP);
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategory.setBounds(41, 201, 89, 20);
		Body.add(lblCategory);
		
		JComboBox catCb = new JComboBox(new Object[]{});
		catCb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String chosen = (String) catCb.getSelectedItem();
				if(chosen.contains(category.getCategoryByIndex(0))) {
					chosenCat = category.getCategoryByIndex(0);
				}
				else if(chosen.contains(category.getCategoryByIndex(1))) {
					chosenCat = category.getCategoryByIndex(1);
				}
				else if(chosen.contains(category.getCategoryByIndex(2))) {
					chosenCat = category.getCategoryByIndex(2);
				}
				else if(chosen.contains(category.getCategoryByIndex(3))) {
					chosenCat = category.getCategoryByIndex(3);
				}
				else if(chosen.contains(category.getCategoryByIndex(4))) {
					chosenCat = category.getCategoryByIndex(4);
				}
				else if(chosen.contains(category.getCategoryByIndex(5))) {
					chosenCat = category.getCategoryByIndex(5);
				}
			}
		});
		catCb.setModel(new DefaultComboBoxModel(new String[] {"Peripherals", "CPU", "GPU", "Motherboard", "RAM", "Storage device"}));
		catCb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		catCb.setBounds(140, 197, 109, 27);
		Body.add(catCb);
		
		skuField = new JTextField();
		skuField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		skuField.setBounds(140, 107, 141, 22);
		Body.add(skuField);
		skuField.setColumns(10);
		
		descField = new JTextField();
		descField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		descField.setColumns(10);
		descField.setBounds(140, 140, 141, 22);
		Body.add(descField);
		
		stockbyField = new JTextField();
		stockbyField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		stockbyField.setColumns(10);
		stockbyField.setBounds(140, 170, 141, 22);
		Body.add(stockbyField);
		
		JLabel lblPrice = new JLabel("PRICE:");
		lblPrice.setVerticalAlignment(SwingConstants.TOP);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrice.setBounds(80, 232, 50, 20);
		Body.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("QUANTITY:");
		lblQuantity.setVerticalAlignment(SwingConstants.TOP);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantity.setBounds(43, 263, 89, 20);
		Body.add(lblQuantity);
		
		priceField = new JTextField();
		priceField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		priceField.setColumns(10);
		priceField.setBounds(140, 232, 141, 22);
		Body.add(priceField);
		
		qtyField = new JTextField();
		qtyField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		qtyField.setColumns(10);
		qtyField.setBounds(140, 263, 141, 22);
		Body.add(qtyField);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handler.Connect();
				saveToDataBase();
			}
		});
		
		btnNewButton.setBounds(140, 311, 89, 23);
		Body.add(btnNewButton);
	}
	
	void saveToDataBase() {
		String sku, desc, qty, price, stockinby, remarks;

		sku = skuField.getText();
		desc = descField.getText();
		qty = qtyField.getText();
		price = priceField.getText();
		stockinby = stockbyField.getText();
	
		try {
			if (!sku.isEmpty() && !desc.isEmpty() && !qty.isEmpty() && !price.isEmpty()) {

				Product prod = new Product();
				prod.setSku(sku);
				prod.setDescription(desc);
				prod.setCategory(chosenCat);
				prod.setQty(qty);
				prod.setPrice(price);

				ActivityLogs logs = new ActivityLogs();
				logs.setSku(sku);
				logs.setDescription(desc);
				logs.setActivity("Stock in");
				logs.setQty(qty);
				logs.setChangeBy(stockinby);
				

				handler.saveToDatabase(prod);
				handler.saveToDatabase(logs);
				handler.table_load("product", inventoryTable);
				handler.table_load("activitylogs", logsTable);

				skuField.setText("");
				descField.setText("");
				stockbyField.setText("");
				qtyField.setText("");
				priceField.setText("");
				

			} else {
				JOptionPane.showMessageDialog(null, "Please input all the necessary information");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static AddWindow getObj(){
        if(obj==null){
            obj=new AddWindow();
        }return obj;
    }
	
}
