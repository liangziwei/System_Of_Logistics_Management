package ui.businessui.entruckingui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.businessVO.EntruckingVO;
import businessLogic.businessLogicController.businessController.EntruckingController;
import businessLogic.businessLogicModel.util.CommonLogic;
import businessLogicService.businessBLService.EntruckingBLService;

@SuppressWarnings("serial")
public class EntruckingPanel extends DetailPanel {

	EntruckingVO entruckingVO;

	EntruckingBLService entruckingCon = new EntruckingController();

	private DateChooser dateChoose = DateChooser.getInstance();

	// 添加下拉框
	private JScrollPane jScrollPane = new JScrollPane();
	private JPanel container = new JPanel();
	// 组件
	private JLabel date = new JLabel("装车日期");
	private JLabel businessHallid = new JLabel("营业厅编号");
	private JLabel transportNumber = new JLabel("汽运编号");
	private JLabel destionation = new JLabel("到达地");
	private JLabel vehicleid = new JLabel("车辆代号");
	private JLabel supervisor = new JLabel("监装员");// 监装员
	private JLabel supercargo = new JLabel("押运员");// 押运员
	private JLabel freight = new JLabel("运费");// 运费
	private JLabel alldeliveryid = new JLabel("本次装箱所有订单条形码号");

	private JLabel result = new JLabel();

	private JTextField dateText = new JTextField();
	private JTextField businessHallidText = new JTextField("");
	private JTextField transportNumberText = new JTextField("");
	private JTextField destionationText = new JTextField("");
	private JTextField vehicleidText = new JTextField("");
	private JTextField supervisorText = new JTextField("");// 监装员
	private JTextField supercargoText = new JTextField("");// 押运员
	private JTextField freightText = new JTextField("");// 运费
	private JTextArea alldeliveryidArea = new JTextArea("");

	private LimpidButton ok = new LimpidButton("", "picture/确定.png");

	private LimpidButton cancel = new LimpidButton("", "picture/取消.png");

	private static final int LABEL_W = 100;

	private static final int LABEL_H = 25;

	/**
	 * 每行信息之间的间隔
	 */
	private static final int LINE_GAP = 18;

	private static final int TEXT_W = LABEL_W * 3;

	private static final int TEXT_H = LABEL_H;

	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;

	private static final int START_Y = START_X >> 1;

	private static final int BUTTON_W = LABEL_W;

	private static final int BUTTON_H = LABEL_H + 5;

	private static final Font WORD_FONT = new Font("宋体", Font.PLAIN, 18);

	private boolean isFirstEnsure = true;

	private boolean isOver = false;

