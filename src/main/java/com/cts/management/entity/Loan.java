package com.cts.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan")
public class Loan  {
    //New Loan add screen must have User’s First Name,
    // Last Name, Loan Number, and Property Address.
    // New Loan add screen must have User’s First Name, Last Name, Loan Number, and Property Address.
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer loanId;

   @Column(name="`userFirstName123`")
   private String userFirstName;

    @Column
   private String userLastName;
    @Column
    private boolean payment;
    @Column
    private float interestRate;

    @Column
   private String propertyAddress;



}
