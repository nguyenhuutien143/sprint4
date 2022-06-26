package fis_training.repo.jpa;


import fis_training.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenceRepo extends JpaRepository<Evidence,Long> {
//    Set<Evidence> findByCriminalCase(CriminalCase criminalCase);
//    Optional<Evidence> findByNumber(String evidenceNumber);
//    boolean isInStorage(Storage storage);
}
