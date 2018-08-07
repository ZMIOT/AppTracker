package bean;

import android.net.Uri;

public class HwItem {
    private Uri uri;
    private String troubleName;
    private Uri img;

    public HwItem(){}
    public HwItem(Uri uri, String troubleName, Uri img) {
        this.uri = uri;
        this.troubleName = troubleName;
        this.img = img;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public String getTroubleName() {
        return troubleName;
    }

    public void setTroubleName(String troubleName) {
        this.troubleName = troubleName;
    }

    public Uri getImg() {
        return img;
    }

    public void setImg(Uri img) {
        this.img = img;
    }
}
