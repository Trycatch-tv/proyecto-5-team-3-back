package com.reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.reservas.model.Mesa;
import com.reservas.service.MesaService;

@RestController
@CrossOrigin
@RequestMapping("/api/mesa")
public class MesaController {

	@Autowired
    private MesaService mesaService;

    @GetMapping("/")
    public ResponseEntity<List<Mesa>> listarMesa() {
        return ResponseEntity.ok(mesaService.listarMesas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mesa> buscarMesaPorId(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(mesaService.buscarMesaPorId(id));
        }

        catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/")
    public ResponseEntity<Mesa> crearMesa(@RequestBody Mesa mesa) {
        try {
            Mesa mesaCreada = mesaService.crearMesa(mesa);
            return ResponseEntity.ok(mesaCreada);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesa> editarMesa(@PathVariable Long id, @RequestBody Mesa mesa) {
        try {
            Mesa mesaExistente = mesaService.buscarMesaPorId(id);
            System.out.println(mesaExistente);
            if (mesa.getNombre_completo()!= null &&!mesa.getNombre_completo().isEmpty())
                mesaExistente.setNombre_completo(mesa.getNombre_completo());

            if (mesa.getComentario()!= null &&!mesa.getComentario().isEmpty())
            mesaExistente.setComentario(mesa.getComentario());

            if (mesa.getUbicacion()!= null &&!mesa.getUbicacion().isEmpty())
            mesaExistente.setUbicacion(mesa.getUbicacion());

            if (mesa.getCapacidad()!= null &&!mesa.getCapacidad().isEmpty())
            mesaExistente.setCapacidad(mesa.getCapacidad());


            mesaService.actualizarMesa(mesaExistente);

            return ResponseEntity.ok(mesaExistente);

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Mesa> eliminarCliente(@PathVariable Long id) {

        try {
            Mesa mesaEliminada = mesaService.buscarMesaPorId(id);

            mesaService.eliminarMesa(id);
            return ResponseEntity.ok(mesaEliminada);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
