package com.protalento.implementacion;

import com.protalento.entidades.Pelicula;
import com.protalento.excepsiones.AccesoDatosEx;
import com.protalento.excepsiones.EscrituraDatosEx;
import com.protalento.excepsiones.LecturaDatosEx;
import com.protalento.interfaces.AccesoDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImplAccesoDatos implements AccesoDatos {
    @Override
    //uso de archivo
    /**
     * @param nombreArchivo
     * verifica si el parametro pasado existe como archivo*/
    public boolean existe(String nombreRecurso)  {
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        File archivo = new File(nombreRecurso);
        List<Pelicula> listaPelicula = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = bufferedReader.readLine(); // se lee el archivo por linea
            while(linea != null){  // si es diferente de null se crea un objeto de tipo pelicula
                Pelicula pelicula = new Pelicula(linea);
                listaPelicula.add(pelicula); //se agrega a la lista un objeto de tipo Pelicula
                linea = bufferedReader.readLine(); // para validar si hay una nueva linea
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Error al listar peliculas: "+ e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Error al listar peliculas: "+ e.getMessage());
        }

        return listaPelicula;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecruso, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreRecruso);
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(archivo,anexar));
            writer.println(pelicula.toString());
            writer.close();
            System.out.println("sea escrito informacion al archivo");
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosEx("Error al escribir pelicula: "+e.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = reader.readLine();
            byte indice =1;
            while (linea != null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Pelicula " + linea + " encontrada en el indice " + indice;
                    break;
                }
                linea=reader.readLine();
                indice++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new LecturaDatosEx("Error al leer Peliocula: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Error al leer Peliocula: " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
         File archivo = new File(nombreRecurso);
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(archivo));
            writer.close();
            System.out.println("archivo creado exitosamente ");
        } catch (IOException e) {
            e.printStackTrace();
            throw new AccesoDatosEx("Error al crear el archivo: " + e.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) {
        File archivo =  new File(nombreRecurso);
        if (archivo.exists())
            archivo.delete();
        System.out.println("archivo eliminado");
    }
}
