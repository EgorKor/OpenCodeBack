package ru.opencode.practice.domain.model.accounts;

import jakarta.persistence.*;
import lombok.Data;
import ru.opencode.practice.domain.model.accRstrList.AccRstr;
import ru.opencode.practice.domain.model.accRstrList.AccRstrList;
import ru.opencode.practice.domain.model.bicDirectoryEntry.BicDirectoryEntry;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Account")
    private String account;

    @Column(name = "RegulationAccountType")
    @Enumerated(EnumType.STRING)
    private RegulationAccountType regulationAccountType;

    @Column(name = "CK")
    private String ck;

    @Column(name = "AccountCBRBIC")
    private String accountCBRBIC;

    @Column(name = "DateIn")
    private Date dateIn;

    @Column(name = "DateOut")
    private Date dateOut;

    @Column(name = "AccountStatus")
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @OneToMany(fetch = FetchType.EAGER)
    private List<AccRstrList> accRstrLists;

    @ManyToOne
    private BicDirectoryEntry bicDirectoryEntry;
}
