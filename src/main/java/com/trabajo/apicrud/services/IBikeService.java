package com.trabajo.apicrud.services;

import com.trabajo.apicrud.entitis.Bicycle;

import java.util.Optional;

public interface IBikeService {
     Bicycle save(Bicycle bike);
     Optional<Bicycle> getById(Long id);
     Bicycle update(Long id, double nuevoPrecio);
     boolean delete(Long id);
}
