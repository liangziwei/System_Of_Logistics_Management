package ui.financeui.settlementui;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ui.baseui.LimpidButton;
import vo.businessVO.ReceivableVO;

@SuppressWarnings("serial")
public class ListPanel extends JPanel{
	
	private JTable list = null;
	
	private JScrollPane container = new JScrollPane();
	
	private LimpidButton sumBtn = new LimpidButton("","picture/合计.png");
	
	private JTextField sumText = new JTextField();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
		
	public ListPanel(List<ReceivableVO> receivables, int x, int y, int panelW, int panelH) {
		//初始化组件
		this.initUI(receivables, x, y, panelW, panelH);
	}
	
	private void initUI(List<ReceivableVO> receivables, int x, int y, int panelW, int panelH) {
		//收款单表格
		//列名
		Object[] names = new Object[] {"收款单日期", "收款快递员"};
		//数据
		int number = receivables.size();
		int rowNum = number < 8 ? 8 : number;
		Object[][] datas = new Object[rowNum][2];
		ReceivableVO temp = null;
		for(int i = 0; i < number; i++) {
			temp = receivables.get(i);
			datas[i][0] = temp.getDate();
			datas[i][1] = temp.getCourier();
		}
		this.list = new JTable(datas, names);
		int rowH = panelH / 18 ;
		this.list.setRowHeight(rowH);
		this.list.setFont(WORD_FONT);
		//列表容器
		this.container.setBounds(0, 0, panelW, panelH >> 1);
		this.container.setViewportView(this.list);
		this.container.setOpaque(false);
		//合计按钮
		int btnW = panelW >> 2;
		int btnH = btnW >> 1;
		this.sumBtn.setBounds(this.container.getX() + btnW,
				this.container.getY() + this.container.getHeight() + btnH , btnW, btnH);
		this.sumBtn.setFont(WORD_FONT);
		//合计文本框
		int textW = btnW;
		int textH = btnH;
		this.sumText.setBounds(panelW * 5 >> 3, this.sumBtn.getY(), textW, textH);
		this.sumText.setFont(WORD_FONT);
		this.sumText.setOpaque(false);
		
		//主面板
		this.setBounds(x, y, panelW, panelH - 7);
		this.setLayout(null);
		this.setOpaque(false);
		this.add(this.container);
		this.add(this.sumBtn);
		this.add(this.sumText);
	}
	
	public int getSelectedRow() {
		return this.list.getSelectedRow();
	}
	
	public JTable getReceivableList() {
		return this.list;
	}
	
	public JButton getSumButton() {
		return this.sumBtn;
	}
	
	public JTextField getSumText() {
		return this.sumText;
	}
}
