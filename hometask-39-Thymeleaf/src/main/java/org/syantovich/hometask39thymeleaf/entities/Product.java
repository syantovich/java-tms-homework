package org.syantovich.hometask39thymeleaf.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.syantovich.hometask39thymeleaf.enums.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "products_39")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price = 0.0;

    private Integer count = 0;

    @Column(name = "is_deliverable")
    private Boolean isDeliverable = false;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus status = ProductStatus.ACTIVE;

    @Version
    private Integer version;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;
}
