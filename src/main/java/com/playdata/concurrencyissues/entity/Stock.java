package com.playdata.concurrencyissues.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
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

    // 낙관적 락을 사용할 경우만 아래 주석부분이 필요
//    @Version
//    private Long version; // 낙관적 락을 위한 버전 정보
//
//    public Stock(Long id, Long productId, Long quantity) {
//        this.id = id;
//        this.productId = productId;
//        this.quantity = quantity;
//    }

    public void decreaseQuantity(Long quantity) {
        if (this.quantity - quantity < 0) {
            throw new RuntimeException("재고는 0 미만이 될 수 없습니다.");
        }
        this.quantity -= quantity;
    }

}
