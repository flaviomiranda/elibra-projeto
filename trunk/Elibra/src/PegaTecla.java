/*
 Aki vai um exemplo de key Listener (esperar pro tecla), quando vc usa o metodo addKeyListener
 e ativa o keyListener, vc necessita declarar 3 metodos:

 public void keyPressed(KeyEvent e){}
 public void keyReleased(KeyEvent e){}	
 public void keyTyped(KeyEvent e){}

 Ah.. importem a biblioteca java.awt.event.*;

 Importante.. veja que o JFrame.. sua implements KeyListener.. isso para poder ser possivel
 dar um addKeyListener nele.

 Quando o usu�rio apertas uma tecla, esses eventos serao chamados, e o codigo que vc escrever
 dentro dele ser� executado.

 O Exemplo abaixo � cheio de florzinha.. soh frescura.. por isso recomendo que vc alterem
 o que vai dentro desses metodos.. fucem ae.. e caso tenha algum metodo que vcs sao sabem oq
 faz.. dah um search na documenta��o da sun. O importante � so ver como pegar evento de tecla
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
								
        /* Metodo chamado quando a tecla � pressionada, o objeto "e" recebe as informa��es
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
	
        /* Coloca as informa��es obtidas nas strings e dps no textarea */

	private void setStrings(KeyEvent e){
		linha2 = "Essa tecla " + (e.isActionKey() ? "" : "n�o") + " � uma tecla de a��o";
		
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

	
        