package ru.opencode.practice.domain.model.initialED;

import jakarta.persistence.*;
import lombok.Data;
import ru.opencode.practice.domain.model.ed807.ED807;

import java.util.Date;


@Data
@Entity
@Table(name = "InitialED")
public class InitialED {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EDNo")
    private Integer edNo;

    @Column(name = "EDDate")
    private Date date;

    @Column(name = "EDAuthor")
    private String edAuthor;

    @ManyToOne
    private ED807 ed807;
}
