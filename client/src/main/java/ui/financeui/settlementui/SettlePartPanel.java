package ui.financeui.settlementui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.financeController.SettlementController;
import businessLogicService.financeBLService.SettlementBLService;
import ui.baseui.DetailPanel;
import vo.businessVO.ReceivableVO;

@SuppressWarnings("serial")
public class SettlePartPanel extends DetailPanel{
	
	private SettlementBLService settle = new SettlementController();
	
	private BusinessIdPanel id = null;

//	private JLabel idLabel = new JLabel("营业厅编号");
//	
//	private JTextField idText = new JTextField();
//	
//	private JButton ok = new JButton("确定");
//	
//	private JButton cancel = new JButton("取消");
	
	private JLabel tip = new JLabel();
	
	private JButton sumBtn = new JButton("合计");
	
	private JTextField sumText = new JTextField();
	
	private ListPanel list = null;
	
    private ReceivablePanel receivable = null;
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
//	private static final int LABEL_W = 80;
//	
//	private static final int LABEL_H = 32;
//	
//	private static final int TEXT_W = LABEL_W;
//	
//	private static final int TEXT_H = LABEL_H;
//	
//	private static final int BUTTON_W = 64;
//	
//	private static final int BUTTON_H = LABEL_H;
	
//	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W - (BUTTON_W << 1)) / 5;
//	
//	private static final int START_Y = START_X >> 1;
	
//	private static final int LIST_PANEL_W = DETAIL_PANEL_W >> 1;
//	
//	private static final int LIST_PANEL_H = DETAIL_PANEL_H - START_Y - (LABEL_H << 1);
	
	/**
	 * @param isCheckAll,true表示查看所有收款单，false表示查看某一营业厅的收款单
	 */
	public SettlePartPanel() {
		//初始化组件
		this.initUI();
		//增加按钮事件监听
		this.addButtonListener();
	}
	
	private void initUI() {
		
//		//如果是查询当天所有营业厅的收款单
//		if(isCheckAll) {
//			//显示收款单列表
//			this.showList(30, START_Y, LIST_PANEL_W - 60, (int)(LIST_PANEL_H * 0.7));
//			//显示收款单详细内容
//			this.showReceivable();
//			//显示合计按钮和合计文本框
//			this.showTotal();
//			//增加收款单列表事件监听
//			this.addListListener();
//			return;
//		}
//		//营业厅编号标签
//		this.idLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
//		this.idLabel.setFont(WORD_FONT);
//		//营业厅编号文本框
//		this.idText.setBounds(this.idLabel.getX() + LABEL_W + (START_X >> 1), this.idLabel.getY(), TEXT_W, TEXT_H);
//		this.idText.setFont(WORD_FONT);
//		//确定按钮
//		this.ok.setBounds(this.idText.getX() + TEXT_W + START_X, this.idText.getY(), BUTTON_W, BUTTON_H);
//		this.ok.setFont(WORD_FONT);
//		//取消按钮
//		this.cancel.setBounds(this.ok.getX() + BUTTON_W + START_X, this.ok.getY(), BUTTON_W, BUTTON_H);
//		this.cancel.setFont(WORD_FONT);
		//提示标签
//		this.tip.setBounds(x, y, width, height);

//		//将组件添加到面板
//		this.add(this.idLabel);
//		this.add(this.idText);
//		this.add(this.ok);
//		this.add(this.cancel);

		//营业厅编号面板
		this.id = new BusinessIdPanel(5, 0, DETAIL_PANEL_W, DETAIL_PANEL_H / 6);
		//将营业厅编号面板加入主面板
		this.add(this.id);
	}
	
	private void addButtonListener() {
		//确定查询按钮
		this.id.getOk().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//根据营业厅编号查询当天的收款单
				//如果找不到，提示用户没有该收款单
				
				//如果找到，显示收款单列表
				//显示收款单详细内容
				showList(30 , id.getHeight() + (id.getHeight() >> 1),
						(DETAIL_PANEL_W >> 1) - 60, DETAIL_PANEL_H >> 1);
				//显示合计按钮和合计文本框
				showTotal();
				//显示收款单详细内容
				showReceivable();
				//刷新面板
				repaint();
			}
		});
		//取消查询按钮
		this.id.getCancel().addActionListener(new ActionListener() {
			
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
		this.list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
	}
	
	private void showList(int x, int y, int w, int h) {
		//TODO test
		List<ReceivableVO> receivables = settle.showBusinessRecei(this.id.getId(), "100");
		this.list = new ListPanel(receivables, x, y, w, h);
		this.add(list);
	}
	
	private void showReceivable() {
		//TODO TEST
		List<ReceivableVO> receivables = new ArrayList<>();
		ArrayList<String> id = new ArrayList<String>();
		id.add("1111");
		id.add("2222");
		receivables.add(new ReceivableVO("1995-1-1", 20.0, "茗科", id));
		this.receivable = new ReceivablePanel(new ReceivableVO("1995-1-1", 20.0, "茗科", id),
				DETAIL_PANEL_W >> 1, this.list.getY(),
				DETAIL_PANEL_W >> 1, DETAIL_PANEL_H * 5 / 6);
		add(receivable);
		this.revalidate();
		this.addListListener();
	}
	
	private void showTotal() {
		//合计按钮
		int btnW = DETAIL_PANEL_W / 10;
		int btnH = btnW >> 1;
		this.sumBtn.setBounds(this.list.getX() + btnW,
				this.list.getY() + this.list.getHeight() + btnH , btnW, btnH);
		this.sumBtn.setFont(WORD_FONT);
		//合计文本框
		int textW = btnW;
		int textH = btnH;
		this.sumText.setBounds(DETAIL_PANEL_W * 5 >> 4, this.sumBtn.getY(), textW, textH);
		this.sumText.setFont(WORD_FONT);
		
		this.add(this.sumBtn);
		this.add(this.sumText);
	}
}
