package ui.viewcontroller;

import java.lang.reflect.Constructor;

import javax.swing.JPanel;

import ui.mainui.ExpressFrame;

public class ViewController {
	
	private ExpressFrame frame;
	
	public ViewController(ExpressFrame frame) {
		this.frame = frame;
	}

	public void switchView(String toViewName) {
		try {
			@SuppressWarnings("unchecked")
			Class<JPanel> viewCls = (Class<JPanel>) Class.forName(toViewName);
			Constructor<JPanel> constructor = viewCls.getConstructor(this.getClass());
			JPanel toView = constructor.newInstance(this);
			frame.add(toView);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
