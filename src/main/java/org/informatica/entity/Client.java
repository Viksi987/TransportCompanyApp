package org.informatica.entity;

public class Client {

    private int id;
    private String name;
    private String phone;
    private String email;
    private int companyId;

    public Client() {
    }

    public Client(String name, String phone, String email, int companyId) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.companyId = companyId;
    }

    public Client(int id, String name, String phone, String email, int companyId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.companyId = companyId;
    }

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

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
