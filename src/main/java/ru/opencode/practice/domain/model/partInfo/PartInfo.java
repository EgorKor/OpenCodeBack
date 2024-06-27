package ru.opencode.practice.domain.model.partInfo;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.opencode.practice.domain.model.ed807.ED807;

@Data
@Entity
@Table(name = "PartInfo")
public class PartInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PartNO")
    private Integer partNo;

    @Column(name = "PartQuantity")
    private Integer partQuantity;

    @Column(name = "PartAggregateID")
    private String partAggregateID;

    @ManyToOne
    private ED807 ed807;

}
