package com.irinamarkov.teahouse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 25)
    String firstName;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 25)
    String lastName;

    @NotNull
    @NotBlank
    @Email
    String email;

    @Size(min=10, max = 20)
    String phone;

    @NotNull
    @NotBlank
    @Size(max = 50)
    String password;

    @Transient
    String confirmPassword;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Order> orders;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    CustomerAddress customerAddress;

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
