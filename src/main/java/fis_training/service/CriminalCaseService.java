package fis_training.service;

import fis_training.core.CaseStatus;
import fis_training.core.CaseType;
import fis_training.model.CriminalCase;
import fis_training.model.Detective;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CriminalCaseService {
    CriminalCase save(CriminalCase criminalCase);
    CriminalCase update(CriminalCase criminalCase);
    List<CriminalCase> getAll();
    CriminalCase getCriminalCase(Long id);
    void delete(Long id);
    List<CriminalCase> findByLeadInvestigator(Detective detective);
    Optional<CriminalCase> findByNumber(String caseNumber);
    List<CriminalCase> findByStatus(CaseStatus status);
    List<CriminalCase> findByType(CaseType type);
}
