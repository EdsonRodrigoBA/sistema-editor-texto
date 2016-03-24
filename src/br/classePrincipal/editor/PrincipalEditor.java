package br.classePrincipal.editor;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
/**
 * 
 * @author Edson Rodrigo
 * @see EditorTexto, LeitorTexto.
 * @version 1.0
 * E-mail: tec.er@outlook.com
 * 
 * Classe responsavel por conter os metodos que vão ser chamados nas classe EditorTexto e LeitorDeTexto
 *
 */
public class PrincipalEditor {
	Path path = Paths.get("c:/c/teste1.txt");
	Charset utf =StandardCharsets.UTF_8;


	public void gravar(String s) throws IOException{
		BufferedWriter bw = Files.newBufferedWriter(path, utf);
		bw.write(s);
		bw.flush();
		bw.close();
	}
	
	
	/**
	 * Metodo responsavel por fazer a limpeza dos texto .
	 */
	public void limparDocumento() throws IOException{
		File file = new File("c:/c/teste1.txt");
		RandomAccessFile ra = new RandomAccessFile(file,"rw");
		
		if(file.exists()){
			/**
			 * Verificando se o arquivo existe , se o arquivo existir , ele pergunta se
			 * o usuario desejar mesmo apagar o documento.
			 */
			int i = JOptionPane.showConfirmDialog(null, "Deseja Mesmo Apaga o Arquivo ?");
			if(i==0){
				ra.setLength(0);
				JOptionPane.showMessageDialog(null, "Arquivo Apagado");
			}else{
				JOptionPane.showMessageDialog(null, "Arquivo Nao Apagado");
			}
		}
	}
	
	
	/**
	 * Metodo que faz a busca do texto dentro do arquivo txt.
	 * @return todas as linhas dentro do documento
	 * @throws IOException
	 */
	public String  leitura() throws IOException{
		BufferedReader fr = Files.newBufferedReader(path, utf);
		
		BufferedReader br = new BufferedReader(fr);
		String linha = br.readLine();
		while(linha != null){
			JOptionPane.showMessageDialog(null, linha);
			linha = br.readLine();
		}
		
		return linha;
		
	} 
	
	

}
