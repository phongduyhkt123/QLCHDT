package GUI.Controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAO.HoaDonChiTietDao;
import DAO.HoaDonDao;
import DAO.KhachHangDao;
import DAO.NhanVienDao;
import DAO.SanPhamDao;
import DAO.impl.HoaDonChiTietDaoImpl;
import DAO.impl.HoaDonDaoImpl;
import DAO.impl.KhachHangDaoImpl;
import DAO.impl.NhanVienDaoImpl;
import DAO.impl.SanPhamDaoImpl;
import Model.HoaDonChiTietModel;
import Model.HoaDonModel;
import Model.KhachHangModel;
import Model.NhanVienModel;
import Ultils.MyUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class HoaDonController {
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
	private JDateChooser dateFind;
	private JComboBox cbFilter;
	private JButton btnFind;
    private KhachHangDao cDao;
    private NhanVienDao eDao;
    private HoaDonDao bDao;
    private SanPhamDao pDao;
    private HoaDonChiTietDao bdDao;
    
    

	public HoaDonController(JTextField txfEmp, JTextField txfCus, JTextField txfPhone, JTextField txfIdBill,
			JDateChooser txdate, JTextField txfTotal, JTable tableHistory, JTextField txfFind, JTable tableDetail,
			JTextField txfIdEmp, HoaDonController controller, JDateChooser dateFind, JComboBox cbFilter,
			JButton btnFind) {
		super();
		this.txfEmp = txfEmp;
		this.txfCus = txfCus;
		this.txfPhone = txfPhone;
		this.txfIdBill = txfIdBill;
		this.txdate = txdate;
		this.txfTotal = txfTotal;
		this.tableHistory = tableHistory;
		this.txfFind = txfFind;
		this.tableDetail = tableDetail;
		this.txfIdEmp = txfIdEmp;
		this.controller = controller;
		this.dateFind = dateFind;
		this.cbFilter = cbFilter;
		this.btnFind = btnFind;
		
		bDao = new HoaDonDaoImpl();
		cDao = new KhachHangDaoImpl();
		pDao = new SanPhamDaoImpl();
		eDao = new NhanVienDaoImpl();
		bdDao = new HoaDonChiTietDaoImpl();
		
		loadData();
		setEvent();
	}

	public void loadData() {
		loadTable(bDao.getAll());
	}

	private void setEvent() {	
		tableHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadRow();
			}
		});
		
//		btnAdd.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				mode = 1;
//				buttonChangeStats(2);
//				
//				txfName.setText("");
//				txfPhone.setText("");
//				txfAddress.setText("");
//				txfId.setText("");
//			}
//		});
//		
//		btnEdit.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				mode = 2;
//				buttonChangeStats(2);
//			}
//		});
//		
//		btnCancel.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				buttonChangeStats(1);
//			}
//		});
//		
		btnFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadTable(find());
			}
		});
