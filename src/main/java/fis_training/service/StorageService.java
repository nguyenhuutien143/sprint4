package fis_training.service;

import fis_training.model.Storage;

import java.util.List;
import java.util.Set;

public interface StorageService {
    Storage save(Storage storage);

    Storage update(Storage storage);

    List<Storage> getAll();

    Storage findById(Long id);

    void delete(Long id);
}
