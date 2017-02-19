package objects;

/**
 * Created by Asia on 19.02.2017.
 */
public class User {

    private String firstName;
    private String lastName;
    private String gmailAddress;
    private String password;
    private String passwordAgain;
    private String day;
    private String month;
    private String year;
    private String gender;
    private String phone;
    private String email;

    public User(String firstName, String lastName, String gmailAddress, String password, String passwordAgain,
                String day, String month, String year, String gender, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gmailAddress = gmailAddress;
        this.password = password;
        this.passwordAgain = passwordAgain;
        this.day = day;
        this.month = month;
        this.year = year;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGmailAddress() {
        return gmailAddress;
    }

    public void setGmailAddress(String gmailAddress) {
        this.gmailAddress = gmailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
