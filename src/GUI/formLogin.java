package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Controller.LoginController;

import javax.swing.JRadioButton;

public class formLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txfUsername;
	private JPasswordField passwordField;
	private JRadioButton rdbtnEmployee;
	private JRadioButton rdbtnManage;
	private JButton btnLogIn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formLogin frame = new formLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public formLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setOpaque(false);
		mainPanel.setBounds(0, 0, 384, 361);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);

		JLabel lbBrand = new JLabel("BLUE STORE");
		lbBrand.setHorizontalAlignment(SwingConstants.CENTER);
		lbBrand.setForeground(new Color(25, 25, 112));
		lbBrand.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 30));
		lbBrand.setBounds(71, 30, 241, 50);
		mainPanel.add(lbBrand);
		
		rdbtnManage = new JRadioButton("Manage");
		rdbtnManage.setForeground(new Color(25, 25, 112));
		rdbtnManage.setOpaque(false);
		rdbtnManage.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		rdbtnManage.setBounds(70, 109, 109, 23);
		mainPanel.add(rdbtnManage);
		
		rdbtnEmployee = new JRadioButton("Employee");
		rdbtnEmployee.setOpaque(false);
		rdbtnEmployee.setForeground(new Color(25, 25, 112));
		rdbtnEmployee.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		rdbtnEmployee.setBounds(200, 109, 109, 23);
		rdbtnEmployee.setSelected(true);
		mainPanel.add(rdbtnEmployee);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnManage);
		group.add(rdbtnEmployee);

		JLabel lbPhone = new JLabel("Phone");
		lbPhone.setForeground(new Color(25, 25, 112));
		lbPhone.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lbPhone.setBounds(45, 160, 90, 25);
		mainPanel.add(lbPhone);
		
				txfUsername = new JTextField();
				txfUsername.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
				txfUsername.setHorizontalAlignment(SwingConstants.LEFT);
				txfUsername.setForeground(new Color(25, 25, 112));
				txfUsername.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
				txfUsername.setColumns(10);
				txfUsername.setBounds(155, 160, 190, 25);
				mainPanel.add(txfUsername);

		JLabel lblPw = new JLabel("Password");
		lblPw.setForeground(new Color(25, 25, 112));
		lblPw.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		lblPw.setBounds(45, 215, 90, 25);
		mainPanel.add(lblPw);

		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setForeground(new Color(25, 25, 112));
		passwordField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		passwordField.setBounds(155, 215, 190, 25);
		mainPanel.add(passwordField);

		btnLogIn = new JButton("LOG IN");
		btnLogIn.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnLogIn.setForeground(new Color(25, 25, 112));
		btnLogIn.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		btnLogIn.setBackground(new Color(176, 196, 222));
		btnLogIn.setBounds(142, 285, 100, 30);
		mainPanel.add(btnLogIn);

		// set background
		JLabel bg = new JLabel();
		bg.setBounds(0, 0, 384, 361);
		ImageIcon bgload = new ImageIcon(new ImageIcon(this.getClass().getResource("/background.png")).getImage()
				.getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH));
		bg.setIcon(bgload);
		getContentPane().add(bg);
		
		LoginController controll = new LoginController(this, txfUsername, passwordField, rdbtnEmployee, rdbtnManage, btnLogIn);
	}
}
