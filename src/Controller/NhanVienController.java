package Controller;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAL.NhanVienDao;
import DAL.ImplDao.NhanVienDaoImpl;

import java.awt.Canvas;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import DTO.NhanVienModel;
import Ultils.MyUtils;

public class NhanVienController {
	private JTextField txfID;
	private JTextField txfName;
	private JTextField txfPhone;
	private JTextField txfAddress;
	private JTextField txfEmail;
	private JTextField txfPasswd;
	private JTextField txfFind;
	private JDateChooser txdate;
	private JTable table;
	private JComboBox cbRole;
	private JComboBox cbGender;
	private JLabel lblAvt;
	private JButton btnUpload;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDisable;
	private JButton btnCancel;
	private JButton btnSave;
	private JComboBox cbFilter;
	private JButton btnFind;
	private JComboBox cbStatus;
    private NhanVienDao dao;
    private int mode;
    private byte[] avtImg = null;
    
    public NhanVienController(JTextField txfID, JTextField txfName, JTextField txfPhone, JTextField txfAddress,
			JTextField txfEmail, JTextField txfPasswd, JTextField txfFind, JDateChooser txdate, JTable table,
			JComboBox cbRole, JComboBox cbGender, JLabel lblAvt, JButton btnUpload, JButton btnAdd, JButton btnEdit,
			JButton btnDisable, JButton btnCancel, JButton btnSave, JComboBox cbFilter, JButton btnFind, JComboBox cbStatus) {
		super();
		this.txfID = txfID;
		this.txfName = txfName;
		this.txfPhone = txfPhone;
		this.txfAddress = txfAddress;
		this.txfEmail = txfEmail;
		this.txfPasswd = txfPasswd;
		this.txfFind = txfFind;
		this.txdate = txdate;
		this.table = table;
		this.cbRole = cbRole;
		this.cbGender = cbGender;
		this.lblAvt = lblAvt;
		this.btnUpload = btnUpload;
		this.btnAdd = btnAdd;
		this.btnEdit = btnEdit;
		this.btnDisable = btnDisable;
		this.btnCancel = btnCancel;
		this.btnSave = btnSave;
		this.cbFilter = cbFilter;
		this.btnFind = btnFind;
		this.cbStatus = cbStatus;
		dao = new NhanVienDaoImpl();
		setEvent();
		buttonChangeStats(1);
	}

    public void loadData() {
		loadTable(dao.getAll());
	}
    
	private void setEvent() {	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadRow();
			}
		});
		
		btnUpload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mode = 1;
				buttonChangeStats(2);
			}
		});
		
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mode = 2;
				buttonChangeStats(2);
			}
		});
		
		btnDisable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//		        int input = JOptionPane.showConfirmDialog(null, "Vô hiệu hóa nhân viên này?");
