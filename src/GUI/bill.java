package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import GUI.Controller.HoaDonChiTietController;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class bill extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txfPrice;
	private JTextField txfQuantity;
	private JTextField txfPhone;
	private JTextField txfAddress;
	private JTextField txfTotal;
	private JTable table;
	private JComboBox cbCus;
	private JComboBox cbPro;
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnPay;
	private JButton btnDel;
	private HoaDonChiTietController controller;

	public bill(Integer userId) {
		setOpaque(false);
		setBorder(new LineBorder(new Color(25, 25, 112)));
		setBackground(new Color(235, 255, 250));
		setLayout(null);
		setVisible(true);
		JLabel lbBill = new JLabel("BILL");
		lbBill.setHorizontalAlignment(SwingConstants.CENTER);
		lbBill.setForeground(new Color(25, 25, 112));
		lbBill.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lbBill.setBounds(198, 0, 163, 30);
		add(lbBill);
		
		JPanel panelCus = new JPanel();
		panelCus.setBorder(new LineBorder(new Color(25, 25, 112)));
		panelCus.setBackground(new Color(176, 196, 222));
		panelCus.setBounds(10, 30, 540, 215);
		add(panelCus);
		panelCus.setLayout(null);
		
		JLabel lbCusName = new JLabel("Customer");
		lbCusName.setForeground(new Color(25, 25, 112));
		lbCusName.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbCusName.setBounds(20, 10, 100, 30);
		panelCus.add(lbCusName);
		
		cbCus = new JComboBox();
		cbCus.setForeground(new Color(25, 25, 112));
		cbCus.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		cbCus.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbCus.setBackground(new Color(245, 255, 250));
		cbCus.setBounds(115, 13, 415, 25);
		panelCus.add(cbCus);
		
		JLabel lbPhone = new JLabel("Phone");
		lbPhone.setForeground(new Color(25, 25, 112));
		lbPhone.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbPhone.setBounds(20, 50, 100, 30);
		panelCus.add(lbPhone);
		
		txfPhone = new JTextField();
		txfPhone.setForeground(new Color(25, 25, 112));
		txfPhone.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		txfPhone.setColumns(10);
		txfPhone.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfPhone.setBounds(115, 53, 100, 25);
		panelCus.add(txfPhone);
		
		JLabel lbAddress = new JLabel("Address");
		lbAddress.setForeground(new Color(25, 25, 112));
		lbAddress.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbAddress.setBounds(225, 50, 100, 30);
		panelCus.add(lbAddress);
		
		txfAddress = new JTextField();
		txfAddress.setForeground(new Color(25, 25, 112));
		txfAddress.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		txfAddress.setColumns(10);
		txfAddress.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfAddress.setBounds(301, 53, 230, 25);
		panelCus.add(txfAddress);
		
		JLabel lbProduct = new JLabel("Product");
		lbProduct.setBounds(20, 90, 100, 30);
		panelCus.add(lbProduct);
		lbProduct.setForeground(new Color(25, 25, 112));
		lbProduct.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		
		cbPro = new JComboBox();
		cbPro.setForeground(new Color(25, 25, 112));
		cbPro.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		cbPro.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbPro.setBackground(new Color(245, 255, 250));
		cbPro.setBounds(115, 93, 415, 25);
		panelCus.add(cbPro);
		
		JLabel lbPrice = new JLabel("Price");
		lbPrice.setBounds(20, 130, 100, 30);
		panelCus.add(lbPrice);
		lbPrice.setForeground(new Color(25, 25, 112));
		lbPrice.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		
		txfPrice = new JTextField();
		txfPrice.setBounds(115, 133, 415, 25);
		panelCus.add(txfPrice);
		txfPrice.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfPrice.setForeground(new Color(25, 25, 112));
		txfPrice.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		txfPrice.setColumns(10);
		
		JLabel lbQuantity = new JLabel("Quantity");
		lbQuantity.setBounds(20, 170, 100, 30);
		panelCus.add(lbQuantity);
		lbQuantity.setForeground(new Color(25, 25, 112));
		lbQuantity.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		
		txfQuantity = new JTextField();
		txfQuantity.setBounds(115, 173, 315, 25);
		panelCus.add(txfQuantity);
		txfQuantity.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfQuantity.setForeground(new Color(25, 25, 112));
		txfQuantity.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		txfQuantity.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(440, 170, 90, 30);
		panelCus.add(btnAdd);
		btnAdd.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdd.setBackground(new Color(204, 204, 255));
		btnAdd.setForeground(new Color(25, 25, 112));
		btnAdd.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		
		JLabel lbBillDetail = new JLabel("BILL DETAIL");
		lbBillDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lbBillDetail.setForeground(new Color(25, 25, 112));
		lbBillDetail.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lbBillDetail.setBounds(198, 250, 163, 30);
		add(lbBillDetail);
		
		JPanel panelBillDetail = new JPanel();
		panelBillDetail.setBorder(new LineBorder(new Color(25, 25, 112)));
		panelBillDetail.setBackground(new Color(176, 196, 222));
		panelBillDetail.setBounds(10, 286, 540, 165);
		add(panelBillDetail);
		panelBillDetail.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		scrollPane.setBackground(new Color(176, 196, 222));
		scrollPane.setForeground(new Color(25, 25, 112));
		scrollPane.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		scrollPane.setBounds(0, 0, 540, 165);
		panelBillDetail.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(204, 204, 255));
		table.setForeground(new Color(25, 25, 112));
		table.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"ID", "Product name", "Price", "Quantity"}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lbTotalPrice = new JLabel("Total Price");
		lbTotalPrice.setForeground(new Color(25, 25, 112));
		lbTotalPrice.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbTotalPrice.setBounds(30, 460, 100, 30);
		add(lbTotalPrice);
		
		txfTotal = new JTextField();
		txfTotal.setBackground(new Color(204, 204, 255));
		txfTotal.setForeground(new Color(25, 25, 112));
		txfTotal.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		txfTotal.setColumns(10);
		txfTotal.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfTotal.setBounds(125, 463, 160, 25);
		add(txfTotal);
		
		btnPay = new JButton("Pay");
		btnPay.setBounds(480, 460, 70, 30);
		add(btnPay);
		btnPay.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnPay.setBackground(new Color(204, 204, 255));
		btnPay.setForeground(new Color(25, 25, 112));
		btnPay.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		
		btnDel = new JButton("Delete");
		btnDel.setBounds(400, 460, 70, 30);
		add(btnDel);
		btnDel.setForeground(new Color(25, 25, 112));
		btnDel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnDel.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnDel.setBackground(new Color(204, 204, 255));
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(320, 460, 70, 30);
		add(btnCancel);
		btnCancel.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.setForeground(new Color(25, 25, 112));
		btnCancel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		
		controller = new HoaDonChiTietController(userId, txfPrice, txfPrice, txfQuantity, txfPrice, txfPhone, txfAddress, txfTotal, table, cbCus, cbPro, btnAdd, btnCancel, btnPay, btnDel);
	}
	
	public HoaDonChiTietController getController() {
		return controller;
	}

	public void setController(HoaDonChiTietController controller) {
		this.controller = controller;
	}
}
