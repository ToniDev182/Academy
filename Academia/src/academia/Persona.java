/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academia;

import java.io.Serializable;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 34639
 */
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    protected UUID id;
    protected String dni;
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected String direccion;

    // contructor por defecto
    public Persona() {

    }

    // contructor parametrizado
    public Persona(String dni, String nombre, String apellido1, String apellido2, String direccion) {
        if (!dni.matches("\\d{8}[a-zA-Z]")) {
            throw new IllegalArgumentException("el DNI no es valido.");
        }
        if (nombre.length() > 20 || !validarTexto(nombre)) {
            throw new IllegalArgumentException("el nombre no es valido.");

        }

        if (apellido1.length() > 20 || !validarTexto(apellido1)) {
            throw new IllegalArgumentException("el nombre no es valido.");
        }

        if (apellido2.length() > 20 || !validarTexto(apellido2)) {
            throw new IllegalArgumentException("el nombre no es valido.");
        }

        if (direccion.length() > 20 || !validarTexto(direccion)) {
            throw new IllegalArgumentException("el nombre no es valido.");
        }
        this.id = UUID.randomUUID();
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
    }

    // constructor por defeceto 
    public Persona(Persona otrapersona) {
        this.id = otrapersona.id;
        this.dni = otrapersona.dni;
        this.nombre = otrapersona.nombre;
        this.apellido1 = otrapersona.apellido1;
        this.apellido2 = otrapersona.apellido2;
        this.direccion = otrapersona.direccion;

    }

    // metodo para validar una cadena de texto
    public static boolean validarTexto(String nombre) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+(?:\\s[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nombre);
        return matcher.matches();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (!dni.matches("\\d{8}[a-zA-Z]")) {
            throw new IllegalArgumentException("el DNI no es valido.");
        }
        this.dni = dni;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() > 20 || !validarTexto(nombre)) {
            throw new IllegalArgumentException("el apellido no es valido.");
        }
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        if (apellido1.length() > 20 || !validarTexto(apellido1)) {
            throw new IllegalArgumentException("el apellido no es valido.");
        }
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        if (apellido2.length() > 20 || !validarTexto(apellido2)) {
            throw new IllegalArgumentException("el Apellido no es valido.");
        }
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion.length() > 20 || !validarTexto(direccion)) {
            throw new IllegalArgumentException("el nombre no es valido.");
        }
        this.direccion = direccion;
    }

}
