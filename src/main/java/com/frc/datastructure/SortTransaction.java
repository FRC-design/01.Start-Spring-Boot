package com.frc.datastructure;

import com.frc.entity.Transaction;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortTransaction {
    public Map<String, BigDecimal> category(List<Transaction> list) {
        Map<String, BigDecimal> map = new HashMap<>();
        for (Transaction transaction : list) {
            if (transaction == null) {
                continue;
            }
            BigDecimal num = transaction.getCountChange();
            String source = transaction.getSource();
            if (map.containsKey(source)) {
                map.put(source, map.get(source).add(num));
            } else {
                map.put(source, num);
            }
        }

        BigDecimal topNum = new BigDecimal("0.00");
        String topSource = null;
        for (String source: map.keySet()){
            if(source.equals("salary")){
                continue;
            }
            BigDecimal num = map.get(source).abs();
            topNum = topNum.max(num);
            if(num.compareTo(topNum) == 0){
                topSource = source;
            }
        }

        Map<String, BigDecimal> result = new HashMap<>();
        result.put(topSource,topNum);
        return result;
    }



    public BigDecimal expenses (List <Transaction> list) {
        BigDecimal expenses = new BigDecimal("0.00");
        for (Transaction transaction : list) {
            BigDecimal num = transaction.getCountChange();
            if(num.compareTo(new BigDecimal("0.00")) < 0){
                expenses = expenses.add(num.abs());
            }
        }
        return expenses;
    }


    public BigDecimal income (List < Transaction > list) {
        BigDecimal income = new BigDecimal("0.00");
        for (Transaction transaction : list) {
            BigDecimal num = transaction.getCountChange();
            if(num.compareTo(new BigDecimal("0.00")) > 0){
                income = income.add(num.abs());
            }
        }
        return income;
    }



}
