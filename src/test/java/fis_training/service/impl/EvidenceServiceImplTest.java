package fis_training.service.impl;

import fis_training.model.CriminalCase;
import fis_training.model.Storage;
import fis_training.service.CriminalCaseService;
import fis_training.service.EvidenceService;
import fis_training.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class EvidenceServiceImplTest {
    @Autowired
    private StorageService storageService;
    @Autowired
    private EvidenceService evidenceService;
    @Autowired
    private CriminalCaseService criminalCaseService;
    @Test
    void findByCriminalCase() {
        CriminalCase criminalCase= criminalCaseService.findByNumber("1").get();

        assertEquals(1,evidenceService.findByCriminalCase(criminalCase).size());
    }

    @Test
    void findByNumber() {
        assertEquals("1", evidenceService.findByNumber("1").get().getNumber());
    }

    @Test
    void isInStorage() {
        Storage storage= storageService.findByLocation("HN").get();
        assertFalse(evidenceService.isInStorage(storage));
    }

    @Test
    void findAll() {
        log.info("evidence 1 : {}",evidenceService.findById(1L).get().toString());
    }
}