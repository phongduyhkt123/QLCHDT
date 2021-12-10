package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class bill extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txfPro;
	private JTextField txfPrice;
	private JTextField txfQuantity;
	private JTable tablePro;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txfAddress;

	public bill() {
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
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(25, 25, 112));
		textField_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		textField_1.setBounds(301, 13, 230, 25);
		panelCus.add(textField_1);
		
		JLabel lbProduct = new JLabel("Product");
		lbProduct.setBounds(20, 90, 100, 30);
		panelCus.add(lbProduct);
		lbProduct.setForeground(new Color(25, 25, 112));
		lbProduct.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		
		txfPro = new JTextField();
		txfPro.setBounds(301, 93, 230, 25);
		panelCus.add(txfPro);
		txfPro.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfPro.setForeground(new Color(25, 25, 112));
		txfPro.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		txfPro.setColumns(10);
		
		JLabel lbPrice = new JLabel("Price");
		lbPrice.setBounds(20, 130, 100, 30);
		panelCus.add(lbPrice);
		lbPrice.setForeground(new Color(25, 25, 112));
		lbPrice.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		
		txfPrice = new JTextField();
		txfPrice.setBounds(115, 133, 270, 25);
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
		
		JLabel lbPhone = new JLabel("Phone");
		lbPhone.setForeground(new Color(25, 25, 112));
		lbPhone.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbPhone.setBounds(20, 50, 100, 30);
		panelCus.add(lbPhone);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(25, 25, 112));
		textField_2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		textField_2.setBounds(115, 53, 100, 25);
		panelCus.add(textField_2);
		
		JComboBox cbID_1 = new JComboBox();
		cbID_1.setForeground(new Color(25, 25, 112));
		cbID_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		cbID_1.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbID_1.setBackground(new Color(245, 255, 250));
		cbID_1.setBounds(115, 13, 175, 25);
		panelCus.add(cbID_1);
		
		txfAddress = new JTextField();
		txfAddress.setForeground(new Color(25, 25, 112));
		txfAddress.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		txfAddress.setColumns(10);
		txfAddress.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfAddress.setBounds(301, 53, 230, 25);
		panelCus.add(txfAddress);
		
		JLabel lbAddress = new JLabel("Address");
		lbAddress.setForeground(new Color(25, 25, 112));
		lbAddress.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbAddress.setBounds(225, 50, 100, 30);
		panelCus.add(lbAddress);
		
		JComboBox cbPro = new JComboBox();
		cbPro.setForeground(new Color(25, 25, 112));
		cbPro.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		cbPro.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbPro.setBackground(new Color(245, 255, 250));
		cbPro.setBounds(115, 93, 175, 25);
		panelCus.add(cbPro);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(417, 130, 90, 30);
		panelCus.add(btnAdd);
		btnAdd.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdd.setBackground(new Color(204, 204, 255));
		btnAdd.setForeground(new Color(25, 25, 112));
		btnAdd.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(417, 170, 90, 30);
		panelCus.add(btnCancel);
		btnCancel.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.setForeground(new Color(25, 25, 112));
		btnCancel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		
		txfQuantity = new JTextField();
		txfQuantity.setBounds(115, 173, 270, 25);
		panelCus.add(txfQuantity);
		txfQuantity.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfQuantity.setForeground(new Color(25, 25, 112));
		txfQuantity.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		txfQuantity.setColumns(10);
		
		JLabel lbBillDetail = new JLabel("BILL DETAIL");
		lbBillDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lbBillDetail.setForeground(new Color(25, 25, 112));
		lbBillDetail.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lbBillDetail.setBounds(198, 250, 163, 30);
		add(lbBillDetail);
		
		JPanel panelProList = new JPanel();
		panelProList.setOpaque(false);
		panelProList.setBorder(new LineBorder(new Color(25, 25, 112)));
		panelProList.setBackground(new Color(176, 196, 222));
		panelProList.setBounds(10, 286, 540, 165);
		add(panelProList);
		panelProList.setLayout(null);
		
		tablePro = new JTable();
		tablePro.setBackground(new Color(176, 196, 222));
		tablePro.setBounds(0, 247, 540, -246);
		panelProList.add(tablePro);
		
		JButton btnPay = new JButton("Pay");
		btnPay.setBounds(460, 460, 90, 30);
		add(btnPay);
		btnPay.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnPay.setBackground(new Color(204, 204, 255));
		btnPay.setForeground(new Color(25, 25, 112));
		btnPay.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		
		JButton btnDel = new JButton("Delete");
		btnDel.setBounds(360, 460, 90, 30);
		add(btnDel);
		btnDel.setForeground(new Color(25, 25, 112));
		btnDel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnDel.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnDel.setBackground(new Color(204, 204, 255));

	}
}
