package com.frc.datastructure;

import com.frc.entity.Transaction;
import org.junit.jupiter.api.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SortTransactionTest {
    List<Transaction> list = null;
    SortTransaction sortTransaction = new SortTransaction();

    @BeforeAll
    void setUp(){
        Transaction t1 = new Transaction("11/30/2019", new BigDecimal(-3500),"FoodPanda");
        Transaction t2 = new Transaction("11/15/2019",new BigDecimal(-1500) ,"gym");
        Transaction t3 = new Transaction("11/03/2019", new BigDecimal(28000),"salary");
        Transaction t4 = new Transaction("11/11/2019", new BigDecimal(-500),"gym");
        Transaction t5 = new Transaction("11/30/2019", new BigDecimal(-8000),"shopping");
        Transaction t6 = new Transaction("11/30/2019", new BigDecimal(-7000),"shopping");
        Transaction t7 = new Transaction("11/30/2019", new BigDecimal(-15000),"gym");
        list = Arrays.asList(t1,t2,t3,t4,t5,t6,t7);
    }

    @Test
    void category() {
        Map<String, BigDecimal> result = sortTransaction.category(list);
        assertEquals( new BigDecimal(17000), result.get("gym"));
    }

    @Test
    void expenses() {
        assertEquals(new BigDecimal("35500.00"), sortTransaction.expenses(list));
    }

    @Test
    void income() {
        assertEquals(new BigDecimal("28000.00"), sortTransaction.income(list));
    }

    @AfterAll
    void mark(){
        System.out.println("\n Test Finish!");
    }
}