package fis_training.dto;

import fis_training.core.EmploymentStatus;
import fis_training.core.Rank;
import fis_training.model.CriminalCase;
import fis_training.model.Person;
import fis_training.model.TrackEntry;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetectiveDTO {

    private Person person;

    private String badgeNumber;

    private Rank rank;

    private boolean armed;

    private EmploymentStatus status;


    private Set<CriminalCase> criminalCaseSet;

    private Set<TrackEntry> trackEntrySet;
}
