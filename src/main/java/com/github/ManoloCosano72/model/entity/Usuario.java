package com.github.ManoloCosano72.model.entity;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
    protected String nombre;

    protected String correo;

    protected String contrasena;
    protected boolean esTrabajador;

    public Usuario(String nombre, String correo, String contrasena, boolean esTrabajador) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.esTrabajador = esTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEsTrabajador() {
        return esTrabajador;
    }

    public void setEsTrabajador(boolean esTrabajador) {
        this.esTrabajador = esTrabajador;
    }
    public static boolean validatePassword(String password) {
        boolean validateResult;
        Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!.#_()%*?&])[A-Za-z\\d@$!.#_()%*?&]{8,}$");
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (passwordMatcher.matches()) {
            validateResult = true;
        } else {
            validateResult = false;
        }
        return validateResult;
    }

    public static boolean validateMail(String mail) {
        boolean validateResult;
        Pattern mailPattern = Pattern.compile("[A-Za-z0-9]+@+(gmail|outlook|hotmail)\\.(com|es)");
        Matcher mailMatcher = mailPattern.matcher(mail);
        if (mailMatcher.matches()) {
            validateResult = true;
        } else {
            validateResult = false;
        }
        return validateResult;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Usuario usuario = (Usuario) object;
        return Objects.equals(correo, usuario.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correo);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", esTrabajador=" + esTrabajador +
                '}';
    }
}
