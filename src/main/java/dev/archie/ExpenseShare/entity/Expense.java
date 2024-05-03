package dev.archie.ExpenseShare.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private double amount;
    private Currency currency;
    private String description;
    @ManyToOne
    private User addedBy;
    private LocalDateTime expenseTime;
    @OneToMany
    private List<UserExpense> userExpenses;
}
