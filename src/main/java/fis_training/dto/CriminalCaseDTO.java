package fis_training.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import fis_training.core.CaseStatus;
import fis_training.core.CaseType;
import fis_training.model.Detective;
import fis_training.model.Evidence;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriminalCaseDTO {

    private String number;

    private CaseType type;

    private String shortDescription;

    private String detailedDescription;


    private CaseStatus status;

    private String notes;


    private Set<Evidence> evidenceSet = new HashSet<>();

    private Detective leadInvestigator;

    private Set<Detective> assigned = new HashSet<>();
}
