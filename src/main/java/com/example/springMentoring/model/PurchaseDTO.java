package com.example.springMentoring.model;

import lombok.Data;

@Data
public class PurchaseDTO {

    private String name;
    private Double price;

// todo implement purchase date

//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
//private LocalDateTime timestamp;
//    private Timestamp date;
}
