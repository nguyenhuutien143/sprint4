package fis_training.service.impl;


import fis_training.core.CaseStatus;
import fis_training.core.CaseType;
import fis_training.core.NotFoundException;
import fis_training.model.CriminalCase;
import fis_training.model.Detective;
import fis_training.repo.CriminalCaseRepo;
import fis_training.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CriminalCaseServiceImpl implements CriminalCaseService {
    @Autowired

    private  CriminalCaseRepo criminalCaseRepo;



    @Override
    public List<CriminalCase> findByLeadInvestigator(Detective detective) {
        List<CriminalCase> criminalCaseList= criminalCaseRepo.findAll().stream().filter(criminalCase ->
                detective.getId().equals(criminalCase.getLeadInvestigator())).collect(Collectors.toList());
        return criminalCaseList;
    }

    @Override
    public Optional<CriminalCase> findByNumber(String caseNumber) {
        Optional<CriminalCase> criminalCase= criminalCaseRepo.findAll().stream().
                                                                        filter(c->caseNumber.equals(c.getNumber())).findFirst();
        if(criminalCase.isPresent()) return criminalCase;
        throw new NotFoundException("not found");
    }

    @Override
    public List<CriminalCase> findByStatus(CaseStatus status) {
        List<CriminalCase> criminalCaseList= criminalCaseRepo.findAll().stream().
                filter(c->status.equals(c.getStatus())).collect(Collectors.toList());
        return criminalCaseList;
    }

    @Override
    public List<CriminalCase> findByType(CaseType type) {
        List<CriminalCase> criminalCaseList= criminalCaseRepo.findAll().stream().
                filter(c->type.equals(c.getType())).collect(Collectors.toList());
        return criminalCaseList;
    }
}
