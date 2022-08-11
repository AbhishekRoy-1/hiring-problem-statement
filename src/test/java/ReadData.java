import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadData {
	Double netCostPrice=0.0;
	Double netSellPrice=0.0;
	 Double cp1,Profit,Loss,costPrice1,sp1=0.0;
	  Double soldQuantity, sellPrice,totalSellPrice;
	

	
	
	public List<POJO> buyStocks() throws StreamReadException, DatabindException, IOException{
		ObjectMapper mapper= new ObjectMapper();
		InputStream inputStream= new FileInputStream(new File(".\\jsonfiles\\trade.json"));
		TypeReference<List<POJO>> typeRef= new TypeReference<List<POJO>> () {};
		List<POJO> pojo= mapper.readValue(inputStream, typeRef);
		System.out.println("\n\t\t\tStocks Bought ");
		for(POJO p:pojo)
		{
			Double quantity;
			Double price;
			Double costPrice;
			while(p.getTransaction_type().contentEquals("BUY"))
			{
				quantity= Double.parseDouble(p.getQuantity());
				price=Double.parseDouble(p.getPrice());
				costPrice1=price;
				costPrice=quantity*price;
				cp1=costPrice;
				System.out.println("\n\t"+p.getName()+" --> Quantity of Stocks -->"+p.getQuantity()+"--> Total Cost Price -->"+costPrice);
				//System.out.println("\n\nThe Details of Stocks Bought are "+"\n SNO "+pojo.indexOf(p)+"\n Stock Name--->"+ p.getName() +" \n Cost of Share --->"+p.getPrice()+"\n Ticker---> "+p.getTicker()+"\n Transaction Type--->"+p.getTransaction_type()+"\n Quantity of Stocks ---> "+p.getQuantity()+"\n Sector --->"+p.getSector()+"\n Trade Time---> "+p.getTrade_time()+"\n Stock Type --->"+p.getStock_type());;                                                           
				netCostPrice=netCostPrice+cp1;
				break;
				
			}
		
		
		
		}
		System.out.println("\n\tThe Net Cost Price for all shares are -->"+netCostPrice);
		
		
		
		return pojo;
		
		
	}
	public List<POJO> sellStocks() throws StreamReadException, DatabindException, IOException{
		ObjectMapper mapper= new ObjectMapper();
		InputStream inputStream= new FileInputStream(new File(".\\jsonfiles\\trade.json"));
		TypeReference<List<POJO>> typeRef= new TypeReference<List<POJO>> () {};
		List<POJO> pojo= mapper.readValue(inputStream, typeRef);
		System.out.println("\n\t\t\tStocks Sold ");
		for(POJO p:pojo)
		{
			Double quantity;
			Double price;
			Double sellPrice;
			while(p.getTransaction_type().contentEquals("SELL"))
			{
				quantity= Double.parseDouble(p.getQuantity());
				price=Double.parseDouble(p.getPrice());
				sellPrice=quantity*price;
				sp1=sellPrice;
				System.out.println("\n\t"+p.getName()+" --> Quantity of Stocks -->"+p.getQuantity()+"--> Total Selling Price -->"+sellPrice);
				//System.out.println("\n\nThe Details of Stocks Bought are "+"\n SNO "+pojo.indexOf(p)+"\n Stock Name--->"+ p.getName() +" \n Cost of Share --->"+p.getPrice()+"\n Ticker---> "+p.getTicker()+"\n Transaction Type--->"+p.getTransaction_type()+"\n Quantity of Stocks ---> "+p.getQuantity()+"\n Sector --->"+p.getSector()+"\n Trade Time---> "+p.getTrade_time()+"\n Stock Type --->"+p.getStock_type());;                                                           
				netSellPrice=netSellPrice+sp1;
				break;
				
				
			}
			
			
		}
		System.out.println("\n\tThe Net Sell Price for all shares are -->"+netSellPrice);
		
		
		return pojo;
				
	}
	
	public List<POJO> TimeFilter(String buyTime,String sellTime) throws StreamReadException, DatabindException, IOException{
		ObjectMapper mapper= new ObjectMapper();
		InputStream inputStream= new FileInputStream(new File(".\\jsonfiles\\trade.json"));
		TypeReference<List<POJO>> typeRef= new TypeReference<List<POJO>> () {};
		List<POJO> pojo= mapper.readValue(inputStream, typeRef);
		
		
		for(POJO p:pojo)
		{
			while(p.getTransaction_type().contains("SELL"))
			{
				
				if(buyTime.contains(p.getTrade_time()))
				{
					soldQuantity=Double.parseDouble(p.getQuantity());
					System.out.println(p.getName()+"-->Trade Time-->"+p.getTrade_time()+"-->Trade Quantity-->"+p.getQuantity());
					calc();
					break;
				}
				else if(sellTime.contains(p.getTrade_time()))
				{
					System.out.println(p.getName()+"-->Trade Time-->"+p.getTrade_time()+"-->Trade Quantity-->"+p.getQuantity());
					break;
				}
				
				else
				{
					System.out.println("Stock Don't Exist !");
					break;
					
				}
				
				
			}
			
		
		
			
		}
		
		
		
		
		return null;
		
		
	}
	
	public Double calc() throws StreamReadException, DatabindException, IOException {
		ObjectMapper mapper= new ObjectMapper();
		InputStream inputStream= new FileInputStream(new File(".\\jsonfiles\\trade.json"));
		TypeReference<List<POJO>> typeRef= new TypeReference<List<POJO>> () {};
		List<POJO> pojo= mapper.readValue(inputStream, typeRef);
		for(POJO p:pojo)
		{	
		Double val1= soldQuantity*costPrice1;//total cp for 10 shares
		Double val2=sp1;//total sp for 10 shares
		if(val1>val2)
		{
			Loss= val1-val2;
			System.out.println("The Loss is "+Loss);
			
		}
		else
		{
			Profit=val2-val1;
			System.out.println("The profit is "+Profit);
		}
		
		}
		
		
		
		return calc();
		
	}
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ReadData read= new ReadData();
		read.buyStocks();
		System.out.println("\t_________________________________________________________________________________________________");
		read.sellStocks();
		System.out.println("\t_________________________________________________________________________________________________");
	
		Scanner sc= new Scanner(System.in);  
		System.out.print("\n\tEnter the Stock Buy Time: ");  
		String buyTime= sc.nextLine();
		System.out.print("\n\tEnter the Stock Sell Time: ");  
		String sellTime= sc.nextLine();
		read.TimeFilter(buyTime, sellTime);
		

	}

}
