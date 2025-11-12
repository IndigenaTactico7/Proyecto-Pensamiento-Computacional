package com.eafit.pensamiento.Controller;

import com.eafit.pensamiento.Base.Residuos;
import com.eafit.pensamiento.Service.ResiduoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residuo")
@CrossOrigin(origins = "http://localhost:5173/")
public class Controller {
    @Autowired
    ResiduoService Residuo;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Residuos residuos) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(Residuo.guardar(residuos));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<?> consultar() throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(Residuo.consultar());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/promedio")
    public ResponseEntity<?> promedios() throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(Residuo.promedios());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("/{idEliminar}")
    public ResponseEntity<?> eliminar(@PathVariable int idEliminar) throws Exception{
        try{
            return ResponseEntity.status(HttpStatus.OK).body(Residuo.eliminarResido(idEliminar));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
    @PutMapping("/{idEditar}")
    public ResponseEntity<?> editar(@RequestBody Residuos residuos, @PathVariable int idEditar) throws Exception{
        try{
            return ResponseEntity.status(HttpStatus.OK).body(Residuo.editar(residuos,idEditar));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


}
