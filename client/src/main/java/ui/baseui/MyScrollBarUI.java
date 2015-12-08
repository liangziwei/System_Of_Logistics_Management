package ui.baseui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalScrollBarUI;

public class MyScrollBarUI extends MetalScrollBarUI{

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		super.paintThumb(g, c, thumbBounds);
		g.translate(thumbBounds.x, thumbBounds.y);
		// 设置把手颜色
		g.setColor(Color.BLACK);
		// 画一个圆角矩形
		g.drawRoundRect(5, 0, 6, thumbBounds.height-1, 5, 5);
		// 消除锯齿
		Graphics2D g2 = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.addRenderingHints(rh);
		// 半透明
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
		// 设置填充颜色，这里设置了渐变，由下往上
		 g2.setPaint(new GradientPaint(c.getWidth() / 2, 1, Color.GRAY, c.getWidth() / 2, c.getHeight(), Color.GRAY));
		// 填充圆角矩形
		g2.fillRoundRect(5, 0, 6, thumbBounds.height-1, 5, 5);

	}
}
