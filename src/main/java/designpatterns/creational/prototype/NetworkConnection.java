package designpatterns.creational.prototype;

public class NetworkConnection implements Cloneable{

    public String ip;
    public String importantData;

    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getImportantData() {
        return importantData;
    }
    public void setImportantData(String importantData) {
        this.importantData = importantData;
    }

    public void loadVeryImportantData() {
        this.importantData = "Very Very Important Data";
    }

    @Override
    public String toString() {
        return "NetworkConnection{" +
                "ip='" + ip + '\'' +
                ", importantData='" + importantData + '\'' +
                '}';
    }


    @Override
    public NetworkConnection clone() {
        try {
            NetworkConnection clone = (NetworkConnection) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
