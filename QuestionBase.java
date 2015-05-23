import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class QuestionBase {
	public static String Q; // a question
	public static String[] C = new String[4]; // The four choice of a question
	public static int KEY; // The answer of a question 
	public static Image image; // The image of a question 
	QuestionBase(){
		
	}
	
	//Set Random question from question base. 
	public static void question(int RandomQuestion){
		
		switch(RandomQuestion){
		
		case 0:
			Q = "植物激素的運輸，下列何者最合理?";
			C[0] = "完全由木質部運輸 ";
			C[1] = "完全由韌皮部運輸 ";
			C[2] = "完全由擴散作用運輸 ";
			C[3] = "因種類不同而由不同方式運輸 ";
			KEY = 3;
			break;
			
		case 1:
			Q = "下圖是哪部動畫的角色 ?";
			C[0] = "fate zero";
			C[1] = "魔法少女伊莉亞";
			C[2] = "fate stay night";
			C[3] = "以上皆是";
			KEY = 3;
			addImage("Image/fate.jpg",170, 430, 270, 270);
			
			break;
			
		case 2:
			Q = "下列四者誰最可愛?";
			C[0] = "長門";
			C[1] = "龍驤";
			C[2] = "吹雪";
			C[3] = "提督";
			KEY = 1;
			for(int i=0 ; i<3; i++){
				addImage("Image/KC"+ i +".jpg",10+220*i, 430, 200, 220);
			}
			
			break;
			
		case 3:
			Q = "關於常用的視窗元件,下列何者錯誤 ?";
			C[0] = "JToolBar: 下拉式選單選取按鈕";
			C[1] = "JSlider: 滑動軸";
			C[2] = "JMenu: 下拉式選單";
			C[3] = "JDialog: 對話視窗";
			KEY = 0;
			break;
			
		case 4:
			Q = "以植物生長素和吉貝素組合在一起噴灑某些植物，會?";
			C[0] = "促進果實生長 ";
			C[1] = "防止老化作用";
			C[2] = "殺死闊葉雙子葉植物";
			C[3] = "促進果實成熟";
			KEY = 0;
			break;
			
		case 5:
			Q = "如果希望收集物件時可以佇列方式，收集的物件加入至__，取得物件時可以從__";
			C[0] = "尾端,前端";
			C[1] = "前端,尾端";
			C[2] = "尾端,尾端";
			C[3] = "以上方法皆可";
			KEY = 0;
			break;
			
		case 6:
			Q = "背景音樂是哪部動畫ed的鋼琴版 ?";
			C[0] = "偽物語";
			C[1] = "傷物語";
			C[2] = "化物語";
			C[3] = "便當";
			KEY = 2;
			break;
		case 7:
			Q = "下列何者不是COU控制單元所執行的動作？";
			C[0] = "控制";
			C[1] = "解碼";
			C[2] = "執行";
			C[3] = "計算";
			KEY = 3;
			break;
		case 8:
			Q = "下圖是哪款遊戲的畫面 ?";
			C[0] = "植物大戰僵屍1";
			C[1] = "植物大戰僵屍2";
			C[2] = "植物大戰僵屍3";
			C[3] = "植物大戰外星人";
			KEY = 0;
			addImage("Image/p.jpg",130, 450, 320, 250);
			break;
		
		case 9:
			Q = "下圖是什麼植物 ?";
			C[0] = "彩虹葛";
			C[1] = "天堂鳥";
			C[2] = "非洲彩花";
			C[3] = "以上皆非";
			KEY = 1;
			addImage("Image/birdFlower.jpg",150, 450, 300, 250);
			break;
		case 10:
		case 11:
		case 12:
			/*
			 .
			 .
			 .
			 .
			 .
			 .
			 */		
		}
		
		
	}
	
	//add an image to a Question
	private static void addImage(String path, int x, int y, int w, int h){ 
		image = Toolkit.getDefaultToolkit().getImage(QuestionBase.class.getResource(path));
		image =  image.getScaledInstance(w, h, Image.SCALE_DEFAULT); // Reset the image size 
		JLabel picture = new JLabel(new ImageIcon(image));
		picture.setBounds(x, y, w, h);
		Knowledge.getGamePanel().add(picture);
	}
	
	
}
