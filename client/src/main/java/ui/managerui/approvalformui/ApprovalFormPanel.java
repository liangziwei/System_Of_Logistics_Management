package ui.managerui.approvalformui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.businessLogicController.managerController.ApprovalFormController;
import businessLogicService.managerBLService.ApprovalFormBLService;
import ui.baseui.DetailPanel;
import vo.businessVO.ArrivalFormVO;
import vo.businessVO.EntruckingVO;
import vo.businessVO.ReceivableVO;
import vo.businessVO.SendFormVO;
import vo.deliveryVO.OrderVO;
import vo.financeVO.PaymentVO;
import vo.managerVO.UncheckedFormVO;
import vo.repositoryVO.InRepositoryVO;
import vo.repositoryVO.OutRepositoryVO;
import vo.transitionVO.ReceivingVO;
import vo.transitionVO.TransferringVO;

@SuppressWarnings("serial")
public class ApprovalFormPanel extends DetailPanel{
	
	private ApprovalFormBLService approve = new ApprovalFormController();
	
	private JLabel typeLabel = new JLabel("单据类型");

	private JComboBox<String> typeText = new JComboBox<String>();
	
	private JTable form = null;
	
	private JScrollPane container = new JScrollPane();
	
	private JButton approveOne = new JButton("通过审批");
	
	private JButton approveMore = new JButton("批量审批");
	
	private UncheckedFormVO uncheck = approve.getUncheckedForms();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	private static final int LABEL_W = DETAIL_PANEL_W / 12;
	
	private static final int LABEL_H = LABEL_W >> 1;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int TABLE_W = (LABEL_W * 3 >> 1) + TEXT_W;
	
	private static final int TABLE_H = DETAIL_PANEL_H >> 1;
	
	private static final int PANEL_H = DETAIL_PANEL_H;
	
	private static final int START_X = ((DETAIL_PANEL_W >> 1) - TABLE_W) >> 1;
	
	private static final int START_Y = START_X >> 1;
	
	private static final int PANEL_W = (DETAIL_PANEL_W >> 1) - (START_X << 1);
	
	public ApprovalFormPanel() {
		//类型标签
		this.typeLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.typeLabel.setFont(WORD_FONT);
		//类型文本
		this.typeText.setBounds(this.typeLabel.getX() + (LABEL_W * 3 >> 1), this.typeLabel.getY(),
				TEXT_W, TEXT_H);
		this.typeText.setFont(WORD_FONT);
		
		this.typeText.addItem("寄件单");
		this.typeText.addItem("装车单");
		this.typeText.addItem("营业厅到达单");
		this.typeText.addItem("收款单");
		this.typeText.addItem("派件单");
		this.typeText.addItem("中转中心到达单");
		this.typeText.addItem("入库单");
		this.typeText.addItem("中转单");
		this.typeText.addItem("出库单");
		this.typeText.addItem("付款单");
		
		this.addTypeItemListener();
		//单据表格
		//审批一张单按钮
		//审批多张单按钮
		//单据详细信息面板
		//把组件添加到主面板
		this.add(this.typeLabel);
		this.add(this.typeText);
		
	}
	
	private void addTypeItemListener() {
		this.typeText.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(form != null) form.setVisible(false);
				//根据用户的选择的表格类型获得相应单据的编号
				String[] date = getDate((String)typeText.getSelectedItem());
				//创建表格
				Object[] names = new Object[]{"单据日期"};
				int dateLen = date.length;
				int formNum = dateLen < 10 ? 10 : dateLen;
				Object[][] datas = new Object[formNum][1];
				for(int i = 0; i < dateLen; i++) {
					datas[i][0] = "1995-4-4";
				}
				form = new JTable(datas, names);
				//设置表格
				container.setBounds(typeLabel.getX(), typeLabel.getY() + (LABEL_H << 1),
						TABLE_W, TABLE_H - 7);
				form.setRowHeight(TABLE_H / (formNum + 1));
				form.setFont(WORD_FONT);
				container.setViewportView(form);
				add(container);
				//刷新面板
				repaint();
			}
		});
	}
	
	private String[] getDate(String type) {
		String[] ids = null;
		int size = 0;
		switch(type) {
		case "寄件单":
			List<OrderVO> order = this.uncheck.getOrderlist();
			size = order.size();
			ids = new String[size];
			for(int i = 0; i < size; i++) {
				ids[i] = order.get(i).getGoodsInfo().getDate();
			}
			return ids;
		case "装车单":
			List<EntruckingVO> entrucking = this.uncheck.getEntruckinglist();
			size = entrucking.size();
			ids = new String[size];
			for(int i = 0; i < size; i++) {
				ids[i] = entrucking.get(i).getDate();
			}
			return ids;
		case "营业厅到达单":
			List<ArrivalFormVO> arrival = this.uncheck.getArrivalformlist();
			size = arrival.size();
			ids = new String[size];
			for(int i = 0; i < size; i++) {
				ids[i] = arrival.get(i).getDate();
			}
			return ids;
		case "收款单":
			List<ReceivableVO> receivable = this.uncheck.getReceivablelist();
			size = receivable.size();
			ids = new String[size];
			for(int i = 0; i < size; i++) {
				ids[i] = receivable.get(i).getDate();
			}
			return ids;
		case "派件单":
			List<SendFormVO> send = this.uncheck.getSendformlist();
			size = send.size();
			ids = new String[size];
			for(int i = 0; i < size; i++) {
				ids[i] = send.get(i).getDate();
			}
			return ids;
		case "中转中心到达单":
			List<ReceivingVO> receiving = this.uncheck.getReceivinglist();
			size = receiving.size();
			ids = new String[size];
			for(int i = 0; i < size; i++) {
				ids[i] = receiving.get(i).getarrivaldate();
			}
			return ids;
		case "入库单":
			List<InRepositoryVO> in = this.uncheck.getInrepositorylist();
			size = in.size();
			ids = new String[size];
			for(int i = 0; i < size; i++) {
				ids[i] = in.get(i).getinrepositorydate();
			}
			return ids;
		case "中转单":
			List<TransferringVO> transferring = this.uncheck.getTransferringlist();
			size = transferring.size();
			ids = new String[size];
			for(int i = 0; i < size; i++) {
				ids[i] = transferring.get(i).getloadingdate();
			}
			return ids;
		case "出库单":
			List<OutRepositoryVO> out = this.uncheck.getOutrepositorylist();
			size = out.size();
			ids = new String[size];
			for(int i = 0; i < size; i++) {
				ids[i] = out.get(i).getoutrepositorydate();
			}
			return ids;
		case "付款单":
			List<PaymentVO> payment = this.uncheck.getPaymentlist();
			size = payment.size();
			ids = new String[size];
			for(int i = 0; i < size; i++) {
				ids[i] = payment.get(i).getDate();
			}
			return ids;
		}
		return null;
	}
	
}
