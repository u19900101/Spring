package ppppp.pojo;

/**
 * @author lppppp
 * @create 2021-01-19 21:34
 */
public class Address {
    private String prov;
    private String city;
    private String street;

    public Address(String prov, String city, String street) {
        this.prov = prov;
        this.city = city;
        this.street = street;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "prov='" + prov + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
