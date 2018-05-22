package com.csinfotechbd.rms.setting.rowsColumn;

import com.csinfotechbd.base.BaseProperty;
import com.csinfotechbd.rms.setting.centereasRow.CentereasRowEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rms_setting_rows_column")
public class RowsColumnEntity extends BaseProperty{
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long columnId;
    @Getter
    @Setter
    @Column(nullable = false)
    private String title;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @Column(nullable = false, columnDefinition = "int default 1")
    private int capacity=1;

    @Getter
    @Setter
    @Column(unique = true)
    private String trackingId;


    @Getter
    @Setter
    @ManyToOne(optional = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "rowId")
    private CentereasRowEntity centerRowEntity;

    public RowsColumnEntity(){}
    public RowsColumnEntity(long id, String title, String clmUniCode, CentereasRowEntity centerRowEntity) {
        this.columnId = id;
        this.title = title;
        this.centerRowEntity = centerRowEntity;
    }
}
