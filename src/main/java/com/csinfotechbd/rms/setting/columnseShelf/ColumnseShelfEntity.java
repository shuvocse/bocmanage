package com.csinfotechbd.rms.setting.columnseShelf;

import com.csinfotechbd.rms.setting.rowsColumn.RowsColumnEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rms_setting_columnse_shelf")
public class ColumnseShelfEntity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long shelfId;
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
    @JoinColumn(name = "columnId")
    @Column(nullable = false)
    private RowsColumnEntity centerColumnEntity;

    public ColumnseShelfEntity(){}
    public ColumnseShelfEntity(long id, String name, String code, RowsColumnEntity centerColumnEntity) {
        this.shelfId = id;
        this.name = name;
        this.code = code;
        this.centerColumnEntity = centerColumnEntity;
    }

    @Override
    public String toString() {
        return "ColumnseShelfEntity{" +
                "shelfId=" + shelfId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", centerColumnEntity=" + centerColumnEntity +
                '}';
    }
}
