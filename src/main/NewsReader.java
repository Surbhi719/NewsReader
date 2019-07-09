package main;

import util.FeedOperator;
import model.Feed;
import modules.Command;
import modules.Crawler;
import modules.Formatter;
import modules.Parser;

public class NewsReader {

	public static void main(String[] args) {
		
		//Assuming we're calling all 3 modules for each feed item- as given in the example too. 
		//Given this we can consider the amount of input data coming in for module 3 & the output generated can be held in memory
		//As "a" feeds data can be held in memory - considering the 240 character limit for a twitter feed
		
		//Using String to hold feed data & ArrayList<Mapping> to hold mapping data
		
		//Using COMMAND DESIGN PATTERN below to call different modules on the Feed Object to perform different operations in the sequence
		//Allows: 1) Easy code extension, Defining & Calling of operations can be configuration driven which will prevent any code changes 
		//in the below code following OPEN CLOSE PRINCIPLE 2) Separation of concern
		Feed feed = new Feed();
		
		FeedOperator operations = new FeedOperator();
		
		//Output Module1: inputFeed in form of String
		Command crawler = new Crawler(feed);
		operations.setCommamdForAction("crawl", crawler);
		
		//Output Module2: ArrayList of Mapping (Mapping contains int start, int end, Enum TagCategory)
		Command parser = new Parser(feed);
		operations.setCommamdForAction("parse", parser);
		
		//Calling Module3 with Input: outputs of module1 & module2
		//Refer Formatter class for the algorithm used for formatting
		Command formatter = new Formatter(feed);
		operations.setCommamdForAction("format", formatter);
		
		operations.performOperation("crawl");
		operations.performOperation("parse");
		operations.performOperation("format");
		
		System.out.println(feed.getFormattedData());
		
	}
	
	
}
