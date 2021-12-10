package GUI;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class formEmployee extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private customer fCustomer;
	private product fProduct;
	private bill fBill;
	private billHistory fHistory;
	private profile fProfile;
	
	public formEmployee(Integer userId) {
		fCustomer = new customer();
		fProduct = new product();
		fBill = new bill(userId);
		fHistory = new billHistory(userId, false);
		fProfile = new profile(userId);
		
		setBackground(new Color(25, 25, 112));
		setTitle("Employee");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 540);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new LineBorder(new Color(25, 25, 112)));
		panel.setBackground(new Color(235, 255, 255));
		panel.setBounds(0, 0, 135, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCus = new JButton("Customer");
		btnCus.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnCus.setOpaque(false);
		btnCus.setBackground(new Color(176, 196, 222));
		btnCus.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnCus.setForeground(new Color(25, 25, 112));
		btnCus.setBounds(10, 30, 115, 35);
		panel.add(btnCus);
				
		JButton btnPro = new JButton("Product");
		btnPro.setOpaque(false);
		btnPro.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnPro.setBackground(new Color(176, 196, 222));
		btnPro.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnPro.setForeground(new Color(25, 25, 112));
		btnPro.setBounds(10, 80, 115, 35);
		panel.add(btnPro);
		
		JButton btnBill = new JButton("Bill");
		btnBill.setOpaque(false);
		btnBill.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnBill.setBackground(new Color(176, 196, 222));
		btnBill.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnBill.setForeground(new Color(25, 25, 112));
		btnBill.setBounds(10, 130, 115, 35);
		panel.add(btnBill);
		
		JButton btnHistory = new JButton("Bill history");
		btnHistory.setOpaque(false);
		btnHistory.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnHistory.setBackground(new Color(176, 196, 222));
		btnHistory.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnHistory.setForeground(new Color(25, 25, 112));
		btnHistory.setBounds(10, 180, 115, 35);
		panel.add(btnHistory);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setOpaque(false);
		btnProfile.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnProfile.setForeground(new Color(25, 25, 112));
		btnProfile.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnProfile.setBackground(new Color(176, 196, 222));
		btnProfile.setBounds(10, 230, 115, 35);
		panel.add(btnProfile);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setOpaque(false);
		btnLogOut.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnLogOut.setForeground(new Color(25, 25, 112));
		btnLogOut.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnLogOut.setBackground(new Color(176, 196, 222));
		btnLogOut.setBounds(10, 440, 115, 35);
		panel.add(btnLogOut);
		
		fCustomer.setVisible(false);
		fCustomer.setOpaque(false);
		fCustomer.setBounds(135, 0, 559, 500);
		fCustomer.setBackground(new Color(235, 255, 250));
		contentPane.add(fCustomer);
		
		fProduct.setVisible(false);
		fProduct.setOpaque(false);
		fProduct.setBounds(135, 0, 559, 500);
		fProduct.setBackground(new Color(235, 255, 250));
		contentPane.add(fProduct);
		
		fBill.setVisible(false);
		fBill.setOpaque(false);
		fBill.setBounds(135, 0, 559, 500);
		fBill.setBackground(new Color(235, 255, 250));
		contentPane.add(fBill);
		
		fHistory.setVisible(false);
		fHistory.setOpaque(false);
		fHistory.setBounds(135, 0, 559, 500);
		fHistory.setBackground(new Color(235, 255, 250));
		contentPane.add(fHistory);
		
		fProfile.setVisible(false);
		fProfile.setOpaque(false);
		fProfile.setBounds(135, 0, 559, 500);
		fProfile.setBackground(new Color(235, 255, 250));
		contentPane.add(fProfile);		
		
		JLabel bg =new JLabel();
		bg.setBounds(0,0,700,500);
		ImageIcon avtload = new ImageIcon(new ImageIcon(this.getClass().getResource("/background.png")).getImage().getScaledInstance(bg.getWidth(),bg.getHeight(), Image.SCALE_SMOOTH));
        bg.setIcon(avtload);
		getContentPane().add(bg);
		
		btnCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hide();
				fCustomer.getController().loadData();
				fCustomer.setVisible(true);
			}
		});
		
		btnPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hide();
				fProduct.getController().loadData();
				fProduct.setVisible(true);
			}
		});
		
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hide();
				fBill.getController().loadData();
				fBill.setVisible(true);
			}
		});
		
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hide();
				fHistory.setVisible(true);
			}
		});
		
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hide();
				fProfile.setVisible(true);
			}
		});
		
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
	
	void Hide() {
		fCustomer.setVisible(false);
		fProduct.setVisible(false);
		fBill.setVisible(false);
		fHistory.setVisible(false);
		fProfile.setVisible(false);
	}
}
