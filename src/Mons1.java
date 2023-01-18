
public class Mons1 extends Monster{
	public Mons1(int x, int y, int w, int h, int HP, int hp) {
		super(x, y, w, h, HP, hp);
		// xは中心座標、yは一番下の座標
	}
	
	public void draw(MyFrame2 frame) {
		// HPバーを描写
		frame.setColor(255,153,204);
		frame.fillRect(x-w/2, y+6, w*hp/HP, 3);
		frame.setColor(0, 0, 0);
		frame.fillRect(x-w/2, y+5, w, 2);
		frame.fillRect(x-w/2, y+9, w, 2);
		frame.fillRect(x-w/2, y+5, 2, 5);
		frame.fillRect(x+w/2-2, y+5, 2, 5);

		frame.setColor(255, 192, 203);
		frame.fillOval(x-w/2, y-h, w, h);
		frame.setColor(0,0,0);
		frame.fillOval(x-w/4, y-h/4*3, w/8, h/4); //左目を描写
		frame.fillOval(x+w/8, y-h/4*3, w/8, h/4); //右目を描写
	}
}
