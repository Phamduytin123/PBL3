package controller.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Customer.PanelXacNhanThongTin_B3;

public class Buoc3Listener implements ActionListener{
	private PanelXacNhanThongTin_B3 B3;
	
	public Buoc3Listener(PanelXacNhanThongTin_B3 B3) {
		this.B3 = B3;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command  = e.getActionCommand();
		if(command.equals("Xác nhận"))
		{
			if(B3.txt_DiaChi.equals("") || B3.txt_Email.equals("") || 
				B3.txt_HoVaTen.equals("") || B3.txt_SoDienThoai.equals("") )
			{
				JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin trước khi sang bước khác");
				return;
			}
			String email = B3.txt_Email.getText(); 
			if(!email.substring(email.length()-10).equals("@gmail.com"))
			{
				JOptionPane.showMessageDialog(null, "Định dạng email bạn nhập vào không đúng đề nghị nhập lại");
				return;
			}
			String Tel = B3.txt_SoDienThoai.getText();
			if(Tel.length() != 10)
			{
				JOptionPane.showMessageDialog(null, "Số điện thoại nhập vào phải đủ 10 chữ số !!");
				return;
			}
			if(B3.chkbx_XacNhan.isSelected()) {
				B3.OutputData();
				B3.fbt.Buoc3Sang4();
			}
			else
			{
				JOptionPane.showMessageDialog( null , "Hãy xác nhận lại những thông tin trên và tích vào ô xác nhận thông tin bên dưới !!");
				return;
			}
		}
		else if(command.equals("Quay lại"))
		{
			B3.OutputData();
			B3.fbt.Lui2();
			B3.fbt.BuocTruocDo = 3;
		}
	}
}
