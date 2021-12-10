package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Controller.KhachHangController;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class customer extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txfName;
	private JTextField txfPhone;
	private JTextField txfAddress;
	private JTextField txfFind;
	private JDateChooser txdate;
	private JTextField txfId;
	private JComboBox cbGender;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnCancel;
	private JButton btnSave;
	private JComboBox cbFilter;
	private JButton btnFind;
	private JTable table;
	private KhachHangController controller;

	public customer() {
		setOpaque(false);
		setBorder(new LineBorder(new Color(25, 25, 112)));
		setBackground(new Color(235, 255, 250));
		setLayout(null);
		setVisible(true);
		JLabel lbCus = new JLabel("CUSTOMER");
		lbCus.setHorizontalAlignment(SwingConstants.CENTER);
		lbCus.setForeground(new Color(25, 25, 112));
		lbCus.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lbCus.setBounds(198, 0, 163, 30);
		add(lbCus);
		
		JPanel panelCus = new JPanel();
		panelCus.setBorder(new LineBorder(new Color(25, 25, 112)));
		panelCus.setBackground(new Color(176, 196, 222));
		panelCus.setBounds(10, 30, 540, 210);
		add(panelCus);
		panelCus.setLayout(null);
		
		JLabel lbID = new JLabel("ID");
		lbID.setForeground(new Color(25, 25, 112));
		lbID.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbID.setBounds(20, 10, 100, 30);
		panelCus.add(lbID);
		
		txfId = new JTextField();
		txfId.setForeground(new Color(25, 25, 112));
		txfId.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		txfId.setColumns(10);
		txfId.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfId.setBounds(90, 10, 320, 25);
		panelCus.add(txfId);
		
		JLabel lbName = new JLabel("Name");
		lbName.setForeground(new Color(25, 25, 112));
		lbName.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbName.setBounds(20, 50, 100, 30);
		panelCus.add(lbName);
				
		txfName = new JTextField();
		txfName.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfName.setForeground(new Color(25, 25, 112));
		txfName.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		txfName.setColumns(10);
		txfName.setBounds(90, 53, 320, 25);
		panelCus.add(txfName);
		
		JLabel lbGender = new JLabel("Gender");
		lbGender.setForeground(new Color(25, 25, 112));
		lbGender.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbGender.setBounds(20, 90, 100, 30);
		panelCus.add(lbGender);
		
		cbGender = new JComboBox();
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbGender.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbGender.setBackground(new Color(245, 255, 250));
		cbGender.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		cbGender.setForeground(new Color(25, 25, 112));
		cbGender.setBounds(90, 93, 100, 25);
		panelCus.add(cbGender);
		
		JLabel lbDob = new JLabel("Date of birth");
		lbDob.setForeground(new Color(25, 25, 112));
		lbDob.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbDob.setBounds(200, 90, 100, 30);
		panelCus.add(lbDob);
		
		txdate = new JDateChooser();
		txdate.getCalendarButton().setForeground(new Color(25, 25, 112));
		txdate.getCalendarButton().setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txdate.setBounds(290, 93, 120, 25);
		txdate.setForeground(new Color(25, 25, 112));
		txdate.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txdate.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txdate.setBackground(new Color(245, 255, 250));
		panelCus.add(txdate);
		
		JLabel lbPhone = new JLabel("Phone");
		lbPhone.setForeground(new Color(25, 25, 112));
		lbPhone.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbPhone.setBounds(20, 130, 100, 30);
		panelCus.add(lbPhone);

		txfPhone = new JTextField();
		txfPhone.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfPhone.setForeground(new Color(25, 25, 112));
		txfPhone.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		txfPhone.setColumns(10);
		txfPhone.setBounds(90, 133, 320, 25);
		panelCus.add(txfPhone);
		
		JLabel lbAddress = new JLabel("Address");
		lbAddress.setForeground(new Color(25, 25, 112));
		lbAddress.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbAddress.setBounds(20, 170, 100, 30);
		panelCus.add(lbAddress);
		
		txfAddress = new JTextField();
		txfAddress.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfAddress.setForeground(new Color(25, 25, 112));
		txfAddress.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		txfAddress.setColumns(10);
		txfAddress.setBounds(90, 173, 320, 25);
		panelCus.add(txfAddress);
		
		btnAdd = new JButton("Add");
		btnAdd.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdd.setBackground(new Color(204, 204, 255));
		btnAdd.setForeground(new Color(25, 25, 112));
		btnAdd.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnAdd.setBounds(440, 15, 90, 30);
		panelCus.add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnEdit.setBackground(new Color(204, 204, 255));
		btnEdit.setForeground(new Color(25, 25, 112));
		btnEdit.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnEdit.setBounds(440, 65, 90, 30);
		panelCus.add(btnEdit);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.setForeground(new Color(25, 25, 112));
		btnCancel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnCancel.setBounds(440, 115, 90, 30);
		panelCus.add(btnCancel);
		
		btnSave = new JButton("Save");
		btnSave.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnSave.setBackground(new Color(204, 204, 255));
		btnSave.setForeground(new Color(25, 25, 112));
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnSave.setBounds(440, 165, 90, 30);
		panelCus.add(btnSave);
		
		JLabel lbCusList = new JLabel("CUSTOMER LIST");
		lbCusList.setHorizontalAlignment(SwingConstants.CENTER);
		lbCusList.setForeground(new Color(25, 25, 112));
		lbCusList.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lbCusList.setBounds(10, 240, 185, 30);
		add(lbCusList);

		cbFilter = new JComboBox();
		cbFilter.setModel(new DefaultComboBoxModel(new String[] {"ID", "Name"}));
		cbFilter.setForeground(new Color(25, 25, 112));
		cbFilter.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		cbFilter.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbFilter.setBackground(new Color(245, 255, 250));
		cbFilter.setBounds(265, 245, 80, 20);
		add(cbFilter);
		
		txfFind = new JTextField();
		txfFind.setForeground(new Color(25, 25, 112));
		txfFind.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txfFind.setColumns(10);
		txfFind.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfFind.setBounds(350, 245, 130, 20);
		add(txfFind);
		
		btnFind = new JButton("Find");
		btnFind.setForeground(new Color(25, 25, 112));
		btnFind.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnFind.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnFind.setBackground(new Color(204, 204, 255));
		btnFind.setBounds(490, 245, 60, 20);
		add(btnFind);
		
		JPanel panelCusList = new JPanel();
		panelCusList.setBorder(new LineBorder(new Color(25, 25, 112)));
		panelCusList.setBackground(new Color(176, 196, 222));
		panelCusList.setBounds(10, 270, 540, 220);
		add(panelCusList);
		panelCusList.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		scrollPane.setBackground(new Color(176, 196, 222));
		scrollPane.setForeground(new Color(25, 25, 112));
		scrollPane.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		scrollPane.setBounds(0, 0, 540, 220);
		panelCusList.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(204, 204, 255));
		table.setForeground(new Color(25, 25, 112));
		table.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		controller = new KhachHangController(txfName, txfPhone, txfAddress, txfFind, txdate, txfId, cbGender, btnAdd, btnEdit, btnCancel, btnSave, cbFilter, btnFind, table);
	}
	
	public KhachHangController getController() {
		return controller;
	}

	public void setController(KhachHangController controller) {
		this.controller = controller;
	}
}
