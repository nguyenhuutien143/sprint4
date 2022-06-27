package fis_training.service;
import fis_training.core.Rank;
import fis_training.model.Detective;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DetectiveService {
    Detective save(Detective detective);

    Detective update(Detective detective);

    List<Detective> getAll();

    Detective findById(Long id);

    void delete(Long id);
    Optional<Detective> findByBadgeNumber(String badgeNumber);
    List<Detective> findbyRank(Rank rank);

}
