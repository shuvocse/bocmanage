package com.csinfotechbd.rms.record;

import com.csinfotechbd.rms.setting.shelfsBox.ShelfBoxEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rms_record")
public class RecordEntity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long recordId;

    @Getter
    @Setter
    @Column(nullable = false)
    private String serialNo;

    @Getter
    @Setter
    @Column(nullable = false)
    private String title;

    @Getter
    @Setter
    @Column(nullable = false)
    private String recordType;

    @Getter
    @Setter
    @Column(nullable = false)
    private String recordCategory;

    @Getter
    @Setter
    private String reference;

    @Getter
    @Setter
    private String comment;

    @Getter
    @Setter
    private Date lastUpdate;

    @Getter
    @Setter
    private Date lastPrint;


    @Getter
    @Setter
    @ManyToOne(optional = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "boxId")
    @Column(nullable = false)
    private ShelfBoxEntity shelfBoxEntity;

    public RecordEntity(){}
    public RecordEntity(long id, String serialNo, String title, String recordType, String recordCategory, String reference, String comment, Date lastUpdate, Date lastPrint, ShelfBoxEntity shelfBoxEntity) {
        this.recordId = id;
        this.serialNo = serialNo;
        this.title = title;
        this.recordType = recordType;
        this.recordCategory = recordCategory;
        this.reference = reference;
        this.comment = comment;
        this.lastUpdate = lastUpdate;
        this.lastPrint = lastPrint;
        this.shelfBoxEntity = shelfBoxEntity;
    }

    @Override
    public String toString() {
        return "RecordEntity{" +
                "recordId=" + recordId +
                ", serialNo='" + serialNo + '\'' +
                ", title='" + title + '\'' +
                ", recordType='" + recordType + '\'' +
                ", recordCategory='" + recordCategory + '\'' +
                ", reference='" + reference + '\'' +
                ", comment='" + comment + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", lastPrint=" + lastPrint +
                ", shelfBoxEntity=" + shelfBoxEntity +
                '}';
    }
}
