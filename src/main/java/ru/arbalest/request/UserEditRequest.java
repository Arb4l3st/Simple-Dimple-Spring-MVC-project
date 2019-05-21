package ru.arbalest.request;

public class UserEditRequest {

    private String fioUserEdit;
    private String dateREdit;
    private String emailEdit;
    private String companyNameUserEdit;
    private int idNotEdit;

    public String getFioUserEdit() {
        return fioUserEdit;
    }

    public void setFioUserEdit(String fioUserEdit) {
        this.fioUserEdit = fioUserEdit;
    }

    public String getDateREdit() {
        return dateREdit;
    }

    public void setDateREdit(String dateREdit) {
        this.dateREdit = dateREdit;
    }

    public String getEmailEdit() {
        return emailEdit;
    }

    public void setEmailEdit(String emailEdit) {
        this.emailEdit = emailEdit;
    }

    public String getCompanyNameUserEdit() {
        return companyNameUserEdit;
    }

    public void setCompanyNameUserEdit(String companyNameUserEdit) {
        this.companyNameUserEdit = companyNameUserEdit;
    }

    public int getIdNotEdit() {
        return idNotEdit;
    }

    public void setIdNotEdit(int idNotEdit) {
        this.idNotEdit = idNotEdit;
    }
}
