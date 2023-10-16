package app_prog.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Investment {
    private double monthlyInvestment;
    private double yearlyInterestRate;
    private int years;

}