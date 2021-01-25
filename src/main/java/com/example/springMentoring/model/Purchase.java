package com.example.springMentoring.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double price;

// todo implement data purchase creating

//    @CreationTimestamp
//    @Column(name = "dataTime", nullable = false, insertable = false)
//    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
