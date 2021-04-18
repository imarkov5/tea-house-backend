package com.irinamarkov.teahouse.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @NotNull
    int quantity;

    @NotNull
    double subtotal;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id")
    Order order;

    @Column(updatable=false)
    @DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
    Date createdAt;

    @DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
    Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
