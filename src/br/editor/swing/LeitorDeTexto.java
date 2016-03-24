package br.editor.swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * Classe que busca os dados no arquivo txt, e retorna para o usuario quando ele
 * clica no botao ler arquivo.
 * @author Edson
 *
 */
public class LeitorDeTexto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeitorDeTexto frame = new LeitorDeTexto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public LeitorDeTexto() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 311);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 403, 213);
		contentPane.add(panel);
		panel.setLayout(null);
		
		File file = new File("c:/c/teste1.txt");
		FileInputStream fileInputStream = null;
		String texto ="";
		
		try{
			fileInputStream = new FileInputStream(file);
			int content;
			while((content = fileInputStream.read()) !=-1){
				texto += (char)content;
			}
			fileInputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		JTextArea textArea = new JTextArea(texto);
		textArea.setLineWrap(true); //quebra de linha automatica.
		textArea.setBounds(10, 11, 383, 191);
		panel.add(textArea);
		JButton btnSair = new JButton("SAIR");
		btnSair.setForeground(Color.BLUE);
		btnSair.setBackground(Color.RED);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSair.setBounds(192, 227, 89, 23);
		contentPane.add(btnSair);
	}
}
