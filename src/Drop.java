
public class Drop extends Drops {
	public Drop(int x, int y, int r, int index, int indey, int c) {
		super(x, y, r, index, indey, c);
	}
	
	public void draw(MyFrame2 frame) {
		if (c == 0) //赤
			frame.setColor(255,0,0);
		else if (c == 1) //緑
			frame.setColor(0,255,0);
		else if (c == 2) //青
			frame.setColor(0,0,255);
		else if (c == 3) //黄
			frame.setColor(255,255,0);
		else if (c == 4) //紫
			frame.setColor(128,0,128);
		else if (c == 5) { //回復
			frame.setColor(255,153,204);
			frame.fillRect(x+index*r+2, y+indey*r+2, r-4, r-4);
			return;
		}
		frame.fillOval(x+index*r, y+indey*r, r, r); //dropを描画
	}

	
	// 消えるか判定する
	public int checkDrop(int[][] list) {
		int combo = 0, count = 0;
		
		for (int i=0; i<list.length; i++) {
			for (int j=0; j<list[i].length; j++) {
				// 横の判定
				for (int k=0; k<list[i].length; k++) {
					if (list[i][k] == list[i][k+1]) {
						count++;
					} else {
						if (count >= 3) {
							combo++;
							break;
						}
						count=0;
					}
				}
				// 縦の判定
				
			}
		}
		return combo;
	}
}






