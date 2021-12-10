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
	private JFrame frame;
    private JButton btnSignin;
    private JTextField txtPhone;
    private JPasswordField txtPassword;
    private JRadioButton rdbManager;
    private JRadioButton rdbEmployee;
    private NhanVienDao dao;
    
    public LoginController(JFrame frame, JButton btnSignin,
    		JTextField txtPhone, JPasswordField txtPassword,
    		JRadioButton rdbManager, JRadioButton rdbEmployee) {
    	this.btnSignin = btnSignin;
    	this.frame = frame;
    	this.txtPhone = txtPhone;
    	this.txtPassword = txtPassword;
    	this.rdbEmployee = rdbEmployee;
    	this.rdbManager = rdbManager;
    	
    	dao = new NhanVienDaoImpl();
    }
    
    public void setEvent() {	
    	btnSignin.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			try {
    				NhanVienModel nhanvien = dao.login(txtPhone.getText(), txtPassword.getText());
    				if(nhanvien != null) {
    					if(rdbManager.isSelected() && nhanvien.getRole() == 1) {
    						JOptionPane.showMessageDialog(frame, "Bạn là quản lý!");
    					}else if (rdbEmployee.isSelected() && nhanvien.getRole() == 0) {
    						JOptionPane.showMessageDialog(frame, "Bạn là nhân viên!");
    					}else {
    						JOptionPane.showMessageDialog(frame, "Thông tin không phù hợp!");
    					}
    				}else {
    					JOptionPane.showMessageDialog(frame, "Sai thông tin đăng nhập!");
    				}
    			}catch(Exception ex) {
    				ex.printStackTrace();
    				JOptionPane.showMessageDialog(frame, "Có lỗi xảy ra. Vui lòng thử lai!");
    			}
    		}
    	});
    }
}
