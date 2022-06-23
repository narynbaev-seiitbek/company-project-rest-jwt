package kg.seit.company_project_rest_api_jwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * @author seiitbeknarynbaev
 */
@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "teacher_id_generator")
    @SequenceGenerator(
            name = "teacher_id_generator",
            sequenceName = "teacher_sequence",
            allocationSize = 1)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(cascade = ALL)
    private User user;

    @OneToOne(cascade = {MERGE, REFRESH, DETACH})
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private Course course;

}
