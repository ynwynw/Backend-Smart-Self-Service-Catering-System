package com.elsa.DataStatistics.statistics;

import com.elsa.DataStatistics.mapper.MonthMapper;
import com.elsa.DataStatistics.mapper.OrderMapper;
import com.elsa.DataStatistics.pojo.Month;
import com.elsa.DataStatistics.pojo.Order;
import com.elsa.DataStatistics.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonthStatistics {

    @Autowired
    private TimeUtil timeUtil;

    @Autowired
    private MonthMapper monthMapper;

    @Autowired
    private OrderMapper orderMapper;

    public void monthStatistics(String oId) {

        int mId = timeUtil.getMonthTime();

        Month month1 = monthMapper.selectById(mId);

        Month month2 = new Month();

        if(month1 == null) {
            Order order = orderMapper.selectById(oId);
            double mIncome = order.getOTotalPrice();
            double mExpend = mIncome / 2;
            double mProfit = mIncome / 2;
            month2.setMonId(mId);
            month2.setMonIncome(mIncome);
            month2.setMonExpend(mExpend);
            month2.setMonProfit(mProfit);
            monthMapper.insert(month2);
        } else {
            Order order = orderMapper.selectById(oId);
            double mIncome = order.getOTotalPrice();
            double mExpend = mIncome / 2;
            double mProfit = mIncome / 2;
            month2.setMonId(mId);
            month2.setMonIncome(month1.getMonIncome() + mIncome);
            month2.setMonProfit(month1.getMonProfit() + mExpend);
            month2.setMonProfit(month1.getMonProfit() + mProfit);
            monthMapper.updateById(month2);
        }
    }

}
