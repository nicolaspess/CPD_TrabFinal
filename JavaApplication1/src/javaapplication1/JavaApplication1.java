/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
//import java.io.FileOutputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
 

/**
 *
 * @author nvdpessutto
 */
public class JavaApplication1 {
    
    //static ObjectOutputStream ArqOut = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        JavaApplication1 obj = new JavaApplication1();
	obj.run();
        
    }
    
    public void run() {
        
        Scanner entrada = new Scanner(System.in);
        String csvFile = "Artigos.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ";";
        //serializa
        Serializador s = new Serializador();
        //deserializa        
        Deserializador d = new Deserializador();
        
        String nome;
        int opcao;
        int id = 1;
        
        // File file = new File("/dados.bin"); 
        //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file)); 
        
        //ObjectOutputStream arqOut = new ObjectOutputStream(new FileOutputStream(new File("Arquivo.bin"),true));
        
        ArrayList<Artigo> artigos = new ArrayList<Artigo>();
	try {

            br = new BufferedReader(new FileReader(csvFile));
   
            //faz o while procurando pelo nome
            while ((line = br.readLine()) != null) {
	        // use comma as separator
		String[] linha = line.split(cvsSplitBy);
                //linha[22] é o nome do autor
                //adiciona tudo 
                if(true){    
                    /**
                    * adiciona no arquivo serial o artigo do autor;
                    * arquivo binario;
                    * insere a instancia de artigo
                    * public Artigo(int id, String ano, String titulo, String area, String autor) 
                    */
                    
                    Artigo art = new Artigo(id, linha[0],linha[3],linha[19],linha[21]);                            
                    //temos a instancia deste artigo
          
                    artigos.add(art);//adicionou ao array                
                }                       
		//System.out.println("Country [code= " + linha[4] + " , name=" + linha[5] + "]");
                System.out.println("estou aqui\n");
                id++;
            }
            try {
                //coloca a instancia art no arquivo binario
                s.serializar("dados.bin", artigos);
            } catch (Exception ex) {
                System.err.println("Falha ao serializar! - " + ex.toString());
            }
            //GAMBIARRA MODE ON
            //chegou no fim do csv...avisa q da pra fechar arquivo               
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
	    if (br != null) {
                try {
                    br.close();
		} catch (IOException e) {
                    e.printStackTrace();
		}
            }
	}
 
	System.out.println("Done");
        
        System.out.println("1- Listagem de todos os artigos de um autor \n"
                                 + "2- Listagem de todos os artigos de um conjunto de autores\n"
                                 + "3- Listagem de todos os artigos que tenham a palavra consultada no título\n"
                                 + "4- Listagem de número de artigos, por autor de uma por determinada área\n"
                                 + "5- Listagem de todos os artigos de um autor em um determinado ano\n");
                
        opcao = entrada.nextInt();
        
        
        if(opcao == 1){ 
            //cria arquivo de indice de acordo com a opção
            System.out.println("Digite o nome do autor: ");
            nome = entrada.next();
            nome = nome.toUpperCase();
            //deserializa ; seleciona os requisitados ; ordena ; cria arquivo de indice
            try{
                artigos = null;
                ArrayList<Artigo> artigosValidos = new ArrayList<Artigo>();
                //artigos = (ArrayList<Artigo>) d.deserializar("dados.bin");
                artigos = (ArrayList<Artigo>) d.deserializar("dados.bin");
                for(Artigo a : artigos){
                    // System.out.println("ArrayList: " + a.getAutor() + " - " + a.getTitulo() + "\n");
                    //if(nome.equals(a.getAutor())){
                    if(a.getAutor().contains(nome)){ //se o autor contem o nome digitado
                        //se autor 'like'->add artigosValidos
                        artigosValidos.add(a);
                    }
                }
                artigos = null;
                //-----------------------------------------------------------
                //ordenar alfabeticamente artigosValidos
                Comparador meuComparador = new Comparador();
                Collections.sort(artigosValidos, meuComparador);
                //-----------------------------------------------------------
                
                ArrayList<Indice> indicesArtigos = new ArrayList<Indice>();
                for(Artigo x: artigosValidos){
                    Indice ind = new Indice(x.getId(), x.getId());
                    indicesArtigos.add(ind);
                }
                //cria arquivo de indices
                s.serializar("IndiceQ1.bin", indicesArtigos);
                
                /*for(Artigo x: artigosValidos){
                    System.out.println("ArrayList Ordenado: " + x.getAutor() + " - " + x.getTitulo() + "\n");
                }*/
            } catch (Exception ex) {
                System.err.println("Falha ao deserializar! - " + 
                                   ex.toString());
            }
            
        }else if(opcao == 2){
            //cria arquivo de indice de acordo com a opção
        }else if(opcao == 3){
            //cria arquivo de indice de acordo com a opção
        }else if(opcao == 4){
            //cria arquivo de indice de acordo com a opção
        }else if(opcao == 5){
            //cria arquivo de indice de acordo com a opção
        }
    }
}