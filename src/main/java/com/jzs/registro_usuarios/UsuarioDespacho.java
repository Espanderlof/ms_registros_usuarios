package com.jzs.registro_usuarios;

public class UsuarioDespacho {
    private int id_despacho;
    private String direccion_despacho;
    private boolean activo_despacho;

    public UsuarioDespacho (int id_despacho, String direccion_despacho, boolean activo_despacho){
        this.id_despacho = id_despacho;
        this.direccion_despacho = direccion_despacho;
        this.activo_despacho = activo_despacho;
    }

    public int getIdDespacho(){
        return id_despacho;
    }

    public String getDireccionDespacho(){
        return direccion_despacho;
    }

    public boolean getActivoDespacho(){
        return activo_despacho;
    }
}
