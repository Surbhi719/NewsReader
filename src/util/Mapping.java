package util;

//Following the principle of Encapsulation, making fields private & getter/setters public
	public class Mapping {
		
		private int start;
		private int end;
		private TagCategory tagCategory;
		
		public Mapping(int start, int end, TagCategory tagCategory) {
			super();
			this.start = start;
			this.end = end;
			this.tagCategory = tagCategory;
		}
		
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		public TagCategory getTagCategory() {
			return tagCategory;
		}
		public void setTagCategory(TagCategory tagCategory) {
			this.tagCategory = tagCategory;
		}
	}
	
