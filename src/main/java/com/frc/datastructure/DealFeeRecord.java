package com.frc.datastructure;

import com.frc.entity.FeeRecord;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class DealFeeRecord {

    public String calculateAmount(List<FeeRecord> list){
        List<String> amountList;
        if(list.size() > 0){
            BigDecimal total = new BigDecimal("0.00");
            //实体类列表中某一项 ---> 提取到list中
            amountList = list
                    .stream()
                    .map(FeeRecord::getAmount)
                    .collect(Collectors.toList());
            //计算list每一项的总和
            for(String amount:amountList){
                BigDecimal decimalAmount = new BigDecimal(amount);
                total = total.add(decimalAmount);
            }
            //格式转化
            DecimalFormat format = new DecimalFormat("0.00");
            String totalAmountStr = format.format(total);
            return totalAmountStr;
        }
        return null;
    }

}
