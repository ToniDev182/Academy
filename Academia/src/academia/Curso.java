/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 34639
 */
class Curso {

    private String nombreCurso;
    private int evaluacion1;
    private int evaluacion2;

    // constructor por defecto
    public Curso() {

    }

    public Curso(String nombreCurso, int evaluacion1, int evaluacion2) {
        if (nombreCurso.length() > 20 || !validarCaracteres(nombreCurso)) {
            throw new IllegalArgumentException("el nombre no es valido");
        }
        if (evaluacion1 < 0 || evaluacion1 > 10) {
            throw new IllegalArgumentException("La nota tiene que ser un numero entre 1 y 10");
        }
        if (evaluacion2 < 0 || evaluacion2 > 10) {
            throw new IllegalArgumentException("La nota tiene que ser un numero entre 1 y 10");
        }

        this.nombreCurso = nombreCurso;
        this.evaluacion1 = evaluacion1;
        this.evaluacion2 = evaluacion2;
    }

    public Curso(Curso otroCurso) {
        this.nombreCurso = otroCurso.nombreCurso;
        this.evaluacion1 = otroCurso.evaluacion1;
        this.evaluacion2 = otroCurso.evaluacion2;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        if (nombreCurso.length() > 20 || !validarCaracteres(nombreCurso)) {
            throw new IllegalArgumentException("el nombre no es valido");
        }
        this.nombreCurso = nombreCurso;
    }

    public int getEvaluacion1() {
        return evaluacion1;
    }

    public void setEvaluacion1(int evaluacion1) {
        if (evaluacion1 < 0 || evaluacion1 > 10) {
            throw new IllegalArgumentException("La nota tiene que ser un numero entre 1 y 10");
        }
        this.evaluacion1 = evaluacion1;
    }

    public int getEvaluacion2() {
        return evaluacion2;
    }

    public void setEvaluacion2(int evaluacion2) {
        if (evaluacion2 < 0 || evaluacion2 > 10) {
            throw new IllegalArgumentException("La nota tiene que ser un numero entre 1 y 10");
        }
        this.evaluacion2 = evaluacion2;
    }
    // Metodo para mostrar un Alumno 

    public void mostrarCurso () {
        System.out.println("Nombre del curso " + nombreCurso);
        System.out.println("Nota de la primera evaluacion " + evaluacion1);
        System.out.println("Nota de la segunda evaluacion" + evaluacion2);

    }

    // metodo para validar una cadena de texto
    public static boolean validarCaracteres(String cadena) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+(?:\\s[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cadena);
        return matcher.matches();
    }
}
