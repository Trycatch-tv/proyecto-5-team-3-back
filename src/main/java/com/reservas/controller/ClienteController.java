package com.reservas.controller;

import com.reservas.model.Cliente;
import com.reservas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("listarClientes")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }
    @GetMapping("buscarCliente/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(clienteService.buscarClientePorId(id));
        }

        catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("crearCliente")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Boolean resultado = true;
        if (cliente.getNombre_completo()!= null &&!cliente.getNombre_completo().isEmpty())
            resultado = false;

        if (cliente.getComentario()!= null &&!cliente.getComentario().isEmpty())
            resultado = false;

        if (cliente.getCorreo()!= null &&!cliente.getCorreo().isEmpty())
            resultado = false;

        if (cliente.getTelefono()!= null &&!cliente.getTelefono().isEmpty())
            resultado = false;
        if (resultado){
        Cliente clienteCreado = clienteService.crearCliente(cliente);
        return ResponseEntity.ok(clienteCreado);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("editarCliente/{id}")
    public ResponseEntity<Cliente> editarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            Cliente clienteExistente = clienteService.buscarClientePorId(id);

            if (cliente.getNombre_completo()!= null &&!cliente.getNombre_completo().isEmpty())
                clienteExistente.setNombre_completo(cliente.getNombre_completo());

            if (cliente.getComentario()!= null &&!cliente.getComentario().isEmpty())
            clienteExistente.setComentario(cliente.getComentario());

            if (cliente.getCorreo()!= null &&!cliente.getCorreo().isEmpty())
            clienteExistente.setCorreo(cliente.getCorreo());

            if (cliente.getTelefono()!= null &&!cliente.getTelefono().isEmpty())
            clienteExistente.setTelefono(cliente.getTelefono());


            clienteService.actualizarCliente(clienteExistente);

            return ResponseEntity.ok(clienteExistente);

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("eliminarCliente/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long id) {

            clienteService.eliminarCliente(id);
            return ResponseEntity.ok().build();
    }



}
