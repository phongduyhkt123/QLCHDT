package GUI.Controller;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAO.NhanVienDao;
import DAO.impl.NhanVienDaoImpl;
import Model.NhanVienModel;

import java.awt.Canvas;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import Ultils.MyUtils;

public class ProfileController {
	private int userId;
	private JTextField txfID;
	private JTextField txfName;
	private JTextField txfPhone;
	private JTextField txfAddress;
	private JTextField txfEmail;
	private JDateChooser txdate;
	private JComboBox cbRole;
	private JComboBox cbGender;
	private JButton btnUpload;
	private JButton btnEdit;
	private JButton btnCancel;
	private JButton btnSave;
	private JComboBox cbStatus;
	private JPasswordField psfConfirmPw;
	private JPasswordField psfNewPw;
	private JPasswordField psfOldPw;
	private JLabel lblAvt;
	private JButton btnChangePw;
	private JButton btnCancelPw;
	private JButton btnSavePw;
    private NhanVienDao dao;
    private byte[] avtImg = null;

	public ProfileController(int userId, JTextField txfID, JTextField txfName, JTextField txfPhone,
			JTextField txfAddress, JTextField txfEmail, JDateChooser txdate, JComboBox cbRole, JComboBox cbGender,
			JButton btnUpload, JButton btnEdit, JButton btnCancel, JButton btnSave, JComboBox cbStatus,
			JPasswordField psfConfirmPw, JPasswordField psfNewPw, JPasswordField psfOldPw, JLabel lblAvt,
			JButton btnChangePw, JButton btnCancelPw, JButton btnSavePw, byte[] avtImg) {
		super();
		this.userId = userId;
		this.txfID = txfID;
		this.txfName = txfName;
		this.txfPhone = txfPhone;
		this.txfAddress = txfAddress;
		this.txfEmail = txfEmail;
		this.txdate = txdate;
		this.cbRole = cbRole;
		this.cbGender = cbGender;
		this.btnUpload = btnUpload;
		this.btnEdit = btnEdit;
		this.btnCancel = btnCancel;
		this.btnSave = btnSave;
		this.cbStatus = cbStatus;
		this.psfConfirmPw = psfConfirmPw;
		this.psfNewPw = psfNewPw;
		this.psfOldPw = psfOldPw;
		this.lblAvt = lblAvt;
		this.btnChangePw = btnChangePw;
		this.btnCancelPw = btnCancelPw;
		this.btnSavePw = btnSavePw;
		this.avtImg = avtImg;
		
		txfID.setEditable(false);
		dao = new NhanVienDaoImpl();
		setEvent();
		loadEmployee();
		buttonChangeStats(1);
	}

	private void setEvent() {		
		btnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
		                "Images", "jpg", "gif", "png");
				chooser.setFileFilter(filter);
		        int returnVal = chooser.showOpenDialog(null);
		        
		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		        	try {
						avtImg = Files.readAllBytes(Paths.get(chooser.getSelectedFile().getAbsolutePath()));
						lblAvt.setIcon(
								new ImageIcon(
										ImageIO.read(
												new ByteArrayInputStream(avtImg)).getScaledInstance(lblAvt.getWidth(), lblAvt.getHeight(), Image.SCALE_SMOOTH)
										)
								);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		        }
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					int input = JOptionPane.showConfirmDialog(null, "Do you want to update your information?");
					if (input == 0) {
						NhanVienModel nhanvien = dao.getById(userId);
						dao.update(new NhanVienModel(Integer.parseInt(txfID.getText()),
								txfName.getText(),
								cbGender.getSelectedIndex() == 0? "Male": "Female",
								new Date(txdate.getDate().getTime()),// dob
								txfPhone.getText(),
								txfAddress.getText(),
								txfEmail.getText(),
								nhanvien.getPassword(),
								avtImg == null ? new byte[0] : avtImg,
								cbRole.getSelectedIndex()+1,
								cbStatus.getSelectedIndex() == 0? 1: 0
								));
					}
				}	
		});
	}
	
	private void loadEmployee() {
		NhanVienModel nhanvien = dao.getById(userId);
		
		txfID.setText(String.valueOf(nhanvien.getId()));
		txfName.setText(nhanvien.getName());
		cbGender.setSelectedIndex(nhanvien.getGender().equals("Male") ? 0: 1);
		txdate.setDate((java.util.Date)nhanvien.getDob());
		txfPhone.setText(nhanvien.getPhone());
		txfAddress.setText(nhanvien.getAddress());
		txfEmail.setText(nhanvien.getEmail());
		cbRole.setSelectedIndex(nhanvien.getRole() - 1);
		cbStatus.setSelectedIndex(nhanvien.getStatus() == 1 ? 0: 1);

		avtImg = null;
		if (nhanvien.getAvatar().length > 0) {
			try {
				lblAvt.setIcon(
						new ImageIcon(
								ImageIO.read(
										new ByteArrayInputStream(nhanvien.getAvatar())).getScaledInstance(lblAvt.getWidth(), lblAvt.getHeight(), Image.SCALE_SMOOTH)
								)
						);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			lblAvt.setIcon(null);
		}
	}
	
	private void buttonChangeStats(int stat) {
		if (stat == 1) {
			btnEdit.setEnabled(true);
			btnSave.setEnabled(false);
			btnCancel.setEnabled(false);
			btnUpload.setEnabled(false);
			
			txfName.setEditable(false);
			txfPhone.setEditable(false);
			txfAddress.setEditable(false);
			txfEmail.setEditable(false);
			txdate.setEnabled(false);
			
			cbStatus.setEnabled(false);
			cbRole.setEnabled(false);
			cbGender.setEnabled(false);
		}
		else {
			btnEdit.setEnabled(false);
			btnSave.setEnabled(true);
			btnCancel.setEnabled(true);
			btnUpload.setEnabled(true);
			
			txfName.setEditable(true);
			txfPhone.setEditable(true);
			txfAddress.setEditable(true);
			txfEmail.setEditable(true);
			txdate.setEnabled(true);
			
			cbStatus.setEnabled(true);
			cbRole.setEnabled(true);
			cbGender.setEnabled(true);
		}
	}
}
