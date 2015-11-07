package ui.baseui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class TaskButton extends JButton{
	
	/**
	 *是否被展开 
	 */
	private boolean isUnfold = false;
	
	/**
	 * 展开后的按钮
	 */
	private List<JButton> detailButtons = new ArrayList<JButton>();

	public TaskButton(String name) {
		this.setText(name);
	}

	public boolean isUnfold() {
		return isUnfold;
	}

	public void setUnfold(boolean isUnfold) {
		this.isUnfold = isUnfold;
	}

	public List<JButton> getDetailButtons() {
		return detailButtons;
	}

	public void setDetailButtons(List<JButton> detailButtons) {
		this.detailButtons = detailButtons;
	}
}