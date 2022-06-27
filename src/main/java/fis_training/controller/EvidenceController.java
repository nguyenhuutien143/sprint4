package fis_training.controller;

import fis_training.dto.EvidenceDTO;
import fis_training.model.CriminalCase;
import fis_training.model.Evidence;
import fis_training.service.CriminalCaseService;
import fis_training.service.EvidenceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evidences")
@CrossOrigin("*")
public class EvidenceController {
    @Autowired
    EvidenceService evidenceService;
    @Autowired
    CriminalCaseService criminalCaseService;
    @Autowired
    private ModelMapper modelMapper;

    public EvidenceController(EvidenceService evidenceService, ModelMapper modelMapper) {
        this.evidenceService = evidenceService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public List<EvidenceDTO> getAllEvidences(){
        return evidenceService.getAll().stream().map(e->modelMapper.map(e,EvidenceDTO.class)).
                collect(Collectors.toList());
    }

    @PostMapping("/")
    public ResponseEntity<EvidenceDTO> createEvidence(@RequestBody EvidenceDTO evidenceDTO){
        Evidence evidenceRequest=modelMapper.map(evidenceDTO, Evidence.class);
        evidenceService.save(evidenceRequest);
        return new ResponseEntity<EvidenceDTO>(evidenceDTO, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EvidenceDTO> getEvidenceById(@PathVariable(name="id") Long id){
        Evidence evidence= evidenceService.findById(id);
        EvidenceDTO evidenceResponse=modelMapper.map(evidence,EvidenceDTO.class);
        return ResponseEntity.ok().body((evidenceResponse));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<EvidenceDTO> updateEvidence(@PathVariable long id,@RequestBody EvidenceDTO evidenceDTO){
        Evidence evidence= modelMapper.map(evidenceDTO, Evidence.class);
        evidenceService.update(evidence);
        return ResponseEntity.ok().body(evidenceDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteEvidence(@PathVariable(name="id")Long id){

        evidenceService.delete(id);
          }
    @GetMapping("/CriminalCase/{criminalCaseId}")
    public List<EvidenceDTO> findByCriminalCase(@PathVariable(name="criminalCaseId") Long id ){
        CriminalCase criminalCase= criminalCaseService.getCriminalCase(id);
        return evidenceService.findByCriminalCase(criminalCase).stream().map(e->modelMapper.map(e,EvidenceDTO.class ))
                .collect(Collectors.toList());
    }
    @GetMapping("/findByNumber/{number}")
    public List<EvidenceDTO> findByNumber(@PathVariable(name="number") String number ){

        return evidenceService.findByNumber(number).stream().map(e->modelMapper.map(e,EvidenceDTO.class ))
                .collect(Collectors.toList());
    }
}
