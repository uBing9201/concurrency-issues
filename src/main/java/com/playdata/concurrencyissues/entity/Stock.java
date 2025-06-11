package com.playdata.concurrencyissues.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stock {

    @Id
    private Long id;

    private Long productId;

    private Long quantity;

    public void decreaseQuantity(Long quantity) {
        if (this.quantity - quantity < 0) {
            throw new RuntimeException("재고는 0 미만이 될 수 없습니다.");
        }
        this.quantity -= quantity;
    }

}
