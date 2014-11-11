package mainRPG;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import telasJogo.GerenciadorJogo;

public class GamePanel extends JPanel implements KeyListener, Runnable{

	private static final long serialVersionUID = -3267458714458004010L;
	//dimensoes da janela
	public static final int LARGURA=320;
	public static final int ALTURA=240;
	public static final int ESCALA=3;
	
	//game thread
	private Thread thread;
	private boolean running;
	private int FPS=60;
	private long targetTime=1000/FPS;
	
	//imagem
	private BufferedImage imagem;
	private Graphics2D g;
	
	//gerenciadorJogo
	GerenciadorJogo gj=new GerenciadorJogo();
	
	public GamePanel(){
		super();
		setPreferredSize(new Dimension(LARGURA*ESCALA, ALTURA*ESCALA));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread==null) {
			thread=new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	private void init(){
		
		imagem=new BufferedImage(ALTURA,LARGURA,BufferedImage.TYPE_INT_RGB);
		g=(Graphics2D) imagem.getGraphics();
		
		running=true;
		
		gj = new GerenciadorJogo();
	}

	@Override
	public void run() {
		
		init();
		
		long start;
		long elapsed;
		long wait;
		
		//game loop
		while(running){
			start=System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed=System.nanoTime()-start;
			
			wait=targetTime-elapsed/1000000;
			if(wait<0)wait=5;
			
			try{
				Thread.sleep(wait);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	private void update(){
		gj.update();
	}
	
	private void draw(){
		gj.draw(g);
	}
	
	private void drawToScreen(){
		Graphics g2=getGraphics();
		g2.drawImage(imagem, 0, 0, LARGURA*ESCALA, ALTURA*ESCALA, null);
		g2.dispose();
	}

	@Override
	public void keyPressed(KeyEvent key) {
		gj.keyPressed(key.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent key) {
		gj.keyReleased(key.getKeyCode());
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
