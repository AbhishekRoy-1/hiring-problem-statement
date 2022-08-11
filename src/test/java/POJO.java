
public class POJO {
	
	String name,ticker,transaction_type,price,quantity,stock_type,sector,trade_time;
	public POJO() {}

	public POJO(String name, String ticker, String transaction_type, String price, String quantity, String stock_type,
			String sector, String trade_time) {
		super();
		this.name = name;
		this.ticker = ticker;
		this.transaction_type = transaction_type;
		this.price = price;
		this.quantity = quantity;
		this.stock_type = stock_type;
		this.sector = sector;
		this.trade_time = trade_time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getStock_type() {
		return stock_type;
	}

	public void setStock_type(String stock_type) {
		this.stock_type = stock_type;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getTrade_time() {
		return trade_time;
	}

	public void setTrade_time(String trade_time) {
		this.trade_time = trade_time;
	}

	@Override
	public String toString() {
		return "POJO [name=" + name + ", ticker=" + ticker + ", transaction_type=" + transaction_type + ", price="
				+ price + ", quantity=" + quantity + ", stock_type=" + stock_type + ", sector=" + sector
				+ ", trade_time=" + trade_time + "]";
	}
	

}
