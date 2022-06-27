package fis_training.repo;


import fis_training.Sprint4Application;
import fis_training.model.CriminalCase;
import fis_training.model.Detective;
import fis_training.core.CaseStatus;
import fis_training.core.CaseType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = Sprint4Application.class)
class CriminalCaseRepositoryTest {
    @Autowired
    CriminalCaseRepo criminalCaseRepository;

    @Test
    public void testFindById() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        CriminalCase result = this.criminalCaseRepository.findById(employee.getId()).get();
        assertEquals(employee.getId(), result.getId());
    }

    @Test
    public void testSave() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        CriminalCase found = this.criminalCaseRepository.findById(employee.getId()).get();
        assertEquals(employee.getId(), found.getId());
    }


    @Test
    public void testDeleteById() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        this.criminalCaseRepository.deleteById(employee.getId());
        List<CriminalCase> result = new ArrayList<>(this.criminalCaseRepository.findAll());
        assertEquals(result.size(), 1);
    }
    @Test
    public void testFindAll() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        List<CriminalCase> result = new ArrayList<>(this.criminalCaseRepository.findAll());
        assertEquals(result.size(), 2);
    }

    private CriminalCase getCriminalCase() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setCreateAt(LocalDateTime.now());
        criminalCase.setModifiedAt(LocalDateTime.now());
        criminalCase.setVersion(2);
        criminalCase.setDetailedDescription("knduidioa");
        criminalCase.setNotes("nodanda");
        criminalCase.setNumber("231124");
        criminalCase.setShortDescription("009897087");
        criminalCase.setStatus(CaseStatus.valueOf("SUBMITTED"));
        criminalCase.setType(CaseType.valueOf("UNCATEGORIZED"));
        Detective person = new Detective();
        person.setId(3L);
        criminalCase.setLeadInvestigator(person);
        return criminalCase;
    }

}