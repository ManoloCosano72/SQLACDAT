package com.github.ManoloCosano72.model.test;

import com.github.ManoloCosano72.model.connection.ConnectionProperties;
import com.github.ManoloCosano72.model.connection.XMLManager;

public class LoadConnection {
    public static void main(String[] args) {
        ConnectionProperties c = XMLManager.readXML (new ConnectionProperties(),"connection.xml");
        XMLManager.readXML(c,"connection.xml");
        System.out.println(c);
    }
}
