package com.test;

import com.codefactory.abstracts.ParseBase;
import com.codefactory.node.XmlNode;
import com.codefactory.utils.Util_File;

public class XmlTest {
    public static void main(String[] args) {
        String orgstring = Util_File.inputStream2String("templet_activity_list.xml");
        ParseBase parent = new XmlNode().build().parse(orgstring);
        System.out.println(parent.getEntityString());
    }
}
