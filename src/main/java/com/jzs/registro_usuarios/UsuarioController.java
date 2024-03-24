package com.jzs.registro_usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioController(){
        usuarios.add(
            new Usuario(1, "JZAPATA", "PASSWORD123", 
                Arrays.asList(
                    new UsuarioRol(1, "ADMINISTRADOR", true),
                    new UsuarioRol(2, "SUPERVISOR", false),
                    new UsuarioRol(3, "USUARIO", false)
                ),
                Arrays.asList(
                    new UsuarioDespacho(1, "CANAL SARMIENTO #9865, PUERTO MONTT", true),
                    new UsuarioDespacho(2, "PASAJE MAWUN #2525, PUERTO VARAS", false)
                )
            )
        );
        usuarios.add(
            new Usuario(2, "PSALINAS", "PASSWORD123", 
                Arrays.asList(
                    new UsuarioRol(1, "USUARIO", true)
                ),
                Arrays.asList(
                    new UsuarioDespacho(1, "SAN FRANCISCO JAVIER #2634, SAN FELIPE", true)
                )
            )
        );
        usuarios.add(
            new Usuario(3, "JMOIL", "PASSWORD123", 
                Arrays.asList(
                    new UsuarioRol(1, "USUARIO", false),
                    new UsuarioRol(2, "SUPERVISOR", true)
                ),
                Arrays.asList(
                    new UsuarioDespacho(1, "GUATICAS #9765, LLANQUIHUE", false),
                    new UsuarioDespacho(2, "AV. AUSTRAL #6584, PUERTO MONTT", true)
                )
            )
        );
        usuarios.add(
            new Usuario(3, "CNAVARRO", "PASSWORD123", 
                Arrays.asList(
                    new UsuarioRol(1, "SUPERVISOR", true)
                ),
                Arrays.asList(
                    new UsuarioDespacho(1, "LAS CAMELIAS #423, VALPARAISO", true)
                )
            )
        );  
        usuarios.add(
            new Usuario(3, "BZAMORA", "PASSWORD123", 
                Arrays.asList(
                    new UsuarioRol(1, "USUARIO", true)
                ),
                Arrays.asList(
                    new UsuarioDespacho(1, "TOCORNAL #8756, SAN FELIPE", true)
                )
            )
        );  
    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @GetMapping("/usuarios/{id}")
    public Usuario getUsuarioById(@PathVariable int id){
        for (Usuario usuario : usuarios){
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    @GetMapping("/usuarios/{id}/rolActual")
    public UsuarioRol getRolActualUsuario(@PathVariable int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                for (UsuarioRol rol : usuario.getRoles()) {
                    if (rol.getActivoRol()) {
                        return rol;
                    }
                }
                return null;
            }
        }
        return null;
    }

    @GetMapping("/usuarios/{id}/despachoActivo")
    public UsuarioDespacho getDespachoActualUsuario(@PathVariable int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                for (UsuarioDespacho despacho : usuario.getDespacho()) {
                    if (despacho.getActivoDespacho()) {
                        return despacho;
                    }
                }
                return null;
            }
        }
        return null;
    }  
    
    @GetMapping("/usuarios/porRol/{rol}/{activo}")
    public List<Map<String, Object>> getUsuariosPorRol(@PathVariable String rol, @PathVariable boolean activo) {
        List<Map<String, Object>> usuariosFiltrados = new ArrayList<>();
    
        for (Usuario usuario : usuarios) {
            for (UsuarioRol usuarioRol : usuario.getRoles()) {
                if (usuarioRol.getNombreRol().equalsIgnoreCase(rol) && usuarioRol.getActivoRol() == activo) {
                    Map<String, Object> usuarioInfo = new HashMap<>();
                    usuarioInfo.put("id", usuario.getId());
                    usuarioInfo.put("name", usuario.getName());
                    
                    usuariosFiltrados.add(usuarioInfo);
                    break;
                }
            }
        }
    
        return usuariosFiltrados;
    }

    @GetMapping("/usuarios/despachoActual/{activo}")
    public List<Map<String, Object>> getUsuariosPorDespachoActual(@PathVariable boolean activo) {
        List<Map<String, Object>> usuariosConDespacho = new ArrayList<>();
    
        for (Usuario usuario : usuarios) {
            for (UsuarioDespacho despacho : usuario.getDespacho()) {
                if (despacho.getActivoDespacho() == activo) {
                    Map<String, Object> usuarioInfo = new HashMap<>();
                    usuarioInfo.put("id", usuario.getId());
                    usuarioInfo.put("name", usuario.getName());
                    usuarioInfo.put("direccionDespacho", despacho.getDireccionDespacho());
                    
                    usuariosConDespacho.add(usuarioInfo);
                }
            }
        }
    
        return usuariosConDespacho;
    }
    
}
