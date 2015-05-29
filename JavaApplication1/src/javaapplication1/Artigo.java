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
public class Artigo implements Serializable {
    private int id;
    private String ano;
    private String titulo;
    private String area;
    private String autor;

    public Artigo(int id, String ano, String titulo, String area, String autor){
        this.id = id;
        this.ano = ano;
        this.titulo = titulo;
        this.area = area;
        this.autor = autor;       
    }
    
    public void setId(int a){
        this.id = a;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setTitulo(String a){
        this.titulo = a;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public void setAutor(String a){
        this.autor = a;
    }
    
    public String getAutor(){
        return this.autor;
    }
    
    public void setArea(String a){
        this.area = a;
    }
    
    public String getArea(){
        return this.area;
        
    }public void setAno(String a){
        this.ano = a;
    }
    
    public String getAno(){
        return this.ano;
    }  
}
