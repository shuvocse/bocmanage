package com.csinfotechbd.rms.setting.country;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "rms_setting_country")
public class CountryEntity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long countryId;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(unique = true)
    private String code;

    public CountryEntity(){}

    public CountryEntity(long countryId, String name, String code) {
        this.countryId = countryId;
        this.name = name;
        this.code = code;
    }
}
