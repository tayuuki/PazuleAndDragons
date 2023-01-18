
public class Background {
	int stage;
	public Background(int stage) {
		this.stage = stage;
	}

	public void drawBG(MyFrame2 frame) {
		if (stage == 0)
			frame.setColor(20, 216, 255); //空色
		else if (stage == 1)
			frame.setColor(200, 200, 200); //城の壁の色
		else if (stage == 2)
			frame.setColor(93, 0, 152); //夜空色
		frame.fillRect(0, 0, 360, 340);
		if (stage == 0)
			frame.setColor(98,120,66); //草色
		else if (stage == 1)
			frame.setColor(240, 50, 50); //城の床の色
		else if (stage == 2)
			frame.setColor(38, 0, 67); //夜空色
		frame.fillOval(-200,180,760, 200);
		for (int i=0; i<6; i++) {
			for (int j=0; j<5; j++) {
				if ((i+j) % 2 == 0)
					frame.setColor(37,22,14);
				else
					frame.setColor(111,75,62);
				frame.fillRect(i*60, 340+j*60, 60, 60);
			}
		}
	}

	public void drawBar(MyFrame2 frame, int HP, int hp) {
		frame.setColor(255,153,204);
		frame.fillRect(0, 325, 360*hp/HP, 15);
		frame.setColor(100,100,100);
		frame.fillRect(0, 325, 360, 4);
		frame.fillRect(0, 336, 360, 4);
		frame.setColor(230,230,230);
		frame.drawString(""+hp+"/"+HP, 240, 338, 14);
	}
}
