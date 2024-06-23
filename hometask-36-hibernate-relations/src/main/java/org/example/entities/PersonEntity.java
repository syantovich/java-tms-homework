package org.example.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persons")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int fullAge;
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
    @Version
    private int version;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<OrderEntity> orders = new ArrayList<>();
}
