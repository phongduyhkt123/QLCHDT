package Controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAL.HoaDonChiTietDao;
import DAL.HoaDonDao;
import DAL.KhachHangDao;
import DAL.SanPhamDao;
import DAL.ImplDao.HoaDonChiTietDaoImpl;
import DAL.ImplDao.HoaDonDaoImpl;
import DAL.ImplDao.KhachHangDaoImpl;
import DAL.ImplDao.SanPhamDaoImpl;
import DTO.HoaDonChiTietModel;
import DTO.HoaDonModel;
import DTO.KhachHangModel;
import DTO.SanPhamModel;
import Ultils.MyUtils;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class HoaDonChiTietController {
	private JTextField txfPro;
	private JTextField txfPrice;
	private JTextField txfQuantity;
	private JTextField txfCus;
	private JTextField txfPhone;
	private JTextField txfAddress;
	private JTextField txfTotal;
	private JTable table;
	private JComboBox cbCus;
	private JComboBox cbPro;
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnPay;
	private JButton btnDel;
    private SanPhamDao pDao;
    private KhachHangDao cDao;
    private HoaDonDao bDao;
    private HoaDonChiTietDao bdDao;
    
	public HoaDonChiTietController(JTextField txfPro, JTextField txfPrice, JTextField txfQuantity, JTextField txfCus,
			JTextField txfPhone, JTextField txfAddress, JTextField txfTotal, JTable table, JComboBox cbCus,
			JComboBox cbPro, JButton btnAdd, JButton btnCancel, JButton btnPay, JButton btnDel) {
		super();
		this.txfPro = txfPro;
		this.txfPrice = txfPrice;
		this.txfQuantity = txfQuantity;
		this.txfCus = txfCus;
		this.txfPhone = txfPhone;
		this.txfAddress = txfAddress;
		this.txfTotal = txfTotal;
		this.table = table;
		this.cbCus = cbCus;
		this.cbPro = cbPro;
		this.btnAdd = btnAdd;
		this.btnCancel = btnCancel;
		this.btnPay = btnPay;
		this.btnDel = btnDel;

		pDao = new SanPhamDaoImpl();
		cDao = new KhachHangDaoImpl();
		bDao = new HoaDonDaoImpl();
		bdDao = new HoaDonChiTietDaoImpl();
		setEvent();
		loadCmbCustomer();
		loadCmbProduct();
		buttonChangeStats(1);
	}

	private void setEvent() {
		
		cbCus.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				loadCustomerInfo();
			}
		});
		
		cbPro.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				loadProductInfo();
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDel.setEnabled(true);
			}
		});
		
		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.removeRow(row);
				table.setModel(tableModel);
			}
		});
		
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearTable();
			}
		});
		
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addToTable();
//				buttonChangeStats(2);
			}
		});
		
		btnPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createBill();
//				buttonChangeStats(2);
			}
		});
    }

	private void loadCmbCustomer() {
		List<KhachHangModel> list = cDao.getAll();
		for (KhachHangModel khachhang : list) {
			cbCus.addItem(khachhang); // load customer name -- by override toString
		}
	}
	
	private void loadCmbProduct() {
		List<SanPhamModel> list = pDao.getAll();
		for (SanPhamModel sanpham : list) {
			cbPro.addItem(sanpham);
		}
	}
	
	private void loadCustomerInfo() {
		KhachHangModel khachhang = (KhachHangModel)cbCus.getSelectedItem();
		txfPhone.setText(khachhang.getPhone());
		txfAddress.setText(khachhang.getAddress());
	}
	
	private void loadProductInfo() {
		SanPhamModel sanpham = (SanPhamModel)cbPro.getSelectedItem();
		txfPrice.setText(String.valueOf(sanpham.getPrice()));
//		txfQuantity.setText(String.valueOf(sanpham.getQuantity()));
	}
	
	private void addToTable() {
//		String[] labels= {"Tên Sản Phẩm ", "Giá", "Số lượng"};
		
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		try {
			SanPhamModel sanpham = ((SanPhamModel)cbPro.getSelectedItem());
			String name = sanpham.getName();
			int quantity = Integer.parseInt(txfQuantity.getText());
			if (quantity < 1) {
				MyUtils.showErrorMessage("Error", "Invalid quantity!");
				return;
			}
			if (quantity > sanpham.getQuantity()) {
				MyUtils.showErrorMessage("Error", "Not enought quantity! Maximum: " + String.valueOf(sanpham.getQuantity()));
				return;
			}
			boolean exist = false;
			for (int i =0; i< tableModel.getRowCount(); i++) {
				if(tableModel.getValueAt(i, 1).equals(name)) {
					int choose = JOptionPane.showConfirmDialog(null, "Sản phẩm này đã được chọn. Bạn có muốn cập nhật lại số lượng không?", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					if (choose == 0) {
						tableModel.setValueAt(quantity, i, 3);
					}
					exist = true;
				}
			}
			if(!exist) {
				Object[] row = {((SanPhamModel)cbPro.getSelectedItem()).getId(), name, txfPrice.getText(), quantity};
				tableModel.addRow(row);
			}
			this.table.setModel(tableModel);
			showTotalPrice();
		} catch(Exception ex) {
			ex.printStackTrace();
			MyUtils.showErrorMessage("Error", ex.getMessage());
		}
	}
	
	private void showTotalPrice() {
		try {
			DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
			double total = 0;
			for (int i =0; i< tableModel.getRowCount(); i++) {
				total += Double.parseDouble(tableModel.getValueAt(i, 2).toString()) 
						* Double.parseDouble(tableModel.getValueAt(i, 3).toString());
			}
			txfTotal.setText(String.valueOf(total));
		}catch(Exception ex) {
			ex.printStackTrace();
			MyUtils.showErrorMessage("Lỗi", ex.getMessage());
		}
		
	}
	
	private void createBill() {
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		try {
			int id = bDao.insert(new HoaDonModel(new Date(new java.util.Date().getTime()),
					Double.parseDouble(txfTotal.getText()),
					1, //id nhan vien
					((KhachHangModel)cbCus.getSelectedItem()).getId() // id khach hang
					));
			if (id == -1) {
				MyUtils.showErrorMessage("Lỗi", "Có lỗi xảy ra vui lòng thử lại!");
				return;
			}
			for (int i =0; i< tableModel.getRowCount(); i++) {
				int idSp = Integer.parseInt(tableModel.getValueAt(i, 0).toString());
				double price = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
				int quantity = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
				bdDao.insert(new HoaDonChiTietModel(id,
													idSp,
													price,
													quantity
													));
				pDao.changeQuantity(idSp, quantity);
			}
			loadCmbProduct();
			clearTable();
			MyUtils.showInfoMessage("Thông báo", "Tạo hóa đơn thành công!");
		}catch(Exception ex) {
			MyUtils.showErrorMessage("Lỗi", ex.getMessage());
		}
	}
	
	private void buttonChangeStats(int stat) {
		if (stat == 1) {
			btnAdd.setEnabled(true);
			btnDel.setEnabled(false);
//			btnEdit.setEnabled(true);
//			btnSave.setEnabled(false);
//			btnCancel.setEnabled(false);
		}else {
//			btnAdd.setEnabled(false);
//			btnEdit.setEnabled(false);
//			btnSave.setEnabled(true);
//			btnCancel.setEnabled(true);
		}
	}
	
	public void clearTable() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		for(int i =0; i< tableModel.getRowCount(); i++) {
			tableModel.removeRow(i);
		}
		table.setModel(tableModel);
	}
	
}
