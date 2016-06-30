package com.example.megan.webcams;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import xml.Camera;
import xml.FineDay;
import xml.Images;

/**
 * Created by megan on 29/06/16.
 */
public class XmlReader {

    private static final String nameSpaces = null;

    public List parse(InputStream inputStream) throws XmlPullParserException, IOException{

        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(inputStream, null);
            parser.nextTag();
            return readFeed(parser);


        }finally {
            inputStream.close();
        }

    }

    /**
     * readFeed does the actual processing, looks for element tags
     * recursively processing the feed
     * returns a list containing all the cams
     * @param parser
     * @return
     */
    private List readFeed(XmlPullParser parser) throws IOException, XmlPullParserException {
        List cameras = new ArrayList();

        parser.require(XmlPullParser.START_TAG, nameSpaces, "feed");
        while (parser.next() != XmlPullParser.END_TAG) {
            if(parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("cam")) {
                cameras.add(readEntry(parser));
            }else {
                skip(parser);
            }
            return cameras;
        }

    }

    private Camera readEntry(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, nameSpaces, "camera");
        String description = null;
        String thumbnailFile = null;
        String cameraName = null;
        Images images = null;
        FineDay lastFineDay = null;
        while (parser.next() != XmlPullParser.START_TAG) {
            continue;
        }
        String name = parser.getName();
        if(name.equals("description")) {
            description = readDescription(parser);
        }else if (name.equals("thumbFile")) {
            thumbnailFile=readThumbnailFile(parser);
        }else if (name.equals("camName")) {
            cameraName=readCameraName(parser);
        }else if (name.equals("images")) {
            images=readImages(parser);
        }else if (name.equals("fineDay")) {
            lastFineDay=readLastFineDay(parser);
        }else {
            skip(parser);
        }
        return new Camera(description, thumbnailFile, cameraName, images, lastFineDay);
    }

    private String readThumbnailFile(XmlPullParser parser) {

    }

    private String readDescription(XmlPullParser parser) {
    }
}
