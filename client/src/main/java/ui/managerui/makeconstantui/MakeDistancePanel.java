package ui.managerui.makeconstantui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.businessLogicController.managerController.MakeConstantController;
import businessLogic.businessLogicModel.util.CommonLogic;
import businessLogicService.managerBLService.MakeConstantBLService;
import constant.City;
import po.constant.DistanceItem;
import po.constant.DistanceTable;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;

@SuppressWarnings("serial")
public class MakeDistancePanel extends DetailPanel{
	
	private MakeConstantBLService makeDistance = new MakeConstantController();
	
	/**
	 *城市距离表 
	 */
	private Map<City, HashMap<City, Double>> distanceTable = new HashMap<City, HashMap<City, Double>>();
	
	private JTable distance = null;
	
	private JScrollPane container = new JScrollPane();
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private JLabel tip = new JLabel();
	
	private static Font WORD_FONT  = new Font("宋体", Font.PLAIN, 18);
	
	private static final int TABLE_W = DETAIL_PANEL_W * 3 >> 2;
	
	private static final int BUTTON_W = 140;
	
	private static final int BUTTON_H = 42;
	
	private static final int LABEL_W = BUTTON_W;
	
	private static final int LABEL_H = BUTTON_H;
	
	private static final int START_X = (DETAIL_PANEL_W - TABLE_W) >> 1;
	
	private static final int START_Y = START_X >> 1;
	
	public MakeDistancePanel() {
		//初始化城市距离表数据
		this.distanceTable = this.makeDistance.getDistance();
		//创建城市距离表界面
		this.createTableUI();
		//初始化按钮
		this.initButtons();
		//提示
		this.tip.setBounds(this.container.getX(), this.ok.getY(), LABEL_W << 1, LABEL_H);
		this.tip.setFont(WORD_FONT);
		this.add(this.tip);
	}
	
	/**
	 * 创建城市距离表界面
	 */
	private void createTableUI() {
		//城市距离表格
		Object[] names = new Object[] {
				"出发地", "到达地", "城市距离"
		};
		//数据
		Object[][] datas = new Object[][] {
			{"南京", "北京", this.distanceTable.get(City.NAN_JING).get(City.BEI_JING) + ""},
			{"南京", "上海", this.distanceTable.get(City.NAN_JING).get(City.SHANG_HAI) + ""},
			{"南京", "广州", this.distanceTable.get(City.NAN_JING).get(City.GUANG_ZHOU) + ""},
			{"北京", "上海", this.distanceTable.get(City.BEI_JING).get(City.SHANG_HAI) + ""},
			{"北京", "广州", this.distanceTable.get(City.BEI_JING).get(City.GUANG_ZHOU) + ""},
			{"上海", "广州", this.distanceTable.get(City.SHANG_HAI).get(City.GUANG_ZHOU) + ""},
			{"同城", "同城", this.distanceTable.get(City.GUANG_ZHOU).get(City.GUANG_ZHOU) + ""}
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
		this.ok.setBounds(this.container.getX() + (TABLE_W >> 1) - (BUTTON_W >> 1), 
				this.container.getY() + this.container.getHeight() + (BUTTON_H * 3 >> 1), BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//将按钮添加到面板
		this.add(this.ok);
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
					String val = (String) distance.getValueAt(i, 2);
					if(!CommonLogic.isDouble(val))
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
		//从表格获得各城市之间的距离
		double nb = Double.parseDouble((String)distance.getValueAt(0, 2));		//南京-北京
		double ns = Double.parseDouble((String)distance.getValueAt(1, 2));		//南京-上海
		double ng = Double.parseDouble((String)distance.getValueAt(2, 2));		//南京-广州
		double bs = Double.parseDouble((String)distance.getValueAt(3, 2));		//北京-上海
		double bg = Double.parseDouble((String)distance.getValueAt(4, 2));		//北京-广州
		double sg = Double.parseDouble((String)distance.getValueAt(5, 2));		//上海-广州
		double local = Double.parseDouble((String)distance.getValueAt(6, 2));	//本地营业厅之间的距离
		
		//创建城市距离表
		DistanceTable d = new DistanceTable();
		//本地营业厅之间的距离
		d.setCityItem(new DistanceItem(City.NAN_JING, City.NAN_JING, local));
		//南京-北京
		d.setCityItem(new DistanceItem(City.NAN_JING, City.BEI_JING, nb));
		//南京-上海
		d.setCityItem(new DistanceItem(City.NAN_JING, City.SHANG_HAI, ns));
		//南京-广州
		d.setCityItem(new DistanceItem(City.NAN_JING, City.GUANG_ZHOU, ng));
		//北京-上海
		d.setCityItem(new DistanceItem(City.BEI_JING, City.SHANG_HAI, bs));
		//北京-广州
		d.setCityItem(new DistanceItem(City.BEI_JING, City.GUANG_ZHOU, bg));
		//上海-广州
		d.setCityItem(new DistanceItem(City.SHANG_HAI, City.GUANG_ZHOU, sg));
		
		//保存城市距离表
		this.makeDistance.setDistance(d);
	}
}
