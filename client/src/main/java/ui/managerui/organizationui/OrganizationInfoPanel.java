package ui.managerui.organizationui;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;

@SuppressWarnings("serial")
public class OrganizationInfoPanel extends JPanel{

	private JLabel typeLabel = new JLabel("机构类型");
	
	private JComboBox<String> typeText = new JComboBox<String> ();
	
	private JLabel idLabel = new JLabel("机构编号");
	
	private JTextField idText = new JTextField();
	
	private JLabel nameLabel = new JLabel("机构名称");
	
	private JTextField nameText = new JTextField();
	
	private JScrollPane container = new JScrollPane();
	
	private JTable staffInfo = null;
	
	private JPanel orgPanel = new JPanel();
	
	private JLabel tip = new JLabel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private static final int LABEL_W = 50;
	
	private static final int LABEL_H = 42;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	public OrganizationInfoPanel(int x, int y, int w, int h, List<StaffVO> staffVO) {
		//主面板
		this.setBounds(x, y, w, h);
		this.setLayout(null);
		//机构信息面板
		this.initOrganizationPanel(w, h);
		//人员信息面板
		this.initStaffPanel(w, h, staffVO);
	}
	
	public void setOrganizationInfo(OrganizationVO vo) {
		this.idText.setText(vo.getId());
		this.nameText.setText(vo.getName());
		this.typeText.setSelectedItem(vo.getType());
	}
	
	public OrganizationVO createOrganizationVO() {
		return new OrganizationVO((String)this.typeText.getSelectedItem(),
				this.idText.getText(), this.nameText.getText(), false, false);
	}
	
	public void disableStaffInfo() {
		this.staffInfo.setEnabled(false);
	}
	
	public void enableStaffInfo() {
		this.staffInfo.setEnabled(true);
	}
	
	private void initOrganizationPanel(int w, int h) {
		//机构信息面板
		this.orgPanel.setLayout(null);
		this.orgPanel.setBounds(0, 0, w >> 1, h);
		this.add(this.orgPanel);

		//组件起始坐标
		int startX = (this.orgPanel.getWidth() - LABEL_W - TEXT_W) / 3;
		int startY = startX;		
		//标签与标签之间的距离
		int gap = LABEL_H + startY;
		//机构编号标签
		this.idLabel.setBounds(startX, startY, LABEL_W, LABEL_H);
		this.idLabel.setFont(WORD_FONT);
		//机构编号文本框
		this.idText.setBounds(this.idLabel.getX() + LABEL_W + (startX >> 1),
				this.idLabel.getY(), TEXT_W, TEXT_H);
		this.idText.setFont(WORD_FONT);
		//机构类型标签
		this.typeLabel.setBounds(this.idLabel.getX(),
				this.idLabel.getY() + gap, LABEL_W, LABEL_H);
		this.typeLabel.setFont(WORD_FONT);
		//机构类型文本框
		this.typeText.setBounds(this.idText.getX(), this.typeLabel.getY(), TEXT_W, TEXT_H);
		this.typeText.setFont(WORD_FONT);
		this.typeText.addItem("营业厅");
		this.typeText.addItem("中转中心");
		this.typeText.addItem("总部");
		//机构名称标签
		this.nameLabel.setBounds(this.typeLabel.getX(),
				this.typeLabel.getY() + gap, LABEL_W, LABEL_H);
		this.nameLabel.setFont(WORD_FONT);
		//机构名称文本框
		this.nameText.setBounds(this.typeText.getX(), this.nameLabel.getY(), TEXT_W, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		//提示标签
		this.tip.setBounds(this.nameLabel.getX(), this.nameText.getY() + (TEXT_H << 1), LABEL_W, LABEL_H);
		this.tip.setFont(WORD_FONT);
		//将组件添加到机构信息面板
		this.orgPanel.add(this.idLabel);
		this.orgPanel.add(this.idText);
		this.orgPanel.add(this.typeLabel);
		this.orgPanel.add(this.typeText);
		this.orgPanel.add(this.nameLabel);
		this.orgPanel.add(this.nameText);
		this.orgPanel.add(this.tip);
	}
	
	private void initStaffPanel(int w, int h, List<StaffVO> staffVO) {
		//表格容器的边界
		this.container.setBounds((w >> 1) + 2, 0, w >> 1, h);
		this.add(this.container);
		//表格
	    //列名
		Object[] names = new Object[] {
				"人员编号", "姓名", "职位"
		};
		//数据
		int staffNum = staffVO.size();
		int rowNum = staffNum < 14 ? 14 : staffNum;
		Object[][] datas = new Object[rowNum][3];
		StaffVO temp = null;
		for(int i = 0; i < staffNum; i++) {
			temp = staffVO.get(i);
			datas[i][0] = temp.getId();
			datas[i][1] = temp.getName();
			datas[i][2] = temp.getPosition();
		}
		this.staffInfo = new JTable(datas, names);
		int rowH = h >> 4;
		this.staffInfo.setRowHeight(rowH);
		this.staffInfo.setPreferredSize(new Dimension(w >> 1, (rowNum + 1) * rowH));
		this.staffInfo.setFont(WORD_FONT);
		//把把表格加入表格容器
		this.container.setViewportView(this.staffInfo);
	}
}
