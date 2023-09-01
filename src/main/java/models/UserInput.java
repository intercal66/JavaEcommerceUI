package models;

import org.openqa.selenium.WebDriver;

public class UserInput {
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String password;
    private String passwordConfirm;
    private Boolean agreePrivacyPolicy;
    private Boolean newsletterSubscribe;
    private Boolean agreePrivacyTerms;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String postCode;
    private String country;
    private String regionState;

    public UserInput(WebDriver driver) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Boolean getAgreePrivacyPolicy() {
        return agreePrivacyPolicy;
    }

    public void setAgreePrivacyPolicy(Boolean agreePrivacyPolicy) {
        this.agreePrivacyPolicy = agreePrivacyPolicy;
    }

    public Boolean getNewsletterSubscribe() {
        return newsletterSubscribe;
    }

    public void setNewsletterSubscribe(Boolean newsletterSubscribe) {
        this.newsletterSubscribe = newsletterSubscribe;
    }

    public Boolean getAgreePrivacyTerms() {
        return agreePrivacyTerms;
    }

    public void setAgreePrivacyTerms(Boolean agreePrivacyTerms) {
        this.agreePrivacyTerms = agreePrivacyTerms;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegionState() {
        return regionState;
    }

    public void setRegionState(String regionState) {
        this.regionState = regionState;
    }
}
