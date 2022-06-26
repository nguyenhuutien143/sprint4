package fis_training.repo;


import fis_training.model.Detective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetectiveRepo extends JpaRepository<Detective,Long> {

//    List<Detective> findAll();
//    Optional<Detective> findByBadgeNumber(String badgeNumber);
//    List<Detective> findbyRank(Rank rank);
//
//    default Optional<Detective> findByIdWithPersonDetails(Long id) {
//        return Optional.empty();
//    }
}