package fis_training.controller;

import fis_training.dto.DetectiveDTO;
import fis_training.dto.EvidenceDTO;
import fis_training.model.Detective;
import fis_training.model.Evidence;
import fis_training.service.DetectiveService;
import fis_training.service.EvidenceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/detectives")
public class DetectiveController {
    @Autowired
    private ModelMapper modelMapper;
    private DetectiveService detectiveService;

    public DetectiveController(ModelMapper modelMapper, DetectiveService detectiveService) {
        this.modelMapper = modelMapper;
        this.detectiveService = detectiveService;

    }
    @GetMapping
    public List<DetectiveDTO> getAllDetectives(){
        return detectiveService.findAll().stream().map(e->modelMapper.map(e,DetectiveDTO.class)).
                collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetectiveDTO> getDetectiveById(@PathVariable(name="id") Long id){
        Detective detective= detectiveService.findById(id).get();
        DetectiveDTO detectiveResponse=modelMapper.map(detective,DetectiveDTO.class);
        return ResponseEntity.ok().body((detectiveResponse));
    }
    @PostMapping
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
    public ResponseEntity deleteDetective(@PathVariable(name="id")Long id){

        detectiveService.deleteById(id);
        return   ResponseEntity.ok().body(id) ;  }
}
