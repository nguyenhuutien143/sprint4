package fis_training.controller;

import fis_training.dto.EvidenceDTO;
import fis_training.model.Evidence;
import fis_training.service.EvidenceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evidences")
public class EvidenceController {
    @Autowired
    private ModelMapper modelMapper;
    private EvidenceService evidenceService;

    public EvidenceController(ModelMapper modelMapper, EvidenceService evidenceService) {
        this.modelMapper = modelMapper;
        this.evidenceService = evidenceService;
    }
    @GetMapping
    public List<EvidenceDTO> getAllEvidences(){
        return evidenceService.findAll().stream().map(e->modelMapper.map(e,EvidenceDTO.class)).
                collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<EvidenceDTO> getEvidenceById(@PathVariable(name="id") Long id){
        Evidence evidence= evidenceService.findById(id).get();
        EvidenceDTO evidenceResponse=modelMapper.map(evidence,EvidenceDTO.class);
        return ResponseEntity.ok().body((evidenceResponse));
    }
    @PostMapping
    public ResponseEntity<EvidenceDTO> createEvidence(@RequestBody EvidenceDTO evidenceDTO){
        Evidence evidenceRequest=modelMapper.map(evidenceDTO, Evidence.class);
        evidenceService.save(evidenceRequest);
        return new ResponseEntity<EvidenceDTO>(evidenceDTO, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<EvidenceDTO> updateEvidence(@PathVariable long id,@RequestBody EvidenceDTO evidenceDTO){
        Evidence evidence= modelMapper.map(evidenceDTO, Evidence.class);
        evidenceService.update(evidence);
        return ResponseEntity.ok().body(evidenceDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteEvidence(@PathVariable(name="id")Long id){

        evidenceService.deleteById(id);
        return   ResponseEntity.ok().body(id) ;  }
}
