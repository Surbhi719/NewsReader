package modules;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Feed;
import util.Mapping;
import util.Tag;
import util.TagFactory;

/**Formatter command module**/
public class Formatter implements Command{
	
	Feed feed;
	
	public Formatter(Feed f){
		this.feed = f;
	}
	
	public void execute(){
		
		String inputFeed = feed.getData();
		List<Mapping> tagMapping = feed.getTagMapping();
		
		String finalFormattedText = formatText(inputFeed, tagMapping);
			
		feed.setFormattedData(finalFormattedText);
	}

	private String formatText(String inputFeed, List<Mapping> tagMapping) {
		//Because in this use case two mappings cannot overlap so sorting based on just start index sorts the entire ArrayList<Mapping>
		Comparator<Mapping> startIndexComparator = new Comparator<Mapping>(){
			@Override
			public int compare(Mapping m1, Mapping m2){
				int value1 = m1.getStart();
				int value2 = m2.getStart();
				return value1>value2 ? 1 : -1 ;
			}
		};
		
		Collections.sort(tagMapping, startIndexComparator);
		
		//Used to get the correct indices - start, end while applying changes
		int incrementCounter = 0;
		
		//Using stringBuilder for BETTER PERFORMANCE
		//For applying changes to input string & avoiding new String creation every time there is a change
		StringBuilder finalFormattedText = new StringBuilder(inputFeed);
		
		for(Mapping m: tagMapping){
			
			int start = m.getStart();
			int end = m.getEnd();
			
			//Used FACTORY DESIGN PATTERN to call the respective Tag classes appendTag() method at runtime based on the TagCategory
			//Provides simplicity for extension: No changes required in this code when a new tag category is added
			TagFactory tagFactory = new TagFactory();
			Tag tag = tagFactory.getTag(m.getTagCategory());
			
			//remove the text snippet that needs changes
			removeSnippet(finalFormattedText, start+incrementCounter, end + incrementCounter);
			
			//update text snippet
			String updatedTextSnippet = tag.appendTag(inputFeed.substring(start, end));
			
			//append changed snippet to final stringBuilder object
			appendSnippetChanges(finalFormattedText, updatedTextSnippet, start, end, incrementCounter);
			
			//the indices of next elements will be moved by the length the current snippet has increased
			incrementCounter += updatedTextSnippet.length() - (end - start);
			
			}
		return finalFormattedText.toString();
	}

	private static void removeSnippet(StringBuilder finalFormattedText, int start, int end) {
		
		finalFormattedText.delete(start, end);
	}

	private static void appendSnippetChanges(StringBuilder formattedText, String updatedTextSnippet, int start, int end, int incrementCounter) {
		
		formattedText.insert(start + incrementCounter, updatedTextSnippet);
	}

}
