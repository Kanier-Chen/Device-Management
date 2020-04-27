package test阶乘;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener{
	JLabel jl1;
	JLabel jl2;
	JTextField jtf;
	JTextArea jta;
	JButton jb,jb1;
	public GUI() {
		this.setLayout(new FlowLayout());
		this.setBounds(100, 100, 1250, 900);
		jl1 = new JLabel("需要计算的阶乘数:");
		jl2 = new JLabel("结果:");
		jtf = new JTextField(20);
		jta = new JTextArea(30,105);
		jta.setEditable(false);
		jb = new JButton("确定");
		jb1 = new JButton("退出");
		jb.addActionListener(this);
		jb1.addActionListener(this);
		jl1.setFont(new Font("黑体", Font.BOLD, 20));
		jl2.setFont(new Font("黑体", Font.BOLD, 20));
		jtf.setFont(new Font("黑体", Font.BOLD, 20));
		jta.setFont(new Font("黑体", Font.BOLD, 20));
		jb.setFont(new Font("黑体", Font.BOLD, 20));
		jb1.setFont(new Font("黑体", Font.BOLD, 20));
		
		this.add(jl1);
		this.add(jtf);
		this.add(jl2);
		this.add(new JScrollPane(jta),BorderLayout.CENTER);
		this.add(jb);
		this.add(jb1);
		this.setTitle("阶乘计算程序");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getActionCommand()=="退出") {
				System.exit(0);
			}
			else if(e.getActionCommand()=="确定") {
				int num = Integer.parseInt(jtf.getText());
				BigInteger sum = new BigInteger("1");
				BigInteger numBig = new BigInteger(String.valueOf(num));
				if(num<0) {
					jta.setText("输入的数字必须为非负数！！");
				}
				else if(num==0) {
					jta.setText("数字"+num+"的计算结果为：\n");
					jta.append("1\n");
					jta.append("结果长为1位");
				}
				else {
					for(int i=num;i>=1;i--) {
						sum = sum.multiply(numBig);
						numBig = numBig.subtract(new BigInteger("1"));
					}
					char[] array = sum.toString().toCharArray();
					jta.setText("数字"+num+"的计算结果为：\n");
					for(int i=0;i<array.length;i++) {
						if(i != 0 && i % 100 == 0) {
							jta.append("\n");
						}
						jta.append(""+array[i]);
					}
					jta.append("\n");
					jta.append("结果长为"+sum.toString().length()+"位");
				}
			}
		} catch (Exception e2) {
			// TODO: handle exception
			jta.setText("请输入数字");
		}
	}
}
