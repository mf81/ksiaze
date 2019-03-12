package eu.maciejfijalkowski.ksiaze.Model;

public class Model {

    private String name;
    private String account;
    private String nameWM;
    private String address;
    private String zipCity;
    private String index;
    private static Model ourInstance = new Model();

    public static Model getInstance() {
        return ourInstance;
    }

    private Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNameWM() {
        return nameWM;
    }

    public void setNameWM(String nameWM) {
        this.nameWM = nameWM;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCity() {
        return zipCity;
    }

    public void setZipCity(String zipCity) {
        this.zipCity = zipCity;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", nameWM='" + nameWM + '\'' +
                ", address='" + address + '\'' +
                ", zipCity='" + zipCity + '\'' +
                ", index='" + index + '\'' +
                '}';
    }
}
