package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JYearChooser;

import GUI.Controller.ThongKeController;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.BorderLayout;

public class statis extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnPrint;
	private JButton btnCreate;
	private JButton btnCreateByTime;
	private JButton btnPrintByTime;
	private JComboBox cbReportType;
	private JYearChooser cbYear;
	private JDateChooser beginDate;
	private JDateChooser endDate;
	private ThongKeController controller;

	private JTable table_1;

	public statis() {
		setOpaque(false);
		setBorder(new LineBorder(new Color(25, 25, 112)));
		setBackground(new Color(235, 255, 250));
		setLayout(null);
		setVisible(true);
		JLabel lbStatistic = new JLabel("STATISTIC");
		lbStatistic.setHorizontalAlignment(SwingConstants.CENTER);
		lbStatistic.setForeground(new Color(25, 25, 112));
		lbStatistic.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lbStatistic.setBounds(198, 0, 163, 30);
		add(lbStatistic);

		JPanel panelCus = new JPanel();
		panelCus.setBorder(new LineBorder(new Color(25, 25, 112)));
		panelCus.setBackground(new Color(176, 196, 222));
		panelCus.setBounds(10, 30, 540, 200);
		add(panelCus);
		panelCus.setLayout(null);

		JLabel lbStatisChoose = new JLabel("Statistics of revenue by");
		lbStatisChoose.setForeground(new Color(25, 25, 112));
		lbStatisChoose.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		lbStatisChoose.setBounds(10, 10, 180, 30);
		panelCus.add(lbStatisChoose);

		cbReportType = new JComboBox();
		cbReportType.setForeground(new Color(25, 25, 112));
		cbReportType.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		cbReportType.setModel(new DefaultComboBoxModel(new String[] { "Month", "Quater", "Year" }));
		cbReportType.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbReportType.setBackground(new Color(245, 255, 250));
		cbReportType.setBounds(190, 13, 80, 25);
		panelCus.add(cbReportType);

		cbYear = new JYearChooser();
		cbYear.getSpinner().setLocation(1, 14);
		cbYear.getSpinner().setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		cbYear.setForeground(new Color(25, 25, 112));
		cbYear.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		cbYear.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		cbYear.setBackground(new Color(245, 255, 250));
		cbYear.setBounds(275, 13, 80, 25);
		panelCus.add(cbYear);

		btnPrint = new JButton("Print");
		btnPrint.setBounds(450, 10, 80, 30);
		panelCus.add(btnPrint);
		btnPrint.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnPrint.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPrint.setBackground(new Color(204, 204, 255));
		btnPrint.setForeground(new Color(25, 25, 112));
		btnPrint.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));

		JScrollPane scrollStatis = new JScrollPane();
		scrollStatis.setForeground(new Color(25, 25, 112));
		scrollStatis.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		scrollStatis.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		scrollStatis.setBackground(new Color(176, 196, 222));
		scrollStatis.setBounds(10, 50, 520, 140);
		panelCus.add(scrollStatis);

		table = new JTable();
		table.setBackground(new Color(204, 204, 255));
		table.setForeground(new Color(25, 25, 112));
		table.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		scrollStatis.setViewportView(table);

		btnCreate = new JButton("Create");
		btnCreate.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCreate.setForeground(new Color(25, 25, 112));
		btnCreate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnCreate.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnCreate.setBackground(new Color(204, 204, 255));
		btnCreate.setBounds(365, 10, 80, 30);
		panelCus.add(btnCreate);

		JPanel panelBillDetail = new JPanel();
		panelBillDetail.setBorder(new LineBorder(new Color(25, 25, 112)));
		panelBillDetail.setBackground(new Color(176, 196, 222));
		panelBillDetail.setBounds(10, 241, 540, 248);
		add(panelBillDetail);
		panelBillDetail.setLayout(null);

		JLabel lbStatisDate = new JLabel("Revenue statistics from");
		lbStatisDate.setForeground(new Color(25, 25, 112));
		lbStatisDate.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		lbStatisDate.setBounds(10, 10, 180, 30);
		panelBillDetail.add(lbStatisDate);

		JScrollPane scrollStatisDate = new JScrollPane();
		scrollStatisDate.setForeground(new Color(25, 25, 112));
		scrollStatisDate.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		scrollStatisDate.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		scrollStatisDate.setBackground(new Color(176, 196, 222));
		scrollStatisDate.setBounds(10, 85, 520, 154);
		panelBillDetail.add(scrollStatisDate);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(204, 204, 255));
		table_1.setForeground(new Color(25, 25, 112));
		table_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		scrollStatisDate.setViewportView(table_1);

		JDateChooser beginDate = new JDateChooser();
		beginDate.setForeground(new Color(25, 25, 112));
		beginDate.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		beginDate.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		beginDate.setBackground(new Color(245, 255, 250));
		beginDate.setBounds(197, 13, 145, 25);
		panelBillDetail.add(beginDate);

		JLabel lblTo = new JLabel("to");
		lblTo.setForeground(new Color(25, 25, 112));
		lblTo.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		lblTo.setBounds(350, 10, 40, 30);
		panelBillDetail.add(lblTo);

		JDateChooser endDate = new JDateChooser();
		endDate.setForeground(new Color(25, 25, 112));
		endDate.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		endDate.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		endDate.setBackground(new Color(245, 255, 250));
		endDate.setBounds(385, 13, 145, 25);
		panelBillDetail.add(endDate);

		btnCreateByTime = new JButton("Create");
		btnCreateByTime.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCreateByTime.setForeground(new Color(25, 25, 112));
		btnCreateByTime.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnCreateByTime.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnCreateByTime.setBackground(new Color(204, 204, 255));
		btnCreateByTime.setBounds(185, 45, 80, 30);
		panelBillDetail.add(btnCreateByTime);

		btnPrintByTime = new JButton("Print");
		btnPrintByTime.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPrintByTime.setForeground(new Color(25, 25, 112));
		btnPrintByTime.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnPrintByTime.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnPrintByTime.setBackground(new Color(204, 204, 255));
		btnPrintByTime.setBounds(275, 44, 80, 30);
		panelBillDetail.add(btnPrintByTime);
		
		controller = new ThongKeController(table, table_1, btnPrint, btnCreate, btnCreateByTime, btnPrintByTime, cbReportType, cbYear, beginDate, endDate);
	}
	
	public ThongKeController getController() {
		return controller;
	}

	public void setController(ThongKeController controller) {
		this.controller = controller;
	}
	
}
