package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.models.TarefaModel;
import com.api.parkingcontrol.repositories.TarefaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

    @Service
public class TarefaService {

    final TarefaRepository tarefaRepository;

    public TarefaService (TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel){
        return tarefaRepository.save(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return tarefaRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return tarefaRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
            return tarefaRepository.existsByApartmentAndBlock(apartment, block);
    }

    public Page<TarefaModel> findAll(Pageable pageable) {
        return tarefaRepository.findAll(pageable);
    }

    public Optional<TarefaModel> findById(UUID id) {
        return tarefaRepository.findById(id);
    }

    public void delete(TarefaModel tarefaModel) {
        tarefaRepository.delete(tarefaModel);
    }
}
