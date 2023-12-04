package com.example.venta.controller;

import com.example.venta.model.DetallesFacturaModel;
import com.example.venta.service.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/detalleFactura")
public class DetalleFacturaController {

    @Autowired
    DetalleFacturaService detalleFacturaService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.detalleFacturaService.finById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<DetallesFacturaModel> create(@RequestBody DetallesFacturaModel detalle){
        return new ResponseEntity<> ( this.detalleFacturaService.create(detalle), HttpStatus.CREATED);
    }
}
