package xml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by megan on 29/06/16.
 */
public class Image {
    private String title;
    private String fileName;

    public static final String BASE_URL = "http://www.mtruapehu.com/";
    private Bitmap imageCache = null;

    public String getTitle() {
        return title;
    }

    public String getFileName() {
        return BASE_URL + fileName;
    }
    public Bitmap getImage() {
        if(imageCache != null) {
            return imageCache;
        }
        try {
            URL url = new URL(getFileName());
            imageCache = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return imageCache;
        } catch(IOException e) {
            throw new RuntimeException("Couldn't read image");
        }
    }
}
