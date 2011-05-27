/*
 Aki vai um exemplo de key Listener (esperar pro tecla), quando vc usa o metodo addKeyListener
 e ativa o keyListener, vc necessita declarar 3 metodos:

 public void keyPressed(KeyEvent e){}
 public void keyReleased(KeyEvent e){}	
 public void keyTyped(KeyEvent e){}

 Ah.. importem a biblioteca java.awt.event.*;

 Importante.. veja que o JFrame.. sua implements KeyListener.. isso para poder ser possivel
 dar um addKeyListener nele.

 Quando o usuário apertas uma tecla, esses eventos serao chamados, e o codigo que vc escrever
 dentro dele será executado.

 O Exemplo abaixo é cheio de florzinha.. soh frescura.. por isso recomendo que vc alterem
 o que vai dentro desses metodos.. fucem ae.. e caso tenha algum metodo que vcs sao sabem oq
 faz.. dah um search na documentação da sun. O importante é so ver como pegar evento de tecla
 e entender a diferenca de keyPressed e keyReleased

*/



import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PegaTecla extends JFrame implements KeyListener{
	
	JTextArea texto;
 	String linha1 = "", linha2="", linha3="";
	
	public PegaTecla(){
		super("Mostrando os eventos de declaro"); /* coloca titulo na janela */
		
                /* manipula textArea */

		texto = new JTextArea(10, 15);
		texto.setText("Aperte qualquer tecla");
		texto.setEnabled(false);
		
                /* coloca KeyListener no classe KeyDemo que extend JFrame
                   ou seja, evento fica no proprio frame */

		addKeyListener(this);
		getContentPane().add(texto);

		/* seta o tamanho e torna o frame visivel */

		setSize(350, 100);
		setVisible(true);
	}
								
        /* Metodo chamado quando a tecla é pressionada, o objeto "e" recebe as informações
	   do evento, o metodo getKeyText pega o nome da tecla pressionada */
	
	public void keyPressed(KeyEvent e){
		linha1 = "Tecla pressionada: " + e.getKeyText(e.getKeyCode());
		setStrings(e);
	}
	
	/* Faz a mesma coisa.. porem quando a tecla pressionada, nao liberada ainda */

	public void keyReleased(KeyEvent e){
		linha1 = "Tecla apertada: " + e.getKeyText(e.getKeyCode());
		setStrings(e);
	}
	
	
	public void keyTyped(KeyEvent e){
		linha1 = "Tipo de Tecla: " + e.getKeyChar();
		setStrings(e);
	}
	
        /* Coloca as informações obtidas nas strings e dps no textarea */

	private void setStrings(KeyEvent e){
		linha2 = "Essa tecla " + (e.isActionKey() ? "" : "não") + " é uma tecla de ação";
		
		String temp = 
		e.getKeyModifiersText(e.getModifiers());
		
		linha3 = "Modificado :" + (temp.equals("") ? "none" : temp);
		
		texto.setText(linha1 + "\n" + linha2 + "\n" + linha3 + "\n");
	}
	
        /* Main */

	public static void main(String args[]){
		PegaTecla app = new PegaTecla();
		
                /* adiciona windowListener para a janela poder ser fechada */
		app.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		}
		);
	}
}

	
        