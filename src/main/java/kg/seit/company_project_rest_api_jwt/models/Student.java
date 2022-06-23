package kg.seit.company_project_rest_api_jwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.seit.company_project_rest_api_jwt.enums.StudyFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * @author seiitbeknarynbaev
 */
@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
public class Student {
    @Id
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_id_generator")
    @SequenceGenerator(
            name = "student_id_generator",
            sequenceName = "student_sequence",
            allocationSize = 1)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Enumerated(STRING)
    private StudyFormat studyFormat;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonIgnore
    private Group group;

}
