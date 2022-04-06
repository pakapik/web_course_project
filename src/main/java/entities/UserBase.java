package entities;

import annotattions.FrontDisplay;
import annotattions.InputType;
import annotattions.SetterOptions;
import jakarta.persistence.*;
import utils.ParseType;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "userbase")
public class UserBase implements IEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", unique = true, nullable = false, length = 30)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "nickname", unique = true, nullable = false, length = 20)
    private String nickname;

    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    @Column(name = "educational_institute", length = 100)
    private String educationalInstitute;

    @Column(name = "card_details", length = 100)
    private String cardDetails;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @FrontDisplay(name = "Fullname",
            inputType = InputType.Text,
            orderPlace = 1,
            dataType = String.class)
    public String getFullName() {
        return fullName;
    }

    @SetterOptions(name = "Fullname", parseType = ParseType.String)
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @FrontDisplay(name = "Nickname",
            inputType = InputType.Text,
            orderPlace = 2,
            dataType = String.class)
    public String getNickname() {
        return nickname;
    }

    @SetterOptions(name = "Nickname", parseType = ParseType.String)
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @FrontDisplay(name = "Email",
            inputType = InputType.Email,
            orderPlace = 3,
            dataType = String.class)
    public String getEmail() {
        return email;
    }

    @SetterOptions(name = "Email", parseType = ParseType.String)
    public void setEmail(String email) {
        this.email = email;
    }

    @FrontDisplay(name = "Password",
            inputType = InputType.Password,
            orderPlace = 4,
            dataType = String.class)
    public String getPassword() {
        return password;
    }

    @SetterOptions(name = "Password", parseType = ParseType.String)
    public void setPassword(String password) throws NoSuchAlgorithmException {
        var md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        var data = md.digest();
        var sb = new StringBuilder();
        for (var byteOfData : data) {
            sb.append(Integer.toString((byteOfData & 0xff) + 0x100, 16).substring(1));
        }
        this.password = sb.toString();
    }

    @FrontDisplay(name = "Registration date",
            inputType = InputType.Date,
            orderPlace = 5,
            dataType = Date.class)
    public Date getRegistrationDate() {
        return registrationDate;
    }

    @SetterOptions(name = "Registration date", parseType = ParseType.SqlDate)
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @FrontDisplay(name = "Educational institute",
            inputType = InputType.Text,
            orderPlace = 6,
            dataType = String.class,
            isRequired = false)
    public String getEducationalInstitute() {
        return educationalInstitute;
    }

    @SetterOptions(name = "Educational institute", parseType = ParseType.String)
    public void setEducationalInstitute(String educationalInstitute) {
        this.educationalInstitute = educationalInstitute;
    }

    @FrontDisplay(name = "Card details",
            inputType = InputType.Text,
            orderPlace = 7,
            dataType = String.class,
            isRequired = false)
    public String getCardDetails() {
        return cardDetails;
    }

    @SetterOptions(name = "Card details", parseType = ParseType.String)
    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }

    @Override
    public String getDescription() {
        return nickname + ": " + fullName;
    }
}