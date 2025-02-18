package com.miapp.biblioteca;

import java.util.ArrayList;

public class Libro{

    //Atributos
    private String titulo;
    private String autor;
    private String ISBN;
    private String genero;
    private boolean disponible;

    //Constructor con parametros
    public Libro(String titulo, String autor, String ISBN, String genero){
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.genero = genero;
        this.disponible = true;
    }

    //Constructor por default
    public Libro(){

    }


    //Getters y Setters
    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getISBN(){
        return ISBN;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public boolean isDisponible(){
        return disponible;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

    @Override
    public String toString(){
        return "Libro [titulo=" + titulo + ", autor=" + autor + ", ISBN=" + ISBN + ", genero=" + genero + ", disponible=" + disponible + "]";
    }

}

