package com.codefactory.node;

import com.codefactory.abstracts.ParseBase;

import java.util.regex.Pattern;

public class XmlNode extends ParseBase{
	public Pattern getPropertyValuePattern(String head) {
		return Pattern.compile("(.*)(?i)"+head+"=(.*)");
	}
	public Pattern getPropetryPattern() {
		Pattern bodytmp2 = Pattern.compile("(.*?)=\\\"(.*?)\\\"");
		return bodytmp2;
	}
	public Pattern getBodyModel(String tmpmodelname) {
		Pattern bodytmp = Pattern.compile("<" + tmpmodelname
				+ "([\\s\\S]*?)</" + tmpmodelname + ">");
		return bodytmp;
	}
	public Pattern getBodyModel(String tmpmodelname,int duplicate) {
		String compilhead="";
		String compilend="";
		for (int i = 0; i < duplicate; i++) {
			compilhead="<" + tmpmodelname+ "([\\s\\S]*?)";
			compilend=compilend+"([\\s\\S]*?)</" + tmpmodelname + ">";
		}
		Pattern bodytmp = Pattern.compile(compilhead+compilend);
		return bodytmp;
	}
	public Pattern getBodyPattern(String modelnametmp) {
		Pattern body = Pattern.compile("<" + modelnametmp + "([\\s\\S]*)</"
				+ modelnametmp + ">");
		return body;
	}
	public Pattern getHeadPattern() {
		Pattern head = Pattern.compile("<(.*?)[\\s\\n]");
		return head;
	}
	public String getPropertyEnd(){
		return "";
	}
	public String getNodeHead(String modelname){
		return "<"+modelname+"";
	}
	public String getNodeEnd(String modelname){
		return "</"+modelname+">";
	}
	public Pattern getEndPattern() {
		Pattern end = Pattern.compile("[\\s\\S]*</(.*?)>");
		return end;
	}
	public Pattern getSpecailBodyPattern(String modelnametmp) {
		Pattern body = Pattern.compile("<" + modelnametmp + "([\\s\\S]*)"
				+ "/>");
		return body;
	}
	public Pattern getSpecailPattern(){
		Pattern end = Pattern.compile("<(.*?)\\s([\\s\\S]*?)/>");
		return end;
	}
	public String getSpecailHead(){
		return "<";
	}
	public String getSpecailEnd(){
		return ">";
	}

	@Override
	public String getSpecailEnd1() {
		return ">";
	}

	@Override
	public String separator() {
		// TODO Auto-generated method stub
		return "=";
	}
	@Override
	public String getSpecailEnd2() {
		// TODO Auto-generated method stub
		return "/>";
	}
	@Override
	public String valueclude() {
		// TODO Auto-generated method stub
		return "\"";
	}
	@Override
	public ParseBase build(String... nodename) {
		// TODO Auto-generated method stub
		String nodename1=nodename.length>0?nodename[0]:"";
		return new XmlNode().setNodename(nodename1);
	}
	@Override
	public Pattern getSpecailPattern(String head) {
		Pattern end = Pattern.compile("<"+head+"([\\s\\S]*?)/>");
		return end;
	}
	@Override
	public String getSpecailHead2() {
		// TODO Auto-generated method stub
		return "";
	}
	@Override
	public Pattern getBodyModelSpecial(String tmpmodelname) {
		Pattern bodytmp = Pattern.compile("<" + tmpmodelname
				+ "([\\s\\S]*)</" + tmpmodelname + ">");
		return bodytmp;
	}
}
