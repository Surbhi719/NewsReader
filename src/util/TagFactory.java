package util;

public class TagFactory {

	public Tag getTag(TagCategory category){
		if(category == null){
			return null;
		}
		if(category == TagCategory.ENTITY){
			return new Entity();
		} else if (category == TagCategory.USERNAME){
			return new Username();
		} else if (category == TagCategory.LINK){
			return new Link();
		}
		
		return null;
	}
}
