/**
 * 
 */
package com.jpmorgan.test.util;

import java.util.Calendar;

import com.jpmorgan.test.vo.TradeVO;

/**
 * @author SanthoshK
 *
 */
public class CalculationUtil {

	public static float calculateCommonDividendYield(float lastDividend, float tickerPrice) {
		try {
			float commonDividendYield = lastDividend / tickerPrice;
			return commonDividendYield;
		} catch (Exception e) {
			return 0;
		}
	}

	public static float calculatePreferredDividendYield(float fixedDividend, float tickerPrice, float parValue) {
		try {
			float preferredDividendYield = (fixedDividend * parValue)/ tickerPrice;
			return preferredDividendYield;
		} catch (Exception e) {
			return 0;
		}
	}
	public static float calculatePERatio (float tickerPrice, float dividend){
		try {
			float peRatio = tickerPrice / dividend;
			return peRatio;
		} catch (Exception e) {
			return 0;
		}
	}
	public static float calculateTradeValue(TradeVO tradeVO){
		return tradeVO.getTradePrice() * tradeVO.getQuantity();
	}
	public static Long getPreviousTimeInMillis(int minutes) {
		Calendar currentTimeCal = Calendar.getInstance();
		currentTimeCal.add(Calendar.MINUTE, -minutes);
		return currentTimeCal.getTimeInMillis();
	}
}
