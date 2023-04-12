package com.cts.management.service;

import com.cts.management.dao.LoanDao;
import com.cts.management.entity.Loan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoanServiceTest {

    @Mock
    private LoanDao loanDao;

    @InjectMocks
    private LoanService loanService;


    @Test
    public void testGetLoansByUserName() {
        List<Loan> loans = new ArrayList<>();
        loans.add(new Loan());
        when(loanDao.findByuserFirstName("Mahi")).thenReturn(loans);
        List<Loan> result = loanService.getLoansByUserName("Mahi");
        assertEquals(1, result.size());
    }

    @Test
    public void testGetLoansByUserFirstName() {
        List<Loan> loans = new ArrayList<>();
        loans.add(new Loan());
        when(loanDao.findByuserFirstName("Mahi")).thenReturn(loans);
        List<Loan> result = loanService.findByuserFirstName("Mahi");
        assertEquals(1, result.size());
    }
    @Test
    public void testSaveLoan() {
        Loan loan = new Loan();
        when(loanDao.save(loan)).thenReturn(loan);
        Loan result = loanService.saveLoan(loan);
        assertEquals(loan, result);
    }

    @Test
    public void testUpdateLoan() throws Exception {
        Loan loan = new Loan();
        loan.setLoanId(1);
        loan.setUserFirstName("Mahi");
        loan.setUserLastName("Barde");
        loan.setInterestRate(10f);
        loan.setPropertyAddress("123 Main St.");
        when(loanDao.findById(1)).thenReturn(Optional.of(loan));
        when(loanDao.save(any())).thenReturn(loan);
        Loan result = loanService.updateLoan(loan);
        assertEquals("John", result.getUserFirstName());
    }

    @Test
    public void testDeleteLoan() {
        doNothing().when(loanDao).deleteById(anyInt());
        loanService.deleteLoan(1);
        verify(loanDao, times(1)).deleteById(anyInt());
    }

    @Test
    public void testInItRecord() {
        loanService.initRecord();
        verify(loanDao, times(1)).save(any());
    }

}
