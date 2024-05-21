package com.api.WarehouseManagementApplication.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "address",nullable = false)
    private String address;

    @OneToMany(mappedBy = "suppleir",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Order> order;
    @CreationTimestamp
    @Column
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column
    private LocalDateTime updatedAt;
}
