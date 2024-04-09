package service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;

public class LibroServicio{
    private ArrayList<Libro> biblioteca; //ArrayList que contiene los libros

    public LibroServicio(ArrayList<Libro> biblioteca){
        this.biblioteca = biblioteca;
    }

    //Crear un nuevo libro
    public void crearLibro(String titulo, String autor, String ISBN, String genero){
        Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);
        biblioteca.add(nuevoLibro);
    }

    //Leer todos los libros
    public ArrayList<Libro> obtenerTodosLosLibros(){
        return biblioteca;
    }

    //Actualizar un libro
    public void actualizarLibro(String ISBN, String nuevoTitulo, String nuevoAutor, String nuevoGenero){

        for(Libro libro : biblioteca){
            if(libro.getISBN().equals(ISBN)){
                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                libro.setGenero(nuevoGenero);
            }
        }
    }


    //Eliminar un libro
    public void eliminarLibro(String ISBN){

        Iterator<Libro> it = biblioteca.iterator();

        while(it.hasNext()){

            if(it.next().getISBN().equals(ISBN)){
                it.remove();
            }
        }
    }


    //Buscar libro por su ISBN
    public Libro buscarLibroPorISBN(String ISBN){

        for(Libro libro : biblioteca){
            if(libro.getISBN().equals(ISBN)){
                return libro;
            }
        }
        return null; //retorna null si no se encuentra ningun libro con el ISBN proporcionado

    }


    //Buscar libro por su titulo
    public ArrayList<Libro> buscarLibrosPorTitulo(String titulo){

        ArrayList<Libro> librosEncontrados = new ArrayList<>();

        for(Libro libro : biblioteca){
            if(libro.getTitulo().equalsIgnoreCase(titulo)){
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;

    }


    //Verifica la disponibilidad de un libro
    public boolean verificarDisponibilidad(Libro libro){

        return libro.isDisponible();

    }

}





