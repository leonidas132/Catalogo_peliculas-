package com.protalento.vista;
import com.protalento.implementacion.implCatalogoPelicula;
import com.protalento.interfaces.CatalogoPeliculas;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CatalogoPeliculas catalogo=new implCatalogoPelicula();

        Scanner teclado =new Scanner(System.in);
        System.out.println("Seleccione una opcion ");
        byte opc =-1;
        do {
            System.out.println("1-Iniciar catalogo pelicula" +
                    "\n2-Agregar pelicula" +
                    "\n3-Listar Pelicula" +
                    "\n4-Buscar Pelicula " +
                    "\n0-Salir");
            System.out.println("ingrese la opcion");
             opc= teclado.nextByte();
            switch(opc){
                case 1:
                    catalogo.iniciarCatalogoPelicuals();

                    break;
                case 2:
                    teclado.nextLine();
                    System.out.println("Agregar nombre pelicula");
                    String nombrePelicula = teclado.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);

                    break;
                case 3:
                    System.out.println("listar pelicula");
                    catalogo.listarPelicula();

                    break;
                case 4:
                    teclado.nextLine();
                    System.out.println("ingrese el nombre de la pelicula");
                    String nombre = teclado.nextLine();
                    catalogo.buscarPelicula(nombre);
                    break;
                case 0:
                    System.out.println("finis");
                    break;
                default:
                    
                    System.out.println("opcion incorrecta ");
            }
        }while (opc!= 0);


    }
}
