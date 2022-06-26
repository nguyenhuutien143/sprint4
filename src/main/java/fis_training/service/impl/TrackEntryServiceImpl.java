package fis_training.service.impl;


import fis_training.core.TrackAction;
import fis_training.model.TrackEntry;
import fis_training.repo.TrackEntryRepo;
import fis_training.service.TrackEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service

public class TrackEntryServiceImpl implements TrackEntryService {
    @Autowired
    private TrackEntryRepo trackEntryRepo;
    @Override
    public List<TrackEntry> findByDetectiveId(Long detectiveId) {
        List<TrackEntry> trackEntryList= trackEntryRepo.findAll().stream().
                filter(t->detectiveId.equals(t.getDetective())).collect(Collectors.toList());
        return trackEntryList;
    }

    @Override
    public List<TrackEntry> findByEvidenceId(Long evidenceId) {
        List<TrackEntry> trackEntryList= trackEntryRepo.findAll().stream().
                filter(t->evidenceId.equals(t.getEvidence())).collect(Collectors.toList());
        return trackEntryList;
    }

    @Override
    public List<TrackEntry> findByDate(Date date) {
        List<TrackEntry> trackEntryList= trackEntryRepo.findAll().stream().
                filter(t->date.equals(t.getDate())).collect(Collectors.toList());
        return trackEntryList;
    }

    @Override
    public List<TrackEntry> findByDateAndAction(Date date, TrackAction action) {
        List<TrackEntry> trackEntryList= trackEntryRepo.findAll().stream().
                filter(t->date.equals(t.getDate())).filter(t->action.equals(t.getTrackAction())).
                collect(Collectors.toList());
        return trackEntryList;
    }
}
