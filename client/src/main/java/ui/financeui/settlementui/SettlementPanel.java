package ui.financeui.settlementui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.financeController.SettlementController;
import businessLogicService.financeBLService.SettlementBLService;
import ui.baseui.DetailPanel;
import vo.businessVO.ReceivableVO;

@SuppressWarnings("serial")
public class SettlementPanel extends DetailPanel{
	
	private SettlementBLService settle = new SettlementController();

	private JLabel idLabel = new JLabel("营业厅编号");
	
	private JTextField idText = new JTextField();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private ListPanel list = null;
	
    private ReceivablePanel receivable = null;
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	private static final int LABEL_W = 100;
	
	private static final int LABEL_H = 32;
	
	private static final int TEXT_W = LABEL_W;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 64;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W - (BUTTON_W << 1)) / 5;
	
	private static final int START_Y = START_X >> 1;
	
	private static final int LIST_PANEL_W = 192;
	
	private static final int LIST_PANEL_H = DETAIL_PANEL_H - START_Y - (LABEL_H << 1);
	
	/**
	 * @param isCheckAll,true表示查看所有收款单，false表示查看某一营业厅的收款单
	 */
	public SettlementPanel(boolean isCheckAll) {
		//初始化组件
		this.initUI(isCheckAll);
		//增加时间监听
		this.addListener();
	}
	
	private void initUI(boolean isCheckAll) {
		this.setLayout(null);
		if(isCheckAll) {
			this.showList();
			this.showReceivable();
			return;
		}
		//营业厅编号标签
		this.idLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.idLabel.setFont(WORD_FONT);
		//营业厅编号文本框
		this.idText.setBounds(this.idLabel.getX() + LABEL_W + (START_X >> 1), this.idLabel.getY(), TEXT_W, TEXT_H);
		this.idText.setFont(WORD_FONT);
		//确定按钮
		this.ok.setBounds(this.idText.getX() + TEXT_W + START_X, this.idText.getY(), BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + BUTTON_W + START_X, this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//将组件添加到面板
		this.add(this.idLabel);
		this.add(this.idText);
		this.add(this.ok);
		this.add(this.cancel);
	}
	
	private void addListener() {
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
				showReceivable();
				repaint();
			}
		});
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	/**
	 * 添加收款单列表的监听
	 */
	private void addListListener() {
		
	}
	
	private void showList() {
		//TODO TEST
		//TODO test
		List<ReceivableVO> receivables = settle.showBusinessRecei(idText.getText(), "100");
		list = new ListPanel(receivables, 5, START_Y + (LABEL_H << 1), LIST_PANEL_W, LIST_PANEL_H);
		add(list);
	}
	
	private void showReceivable() {
		//TODO TEST
		List<ReceivableVO> receivables = settle.showBusinessRecei(idText.getText(), "100");
		receivable = new ReceivablePanel(receivables.get(0), list.getX() + LIST_PANEL_W,
				list.getY(), DETAIL_PANEL_W - LIST_PANEL_W, LIST_PANEL_H);
		add(receivable);
	}
}
