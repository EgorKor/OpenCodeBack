package ru.opencode.practice.domain.model.bicDirectoryEntry;


import jakarta.persistence.*;
import lombok.Data;
import ru.opencode.practice.domain.model.accounts.Accounts;
import ru.opencode.practice.domain.model.ed807.ED807;
import ru.opencode.practice.domain.model.swbics.SWBICS;

import java.util.List;

@Data
@Entity
@Table(name="BICDirectoryEntry")
public class BicDirectoryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "BIC", nullable = false)
    private String bic;

    @Enumerated(EnumType.STRING)
    @Column(name = "ChangeType")
    private ChangeType changeType;

    @ManyToOne
    @JoinColumn(name = "ED_ID")
    private ED807 ed807;


    @OneToMany(fetch = FetchType.EAGER)
    private List<Accounts> accountsList;

    @OneToMany(fetch = FetchType.EAGER)
    private List<SWBICS> swbicsList;


}
