package com.test;

import com.codefactory.utils.Util_File;

public class HCTest {
    public static void main(String[] args) {
        String[] readline= Util_File.inputStream2String("D:\\WeGame\\流放之路\\logs\\Client.txt").split("\n");
        for (int i = 0; i <readline.length ; i++) {
            if(readline[i].contains("#<")){
                System.out.println(readline[i]);
            }
        }
    }
}
