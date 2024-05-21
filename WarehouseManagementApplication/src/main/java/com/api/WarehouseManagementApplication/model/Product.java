package com.api.WarehouseManagementApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private Long number;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "category_id",nullable = true)
    private Category category;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Order> order;

    @CreationTimestamp
    @Column
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column
    private LocalDateTime updatedAt;
}
