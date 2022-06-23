package kg.seit.company_project_rest_api_jwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

/**
 * @author seiitbeknarynbaev
 */
@Entity
@Table(name = "groups")
@Getter
@Setter
public class Group {
    @SequenceGenerator(
            name = "group_id_generator",
            sequenceName = "group_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "group_id_generator")
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "date_of_start")
    private LocalDate dateOfStart;

    @Column(name = "date_of_finish")
    private LocalDate dateOfFinish;

    @JsonIgnore
    @ManyToMany(mappedBy = "groups", cascade = {MERGE, REFRESH, PERSIST, DETACH}, fetch = FetchType.EAGER)
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "group", cascade = ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    @JsonIgnore
    public void setCourse(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setGroup(this);
    }
}
