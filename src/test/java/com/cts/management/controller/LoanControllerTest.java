package com.cts.management.controller;

import com.cts.management.configuration.JwtAuthenticationEntryPoint;
import com.cts.management.dao.LoanDao;
import com.cts.management.entity.Loan;
import com.cts.management.service.JwtService;
import com.cts.management.service.LoanService;
import com.cts.management.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(LoanController.class)
@AutoConfigureMockMvc
public class LoanControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    LoanDao loanDao;
    @MockBean
    LoanService loanService;
    @MockBean
    private JwtUtil jwtUtil;
    @MockBean
    private JwtService jwtService;
    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Test
    void testNewLoan() throws Exception {

        Loan loan = new Loan(1, "mahesh", "barde", true, 12.f, "house");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObj = objectMapper.writeValueAsString(loan);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/newLoan").
                        contentType(MediaType.APPLICATION_JSON).content(jsonObj)).
                andExpect(status().isOk());
    }


    @Test
    void testGetLoan() throws Exception {
        Loan loan = new Loan();
        loan.setLoanId(1);
        loan.setUserFirstName("mahesh");
        loan.setUserLastName("barde");
        loan.setPayment(true);
        loan.setInterestRate(12f);
        loan.setPropertyAddress("pune");
//        List<Loan> loans = new ArrayList<>();
//        loans.add(loan);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/getLoan")).
                andExpect(status().isOk());
//                andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].userFirstName", Matchers.equalTo("mahesh")))
//                ;

    }

    @Test
    void testgetLoanss() throws Exception {

        Loan loan = new Loan(3, "mahesh", "barde", true, 12.f, "house");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObj = objectMapper.writeValueAsString(loan);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/loan/3").
                        contentType(MediaType.APPLICATION_JSON).content(jsonObj)).
                andExpect(status().isOk());
    }
    @Test
    void testgetLoans() throws Exception {

        Loan loan = new Loan(1, "mahesh", "barde", true, 12.f, "house");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObj = objectMapper.writeValueAsString(loan);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/loans/mahesh").
                        contentType(MediaType.APPLICATION_JSON).content(jsonObj)).
                andExpect(status().isOk());
    }
    @Test
    void testupdateLoan() throws Exception {

        Loan loan = new Loan(1, "rahul", "barde", true, 12.f, "house");



        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObj = objectMapper.writeValueAsString(loan);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/updateLoan").
                        contentType(MediaType.APPLICATION_JSON).content(jsonObj)).
                andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content()
//                        .string(
//                                "{\"loanId\":1,\"userFirstName\":\"rahul\",\"userLastName\":\"barde\",\"payment\":true,\"interestRate\":12.0,\"propertyAddress\":\"house\"}"));
//
    }

    @Test
    void testDeleteLoanRecord() throws Exception {

        Integer employeeId = 1;
        willDoNothing().given(loanService).deleteLoan(employeeId);

        // when -  action or the behaviour that we are going test
       mockMvc.perform(delete("/delete?id="+employeeId)).andExpect(status().isOk());

        // then - verify the output



    }

}
