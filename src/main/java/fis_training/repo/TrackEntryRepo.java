package fis_training.repo;

import fis_training.model.TrackEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackEntryRepo extends JpaRepository<TrackEntry, Long> {

}
