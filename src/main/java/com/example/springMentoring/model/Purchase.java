package com.example.springMentoring.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double price;

    @CreationTimestamp
    @Column(name = "data_time", nullable = false/*, insertable = false*/)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
