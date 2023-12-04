package com.example.venta.controller;

import com.example.venta.model.ClienteModel;
import com.example.venta.model.DetallesFacturaModel;
import com.example.venta.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.clienteService.finById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ClienteModel> create(@RequestBody ClienteModel cliente) {
        return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
    }
}