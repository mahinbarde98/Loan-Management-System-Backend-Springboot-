package com.cts.management.dao;

import com.cts.management.entity.Loan;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LoanDaoTest {
    @Mock
    LoanDao loanDao;

    @Test
    void testfindByUserFirstName() {
        Loan loan = new Loan(1, "mahesh", "barde", true, 12.f, "house");
        loanDao.save(loan);
        assertThat(loanDao.findByuserFirstName("mahesh")).isNotNull();
    }

    @Test
    void testfindByUserLastName() {
        Loan loan = new Loan(1, "mahesh", "barde", true, 12.f, "house");
        loanDao.save(loan);
        assertThat(loanDao.findByUserLastName("barde")).isNotNull();
    }

    @Test
    void testfindByLoanId() throws JsonProcessingException {
        Loan loan = new Loan(1, "mahesh", "barde", true, 12.f, "house");
        loanDao.save(loan);
        assertThat(loanDao.findByLoanId(1)).isNotNull();
    }


}
