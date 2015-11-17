package ui.transitionui.loadingui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.transitionController.LoadingController;
import businessLogicService.transitionBLService.LoadingBLService;
import ui.baseui.DetailPanel;

public class ModifyLoadingPanel1 extends DetailPanel{
	private LoadingBLService loadingservice = new LoadingController();
	
	private JLabel loadingid = new JLabel("装运编号");
	
	private JTextField loadingidText = new JTextField(11);
	
	private JButton find = new JButton("查询");
	
	private JButton cancle = new JButton("取消");
	
	public ModifyLoadingPanel1() {
		// TODO Auto-generated constructor stub
		super();
		
		loadingid.setBounds(AddLoadingPanel.START_X, AddLoadingPanel.START_Y, AddLoadingPanel.LABEL_W, AddLoadingPanel.LABEL_H);
		this.container.add(this.loadingid);
		loadingidText.setBounds(loadingid.getX()+loadingid.getWidth()+AddLoadingPanel.COMPONENT_GAP_X,loadingid.getY(),
				AddLoadingPanel.TEXTid_W,AddLoadingPanel.TEXT_H);
		this.container.add(this.loadingidText);
		find.setBounds(loadingidText.getX()+loadingidText.getWidth()+AddLoadingPanel.COMPONENT_GAP_X,loadingid.getY(),
				AddLoadingPanel.LABEL_W, AddLoadingPanel.LABEL_H);
		this.container.add(find);
		cancle.setBounds(find.getX()+find.getWidth()+AddLoadingPanel.COMPONENT_GAP_X, loadingid.getY(), 
				AddLoadingPanel.LABEL_W, AddLoadingPanel.LABEL_H);
		this.container.add(cancle);
		
		//添加事件监听
		this.addListener();
	}
	
	public void addListener() {
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		cancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
}
