package com.example.venta.controller;

import com.example.venta.dto.FacturaDTO;
import com.example.venta.model.DetallesFacturaModel;
import com.example.venta.model.FacturaModel;
import com.example.venta.service.FacturaYDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Factura")
public class FacturaYDetalleController {

    @Autowired
    FacturaYDetalleService facturaService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.facturaService.finById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public FacturaDTO newEntity(@RequestBody FacturaModel factura){
         return this.facturaService.save(factura);
    }
}
/*
{
"clientes":{"id":2},
"detalle_Factura":[
    {
        "cantidad":3,
        "producto":{"id":2}
    },
    {
        "cantidad":5,
        "producto":{"id":3}
    }
]
}
 */