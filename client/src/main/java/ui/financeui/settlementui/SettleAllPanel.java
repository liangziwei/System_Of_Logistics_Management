package ui.financeui.settlementui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import businessLogic.businessLogicController.financeController.SettlementController;
import businessLogicService.financeBLService.SettlementBLService;
import ui.baseui.DatePanel;
import ui.baseui.DetailPanel;
import vo.businessVO.ReceivableVO;

@SuppressWarnings("serial")
public class SettleAllPanel extends DetailPanel{
	
	private SettlementBLService settle = new SettlementController();

	private ListPanel list = null;
	
	private ReceivablePanel receivable = null;
	
	private List<ReceivableVO> receivableVO = null;
	
	public SettleAllPanel() {
		//获得收款单信息
		this.receivableVO = settle.showReceiList(DatePanel.getCurrentDate());
		//收款单列表面板
		this.list = new ListPanel(receivableVO, 30 , DETAIL_PANEL_W >> 3,
				(DETAIL_PANEL_W >> 1) - 60, DETAIL_PANEL_H * 5 / 6);
		//将列表加入主面板
		this.add(this.list);
		//增加列表事件监听
		this.addListListener();
		//增加合计按钮事件监听
		this.addSumBtnListener();
	}
	
	private void addListListener() {
		this.list.getReceivableList().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				int row = list.getSelectedRow();
				if(row < receivableVO.size()) {
					//收款单详细信息面板
					receivable = new ReceivablePanel(receivableVO.get(row),
							DETAIL_PANEL_W >> 1, list.getY(),
							DETAIL_PANEL_W >> 1, DETAIL_PANEL_H * 5 / 6);
					add(receivable);
					receivable.validate();
					receivable.repaint();
				}
			}
		});
	}
	
	private void addSumBtnListener() {
		this.list.getSumButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//计算总价
				double sum = settle.calculateSum();
				//显示总价
				list.getSumText().setText(new Double(sum).toString());
			}
		});
	}
}
