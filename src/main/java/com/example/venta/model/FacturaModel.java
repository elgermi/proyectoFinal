package com.example.venta.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name="factura")
public class FacturaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facturaid;
    @ManyToOne
    @JoinColumn(name="clienteid")
    private ClienteModel cliente;


    @Column(name="fecha_creacion")
    private LocalDate fechaCreacion;
    private double total;

    @OneToMany
    @JoinColumn(name="factura")
    private Set<DetallesFacturaModel> lineas;

    public Long getFacturaid() {
        return facturaid;
    }

    public void setFacturaid(Long facturaid) {
        this.facturaid = facturaid;
    }

    public Set<DetallesFacturaModel> getLineas() {
        return lineas;
    }

    public void setLineas(Set<DetallesFacturaModel> lineas) {
        this.lineas = lineas;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
