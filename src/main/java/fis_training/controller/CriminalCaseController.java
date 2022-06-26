package fis_training.controller;

import fis_training.dto.CriminalCaseDTO;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/CriminalCases")
public class CriminalCaseController {
    @Autowired
    private ModelMapper modelMapper;
    private CriminalCaseService criminalCaseService;

    public CriminalCaseController(ModelMapper modelMapper, CriminalCaseService criminalCaseService) {
        this.modelMapper = modelMapper;
        this.criminalCaseService = criminalCaseService;
    }
    @GetMapping
    public List<CriminalCaseDTO> getAllCriminalCases(){
        return criminalCaseService.findAll().stream().map(c->modelMapper.map(c, CriminalCaseDTO.class)).
                collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CriminalCaseDTO> getCriminalCaseById(@PathVariable(name="id") Long id){
        CriminalCase criminalCase= criminalCaseService.findById(id).get();
        CriminalCaseDTO criminalCaseResponse=modelMapper.map(criminalCase,CriminalCaseDTO.class);
        return ResponseEntity.ok().body((criminalCaseResponse));
    }
    @PostMapping
    public ResponseEntity<CriminalCaseDTO> createCriminalCase(@RequestBody CriminalCaseDTO criminalCaseDTO){
        CriminalCase criminalCaseRequest=modelMapper.map(criminalCaseDTO, CriminalCase.class);
        criminalCaseService.save(criminalCaseRequest);
        return new ResponseEntity<CriminalCaseDTO>(criminalCaseDTO, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<CriminalCaseDTO> updateCriminalCase(@PathVariable long id,@RequestBody CriminalCaseDTO criminalCaseDTO){
        CriminalCase criminalCase= modelMapper.map(criminalCaseDTO, CriminalCase.class);
        criminalCaseService.update(criminalCase);
        return ResponseEntity.ok().body(criminalCaseDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCriminalCase(@PathVariable(name="id")Long id){

        criminalCaseService.deleteById(id);
        return   ResponseEntity.ok().body(id) ;  }
}
