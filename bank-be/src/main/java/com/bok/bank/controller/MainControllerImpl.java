package com.bok.bank.controller;

import com.bok.bank.model.Account;
import com.bok.bank.model.BankAccount;
import com.bok.bank.model.Company;
import com.bok.bank.model.User;
import com.bok.bank.repository.AccountRepository;
import com.bok.bank.repository.BankAccountRepository;
import com.bok.bank.repository.CardRepository;
import com.bok.bank.service.MainController;
import com.bok.bank.util.ExchangeData;
import com.bok.bank.util.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

/**
 * This is a service to delete
 */
@Service
public class MainControllerImpl implements MainController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    ExchangeData exchangeData;

    @Override
    public String populateDB() {
        List<Account> accounts = Arrays.asList(
                new User("Domenico", "domfas", "mico.fasano@gmail.com", "3926772950", "+39", Account.Status.ACTIVE, "Italy", "Apulia", "Locorotondo", "70010",
                        "via le mani dal naso", "12/c", null, "Fasano", User.Gender.M, "FSNDNC99C13D508Y", "Fasano", "Italy", LocalDate.of(1999,3,13)),
                new User("Chris", "chrisfara", "chris.fara@gmail.com", "3911172950", "+39", Account.Status.ACTIVE, "Italy", "CalaBBria", "GIOIA TAURA", "00000",
                        "via le mani dal ferro", "69/c", "Gennaro", "Faraone", User.Gender.M, "CSTFRN99B44D508Y", "ViBBo Violenza", "Italy", LocalDate.of(1999,8,21)),
                new User("Paolo", "paolopi", "paolo.pio@gmail.com", "3911172150", "+39", Account.Status.ACTIVE, "Italy", "Apulia", "San Marco In Lamis", "00001",
                        "via le mani dai taralli", "00/c", "Pio", "Bevilacqua", User.Gender.M, "PLPBLQ99O99D508Y", "San Giovanni Rotondo", "Italy", LocalDate.of(1999,10,2)),
                new Company("Soldo", "sldin", "soldo.soldo@soldo.com", "1234567890", "+39", Account.Status.ACTIVE, "Italy", "Lazio", "Rome", "00159",
                        "via le mani dal soldo", "2/c", "123422342"),
                new Company("Softlab", "sftlb", "soft.lab@softlab.com", "1234562290", "+39", Account.Status.ACTIVE, "Italy", "Lazio", "Rome", "00159",
                        "via le mani dal bell stu sit", "13/c", "123499342")
        );
        accountRepository.saveAll(accounts);
        List<BankAccount> bankAccounts = Arrays.asList(
                new BankAccount(accounts.get(0), "1234543212345432123454321234", "firstBankAccount", "universitary", Currency.getInstance("EUR"), new Money(BigDecimal.ZERO), new Money(BigDecimal.valueOf(100))),
                new BankAccount(accounts.get(1), "1234543212311112123454321234", "AeroBankAccount", "boh", Currency.getInstance("EUR"), new Money(BigDecimal.ZERO), new Money(BigDecimal.valueOf(50)))
        );
        bankAccountRepository.saveAll(bankAccounts);
        return "populated";
    }

    @Override
    public String cleanDB() {
        return null;
    }

    @Override
    public String conversionRate() {
        return exchangeData.fetchData().toString();
    }
}
