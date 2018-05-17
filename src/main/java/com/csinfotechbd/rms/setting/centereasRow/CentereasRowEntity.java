package com.csinfotechbd.rms.setting.centereasRow;

import com.csinfotechbd.rms.setting.center.CenterEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rms_setting_center_row")
public class CentereasRowEntity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rowId;
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
    @JoinColumn(name = "centerId")
    @Column(nullable = false)
    private CenterEntity centerEntity;

    public CentereasRowEntity(){}
    public CentereasRowEntity(long id, String name, String code, CenterEntity centerEntity) {
        this.rowId = id;
        this.name = name;
        this.code = code;
        this.centerEntity = centerEntity;
    }

    @Override
    public String toString() {
        return "CentereasRowEntity{" +
                "rowId=" + rowId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", centerEntity=" + centerEntity +
                '}';
    }
}
