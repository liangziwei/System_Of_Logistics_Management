package ui.mainui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

public class ExpressFrame extends JFrame{

	/**
	 * 主框架宽度
	 */
	public static final int FRAME_W = 1000;
	
	/**
	 * 主框架高度
	 */
	public static final int FRAME_H = 600;
	
	private static ExpressFrame frame=null;
	
	private ExpressFrame() {
		//主框架

		this.setLayout(null);

		this.setSize(FRAME_W, FRAME_H);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setFrameAtCenter(this);
		this.setUndecorated(true);
		this.setVisible(true);
		
		//处理拖动事件
		 this.addMouseListener(new MouseAdapter() {
		  @Override
		  public void mousePressed(MouseEvent e) {
		  xOld = e.getX();
		  yOld = e.getY();
		  }
		 });
		 this.addMouseMotionListener(new MouseMotionAdapter() {
		  @Override
		  public void mouseDragged(MouseEvent e) {
		  int xOnScreen = e.getXOnScreen();
		  int yOnScreen = e.getYOnScreen();
		  int xx = xOnScreen - xOld;
		  int yy = yOnScreen - yOld;
		  ExpressFrame.this.setLocation(xx, yy);
		  }
		 });
	}
	
	private void setFrameAtCenter(JFrame frame) {
		Toolkit kit=Toolkit.getDefaultToolkit();
	    Dimension screenSize=kit.getScreenSize();
	    int screenWidth=(int) screenSize.getWidth();
	    int screenHeight=(int) screenSize.getHeight();
	    frame.setLocation(screenWidth-frame.getWidth()>>1,
	    		(screenHeight-frame.getHeight()>>1)-32);
	}
	
	
	private static final long serialVersionUID = 1L;
	 //用于处理拖动事件，表示鼠标按下时的坐标，相对于JFrame
	 int xOld = 0;
	 int yOld = 0;
	  
	 public static ExpressFrame getInstance(){
		 if(frame==null){
			 frame=new ExpressFrame();
		 }
		 return frame;
	 }
	
}