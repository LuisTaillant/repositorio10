package service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

public class UsuarioServicio{

    private ArrayList<Usuario> usuarios; //ArrayList que contiene los usuarios

    public UsuarioServicio(ArrayList<Usuario> usuarios){
        this.usuarios = usuarios;
    }

    //Crear un nuevo usuario
    public void crearUsuario(String nombre, String id){
        Usuario nuevoUsuario = new Usuario(nombre, id);
        usuarios.add(nuevoUsuario);
    }

    //Leer todos los usuarios
    public ArrayList<Usuario> obtenerTodosLosUsuarios(){
        return usuarios;
    }

    //Actualizar un usuario
    public void actualizarUsuario(String id, String nuevoNombre){

        for(Usuario usuario : usuarios){
            if(usuario.getId().equals(id)){
                usuario.setNombre(nuevoNombre);
                return;
            }
        }
    }


    //Eliminar un usuario
    public void eliminarUsuarios(String id){

        Iterator<Usuario> it = usuarios.iterator();

        while(it.hasNext()){

            if(it.next().getId().equals(id)){
                it.remove();
            }
        }
    }


    //Prestamo de un libro a un usuario
    public void prestarLibro(Usuario usuario, Libro libro){

        if(libro.isDisponible()){
            usuario.getLibrosPrestados().add(libro);
            libro.setDisponible(false);
            //registrar el prestamo en la lista de prestamos del usuario
            //y actualizar la disponibilidad del libro
        }else{
            System.out.println("El libro no esta disponible para prestamo");
        }
    }


    //Buscar un usuario por id
    public Usuario buscarUsuarioPorId(String id){

        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                return usuario;
            }
        }
        //retorna null si no se encuentra ningun usuario
        //con el id proporcionado
        return null;
    }


    //Devolver un libro de un usuario
    public void devolverLibro(Usuario usuario, Libro libro){

        if(usuario.getLibrosPrestados().contains(libro)){
            usuario.getLibrosPrestados().remove(libro);
            libro.setDisponible(true);
            //registrar la devolucion del libro
            //y actualizar la disponibilidad del libro
        }else{
            System.out.println("El libro no fue prestado por este usuario");
        }
    }


    //Obtener todos los libros prestados de un usuario
    public ArrayList<Libro> obtenerLibrosPrestados(Usuario usuario){
        return usuario.getLibrosPrestados();
    }

    //Buscar usuarios por su nombre
    public ArrayList<Usuario> buscarUsuariosPorNombre(String nombre){

        ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();

        for(Usuario usuario : usuarios){
            if(usuario.getNombre().equalsIgnoreCase(nombre)){
               usuariosEncontrados.add(usuario);
            }
        }
        return usuariosEncontrados;

    }

}
