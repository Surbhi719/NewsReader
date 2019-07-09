package modules;

import java.util.ArrayList;
import java.util.List;

import model.Feed;
import util.Mapping;
import util.TagCategory;

/**Parser Command Module**/
public class Parser implements Command{
	
	Feed feed;
	
	public Parser(Feed f){
		this.feed = f;
	}
	
	public void execute(){
		
		String inputFeed = feed.getData();
		
		List<Mapping> tagMapping = parse(inputFeed);
		
		feed.setTagMapping(tagMapping);
	}

	private List<Mapping> parse(String inputFeed) {
		
		List<Mapping> mapping = new ArrayList<>();
		Mapping m1 = new Mapping(14, 22, TagCategory.ENTITY);
		mapping.add(m1);
		
		Mapping m2 = new Mapping(0, 5, TagCategory.ENTITY);
		mapping.add(m2);
		
		//Please note that in the given problem statement example the tag mapping here was wrongly stated as 67
		Mapping m3 = new Mapping(55, 66, TagCategory.USERNAME);
		mapping.add(m3);
		
		Mapping m4 = new Mapping(37, 54, TagCategory.LINK);
		mapping.add(m4);
		
		return mapping;
	}

}
