package com.jzs.registro_usuarios;

public class UsuarioRol {
    private int id_rol;
    private String nombre_rol;
    private boolean activo_rol;

    public UsuarioRol (int id_rol, String nombre_rol, boolean activo_rol){
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
        this.activo_rol = activo_rol;
    }

    public int getIdRol(){
        return id_rol;
    }

    public String getNombreRol(){
        return nombre_rol;
    }

    public boolean getActivoRol(){
        return activo_rol;
    }
}
