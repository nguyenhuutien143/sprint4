package fis_training.service.impl;

import fis_training.core.NotFoundException;
import fis_training.core.Rank;
import fis_training.model.Detective;
import fis_training.repo.DetectiveRepo;
import fis_training.service.DetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetectiveserviceImpl implements DetectiveService {
    @Autowired
    private DetectiveRepo detectiveRepo;

    @Override
    public void save(Detective detective) {
        detectiveRepo.save(detective);
    }

    @Override
    public void delete(Detective detective) {
        detectiveRepo.delete(detective);
    }

    @Override
    public Detective update(Detective detective) {
        detectiveRepo.save(detective);
        return detective;
    }

    @Override
    public int deleteById(Long detectiveId) {
        detectiveRepo.deleteById(detectiveId);
        if(detectiveRepo.findById(detectiveId).isPresent()) return -1;
        return 1;
    }

    @Override
    public Optional<Detective> findById(Long detectiveId) {
        return detectiveRepo.findById(detectiveId);
    }

    @Override
    public List<Detective> findAll() {
        return detectiveRepo.findAll();
    }

    @Override
    public Optional<Detective> findByBadgeNumber(String badgeNumber) {
        Optional<Detective> detective= detectiveRepo.findAll().stream().
                filter(d->badgeNumber.equals(d.getBadgeNumber())).findFirst();
        if(detective.isPresent()) return detective;
         throw new NotFoundException("not found detective with this badge number");
    }

    @Override
    public List<Detective> findbyRank(Rank rank) {
        List<Detective> detectiveList= detectiveRepo.findAll().stream().
                filter(detective->rank.equals(detective.getRank())).collect(Collectors.toList());
        return detectiveList;
    }
}
