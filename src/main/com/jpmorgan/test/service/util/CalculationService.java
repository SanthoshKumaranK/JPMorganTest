/**
 * 
 */
package com.jpmorgan.test.service.util;

import java.util.Map;
import java.util.Set;

import com.jpmorgan.test.util.CalculationUtil;
import com.jpmorgan.test.util.TradeConstants;
import com.jpmorgan.test.vo.TradeVO;

/**
 * @author SanthoshK
 *
 */
public class CalculationService {

	public float calculateStockPrice(String stockSymbol,
			Map<String, Map<Long, TradeVO>> tradeList) {
		float tradeValue = 0.0f;
		float totalTradeValue = 0.0f;
		int totalQuantity = 0;
		Long previousTimeInMillis = CalculationUtil.getPreviousTimeInMillis(TradeConstants.STOCK_PRICE_CALC_MINUTES);
		
		Map<Long, TradeVO> tradeSubList = tradeList.get(stockSymbol);
		Set<Long> keySet = tradeSubList.keySet();
		for (Long tradeTimeStamp : keySet) {
			if (tradeTimeStamp > previousTimeInMillis) {
				TradeVO tradeVO = tradeSubList.get(tradeTimeStamp);
				tradeValue = CalculationUtil.calculateTradeValue(tradeVO);
				totalTradeValue += tradeValue;
				totalQuantity += tradeVO.getQuantity();
			}
		}
		float stockPrice = totalTradeValue / totalQuantity;
		return stockPrice;
	}

	public double calculateGeometricMean(
			Map<String, Map<Long, TradeVO>> tradeList) {
		float tradeValue = 0.0f;
		float totalTradeValue = 0.0f;
		int totalQuantity = 0;
		float stockPrice = 0.0f;
		float totalStockPrice = 1.0f;
		for (Map<Long, TradeVO> tradeSubList : tradeList.values()) {
			for (TradeVO tradeVO : tradeSubList.values()) {
				tradeValue = CalculationUtil.calculateTradeValue(tradeVO);
				totalTradeValue += tradeValue;
				totalQuantity += tradeVO.getQuantity();
			}
			stockPrice = totalTradeValue / totalQuantity;
			totalStockPrice = totalStockPrice * stockPrice;
		}
		double geometricMeanValue = Math.pow(totalStockPrice, (1.0/tradeList.size()));
		return geometricMeanValue;
	}
}
