package fis_training.repo.jdpctemplate;


import fis_training.core.Rank;
import fis_training.model.Detective;
import fis_training.repo.jpa.AbstractRepo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetectiveRepo extends AbstractRepo<Detective> {

    List<Detective> findAll();
    Optional<Detective> findByBadgeNumber(String badgeNumber);
    List<Detective> findbyRank(Rank rank);

    default Optional<Detective> findByIdWithPersonDetails(Long id) {
        return Optional.empty();
    }
}