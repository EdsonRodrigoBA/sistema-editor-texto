package br.editor.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import br.classePrincipal.editor.PrincipalEditor;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class EditorTexto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorTexto frame = new EditorTexto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditorTexto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 340);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelEditor = new JPanel();
		panelEditor.setBackground(Color.CYAN);
		panelEditor.setBorder(new TitledBorder(null, "Editor de Texto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEditor.setBounds(10, 11, 488, 202);
		contentPane.add(panelEditor);
		panelEditor.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(10, 21, 468, 170);
		panelEditor.add(textArea);
		
		JButton btnSalvaDocumento = new JButton("Salvar");
		btnSalvaDocumento.setForeground(Color.RED);
		btnSalvaDocumento.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvaDocumento.addActionListener(new ActionListener() {
			/**
			 * Metodo responsavel por salva e cria o arquivo txt
			 */
			public void actionPerformed(ActionEvent e) {
				try{
					//chamando a classe principal editor e instanciando.
					PrincipalEditor p = new PrincipalEditor();
					String s = textArea.getText();
					if(s.equals("")){
						//verificando caso o o textfield esteja vazio , ele dispara a mensagem nada pra salva.
						JOptionPane.showMessageDialog(EditorTexto.this, "Nada pra Salvar");
					}else{
						//se tive algo para salvar ele salva, e exibe a mensagem abaixo.
						
						p.gravar(s);
						JOptionPane.showMessageDialog(EditorTexto.this, "Arquivo Salvo Salvo Com Sucessor");
					}


				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnSalvaDocumento.setBounds(139, 224, 89, 23);
		contentPane.add(btnSalvaDocumento);
		
		JButton btnLimparEditor = new JButton("Limpar Editor");
		btnLimparEditor.setForeground(Color.BLUE);
		btnLimparEditor.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnLimparEditor.addActionListener(new ActionListener() {
			//BOTAO RESPONSAVEL POR LIMPA O TEXTFIELD.
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
			}
		});
		btnLimparEditor.setBounds(10, 256, 133, 23);
		contentPane.add(btnLimparEditor);
		
		JButton btnApagardoDocumentoSalvo = new JButton("Apaga Texto depois de salvo");
		btnApagardoDocumentoSalvo.setForeground(Color.BLUE);
		btnApagardoDocumentoSalvo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnApagardoDocumentoSalvo.addActionListener(new ActionListener() {
			//EVENTO DO BOTÃO PARA APAGA O TEXTO LOGO DEPOIS QUE FOI SALVO.
			public void actionPerformed(ActionEvent e) {
				try{
					PrincipalEditor principalEditor = new PrincipalEditor();
					principalEditor.limparDocumento();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnApagardoDocumentoSalvo.setBounds(153, 256, 194, 23);
		contentPane.add(btnApagardoDocumentoSalvo);
		
		JButton btnFechaDoc = new JButton("Fechar Editor");
		btnFechaDoc.setForeground(Color.BLUE);
		btnFechaDoc.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		//fecha a janela completa ou seja o editor de texto.
		btnFechaDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnFechaDoc.setBounds(376, 256, 109, 23);
		contentPane.add(btnFechaDoc);
		
		JButton btnLerArquivo = new JButton("Ler Arquivo");
		btnLerArquivo.setForeground(Color.RED);
		btnLerArquivo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLerArquivo.addActionListener(new ActionListener() {
			
			//EVENTO DO BUTAO QUE LER O ARQUIVO
			public void actionPerformed(ActionEvent e) {
				try{
					EditorTexto.this.dispose();
					LeitorDeTexto leitorDeTexto = new LeitorDeTexto();
					leitorDeTexto.setVisible(true);
					leitorDeTexto.setLocationRelativeTo(null);
				}catch(Exception e2){
					e2.getMessage();
				}
			}
		});
		btnLerArquivo.setBounds(264, 224, 150, 23);
		contentPane.add(btnLerArquivo);
	}
}
