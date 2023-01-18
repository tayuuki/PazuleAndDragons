
public class Mons3 extends Monster {
	public Mons3(int x, int y, int w, int h, int HP, int hp) {
		super(x, y, w, h, HP, hp);
		// xは中心座標、yは一番下の座標
	}

	public void draw(MyFrame2 frame) {
		// HPバー
		frame.setColor(255,153,204);
		frame.fillRect(x-w/2, y+6, w*hp/HP, 3);
		frame.setColor(0, 0, 0);
		frame.fillRect(x-w/2, y+5, w, 2);
		frame.fillRect(x-w/2, y+9, w, 2);
		frame.fillRect(x-w/2, y+5, 2, 5);
		frame.fillRect(x+w/2-2, y+5, 2, 5);
		
		drawMons1(frame, x, y, w, h/2, 0);
		drawMons1(frame, x, y-h/4*3, w/3, h/4, 1);
		frame.setColor(0,0,0);
		frame.fillRect(x-w/24, y-h/4*3, w/12, h/4);
		frame.fillRect(x-w/6, y-h/16*11, w/3, h/24);
	}

	public void drawMons1(MyFrame2 frame, int x1, int y1, int w1, int h1, int c) {
		if (c == 0)
			frame.setColor(20, 160, 255);
		else if (c == 1)
			frame.setColor(0, 0, 0);
		frame.fillOval(x1 - w1 / 2, y1 - h1, w1, h1);
		if (c == 0)
			frame.setColor(0, 0, 0);
		else if (c == 1)
			frame.setColor(255, 255, 255);
		frame.fillOval(x1 - w1 / 4, y1 - h1 / 4 * 3, w1 / 8, h1 / 4); // 左目を描写
		frame.fillOval(x1 + w1 / 8, y1 - h1 / 4 * 3, w1 / 8, h1 / 4); // 右目を描写
	}
}
