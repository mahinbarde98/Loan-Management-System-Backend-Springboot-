package com.cts.management.entity;

import com.cts.management.configuration.JwtAuthenticationEntryPoint;
import com.cts.management.configuration.JwtRequestFilter;
import com.cts.management.service.JwtService;
import com.cts.management.service.LoanService;
import com.cts.management.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(Loan.class)
public class LoanTest {
    @MockBean
    private LoanService loanService;
    @MockBean
    private JwtService jwtService;

    @MockBean
    private JwtRequestFilter jwtRequestFilter;
    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;



    Loan loan =new Loan();
    Loan loan1 =new
            Loan(1,"Ram","Kame",true,12f,"Nagar");


    @Test
    void testLoanid(){
        loan.setLoanId(1);
        assertEquals(loan.getLoanId(),1);
    }

    @Test
    void testUserFirstName(){
        loan.setUserFirstName("Sami");
        assertEquals(loan.getUserFirstName(),"Sami");
    }

   @Test
    void tesUserLastName(){
      loan.setUserLastName("Lahor");
      assertEquals(loan.getUserLastName(),"Lahor");
    }

    @Test
    void testInterestRate(){
        loan.setInterestRate(11f);
        assertEquals(loan.getInterestRate(),11f);
    }
    @Test
    void testProperty(){
        loan.setPropertyAddress("Pune");
        assertEquals(loan.getPropertyAddress(),"Pune");
    }
    @Test
    void testPayment(){
        loan.setPayment(true);
        assertEquals(loan.isPayment(),true);

    }

}
