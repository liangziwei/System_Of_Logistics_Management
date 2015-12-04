package ui.managerui.organizationui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.managerController.OrganizationManagementController;
import businessLogic.businessLogicModel.util.CommonLogic;
import businessLogicService.managerBLService.OrganizationManagementBLService;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.managerVO.OrganizationVO;

@SuppressWarnings("serial")
public class AddOrganization extends DetailPanel{
	
	private OrganizationManagementBLService organization = new OrganizationManagementController();

	private JLabel typeLabel = new JLabel("机构类型");
	
	private JComboBox<String> typeText = new JComboBox<String> ();
	
	private JLabel idLabel = new JLabel("机构编号");
	
	private JTextField idText = new JTextField();
	
	private JLabel nameLabel = new JLabel("机构名称");
	
	private JTextField nameText = new JTextField();
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private JLabel tip = new JLabel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	private static final int LABEL_W = 80;
	
	private static final int LABEL_H = 42;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 30;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X >> 1;
	
	public AddOrganization() {
		//机构编号标签
		this.idLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.idLabel.setFont(WORD_FONT);
		//机构编号文本框
		this.idText.setBounds(this.idLabel.getX() + LABEL_W + (START_X >> 1),
				this.idLabel.getY(), TEXT_W, TEXT_H);
		this.idText.setFont(WORD_FONT);
		this.idText.setOpaque(false);
		//机构类型标签
		this.typeLabel.setBounds(this.idLabel.getX(),
				this.idLabel.getY() + LABEL_H + (START_Y >> 1), LABEL_W, LABEL_H);
		this.typeLabel.setFont(WORD_FONT);
		//机构类型文本框
		this.typeText.setBounds(this.idText.getX(), this.typeLabel.getY(), TEXT_W, TEXT_H);
		this.typeText.setFont(WORD_FONT);
		this.typeText.addItem("营业厅");
		this.typeText.addItem("中转中心");
		this.typeText.addItem("总部");
		this.typeText.setOpaque(false);
		//机构名称标签
		this.nameLabel.setBounds(this.typeLabel.getX(),
				this.typeLabel.getY() + LABEL_H + (START_Y  >> 1), LABEL_W, LABEL_H);
		this.nameLabel.setFont(WORD_FONT);
		//机构名称文本框
		this.nameText.setBounds(this.typeText.getX(), this.nameLabel.getY(), TEXT_W, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		this.nameText.setOpaque(false);
		//确定按钮
		this.ok.setBounds(this.nameText.getX() + (TEXT_W >> 1),
				this.nameText.getY() + (TEXT_H << 1), BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W << 1), this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//提示标签
		this.tip.setBounds(this.nameLabel.getX(), this.ok.getY(), LABEL_W, LABEL_H);
		this.tip.setFont(WORD_FONT);
		//将组件添加到面板
		this.add(this.idLabel);
		this.add(this.idText);
		this.add(this.typeLabel);
		this.add(this.typeText);
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.ok);
		this.add(this.cancel);
		this.add(this.tip);
		//增加事件监听
		this.addListener();
	}
	
	private void addListener() {
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//验证输入是否完整 TODO进行跟进一步的信息验证
				tip.setForeground(Color.RED);
				if(CommonLogic.isNull(idText.getText()) || CommonLogic.isNull(nameText.getText())) {
					tip.setText("请把信息填写完整");
					return ;
				}
				//保存信息
				boolean res = organization.addOrganization(new OrganizationVO(typeText.getSelectedItem().toString(),
						idText.getText(), nameText.getText(), false, false));
				//保存成功
				if(res) {
					//清空用户输入
					clearInfo();
					//提示用户保存成功
					tip.setForeground(Color.BLUE);
					tip.setText("保存成功");
				}
				else {
					tip.setForeground(Color.RED);
					tip.setText("保存失败，请稍后重试");
				}
				repaint();
			}
		});
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//清空用户输入的信息
				clearInfo();
				//刷新面板
				repaint();
			}
		});
	}
	
	private void clearInfo() {
		this.idText.setText("");
		this.nameText.setText("");
	}
}
