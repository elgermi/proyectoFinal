package com.example.venta.service;

import com.example.venta.model.ClienteModel;
import com.example.venta.repository.ClienteRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepostitory clienteRepostitory;

    public ClienteModel create(ClienteModel cliente) {
        return this.clienteRepostitory.save(cliente);
    }

    public String finById(Long id) {
        Optional<ClienteModel> cajaDetalle = this.clienteRepostitory.findById(id);


        if (cajaDetalle.isPresent()) {
            ClienteModel cliente = cajaDetalle.get();

            return cliente.toString();
        }
        return null;
    }
}
