/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author 34639
 */
public class Alumno extends Persona {
// coleccion de cursos que tienen los alumnos
    private Set<Curso> cursos;

    // contructor parametrizado
    public Alumno(String dni, String nombre, String apellido1, String apellido2, String direccion) {
    }

    // contructor de copia
    public Alumno(Persona otraPersona) {
        super(otraPersona);
        this.cursos = new HashSet<>();
    }

    // constructor por defecto 
    public Alumno() {
    }
    // getters y setters
    
    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    // Metodo para mostrar un Alumno 
    public void mostrarAlumno() {
        System.out.println("ID " + id);
        System.out.println("DNI " + dni);
        System.out.println("Primer apellido" + apellido1);
        System.out.println("Segundo apellido " + apellido2);
        System.out.println("Nombre " + nombre);
        System.out.println("Direccion " + direccion);
        System.out.println("");
    }
    
   

}
