package mainRPG;

import javax.swing.*;


public class GameStart {
	
	public static void main(String[] args) {
		JFrame janelaJogo=new JFrame();
		janelaJogo.setContentPane(new GamePanel());
		janelaJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaJogo.setResizable(false);
		janelaJogo.pack();
		janelaJogo.setVisible(true);
	}

}
