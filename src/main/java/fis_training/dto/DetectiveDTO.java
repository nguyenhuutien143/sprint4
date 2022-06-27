package fis_training.dto;

import com.sun.istack.NotNull;
import fis_training.core.EmploymentStatus;
import fis_training.core.Rank;
import fis_training.model.CriminalCase;
import fis_training.model.Person;
import fis_training.model.TrackEntry;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetectiveDTO {
    private Person person;
    private String badgeNumber;
    private Rank rank;
    private Boolean armed = false;
    private EmploymentStatus status;
    private List<CriminalCase> criminalCases = new ArrayList<>();
    private List<TrackEntry> trackEntries;
}
