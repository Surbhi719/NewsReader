package util;

public class Username implements Tag {

	@Override
	public String appendTag(String data) {
		
		return "<a href =\"http://twitter.com/" + data + "\">" + data + "</a>";
	}

}
