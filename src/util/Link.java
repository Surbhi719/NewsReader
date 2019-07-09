package util;

public class Link implements Tag{

	@Override
	public String appendTag(String data) {
		
		return "<a href = \"" + data + "\">" + data + "</a>";
	}

}
