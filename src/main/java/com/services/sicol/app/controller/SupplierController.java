package com.services.sicol.app.controller;

import com.services.sicol.app.dto.SupplierDTO;
import com.services.sicol.app.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping()
    public List<SupplierDTO> getAllSuppliers() {
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public SupplierDTO getSupplierById(@PathVariable Integer id) {
        return supplierService.findById(id);
    }

    @PostMapping()
    public SupplierDTO createSupplier(@RequestBody SupplierDTO supplierDTO) {
        return supplierService.save(supplierDTO);
    }
}
