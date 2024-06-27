DROP TABLE IF EXISTS RstrList;
DROP TABLE IF EXISTS ParticipantInfo;
DROP TABLE IF EXISTS SWBICS;
DROP TABLE IF EXISTS AccRstrList;
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS InitialED;
DROP TABLE IF EXISTS PartInfo;
DROP TABLE IF EXISTS BICDirectoryEntry;
DROP TABLE IF EXISTS ED807;

CREATE TABLE ED807
(
    ID               LONG PRIMARY KEY,
    FileName         VARCHAR(255) NOT NULL,
    DirectoryVersion INT4         NOT NULL,
    BusinessDay      DATE         NOT NULL,
    InfoTypeCode     VARCHAR      NOT NULL,
    CreationDateTime DATETIME     NOT NULL,
    CreationReason   VARCHAR      NOT NULL,
    EDAuthor         VARCHAR      NOT NULL,
    EDReceiver       VARCHAR      NOT NULL,
    EDDate           DATE         NOT NULL,
    EDNo             INT          NOT NULL
);



CREATE TABLE BICDirectoryEntry
(
    ID         LONG PRIMARY KEY,
    BIC        VARCHAR                    NOT NULL,
    ChangeType VARCHAR                    NOT NULL,
    ED_ID      LONG REFERENCES ED807 (ID) NOT NULL
);



CREATE TABLE PartInfo
(
    ID              LONG PRIMARY KEY,
    PartNo          INT                        NOT NULL,
    PartQuantity    INT                        NOT NULL,
    PartAggregateID VARCHAR                    NOT NULL,
    ED_ID           LONG REFERENCES ED807 (ID) NOT NULL
);

CREATE TABLE InitialED
(
    ID       LONG PRIMARY KEY,
    EDNo     INT     NOT NULL,
    EDDate   DATE    NOT NULL,
    EDAuthor VARCHAR NOT NULL,
    ED_ID    LONG REFERENCES ED807 (ID)
);

CREATE TABLE Accounts
(
    ID                    LONG PRIMARY KEY,
    BICDE_ID              LONG REFERENCES BICDirectoryEntry (ID) NOT NULL,
    Account               VARCHAR                                NOT NULL,
    RegulationAccountType VARCHAR                                NOT NULL,
    CK                    VARCHAR                                NOT NULL,
    AccountCBRBIC         VARCHAR                                NOT NULL,
    DateIn                DATE                                   NOT NULL,
    DateOut               DATE                                   NOT NULL,
    AccountStatus         VARCHAR                                NOT NULL
);


CREATE TABLE AccRstrList
(
    ID           LONG PRIMARY KEY,
    Accounts_ID  LONG REFERENCES Accounts (ID) NOT NULL,
    AccRstr      VARCHAR                       NOT NULL,
    AccRstrDate  DATE                          NOT NULL,
    SuccessorBIC VARCHAR                       NOT NULL
);

CREATE TABLE SWBICS
(
    ID           LONG PRIMARY KEY,
    BICDE_ID     LONG REFERENCES BICDirectoryEntry (ID) NOT NULL,
    SWBIC        VARCHAR                                NOT NULL,
    DefaultSWBIC BOOL                                   NOT NULL
);

CREATE TABLE ParticipantInfo
(
    ID                LONG PRIMARY KEY,
    BICDE_ID          LONG REFERENCES BICDirectoryEntry (ID) NOT NULL,
    NameP             VARCHAR(160)                           NOT NULL,
    EnglName          VARCHAR(140)                           NOT NULL,
    RegN              VARCHAR(9)                             NOT NULL,
    CntrCd            VARCHAR(2)                             NOT NULL,
    Rgn               VARCHAR(2)                             NOT NULL,
    Ind               VARCHAR(6)                             NOT NULL,
    Tnp               VARCHAR(5)                             NOT NULL,
    Nnp               VARCHAR(25)                            NOT NULL,
    Adr               VARCHAR(160)                           NOT NULL,
    PrntBIC           VARCHAR(9)                             NOT NULL,
    DateIn            DATE                                   NOT NULL,
    DateOut           DATE                                   NOT NULL,
    PtType            VARCHAR(2)                             NOT NULL,
    Srvcs             VARCHAR(1)                             NOT NULL,
    XchType           VARCHAR(1)                             NOT NULL,
    UID               VARCHAR(10)                            NOT NULL,
    ParticipantStatus VARCHAR                                NOT NULL
);


CREATE TABLE RstrList
(
    ID                 LONG PRIMARY KEY,
    ParticipantInfo_ID LONG REFERENCES ParticipantInfo (ID) NOT NULL,
    Rstr               VARCHAR                              NOT NULL,
    RstrDate           DATE                                 NOT NULL
);

