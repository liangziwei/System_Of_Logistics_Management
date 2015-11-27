package ui.financeui.settlementui;

import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import vo.businessVO.ReceivableVO;

@SuppressWarnings("serial")
public class ListPanel extends JScrollPane{
	
	private JTable list = null;
	
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
		int rowNum = number < 10 ? 10 : number;
		Object[][] datas = new Object[rowNum][2];
		ReceivableVO temp = null;
		for(int i = 0; i < number; i++) {
			temp = receivables.get(i);
			datas[i][0] = temp.getDate();
			datas[i][1] = temp.getCourier();
		}
		this.list = new JTable(datas, names);
		int rowH = panelH / 11;
		this.list.setRowHeight(rowH);
		this.list.setFont(WORD_FONT);
		
		//主面板
		this.setBounds(x, y, panelW, panelH - 7);
		this.setViewportView(this.list);
		
	}
}
