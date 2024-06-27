package ru.opencode.practice.domain.model.participantInfo;

import jakarta.persistence.*;
import lombok.Data;
import ru.opencode.practice.domain.model.bicDirectoryEntry.BicDirectoryEntry;
import ru.opencode.practice.domain.model.rstrList.Rstr;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ParticipantInfo")
public class ParticipantInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NameP")
    private String nameP;

    @Column(name = "EnglName")
    private String englName;

    @Column(name = "RegN")
    private String regN;

    @Column(name = "CntrCd")
    private String CntrCd;

    @Column(name = "Ind")
    private String ind;

    @Column(name = "Nnp")
    private String nnp;

    @Column(name = "Adr")
    private String Adr;

    @Column(name = "PrntBIC")
    private String PrntBIC;

    @Column(name = "DateIn")
    private Date dateIn;

    @Column(name = "DateOut")
    private Date dateOut;

    @Column(name = "PtType")
    @Enumerated(EnumType.STRING)
    private PtType ptType;

    @Column(name = "Srvcs")
    @Enumerated(EnumType.STRING)
    private Srvcs srvcs;

    @Column(name = "XchType")
    @Enumerated(EnumType.STRING)
    private XchType xchType;

    @Column(name = "UID")
    private String uid;

    @Column(name = "ParticipantStatus")
    @Enumerated(EnumType.STRING)
    private ParticipantStatus participantStatus;

    @ManyToOne
    private BicDirectoryEntry bicDirectoryEntry;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Rstr> rstrList;
    
}
