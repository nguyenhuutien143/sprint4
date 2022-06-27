package fis_training.controller;

import fis_training.core.Rank;
import fis_training.dto.DetectiveDTO;
import fis_training.model.Detective;
import fis_training.service.DetectiveService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detective")
@CrossOrigin("*")
public class DetectiveController {
    @Autowired
    DetectiveService detectiveService;
    @Autowired
    private ModelMapper modelMapper;

    public DetectiveController(DetectiveService detectiveService, ModelMapper modelMapper) {
        this.detectiveService = detectiveService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public List<DetectiveDTO> getDetectives() {
        return detectiveService.getAll().stream().map(e->modelMapper.map(e, DetectiveDTO.class)).
                collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetectiveDTO> getDetectiveById(@PathVariable(name="id") Long id){
        Detective detective= detectiveService.findById(id);
        DetectiveDTO detectiveResponse=modelMapper.map(detective,DetectiveDTO.class);
        return ResponseEntity.ok().body((detectiveResponse));
    }
    @PostMapping("/")
    public ResponseEntity<DetectiveDTO> createDetective(@RequestBody DetectiveDTO detectiveDTO){
        Detective detectiveRequest=modelMapper.map(detectiveDTO, Detective.class);
        detectiveService.save(detectiveRequest);
        return new ResponseEntity<DetectiveDTO>(detectiveDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<DetectiveDTO> updateDetective(@PathVariable long id,@RequestBody DetectiveDTO detectiveDTO){
        Detective detective= modelMapper.map(detectiveDTO, Detective.class);
        detectiveService.update(detective);
        return ResponseEntity.ok().body(detectiveDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDetective(@PathVariable(name="id")Long id){

        detectiveService.delete(id);  }
    @GetMapping("/Rank/{rank}")
    public List<DetectiveDTO> findByRank(@PathVariable(name="rank") String rank){
        return detectiveService.findbyRank(Rank.valueOf(rank)).stream().map(d-> modelMapper.map(d,DetectiveDTO.class)).
                collect(Collectors.toList());
    }
}
