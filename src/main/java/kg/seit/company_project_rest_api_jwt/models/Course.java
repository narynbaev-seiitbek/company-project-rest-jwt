package kg.seit.company_project_rest_api_jwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.ALL;

/**
 * @author seiitbeknarynbaev
 */
@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {

    @Column(nullable = false)
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_id_generator")
    @SequenceGenerator(
            name = "course_id_generator",
            sequenceName = "course_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    private String duration;

    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @ManyToMany(cascade = ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "course_groups",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "groups_id"))
    @ToString.Exclude
    private List<Group> groups = new ArrayList<>();

    @OneToOne(cascade = ALL, mappedBy = "course")
    private Teacher teacher;


    public void setGroup(Group group) {
        if (groups == null) {
            groups = new ArrayList<>();
        }
        groups.add(group);


    }

}
