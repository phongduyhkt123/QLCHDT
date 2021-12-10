package Controller;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import DAL.NhanVienDao;
import DAL.ImplDao.NhanVienDaoImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import DTO.NhanVienModel;
import GUI.formAdmin;
import GUI.formEmployee;
import GUI.formLogin;
import Ultils.MyUtils;

public class LoginController {
	private formLogin form;
	private JTextField txfUsername;
	private JPasswordField passwordField;
	private JRadioButton rdbtnEmployee;
	private JRadioButton rdbtnManage;
	private JButton btnLogIn;
    private NhanVienDao dao;

    public LoginController(formLogin form, JTextField txfUsername, JPasswordField passwordField, JRadioButton rdbtnEmployee,
			JRadioButton rdbtnManage, JButton btnLogIn) {
    	this.form = form;
		this.txfUsername = txfUsername;
		this.passwordField = passwordField;
		this.rdbtnEmployee = rdbtnEmployee;
		this.rdbtnManage = rdbtnManage;
		this.btnLogIn = btnLogIn;
		setEvent();
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
	    					if (rdbtnManage.isSelected() && nhanvien.getRole() == 1) {
	    						new formAdmin().addWindowListener(new java.awt.event.WindowAdapter() {
	    					        @Override
	    					        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
	    					        	form.setVisible(true);
	    					        }
	    					    });
	    						form.setVisible(false);
	    					} else if (rdbtnEmployee.isSelected() && nhanvien.getRole() == 2) {
	    						new formEmployee().addWindowListener(new java.awt.event.WindowAdapter() {
	    					        @Override
	    					        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
	    					        	form.setVisible(true);
	    					        }
	    					    });
	    						form.setVisible(false);
	    					} else {
	    						MyUtils.showErrorMessage("Lỗi đăng nhập" , "Thông tin không phù hợp!");
	    					}
    					}else {
    						MyUtils.showErrorMessage("Lỗi đăng nhập" , "Tài khoản bị vô hiệu hóa!");
    					}
    				}else {
    					MyUtils.showErrorMessage("Lỗi đăng nhập" , "Sai thông tin đăng nhập!");
    				}
    			} catch(Exception ex) {
    				ex.printStackTrace();
    				MyUtils.showErrorMessage("Lỗi đăng nhập" , "Có lỗi xảy ra. Vui lòng thử lại!");
    			}
    		}
    	});
    }
}
