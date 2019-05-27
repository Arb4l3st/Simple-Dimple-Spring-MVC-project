package ru.arbalest.controllers;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.arbalest.converter.ConverterToJSON;
import ru.arbalest.request.CompanyEditRequest;
import ru.arbalest.request.CompanyRequest;
import ru.arbalest.request.UserEditRequest;
import ru.arbalest.request.UserRequest;
import ru.arbalest.services.CompanyService;
import ru.arbalest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/index")
public class MapController {

    private final CompanyService companyService;
    private final UserService userService;
    private ConverterToJSON converterToJSON = new ConverterToJSON();

    @Autowired
    public MapController(CompanyService companyService,UserService userService) {
        this.companyService = companyService;
        this.userService = userService;
    }

    @ModelAttribute
    public void setAttributes(Model model) throws JSONException {
        JSONArray companyArray = converterToJSON.getJSONArrayFromAllCompanies(companyService.getAllCompanies());
        JSONArray companyArrayNames = converterToJSON.getJSONNamesofCompanies(companyService.getAllCompanies());
        JSONArray userArray = converterToJSON.getJSONArrayFromAllUsers(userService.getAllUsers());
        model.addAttribute("companyArray", companyArray);
        model.addAttribute("userArray", userArray);
        model.addAttribute("companyNamesArray", companyArrayNames);
    }

    @GetMapping
    public Model printIndexDefault(Model model){
        return model;
    }

    @PostMapping
    public ModelAndView createProfile(
            ModelAndView modelAndView,
            Model model,
            @ModelAttribute CompanyRequest companyRequest,
            @ModelAttribute UserRequest userRequest
    ) throws JSONException {
        if (userRequest.getFioUser() != null) {
            userRequest.setId(userService.getAllUsers().size() + 1);
            userService.insertUser(
                    userRequest.getFioUser(),
                    userRequest.getDateR(),
                    userRequest.getEmail(),
                    userRequest.getCompanyNameUser(),
                    userRequest.getId()
            );
        }
        if (companyRequest.getTin() != null) {
            companyService.insertCompany(
                    companyRequest.getCompanyName(),
                    companyRequest.getPhoneNumber(),
                    companyRequest.getTin()
            );
        }
        redirectAndRefresh(modelAndView);
        this.setAttributes(model);
        return modelAndView;
    }

    @PostMapping(params = "delete")
    public ModelAndView deleteProfile(
            ModelAndView modelAndView,
            Model model,
            @ModelAttribute CompanyEditRequest companyEditRequest,
            @ModelAttribute UserEditRequest userEditRequest
    ) throws JSONException {
        if (companyEditRequest.getTinEdit() != null) {
            companyService.deleteCompany(
                    companyEditRequest.getTinEdit()
            );
        }
        if (userEditRequest.getFioUserEdit() != null) {
            userService.deleteUserById(
                    userEditRequest.getIdNotEdit()
            );
        }
        redirectAndRefresh(modelAndView);
        this.setAttributes(model);
        return modelAndView;
    }

    @PostMapping(params = "save")
    public ModelAndView updateProfile(
            ModelAndView modelAndView,
            Model model,
            @ModelAttribute CompanyEditRequest companyEditRequest,
            @ModelAttribute UserEditRequest userEditRequest
    ) throws JSONException {
        if (companyEditRequest.getTinEdit() != null) {
            companyService.updateCompany(
                    companyEditRequest.getCompanyNameEdit(),
                    companyEditRequest.getPhoneNumberEdit(),
                    companyEditRequest.getTinEdit()
            );
        }
        if (userEditRequest.getFioUserEdit() != null) {
            userService.updateUser(
                    userEditRequest.getFioUserEdit(),
                    userEditRequest.getDateREdit(),
                    userEditRequest.getEmailEdit(),
                    userEditRequest.getCompanyNameUserEdit(),
                    userEditRequest.getIdNotEdit()
            );
        }
        redirectAndRefresh(modelAndView);
        this.setAttributes(model);
        return modelAndView;
    }

    @PostMapping(params = "filterUser")
    public Model setFilter(
            ModelAndView modelAndView,
            Model model,
            @ModelAttribute UserRequest userRequest
    ) throws JSONException {
        JSONArray userArrayUPD = converterToJSON.getJSONArrayFromAllUsers(userService.getUsersByCompany(userRequest.getCompanyNameUser()));
        model.addAttribute("userArray", userArrayUPD);
        redirectAndRefresh(modelAndView);
        return model;
    }

    @PostMapping(params = "undoFilterUsers")
    public ModelAndView undoFilter(
            ModelAndView modelAndView,
            Model model
    ) throws JSONException {
        redirectAndRefresh(modelAndView);
        this.setAttributes(model);
        return modelAndView;
    }

    private void redirectAndRefresh(
            ModelAndView modelAndView
    ){
        //Перенаправление на GET метод
        RedirectView redirectView = new RedirectView("index");
        redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        modelAndView.setView(redirectView);
    }

}