package picksovt.entity;

import jakarta.persistence.*;
import lombok.Data;
import picksovt.enums.Gender;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_gen")
    @SequenceGenerator(name = "doctor_gen", sequenceName = "doctor_seq", allocationSize = 1)
    private Long id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String position;

    @Email
    @Column(unique = true)
    private String email;

    @ManyToMany(mappedBy = "doctors")
    private List<Department> departments;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
}
