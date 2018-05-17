package com.csinfotechbd.rms.setting.zone;

import com.csinfotechbd.rms.setting.country.CountryEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rms_setting_zone")
public class ZoneEntity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zoneId;
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
    @JoinColumn(name = "countryId")
    @Column(nullable = false)
    private CountryEntity countryEntity;


    public ZoneEntity(){}


    public ZoneEntity(long id, String name, String code, CountryEntity countryEntity) {
        this.name = name;
        this.code = code;
        this.countryEntity = countryEntity;
    }



}
