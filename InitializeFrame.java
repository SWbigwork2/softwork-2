package swing_learning;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class InitializeFrame extends JFrame {
	public void initialize(){
		MyFrame_6 frame_6 = new MyFrame_6();
		  JFrame frame = new JFrame();
		  Toolkit kit = Toolkit.getDefaultToolkit();
		  Dimension screensize = kit.getScreenSize();
		  int screenWidth = screensize.width;
		  int screenHeight = screensize.height;
		  int frameWidth = 0;
		  int frameHeight = 0;
		  if (screenWidth * 3 > screenHeight * 4){
				frameHeight = screenHeight / 2;
				frameWidth = frameHeight * 4 / 3;
		  }
		  else {
				frameWidth = screenWidth / 2;
				frameHeight = frameWidth * 3 / 4;
		  }
		  
		  setBounds((screenWidth - frameWidth)/2, (screenHeight - frameHeight)/2, frameWidth, frameHeight);
		  setTitle("Test");
		  //getContentPane().add(frame_6);
		  setBackground(Color.black);
		  setDefaultCloseOperation(EXIT_ON_CLOSE);
		  setVisible(true);
		 
		}
}
