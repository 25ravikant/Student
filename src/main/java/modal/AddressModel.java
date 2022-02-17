package modal;

public class AddressModel {

    private String email;
    private String phone;
    private String street;
    private String pin;
    private String city;

    public AddressModel() {
    }

    public AddressModel(String email, String phone, String street, String pin, String city) {
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.pin = pin;
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressModel{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", street='" + street + '\'' +
                ", pin='" + pin + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
