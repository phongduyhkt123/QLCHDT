package Controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAL.KhachHangDao;
import DAL.ImplDao.KhachHangDaoImpl;
import DTO.KhachHangModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class KhachHangController {
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
    private KhachHangDao dao;
    private int mode;

	public KhachHangController(JTextField txfName, JTextField txfPhone, JTextField txfAddress, JTextField txfFind,
			JDateChooser txdate, JTextField txfId, JComboBox cbGender, JButton btnAdd, JButton btnEdit,
			JButton btnCancel, JButton btnSave, JComboBox cbFilter, JButton btnFind, JTable table) {
		super();
		this.txfName = txfName;
		this.txfPhone = txfPhone;
		this.txfAddress = txfAddress;
		this.txfFind = txfFind;
		this.txdate = txdate;
		this.txfId = txfId;
		this.cbGender = cbGender;
		this.btnAdd = btnAdd;
		this.btnEdit = btnEdit;
		this.btnCancel = btnCancel;
		this.btnSave = btnSave;
		this.cbFilter = cbFilter;
		this.btnFind = btnFind;
		this.table = table;
		dao = new KhachHangDaoImpl();
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
						dao.insert(new KhachHangModel(
								txfName.getText(),
								cbGender.getSelectedIndex() == 0? "Nam": "Nữ",
								new Date(txdate.getDate().getTime()),// dob
								txfPhone.getText(),
								txfAddress.getText()
								));
						loadTable(dao.getAll());
						buttonChangeStats(1);
					}

				}else if (mode == 2) {
					int input = JOptionPane.showConfirmDialog(null, "Chỉnh sửa khách hàng?");
					if (input == 0) {
						dao.update(new KhachHangModel(Integer.parseInt(txfId.getText()),
								txfName.getText(),
								cbGender.getSelectedIndex() == 0? "Nam": "Nữ",
								new Date(txdate.getDate().getTime()),// dob
								txfPhone.getText(),
								txfAddress.getText()
								));
						loadTable(dao.getAll());
						buttonChangeStats(1);
					}
				}	
			}
		});
    }

	public void loadTable(List<KhachHangModel> list) {
		String[] labels= {"ID", "Tên Khách Hàng", "Giới tính", "Ngày sinh", "Điện thoại", "Địa chỉ"};
		DefaultTableModel tableModel = new DefaultTableModel(labels, 0);
		try {
			for (KhachHangModel khachhang : list) {
				Object[] row = {khachhang.getId(), khachhang.getName(), khachhang.getGender(), khachhang.getDob(), 
						khachhang.getPhone(), khachhang.getAddress()};
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
		txfId.setText(table.getValueAt(row, 0).toString());
		txfName.setText(table.getValueAt(row, 1).toString());
		cbGender.setSelectedIndex(table.getValueAt(row, 2).equals("Nam") ? 0: 1);
		txdate.setDate((java.util.Date) table.getValueAt(row, 3));
		txfPhone.setText(table.getValueAt(row, 4).toString());
		txfAddress.setText(table.getValueAt(row, 5).toString());

	}
	
	public void buttonChangeStats(int stat) {
		if (stat == 1) {
			btnAdd.setEnabled(true);
			btnEdit.setEnabled(true);
			btnSave.setEnabled(false);
			btnCancel.setEnabled(false);
		}else {
			btnAdd.setEnabled(false);
			btnEdit.setEnabled(false);
			btnSave.setEnabled(true);
			btnCancel.setEnabled(true);
		}
	}
	
	public List<KhachHangModel> find() {
		String kw = txfFind.getText();
		if (kw.equals("")) {
			return dao.getAll();
		}
		List<KhachHangModel> list = new ArrayList<KhachHangModel>();
		System.out.print(cbFilter.getSelectedIndex());
		if (cbFilter.getSelectedIndex() == 0) {
			KhachHangModel khachhang = dao.getById(Integer.parseInt(kw));
			if ( khachhang != null) {
				list.add(khachhang);
			}
		}else if (cbFilter.getSelectedIndex() == 1) {
			list = dao.getByName(kw);
		}
		return list;
	}
}
