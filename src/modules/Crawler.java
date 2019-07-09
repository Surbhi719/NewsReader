package modules;

import model.Feed;

/**Crawler command module**/
public class Crawler implements Command{
	Feed feed;
	
	public Crawler(Feed f){
		this.feed = f;
	}
	
	public void execute(){
		
		feed.setData("Obama visited Facebook headquarters: http://bit.ly/xyz@elversatile");
	}
}
