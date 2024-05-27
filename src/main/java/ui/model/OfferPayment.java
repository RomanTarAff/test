package ui.model;

import lombok.Data;

@Data
public class OfferPayment {

    private Double monthlyPayment;
    private Integer term;
    private Double interestRate;
    private Double apr;
}
