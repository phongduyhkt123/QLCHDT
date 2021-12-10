package GUI.Controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAO.KhachHangDao;
import DAO.impl.KhachHangDaoImpl;
import Model.KhachHangModel;
import Ultils.MyUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		setEvent();
		buttonChangeStats(1);
		txfId.setEditable(false);
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
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mode = 1;
				buttonChangeStats(2);
				
				txfName.setText("");
				txfPhone.setText("");
				txfAddress.setText("");
				txfId.setText("");
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mode = 2;
				buttonChangeStats(2);
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonChangeStats(1);
			}
		});
		
		btnFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadTable(find());
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mode == 1) {
					int input = JOptionPane.showConfirmDialog(null, "Do you want to create new customer?");
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
					int input = JOptionPane.showConfirmDialog(null, "Do you want to update this customer infomation?");
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

	private void loadTable(List<KhachHangModel> list) {
		String[] labels= {"ID", "Customer name", "Gener", "Birthday", "Phone", "Address"};
		DefaultTableModel tableModel = new DefaultTableModel(labels, 0) {
			@Override
			public boolean isCellEditable(int row, int column) { 
				return false;
			};
		};
		
		try {
			for (KhachHangModel khachhang : list) {
				Object[] row = {khachhang.getId(), khachhang.getName(), khachhang.getGender(), khachhang.getDob(), 
						khachhang.getPhone(), khachhang.getAddress()};
				tableModel.addRow(row);
			}
			this.table.setModel(tableModel);
		}catch(Exception ex) {
			ex.printStackTrace();
			MyUtils.showErrorMessage("Error", ex.getMessage());
		}
	}
	
	private void loadRow() {
		if (btnSave.isEnabled())
			return;
		
		int row = table.getSelectedRow();
		txfId.setText(table.getValueAt(row, 0).toString());
		txfName.setText(table.getValueAt(row, 1).toString());
		cbGender.setSelectedIndex(table.getValueAt(row, 2).equals("Nam") ? 0: 1);
		txdate.setDate((java.util.Date) table.getValueAt(row, 3));
		txfPhone.setText(table.getValueAt(row, 4).toString());
		txfAddress.setText(table.getValueAt(row, 5).toString());
	}
	
	private void buttonChangeStats(int stat) {
		if (stat == 1) {
			btnAdd.setEnabled(true);
			btnEdit.setEnabled(true);
			btnSave.setEnabled(false);
			btnCancel.setEnabled(false);

			txfName.setEditable(false);
			txfPhone.setEditable(false);
			txfAddress.setEditable(false);
			
			cbGender.setEnabled(false);
		}
		else {
			btnAdd.setEnabled(false);
			btnEdit.setEnabled(false);
			btnSave.setEnabled(true);
			btnCancel.setEnabled(true);
			
			txfName.setEditable(true);
			txfPhone.setEditable(true);
			txfAddress.setEditable(true);
			
			cbGender.setEnabled(true);
		}
	}
	
	private List<KhachHangModel> find() {
		String kw = txfFind.getText();
		if (kw.equals("")) {
			return dao.getAll();
		}
		
		List<KhachHangModel> list = new ArrayList<KhachHangModel>();
		
		if (cbFilter.getSelectedIndex() == 0) {
			KhachHangModel khachhang = dao.getById(Integer.parseInt(kw));
			if ( khachhang != null) {
				list.add(khachhang);
			}
		}
		else if (cbFilter.getSelectedIndex() == 1) {
			list = dao.getByName(kw);
		}
		return list;
	}
}
