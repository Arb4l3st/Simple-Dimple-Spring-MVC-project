package ru.arbalest.converter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.arbalest.models.Company;
import ru.arbalest.models.OneUser;

import java.util.List;

public class ConverterToJSON {

    public JSONArray getJSONArrayFromAllCompanies(List<Company> companyList) throws JSONException {
        JSONArray jsonArr = new JSONArray();

        for (int i = 0; i < companyList.size();i++){
            JSONObject jsonObj = new JSONObject();
            // первый параметр в jsonObj - название хедера в таблице
            jsonObj.put("ИНН", companyList.get(i).getTIN());
            jsonObj.put("Название Компании", companyList.get(i).getCompanyName());
            jsonObj.put("Номер Телефона", companyList.get(i).getPhoneNumber());
            jsonArr.put(jsonObj);
        }
        return jsonArr;
    }

    public JSONArray getJSONArrayFromAllUsers(List<OneUser> userList) throws JSONException {
        JSONArray jsonArr = new JSONArray();

        for (int i = 0; i < userList.size();i++){
            JSONObject jsonObj = new JSONObject();
            // первый параметр в jsonObj - название хедера в таблице
            jsonObj.put("ФИО", userList.get(i).getFio());
            jsonObj.put("Дата рождения", userList.get(i).getDateR());
            jsonObj.put("Название Компании", userList.get(i).getCompanyName());
            jsonObj.put("Email", userList.get(i).getEmail());
            jsonObj.put("ID", userList.get(i).getId());
            jsonArr.put(jsonObj);
        }
        return jsonArr;
    }
    public JSONArray getJSONNamesofCompanies(List<Company> companyList) throws JSONException {
        JSONArray jsonArr = new JSONArray();

        for (int i = 0; i < companyList.size();i++){
            JSONObject jsonObj = new JSONObject();
            // первый параметр в jsonObj - название хедера в таблице
            jsonObj.put("Название Компании", companyList.get(i).getCompanyName());
            jsonArr.put(jsonObj);
        }
        return jsonArr;
    }
}
