package fis_training.service;

import fis_training.core.Rank;
import fis_training.model.Detective;

import java.util.List;
import java.util.Optional;

public interface DetectiveService {
    List<Detective> findAll();
    Optional<Detective> findByBadgeNumber(String badgeNumber);
    List<Detective> findbyRank(Rank rank);

    default Optional<Detective> findByIdWithPersonDetails(Long id) {
        return Optional.empty();
    }
}
