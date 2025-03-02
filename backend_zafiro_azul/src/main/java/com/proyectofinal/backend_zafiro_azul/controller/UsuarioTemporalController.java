package com.proyectofinal.backend_zafiro_azul.controller;


import com.proyectofinal.backend_zafiro_azul.model.UsuarioTemporal;
import com.proyectofinal.backend_zafiro_azul.service.IUsuarioService;
import com.proyectofinal.backend_zafiro_azul.service.Iusuario_TemporalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/usuariotemp")
@RestController
public class UsuarioTemporalController {
    @Autowired
    private Iusuario_TemporalService iusuarioTempServ;


    @GetMapping ("/traer")
    public List<UsuarioTemporal> getUsuario_Temporal(){
        return iusuarioTempServ.getUsuario_Temporal();
    }

    @GetMapping ("/traer_id/{id}")
    public UsuarioTemporal findUsuario_Temporal(@PathVariable Long id){
        return iusuarioTempServ.findUsuario_Temporal(id);
    }

    @PostMapping("/crear")
    public String saveUsuario_Temporal(@RequestBody UsuarioTemporal usuarioTemporal){
        iusuarioTempServ.saveUsuario_Temporal(usuarioTemporal);
        return "El usuario temporal fue creado con exito";
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String>editUsuario_Temporal(
            @PathVariable Long id,
            @RequestBody UsuarioTemporal usuarioTempActualizado){
        iusuarioTempServ.editUsuario_Temporal(id ,usuarioTempActualizado);
        return ResponseEntity.ok("El usuario temporal fue actualizado");
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteUsuario_Temporal(@PathVariable long id){
        iusuarioTempServ.deleteUsuario_Temporal(id);
        return "El usuario temporal fue eliminado";
    }



}

