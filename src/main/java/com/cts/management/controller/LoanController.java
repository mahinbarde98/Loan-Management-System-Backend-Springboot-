package com.cts.management.controller;

import com.cts.management.dao.LoanDao;
import com.cts.management.entity.Loan;
import com.cts.management.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @Autowired
    private LoanDao loanDao;


    @GetMapping("/loans/{userFirstName}")
    private List<Loan> getLoans(@PathVariable("userFirstName") String userFirstName) {
        return loanService.findByuserFirstName(userFirstName);
    }

    @GetMapping("/loan/{customerId}")
    private Optional<Loan> getLoanss(@PathVariable(value = "customerId") String customerId) {
        return Optional.of(loanDao.findById(Integer.valueOf(customerId)).get());
    }
    @GetMapping("/getLoan")
    public List<Loan> findLoan(){
       return (List<Loan>) loanDao.findAll();
    }

    @PostConstruct
    public void initRecord() {
        loanService.initRecord();
    }
    @PostMapping("/newLoan")
    private Loan saveLoan(@RequestBody Loan loan) {
        return loanService.saveLoan(loan);
    }

    @PutMapping("/updateLoan")
    private Loan updateLoan(@RequestBody Loan loan) throws Exception {
       return loanService.updateLoan(loan);

   }


//    @GetMapping("/loans/{userFirstName}/{userLastName}/{loanId}")
//    private List<Loan> getLoans(@PathVariable("userFirstName") String userFirstName,
//                                @PathVariable("userLastNAme") String userLastName,@PathVariable("loanId") Integer loanId
//            ) {
//        return loanDao.findByUserFirstNameOrLoanIdOrUserLastName(userFirstName);
//
//
//    }

//    @GetMapping("/loans/{userFirstName}/{userLastName}/{loanId}")
//    private List<Loan> getLoans(@PathVariable("userFirstName") String userFirstName,
//                                @PathVariable("userLastNAme") String userLastName,@PathVariable("loanId") Integer loanId
//    ) {
//        return loanService.findByUserFirstNameOrLoanIdOrUserLastName(userFirstName, loanId, userLastName);
//
//
//    }

    //since we cannot call delete method same as others we are using @RequestParam to find id in our url
    @DeleteMapping("/delete")
    public void deleteLoanRecord(@RequestParam Integer id){
        loanService.deleteLoan(id);
    }


//    @GetMapping("/loan/folol")
//    public ResponseEntity<List<Loan>> getLoanByNameOrlnameOrPrice(@RequestParam String userfirstName,
//                                                                       @RequestParam String userLastName,
//                                                                       @RequestParam Integer loanId) {
//        return new ResponseEntity<List<Loan>>(loanDao.findByUserFirstNameOrUserLastNameorLoanID(userfirstName, userLastName, loanId), HttpStatus.OK);
//    }


}
