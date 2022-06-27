package fis_training.repo;

import fis_training.model.Detective;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetectiveRepo extends JpaRepository<Detective, Long> {
    Detective findDetectiveByPersonUsername(String username);
}
