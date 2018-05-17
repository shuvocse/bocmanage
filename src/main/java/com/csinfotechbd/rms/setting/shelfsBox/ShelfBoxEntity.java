package com.csinfotechbd.rms.setting.shelfsBox;

import com.csinfotechbd.rms.setting.columnseShelf.ColumnseShelfEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rms_setting_column_shelf_box")
public class ShelfBoxEntity {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long boxId;

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
    private int capacity;


    @Getter
    @Setter
    @ManyToOne(optional = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "shelfId")
    @Column(nullable = false)
    private ColumnseShelfEntity columnShelfEntity;

    public ShelfBoxEntity(){}

    public ShelfBoxEntity(long id, String name, String code, int capacity, ColumnseShelfEntity columnShelfEntity) {
        this.boxId = id;
        this.name = name;
        this.code = code;
        this.capacity = capacity;
        this.columnShelfEntity = columnShelfEntity;
    }
}
