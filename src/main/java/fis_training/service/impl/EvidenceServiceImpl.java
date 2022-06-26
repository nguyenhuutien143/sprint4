package fis_training.service.impl;


import fis_training.core.NotFoundException;
import fis_training.model.CriminalCase;
import fis_training.model.Evidence;
import fis_training.model.Storage;
import fis_training.repo.EvidenceRepo;
import fis_training.service.AbstractService;
import fis_training.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service

public class EvidenceServiceImpl implements EvidenceService{
    @Autowired
    private EvidenceRepo evidenceRepo;
    public List<Evidence> findByCriminalCase(CriminalCase criminalCase) {
        List<Evidence> evidenceList= evidenceRepo.findAll().stream().
                filter(e->criminalCase.getId().equals(e.getCriminalCase())).collect(Collectors.toList());
        return evidenceList;
    }

    @Override
    public Optional<Evidence> findByNumber(String evidenceNumber) {
        Optional<Evidence> evidence= evidenceRepo.findAll().stream().
                filter(e->evidenceNumber.equals(e.getNumber())).findFirst();
        if(evidence.isPresent()) return evidence;
        throw new NotFoundException("not found");
    }

    @Override
    public boolean isInStorage(Storage storage) {
        Optional<Evidence> evidence= evidenceRepo.findAll().stream().
                filter(e->storage.getId().equals(e.getStorage())).findFirst();
        if (evidence.isPresent()) return  true;
        return false;
    }

    @Override
    public void save(Evidence entity) {
        evidenceRepo.save(entity);
    }

    @Override
    public void delete(Evidence entity) {
        evidenceRepo.delete(entity);
    }

    @Override
    public Evidence update(Evidence entity) {
        evidenceRepo.save(entity);
        return entity;
    }

    @Override
    public int deleteById(Long entityId) {

        evidenceRepo.deleteById(entityId);
        if(evidenceRepo.findById(entityId).isPresent()) return -1;
        return 1;
    }

    @Override
    public Optional<Evidence> findById(Long entityId) {
        Optional<Evidence> evidence= evidenceRepo.findById(entityId);
        return evidence;
    }

    @Override
    public List<Evidence> findAll() {
        return evidenceRepo.findAll();
    }
}
