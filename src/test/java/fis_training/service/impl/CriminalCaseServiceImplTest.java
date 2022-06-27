package fis_training.service.impl;

import fis_training.core.CaseStatus;
import fis_training.core.CaseType;
import fis_training.model.CriminalCase;
import fis_training.repo.CriminalCaseRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;

@ExtendWith(MockitoExtension.class)
@Slf4j
class CriminalCaseServiceImplTest {
    private CriminalCaseServiceImpl caseServiceImpl;
    private CriminalCaseRepo criminalCaseRepo;
    private CriminalCase criminalCase;

    @BeforeEach
    public void init() {
        criminalCaseRepo = mock(CriminalCaseRepo.class);
        caseServiceImpl = new CriminalCaseServiceImpl(criminalCaseRepo);
        criminalCase = new CriminalCase();
        criminalCase.setId(1L);
        criminalCase.setNumber("CASE001");
        criminalCase.setStatus(CaseStatus.IN_COURT);
        criminalCase.setType(CaseType.FELONY);
        criminalCase.setNotes("Note");
    }
    @Test
    void save() {
        when(criminalCaseRepo.save(criminalCase)).thenReturn(criminalCase);
        CriminalCase savedCriminalCase = caseServiceImpl.save(criminalCase);
        log.info("Created case: {}", savedCriminalCase);
        assertThat(savedCriminalCase).isNotNull();
        verify(criminalCaseRepo, times(1)).save(criminalCase);
    }

    @Test
    void update() {
        log.info("Update before: {}", criminalCase);
        when(criminalCaseRepo.save(criminalCase)).thenReturn(criminalCase);
        criminalCase.setNumber("CASE007");
        criminalCase.setType(CaseType.MISDEMEANOR);
        CriminalCase updatedCriminalCase = caseServiceImpl.update(criminalCase);
        log.info("Updated case: {}", updatedCriminalCase);
        assertThat("CASE007".equals(updatedCriminalCase.getNumber()));
        assertThat(CaseType.MISDEMEANOR.equals(updatedCriminalCase.getType()));
    }

    @Test
    void getAll() {
        List<CriminalCase> criminalCaseList = new ArrayList<>();
        CriminalCase criminalCase1 = new CriminalCase();
        CriminalCase criminalCase2 = new CriminalCase();
        CriminalCase criminalCase3 = new CriminalCase();
        criminalCaseList.add(criminalCase1);
        criminalCaseList.add(criminalCase2);
        criminalCaseList.add(criminalCase3);

        when(criminalCaseRepo.findAll()).thenReturn(criminalCaseList);

        List<CriminalCase> criminalCases = caseServiceImpl.getAll();
        criminalCases.forEach(criminal -> log.info("Case in list: {}", criminal));
        assertEquals(3, criminalCases.size());
        verify(criminalCaseRepo, times(1)).findAll();
    }

    @Test
    void getCriminalCase() {
    }

    @Test
    void delete() {
        caseServiceImpl.delete(criminalCase.getId());
        verify(criminalCaseRepo, times(1)).deleteById(criminalCase.getId());
    }

    @Test
    void findByLeadInvestigator() {
        List<CriminalCase> criminalCaseList = new ArrayList<>();
        CriminalCase criminalCase1 = CriminalCase.builder()
                .number("Case1")
                .build();
        CriminalCase criminalCase2 = CriminalCase.builder()
                .number("case2")
                .build();
        criminalCaseList.add(criminalCase1);
        criminalCaseList.add(criminalCase2);
        when(caseServiceImpl.findByLeadInvestigator(1L)).thenReturn(criminalCaseList);
        caseServiceImpl.findByLeadInvestigator(1L)
                .forEach(criminal -> log.info("Case: {}", criminal));
    }

    @Test
    void findByNumber() {
        CriminalCase criminalCase2 = new CriminalCase();
        criminalCase2.setNumber("Case11");
        when(caseServiceImpl.findByNumber("Case11")).thenReturn(criminalCase2);
        log.info("Case: {}", caseServiceImpl.findByNumber("Case11"));
    }

    @Test
    void findByStatus() {
    }

    @Test
    void findByType() {
    }
}