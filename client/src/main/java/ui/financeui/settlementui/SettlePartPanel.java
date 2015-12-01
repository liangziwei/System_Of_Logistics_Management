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
public class SettlePartPanel extends DetailPanel{
	
	private SettlementBLService settle = new SettlementController();
	
	private BusinessIdPanel id = null;

	private ListPanel list = null;
	
    private ReceivablePanel receivable = null;
	
	private List<ReceivableVO> receivableVO = null;
	
	public SettlePartPanel() {
		//初始化组件
		this.initUI();
		//增加按钮事件监听
		this.addButtonListener();
	}
	
	private void initUI() {
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
				receivableVO = settle.showBusinessRecei(id.getId(), DatePanel.getCurrentDate());
				//如果找不到，提示用户没有该收款单
				if(receivableVO == null) {
					id.setTip("该收款单不存在");
					return ;
				}
				else {
					id.removeTip();
				}
				//如果找到，显示收款单列表
				showList(receivableVO, 30 , id.getHeight() + (id.getHeight() >> 1),
						(DETAIL_PANEL_W >> 1) - 60, DETAIL_PANEL_H * 5 / 6);
				//增加列表的 监听
				addListListener();
				//刷新面板
				list.repaint();
				repaint();
			}
		});
	}
	
	/**
	 * 添加收款单列表的监听
	 */
	private void addListListener() {
		this.list.getReceivableList().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				//显示收款单详细内容
				int row = list.getSelectedRow();
				if(receivableVO.size() > row) {
					showReceivable(receivableVO.get(row));
				}
				//刷新收款单详细内容面板
				receivable.validate();
				receivable.repaint();
			}
		});
		//合计按钮
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
	
	private void showList(List<ReceivableVO> receivables, int x, int y, int w, int h) {
		if(this.list != null) this.remove(this.list);
		this.list = new ListPanel(receivables, x, y, w, h);
		this.add(list);
	}
	
	private void showReceivable(ReceivableVO vo) {
		this.receivable = new ReceivablePanel(vo,
				DETAIL_PANEL_W >> 1, this.list.getY(),
				DETAIL_PANEL_W >> 1, DETAIL_PANEL_H * 5 / 6);
		this.add(this.receivable);
	}
	
}
