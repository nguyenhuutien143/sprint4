package fis_training.service.impl;


import fis_training.core.NotFoundException;
import fis_training.model.Storage;
import fis_training.repo.jpa.StorageRepo;
import fis_training.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageRepo storageRepo;
    @Override
    public Optional<Storage> findByName(String name) {
        Optional<Storage> storage= storageRepo.findAll().stream().filter(s-> name.equals(s.getName())).findFirst();
        if(storage.isPresent()) return storage;
        throw new NotFoundException("not found");
    }

    @Override
    public Optional<Storage> findByLocation(String location) {
        Optional<Storage> storage= storageRepo.findAll().stream().filter(s-> location.equals(s.getLocation())).findFirst();
        if(storage.isPresent()) return storage;
        throw new NotFoundException("not found");
    }
}
