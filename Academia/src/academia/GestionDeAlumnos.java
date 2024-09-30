/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author 34639
 */
public class GestionDeAlumnos {

    // coleccion de alumnos
    HashMap<UUID, Alumno> alumnos = new HashMap<>();
// metodo que leer un alumno y devuelve un alumno 

    public static Alumno leerAlumno() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el DNI: ");
        String dni = scanner.nextLine();

        System.out.println("Introduce el Nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Introduce el primer apellido: ");
        String apellelido1 = scanner.nextLine();

        System.out.println("Introduce el segundo apellido: ");
        String apellelido2 = scanner.nextLine();

        System.out.println("Introduce la direccion: ");
        String direccion = scanner.nextLine();

        return new Alumno(dni, nombre, apellelido1, apellelido2, direccion);

    }

    // metodo que lee un curso y devuelve un curso
    public static Curso leerCurso() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre del curso: ");
        String nombreCurso = scanner.nextLine();

        System.out.println("Introduce la nota de la primera evaluación: ");
        int evaluacion1 = scanner.nextInt();

        System.out.println("Introdice la nota de la segunda evaluación: ");
        int evaluacion2 = scanner.nextInt();

        return new Curso(nombreCurso, evaluacion1, evaluacion2);

    }

    // metodo para añadir una persona y verificqar si su dni ya estaba antes en la lista
    public void añadirAlumno(Alumno alumno) {

        for (Alumno alumnoRegistrado : alumnos.values()) {
            if (alumno.getDni().equals(alumnoRegistrado.getDni())) {
                throw new IllegalArgumentException("El dni ya existe");

            }
        }
        alumnos.put(alumno.getId(), alumno);
    }

    // mostrar alumno por id
    public Alumno mostrarAlumno(UUID id) {
        return alumnos.get(id);
    }

    // borrar alumno
    public void borrarAlumno(UUID id) {
        alumnos.remove(id);

    }

    // metodo para listar todas las personas por nombre y apellido
    public List<Alumno> alumnosOrdenados() {
        // crea una lista a partir de de los valores del hashMap
        List<Alumno> listaAlumnos = new ArrayList<>(alumnos.values());
        // ordena la lista usando comparadores
        listaAlumnos.sort(Comparator.comparing(Persona::getApellido1).thenComparing(Persona::getNombre));
        return listaAlumnos;
    }

    // metodo para mostrar todos los alumnos matriculados en un curso 
    public List<Alumno> alumnosCurso(String nombreCur) {

        List<Alumno> alumnosEnCurso = new ArrayList<>();
        alumnos.values().forEach(alumno -> {
            alumno.getCursos().forEach(curso -> {
                if (curso.getNombreCurso().equals(nombreCur)) {

                    alumnosEnCurso.add(alumno);

                }

            });
        });
        return alumnosEnCurso;
    }

    public List<Alumno> alumnosAprobados() {

        // creamos una lista para guardar los aprobados 
        List<Alumno> alumnosAprobados = new ArrayList<>();

        for (Alumno alumno : alumnos.values()) {
            // bandera para saber si en algun momento algo no está aprobado 
            boolean todoaprobado = true;
            for (Curso curso : alumno.getCursos()) {
                // recoremos los alumnos on sus valores y los cursos , despues de recorrer los cursos
                // si ninguno esta suspenso lo agregamos a la lista. 
                if (curso.getEvaluacion1() < 5 && curso.getEvaluacion2() < 5) {
                    todoaprobado = false;
                }
            }
            if (todoaprobado) {
                alumnosAprobados.add(alumno);
            }

        }
        return alumnosAprobados;
    }

    // metodo para guardar los alumnos en un fichero binario
    public void guardarDatos() {

        // creamos un objeto de archivo binario y le damos nombre
        File archivoBin = new File("Datos_Alumnos.bin");
        if (archivoBin.exists() && archivoBin.isFile()) {
            try (ObjectOutput guardado = new ObjectOutputStream(new FileOutputStream(archivoBin))) {
                guardado.writeObject(alumnos); // escribir el mapa de alumnos en el archivo 
            } catch (IOException E) {
                E.printStackTrace();
            }
        }

    }

    public void cargarDatos() {
        // creamos el archivo y verificamos si tipo archivo y si existe
        File archivoBin = new File("Datos_Alumnos.bin");
        if (archivoBin.exists() && archivoBin.isFile()) {
            // Flujo de entrada de datos. 
            try (ObjectInputStream Cargado = new ObjectInputStream(new FileInputStream(archivoBin))) {
                alumnos = (HashMap<UUID, Alumno>) Cargado.readObject(); // escribir el mapa de alumnos en el archivo 
                System.out.println("Datos cargados correctamente");
            } catch (IOException | ClassNotFoundException e) {

            }
        }

    }
}



