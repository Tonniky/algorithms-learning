package DesignPattern.Adapter;

import java.io.InputStream;

public class B implements ReaderXml,XmlReader{
    @Override
    public InputStream readerXml() {
        return null;
    }

    @Override
    public InputStream xmlReader() {
        return null;
    }
}
