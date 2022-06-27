package fis_training.dto;

import fis_training.core.TrackAction;
import fis_training.model.Detective;
import fis_training.model.Evidence;
import lombok.*;
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TrackEntryDTO {
    private Evidence evidence;
    private Detective detective;
    private TrackAction action;
    private String reason;
}
