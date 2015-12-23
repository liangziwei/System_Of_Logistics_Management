package ui.repositoryui.outRep;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ui.baseui.DetailPanel;
import vo.transitionVO.TransferringVO;

public class TransferPanel extends JPanel {
	// transferring面板上的组件
	private JLabel wayid = new JLabel("装运方式编号");
	private JLabel departureid = new JLabel("出发地");
	private JLabel arrivalid = new JLabel("目的地");
	private JLabel supervisionid = new JLabel("监装员");
	private JLabel containerid = new JLabel("货柜号");
	private JLabel alldeliveryid = new JLabel("本次装箱所有托运单号");
	private JTextField wayidText = new JTextField();
	private JTextField departureidText = new JTextField();
	private JTextField arrivalidText = new JTextField();
	private JTextField supervisionidText = new JTextField();
	private JTextField containeridText = new JTextField();
	private JTextArea alldeliveryidText = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane(alldeliveryidText);

	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);

	public static final int LABEL_W = 80;
	public static final int LABEL_H = 40;
	public static final int TEXT_W = LABEL_W << 1;
	public static final int TEXT_H = LABEL_H;
	public static final int TEXTid_W = LABEL_W * 4;
	public static final int COMPONENT_GAP_X = 30;
	public static final int COMPONENT_GAP_Y = COMPONENT_GAP_X << 1;
	public static final int Area_W = LABEL_W * 7;
	public static final int Area_H = LABEL_H * 6;

	public TransferPanel(TransferringVO transferringVO, int x, int y, int W, int H) {
		// TODO Auto-generated constructor stub
		// 初始化组件
		int labelW = W / 5;
		int labelH = labelW >> 1;
		int textW = labelW * 3;
		int textH = labelH;
		int Start_x = labelW >> 1;
		int Start_y = 0;
		int theGap = labelW >> 1; // 标签与文本框的距离
		// 装运方式编号
		wayid.setBounds(Start_x, Start_y, labelW, labelH);
		wayid.setFont(WORD_FONT);
		wayidText.setBounds(wayid.getX() + wayid.getWidth() + theGap, wayid.getY(), textW, textH);
		wayidText.setOpaque(false);
		wayidText.setText(transferringVO.getwayid());

		// 出发地
		departureid.setBounds(wayid.getX(), wayid.getY() + wayid.getHeight() + theGap-20, labelW / 2, labelH);
		departureid.setFont(WORD_FONT);
		departureidText.setBounds(departureid.getX() + departureid.getWidth() + COMPONENT_GAP_X, departureid.getY(),
				textW / 3, textH);
		departureidText.setOpaque(false);
		departureidText.setText(transferringVO.getdepartureid());
		// 到达地
		arrivalid.setBounds(departureidText.getX() + departureidText.getWidth() + theGap, departureidText.getY(),
				labelW / 2, labelH);
		arrivalid.setFont(WORD_FONT);
		arrivalidText.setBounds(arrivalid.getX() + arrivalid.getWidth() + COMPONENT_GAP_X, arrivalid.getY(), textW / 3,
				textH);
		arrivalidText.setOpaque(false);
		arrivalidText.setText(transferringVO.getarrivalid());
		// 监装员
		supervisionid.setBounds(departureid.getX(), departureid.getY()+departureid.getHeight()+theGap-20, labelW/2, labelH);
		supervisionid.setFont(WORD_FONT);
		supervisionidText.setBounds(supervisionid.getX()+supervisionid.getWidth()+COMPONENT_GAP_X,supervisionid.getY(),textW/3,textH);
		supervisionidText.setOpaque(false);
		supervisionidText.setText(transferringVO.getsupervisionid());
		// 货柜号
		containerid.setBounds(supervisionidText.getX()+supervisionidText.getWidth()+theGap, supervisionid.getY(), labelW/2, labelH);
		containerid.setFont(WORD_FONT);
		containeridText.setBounds(containerid.getX()+containerid.getWidth()+COMPONENT_GAP_X, containerid.getY(), textW/3, textH);
		containeridText.setOpaque(false);
		containeridText.setText(transferringVO.getcontainerid());
		// 所有托运单号
		alldeliveryid.setBounds(supervisionid.getX(), supervisionid.getY()+supervisionid.getHeight()+theGap-20, textW, labelH);
		alldeliveryid.setFont(WORD_FONT);
		scrollPane.setBounds(alldeliveryid.getX(),alldeliveryid.getY()+alldeliveryid.getHeight()+5,textW+labelW,textH*3);
		scrollPane.setViewportView(alldeliveryidText);
		scrollPane.setOpaque(false);
		alldeliveryidText.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		alldeliveryidText.setFont(WORD_FONT);
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		for(String allDEL:(transferringVO.getalldeliveryid())){
			alldeliveryidText.append(allDEL+"\n");
		}
		
		//相关组件不可编辑
		alldeliveryidText.setEditable(false);
		wayidText.setEditable(false);
		departureidText.setEditable(false);
		arrivalidText.setEditable(false);
		supervisionidText.setEditable(false);
		containeridText.setEditable(false);
		// 将组件添加到面板
		this.setBounds(x, y, W, H);
		this.setLayout(null);
		this.add(wayid);
		this.add(wayidText);
		this.add(departureid);
		this.add(departureidText);
		this.add(arrivalid);
		this.add(arrivalidText);
		this.add(supervisionid);
		this.add(supervisionidText);
		this.add(containerid);
		this.add(containeridText);
		this.add(alldeliveryid);
		this.add(scrollPane);
	}
}
