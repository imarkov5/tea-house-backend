package com.irinamarkov.teahouse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="customer_address")
public class CustomerAddress {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    String street;

    @NotNull
    @NotBlank
    @Size(max = 45)
    String city;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 25)
    String state;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 10)
    String zipcode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    @JsonIgnore
    Customer customer;

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
