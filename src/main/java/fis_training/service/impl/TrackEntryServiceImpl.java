package fis_training.service.impl;
import fis_training.model.TrackEntry;
import fis_training.repo.TrackEntryRepo;
import fis_training.service.TrackEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TrackEntryServiceImpl implements TrackEntryService {

    @Autowired
    TrackEntryRepo trackEntryRepository;


    @Override
    public TrackEntry save(TrackEntry trackEntry) {
        return this.trackEntryRepository.save(trackEntry);
    }

    @Override
    public TrackEntry update(TrackEntry trackEntry) {
        return this.trackEntryRepository.save(trackEntry);
    }

    @Override
    public List<TrackEntry> getAll() {
        return this.trackEntryRepository.findAll();
    }

    @Override
    public TrackEntry findById(Long id) {
        return this.trackEntryRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        TrackEntry trackEntry = new TrackEntry();
        trackEntry.setId(id);
        this.trackEntryRepository.delete(trackEntry);
    }
}
