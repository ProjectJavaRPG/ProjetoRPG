package telasJogo;

import java.awt.Color;
import java.awt.Graphics2D;

import mainRPG.GamePanel;

public class MapaMundo extends FaseJogo{
	
	public MapaMundo(GerenciadorJogo gj){
		this.gj = gj;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, GamePanel.LARGURA*3, GamePanel.ALTURA*3);
		
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

}
