package fis_training.service;



import fis_training.model.CriminalCase;
import fis_training.model.Evidence;
import fis_training.model.Storage;

import java.util.List;
import java.util.Optional;

public interface EvidenceService extends AbstractService<Evidence> {
    List<Evidence> findByCriminalCase(CriminalCase criminalCase);
    Optional<Evidence> findByNumber(String evidenceNumber);
    boolean isInStorage(Storage storage);

}
