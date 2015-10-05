/**
 * 
 */
package com.jpmorgan.test.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jpmorgan.test.service.util.CalculationService;
import com.jpmorgan.test.util.CalculationUtil;
import com.jpmorgan.test.util.TradeConstants.STOCK_TYPE;
import com.jpmorgan.test.util.TradeConstants.TRADE_TYPE;
import com.jpmorgan.test.vo.TradeVO;

/**
 * @author SanthoshK
 *
 */
public class TradeService implements Service{

	private Map<String, Map<Long, TradeVO>> tradeList;

	public TradeService() {
		tradeList = new HashMap<String, Map<Long, TradeVO>>();
	}

	public void recordTrade(Date tradeTime, String stockSymbol,
			int stockQuantity, TRADE_TYPE tradeType, float price) {
		TradeVO tradeVO = new TradeVO(stockSymbol, tradeTime, stockQuantity,
				tradeType, price);
		this.recordTrade(tradeVO);

	}

	public void recordTrade(TradeVO tradeVO) {
		String stockSymbol = tradeVO.getStockSymbol();
		Map<Long, TradeVO> tradeSubList = tradeList.get(stockSymbol);

		if (tradeSubList == null || tradeSubList.size() <= 0) {
			tradeSubList = new HashMap<Long, TradeVO>();
			tradeList.put(stockSymbol, tradeSubList);
		}

		tradeSubList.put(tradeVO.getTradeTime().getTime(), tradeVO);
	}

	public float calculateDividendYield(STOCK_TYPE stockType, float dividend,
			float tickerPrice, float parValue) {
		if (STOCK_TYPE.COMMON == stockType) {
			return CalculationUtil.calculateCommonDividendYield(dividend, tickerPrice);
		}
		return CalculationUtil.calculatePreferredDividendYield(dividend, tickerPrice, parValue);
	}

	public float calculatePERatio(float dividend, float tickerPrice) {
		return CalculationUtil.calculatePERatio(tickerPrice, dividend);
	}
	
	public float calculateStockPrice(String stockSymbol){
		CalculationService	service = new CalculationService();
		return service.calculateStockPrice(stockSymbol, tradeList);
		
	}
	public double calculateGeometricMean() {
		CalculationService	service = new CalculationService();
		return service.calculateGeometricMean(tradeList);
	}
	public void printTradeList(){
		System.out.println(tradeList);
	}
}
