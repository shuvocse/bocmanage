package com.csinfotechbd.rms.setting.rowsColumn;

import com.csinfotechbd.rms.setting.centereasRow.CentereasRowEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rms_setting_rows_column")
public class RowsColumnEntity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long columnId;
    @Getter
    @Setter
    @Column(nullable = false)
    private String name;
    @Getter
    @Setter
    @Column(unique = true)
    private String code;


    @Getter
    @Setter
    @ManyToOne(optional = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "rowId")
    @Column(nullable = false)
    private CentereasRowEntity centerRowEntity;

    public RowsColumnEntity(){}
    public RowsColumnEntity(long id, String name, String code, CentereasRowEntity centerRowEntity) {
        this.columnId = id;
        this.name = name;
        this.code = code;
        this.centerRowEntity = centerRowEntity;
    }
}
