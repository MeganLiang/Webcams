package xml;


import java.util.List;

/**
 * Created by megan on 29/06/16.
 */
public class Camera {

    private String description;
    private String thumbnailFile;
    private String cameraName;
    private Images images;
    private FineDay lastFineDay;

    public Camera(String description, String thumbnailFile, String cameraName, Images images, FineDay lastFineDay) {
        this.description = description;
        this.thumbnailFile = thumbnailFile;
        this.cameraName = cameraName;
        this.images = images;
        this.lastFineDay = lastFineDay;
    }
}
