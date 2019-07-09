package model;

import java.util.List;

import util.Mapping;

public class Feed {
	
	private String data;
	private List<Mapping> tagMapping;
	private String formattedData;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public List<Mapping> getTagMapping() {
		return tagMapping;
	}
	public void setTagMapping(List<Mapping> tagMapping) {
		this.tagMapping = tagMapping;
	}
	public String getFormattedData() {
		return formattedData;
	}
	public void setFormattedData(String formattedData) {
		this.formattedData = formattedData;
	}
	
	

}
