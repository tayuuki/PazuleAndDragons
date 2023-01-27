
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pointer implements KeyListener {
	int x,y,r,index,indey,cx,cy;
	boolean flug;
	public Pointer(int x, int y, int r, int index, int indey, int cx, int cy, boolean flug) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.index = index;
		this.indey = indey;
		this.cx = cx;
		this.cy = cy;
		this.flug = flug;
	}
	public void draw(MyFrame2 frame) {
		frame.setColor(255,255,255);
		frame.fillOval(x+index*60+r, y+indey*60+r, r, r);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if (flug) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT && index > 0) {
				cx = index;
				index--;
			} if (e.getKeyCode() == KeyEvent.VK_RIGHT && index < 5) {
				cx = index;
				index++;
			} if (e.getKeyCode() == KeyEvent.VK_UP && indey > 0) {
				cy = indey;
				indey--;
			} if (e.getKeyCode() == KeyEvent.VK_DOWN && indey < 4) {
				cy = indey;
				indey++;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
