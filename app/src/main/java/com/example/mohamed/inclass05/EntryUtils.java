package com.example.mohamed.inclass05;

import android.util.Log;
import android.util.Xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by mohamed on 2/13/17.
 */

public class EntryUtils {

    static public class EntriesSAXParser extends DefaultHandler //Needs to extend Handler
    {
        ArrayList<Entry> entryList;
        StringBuilder xmlInnerText = new StringBuilder();
        Entry e;

        static public ArrayList<Entry> parseEntries(InputStream in) throws IOException, SAXException{

            EntriesSAXParser entriesSAXParser = new EntriesSAXParser();
            Xml.parse(in,Xml.Encoding.UTF_8,entriesSAXParser);
            return entriesSAXParser.getEntryList();
        }

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            xmlInnerText = new StringBuilder();
            entryList = new ArrayList<Entry>();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);

            if(localName.equals("item")){
                Log.d("dd","Found Item"); //Works
                e = new Entry();
                //e.setTitle(attributes.getValue("title"));
                //e.setPubDate("pubdate");
                //e.setDesc("description");
                //e.setImgUrl(attributes.getValue("media:group"));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            if(localName.equals("item")){
                Log.d("dd","Found Item"); //Works
               // e = new Entry();
                //e.setTitle(attributes.getValue("title"));
                //e.setPubDate("pubdate");
                //e.setDesc("description");
                //e.setImgUrl(attributes.getValue("media:group"));
                entryList.add(e);
            }
            else if (localName.equals("title")){
                e.setTitle(xmlInnerText.toString());
            }
            else if (localName.equals("pubdate")){
                e.setPubDate(xmlInnerText.toString());
            }
            else if (localName.equals("description")){
                e.setDesc(xmlInnerText.toString());
            }
            else if (localName.equals("media:group")){
                e.setImgUrl(xmlInnerText.toString());
            }
            xmlInnerText.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);

            //We retrieve details here

            xmlInnerText.append(ch,start,length);
        }
        public ArrayList<Entry> getEntryList() {
            return entryList;
        }

        public void setEntryList(ArrayList<Entry> entryList) {
            this.entryList = entryList;
        }
    }
}
