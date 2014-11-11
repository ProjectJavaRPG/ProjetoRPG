package telasJogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import mainRPG.GamePanel;
import mainRPG.GameStart;

public class MenuInicial extends FaseJogo{
	private BufferedImage planoFundo; //criar classe PlanoFundo!! 
	private Color corTitulo;
	private Font fonteTitulo;
	private Font fonte;
	
	private int opcaoAtual=0;
	private String[] opcoesMenu={"Iniciar", "Sair"}; //NOTA:manter a opção "sair" sempre na ultima posição!!
		
	public MenuInicial(GerenciadorJogo gj){
		this.gj=gj;
		
		corTitulo=new Color(130, 20, 200);
		fonteTitulo=new Font("AR DESTINE", Font.PLAIN, 18);
		fonte=new Font("Arial", Font.PLAIN, 12);
		
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
	public void draw(java.awt.Graphics2D g) {
		//planoFundo.draw(g);
		
		//desenha o titulo
		g.setColor(corTitulo);
		g.setFont(fonteTitulo);
		g.drawString("Nome do Jogo", GamePanel.LARGURA/5, GamePanel.ALTURA/5);
		
		//desenha menu
		g.setFont(fonte);
		for(int i=0; i<opcoesMenu.length; i++){
			if(i==opcaoAtual){
				g.setColor(Color.MAGENTA);
			}
			
			else
				g.setColor(Color.ORANGE);
			
			g.drawString(opcoesMenu[i], GamePanel.LARGURA/3, 110+i*15);
		}
	}
	
	public void selecionado(){
		if(opcaoAtual==opcoesMenu.length-1){
			System.exit(0);
		}
		
		if(opcaoAtual==0){
			gj.selecionaTela(1);
		}
	}

	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_DOWN){
			opcaoAtual++;
			if(opcaoAtual == opcoesMenu.length){
				opcaoAtual = 0;
			}
		}
		
		if(k == KeyEvent.VK_UP){
			opcaoAtual--;
			if(opcaoAtual==-1){
				opcaoAtual=opcoesMenu.length-1;
			}
		}
		
		if(k==KeyEvent.VK_ENTER){
			//executa funcao de selecao
			selecionado();		}
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}
	
}
