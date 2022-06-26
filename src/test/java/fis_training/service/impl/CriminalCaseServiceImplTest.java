package fis_training.service.impl;

import fis_training.core.CaseStatus;
import fis_training.core.CaseType;
import fis_training.model.Detective;
import fis_training.repo.DetectiveRepo;
import fis_training.service.CriminalCaseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class CriminalCaseServiceImplTest {
@Autowired
private CriminalCaseService criminalCaseService;
private DetectiveRepo detectiveRepo;
    @Test
    void findByLeadInvestigator() {
        Optional<Detective> detective= detectiveRepo.findById(1L);
        assertEquals(2,criminalCaseService.findByLeadInvestigator(detective.get()).size());
    }

    @Test
    void findByNumber() {
        Assertions.assertEquals("1", criminalCaseService.findByNumber("1").get().getNumber());
    }

    @Test
    void findByStatus() {
        assertEquals(2, criminalCaseService.findByStatus(CaseStatus.SUBMITTED).size());
    }

    @Test
    void findByType() {
        assertEquals(1,criminalCaseService.findByType(CaseType.UNCATEGORIZED).size());
    }

    @Test
    void testFindByLeadInvestigator() {
        Optional<Detective> detective= detectiveRepo.findById(1L);
        assertEquals(1, criminalCaseService.findByLeadInvestigator(detective.get()).size());
    }

    @Test
    void testFindByNumber() {
        Assertions.assertEquals("1", criminalCaseService.findByNumber("1").get().getNumber());
    }

    @Test
    void testFindByStatus() {
        assertEquals(2,criminalCaseService.findByStatus(CaseStatus.SUBMITTED).size());
    }

    @Test
    void testFindByType() {
        assertEquals(0,criminalCaseService.findByType(CaseType.UNCATEGORIZED).size());
    }
}