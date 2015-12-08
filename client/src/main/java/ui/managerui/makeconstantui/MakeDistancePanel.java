package ui.managerui.makeconstantui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.businessLogicModel.deliveryModel.DistanceIO;
import businessLogic.businessLogicModel.util.CommonLogic;
import constant.City;
import po.deliveryPO.DistanceConstant;
import ui.baseui.DetailPanel;

@SuppressWarnings("serial")
public class MakeDistancePanel extends DetailPanel{
	
	private JTable distance = null;
	
	private JScrollPane container = new JScrollPane();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private JLabel tip = new JLabel();
	
	private static Font WORD_FONT  = new Font("宋体", Font.PLAIN, 18);
	
	private static final int TABLE_W = DETAIL_PANEL_W * 3 >> 2;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 42;
	
	private static final int LABEL_W = BUTTON_W;
	
	private static final int LABEL_H = BUTTON_H;
	
	private static final int START_X = (DETAIL_PANEL_W - TABLE_W) >> 1;
	
	private static final int START_Y = START_X >> 1;
	
	public MakeDistancePanel() {
		//初始化城市距离表
		this.initTable();
		//初始化按钮
		this.initButtons();
		//提示
		this.tip.setBounds(this.container.getX(), this.ok.getY(), LABEL_W << 1, LABEL_H);
		this.tip.setFont(WORD_FONT);
		this.add(this.tip);
	}
	
	private void initTable() {
		//城市距离表格
		Object[] names = new Object[] {
				"出发地", "到达地", "城市距离"
		};
		//数据
		Object[][] datas = new Object[][] {
			{"南京", "北京", DistanceIO.getDistance(City.NAN_JING, City.BEI_JING) + ""},
			{"南京", "上海", DistanceIO.getDistance(City.NAN_JING, City.SHANG_HAI) + ""},
			{"南京", "广州", DistanceIO.getDistance(City.NAN_JING, City.GUANG_ZHOU) + ""},
			{"北京", "上海", DistanceIO.getDistance(City.BEI_JING, City.SHANG_HAI) + ""},
			{"北京", "广州", DistanceIO.getDistance(City.BEI_JING, City.GUANG_ZHOU) + ""},
			{"上海", "广州", DistanceIO.getDistance(City.SHANG_HAI, City.GUANG_ZHOU) + ""},
			{"同城", "同城", DistanceIO.getDistance(City.GUANG_ZHOU, City.GUANG_ZHOU) + ""}
		};
		this.distance = new JTable(datas ,names);
		this.distance.setRowHeight(32);
		this.distance.setFont(WORD_FONT);
		//表格容器
		this.container.setBounds(START_X, START_Y, TABLE_W, 247);
		this.add(this.container);
		this.container.setViewportView(this.distance);
	}
	
	private void initButtons() {
		//确定按钮
		this.ok.setBounds(this.container.getX() + (TABLE_W >> 1), 
				this.container.getY() + this.container.getHeight() + (BUTTON_H * 3 >> 1), BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W << 1), this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		this.cancel.setVisible(false);
		//将按钮添加到面板
		this.add(this.ok);
		this.add(this.cancel);
		//添加事件监听
		this.addButtonListener();
	}
	
	private void addButtonListener() {
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//验证数据的合理性
				boolean isValidate = true;
				int rowNum = distance.getRowCount();
				for(int i = 0; i < rowNum; i++) {
					if(!CommonLogic.isDouble((String)distance.getValueAt(i, 2)))
						isValidate = false;
				}
				//如果通过验证
				if(isValidate) {
					//保存修改
					saveConstant();
					//提示
					tip.setForeground(Color.BLUE);
					tip.setText("修改成功");
				}
				else {
					tip.setForeground(Color.RED);
					tip.setText("输入中含有非数字");
				}
				repaint();
			}
		});
	}
	
	private void saveConstant() {
		double nb = Double.parseDouble((String)distance.getValueAt(0, 2));
		double ns = Double.parseDouble((String)distance.getValueAt(1, 2));
		double ng = Double.parseDouble((String)distance.getValueAt(2, 2));
		double bs = Double.parseDouble((String)distance.getValueAt(3, 2));
		double bg = Double.parseDouble((String)distance.getValueAt(4, 2));
		double sg = Double.parseDouble((String)distance.getValueAt(5, 2));
		double local = Double.parseDouble((String)distance.getValueAt(6, 2));
		
		HashMap<City, Double> nan_jing = new HashMap<City, Double>();
		nan_jing.put(City.NAN_JING, local);
		nan_jing.put(City.BEI_JING, nb);
		nan_jing.put(City.SHANG_HAI, ns);
		nan_jing.put(City.GUANG_ZHOU, ng);
		HashMap<City, Double> bei_jing = new HashMap<City, Double>();
		bei_jing.put(City.NAN_JING, nb);
		bei_jing.put(City.BEI_JING, local);
		bei_jing.put(City.SHANG_HAI, bs);
		bei_jing.put(City.GUANG_ZHOU, bg);
		HashMap<City, Double> shang_hai = new HashMap<City, Double>();
		shang_hai.put(City.NAN_JING, ns);
		shang_hai.put(City.BEI_JING, bs);
		shang_hai.put(City.SHANG_HAI, local);
		shang_hai.put(City.GUANG_ZHOU, sg);
		HashMap<City, Double> guang_zhou = new HashMap<City, Double>();
		guang_zhou.put(City.NAN_JING, ng);
		guang_zhou.put(City.BEI_JING, bg);
		guang_zhou.put(City.SHANG_HAI, sg);
		guang_zhou.put(City.GUANG_ZHOU, local);
		Map<City, HashMap<City, Double>> table = new HashMap<City, HashMap<City, Double>>();
		table.put(City.NAN_JING, nan_jing);
		table.put(City.BEI_JING, bei_jing);
		table.put(City.SHANG_HAI, shang_hai);
		table.put(City.GUANG_ZHOU, guang_zhou);
		
		DistanceConstant d = new DistanceConstant(table);
		DistanceIO.saveDistance(d);
	}
}
