package fis_training.dto;

import fis_training.model.CriminalCase;
import fis_training.model.Storage;
import fis_training.model.TrackEntry;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EvidenceDTO {
    private CriminalCase criminalCase;
    private Storage storage;
    private String number;
    private String itemName;
    private String notes;
    private Boolean archived=false;
    private List<TrackEntry> trackEntries = new ArrayList<>();
}
