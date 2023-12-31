package com.example.venta.model;

import jakarta.persistence.*;


@Entity
@Table(name="linea")
public class DetallesFacturaModel {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn(name="facturaid")
    private FacturaModel factura;
    @Column(name="cantidad")
    private int cantidadProductos;
    @ManyToOne
    @JoinColumn(name="productosid")
    private ProductosModel producto;
    public DetallesFacturaModel() {
    }
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
