package productManage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CheckView extends JFrame {

	private JPanel contentPane;
	private JTextField tfProductID;
	private JTextField tfProductName;
	private JTextField tfNumber;
	private JTextField tfPrice;
	private JTable table;
	private JComboBox cbProduct = new JComboBox();
	private JLabel lbltt = new JLabel("");

	Vector vTieuDe = new Vector();
	Vector vndung = new Vector();
	Vector vdong = new Vector();
	
	double tt=0;
	DefaultTableModel dtm = new DefaultTableModel();

	public void tieuDe() {
		vTieuDe.add("Mã sp");
		vTieuDe.add("Tên sp");
		vTieuDe.add("Loại sp");
		vTieuDe.add("Khuyễn mãi");
		vTieuDe.add("Số lượng");
		vTieuDe.add("Đơn giá");
		vTieuDe.add("Thành tiền");

	}

	public void nhap(Product sanpham) {
		
		
		vdong.add(sanpham.getProductID());
		vdong.add( sanpham.getProductName());
		if (cbProduct.getSelectedIndex() == 0) {
			vdong.add( "Điện thoại");
			vdong.add("20%");
		}
		if (cbProduct.getSelectedIndex() == 1) {
			vdong.add( "Điện máy");
			vdong.add("10%");
		}
		vdong.add( sanpham.getNumber()+"");
		vdong.add(sanpham.getPrice()+"");
		vdong.add(sanpham.computeMoney()+"");
		tt=tt +sanpham.computeMoney();
		vndung.add( vdong);
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckView frame = new CheckView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckView() {
		tieuDe();
		setTitle("Quản lý sản phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 545);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelProduct = new JLabel("SẢN PHẨM");
		labelProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelProduct.setBounds(21, 10, 95, 32);
		contentPane.add(labelProduct);

		cbProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbProduct.setModel(new DefaultComboBoxModel(new String[] { "Điện thoại", "Điện máy" }));
		cbProduct.setBounds(21, 52, 173, 32);
		contentPane.add(cbProduct);

		tfProductID = new JTextField();
		tfProductID.setBounds(372, 52, 196, 20);
		contentPane.add(tfProductID);
		tfProductID.setColumns(10);

		JLabel lblNewLabel = new JLabel("Mã sản phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(279, 52, 83, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(279, 80, 83, 20);
		contentPane.add(lblNewLabel_1);

		tfProductName = new JTextField();
		tfProductName.setColumns(10);
		tfProductName.setBounds(372, 82, 196, 20);
		contentPane.add(tfProductName);

		JLabel lbSoluong = new JLabel("Số lượng");
		lbSoluong.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbSoluong.setBounds(279, 110, 83, 20);
		contentPane.add(lbSoluong);

		tfNumber = new JTextField();
		tfNumber.setColumns(10);
		tfNumber.setBounds(372, 112, 196, 20);
		contentPane.add(tfNumber);

		JLabel lblnGi_1 = new JLabel("Đơn giá");
		lblnGi_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnGi_1.setBounds(279, 142, 83, 20);
		contentPane.add(lblnGi_1);

		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(372, 142, 196, 20);
		contentPane.add(tfPrice);

		JButton btnAdd = new JButton("THÊM");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product sanpham = null;
				String maSP = tfProductID.getText();
				String tenSP = tfProductName.getText();
				int soluong = Integer.parseInt(tfNumber.getText());
				double donGia= Double.parseDouble(tfPrice.getText());
				if(cbProduct.getSelectedIndex()==0) {
					sanpham= new Phone(maSP, tenSP, soluong, donGia);
				}
				if(cbProduct.getSelectedIndex()==1) {
					sanpham= new ElectricMachine(maSP, tenSP, soluong, donGia);
				}
				nhap(sanpham);
				lbltt.setText(tt+"");
				dtm.setDataVector(vndung,vTieuDe);
				table.setModel(dtm);
								
			
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(142, 187, 83, 32);
		contentPane.add(btnAdd);

		JButton btnDelete = new JButton("XÓA");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfPrice.setText("");
				tfProductID.setText("");
				tfNumber.setText("");
				tfProductName.setText("");
				lbltt.setText("");
				vdong.clear();
				dtm.setDataVector(vdong, vTieuDe);
				table.setModel(dtm);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(279, 187, 83, 32);
		contentPane.add(btnDelete);

		JButton btnExit = new JButton("THOÁT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(417, 186, 83, 35);
		contentPane.add(btnExit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 325, 2, 2);
		contentPane.add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(39, 242, 579, 129);
		contentPane.add(scrollPane_1);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, },
				new String[] { "M\u00E3 SP", "T\u00EAn SP", "Lo\u1EA1i SP", "S\u1ED1 l\u01B0\u1EE3ng",
						"Khuy\u1EBFn m\u00E3i", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh Ti\u1EC1n" }));
		table.getColumnModel().getColumn(0).setMinWidth(18);
		scrollPane_1.setViewportView(table);

		JLabel lbTongThanhTien = new JLabel("TỔNG THÀNH TIỀN:");
		lbTongThanhTien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbTongThanhTien.setBounds(217, 408, 118, 25);
		contentPane.add(lbTongThanhTien);

		lbltt.setForeground(Color.RED);
		lbltt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbltt.setBounds(360, 413, 112, 20);
		contentPane.add(lbltt);
	}
}
