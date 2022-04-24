package com.gmail.evanloafakahaitao.hwk.hwk19.task1;

public final class ReaderFactory {

    /*private static ReaderFactory readerFactory = null;

    public static ReaderFactory getInstance() {
        if (readerFactory == null) {
            synchronized (readerFactory) {
                if (readerFactory == null) {
                    readerFactory = new ReaderFactory();
                }
            }
        }
        return readerFactory;
    }*/

    private ReaderFactory() {}

    public static ReaderFactory getInstance() {
        return LazyReaderFactoryInitializer.readerFactory;
    }

    private static class LazyReaderFactoryInitializer {
        public static ReaderFactory readerFactory = new ReaderFactory();
    }

    public TextReader getReader(ReaderTypes type) {
        switch (type) {
            case TXT: return new TxtReader();
            case XML: return new XmlReader();
            case PROPERTIES: return new PropertiesReader();
                default: return new TxtReader();
        }
    }

    public enum ReaderTypes {
        TXT,
        XML,
        PROPERTIES
    }
}
