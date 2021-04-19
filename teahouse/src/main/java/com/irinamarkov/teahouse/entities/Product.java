package com.irinamarkov.teahouse.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    String name;

    @NotNull
    @NotBlank
    @Size(max = 500)
    String description;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 20)
    String serialNumber;

    @NotNull
    double price;

    @NotNull
    int quantity;

    @NotNull
    @NotBlank
    String imageUrl;

//    @JsonIdentityInfo(
//            generator = ObjectIdGenerators.PropertyGenerator.class,
//            property = "category_id"
//    )

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    @JsonIgnore
    Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<OrderItem> orderItems;

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
