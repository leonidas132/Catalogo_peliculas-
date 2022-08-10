package com.protalento.implementacion;

import com.protalento.entidades.Pelicula;
import com.protalento.excepsiones.AccesoDatosEx;
import com.protalento.excepsiones.LecturaDatosEx;
import com.protalento.interfaces.AccesoDatos;
import com.protalento.interfaces.CatalogoPeliculas;


import java.util.List;

public class implCatalogoPelicula implements CatalogoPeliculas {

    private final AccesoDatos datos;

    public implCatalogoPelicula() {
        this.datos = new ImplAccesoDatos();
    }


    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula,NOMBRE_RECURSO,anexar);
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso");
            e.printStackTrace(System.out);

        }


    }

    @Override
    public void listarPelicula() {
        try {
           List<Pelicula>peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula : peliculas) {
                System.out.println("pelicula : "+ pelicula);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("error de acceso a datos");
            e.printStackTrace();
        }

    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO,buscar);

        } catch (LecturaDatosEx e) {
            System.out.println("error en el acceso a datos");
            e.printStackTrace();
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPelicuals() {
        try {
            if(this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("eror en el acesso a datos");
            e.printStackTrace();
        }

    }
}
