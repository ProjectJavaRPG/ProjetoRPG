package telasJogo;

import java.util.ArrayList;

public class GerenciadorJogo {
	
	private ArrayList<FaseJogo> faseJogo;
	private int estadoAtual;
	
	//posicao de cada fase no arrayList
	public static final int MENUINICIAL=0;
	public static final int MAPAMUNDO=1;
	public static final int MAPA1=2;
	
	public GerenciadorJogo(){
		
		faseJogo = new ArrayList<FaseJogo>();
		
		estadoAtual = MENUINICIAL;
		//criar objeto para cada tela do jogo.
		
		faseJogo.add(new MenuInicial(this));
		faseJogo.add(new MapaMundo(this));
	}
	
	public void selecionaTela(int estadoSeguinte){
		
		estadoAtual = estadoSeguinte;
		//iniciar a visualizacao da nova janela
		faseJogo.get(estadoAtual).init();
	}
	
	public void update(){
		//executar update da janela atual
		faseJogo.get(estadoAtual).update();
	}
	
	public void draw(java.awt.Graphics2D g){
		//desenhar imagem da janela atual
		faseJogo.get(estadoAtual).draw(g);
	}
	
	public void keyPressed(int k){
		faseJogo.get(estadoAtual).keyPressed(k);
	}
	
	public void keyReleased(int k){
		faseJogo.get(estadoAtual).keyReleased(k);
	}

}
