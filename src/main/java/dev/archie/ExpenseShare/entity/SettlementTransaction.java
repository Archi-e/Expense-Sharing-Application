package dev.archie.ExpenseShare.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Currency;

@Getter
@Setter
@Entity
public class SettlementTransaction extends BaseModel{
    private double amount;
    private Currency currency;
    @ManyToOne
    private User lender;
    @ManyToOne
    private User borrower;
}
