package DesignPattern.constructMode.Adapter;

import java.io.InputStream;

public class Adapter extends B implements XmlReader {
    @Override
    public InputStream xmlReader() {
        return readerXml();
    }
}
