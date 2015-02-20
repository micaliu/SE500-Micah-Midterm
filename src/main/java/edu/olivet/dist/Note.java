package edu.olivet.dist;

import java.util.ArrayList;
import java.util.List;

public class Note {

	enum Category {
		Feature,
		Enhancement,
		BugFix
	}
	
	private Category category;
	private List<String> contents = new ArrayList<String>();

	public void addContent(String s) {
		contents.add(s);
	}
	
	public List<String> getContents() {
		return contents;
	}
	public void setContents(List<String> contents) {
		this.contents = contents;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Note [category=" + category + ", contents=" + contents + "]";
	}
}
