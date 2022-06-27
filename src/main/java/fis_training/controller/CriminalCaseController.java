package fis_training.controller;

import fis_training.core.CaseStatus;
import fis_training.core.CaseType;
import fis_training.dto.CriminalCaseDTO;
import fis_training.model.CriminalCase;
import fis_training.service.CriminalCaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/criminalCases")
@CrossOrigin("*")
public class CriminalCaseController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CriminalCaseService criminalCaseService;

    public CriminalCaseController(ModelMapper modelMapper, CriminalCaseService criminalCaseService) {
        this.modelMapper = modelMapper;
        this.criminalCaseService = criminalCaseService;
    }

    @PostMapping("/")
    public ResponseEntity<CriminalCaseDTO> addCriminalCase(@RequestBody CriminalCaseDTO criminalCaseDTO) {
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
    public void deleteCriminalCase(@PathVariable(name="id")Long id){

        criminalCaseService.delete(id);  }

    public List<CriminalCaseDTO> getAllCriminalCases(){
        return criminalCaseService.getAll().stream().map(c->modelMapper.map(c, CriminalCaseDTO.class)).
                collect(Collectors.toList());
    }
    @GetMapping("status/{caseStatus}")
    public List<CriminalCaseDTO> findByStatus(@PathVariable("caseStatus") String caseStatus) {
        return criminalCaseService.findByStatus(CaseStatus.valueOf(caseStatus)).stream()
                .map(criminalCase -> modelMapper.map(criminalCase, CriminalCaseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("type/{caseType}")
    public List<CriminalCaseDTO> findByType(@PathVariable("caseType") String caseType) {
        return criminalCaseService.findByType(CaseType.valueOf(caseType)).stream()
                .map(criminalCase -> modelMapper.map(criminalCase, CriminalCaseDTO.class))
                .collect(Collectors.toList());
    }
}
