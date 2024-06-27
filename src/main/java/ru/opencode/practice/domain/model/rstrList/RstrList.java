package ru.opencode.practice.domain.model.rstrList;

import jakarta.persistence.*;
import lombok.Data;
import ru.opencode.practice.domain.model.participantInfo.ParticipantInfo;

import java.util.Date;

@Data
@Entity
@Table(name = "RstrList")
public class RstrList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RstrDate")
    private Date rstrDate;

    @Column(name = "Rstr")
    @Enumerated(EnumType.STRING)
    private Rstr rstr;

    @ManyToOne
    private ParticipantInfo participantInfo;
}
