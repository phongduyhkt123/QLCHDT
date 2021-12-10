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
import DAL.ImplDao.HoaDonDaoImpl;
import DAL.ImplDao.KhachHangDaoImpl;
import DAL.ImplDao.SanPhamDaoImpl;
import DTO.KhachHangModel;
import DTO.SanPhamModel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class HoaDonChiTietController {
	private JTextField txfPro;
	private JTextField txfPrice;
	private JTextField txfQuantity;
	private JTextField textField_1;
	private JTextField txfPhone;
	private JTextField txfAddress;
	private JButton btnDel;
	private JTable table;
	private JButton btnAdd;
	private JButton btnCancel;
	private JComboBox cbPro;
	private JComboBox cbID;
    private SanPhamDao pDao;
    private KhachHangDao cDao;
    private HoaDonDao bDao;
    private HoaDonChiTietDao bdDao;
    private int mode;

    
    
    
	public HoaDonChiTietController(JTextField txfPro, JTextField txfPrice, JTextField txfQuantity,
			JTextField textField_1, JTextField txfPhone, JTextField txfAddress, JButton btnDel, JTable table,
			JButton btnAdd, JButton btnCancel, JComboBox cbPro, JComboBox cbID) {
		super();
		this.txfPro = txfPro;
		this.txfPrice = txfPrice;
		this.txfQuantity = txfQuantity;
		this.textField_1 = textField_1;
		this.txfPhone = txfPhone;
		this.txfAddress = txfAddress;
		this.btnDel = btnDel;
		this.table = table;
		this.btnAdd = btnAdd;
		this.btnCancel = btnCancel;
		this.cbPro = cbPro;
		this.cbID = cbID;
		
		pDao = new SanPhamDaoImpl();
		cDao = new KhachHangDaoImpl();
		bDao = new HoaDonDaoImpl();
		setEvent();
		buttonChangeStats(1);
	}

	public void setEvent() {
		
		cbID.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				loadCustomerInfo();
			}
		});
		
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				loadRow();
//			}
//		});
//		
//		btnAdd.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				mode = 1;
//				buttonChangeStats(2);
//			}
//		});
//		
//		btnEdit.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				mode = 2;
//				buttonChangeStats(2);
//			}
//		});
//		
//		btnCancel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				buttonChangeStats(1);
//			}
//		});
//		
//		btnFind.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				loadTable(find());
//			}
//		});
//		
//		btnSave.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if (mode == 1) {
//					int input = JOptionPane.showConfirmDialog(null, "Thêm mới sản phẩm?");
//					if (input == 0) {
//						dao.insert(new SanPhamModel(
//								txfName.getText(),
//								Double.parseDouble(txfPrice.getText()),
//								Integer.parseInt(txfQuantity.getText())
//								));
//						loadTable(dao.getAll());
//						buttonChangeStats(1);
//					}
//
//				}else if (mode == 2) {
//					int input = JOptionPane.showConfirmDialog(null, "Chỉnh sửa sản phẩm?");
//					if (input == 0) {
//						dao.update(new SanPhamModel(Integer.parseInt(txfID.getText()),
//								txfName.getText(),
//								Double.parseDouble(txfPrice.getText()),
//								Integer.parseInt(txfQuantity.getText())
//								));
//						loadTable(dao.getAll());
//						buttonChangeStats(1);
//					}
//				}	
//			}
//		});
    }

	public void loadTable(List<SanPhamModel> list) {
		String[] labels= {"ID", "Tên Sản Phẩm ", "Giá", "Số lượng"};
		DefaultTableModel tableModel = new DefaultTableModel(labels, 0);
		try {
			for (SanPhamModel sanpham : list) {
				Object[] row = {sanpham.getId(), sanpham.getName(), sanpham.getPrice(), sanpham.getQuantity()};
				tableModel.addRow(row);
			}
			this.table.setModel(tableModel);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
	
//	public void loadRow() {
//		int row = table.getSelectedRow();
//		txfID.setText(table.getValueAt(row, 0).toString());
//		txfName.setText(table.getValueAt(row, 1).toString());
//		txfPrice.setText(table.getValueAt(row, 2).toString());
//		txfQuantity.setText(table.getValueAt(row, 3).toString());
//	}
	
	public void loadCmbCustomer() {
		List<KhachHangModel> list = cDao.getAll();
		for (KhachHangModel khachhang : list) {
			cbID.addItem(khachhang); // load customer name -- by override toString
		}
	}
	
	public void loadCustomerInfo() {
		KhachHangModel khachhang = (KhachHangModel)cbID.getSelectedItem();
		txfPhone.setText(khachhang.getName());
		txfAddress.setText(khachhang.getPhone());
	}
	
	
	public void buttonChangeStats(int stat) {
		if (stat == 1) {
			btnAdd.setEnabled(true);
//			btnEdit.setEnabled(true);
//			btnSave.setEnabled(false);
			btnCancel.setEnabled(false);
		}else {
			btnAdd.setEnabled(false);
//			btnEdit.setEnabled(false);
//			btnSave.setEnabled(true);
			btnCancel.setEnabled(true);
		}
	}
//	
//	public List<SanPhamModel> find() {
//		String kw = txfFind.getText();
//		if (kw.equals("")) {
//			return dao.getAll();
//		}
//		List<SanPhamModel> list = new ArrayList<SanPhamModel>();
//		System.out.print(cbFilter.getSelectedIndex());
//		if (cbFilter.getSelectedIndex() == 0) {
//			SanPhamModel sanpham = dao.getById(Integer.parseInt(kw));
//			if ( sanpham != null) {
//				list.add(sanpham);
//			}
//		}else if (cbFilter.getSelectedIndex() == 1) {
//			list = dao.getByName(kw);
//		}
//		return list;
//	}
}
