package ru.arbalest.request;

public class CompanyEditRequest {

    private String companyNameEdit;
    private String tinEdit;
    private String phoneNumberEdit;

    public String getCompanyNameEdit() {
        return companyNameEdit;
    }

    public void setCompanyNameEdit(String companyNameEdit) {
        this.companyNameEdit = companyNameEdit;
    }

    public String getTinEdit() {
        return tinEdit;
    }

    public void setTinEdit(String tinEdit) {
        this.tinEdit = tinEdit;
    }

    public String getPhoneNumberEdit() {
        return phoneNumberEdit;
    }

    public void setPhoneNumberEdit(String phoneNumberEdit) {
        this.phoneNumberEdit = phoneNumberEdit;
    }
}
