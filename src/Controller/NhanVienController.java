package Controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAL.NhanVienDao;
import DAL.ImplDao.NhanVienDaoImpl;

import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DTO.NhanVienModel;

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
	private Canvas canvasAvt;
	private JButton btnUpload;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDisable;
	private JButton btnCancel;
	private JButton btnSave;
	private JComboBox cbFilter;
	private JButton btnFind;
    private NhanVienDao dao;
    private int mode;
    
    
    
    public NhanVienController(JTextField txfID, JTextField txfName, JTextField txfPhone, JTextField txfAddress,
			JTextField txfEmail, JTextField txfPasswd, JTextField txfFind, JDateChooser txdate, JTable table,
			JComboBox cbRole, JComboBox cbGender, Canvas canvasAvt, JButton btnUpload, JButton btnAdd, JButton btnEdit,
			JButton btnDisable, JButton btnCancel, JButton btnSave, JComboBox cbFilter, JButton btnFind) {
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
		this.canvasAvt = canvasAvt;
		this.btnUpload = btnUpload;
		this.btnAdd = btnAdd;
		this.btnEdit = btnEdit;
		this.btnDisable = btnDisable;
		this.btnCancel = btnCancel;
		this.btnSave = btnSave;
		this.cbFilter = cbFilter;
		this.btnFind = btnFind;
		dao = new NhanVienDaoImpl();
		loadTable(dao.getAll());
		setEvent();
	}

	public void setEvent() {	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadRow();
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
								null,
								cbRole.getSelectedIndex()+1
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
								null,
								cbRole.getSelectedIndex()+1
								));
						loadTable(dao.getAll());
						buttonChangeStats(1);
					}
				}	
			}
		});
    }

	public void loadTable(List<NhanVienModel> list) {
		String[] labels= {"ID", "Tên Nhân Viên", "Giới tính", "Ngày sinh", "Điện thoại", "Địa chỉ", "Email", "Chức vụ", "Password", "Avatar"};
		DefaultTableModel tableModel = new DefaultTableModel(labels, 0);
		try {
			for (NhanVienModel nhanvien : list) {
				Object[] row = {nhanvien.getId(), nhanvien.getName(), nhanvien.getGender(), nhanvien.getDob(), 
						nhanvien.getPhone(), nhanvien.getAddress(), nhanvien.getEmail(), nhanvien.getRole() == 1?"Quản lý":"Nhân viên",
						nhanvien.getPassword(), nhanvien.getAvatar()};
				tableModel.addRow(row);
			}
			this.table.setModel(tableModel);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void loadRow() {
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

	}
	
	public void buttonChangeStats(int stat) {
		if (stat == 1) {
			btnAdd.setEnabled(true);
			btnEdit.setEnabled(true);
			btnDisable.setEnabled(true);
			btnSave.setEnabled(false);
			btnCancel.setEnabled(false);
		}else {
			btnAdd.setEnabled(false);
			btnEdit.setEnabled(false);
			btnDisable.setEnabled(false);
			btnSave.setEnabled(true);
			btnCancel.setEnabled(true);
		}
	}
	
	public List<NhanVienModel> find() {
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
