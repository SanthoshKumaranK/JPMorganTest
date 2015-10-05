package com.jpmorgan.test.test;

import java.util.Date;
import java.util.Random;

import com.jpmorgan.test.service.Service;
import com.jpmorgan.test.service.TradeService;
import com.jpmorgan.test.util.TradeConstants.TRADE_TYPE;


public class MyTest {

	public static void main(String[] args) {
		MyTest myTestObj = new MyTest();
		myTestObj.test();
	}
	private void test(){
		try {
			MyThread myThread = new MyThread();
			myThread.start();
		} catch (Exception e) {
			System.err.println("ERROR Occurred!");
			e.printStackTrace();
		} finally {
			System.out.println("All Done!!!");
		}
	}
	private class MyThread extends Thread {
		
		public void run(){
			try {
				System.out.println("Thread Start");
				testTradeService();
			} catch (Exception e) {
				System.err.println("Error Occurred in Thread!");
			} finally {
				System.out.println("Test in Thread done!");
			}
		}
		public void testTradeService() throws InterruptedException{
			Service tradeService = new TradeService();
			
			for(int index=0; index <=15; index++) {
				
				TRADE_TYPE tradeType = (index % 2 ==0) ? TRADE_TYPE.BUY : TRADE_TYPE.SELL;
				String stockName = "STOCK"+(index%10);
				
				tradeService.recordTrade(new Date(), stockName, (new Random().nextInt(50) * index), tradeType, (new Random().nextFloat() * index));
				System.out.println("Record Trade ["+index+"] - " + stockName);
				Thread.sleep((1*60*1000));
			}
			System.out.println("All Recorded");
			tradeService.printTradeList();
			System.out.println("----------");
			System.out.println("STOCK2 ----> " + tradeService.calculateStockPrice("STOCK2"));
			System.out.println("STOCK5 ----> " + tradeService.calculateStockPrice("STOCK5"));
			
			System.out.println("GM : " + tradeService.calculateGeometricMean());
		}
		
	}
	

}
