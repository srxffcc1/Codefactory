package com.codefactory.abstracts;

public class NodeEntity {
private String key;
private String value;
private String separator;
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
public String getSeparator() {
	return separator;
}
public void setSeparator(String separator) {
	this.separator = separator;
}
public NodeEntity(String key,  String separator,String value) {
	super();
	this.key = key;	
	this.separator = separator;
	this.value = value;
}
public NodeEntity() {
	super();
}
@Override
public String toString() {
	return key+separator+value;
}


}
