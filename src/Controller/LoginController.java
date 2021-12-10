package Controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import DAL.NhanVienDao;
import DAL.ImplDao.NhanVienDaoImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.NhanVienModel;

public class LoginController {
	private JTextField txfUsername;
	private JPasswordField passwordField;
	private JRadioButton rdbtnEmployee;
	private JRadioButton rdbtnManage;
	private JButton btnLogIn;
    private NhanVienDao dao;

    public LoginController(JTextField txfUsername, JPasswordField passwordField, JRadioButton rdbtnEmployee,
			JRadioButton rdbtnManage, JButton btnLogIn) {
		super();
		this.txfUsername = txfUsername;
		this.passwordField = passwordField;
		this.rdbtnEmployee = rdbtnEmployee;
		this.rdbtnManage = rdbtnManage;
		this.btnLogIn = btnLogIn;
		
		dao = new NhanVienDaoImpl();
	}

	public void setEvent() {	
		btnLogIn.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			try {
    				NhanVienModel nhanvien = dao.login(txfUsername.getText(), passwordField.getText());
    				if(nhanvien != null) {
    					if(nhanvien.getStatus() == 1) {
	    					if(rdbtnManage.isSelected() && nhanvien.getRole() == 1) {
	    						JOptionPane.showMessageDialog(null, "Bạn là quản lý!");
	    					}else if (rdbtnEmployee.isSelected() && nhanvien.getRole() == 0) {
	    						JOptionPane.showMessageDialog(null, "Bạn là nhân viên!");
	    					}else {
	    						JOptionPane.showMessageDialog(null, "Thông tin không phù hợp!");
	    					}
    					}else {
    						JOptionPane.showMessageDialog(null, "Tài khoản bị vô hiệu hóa!");
    					}
    				}else {
    					JOptionPane.showMessageDialog(null, "Sai thông tin đăng nhập!");
    					JOptionPane.showMessageDialog(null, " ádfsdafdsa" , "Lỗi", JOptionPane.ERROR_MESSAGE);
    				}
    			}catch(Exception ex) {
    				ex.printStackTrace();
    				JOptionPane.showMessageDialog(null, "Có lỗi xảy ra. Vui lòng thử lai!");
    			}
    		}
    	});
    }
}
