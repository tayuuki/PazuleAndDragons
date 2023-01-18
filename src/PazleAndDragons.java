
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PazleAndDragons extends MyFrame2 implements MouseListener {
	boolean 	check1 = false, check2 = false, check3 = false; //flug
	int 		stage = 0; //ステージ. 最大2まで
	int 		moveTime = 20; //操作時間(s)
	long 		endTime; //ドロップ操作が終了する時間
	int 		combo = 0; //コンボ数
	int			cx, cy;
	

	public void run() {
		final int 	HP = 100000; //プレイヤーの最大HP
		int 		hp = HP; //　プレイヤーの現在のHP
		int 		tmp;
		long 		nowTime; //現在時刻を取得
		int[][] 	list = new int[5][6];
		int[][] 	mons = {{10000,10000}, {20000,20000}, {50000,50000}};
		Drops[][] 	drops = new Drops[5][6];
		Background 	bg = new Background(stage);
		Monster[] 	monster = {new Mons1(180, 250, 170, 170, mons[0][0], mons[0][1]),
				new Mons2(180, 250, 70, 60, mons[1][0], mons[1][1]),
				new Mons3(180, 250, 150, 200, mons[2][0], mons[2][1])};
		Pointer 	pointer = new Pointer(0,340,20,0,0,0,0,true); // ポインターを生成
		
		// ドロップを生成
		 for (int i=0; i<5; i++) {
			 for (int j=0; j<6; j++) {
		 		drops[i][j] = new Drop(0, 340, 60, j, i, (int)(Math.random()*6));
			 }
		}
		
		//その他初期設定
		setSize(360,640);
		addKeyListener(pointer);
		addMouseListener(this);
		
		while(true) {
			clear();
			//1.もしゲームをクリアするか、デスしたら終了(コンティニュー？)
			if (stage==3) {
				// drawString
				break;
			}

			//2.背景を描写 -> 背景の番号をカウントする変数で判定し描写
			bg.stage = stage;
			bg.drawBG(this);

			//3.モンスターを描写
			monster[stage].draw(this);

			//4.HPバーを描写
			bg.drawBar(this, HP, hp);

			//5.ドロップを描写とポインターを描写
			 for (int i=0; i<5; i++) {
				 for (int j=0; j<6; j++) {
					drops[i][j].draw(this);
				 }
			}
			pointer.draw(this);
			// ドロップの入れ替え判定
			if (pointer.index != pointer.cx) {
				tmp = drops[pointer.cy][pointer.cx].c;
				drops[pointer.cy][pointer.cx].c = drops[pointer.indey][pointer.index].c;
				drops[pointer.indey][pointer.index].c = tmp;
				pointer.cx = pointer.index;
			} else if (pointer.indey != pointer.cy) {
				tmp = drops[pointer.cy][pointer.cx].c;
				drops[pointer.cy][pointer.cx].c = drops[pointer.indey][pointer.index].c;
				drops[pointer.indey][pointer.index].c = tmp;
				pointer.cy = pointer.indey;
			}

			//6.マウスをリリースするかタイムアップになった場合checkDropを実行しその後の動作を行う
				if (check1) {
					nowTime = System.currentTimeMillis();
					if (check3) {
						pointer.index = cx;
						pointer.indey = cy;
						pointer.cx = cx;
						pointer.cy = cy;
						pointer.flug = true;
						check3 = false;
					}
					if (endTime <= nowTime|| check2) {
						//コンボを判定し落ちコンを行う
//						list = drop_addDrop(checkDrop(drops));
//						 for (int i=0; i<5; i++) {
//							 for (int j=0; j<6; j++) {
//						 		drops[i][j].c = list[i][j];
//								 System.out.print(list[i][j]);
//							 }
//							 System.out.print("\n");
//						}
						if (combo != 0) 
							monster[stage].hp -= 1000*(int)(Math.pow(1.15, combo)); //モンスターに攻撃
						if (monster[stage].hp < 0) //もしモンスターのhpが負の数なら0にする
							monster[stage].hp = 0;
						check1 = false;
						check2 = false;
						pointer.flug = false;
						setColor(255,255,255);
						drawString("combo "+combo, 0, 325, 50);
						combo = 0;
						sleep(1.5);
						if (monster[stage].hp != 0)
							hp -= monster[stage].HP/5*1;
					}
				}

			//8.もしモンスターが生きていたら、モンスターの攻撃。死んでいたら次のステージへ改善点
			if (monster[stage].hp == 0) {
				stage++;
				hp += HP*((1-hp/HP)/3*2); //ステージクリア時のHP回復
			} else if (hp == 0) {
				stage = -1;
				setColor(255,255,255);
				drawString("GAME OVER", 0, 320, 64);
				return;
			} if (stage == 3) {
				setColor(255,255,255);
				drawString("GAME CLEAR", 0, 320, 60);
				return;
			}
			sleep(0.1);
		}
	}
	
	// 要素が全て6の行列を生成するメソッド
	public int[][] makeMatrix(int x, int y, int num) {
		int[][] temp = new int[y][x];
		
		for (int i=0; i<y; i++) {
			for (int j=0; j<x; j++) {
				temp[i][j] = num;
			}
		}
		return temp;
	}

	// ドロップを落とすメソッド
//	public int[][] drop_addDrop(int[][] list) {
//		// マス目の数を直したら変更する
//		int[][] temp = makeMatrix(6,5,6);
//		int [] i_count = {4, 4, 4, 4, 4, 4} ;
//		
//		for (int i=list.length-1; i>=0; i--) {
//			for (int j=list[i].length-1; j>=0; j--) {
//				if (list[i][j] != 6) {
//					temp[i_count[j]][j] = list[i][j];
//					i_count[j]--;
//				}
//			}
//		}
//		for (int i=list.length-1; i>=0; i--) {
//			for (int j=list[i].length-1; j>=0; j--) {
//				if (temp[i][j] == 6)
//					temp[i][j] = (int)(Math.random()*6);
//			}
//		}
//		return temp;
//	}
	
//	public int[][] checkDrop(Drops[][] list) {
//		int count = 0, heart=0;
//		int[][] temp1 = new int[5][6];
//		int[][] temp2 = new int[5][6];
//		
//		for (int i=0; i<list.length; i++) {
//			for (int j=0; j<list[i].length; j++) {
//				temp1[i][j] = list[i][j].c;
//				temp2[i][j] = list[i][j].c;
//			}
//		}
//		for (int i=0; i<list.length; i++) {
//			for (int j=0; j<list[i].length-2; j++) {
//				if (list[i][j].c == list[i][j+1].c && list[i][j+1].c == list[i][j+2].c) {
//					for (int k=0; k<3; k++) {
//						temp1[i][k] += 7;
//					}
//				}
//			}
//		}
//		for (int i=0; i<list.length-2; i++) {
//			for (int j=0; j<list[i].length; j++) {
//				if (list[i][j].c == list[i+1][j].c && list[i+1][j].c == list[i+2][j].c) {
//					for (int k=0; k<3; k++) {
//						temp2[k][j] += 7;
//					}
//				}
//			}
//		}
//		for (int i=0; i<list.length; i++) {
//			for (int j=0; j<list[i].length; j++) {
//				if (temp1[i][j] <= 5 && temp1[i][j] == temp2[i][j]) {
//					count++;
//				} else {
//					temp1[i][j] = 6;
//				}
//				System.out.print(temp1[i][j]);
//			}
//			System.out.print("\n");
//		}
//		combo = 30 - count;
//		return temp1;
//	}

	public static void main(String[] args) {
		new PazleAndDragons();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		cx = e.getX()/60;
		cy = e.getY();
		
		endTime = System.currentTimeMillis()+moveTime*1000;
		if (cy >= 340) { //エラー処理
			cy = (e.getY()-340)/60;
			check1 = true;
			check3 = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if (check1) {
			check2 = true;
		}
		System.out.println(2);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}