package fis_training.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvidenceDTO {
    @NotEmpty
    private String number;
    @NotEmpty
    private String itemName;
    @NotEmpty
    private String notes;
    @NotEmpty
    private boolean archived;
}
