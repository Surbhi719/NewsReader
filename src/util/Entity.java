package util;

public class Entity implements Tag{

	@Override
	public String appendTag(String data) {
		
		return "<strong>" + data + "</strong>";
	}

}
