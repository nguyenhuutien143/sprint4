package fis_training.controller;



import fis_training.dto.CriminalCaseDTO;
import fis_training.dto.TrackEntryDTO;
import fis_training.model.CriminalCase;
import fis_training.model.TrackEntry;
import fis_training.service.TrackEntryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trackEntry")
@CrossOrigin("*")
public class TrackEntryController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    final TrackEntryService trackEntryService;

    public TrackEntryController(ModelMapper modelMapper, TrackEntryService trackEntryService) {
        this.modelMapper = modelMapper;
        this.trackEntryService = trackEntryService;
    }

    @GetMapping("/")
    public List<TrackEntryDTO> getAllTrackEntries(){
        return trackEntryService.getAll().stream().map(c->modelMapper.map(c, TrackEntryDTO.class)).
                collect(Collectors.toList());
    }

    @PostMapping("/")
    public ResponseEntity<TrackEntryDTO> createTrackEntry(@RequestBody TrackEntryDTO trackEntryDTO){
        TrackEntry trackEntryRequest=modelMapper.map(trackEntryDTO, TrackEntry.class);
        trackEntryService.save(trackEntryRequest);
        return new ResponseEntity<TrackEntryDTO>(trackEntryDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<TrackEntryDTO> updateTrackEntry(@PathVariable long id,@RequestBody TrackEntryDTO trackEntryDTO){
        TrackEntry trackEntry= modelMapper.map(trackEntryDTO, TrackEntry.class);
        trackEntryService.update(trackEntry);
        return ResponseEntity.ok().body(trackEntryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTrackEntry(@PathVariable(name="id")Long id){

        trackEntryService.delete(id); }
}
