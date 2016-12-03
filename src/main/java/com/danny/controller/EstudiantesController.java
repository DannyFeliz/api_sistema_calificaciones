package com.danny.controller;


import com.danny.entities.Estudiante;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class EstudiantesController extends BaseController {

    public EstudiantesController() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

    }

    //localhost:8080/estudiantes
    @GetMapping("/estudiantes")
    public ArrayList<Estudiante> obtenerListaEstudiante() {
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();

        try{
            resultSet = statement.executeQuery("SELECT * FROM estudiantes");
            while(resultSet.next()) {
                listaEstudiantes.add(new Estudiante(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
            }

        }catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        return listaEstudiantes;
    }

    //localhost:8080/estudiantes/MATRICULA
    @GetMapping("/estudiantes/{matricula}")
    public Estudiante obtenerEstudiante(@PathVariable int matricula) {
        Estudiante estudiante = new Estudiante();

        try{
            resultSet = statement.executeQuery("SELECT * FROM estudiantes where matricula = " + matricula);
            while(resultSet.next()) {
                estudiante = new Estudiante(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
            }

        }catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        return estudiante;
    }


    //localhost:8080/estudiantes
    @PostMapping("/estudiantes")
    public void agregarEstudiante(@RequestParam int matricula,
                                        @RequestParam String nombre,
                                        @RequestParam String apellido,
                                        @RequestParam String calificacion
                                        ) {
        try{
            statement.executeUpdate("INSERT INTO estudiantes (matricula, nombre, apellido, calificacion) " +
                                    "VALUES ('"+ matricula +"', '"+ nombre +"', '"+ apellido +"', '"+ calificacion +"')");
        }catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    @DeleteMapping("/estudiantes/{matricula}")
    public void agregarEstudiante(@PathVariable int matricula) {
        try{
            statement.executeUpdate("DELETE FROM estudiantes WHERE matricula = " + matricula);
        }catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }



    //localhost/estudiantes/X
    @PutMapping("/estudiantes/{matricula}")
    public void actualizarEstudiante(@PathVariable int matricula,
                                     @RequestParam String nombre,
                                     @RequestParam String apellido,
                                     @RequestParam String calificacion
                                     ) {
        try{
            statement.executeUpdate("UPDATE estudiantes SET nombre = '"+ nombre +"', apellido = '"+ apellido +"', calificacion = '"+ calificacion +"'  " +
                                    "WHERE matricula = " + matricula);
        }catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }

}
