package com.example.venta.controller;

import com.example.venta.model.ClienteModel;
import com.example.venta.model.ProductosModel;
import com.example.venta.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/producto")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @PostMapping("/")
    public ResponseEntity<ProductosModel> create(@RequestBody ProductosModel producto) {
        return new ResponseEntity<>(this.productoService.create(producto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.productoService.findById(id), HttpStatus.OK);
    }


}
