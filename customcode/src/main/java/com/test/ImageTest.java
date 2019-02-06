package com.test;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageTest {
    public static void main(String[] args) {
        String url="http://www.workec.com/html/form/78945.html";
        Pattern pattern=Pattern.compile("https?://www.workec.com/html/form/(.+).html");
        Matcher matcher=pattern.matcher(url);
        while (matcher.find()){
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
        }

    }
}
