package ui;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import service.LibroServicio;
import service.UsuarioServicio;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        ArrayList<Libro> biblioteca = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        LibroServicio libroService = new LibroServicio(biblioteca);
        UsuarioServicio usuarioService = new UsuarioServicio(usuarios);

        libroService.crearLibro("Monstruos en el campamento", "R.L Stine", "001", "Fantasmas"); // valor por defecto inicial
        usuarioService.crearUsuario("Luis", "001"); // valor por defecto inicial
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do{
            System.out.println("=== Biblioteca Virtual ===");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Actualizar Usuario por id");
            System.out.println("3. Eliminar Usuario por id");
            System.out.println("4. Crear Libro");
            System.out.println("5. Actualizar Libro");
            System.out.println("6. Eliminar Libro");
            System.out.println("7. Buscar Libro por ISBN");
            System.out.println("8. Buscar Libros por titulo");
            System.out.println("9. Buscar Usuarios por nombre");
            System.out.println("10. Listar Libros");
            System.out.println("11. Prestamos");
            System.out.println("12. Devoluciones");
            System.out.println("13. Salir");

            System.out.println("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // consumir el salto de linea

            switch(opcion){

                case 1:
                    // crear usuario
                    System.out.println("Ingrese el nombre de usuario: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el idUsuario: ");
                    String id = scanner.nextLine();

                    usuarioService.crearUsuario(nombre, id);
                    break;

                case 2:
                    // Actualizar usuario
                    System.out.println("Ingrese el nombre de usuario a actualizar: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.println("Ingrese el nuevo id de usuario: ");
                    String nuevoId = scanner.nextLine();

                    usuarioService.actualizarUsuario(nuevoId, nuevoNombre);
                    break;

                case 3:
                    // Eliminar Usuario
                    System.out.println("Ingrese el id del usuario a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    usuarioService.eliminarUsuarios(idEliminar);
                    break;

                case 4:
                    // crear libro
                    System.out.println("Ingrese el titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Ingrese el Autor: ");
                    String autor = scanner.nextLine();
                    System.out.println("Ingrese el ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.println("Ingrese el genero: ");
                    String genero = scanner.nextLine();

                    libroService.crearLibro(titulo, autor, isbn, genero);
                    break;

                case 5:
                    // Actualizar libro
                    System.out.println("Ingrese el ISBN del libro a actualizar: ");
                    String isbnActualizar = scanner.nextLine();
                    System.out.println("Ingrese el nuevo titulo: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.println("Ingrese el nuevo autor: ");
                    String nuevoAutor = scanner.nextLine();
                    System.out.println("Ingrese el nuevo genero: ");
                    String nuevoGenero = scanner.nextLine();

                    libroService.actualizarLibro(isbnActualizar, nuevoTitulo, nuevoAutor, nuevoGenero);
                    break;

                case 6:
                    // Eliminar Libro
                    System.out.println("Ingrese el ISBN del libro a eliminar: ");
                    String isbnEliminar = scanner.nextLine();
                    libroService.eliminarLibro(isbnEliminar);
                    break;


                case 7:
                    // Buscar libro por ISBN
                    System.out.println("Ingrese el ISBN del libro a buscar: ");
                    String isbnBuscar = scanner.nextLine();
                    Libro libroISBN = libroService.buscarLibroPorISBN(isbnBuscar);

                    if(libroISBN != null){
                        System.out.println("Libro encontrado: " + libroISBN.getTitulo());
                    }else{
                        System.out.println("Libro no encontrado");
                    }
                    break;


                case 8:
                    // Buscar libros por titulo
                    System.out.println("Ingrese el titulo a buscar: ");
                    String tituloBuscar = scanner.nextLine();
                    ArrayList<Libro> librosPorTitulo = libroService.buscarLibrosPorTitulo(tituloBuscar);

                    if(!librosPorTitulo.isEmpty()){
                        System.out.println("Libros encontrados:");
                        for(Libro libro : librosPorTitulo){
                            System.out.println(libro.getTitulo());
                        }
                    }else{
                        System.out.println("Ningun libro encontrado con ese titulo");
                    }
                    break;

                case 9:
                    // Buscar usuarios por nombre
                    System.out.println("Ingrese el nombre de usuario a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    ArrayList<Usuario> usuariosPorNombre = usuarioService.buscarUsuariosPorNombre(nombreBuscar);

                    if(!usuariosPorNombre.isEmpty()){
                        System.out.println("Usuarios encontrados:");
                        for(Usuario usuario : usuariosPorNombre){
                            System.out.println(usuario.getNombre());
                        }
                    }else{
                        System.out.println("Ningun usuario encontrado con ese nombre");
                    }
                    break;

                case 10:
                    // Listar Libros
                    ArrayList<Libro> listaLibros = libroService.obtenerTodosLosLibros();
                    for(Libro libro : listaLibros){
                        System.out.println(libro.getTitulo() + " (" + libro.getISBN() + ")");
                    }
                    break;

                case 11:
                    // Prestar libro por ISBN
                    System.out.println("Ingrese el numero de indentificacion del usuario: ");
                    String idUsuario = scanner.nextLine();
                    Usuario usuarioPrestamo = usuarioService.buscarUsuarioPorId(idUsuario);

                    if(usuarioPrestamo != null){

                        System.out.println("Ingrese el ISBN del libro a prestar: ");
                        String isbnPrestamo = scanner.nextLine();
                        Libro libroPrestamo = libroService.buscarLibroPorISBN(isbnPrestamo);

                        if(libroPrestamo != null){

                            if(libroService.verificarDisponibilidad(libroPrestamo)){

                                usuarioService.prestarLibro(usuarioPrestamo, libroPrestamo);
                                System.out.println("El libro no esta disponible para prestamo");
                            }else{
                                System.out.println("Libro no encontrado");
                            }

                        } else {
                            System.out.println("Usuario no encontrado");
                        }

                        break;
                    }

                case 12:
                    // Devolver libro por ISBN
                    System.out.println("Ingrese el numero de indentificacion del usuario: ");
                    String idUsuario1 = scanner.nextLine();
                    Usuario usuarioDevolucion = usuarioService.buscarUsuarioPorId(idUsuario1);

                    if(usuarioDevolucion != null){

                        System.out.println("Ingrese el ISBN del libro a devolver: ");
                        String isbnDevolucion = scanner.nextLine();
                        Libro libroDevolucion = libroService.buscarLibroPorISBN(isbnDevolucion);

                        if(libroDevolucion != null){
                            usuarioService.devolverLibro(usuarioDevolucion, libroDevolucion);
                            System.out.println("Devolucion exitosa. Libro devuelto por " + usuarioDevolucion.getNombre());
                        }else{
                            System.out.println("Libro no encontrado");
                        }

                    } else {
                        System.out.println("Usuario no encontrado");
                    }

                    break;

                case 13:
                    // Salir del menu
                    System.out.println("Gracias por usar la Biblioteca Virtual. Nos vemos! ");
                    break;


                default:
                    System.out.println("Opcion no valida. Intente de nuevo por favor");

            }

        } while (opcion != 13);

    }

}