//		
//		btnSave.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (mode == 1) {
//					int input = JOptionPane.showConfirmDialog(null, "Do you want to create new customer?");
//					if (input == 0) {
//						dao.insert(new HoaDonModel(
//								txfName.getText(),
//								cbGender.getSelectedIndex() == 0? "Nam": "Nữ",
//								new Date(txdate.getDate().getTime()),// dob
//								txfPhone.getText(),
//								txfAddress.getText()
//								));
//						loadTable(dao.getAll());
//						buttonChangeStats(1);
//					}
//
//				}else if (mode == 2) {
//					int input = JOptionPane.showConfirmDialog(null, "Do you want to update this customer infomation?");
//					if (input == 0) {
//						dao.update(new HoaDonModel(Integer.parseInt(txfId.getText()),
//								txfName.getText(),
//								cbGender.getSelectedIndex() == 0? "Nam": "Nữ",
//								new Date(txdate.getDate().getTime()),// dob
//								txfPhone.getText(),
//								txfAddress.getText()
//								));
//						loadTable(dao.getAll());
//						buttonChangeStats(1);
//					}
//				}	
//			}
//		});
    }

	private void loadTable(List<HoaDonModel> list) {
		String[] labels= {"ID", "ID Customer", "ID Employee", "CreateDate", "Total"};
		DefaultTableModel tableModel = new DefaultTableModel(labels, 0) {
			@Override
			public boolean isCellEditable(int row, int column) { 
				return false;
			};
		};
		
		try {
			for (HoaDonModel hoadon : list) {
				Object[] row = {hoadon.getId(), hoadon.getIdNV(), hoadon.getIdKH(), hoadon.getCreateDate(), hoadon.getTotalPrice()};
				tableModel.addRow(row);
			}
			this.tableHistory.setModel(tableModel);
		}catch(Exception ex) {
			ex.printStackTrace();
			MyUtils.showErrorMessage("Error", ex.getMessage());
		}
	}
	
	private void loadChildTable(List<HoaDonChiTietModel> list) {
		String[] labels= {"ID Bill", "ID Product", "Price", "Quantity"};
		DefaultTableModel tableModel = new DefaultTableModel(labels, 0) {
			@Override
			public boolean isCellEditable(int row, int column) { 
				return false;
			};
		};
		
		try {
			for (HoaDonChiTietModel hdct : list) {
				Object[] row = {hdct.getIdHD(), hdct.getIdSP(), hdct.getPrice(), hdct.getQuantity()};
				tableModel.addRow(row);
			}
			this.tableDetail.setModel(tableModel);
		}catch(Exception ex) {
			ex.printStackTrace();
			MyUtils.showErrorMessage("Error", ex.getMessage());
		}
	}
	
	private void loadRow() {
		int row = tableHistory.getSelectedRow();

		txfIdBill.setText(tableHistory.getValueAt(row, 0).toString());
		txfIdEmp.setText(tableHistory.getValueAt(row, 1).toString());
		txdate.setDate((java.util.Date) tableHistory.getValueAt(row, 3));
		txfTotal.setText(tableHistory.getValueAt(row, 4).toString());
		
		KhachHangModel kh = cDao.getById(Integer.parseInt(tableHistory.getValueAt(row, 2).toString()));
		NhanVienModel nv = eDao.getById(Integer.parseInt(tableHistory.getValueAt(row, 1).toString()));
		
		txfPhone.setText(kh.getPhone());
		txfEmp.setText(nv.getName());
		txfCus.setText(kh.getName());
		
		loadChildTable(bdDao.getByIdBill(Integer.parseInt(txfIdBill.getText())));

	}
	
//	private void buttonChangeStats(int stat) {
//		if (stat == 1) {
//			btnAdd.setEnabled(true);
//			btnEdit.setEnabled(true);
//			btnSave.setEnabled(false);
//			btnCancel.setEnabled(false);
//
//			txfName.setEditable(false);
//			txfPhone.setEditable(false);
//			txfAddress.setEditable(false);
//			
//			cbGender.setEnabled(false);
//		}
//		else {
//			btnAdd.setEnabled(false);
//			btnEdit.setEnabled(false);
//			btnSave.setEnabled(true);
//			btnCancel.setEnabled(true);
//			
//			txfName.setEditable(true);
//			txfPhone.setEditable(true);
//			txfAddress.setEditable(true);
//			
//			cbGender.setEnabled(true);
//		}
//	}
//	
	private List<HoaDonModel> find() {
		String kw = txfFind.getText();
		if (kw.equals("")) {
			return bDao.getAll();
		}
		
		List<HoaDonModel> list = new ArrayList<HoaDonModel>();
		
		if (cbFilter.getSelectedIndex() == 0) {
			HoaDonModel hoadon = bDao.getById(Integer.parseInt(kw));
			if ( hoadon != null) {
				list.add(hoadon);
			}
		}
		else if (cbFilter.getSelectedIndex() == 1) {
			list = bDao.getByIdEmployee(Integer.parseInt(kw));
		}
		return list;
	}
}