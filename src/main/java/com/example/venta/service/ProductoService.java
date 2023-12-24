package com.example.venta.service;

import com.example.venta.model.ClienteModel;
import com.example.venta.model.ProductosModel;
import com.example.venta.repository.ProductosReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.type.DeclaredType;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    ProductosReposirory productosReposirory;

    public ProductosModel create(ProductosModel cliente) {
        return this.productosReposirory.save(cliente);
    }

    public ProductosModel findById(Long id){
        Optional<ProductosModel> cajaProducto=this.productosReposirory.findById(id);

        if(cajaProducto.isPresent()){
            ProductosModel producto= cajaProducto.get();
            return producto;
        }
        return null;
    }

}
