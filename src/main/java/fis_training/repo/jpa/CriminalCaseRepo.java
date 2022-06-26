package fis_training.repo.jpa;


import fis_training.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CriminalCaseRepo extends JpaRepository<CriminalCase,Long> {
//    Set<CriminalCase> findByLeadInvestigator(Detective detective);
//    Optional<CriminalCase> findByNumber(String caseNumber);
//    Set<CriminalCase> findByStatus(CaseStatus status);
//    Set<CriminalCase> findByType(CaseType type);
}
