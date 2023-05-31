package com.trabajo.apicrud.services;

import com.trabajo.apicrud.entitis.Bicycle;
import com.trabajo.apicrud.repository.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class IBikeServiceImpl implements IBikeService{

    @Autowired
    private BicycleRepository bicycleRepository;

    @Override
    public Bicycle save(Bicycle bike) {
        return this.bicycleRepository.save(bike);
    }

    @Override
    public Optional<Bicycle> getById(Long id) {
        return this.bicycleRepository.findById(id);
    }

    @Override
    public Bicycle update(Long id, double nuevoPrecio) {
        Optional<Bicycle> bike = this.bicycleRepository.findById(id);
        if (bike.isPresent()) {
            Bicycle tmp = bike.get();
            tmp.setPrecio(nuevoPrecio);
            return save(tmp);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        this.bicycleRepository.deleteById(id);
        return true;
    }
}
