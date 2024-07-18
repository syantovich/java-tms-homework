package org.syantovich.hometask43bike.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "bikes")
@NoArgsConstructor
@Getter
@Setter
public class BikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer num;
    @Enumerated(EnumType.STRING)
    private Brands brand;
    @Enumerated(EnumType.STRING)
    private Types type;
    @Column(name = "is_hidden")
    private Boolean isHidden ;
    @Column(name = "is_booked")
    private Boolean isBooked;


    @Version
    private Integer version;

    public enum Brands {
        STEELS,
        AIST,
        GIANT,
        SCOTT,
        FUJI
    }

    public enum Types {
        BMX,
        HYBRID,
        MTB,
        RIGID,
        TOURING
    }
}
