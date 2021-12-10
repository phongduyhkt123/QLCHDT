package GUI;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Canvas;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class profile extends JPanel {	
	private static final long serialVersionUID = 1L;
	private JTextField txfID;
	private JTextField txfName;
	private JTextField txfPhone;
	private JTextField txfAddress;
	private JTextField txfEmail;
	private JDateChooser txdate;
	private JComboBox cbRole;
	private JComboBox cbGender;
	private Canvas canvasAvt;
	private JButton btnUpload;
	private JButton btnEdit;
	private JButton btnCancel;
	private JButton btnSave;
	private JComboBox cbStatus;
	private JPasswordField psfConfirmPw;
	private JPasswordField psfNewPw;
	private JPasswordField psfOldPw;
	
	public profile() {
		setOpaque(false);
		setBorder(new LineBorder(new Color(25, 25, 112)));
		setBackground(new Color(235, 255, 250));
		setLayout(null);
		setVisible(true);
		JLabel lbProfile = new JLabel("PROFILE");
		lbProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lbProfile.setForeground(new Color(25, 25, 112));
		lbProfile.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lbProfile.setBounds(198, 0, 163, 30);
		add(lbProfile);
		
		JPanel panelEmp = new JPanel();
		panelEmp.setBorder(new LineBorder(new Color(25, 25, 112)));
		panelEmp.setBackground(new Color(176, 196, 222));
		panelEmp.setBounds(10, 30, 540, 250);
		add(panelEmp);
		panelEmp.setLayout(null);
		
		JLabel lbID = new JLabel("ID");
		lbID.setForeground(new Color(25, 25, 112));
		lbID.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lbID.setBounds(105, 10, 100, 30);
		panelEmp.add(lbID);
		
		txfID = new JTextField();
		txfID.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfID.setForeground(new Color(25, 25, 112));
		txfID.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txfID.setBounds(165, 13, 80, 25);
		panelEmp.add(txfID);
		txfID.setColumns(10);
		
		JLabel lbRole = new JLabel("Role");
		lbRole.setBounds(255, 10, 58, 30);
		panelEmp.add(lbRole);
		lbRole.setForeground(new Color(25, 25, 112));
		lbRole.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		
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
		lbName.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lbName.setBounds(105, 50, 100, 30);
		panelEmp.add(lbName);
		
		txfName = new JTextField();
		txfName.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfName.setForeground(new Color(25, 25, 112));
		txfName.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txfName.setColumns(10);
		txfName.setBounds(165, 53, 265, 25);
		panelEmp.add(txfName);
		
		JLabel lbGender = new JLabel("Gender");
		lbGender.setBounds(105, 91, 58, 30);
		panelEmp.add(lbGender);
		lbGender.setForeground(new Color(25, 25, 112));
		lbGender.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		
		cbGender = new JComboBox();
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cbGender.setBounds(165, 94, 80, 25);
		panelEmp.add(cbGender);
		cbGender.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbGender.setBackground(new Color(245, 255, 250));
		cbGender.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		cbGender.setForeground(new Color(25, 25, 112));
		
		JLabel lbDob = new JLabel("DOB");
		lbDob.setBounds(255, 91, 58, 30);
		panelEmp.add(lbDob);
		lbDob.setForeground(new Color(25, 25, 112));
		lbDob.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		
		txdate = new JDateChooser();
		txdate.setBounds(310, 94, 120, 25);
		panelEmp.add(txdate);
		txdate.setForeground(new Color(25, 25, 112));
		txdate.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txdate.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txdate.setBackground(new Color(245, 255, 250));
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setForeground(new Color(25, 25, 112));
		lbEmail.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lbEmail.setBounds(105, 130, 51, 30);
		panelEmp.add(lbEmail);
		
		txfEmail = new JTextField();
		txfEmail.setForeground(new Color(25, 25, 112));
		txfEmail.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txfEmail.setColumns(10);
		txfEmail.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfEmail.setBounds(165, 133, 360, 25);
		panelEmp.add(txfEmail);
		
		JLabel lbPhone = new JLabel("Phone");
		lbPhone.setBounds(105, 170, 80, 30);
		panelEmp.add(lbPhone);
		lbPhone.setForeground(new Color(25, 25, 112));
		lbPhone.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		
		txfPhone = new JTextField();
		txfPhone.setBounds(165, 173, 360, 25);
		panelEmp.add(txfPhone);
		txfPhone.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfPhone.setForeground(new Color(25, 25, 112));
		txfPhone.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txfPhone.setColumns(10);
		
		JLabel lbAddress = new JLabel("Address");
		lbAddress.setBounds(105, 210, 70, 30);
		panelEmp.add(lbAddress);
		lbAddress.setForeground(new Color(25, 25, 112));
		lbAddress.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		
		txfAddress = new JTextField();
		txfAddress.setBounds(165, 213, 195, 25);
		panelEmp.add(txfAddress);
		txfAddress.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		txfAddress.setForeground(new Color(25, 25, 112));
		txfAddress.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		txfAddress.setColumns(10);
		
		canvasAvt = new Canvas();
		canvasAvt.setBounds(5, 10, 90, 116);
		panelEmp.add(canvasAvt);
		canvasAvt.setBackground(new Color(245, 255, 250));
		
		btnUpload = new JButton("Upload");
		btnUpload.setBounds(5, 130, 90, 30);
		panelEmp.add(btnUpload);
		btnUpload.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUpload.setForeground(new Color(25, 25, 112));
		btnUpload.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnUpload.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnUpload.setBackground(new Color(204, 204, 255));
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(440, 10, 90, 30);
		panelEmp.add(btnEdit);
		btnEdit.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnEdit.setBackground(new Color(204, 204, 255));
		btnEdit.setForeground(new Color(25, 25, 112));
		btnEdit.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(440, 51, 90, 30);
		panelEmp.add(btnCancel);
		btnCancel.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnCancel.setBackground(new Color(204, 204, 255));
		btnCancel.setForeground(new Color(25, 25, 112));
		btnCancel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		
		btnSave = new JButton("Save");
		btnSave.setBounds(440, 91, 90, 30);
		panelEmp.add(btnSave);
		btnSave.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnSave.setBackground(new Color(204, 204, 255));
		btnSave.setForeground(new Color(25, 25, 112));
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		
		JLabel lbStatus = new JLabel("Status");
		lbStatus.setBounds(370, 209, 57, 30);
		panelEmp.add(lbStatus);
		lbStatus.setForeground(new Color(25, 25, 112));
		lbStatus.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		
		cbStatus = new JComboBox();
		cbStatus.setBounds(425, 212, 100, 25);
		panelEmp.add(cbStatus);
		cbStatus.setModel(new DefaultComboBoxModel(new String[] {"Enable", "Disable"}));
		cbStatus.setForeground(new Color(25, 25, 112));
		cbStatus.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		cbStatus.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbStatus.setBackground(new Color(245, 255, 250));
		
		JLabel lbChangePw = new JLabel("CHANGE PASSWORD");
		lbChangePw.setHorizontalAlignment(SwingConstants.CENTER);
		lbChangePw.setForeground(new Color(25, 25, 112));
		lbChangePw.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lbChangePw.setBounds(165, 290, 230, 30);
		add(lbChangePw);
		
		JPanel panelEmpList = new JPanel();
		panelEmpList.setBorder(new LineBorder(new Color(25, 25, 112)));
		panelEmpList.setBackground(new Color(176, 196, 222));
		panelEmpList.setBounds(10, 331, 540, 160);
		add(panelEmpList);
		panelEmpList.setLayout(null);
		
		JLabel lbOldPw = new JLabel("Old Password");
		lbOldPw.setForeground(new Color(25, 25, 112));
		lbOldPw.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lbOldPw.setBounds(10, 25, 110, 30);
		panelEmpList.add(lbOldPw);
		
		psfOldPw = new JPasswordField();
		psfOldPw.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		psfOldPw.setBounds(130, 28, 285, 25);
		panelEmpList.add(psfOldPw);
		
		JLabel lbNewPw = new JLabel("New Password");
		lbNewPw.setForeground(new Color(25, 25, 112));
		lbNewPw.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lbNewPw.setBounds(10, 65, 110, 30);
		panelEmpList.add(lbNewPw);
		
		psfNewPw = new JPasswordField();
		psfNewPw.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		psfNewPw.setBounds(130, 68, 285, 25);
		panelEmpList.add(psfNewPw);
		
		JLabel lbConfirmPw = new JLabel("Confirm Password");
		lbConfirmPw.setForeground(new Color(25, 25, 112));
		lbConfirmPw.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lbConfirmPw.setBounds(10, 105, 124, 30);
		panelEmpList.add(lbConfirmPw);
		
		psfConfirmPw = new JPasswordField();
		psfConfirmPw.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		psfConfirmPw.setBounds(130, 108, 285, 25);
		panelEmpList.add(psfConfirmPw);
		
		JButton btnChangePw = new JButton("Change password");
		btnChangePw.setForeground(new Color(25, 25, 112));
		btnChangePw.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnChangePw.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnChangePw.setBackground(new Color(204, 204, 255));
		btnChangePw.setBounds(425, 25, 105, 30);
		panelEmpList.add(btnChangePw);
		
		JButton btnCancelPw = new JButton("Cancel");
		btnCancelPw.setForeground(new Color(25, 25, 112));
		btnCancelPw.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnCancelPw.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnCancelPw.setBackground(new Color(204, 204, 255));
		btnCancelPw.setBounds(425, 65, 105, 30);
		panelEmpList.add(btnCancelPw);
		
		JButton btnSavePw = new JButton("Save");
		btnSavePw.setBounds(425, 105, 105, 30);
		panelEmpList.add(btnSavePw);
		btnSavePw.setForeground(new Color(25, 25, 112));
		btnSavePw.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnSavePw.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnSavePw.setBackground(new Color(204, 204, 255));
	}
}
