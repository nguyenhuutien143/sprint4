package fis_training.service;

import fis_training.model.CriminalCase;
import fis_training.model.Evidence;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EvidenceService {
    Evidence save(Evidence evidence);

    Evidence update(Evidence evidence);

    List<Evidence> getAll();

    Evidence findById(Long id);

    void delete(Long id);
    List<Evidence> findByCriminalCase(CriminalCase criminalCase);
    Optional<Evidence> findByNumber(String evidenceNumber);
}
