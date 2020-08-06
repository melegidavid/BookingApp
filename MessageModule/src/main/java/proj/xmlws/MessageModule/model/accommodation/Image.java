package proj.xmlws.MessageModule.model.accommodation;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Transient
    private List<Byte> image;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Accommodation accommodation;

    public Image() {
    }

    public Image(String path) throws IOException {
        this.name = path;

        image = new ArrayList<Byte>();
        // open image
        File imgPath = new File(name);
        BufferedImage bufferedImage = ImageIO.read(imgPath);

        // get DataBufferBytes from Raster
        WritableRaster raster = bufferedImage.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

        byte[] temp = data.getData();
        for (byte b : temp) {
            image.add(b);
        }

    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Byte> getImage() {
        return image;
    }

    public void setImage(List<Byte> image) {
        this.image = image;
    }

}
