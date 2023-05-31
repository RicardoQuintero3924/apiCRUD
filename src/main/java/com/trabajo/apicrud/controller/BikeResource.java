package com.trabajo.apicrud.controller;

import com.trabajo.apicrud.entitis.Bicycle;
import com.trabajo.apicrud.services.IBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BikeResource {

    @Autowired
    private IBikeService bikeService;

    @PostMapping("/Bicycle")
    public ResponseEntity<Bicycle> crearBicileta(@RequestBody Bicycle bike) {
        return new ResponseEntity(this.bikeService.save(bike), HttpStatus.CREATED);
    }

    @GetMapping("/Bicycle/{id}")
    public ResponseEntity<Bicycle> obtenerBike(@PathVariable("id") Long id){
        Optional<Bicycle> optionalBicycle = this.bikeService.getById(id);
        if (optionalBicycle.isPresent())
            return new ResponseEntity(optionalBicycle.get(), HttpStatus.OK);
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/Bicycle/{id}/nuevoprecio/{precio}")
    public ResponseEntity<Bicycle> actualizarBike(@PathVariable("id") Long id, @PathVariable("precio") double precio){
        Bicycle bikeUpdate = this.bikeService.update(id, precio);
        if (bikeUpdate != null){
            return new ResponseEntity(bikeUpdate, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/Bicycle/{id}")
    public ResponseEntity<Void> eliminarBike(@PathVariable("id") Long id){
        this.bikeService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
