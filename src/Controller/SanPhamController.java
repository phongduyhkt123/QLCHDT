package Controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAL.SanPhamDao;
import DAL.ImplDao.SanPhamDaoImpl;
import DTO.SanPhamModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class SanPhamController {
	private JTextField txfID;
	private JTextField txfName;
	private JTextField txfPrice;
	private JTextField txfQuantity;
	private JTextField txfFind;
	private JTable table;
	private JButton btnFind;
	private JComboBox cbFilter;
	private JComboBox cbID;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnDisable;
	private JButton btnEdit;
	private JButton btnAdd;
    private SanPhamDao dao;
    private int mode;

	public SanPhamController(JTextField txfID, JTextField txfName, JTextField txfPrice, JTextField txfQuantity,
			JTextField txfFind, JTable table, JButton btnFind, JComboBox cbFilter, JComboBox cbID, JButton btnSave,
			JButton btnCancel, JButton btnDisable, JButton btnEdit, JButton btnAdd) {
		super();
		this.txfID = txfID;
		this.txfName = txfName;
		this.txfPrice = txfPrice;
		this.txfQuantity = txfQuantity;
		this.txfFind = txfFind;
		this.table = table;
		this.btnFind = btnFind;
		this.cbFilter = cbFilter;
		this.cbID = cbID;
		this.btnSave = btnSave;
		this.btnCancel = btnCancel;
		this.btnDisable = btnDisable;
		this.btnEdit = btnEdit;
		this.btnAdd = btnAdd;
		dao = new SanPhamDaoImpl();
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
					int input = JOptionPane.showConfirmDialog(null, "Thêm mới sản phẩm?");
					if (input == 0) {
						dao.insert(new SanPhamModel(
								txfName.getText(),
								Double.parseDouble(txfPrice.getText()),
								Integer.parseInt(txfQuantity.getText())
								));
						loadTable(dao.getAll());
						buttonChangeStats(1);
					}

				}else if (mode == 2) {
					int input = JOptionPane.showConfirmDialog(null, "Chỉnh sửa sản phẩm?");
					if (input == 0) {
						dao.update(new SanPhamModel(Integer.parseInt(txfID.getText()),
								txfName.getText(),
								Double.parseDouble(txfPrice.getText()),
								Integer.parseInt(txfQuantity.getText())
								));
						loadTable(dao.getAll());
						buttonChangeStats(1);
					}
				}	
			}
		});
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
	
	public void loadRow() {
		int row = table.getSelectedRow();
		txfID.setText(table.getValueAt(row, 0).toString());
		txfName.setText(table.getValueAt(row, 1).toString());
		txfPrice.setText(table.getValueAt(row, 2).toString());
		txfQuantity.setText(table.getValueAt(row, 3).toString());
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
	
	public List<SanPhamModel> find() {
		String kw = txfFind.getText();
		if (kw.equals("")) {
			return dao.getAll();
		}
		List<SanPhamModel> list = new ArrayList<SanPhamModel>();
		System.out.print(cbFilter.getSelectedIndex());
		if (cbFilter.getSelectedIndex() == 0) {
			SanPhamModel sanpham = dao.getById(Integer.parseInt(kw));
			if ( sanpham != null) {
				list.add(sanpham);
			}
		}else if (cbFilter.getSelectedIndex() == 1) {
			list = dao.getByName(kw);
		}
		return list;
	}
}
