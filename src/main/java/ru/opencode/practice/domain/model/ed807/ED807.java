package ru.opencode.practice.domain.model.ed807;

import jakarta.persistence.*;
import lombok.Data;
import ru.opencode.practice.domain.model.bicDirectoryEntry.BicDirectoryEntry;
import ru.opencode.practice.domain.model.partInfo.PartInfo;

import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "ED807")
public class ED807 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FileName")
    private String fileName;
    @Column(name = "DirectoryVersion")
    private Integer directoryVersion;
    @Column(name = "BusinessDay")
    private Date businessDay;
    @Enumerated(EnumType.STRING)
    @Column(name = "InfoTypeCode")
    private InfoTypeCode infoTypeCode;
    @Column(name = "CreationDateTime")
    private Date creationDateTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "CreationReason")
    private CreationReason creationReason;
    @Column(name = "EDAuthor")
    private String edAuthor;
    @Column(name = "EDReceiver")
    private String edReceiver;
    @Column(name = "EDDate")
    private Date edDate;
    @Column(name = "EDNo")
    private Integer edNo;

    @OneToMany(fetch = FetchType.EAGER)
    private List<BicDirectoryEntry> bicDirectoryEntryList;

    @OneToMany(fetch = FetchType.EAGER)
    private List<PartInfo> partInfoList;


}
