package com.example.twitter.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name="order_date_time")
    private LocalDateTime orderDateTime;

    @Column
    private String

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"order"})
    private User user;
}
