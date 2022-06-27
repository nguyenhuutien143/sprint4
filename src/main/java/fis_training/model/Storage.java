package fis_training.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Data
public class Storage extends AbstractEntity {
    private String name;
    private String location;
    @OneToMany(mappedBy = "storage")
    private List<Evidence> evidenceSet = new ArrayList<>();

}
