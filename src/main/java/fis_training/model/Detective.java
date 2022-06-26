package fis_training.model;

import com.fasterxml.jackson.annotation.*;
import fis_training.core.EmploymentStatus;
import fis_training.core.Rank;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "detective")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Detective extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @Column(name = "badgeNumber", unique = true)
    private String badgeNumber;
    @Column(name = "detectiveRank")
    @Enumerated(EnumType.STRING)
    private Rank rank;
    @Column(name = "armed")
    private boolean armed;
    @Enumerated(EnumType.STRING)
    private EmploymentStatus status;
    @ManyToMany(mappedBy = "assigned")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference(value = "criminalCase-detective")
    @Transient
//    @JsonIdentityReference(alwaysAsId = true)
    private Set<CriminalCase> criminalCaseSet;
    @OneToMany(mappedBy = "detective", cascade = CascadeType.ALL)
//    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Transient
//    @JsonIdentityReference(alwaysAsId = true)
    private Set<TrackEntry> trackEntrySet;

    @Override
    public String toString() {
        return "Detective{" +
                "person=" + person +
                ", badgeNumber='" + badgeNumber + '\'' +
                ", rank=" + rank +
                ", armed=" + armed +
                ", employmentStatus=" + status +
                ", criminalCaseSet=" + criminalCaseSet +
                ", trackEntrySet=" + trackEntrySet +
                ", id=" + id +
                ", version=" + version +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detective detective = (Detective) o;
        return armed == detective.armed && Objects.equals(person, detective.person) && Objects.equals(badgeNumber, detective.badgeNumber) && rank == detective.rank && status == detective.status && Objects.equals(criminalCaseSet, detective.criminalCaseSet) && Objects.equals(trackEntrySet, detective.trackEntrySet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, badgeNumber, rank, armed, status, criminalCaseSet, trackEntrySet);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public boolean getArmed() {
        return armed;
    }

    public void setArmed(boolean armed) {
        this.armed = armed;
    }

    public EmploymentStatus getStatus() {
        return status;
    }

    public void setStatus(EmploymentStatus status) {
        this.status = status;
    }

    public Set<CriminalCase> getCriminalCaseSet() {
        return criminalCaseSet;
    }

    public void setCriminalCaseSet(Set<CriminalCase> criminalCaseSet) {
        this.criminalCaseSet = criminalCaseSet;
    }

    public Set<TrackEntry> getTrackEntrySet() {
        return trackEntrySet;
    }

    public void setTrackEntrySet(Set<TrackEntry> trackEntrySet) {
        this.trackEntrySet = trackEntrySet;
    }
}
