package com.jzs.registro_usuarios;

import java.util.List;

public class Usuario {
    private int id;
    private String name;
    private String passwd;
    private List<UsuarioRol> roles;
    private List<UsuarioDespacho> despacho;
    
    public Usuario (int id, String name, String passwd, List<UsuarioRol> roles, List<UsuarioDespacho> despacho){
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.roles = roles;
        this.despacho = despacho;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public boolean getPassWd(){
        //supongamos que esta validada 
        if (passwd != "") {
            return true;    
        }else{
            return false;
        }   
    }

    public List<UsuarioRol> getRoles(){
        return roles;
    }

    public List<UsuarioDespacho> getDespacho(){
        return despacho;
    }
}
