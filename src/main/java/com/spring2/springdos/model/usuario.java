package com.spring2.springdos.model;

public class usuario {
    private int id;
    private String nombre;
    private String email;
    private String password;
    private String numeroTelefono;
    
    public usuario(int id, String nombre, String email, String password, String numeroTelefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.numeroTelefono = numeroTelefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

}
