package fis_training.repo;


import fis_training.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriminalCaseRepo extends JpaRepository<CriminalCase, Long> {
}
