package GUI;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import Controller.NhanVienController;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Canvas;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class employee extends JPanel {	
	private static final long serialVersionUID = 1L;
	private JTextField txfID;
	private JTextField txfName;
	private JTextField txfPhone;
	private JTextField txfAddress;
	private JTextField txfEmail;
	private JTextField txfPasswd;
	private JTextField txfFind;
	private JLabel lblAvt;
	private JDateChooser txdate;
	private JTable table;
	private JComboBox cbRole;
	private JComboBox cbGender;
	private JButton btnUpload;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDisable;
	private JButton btnCancel;
	private JButton btnSave;
	private JComboBox cbFilter;
	private JButton btnFind;
	private JComboBox cbStatus;
	private NhanVienController controller;

	public employee() {
		setOpaque(false);
		setBorder(new LineBorder(new Color(25, 25, 112)));
		setBackground(new Color(235, 255, 250));
		setLayout(null);
		setVisible(true);
		JLabel lbEmp = new JLabel("EMPLOYEE");
		lbEmp.setHorizontalAlignment(SwingConstants.CENTER);
		lbEmp.setForeground(new Color(25, 25, 112));
		lbEmp.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lbEmp.setBounds(198, 0, 163, 30);
		add(lbEmp);
		
		JPanel panelEmp = new JPanel();
		panelEmp.setBorder(new LineBorder(new Color(25, 25, 112)));
		panelEmp.setBackground(new Color(176, 196, 222));
		panelEmp.setBounds(10, 30, 540, 250);
		add(panelEmp);
		panelEmp.setLayout(null);
		
		JLabel lbID = new JLabel("ID");
		lbID.setForeground(new Color(25, 25, 112));
		lbID.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbID.setBounds(105, 10, 100, 30);
		panelEmp.add(lbID);
		
		txfID = new JTextField();
		txfID.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfID.setForeground(new Color(25, 25, 112));
		txfID.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		txfID.setBounds(165, 13, 80, 25);
		panelEmp.add(txfID);
		txfID.setColumns(10);
		
		JLabel lbRole = new JLabel("Role");
		lbRole.setBounds(255, 10, 58, 30);
		panelEmp.add(lbRole);
		lbRole.setForeground(new Color(25, 25, 112));
		lbRole.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		
		cbRole = new JComboBox();
		cbRole.setModel(new DefaultComboBoxModel(new String[] {"Manage", "Employee"}));
		cbRole.setBounds(310, 13, 120, 25);
		panelEmp.add(cbRole);
		cbRole.setForeground(new Color(25, 25, 112));
		cbRole.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		cbRole.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbRole.setBackground(new Color(245, 255, 250));
		
		JLabel lbName = new JLabel("Name");
		lbName.setForeground(new Color(25, 25, 112));
		lbName.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbName.setBounds(105, 50, 100, 30);
		panelEmp.add(lbName);
		
		txfName = new JTextField();
		txfName.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfName.setForeground(new Color(25, 25, 112));
		txfName.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		txfName.setColumns(10);
		txfName.setBounds(165, 53, 265, 25);
		panelEmp.add(txfName);
		
		JLabel lbGender = new JLabel("Gender");
		lbGender.setBounds(105, 91, 58, 30);
		panelEmp.add(lbGender);
		lbGender.setForeground(new Color(25, 25, 112));
		lbGender.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		
		cbGender = new JComboBox();
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbGender.setBounds(165, 94, 80, 25);
		panelEmp.add(cbGender);
		cbGender.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbGender.setBackground(new Color(245, 255, 250));
		cbGender.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		cbGender.setForeground(new Color(25, 25, 112));
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setForeground(new Color(25, 25, 112));
		lbEmail.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbEmail.setBounds(105, 130, 51, 30);
		panelEmp.add(lbEmail);
		
		txfEmail = new JTextField();
		txfEmail.setForeground(new Color(25, 25, 112));
		txfEmail.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		txfEmail.setColumns(10);
		txfEmail.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfEmail.setBounds(165, 133, 265, 25);
		panelEmp.add(txfEmail);
		
		JLabel lbPhone = new JLabel("Phone");
		lbPhone.setBounds(10, 170, 80, 30);
		panelEmp.add(lbPhone);
		lbPhone.setForeground(new Color(25, 25, 112));
		lbPhone.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		
		txfPhone = new JTextField();
		txfPhone.setBounds(65, 173, 100, 25);
		panelEmp.add(txfPhone);
		txfPhone.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfPhone.setForeground(new Color(25, 25, 112));
		txfPhone.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		txfPhone.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(170, 170, 80, 30);
		panelEmp.add(lblPassword);
		lblPassword.setForeground(new Color(25, 25, 112));
		lblPassword.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		
		txfPasswd = new JTextField();
		txfPasswd.setBounds(245, 173, 185, 25);
		panelEmp.add(txfPasswd);
		txfPasswd.setForeground(new Color(25, 25, 112));
		txfPasswd.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		txfPasswd.setColumns(10);
		txfPasswd.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		
		btnUpload = new JButton("Upload");
		btnUpload.setBounds(5, 130, 90, 30);
		panelEmp.add(btnUpload);
		btnUpload.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUpload.setForeground(new Color(25, 25, 112));
		btnUpload.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnUpload.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnUpload.setBackground(new Color(204, 204, 255));
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(440, 10, 90, 30);
		panelEmp.add(btnAdd);
		btnAdd.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdd.setBackground(new Color(204, 204, 255));
		btnAdd.setForeground(new Color(25, 25, 112));
		btnAdd.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(440, 60, 90, 30);
		panelEmp.add(btnEdit);
		btnEdit.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnEdit.setBackground(new Color(204, 204, 255));
		btnEdit.setForeground(new Color(25, 25, 112));
		btnEdit.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		
		btnDisable = new JButton("Disable");
		btnDisable.setBounds(440, 110, 90, 30);
		panelEmp.add(btnDisable);
		btnDisable.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnDisable.setBackground(new Color(204, 204, 255));
		btnDisable.setForeground(new Color(25, 25, 112));
		btnDisable.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(440, 160, 90, 30);
		panelEmp.add(btnCancel);
		btnCancel.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.setForeground(new Color(25, 25, 112));
		btnCancel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		
		btnSave = new JButton("Save");
		btnSave.setBounds(440, 209, 90, 30);
		panelEmp.add(btnSave);
		btnSave.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnSave.setBackground(new Color(204, 204, 255));
		btnSave.setForeground(new Color(25, 25, 112));
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		
		JLabel lbStatus = new JLabel("Status");
		lbStatus.setForeground(new Color(25, 25, 112));
		lbStatus.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lbStatus.setBounds(10, 210, 57, 30);
		panelEmp.add(lbStatus);
		
		cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] {"Enable", "Disable"}));
		cbStatus.setForeground(new Color(25, 25, 112));
		cbStatus.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		cbStatus.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbStatus.setBackground(new Color(245, 255, 250));
		cbStatus.setBounds(65, 213, 100, 25);
		panelEmp.add(cbStatus);
		
		JLabel lbDob = new JLabel("DOB");
		lbDob.setBounds(255, 91, 58, 30);
		panelEmp.add(lbDob);
		lbDob.setForeground(new Color(25, 25, 112));
		lbDob.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		
		txdate = new JDateChooser();
		txdate.setBounds(310, 94, 120, 25);
		panelEmp.add(txdate);
		txdate.setForeground(new Color(25, 25, 112));
		txdate.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txdate.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txdate.setBackground(new Color(245, 255, 250));
		
		JLabel lbAddress = new JLabel("Address");
		lbAddress.setBounds(170, 210, 70, 30);
		panelEmp.add(lbAddress);
		lbAddress.setForeground(new Color(25, 25, 112));
		lbAddress.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		
		txfAddress = new JTextField();
		txfAddress.setBounds(245, 213, 185, 25);
		panelEmp.add(txfAddress);
		txfAddress.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfAddress.setForeground(new Color(25, 25, 112));
		txfAddress.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		txfAddress.setColumns(10);
		
		JLabel lbEmpList = new JLabel("EMPLOYEE LIST");
		lbEmpList.setHorizontalAlignment(SwingConstants.CENTER);
		lbEmpList.setForeground(new Color(25, 25, 112));
		lbEmpList.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lbEmpList.setBounds(10, 280, 180, 30);
		add(lbEmpList);
		
		cbFilter = new JComboBox();
		cbFilter.setOpaque(false);
		cbFilter.setModel(new DefaultComboBoxModel(new String[] {"ID", "Name"}));
		cbFilter.setForeground(new Color(25, 25, 112));
		cbFilter.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		cbFilter.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbFilter.setBackground(new Color(245, 255, 250));
		cbFilter.setBounds(265, 285, 80, 20);
		add(cbFilter);
		
		txfFind = new JTextField();
		txfFind.setForeground(new Color(25, 25, 112));
		txfFind.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txfFind.setColumns(10);
		txfFind.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfFind.setBounds(350, 285, 130, 20);
		add(txfFind);
		
		btnFind = new JButton("Find");
		btnFind.setForeground(new Color(25, 25, 112));
		btnFind.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnFind.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnFind.setBackground(new Color(204, 204, 255));
		btnFind.setBounds(490, 285, 60, 20);
		add(btnFind);
		
		lblAvt = new JLabel("");
		lblAvt.setBounds(5, 10, 90, 116);
		lblAvt.setBackground(new Color(245, 255, 250));
		panelEmp.add(lblAvt);
		
		JPanel panelEmpList = new JPanel();
		panelEmpList.setBorder(new LineBorder(new Color(25, 25, 112)));
		panelEmpList.setBackground(new Color(176, 196, 222));
		panelEmpList.setBounds(10, 309, 540, 180);
		add(panelEmpList);
		panelEmpList.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		scrollPane.setBackground(new Color(176, 196, 222));
		scrollPane.setForeground(new Color(25, 25, 112));
		scrollPane.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		scrollPane.setBounds(0, 0, 540, 180);
		panelEmpList.add(scrollPane);
		
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
		
		controller = new NhanVienController(txfID, txfName, txfPhone, txfAddress, txfEmail, txfPasswd, txfFind, txdate, table, cbRole, cbGender, lblAvt, btnUpload, btnAdd, btnEdit, btnDisable, btnCancel, btnSave, cbFilter, btnFind, cbStatus);
	}
	
	public NhanVienController getController() {
		return controller;
	}

	public void setController(NhanVienController controller) {
		this.controller = controller;
	}
}
