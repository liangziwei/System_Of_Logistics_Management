package ui.baseui;

import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTextField;

import businessLogic.businessLogicModel.util.CommonLogic;

/**
 * 日期面板，用于用户输入日期(yyyy-mm-dd)
 */
@SuppressWarnings("serial")
public class DatePanel extends JPanel{

	private JTextField year = new JTextField();
	
	private JTextField month = new JTextField();
	
	private JTextField day = new JTextField();
	
	private int textW = 0;
	
	private int textH = 0;
	
	public DatePanel() {
		//主面板
		this.setLayout(null);
		this.setVisible(true);
		//设置文本框为透明
		this.year.setOpaque(false);
		this.month.setOpaque(false);
		this.day.setOpaque(false);
	}
	
	/**
	 *设置日期面板的边界与大小以及里面组件的边界与大小 
	 */
	public void setPanelBound(int x, int y, int w, int h) {
		//设置面板范围
		this.setBounds(x, y, w, h);
		//设置文本框长和宽
		this.textW = (w - h) / 3;
		this.textH = h;
		this.setTextBound();
	}
	
	private void setTextBound() {
		this.year.setBounds(0, 0, this.textW, this.textH); 
		this.month.setBounds(this.textW + (this.textH >> 1), 0, this.textW, this.textH);
		this.day.setBounds((this.textW << 1) + this.textH, 0, this.textW, this.textH);
		//将组件添加到面板
		this.add(this.year);
		this.add(this.month);
		this.add(this.day);
		//刷新面板
		this.repaint();
	}
	
	public void setDate() {
		//设置日期
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String[] d = form.format(date).split("-");
		this.year.setText(d[0]); 
		this.month.setText(d[1]);
		this.day.setText(d[2]);
		//设置日期不可编辑
		this.disableComponents();
	}
	
	public void setDate(String date) {
		try {
			String d[] = date.split("-");
			this.year.setText(d[0]);
			this.month.setText(d[1]);
			this.day.setText(d[2]);
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		//设置日期不可编辑
		this.disableComponents();
	}
	
	public void clearInfo() {
		this.year.setText("");
		this.month.setText("");
		this.day.setText("");
	}
	
	public void disableComponents() {
		//设置日期不可编辑
		this.year.setEditable(false);
		this.month.setEditable(false);
		this.day.setEditable(false);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//年与月之间的横线
		g.drawLine(this.textW, this.textH >> 1, this.textW + (this.textH >> 1), this.textH >> 1);
		//月与日之间的横线
		g.drawLine((this.textW << 1) + (this.textH >> 1), this.textH >> 1, (this.textW << 1) + this.textH, this.textH >> 1);
	}
	
	public String getDate() {
		String year = this.year.getText();
		if(CommonLogic.isNull(year)) year = "0000";
		String month = this.month.getText();
		month = month.length() < 2 ? "0" + month : month;
		String day = this.day.getText();
		day = day.length() < 2 ? "0" + day : day;
		return year + "-" + month + "-" + day;
	}
	
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		return sdf.format(d);
	}
}
