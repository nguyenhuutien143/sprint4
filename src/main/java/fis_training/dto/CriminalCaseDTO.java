package fis_training.dto;

import fis_training.core.CaseStatus;
import fis_training.core.CaseType;
import fis_training.model.Detective;
import fis_training.model.Evidence;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CriminalCaseDTO {
    private String number;
    private CaseType type;
    private String shortDescription;
    private String detailedDescription;
    private CaseStatus status;
    private String notes;
    private List<Evidence> evidences = new ArrayList<>();
    private Detective leadInvestigator;
    private List<Detective> assigned = new ArrayList<>();
}
