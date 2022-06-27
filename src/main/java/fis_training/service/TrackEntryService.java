package fis_training.service;

import fis_training.model.TrackEntry;

import java.util.List;
import java.util.Set;

public interface TrackEntryService {
    TrackEntry save(TrackEntry trackEntry);

    TrackEntry update(TrackEntry trackEntry);

    List<TrackEntry> getAll();

    TrackEntry findById(Long id);

    void delete(Long id);
}
