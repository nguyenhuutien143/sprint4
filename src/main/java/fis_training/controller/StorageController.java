package fis_training.controller;

import fis_training.dto.CriminalCaseDTO;
import fis_training.dto.StorageDTO;
import fis_training.model.CriminalCase;
import fis_training.model.Storage;
import fis_training.service.StorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/storage")
@CrossOrigin("*")
public class StorageController {
    @Autowired
    StorageService storageService;
    @Autowired
    private ModelMapper modelMapper;

    public StorageController(StorageService storageService, ModelMapper modelMapper) {
        this.storageService = storageService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public List<StorageDTO> getAllStorages(){
        return storageService.getAll().stream().map(c->modelMapper.map(c, StorageDTO.class)).
                collect(Collectors.toList());
    }

    @PostMapping("/")
    public ResponseEntity<StorageDTO> createStorage(@RequestBody StorageDTO storageDTO){
        Storage storageRequest=modelMapper.map(storageDTO, Storage.class);
        storageService.save(storageRequest);
        return new ResponseEntity<StorageDTO>(storageDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<StorageDTO> updateStorage(@PathVariable long id,@RequestBody StorageDTO storageDTO){
        Storage storage= modelMapper.map(storageDTO, Storage.class);
        storageService.update(storage);
        return ResponseEntity.ok().body(storageDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCriminalCase(@PathVariable(name="id")Long id){

        storageService.delete(id);  }
}