	public EntruckingPanel() {
		super();
		//下拉框设置
		container.setLayout(null);
		container.setPreferredSize(new Dimension(CONTAINER_W, CONTAINER_H));
		container.setOpaque(false);
		jScrollPane.setBounds(0, 0,DETAIL_PANEL_W, DETAIL_PANEL_H);
		jScrollPane.setViewportView(this.container);
		jScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		jScrollPane.getViewport().setOpaque(false);
		jScrollPane.setOpaque(false);
		super.add(jScrollPane);
		
		this.date.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.date.setFont(WORD_FONT);
		this.dateText.setBounds(START_X + LABEL_W + LINE_GAP, START_Y, TEXT_W, TEXT_H);
		this.dateText.setFont(WORD_FONT);
		dateChoose.register(dateText);
		this.dateText.setOpaque(false);

		this.businessHallid.setBounds(START_X, START_Y + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.businessHallid.setFont(WORD_FONT);
		this.businessHallidText.setBounds(this.dateText.getX(), this.businessHallid.getY(), TEXT_W, TEXT_H);
		this.businessHallidText.setFont(WORD_FONT);
		this.businessHallidText.setOpaque(false);

		this.transportNumber.setBounds(START_X, this.businessHallid.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.transportNumber.setFont(WORD_FONT);
		this.transportNumberText.setBounds(this.dateText.getX(), this.transportNumber.getY(), TEXT_W, TEXT_H);
		this.transportNumberText.setFont(WORD_FONT);
		this.transportNumberText.setOpaque(false);

		this.destionation.setBounds(START_X, this.transportNumber.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.destionation.setFont(WORD_FONT);
		this.destionationText.setBounds(this.dateText.getX(), this.destionation.getY(), TEXT_W, TEXT_H);
		this.destionationText.setFont(WORD_FONT);
		this.destionationText.setOpaque(false);

		this.vehicleid.setBounds(START_X, this.destionation.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.vehicleid.setFont(WORD_FONT);
		this.vehicleidText.setBounds(this.dateText.getX(), this.vehicleid.getY(), TEXT_W, TEXT_H);
		this.vehicleidText.setFont(WORD_FONT);
		this.vehicleidText.setOpaque(false);

		this.supervisor.setBounds(START_X, this.vehicleid.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.supervisor.setFont(WORD_FONT);
		this.supervisorText.setBounds(this.dateText.getX(), this.supervisor.getY(), TEXT_W, TEXT_H);
		this.supervisorText.setFont(WORD_FONT);
		this.supervisorText.setOpaque(false);

		this.supercargo.setBounds(START_X, this.supervisor.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.supercargo.setFont(WORD_FONT);
		this.supercargoText.setBounds(this.dateText.getX(), this.supercargo.getY(), TEXT_W, TEXT_H);
		this.supercargoText.setFont(WORD_FONT);
		this.supercargoText.setOpaque(false);

		this.freight.setBounds(START_X, this.supercargo.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.freight.setFont(WORD_FONT);
		this.freightText.setBounds(this.dateText.getX(), this.freight.getY(), TEXT_W, TEXT_H);
		this.freightText.setFont(WORD_FONT);
		this.freightText.setText(String.valueOf(entruckingCon.getFreight()));
		this.freightText.setOpaque(false);
		
		alldeliveryid.setBounds(freight.getX(), freight.getY()+freight.getHeight()+LABEL_H, LABEL_W*3,LABEL_H);
		alldeliveryid.setFont(WORD_FONT);
		alldeliveryidArea.setFont(WORD_FONT);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(alldeliveryid.getX(), alldeliveryid.getY()+alldeliveryid.getHeight(), TEXT_W/2*3,TEXT_H*7);
		scrollPane.setViewportView(alldeliveryidArea);
		this.container.add(scrollPane);

		this.result.setBounds(scrollPane.getX() + LINE_GAP, scrollPane.getY()+scrollPane.getHeight() + LINE_GAP, TEXT_W, TEXT_H);
		this.setFont(WORD_FONT);
		this.result.setText("");

		// 确定按钮
		this.ok.setBounds(result.getX() + TEXT_W, result.getY() + LABEL_H + LINE_GAP, BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		// this.ok.setText("确认");
		// this.ok.setIcon(new ImageIcon("picture/确认.png"));

		// 取消按钮
		this.cancel.setBounds(this.ok.getX() + BUTTON_W + LINE_GAP, this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		this.cancel.setVisible(false);
		// 错误提示
		// 添加事件监听
		this.addListener();
		// 将组件添加到主面板
		this.addComponents();
	}

	private void addListener() {

		this.ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// 验证收件信息是否合法
				if (isFirstEnsure) {
					if (isCorrect()) {
						result.setForeground(Color.BLUE);
						result.setText("请确认信息输入无误，确认后点击提交");
						// ok.setText("提交");
						ok.setIcon(new ImageIcon("picture/提交.png"));
						disablePanel();
						isFirstEnsure = false;
					} else {
						result.setForeground(Color.RED);
						disablePanel();
						// ok.setEnabled(false);
						result.setText("信息输入格式有错误，请重新输入");
					}

					cancel.setVisible(true);
				} else {

					if (isOver) {
						result.setText("");
						setblack();
						enablePanel();
						isFirstEnsure = true;
						isOver = false;
					} else {
						String dateStr = dateText.getText();
						String businessIDStr = businessHallidText.getText();
						String transNumberStr = transportNumberText.getText();
						String destStr = destionationText.getText();
						String vehiStr = vehicleidText.getText();
						String supervisorStr = supervisorText.getText();// 监装员
						String supercargoStr = supercargoText.getText();
						String freightStr = freightText.getText();
						
						List<String> all = new ArrayList<String>();
						String alldeli = alldeliveryidArea.getText();
							String[] alldeli1 = alldeli.split("\n");
							for(String q:alldeli1){
								all.add(q);
							}

						entruckingVO = new EntruckingVO(dateStr, businessIDStr, transNumberStr, destStr, vehiStr,
								supervisorStr, supercargoStr, Double.parseDouble(freightStr));
						entruckingVO.setDeliveryIDList(all);
						if (entruckingCon.addEntruckingFrom(entruckingVO)) {
							result.setForeground(Color.GREEN);
							result.setText("保存成功！");
							// ok.setText("确认");
							ok.setIcon(new ImageIcon("picture/确认.png"));
							cancel.setVisible(false);
							isOver = true;

						} else {
							result.setForeground(Color.RED);
							result.setText("信息有误，保存失败");
						}

					}
				}
				repaint();
			}
		});

		// 取消按钮
		this.cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// 设置取消按钮不可见
				if (ok.getText().equals("提交")) {
					ok.setText("确定");
					cancel.setVisible(false);
					enablePanel();
					isFirstEnsure = true;
					result.setText("");
				} else {
					cancel.setVisible(false);

					// 设置状态为第一次点击确定按钮
					isFirstEnsure = true;
					// 使组件可编辑
					enablePanel();
					// 消除提示信息
					result.setText("");

				}
				repaint();
			}
		});
	}

	private void addComponents() {
		this.container.add(date);
		this.container.add(dateText);
		this.container.add(businessHallid);
		this.container.add(businessHallidText);
		this.container.add(destionation);
		this.container.add(destionationText);
		this.container.add(transportNumber);
		this.container.add(transportNumberText);
		this.container.add(supercargo);
		this.container.add(supercargoText);
		this.container.add(supervisor);
		this.container.add(supervisorText);
		this.container.add(freight);
		this.container.add(freightText);
		this.container.add(vehicleid);
		this.container.add(vehicleidText);
		this.container.add(alldeliveryid);
//		this.container.add(alldeliveryidArea);
		this.container.add(result);
		this.container.add(ok);
		this.container.add(cancel);
	}

	private boolean isCorrect() {

		String dateStr = dateText.getText();
		String businessIDStr = businessHallidText.getText();
		String transNumberStr = transportNumberText.getText();
		String vehiStr = vehicleidText.getText();

		if (!CommonLogic.isDate(dateStr)) {
			dateText.setText("");
			return false;
		} else if (!businessIDStr.matches("\\d{6}")) {
			businessHallidText.setText("");
			return false;
		} else if (!transNumberStr.matches("\\d{19}")) {
			transportNumberText.setText("");
			return false;
		} else if (!vehiStr.matches("\\d{9}")) {
			vehicleidText.setText("");
			return false;
		}
			String alldeli = alldeliveryidArea.getText();
			String[] alldeli1 = alldeli.split("\n");
			for(String q:alldeli1){
				if(!q.matches("\\d{10}")){
					return false;
				}
			}

		return true;
	}

	private void disablePanel() {
		this.dateText.setEditable(false);
		this.businessHallidText.setEditable(false);
		this.transportNumberText.setEditable(false);
		this.destionationText.setEditable(false);
		this.supercargoText.setEditable(false);
		this.supervisorText.setEditable(false);
		this.freightText.setEditable(false);
		this.vehicleidText.setEditable(false);
		this.alldeliveryidArea.setEditable(false);
	}

	private void enablePanel() {
		this.dateText.setEditable(true);
		this.businessHallidText.setEditable(true);
		this.transportNumberText.setEditable(true);
		this.destionationText.setEditable(true);
		this.supercargoText.setEditable(true);
		this.supervisorText.setEditable(true);
		this.freightText.setEditable(true);
		this.vehicleidText.setEditable(true);
		this.alldeliveryidArea.setEditable(true);
	}

	private void setblack() {
		this.dateText.setText("");
		this.businessHallidText.setText("");
		this.transportNumberText.setText("");
		this.destionationText.setText("");
		this.supercargoText.setText("");
		this.supervisorText.setText("");
		// this.freightText.setText("");
		this.vehicleidText.setText("");
		this.alldeliveryidArea.setText("");
	}
}
