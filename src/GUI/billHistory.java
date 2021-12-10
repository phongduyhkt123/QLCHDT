package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import GUI.Controller.HoaDonController;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class billHistory extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txfEmp;
	private JTextField txfCus;
	private JTextField txfPhone;
	private JTextField txfIdBill;
	private JDateChooser txdate;
	private JTextField txfTotal;
	private JTable tableHistory;
	private JTextField txfFind;
	private JTable tableDetail;
	private JTextField txfIdEmp;
	private HoaDonController controller;
	private JComboBox cbFilter;
	private JButton btnFind;
	
	public billHistory(Integer userId, boolean isAdmin) {
		setOpaque(false);
		setBorder(new LineBorder(new Color(25, 25, 112)));
		setBackground(new Color(235, 255, 250));
		setLayout(null);
		setVisible(true);
		JLabel lbBillDetail = new JLabel("BILL DETAIL");
		lbBillDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lbBillDetail.setForeground(new Color(25, 25, 112));
		lbBillDetail.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lbBillDetail.setBounds(198, 0, 163, 30);
		add(lbBillDetail);
		
		JPanel panelCus = new JPanel();
		panelCus.setBorder(new LineBorder(new Color(25, 25, 112)));
		panelCus.setBackground(new Color(176, 196, 222));
		panelCus.setBounds(10, 30, 540, 240);
		add(panelCus);
		panelCus.setLayout(null);
		
		JLabel lbIdBill = new JLabel("ID Bill");
		lbIdBill.setForeground(new Color(25, 25, 112));
		lbIdBill.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbIdBill.setBounds(10, 10, 100, 30);
		panelCus.add(lbIdBill);
		
		txfIdBill = new JTextField();
		txfIdBill.setForeground(new Color(25, 25, 112));
		txfIdBill.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		txfIdBill.setColumns(10);
		txfIdBill.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfIdBill.setBounds(100, 13, 100, 25);
		panelCus.add(txfIdBill);
		
		JLabel lbDate = new JLabel("Date");
		lbDate.setForeground(new Color(25, 25, 112));
		lbDate.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbDate.setBounds(206, 10, 64, 30);
		panelCus.add(lbDate);
		
		txdate = new JDateChooser();
		txdate.getCalendarButton().setForeground(new Color(25, 25, 112));
		txdate.getCalendarButton().setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txdate.setForeground(new Color(25, 25, 112));
		txdate.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		txdate.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txdate.setBounds(243, 13, 100, 25);
		panelCus.add(txdate);
		
		JLabel lbTotal = new JLabel("Total");
		lbTotal.setForeground(new Color(25, 25, 112));
		lbTotal.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbTotal.setBounds(350, 10, 47, 30);
		panelCus.add(lbTotal);
		
		txfTotal = new JTextField();
		txfTotal.setForeground(new Color(25, 25, 112));
		txfTotal.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		txfTotal.setColumns(10);
		txfTotal.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfTotal.setBounds(391, 13, 140, 25);
		panelCus.add(txfTotal);
		
		JLabel lbPhone = new JLabel("Phone");
		lbPhone.setBounds(320, 45, 64, 30);
		panelCus.add(lbPhone);
		lbPhone.setForeground(new Color(25, 25, 112));
		lbPhone.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		
		txfPhone = new JTextField();
		txfPhone.setForeground(new Color(25, 25, 112));
		txfPhone.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		txfPhone.setColumns(10);
		txfPhone.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfPhone.setBounds(371, 48, 160, 25);
		panelCus.add(txfPhone);
		
		JLabel lbCus = new JLabel("Customer");
		lbCus.setForeground(new Color(25, 25, 112));
		lbCus.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbCus.setBounds(10, 45, 100, 30);
		panelCus.add(lbCus);
		
		txfCus = new JTextField();
		txfCus.setForeground(new Color(25, 25, 112));
		txfCus.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		txfCus.setColumns(10);
		txfCus.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfCus.setBounds(100, 48, 210, 25);
		panelCus.add(txfCus);
		
		JLabel lbEmp = new JLabel("Employee");
		lbEmp.setForeground(new Color(25, 25, 112));
		lbEmp.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbEmp.setBounds(206, 80, 100, 30);
		panelCus.add(lbEmp);
		
		txfEmp = new JTextField();
		txfEmp.setBounds(284, 83, 247, 25);
		panelCus.add(txfEmp);
		txfEmp.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfEmp.setForeground(new Color(25, 25, 112));
		txfEmp.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		txfEmp.setColumns(10);
		
		JScrollPane scrollDetail = new JScrollPane();
		scrollDetail.setOpaque(false);
		scrollDetail.setForeground(new Color(25, 25, 112));
		scrollDetail.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		scrollDetail.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		scrollDetail.setBackground(new Color(176, 196, 222));
		scrollDetail.setBounds(5, 120, 530, 115);
		panelCus.add(scrollDetail);
		
		tableDetail = new JTable();
		tableDetail.setBackground(new Color(204, 204, 255));
		tableDetail.setForeground(new Color(25, 25, 112));
		tableDetail.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		tableDetail.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollDetail.setViewportView(tableDetail);
		
		JLabel lbIdEmp = new JLabel("ID Employee");
		lbIdEmp.setForeground(new Color(25, 25, 112));
		lbIdEmp.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbIdEmp.setBounds(10, 80, 100, 30);
		panelCus.add(lbIdEmp);
		
		txfIdEmp = new JTextField();
		txfIdEmp.setForeground(new Color(25, 25, 112));
		txfIdEmp.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		txfIdEmp.setColumns(10);
		txfIdEmp.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfIdEmp.setBounds(100, 83, 100, 25);
		panelCus.add(txfIdEmp);
		
		JLabel lbBillHistory = new JLabel("BILL HISTORY");
		lbBillHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lbBillHistory.setForeground(new Color(25, 25, 112));
		lbBillHistory.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lbBillHistory.setBounds(10, 275, 152, 30);
		add(lbBillHistory);
		
		JPanel panelBillHistory = new JPanel();
		panelBillHistory.setOpaque(false);
		panelBillHistory.setBorder(new LineBorder(new Color(25, 25, 112)));
		panelBillHistory.setBackground(new Color(176, 196, 222));
		panelBillHistory.setBounds(10, 309, 540, 180);
		add(panelBillHistory);
		panelBillHistory.setLayout(null);
		
		JScrollPane scrollHistory = new JScrollPane();
		scrollHistory.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		scrollHistory.setBackground(new Color(176, 196, 222));
		scrollHistory.setForeground(new Color(25, 25, 112));
		scrollHistory.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		scrollHistory.setBounds(0, 0, 540, 180);
		panelBillHistory.add(scrollHistory);
		
		tableHistory = new JTable();
		tableHistory.setBackground(new Color(204, 204, 255));
		tableHistory.setForeground(new Color(25, 25, 112));
		tableHistory.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		tableHistory.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollHistory.setViewportView(tableHistory);
		
		cbFilter = new JComboBox();
		if (isAdmin) {
			cbFilter.setModel(new DefaultComboBoxModel(new String[] {"ID Bill", "ID Employee"}));
		}
		else {
			cbFilter.setModel(new DefaultComboBoxModel(new String[] {"ID Bill"}));
		}
		cbFilter.setBounds(277, 281, 80, 20);
		add(cbFilter);
		cbFilter.setOpaque(false);
		cbFilter.setForeground(new Color(25, 25, 112));
		cbFilter.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		cbFilter.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbFilter.setBackground(new Color(245, 255, 250));
		
		txfFind = new JTextField();
		txfFind.setBounds(365, 281, 115, 20);
		add(txfFind);
		txfFind.setForeground(new Color(25, 25, 112));
		txfFind.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txfFind.setColumns(10);
		txfFind.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		
		btnFind = new JButton("Find");
		btnFind.setBounds(490, 280, 60, 20);
		add(btnFind);
		btnFind.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnFind.setBackground(new Color(204, 204, 255));
		btnFind.setForeground(new Color(25, 25, 112));
		btnFind.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		
		controller = new HoaDonController(userId, txfEmp, txfCus, txfPhone, txfIdBill, txdate, txfTotal, tableHistory, txfFind, tableDetail, txfIdEmp, cbFilter, btnFind);
	}
	
	public HoaDonController getController() {
		return controller;
	}
}
