package com.example.application.data.dto;

import com.example.application.data.entity.GiftCard;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GiftCardDTO extends AbstractDTO {
    @NotBlank
    private String code;

    private OrderDTO order;

    @NotNull
    private BigDecimal originalAmount;

    private BigDecimal balance;

    @NotNull
    private LocalDateTime created;

    public GiftCardDTO() {
    }

    public GiftCardDTO(GiftCard giftCard) {
        this(giftCard, true);
    }

    public GiftCardDTO(GiftCard giftCard, boolean deep) {
        this.setId(giftCard.getId());
        this.balance = giftCard.getBalance();
        this.code = giftCard.getCode();
        this.created = giftCard.getCreated();
        this.originalAmount = giftCard.getOriginalAmount();

        if (deep) {
            this.order = new OrderDTO(giftCard.getOrder(), false);
        }
    }

    @Override
    public String toString() {
        return code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
