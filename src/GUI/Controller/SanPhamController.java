package GUI.Controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.SanPhamDao;
import DAO.impl.SanPhamDaoImpl;
import Model.SanPhamModel;
import Ultils.MyUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnEdit;
	private JButton btnAdd;
    private SanPhamDao dao;
    private int mode;

	public SanPhamController(JTextField txfID, JTextField txfName, JTextField txfPrice, JTextField txfQuantity,
			JTextField txfFind, JTable table, JButton btnFind, JComboBox cbFilter, JButton btnSave,
			JButton btnCancel, JButton btnEdit, JButton btnAdd) {
		super();
		this.txfID = txfID;
		this.txfName = txfName;
		this.txfPrice = txfPrice;
		this.txfQuantity = txfQuantity;
		this.txfFind = txfFind;
		this.table = table;
		this.btnFind = btnFind;
		this.cbFilter = cbFilter;
		this.btnSave = btnSave;
		this.btnCancel = btnCancel;
		this.btnEdit = btnEdit;
		this.btnAdd = btnAdd;
		dao = new SanPhamDaoImpl();
		setEvent();
		buttonChangeStats(1);
		txfID.setEditable(false);
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
				
				txfID.setText("");
				txfName.setText("");
				txfPrice.setText("");
				txfQuantity.setText("");
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
					int input = JOptionPane.showConfirmDialog(null, "Do you want to create new product?");
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
					int input = JOptionPane.showConfirmDialog(null, "Do you want to update this product's information?");
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

	private void loadTable(List<SanPhamModel> list) {
		String[] labels= {"ID", "Product name ", "Price", "Quantity"};
		DefaultTableModel tableModel = new DefaultTableModel(labels, 0) {
			@Override
			public boolean isCellEditable(int row, int column) { 
				return false;
			};
		};
		try {
			for (SanPhamModel sanpham : list) {
				Object[] row = {sanpham.getId(), sanpham.getName(), sanpham.getPrice(), sanpham.getQuantity()};
				tableModel.addRow(row);
			}
			this.table.setModel(tableModel);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			MyUtils.showErrorMessage("Error", ex.getMessage());
		}
	}
	
	private void loadRow() {
		if (btnSave.isEnabled())
			return;
		
		int row = table.getSelectedRow();
		txfID.setText(table.getValueAt(row, 0).toString());
		txfName.setText(table.getValueAt(row, 1).toString());
		txfPrice.setText(table.getValueAt(row, 2).toString());
		txfQuantity.setText(table.getValueAt(row, 3).toString());
	}
	
	private void buttonChangeStats(int stat) {
		if (stat == 1) {
			btnAdd.setEnabled(true);
			btnEdit.setEnabled(true);
			btnSave.setEnabled(false);
			btnCancel.setEnabled(false);
			
			txfName.setEditable(false);
			txfPrice.setEditable(false);
			txfQuantity.setEditable(false);
		}
		else {
			btnAdd.setEnabled(false);
			btnEdit.setEnabled(false);
			btnSave.setEnabled(true);
			btnCancel.setEnabled(true);
			
			txfName.setEditable(true);
			txfPrice.setEditable(true);
			txfQuantity.setEditable(true);
		}
	}
	
	private List<SanPhamModel> find() {
		String kw = txfFind.getText();
		if (kw.equals("")) {
			return dao.getAll();
		}
		
		List<SanPhamModel> list = new ArrayList<SanPhamModel>();

		if (cbFilter.getSelectedIndex() == 0) {
			SanPhamModel sanpham = dao.getById(Integer.parseInt(kw));
			if ( sanpham != null) {
				list.add(sanpham);
			}
		}
		else if (cbFilter.getSelectedIndex() == 1) {
			list = dao.getByName(kw);
		}
		return list;
	}
}
