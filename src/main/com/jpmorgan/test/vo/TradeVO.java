/**
 * 
 */
package com.jpmorgan.test.vo;

import java.io.Serializable;
import java.util.Date;

import com.jpmorgan.test.util.TradeConstants.TRADE_TYPE;

/**
 * @author SanthoshK
 *
 */
public class TradeVO implements Serializable {

	private static final long serialVersionUID = 4657043989048392860L;
	
	private String stockSymbol;
	private Date tradeTime;
	private int quantity;
	private TRADE_TYPE tradeType;
	private float tradePrice;
	
	public TradeVO(String stockSymbol, Date tradeTime, int quantity, TRADE_TYPE tradeType, float tradePrice){
		this.stockSymbol = stockSymbol;
		this.tradeTime = tradeTime;
		this.quantity = quantity;
		this.tradeType = tradeType;
		this.tradePrice = tradePrice;
	}
	
	public String toString(){
		return "[" + this.stockSymbol + "," + 
		this.tradeTime + "," + 
		this.quantity + "," + 
		this.tradeType + "," + 
		this.tradePrice + "]";
	}
	
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public Date getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public TRADE_TYPE getTradeType() {
		return tradeType;
	}
	public void setTradeType(TRADE_TYPE tradeType) {
		this.tradeType = tradeType;
	}
	public float getTradePrice() {
		return tradePrice;
	}
	public void setTradePrice(float tradePrice) {
		this.tradePrice = tradePrice;
	}
}