//		        // 0=yes, 1=no, 2=cancel
//		        if (input == 0) {
//		        	
//		        }
//				System.out.print(txdate.getDate().getTime());
			}
		});
		
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buttonChangeStats(1);
			}
		});
		
		btnFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadTable(find());
			}
		});
		
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (mode == 1) {
					int input = JOptionPane.showConfirmDialog(null, "Thêm mới nhân viên?");
					if (input == 0) {
						dao.insert(new NhanVienModel(
								txfName.getText(),
								cbGender.getSelectedIndex() == 0? "Nam": "Nữ",
								new Date(txdate.getDate().getTime()),// dob
								txfPhone.getText(),
								txfAddress.getText(),
								txfEmail.getText(),
								txfPasswd.getText(),
								avtImg,
								cbRole.getSelectedIndex()+1,
								cbStatus.getSelectedIndex() == 0? 1: 0
								));
						loadTable(dao.getAll());
						buttonChangeStats(1);
					}

				}else if (mode == 2) {
					int input = JOptionPane.showConfirmDialog(null, "Chỉnh sửa nhân viên?");
					if (input == 0) {
						dao.update(new NhanVienModel(Integer.parseInt(txfID.getText()),
								txfName.getText(),
								cbGender.getSelectedIndex() == 0? "Nam": "Nữ",
								new Date(txdate.getDate().getTime()),// dob
								txfPhone.getText(),
								txfAddress.getText(),
								txfEmail.getText(),
								txfPasswd.getText(),
								avtImg,
								cbRole.getSelectedIndex()+1,
								cbStatus.getSelectedIndex() == 0? 1: 0
								));
						loadTable(dao.getAll());
						buttonChangeStats(1);
					}
				}	
			}
		});
    }

	private void loadTable(List<NhanVienModel> list) {
		String[] labels= {"ID", "Tên Nhân Viên", "Giới tính", "Ngày sinh", "Điện thoại", "Địa chỉ", "Email", "Chức vụ", "Password", "Trạng thái", "avt"};
		DefaultTableModel tableModel = new DefaultTableModel(labels, 0);
		try {
			for (NhanVienModel nhanvien : list) {
				Object[] row = {nhanvien.getId(), nhanvien.getName(), nhanvien.getGender(), nhanvien.getDob(), 
						nhanvien.getPhone(), nhanvien.getAddress(), nhanvien.getEmail(), nhanvien.getRole() == 1?"Quản lý":"Nhân viên",
						nhanvien.getPassword(), nhanvien.getStatus() == 1?"Enable":"Disable", nhanvien.getAvatar()};
				tableModel.addRow(row);
			}
			this.table.setModel(tableModel);
			this.table.removeColumn(this.table.getColumnModel().getColumn(10));
		}catch(Exception ex) {
			ex.printStackTrace();
			MyUtils.showErrorMessage("Lỗi", ex.getMessage());
		}
	}
	
	private void loadRow() {
		int row = table.getSelectedRow();
		txfID.setText(table.getValueAt(row, 0).toString());
		txfName.setText(table.getValueAt(row, 1).toString());
		cbGender.setSelectedIndex(table.getValueAt(row, 2).equals("Nam") ? 0: 1);
		txdate.setDate((java.util.Date) table.getValueAt(row, 3));
		txfPhone.setText(table.getValueAt(row, 4).toString());
		txfAddress.setText(table.getValueAt(row, 5).toString());
		txfEmail.setText(table.getValueAt(row, 6).toString());
		cbRole.setSelectedIndex(table.getValueAt(row, 7).equals("Quản lý") ? 0: 1);
		txfPasswd.setText(table.getValueAt(row, 8).toString());
		cbStatus.setSelectedIndex(table.getValueAt(row, 9).equals("Enable") ? 0: 1);

		avtImg = null;
		if (((byte[])table.getModel().getValueAt(row, 10)).length > 0) {
			try {
				lblAvt.setIcon(
						new ImageIcon(
								ImageIO.read(
										new ByteArrayInputStream((byte[])table.getModel().getValueAt(row, 10))).getScaledInstance(lblAvt.getWidth(), lblAvt.getHeight(), Image.SCALE_SMOOTH)
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
			btnAdd.setEnabled(true);
			btnEdit.setEnabled(true);
			btnDisable.setEnabled(true);
			btnSave.setEnabled(false);
			btnCancel.setEnabled(false);
			btnUpload.setEnabled(false);
		}else {
			btnAdd.setEnabled(false);
			btnEdit.setEnabled(false);
			btnDisable.setEnabled(false);
			btnSave.setEnabled(true);
			btnCancel.setEnabled(true);
			btnUpload.setEnabled(true);
		}
	}
	
	private List<NhanVienModel> find() {
		String kw = txfFind.getText();
		if (kw.equals("")) {
			return dao.getAll();
		}
		List<NhanVienModel> list = new ArrayList<NhanVienModel>();
		System.out.print(cbFilter.getSelectedIndex());
		if (cbFilter.getSelectedIndex() == 0) {
			NhanVienModel nhanvien = dao.getById(Integer.parseInt(kw));
			if ( nhanvien != null) {
				list.add(nhanvien);
			}
		}else if (cbFilter.getSelectedIndex() == 1) {
			list = dao.getByName(kw);
		}
		return list;
	}
}
