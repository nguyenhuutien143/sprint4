package fis_training.service.impl;
import fis_training.model.Storage;
import fis_training.repo.StorageRepo;
import fis_training.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageRepo storageRepository;

    @Override
    public Storage save(Storage storage) {
        return this.storageRepository.save(storage);
    }

    @Override
    public Storage update(Storage storage) {
        return this.storageRepository.save(storage);
    }

    @Override
    public List<Storage> getAll() {
        return this.storageRepository.findAll();
    }

    @Override
    public Storage findById(Long id) {
        return this.storageRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        Storage storage = new Storage();
        storage.setId(id);
        this.storageRepository.delete(storage);
    }
}
