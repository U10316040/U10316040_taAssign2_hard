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
			Q = "�Ӫ��E�����B��A�U�C��̳̦X�z?";
			C[0] = "�����Ѥ�賡�B�� ";
			C[1] = "�����Ѷ��ֳ��B�� ";
			C[2] = "�������X���@�ιB�� ";
			C[3] = "�]�������P�ӥѤ��P�覡�B�� ";
			KEY = 3;
			break;
			
		case 1:
			Q = "�U�ϬO�����ʵe������ ?";
			C[0] = "fate zero";
			C[1] = "�]�k�֤k�����";
			C[2] = "fate stay night";
			C[3] = "�H�W�ҬO";
			KEY = 3;
			addImage("Image/fate.jpg",170, 430, 270, 270);
			
			break;
			
		case 2:
			Q = "�U�C�|�ֳ̥̽i�R?";
			C[0] = "����";
			C[1] = "�s��";
			C[2] = "�j��";
			C[3] = "����";
			KEY = 1;
			for(int i=0 ; i<3; i++){
				addImage("Image/KC"+ i +".jpg",10+220*i, 430, 200, 220);
			}
			
			break;
			
		case 3:
			Q = "����`�Ϊ���������,�U�C��̿��~ ?";
			C[0] = "JToolBar: �U�Ԧ���������s";
			C[1] = "JSlider: �ưʶb";
			C[2] = "JMenu: �U�Ԧ����";
			C[3] = "JDialog: ��ܵ���";
			KEY = 0;
			break;
			
		case 4:
			Q = "�H�Ӫ��ͪ����M�N�����զX�b�@�_�Q�x�Y�ǴӪ��A�|?";
			C[0] = "�P�i�G��ͪ� ";
			C[1] = "����ѤƧ@��";
			C[2] = "�����︭���l���Ӫ�";
			C[3] = "�P�i�G�ꦨ��";
			KEY = 0;
			break;
			
		case 5:
			Q = "�p�G�Ʊ榬������ɥi�H��C�覡�A����������[�J��__�A���o����ɥi�H�q__";
			C[0] = "����,�e��";
			C[1] = "�e��,����";
			C[2] = "����,����";
			C[3] = "�H�W��k�ҥi";
			KEY = 0;
			break;
			
		case 6:
			Q = "�I�����֬O�����ʵeed�����^�� ?";
			C[0] = "�����y";
			C[1] = "�˪��y";
			C[2] = "�ƪ��y";
			C[3] = "�K��";
			KEY = 2;
			break;
		case 7:
			Q = "�U�C��̤��OCOU����椸�Ұ��檺�ʧ@�H";
			C[0] = "����";
			C[1] = "�ѽX";
			C[2] = "����";
			C[3] = "�p��";
			KEY = 3;
			break;
		case 8:
			Q = "�U�ϬO���ڹC�����e�� ?";
			C[0] = "�Ӫ��j�Ի���1";
			C[1] = "�Ӫ��j�Ի���2";
			C[2] = "�Ӫ��j�Ի���3";
			C[3] = "�Ӫ��j�ԥ~�P�H";
			KEY = 0;
			addImage("Image/p.jpg",130, 450, 320, 250);
			break;
		
		case 9:
			Q = "�U�ϬO����Ӫ� ?";
			C[0] = "�m�i��";
			C[1] = "�Ѱ�";
			C[2] = "�D�w�m��";
			C[3] = "�H�W�ҫD";
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
