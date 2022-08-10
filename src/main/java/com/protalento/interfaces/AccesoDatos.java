package com.protalento.interfaces;

import com.protalento.entidades.Pelicula;
import com.protalento.excepsiones.*;


import java.util.List;

public interface AccesoDatos {
    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;

    void escribir (Pelicula pelicula,String nombreRecruso,boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreRecurso,String buscar)throws LecturaDatosEx;

    void crear(String nombreRecurso) throws AccesoDatosEx;

    void borrar(String nombreRecurso) throws AccesoDatosEx;


}
