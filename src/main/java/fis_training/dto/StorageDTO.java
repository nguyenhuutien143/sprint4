package fis_training.dto;

import fis_training.model.Evidence;
import lombok.*;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StorageDTO {
    private String name;
    private String location;
    private List<Evidence> evidenceSet = new ArrayList<>();
}
