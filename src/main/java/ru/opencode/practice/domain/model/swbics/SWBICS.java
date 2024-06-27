package ru.opencode.practice.domain.model.swbics;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.opencode.practice.domain.model.bicDirectoryEntry.BicDirectoryEntry;

@Data
@Table(name = "SWBICS")
@Entity
public class SWBICS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "swbic")
    private String swbic;

    @Column(name = "DefaultSWBIC")
    private Boolean defaultSwbic;

    @ManyToOne
    private BicDirectoryEntry bicDirectoryEntry;
}
