package fis_training.service.impl;

import fis_training.core.TrackAction;
import fis_training.service.TrackEntryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TrackEntryServiceImplTest {
@Autowired
private TrackEntryService trackEntryService;
    @Test
    void findByDetectiveId() {
        assertEquals(1,trackEntryService.findByDetectiveId(1L).size());
    }

    @Test
    void findByEvidenceId() {
        assertEquals(1,trackEntryService.findByEvidenceId(1L).size());
    }

    @Test
    void findByDate() {
        Date d= new Date();
        assertEquals(0,trackEntryService.findByDate(d).size());
    }

    @Test
    void findByDateAndAction() {
        Date d= new Date();
        assertEquals(0,trackEntryService.findByDateAndAction(d, TrackAction.RETRIEVED).size());
    }
}