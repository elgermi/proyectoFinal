package com.example.venta.service;


import com.example.venta.model.ClienteModel;
import com.example.venta.model.DetallesFacturaModel;
import com.example.venta.model.FacturaModel;
import com.example.venta.model.ProductosModel;
import com.example.venta.repository.ClienteRepostitory;
import com.example.venta.repository.DetalleFacturaRepository;
import com.example.venta.repository.FacturaRepository;
import com.example.venta.repository.ProductosReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaYDetalleService {

    @Autowired
    DetalleFacturaRepository detalleFacturaRepository;
    @Autowired
    FacturaRepository facturaRepository;
    @Autowired
    ProductosReposirory productosReposirory;

    @Autowired
    ClienteRepostitory clienteRepostitory;

    public DetallesFacturaModel create(DetallesFacturaModel detalle) {
        return this.detalleFacturaRepository.save(detalle);
    }


    public String finById(Long id) {
        Optional<DetallesFacturaModel> cajaDetalle = this.detalleFacturaRepository.findById(id);


        if (cajaDetalle.isPresent()) {
            DetallesFacturaModel detalle = cajaDetalle.get();

            return detalle.toString();
        }
        return null;
    }








}
