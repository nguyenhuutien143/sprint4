package fis_training.service;



import fis_training.model.Storage;

import java.util.Optional;

public interface StorageService {
    Optional<Storage> findByName(String name);

    Optional<Storage> findByLocation(String location);
}

