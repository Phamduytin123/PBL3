package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class PanelBill extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public PanelBill() {
		setBorder(new LineBorder(new Color(130, 135, 144), 1, true));
		this.setBounds(167, 127, 491, 132);
		setLayout(null);
		
		JLabel lbMaHoaDon = new JLabel("Mã hóa đơn");
		lbMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbMaHoaDon.setBounds(10, 11, 68, 14);
		add(lbMaHoaDon);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(89, 8, 262, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Chi tiết");
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(379, 7, 89, 23);
		add(btnNewButton);
		
		JLabel lblStart = new JLabel("");
		ImageIcon icon = new ImageIcon(FormMainPage.class.getResource("/photo/Icons-Land-Vista-Map-Markers-Map-Marker-Marker-Outside-Chartreuse.16.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		lblStart.setIcon(scaledIcon);
		lblStart.setBounds(7, 36, 16, 30);
		add(lblStart);
		
		JLabel lblEnd = new JLabel("");
		ImageIcon icon2 = new ImageIcon(FormMainPage.class.getResource("/photo/Icons-Land-Vista-Map-Markers-Map-Marker-Flag-4-Right-Azure.16.png"));
		Image image2 = icon2.getImage();
		Image scaledImage2 = image2.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
		lblEnd.setIcon(scaledIcon2);
		lblEnd.setBounds(5, 72, 16, 30);
		add(lblEnd);
		
		JLabel lblDiemDi = new JLabel("Điểm đi");
		lblDiemDi.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDiemDi.setBounds(30, 44, 51, 14);
		add(lblDiemDi);
		
		JLabel lbDiemDen = new JLabel("Điểm đến");
		lbDiemDen.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbDiemDen.setBounds(26, 80, 51, 14);
		add(lbDiemDen);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(88, 41, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(88, 77, 96, 20);
		add(textField_2);
		
		JLabel lblKhoangCach = new JLabel("Khoảng cách");
		lblKhoangCach.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblKhoangCach.setBounds(191, 44, 77, 14);
		add(lblKhoangCach);
		
		JLabel lblThoiGian = new JLabel("Thời gian");
		lblThoiGian.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblThoiGian.setBounds(191, 80, 77, 14);
		add(lblThoiGian);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(265, 41, 77, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(265, 77, 77, 20);
		add(textField_4);
		
		JLabel lblGiaVe = new JLabel("Giá vé");
		lblGiaVe.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGiaVe.setBounds(350, 44, 45, 14);
		add(lblGiaVe);
		
		JLabel lblTinhTrang = new JLabel("Tình trạng");
		lblTinhTrang.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblTinhTrang.setBounds(350, 80, 63, 14);
		add(lblTinhTrang);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(411, 41, 68, 20);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(411, 77, 68, 20);
		add(textField_6);
		
	}
}
