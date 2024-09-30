/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package academia;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author 34639
 */
public class Academia {

    static Scanner scanner = new Scanner(System.in);
    static GestionDeAlumnos gestor = new GestionDeAlumnos();

    public static void main(String[] args) {

        gestor.cargarDatos();

        System.out.println("Bienvenido al sitema de gestion del alumnado");

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Agregar un Alumno");
            System.out.println("2. Consultar Persona por ID ");
            System.out.println("3. Eliminar Persona");
            System.out.println("4. Listar Alumnos Alfabeticamente");
            System.out.println("5. Listar Alumnos por Curso ");
            System.out.println("6. Mostar Alumnos con todo aprobado");
            System.out.println("7. Salir");

            System.out.println("Seleccione una opcion");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    // agregar alumno
                    Alumno nuevoAlumno = GestionDeAlumnos.leerAlumno();
                    gestor.añadirAlumno(nuevoAlumno);
                    gestor.guardarDatos();
                    System.out.println("Persona guardada correctamente");
                    break;
                // consultar alumno por id
                case 2:
                    System.out.println("Introduce el ID del Alumno");
                    String idConsulta = scanner.nextLine();
                    Alumno alumnoConsulta = gestor.mostrarAlumno(UUID.fromString(idConsulta));
                    if (alumnoConsulta != null) {
                        System.out.println("Alumno encontrado");

                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    break;
                // borrar un alumno
                case 3:
                    System.out.println("Introduce el ID del Alumno a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    gestor.borrarAlumno(UUID.fromString(idEliminar));
                    gestor.guardarDatos();
                    System.out.println("Alumno eliminado correctamente");
                    List<Alumno> listaAlumnos = gestor.alumnosOrdenados();
                    System.out.println("Listado de Alumnos");
                    for (Alumno alumno : listaAlumnos) {
                        alumno.mostrarAlumno();
                    }
                    break;

                // Ordenar alumnos por apellidos y nombre
                case 4:

                    for (Alumno alumno : gestor.alumnosOrdenados()) {
                        alumno.mostrarAlumno();
                    }
                    break;

                case 5:

                    // ordenar los alumnos por curso
                    System.out.println("Inserte el nombre del curso que quiere buscar: ");
                    String cursoBuscar = (scanner.nextLine());
                    List<Alumno> alumnosCurso = gestor.alumnosCurso(cursoBuscar);
                    if (alumnosCurso.isEmpty()) {
                        System.out.println("Nos se ha encontrado ningun alumno en este curso: " + cursoBuscar);

                    } else {
                        System.out.println("Los alumnos matriculados en el curso " + cursoBuscar + " son: ");
                        for (Alumno alumno : alumnosCurso) {
                            alumno.mostrarAlumno();
                        }

                    }

                    break;
                // alumnos que lo tienen todo aprobado
                case 6:
                    System.out.println("Los alumnos que tienen todo aprobado son: ");
                    for (Alumno alumno : gestor.alumnosAprobados()) {
                        alumno.mostrarAlumno();
                    }
                    break;
                // salir
                case 7:

                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida. porfavor, seleccione una opcion valida. ");

            }

        }

    }

}
