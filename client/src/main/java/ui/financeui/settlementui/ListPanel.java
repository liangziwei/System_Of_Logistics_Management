package ui.financeui.settlementui;

import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import vo.businessVO.ReceivableVO;

@SuppressWarnings("serial")
public class ListPanel extends JScrollPane{
	
	private JList<String> list = null;
	
	private Vector<String> items = new Vector<String>();
	
//	private JButton sumBtn = new JButton("合计");
	
//	private JTextField sumText = new JTextField();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
		
	public ListPanel(List<ReceivableVO> receivables, int x, int y, int panelW, int panelH) {
		//添加列表项
		this.addListItem(receivables);
		//初始化组件
		this.initUI(receivables, x, y, panelW, panelH);
	}
	
	private void initUI(List<ReceivableVO> receivables, int x, int y, int panelW, int panelH) {
		//合计按钮
		int btnW = panelW / 5 << 1;
		int btnH = btnW >> 1;
		int btnX = btnH;
		int btnY = panelH - btnH * 3;
//		this.sumBtn.setBounds(0, btnY, btnW, btnH);
//		this.sumBtn.setFont(WORD_FONT);
		//合计文本框
		int textW = btnW;
		int textH = btnH;
//		this.sumText.setBounds(this.sumBtn.getX() + btnW + btnX, this.sumBtn.getY(), textW, textH);
//		this.sumText.setFont(WORD_FONT);
		//列表项
		this.list = new JList<String>(this.items);
		//计算列表项个数
		int number = 0, size = receivables.size();
		for(int i = 0; i < size; i++) {
			number = number + receivables.get(i).getDeliveryid().size() + 1;
		}
		int itemH = panelH / number;
		
		//设置列表项长宽
		itemH = itemH > 20 ? 20 : itemH;
		this.list.setFixedCellHeight(20);
		this.list.setFixedCellHeight(itemH);
		this.list.setFixedCellWidth(panelW);
		//设置列表项字体
		this.list.setFont(WORD_FONT);
		//列表边框
		TitledBorder b = new TitledBorder("收款单列表");
		b.setTitleFont(WORD_FONT);		
		this.list.setBorder(b);
		int h = btnY - btnH;
		this.list.setBounds(0, 0, panelW, h);	
		//列表面板
		this.setBounds(x, y, panelW, panelH);
		this.setViewportView(this.list);
//		this.add(this.sumBtn);
//		this.add(this.sumText);
	}
	
	private void addListItem(List<ReceivableVO> receivables) {
		List<String> id = null;
		for(int i = 0; i < receivables.size(); i++) {
			this.items.add("收款单" + (i + 1));
			id = receivables.get(i).getDeliveryid();
			for(int j = 0; j < id.size(); j++) {
				this.items.add("订单编号" + (j + 1) + ":" + id.get(j));
			}
		}
	}
	
//	public static void main(String[] args) {
//		JFrame f = new JFrame();
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setLayout(null);
//		f.setVisible(true);
//		f.setBounds(100, 100, 700, 400);
//		
//	    List<ReceivableVO> receivables = new ArrayList<ReceivableVO>();
//		ArrayList<String> id1 = new ArrayList<String>();
//		id1.add("1000010000");
//		id1.add("1000010001");
//		id1.add("1000010002");
//		id1.add("1000010003");
//		ArrayList<String> id2 = new ArrayList<String>();
//		id2.add("0000010000");
//		id2.add("0000010001");
//		id2.add("0000010002");
//		id2.add("0000010003");
//		ArrayList<String> id3 = new ArrayList<String>();
//		id3.add("1000610000");
//		id3.add("1000610001");
//		id3.add("1000610002");
//		id3.add("1000610003");
//		receivables.add(new ReceivableVO("1990-1-1", 12.0, "A", id1));
//		receivables.add(new ReceivableVO("", 0.0, "", id2));
//		receivables.add(new ReceivableVO("", 0.0, "", id3));
//		
//		ListPanel l = new ListPanel(receivables, 0, 0, 600, 300);
//		l.setFont(new Font("宋体", Font.BOLD, 10)); 
//		f.add(l); 
//		f.repaint();
//	}
}
