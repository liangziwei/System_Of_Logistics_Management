package ui.financeui.originalInfoui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import ui.baseui.DetailPanel;

import ui.baseui.LimpidButton;

import businessLogic.businessLogicController.financeController.OriginalInfoController;


@SuppressWarnings("serial")
public class OriginalInfoPanel extends DetailPanel{
	
	private OriginalInfoController originalInfoCon;
	
	private JLabel query=new JLabel("历史建账信息");
	
	private JLabel OriginizationLabel=new JLabel("机构");
	private JLabel staffLabel=new JLabel("人员");
	private JLabel vehicleLabel=new JLabel("车辆");
	private JLabel storeLabel=new JLabel("库存");
	private JLabel accountLabel=new JLabel("银行账户");
	
	private JScrollPane panel=new JScrollPane ();
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private static final int LABEL_W=120;
	private static final int LABEL_H=20;
	private static final int START_X=20;
	private static final int START_Y=20;
	private static final int RowHeight=20;
	private static final int TABEL_W = DETAIL_PANEL_W - 80;
	
	private static final int TABEL_H = DETAIL_PANEL_H -150;
	
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 30;
	
	public OriginalInfoPanel() {
		// TODO Auto-generated constructor stub
		OriginizationLabel.setBounds(START_X<<2, START_Y, LABEL_W, LABEL_H);
		OriginizationLabel.setFont(WORD_FONT);
		
		staffLabel.setBounds(OriginizationLabel.getX()+LABEL_W, START_Y, LABEL_W, LABEL_H);
		staffLabel.setFont(WORD_FONT);
		
		vehicleLabel.setBounds(staffLabel.getX()+LABEL_W, START_Y, LABEL_W, LABEL_H);
		vehicleLabel.setFont(WORD_FONT);
		
		storeLabel.setBounds(vehicleLabel.getX()+LABEL_W, START_Y, LABEL_W, LABEL_H);
		storeLabel.setFont(WORD_FONT);
		
		accountLabel.setBounds(storeLabel.getX()+LABEL_W, START_Y, LABEL_W, LABEL_H);
		accountLabel.setFont(WORD_FONT);
			
		ok.setBounds(START_X<<4, START_Y+TABEL_H+30,BUTTON_W , BUTTON_H);
		ok.setFont(WORD_FONT);
		
		cancel.setBounds(ok.getX()+BUTTON_W+20, ok.getY(),BUTTON_W , BUTTON_H);
		cancel.setFont(WORD_FONT);
		
		addComponents();
		addListener();
		repaint();
	}
	
	//创建机构信息的表
	private void createOriginizationTable(){
		String[] name = {"机构编号", "机构类型","机构名称"};
		Object[][] datas ={{"025001001","营业厅","茗柯"},{"025001001","营业厅","茗柯"},{"025001001","营业厅","茗柯营业厅"}};
		createTable(datas,name);

	}
	//创建人员信息的表
	private void createStaffTable(){
		String[] name = {"ID", "姓名","性别","职位","年龄","薪水"};
		Object[][] datas ={{"025001001","茗柯","男","秘书","33","123456"},{"025001001","茗柯1","男","经理","33","1234567"}};
		createTable(datas,name);

	}
	//创建车辆信息的表
	private void createVehicleTable(){
		String[] name = {"车辆代号", "车牌号","服役时间"};
		Object[][] datas ={{"025001001","苏A 12345","5"},{"025001001","苏A 54321","11"}};
		createTable(datas,name);
	}
	
	//创建库存信息的表
	private void createStoreTable(){
		String[] name = {"快递编号", "入库日期","目的地","区号","排号","架号","位号"};
		Object[][] datas ={{"1234567890","2015-11-11","北京","A","22","11","22"},{"1234567891","2015-11-11","北京","A","22","11","33"}};
		createTable(datas,name);
	}
	
	//创建银行账户的表
	private void createAccountTable(){
		String[] name = {"账户名称", "账户余额"};
		Object[][] datas={{"茗柯110","122222"},{"茗柯111","1111111"}};
		createTable(datas,name);

	}
	
	private void createTable(Object[][] datas,String[] name){
		JTable table=new JTable(datas,name);
		table.setFont(WORD_FONT);
		table.setRowHeight (RowHeight);//设置每行的高度为20
		table.setRowMargin (5);//设置相邻两行单元格的距离
//		table.setSelectionBackground (Color.white);//设置所选择行的背景色
		table.setSelectionForeground (Color.red);//设置所选择行的前景色
		table.setGridColor (Color.black);//设置网格线的颜色
		table.doLayout (); 
		
		//设置透明
		table.setOpaque(false);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();  
		renderer.setOpaque(false);//render单元格的属性
		
		JTableHeader header = table.getTableHeader();//获取头部     
        header.setOpaque(false);//设置头部为透明  
        header.getTable().setOpaque(false);//设置头部里面的表格透明 
//		header.setDefaultRenderer(renderer);
		header.setBackground(Color.BLUE);
//		TableCellRenderer headerRenderer = header.getDefaultRenderer();   
//        if (headerRenderer instanceof JLabel){  
//            ((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);   
//            ((JLabel) headerRenderer).setOpaque(false);   
//        } 
		for(int i = 0 ; i < name.length ; i ++){  
		    table.getColumn(name[i]).setCellRenderer(renderer);  
		}  
		
		this.remove(panel);
		panel = new JScrollPane (table);
		panel.setOpaque(false);
		panel.getViewport().setOpaque(false);
		
		panel.setColumnHeaderView(table.getTableHeader());
		panel.getColumnHeader().setOpaque(false);
		panel.setBounds(START_X<<1, START_Y<<1, TABEL_W, TABEL_H);
		panel.setVisible(true);
		this.add(panel);
	}
	
	private void addListener(){
		this.OriginizationLabel.addMouseListener(new  MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				createOriginizationTable();
				repaint();
			}		
		});
		
		this.staffLabel.addMouseListener(new  MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				createStaffTable();
				repaint();
			}		
		});
		
		this.vehicleLabel.addMouseListener(new  MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				createVehicleTable();
				repaint();
			}		
		});
		
		this.storeLabel.addMouseListener(new  MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				createStoreTable();
				repaint();
			}		
		});
		
		this.accountLabel.addMouseListener(new  MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				createAccountTable();
				repaint();
			}		
		});
		
	}
	
	private void addComponents(){
		this.add(OriginizationLabel);
		this.add(staffLabel);
		this.add(vehicleLabel);
		this.add(storeLabel);
		this.add(accountLabel);
		
		this.add(ok);
		this.add(cancel);
		
		this.add(panel);
		
	}
	
}
