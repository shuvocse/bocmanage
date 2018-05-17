package com.csinfotechbd.rms.setting.center;

import com.csinfotechbd.rms.setting.warehouse.WarehouseEntity;
import com.csinfotechbd.rms.setting.zone.ZoneEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rms_setting_center")
public class CenterEntity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long centerId;
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
    @JoinColumn(name = "warehouseId")
    @Column(nullable = false)
    private WarehouseEntity warehouseEntity;

    public CenterEntity(){}
    public CenterEntity(long id, String name, String code, WarehouseEntity warehouseEntity) {
        this.centerId = id;
        this.name = name;
        this.code = code;
        this.warehouseEntity = warehouseEntity;
    }

    @Override
    public String toString() {
        return "CenterEntity{" +
                "centerId=" + centerId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", warehouseEntity=" + warehouseEntity +
                '}';
    }
}
