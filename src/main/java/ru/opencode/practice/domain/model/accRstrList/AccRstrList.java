package ru.opencode.practice.domain.model.accRstrList;

import jakarta.persistence.*;
import lombok.Data;
import ru.opencode.practice.domain.model.accounts.Accounts;

import java.util.Date;

@Data
@Entity
@Table(name = "AccRstrList")
public class AccRstrList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AccRstr")
    @Enumerated(EnumType.STRING)
    private AccRstr accRstr;

    @Column(name = "AccRstrDate")
    private Date accRstrDate;

    @Column(name = "SuccessorBIC")
    private String successorBIC;

    @ManyToOne
    private Accounts accounts;
}
