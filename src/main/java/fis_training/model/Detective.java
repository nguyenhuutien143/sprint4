package fis_training.model;

import com.sun.istack.NotNull;
import fis_training.core.EmploymentStatus;
import fis_training.core.Rank;
import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Detective extends AbstractEntity {
    @NotNull
    @OneToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;
    @Column(unique = true, nullable = false)
    private String badgeNumber;
    @Enumerated(EnumType.STRING)
    private Rank rank;
    private Boolean armed = false;
    @Enumerated(EnumType.STRING)
    private EmploymentStatus status;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "working_detective_case",
            joinColumns = @JoinColumn(name = "detective_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "case_id", referencedColumnName = "id"))
    private List<CriminalCase> criminalCases = new ArrayList<>();
    @OneToMany(mappedBy = "detective")
    private List<TrackEntry> trackEntries;
    public Detective() {
        super();
    }
}
