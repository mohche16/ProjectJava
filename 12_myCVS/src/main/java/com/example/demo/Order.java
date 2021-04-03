package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
	private int OrderId;
    private String OrderDate;
    private String Region;
    private String Rep1;
    private String Rep2;
    private String Item;
    private int Units;
    private float UnitCost;
    private float Total;
    
    HashMap<String, String> Data = new HashMap<String, String>();

    public Order(int OrderId, String OrderDate, String Region, String Rep1, String Rep2, String Item, int Units, float UnitCost, float Total) {
    	this.OrderId = OrderId;
    	this.OrderDate = OrderDate;
        this.Region = Region;
        this.Rep1 = Rep1;
        this.Rep2 = Rep2;
        this.Item = Item;
        this.Units = Units;
        this.UnitCost = UnitCost;
        this.Total = Total;
        
        Data.put("OrderId", Integer.toString(this.OrderId));
        Data.put("OrderDate", this.OrderDate);
        Data.put("Region", this.Region);
        Data.put("Rep1", this.Rep1);
        Data.put("Rep2", this.Rep2);
        Data.put("Item", this.Item);
        Data.put("Units", Integer.toString(this.Units));
        Data.put("UnitCost", Float.toString(this.UnitCost));
        Data.put("Total", Float.toString(this.Total));
    }
    
   public String GetData(String key) {
	   return Data.get(key);
   }
    
    
};