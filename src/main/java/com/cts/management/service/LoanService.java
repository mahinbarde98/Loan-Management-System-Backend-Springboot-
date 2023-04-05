package com.cts.management.service;

import com.cts.management.dao.LoanDao;
import com.cts.management.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    private Loan loans = new Loan();

    @Autowired
    private LoanDao loanDao;


    public List<Loan> getLoansByUserName(String userName) {
        List<Loan> loans = new ArrayList<Loan>();
        loanDao.findByuserFirstName(userName).forEach(loan -> loans.add(loan));
        System.out.println("Getting loan details for existing customer {}" + userName);

        return loans;
    }

    public List<Loan> findByuserFirstName(String userFirstName) {
        List<Loan> loans = new ArrayList<Loan>();
        loanDao.findByuserFirstName(userFirstName).forEach(abc -> loans.add(abc));

        return loans;
    }

    public Loan saveLoan(Loan loan) {
        return loanDao.save(loan);
    }

    public Loan updateLoan(Loan loan) throws Exception {

        //Checking whether loan exit with the given id or not .
        // If the record is not found then throw the exception
        Integer loanId = loan.getLoanId();
        final Loan updateLoan = loanDao.findById(loanId)
                .orElseThrow(() -> new Exception("Loan does not exist with id: " + loanId));
        updateLoan.setUserFirstName(loan.getUserFirstName());
        updateLoan.setUserLastName(loan.getUserLastName());
        updateLoan.setInterestRate(loan.getInterestRate());
        updateLoan.setPropertyAddress(loan.getPropertyAddress());


        return loanDao.save(updateLoan);
    }

    public void deleteLoan(Integer id) {
        loanDao.deleteById(id);
    }

    public void initRecord() {
        Loan loan = new Loan();
        loan.setLoanId(1);
        loan.setUserFirstName("mahesh");
        loan.setUserLastName("barde");
        loan.setPayment(true);
        loan.setInterestRate(12f);
        loan.setPropertyAddress("pune");
        loanDao.save(loan);
    }
}
