/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.Serializable;
/**
 *
 * @author hp
 */
public class Indice implements Serializable {
    
    private int idArtigo; //id do artigo no arquivo binario principal
    private int posicao;  //posição do artigo no arquivo principal
    
    public Indice(int idArtigo, int posicao){
        this.idArtigo = idArtigo;
        this.posicao = posicao;
    }
    
    public void setIdArtigo(int a){
        this.idArtigo = a;
    }
    
    public int getIdArtigo(){
        return this.idArtigo;
    }
    
    public void setPosicao(int a){
        this.posicao = a;
    }
    
    public int getPosicao(){
        return this.posicao;
    }
}
