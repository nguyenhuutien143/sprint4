package fis_training.repo;

import fis_training.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvidenceRepo extends JpaRepository<Evidence, Long> {
}
