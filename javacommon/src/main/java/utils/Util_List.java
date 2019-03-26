package utils;

import java.util.ArrayList;
import java.util.List;

public class Util_List {
	List<Object> list=new ArrayList<Object>();
	public Util_List(){
		list.clear();
	}
	
	public Util_List add(Object object){
		list.add(object);
		return this;
		
	}
	public Util_List clear(Object object){
		list.clear();
		return this;
	}
	public Object get(int index){
		return list.get(index);
	}
	public Util_List remove(int index){
		list.remove(index);
		return this;
	}
	public int size(){
		return list.size();
	}
	
}
