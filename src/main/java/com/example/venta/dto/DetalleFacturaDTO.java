package com.example.venta.dto;

import com.example.venta.model.FacturaModel;
import com.example.venta.model.ProductosModel;;
import lombok.Data;




public class DetalleFacturaDTO {
    private Long id;
    private FacturaModel factura;
    private int cantidadProductos;
    private ProductosModel producto;
    private double importe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FacturaModel getFactura() {
        return factura;
    }

    public void setFactura(FacturaModel factura) {
        this.factura = factura;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public ProductosModel getProducto() {
        return producto;
    }

    public void setProducto(ProductosModel producto) {
        this.producto = producto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
