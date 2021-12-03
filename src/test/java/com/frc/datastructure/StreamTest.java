package com.frc.datastructure;
import com.frc.entity.FeeRecord;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.Arrays;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StreamTest {
    List<FeeRecord> list = null;
    DealFeeRecord dealFeeRecord = new DealFeeRecord();

    @BeforeAll
    void setUp(){
        FeeRecord f1 = new FeeRecord("2020135", "50.00", "1385618216");
        FeeRecord f2 = new FeeRecord("2020136", "10.00", "1385618216");
        FeeRecord f3 = new FeeRecord("2020137", "850.00", "1385618216");
        FeeRecord f4 = new FeeRecord("2020138", "120.00", "1385618216");
        FeeRecord f5 = new FeeRecord("2020139", "510.00", "1385618216");
        FeeRecord f6 = new FeeRecord("2021135", "32.00", "1385618216");
        FeeRecord f7 = new FeeRecord("2220135", "10.00", "1385618216");
        list = Arrays.asList(f1,f2,f3,f4,f5,f6,f7);
    }

    @Test
    void calculateAmount(){
        System.out.println(dealFeeRecord.calculateAmount(list));
    }

}