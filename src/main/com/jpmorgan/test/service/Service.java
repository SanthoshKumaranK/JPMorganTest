package com.jpmorgan.test.service;

import java.util.Date;

import com.jpmorgan.test.util.TradeConstants.STOCK_TYPE;
import com.jpmorgan.test.util.TradeConstants.TRADE_TYPE;
import com.jpmorgan.test.vo.TradeVO;

public interface Service {

	public void recordTrade(Date tradeTime, String stockSymbol,
			int stockQuantity, TRADE_TYPE tradeType, float price);

	public void recordTrade(TradeVO tradeVO);

	public float calculateDividendYield(STOCK_TYPE stockType, float dividend,
			float tickerPrice, float parValue);

	public float calculatePERatio(float dividend, float tickerPrice);

	public float calculateStockPrice(String stockSymbol);

	public double calculateGeometricMean();

	public void printTradeList();
}
