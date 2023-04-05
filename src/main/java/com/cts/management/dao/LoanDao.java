package com.cts.management.dao;

import com.cts.management.entity.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanDao extends CrudRepository<Loan, Integer> {
    List<Loan> findByuserFirstName(String userName);

   List<Loan> findByLoanId(Integer loanId);

    List<Loan> findByUserLastName(String userFirstName);

   // List<Loan> findByUserFirstNameOrUserLastNameorLoanID(String userFirstName,String userLastName,Integer loanId );
}
