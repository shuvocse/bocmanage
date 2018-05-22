package com.csinfotechbd.rms.setting.center;

import com.csinfotechbd.base.BaseProperty;
import com.csinfotechbd.rms.setting.warehouse.WarehouseEntity;
import com.csinfotechbd.rms.setting.zone.ZoneEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rms_setting_center")
public class CenterEntity extends BaseProperty{
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long centerId;
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
    @JoinColumn(name = "warehouseId")
    private WarehouseEntity warehouseEntity;

    public CenterEntity(){}
    public CenterEntity(long id, String title, String centUniCode, WarehouseEntity warehouseEntity) {
        this.centerId = id;
        this.title = title;
        this.warehouseEntity = warehouseEntity;
    }

    @Override
    public String toString() {
        return "CenterEntity{" +
                "centerId=" + centerId +
                ", name='" + title + '\'' +
                ", warehouseEntity=" + warehouseEntity +
                '}';
    }
}
