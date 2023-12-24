package com.example.venta.service;

import com.example.venta.dto.DetalleFacturaDTO;
import com.example.venta.dto.FacturaDTO;
import com.example.venta.model.*;
import com.example.venta.repository.ClienteRepostitory;
import com.example.venta.repository.FacturaRepository;
import com.example.venta.repository.ProductosReposirory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class FacturaYDetalleService {

    @Autowired
    FacturaRepository facturaRepository;
    @Autowired
    ProductosReposirory productosReposirory;

    @Autowired
    ClienteRepostitory clienteRepostitory;

   // @Autowired
    //RestTemplate restTemplate;


    public List<FacturaDTO> findAll() {
        return facturaDTOSArmado(this.facturaRepository.findAll());
    }



    public FacturaDTO save(FacturaModel factura){
        var facturaReal=armarFactura(factura);
        return armarFacturaDTO(this.facturaRepository.save(facturaReal));


    }


    public FacturaDTO finById(Long id) {
        Optional<FacturaModel> cajaDetalle = this.facturaRepository.findById(id);
        if (cajaDetalle.isPresent()) {
            FacturaModel detalle = cajaDetalle.get();
            return armarFacturaDTO(cajaDetalle.get());
        }else{
        return new FacturaDTO();
        }
    }

    public List<FacturaDTO> facturaDTOSArmado(List<FacturaModel> factura){
        List<FacturaDTO> dtos=new ArrayList<FacturaDTO>();
        for (FacturaModel facturas: factura) {
            dtos.add(armarFacturaDTO(facturas));

        }
        return dtos;
    }
    public FacturaDTO armarFacturaDTO(FacturaModel factura){
        FacturaDTO dto=new FacturaDTO();

        dto.setFechaCreacion(factura.getFechaCreacion());
        dto.setTotal(factura.getTotal());
        dto.setCliente(factura.getCliente());
        dto.setId(factura.getFacturaid());
        dto.setLineas(crearLineasDTO(factura.getLineas()));

        return dto;
    }

    private Set<DetalleFacturaDTO> crearLineasDTO(Set<DetallesFacturaModel> lineas) {
        Set<DetalleFacturaDTO> dtos = new HashSet<DetalleFacturaDTO>();

        for (DetallesFacturaModel linea : lineas) {

            DetalleFacturaDTO dto = new DetalleFacturaDTO();

            dto.setId(linea.getId());
            dto.setFactura(linea.getFactura());
            dto.setProducto(linea.getProducto());
            dto.setCantidadProductos(linea.getCantidadProductos());


        }
        return dtos;
    }
    public DetallesFacturaModel crearLineas(DetallesFacturaModel detalle){
        var linea=new DetallesFacturaModel();
        linea.setFactura(detalle.getFactura());
        linea.setId(detalle.getId());
        linea.setProducto(detalle.getProducto());
        linea.setImporte(detalle.getImporte());
        linea.setCantidadProductos(detalle.getCantidadProductos());

        return linea;

    }

    public FacturaModel armarFactura(FacturaModel factura){
        FacturaModel facturaGuardado=new FacturaModel();


        facturaGuardado.setCliente(this.clienteRepostitory.findById(factura.getCliente().getId()).get());
        facturaGuardado.setFechaCreacion(LocalDate.now());


        /*Worldclock worldClock = this.restTemplate.getForObject("http://worldclockapi.com/api/json/utc/now", Worldclock.class);

        String currentDateTime = worldClock.getCurrentDateTime();
        // "2021-12-08T17:36Z"
        try {
            Date date1=new SimpleDateFormat("yyyy-MM-dd'T'mm:ss'Z'").parse(currentDateTime);
            facturaGuardado.setFechaCreacion(date1);
        } catch (ParseException e) {
            e.printStackTrace();
            facturaGuardado.setFechaCreacion(new Date());
        }*/

        facturaGuardado.setLineas(new HashSet<DetallesFacturaModel>());
         List<DetallesFacturaModel> dtos=new ArrayList<DetallesFacturaModel>();
        for (DetallesFacturaModel linea : factura.getLineas()) {
            dtos.add(crearLineas((DetallesFacturaModel) factura.getLineas()));
            facturaGuardado= (FacturaModel) dtos;

        }

        facturaGuardado.setTotal(calcularTotal(factura.getLineas()));
        facturaGuardado.setLineas(factura.getLineas());


        return facturaGuardado;
    }


    public Float calcularTotal(Set<DetallesFacturaModel> detalles) {
        float totales = 0;
        for (DetallesFacturaModel detalle : detalles) {
            totales += detalle.getProducto().getPrecio();
        }
        return totales;
    }

    public void calcularStock(Set<DetallesFacturaModel> detalles){

        var nuevoStock=0;
        for (DetallesFacturaModel detalle:detalles) {
            var producto=detalle.getProducto();
            var stockBD=this.productosReposirory.getById(producto.getId());
            var stock= detalle.getProducto().getStock();
            nuevoStock=detalle.getCantidadProductos()-stock;
            stockBD.setStock(nuevoStock);
             this.productosReposirory.save(stockBD);

        }

    }





}
