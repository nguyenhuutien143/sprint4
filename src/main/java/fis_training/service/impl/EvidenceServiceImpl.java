package fis_training.service.impl;

import fis_training.core.NotFoundException;
import fis_training.model.CriminalCase;
import fis_training.model.Evidence;
import fis_training.repo.EvidenceRepo;
import fis_training.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EvidenceServiceImpl implements EvidenceService {

    @Autowired
    EvidenceRepo evidenceRepo;

    @Override
    public Evidence save(Evidence evidence) {
        return this.evidenceRepo.save(evidence);
    }

    @Override
    public Evidence update(Evidence evidence) {
        return this.evidenceRepo.save(evidence);
    }

    @Override
    public List<Evidence> getAll() {
        return this.evidenceRepo.findAll();
    }

    @Override
    public Evidence findById(Long id) {
        return this.evidenceRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        Evidence evidence = new Evidence();
        evidence.setId(id);
        this.evidenceRepo.delete(evidence);
    }

    @Override
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
}
