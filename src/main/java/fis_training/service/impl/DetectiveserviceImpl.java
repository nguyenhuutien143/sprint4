package fis_training.service.impl;


import fis_training.core.NotFoundException;
import fis_training.core.Rank;
import fis_training.model.Detective;
import fis_training.repo.DetectiveRepo;
import fis_training.service.DetectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DetectiveServiceImpl implements DetectiveService {
    @Autowired
    DetectiveRepo detectiveRepo;


    @Override
    public Detective save(Detective detective) {
        return this.detectiveRepo.save(detective);
    }

    @Override
    public Detective update(Detective detective) {
        return this.detectiveRepo.save(detective);
    }

    @Override
    public List<Detective> getAll() {
        return this.detectiveRepo.findAll();
    }

    @Override
    public Detective findById(Long id) {
        return this.detectiveRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        Detective detective = new Detective();
        detective.setId(id);
        this.detectiveRepo.delete(detective);
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
