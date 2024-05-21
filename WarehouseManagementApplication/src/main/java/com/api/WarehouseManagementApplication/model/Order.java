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
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "suppleir_id",nullable = true)
    private Supplier suppleir;


    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "product_id",nullable = true)
    private Product product;

    @CreationTimestamp
    @Column
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column
    private LocalDateTime updatedAt;
}
