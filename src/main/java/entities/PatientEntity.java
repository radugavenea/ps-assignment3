package entities;

import java.sql.Date;

/**
 * Created by radu on 05.05.2017.
 */
public class PatientEntity {

    private int id;
    private String name;
    private String cardNumber;
    private String numericalCode;
    private Date birthday;
    private String address;

    public PatientEntity(int id, String name, String cardNumber, String numericalCode, Date birthday, String address) {
        this.id = id;
        this.name = name;
        this.cardNumber = cardNumber;
        this.numericalCode = numericalCode;
        this.birthday = birthday;
        this.address = address;
    }

    public PatientEntity(String name, String cardNumber, String numericalCode, Date birthday, String address) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.numericalCode = numericalCode;
        this.birthday = birthday;
        this.address = address;
    }

    public PatientEntity(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNumericalCode() {
        return numericalCode;
    }

    public void setNumericalCode(String numericalCode) {
        this.numericalCode = numericalCode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
