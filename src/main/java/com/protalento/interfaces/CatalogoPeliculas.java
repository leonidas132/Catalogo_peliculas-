package com.protalento.interfaces;

public interface CatalogoPeliculas {
    public static final String NOMBRE_RECURSO = "peliculas.txt";

    void agregarPelicula(String nombrePelicula);

    void listarPelicula();

     void buscarPelicula(String buscar);

     void iniciarCatalogoPelicuals();


}
