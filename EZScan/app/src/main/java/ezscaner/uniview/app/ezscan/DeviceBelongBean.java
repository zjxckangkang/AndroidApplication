package ezscaner.uniview.app.ezscan;

import java.security.PrivateKey;

/**
 * Created by kangkang on 16/6/3.
 */
public class DeviceBelongBean {
    private String sn;
    private String location;
    private String owner;

    public DeviceBelongBean(String sn, String location, String owner) {
        this.sn = sn;
        this.location = location;
        this.owner = owner;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
