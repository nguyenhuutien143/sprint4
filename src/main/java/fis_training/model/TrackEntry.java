package fis_training.model;


import fis_training.core.TrackAction;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class TrackEntry extends AbstractEntity {
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "evidence_fk", nullable = false)
    private Evidence evidence;
    @ManyToOne
    @JoinColumn(name = "detective_fk", nullable = false)
    private Detective detective;
    @Enumerated(EnumType.STRING)
    private TrackAction action;
    private String reason;
}
