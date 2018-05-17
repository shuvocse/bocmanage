package com.csinfotechbd.rms.setting.warehouse;

import com.csinfotechbd.rms.setting.country.CountryEntity;
import com.csinfotechbd.rms.setting.zone.ZoneEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rms_setting_warehouse")
public class WarehouseEntity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long warehouseId;
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
    @JoinColumn(name = "zoneId")
    @Column(nullable = false)
    private ZoneEntity zoneEntity;

    @Override
    public String toString() {
        return "WarehouseEntity{" +
                "warehouseId=" + warehouseId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", zoneEntity=" + zoneEntity +
                '}';
    }
    public WarehouseEntity(){}
    public WarehouseEntity(long id, String name, String code, ZoneEntity zoneEntity) {
        this.warehouseId = id;
        this.name = name;
        this.code = code;
        this.zoneEntity = zoneEntity;
    }
}
