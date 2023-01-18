
public class Mons2 extends Monster{
	public Mons2(int x, int y, int w, int h, int HP, int hp) {
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
		for (int i=0; i<3; i++) {
			drawMons1(frame, i);
		}
	}
	
	public void drawMons1(MyFrame2 frame, int i) {
		frame.setColor(178, 184, 184);
		frame.fillOval(x-w/2, y-h*(i+1), w, h);
		frame.setColor(0,0,0);
		frame.fillOval(x-w/4, y-h/3*2-(i*h), w/8, h/3); //左目を描写
		frame.fillOval(x+w/8, y-h/3*2-(i*h), w/8, h/3); //右目を描写
	}
}