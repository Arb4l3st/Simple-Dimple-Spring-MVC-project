function companyModalEdit(tr) {
    var nameCompany = tr.getElementsByTagName("td")[0].innerText;
    var TinNumber = tr.getElementsByTagName("td")[1].innerText;
    var numberPhone = tr.getElementsByTagName("td")[2].innerText;
    var str = '<div class="form-group">\n' +
        '                                <label for="companyNameEdit">Название организации</label>\n' +
        '                                <textarea class="form-control" id="companyNameEdit" name="companyNameEdit" rows="1">'
        + nameCompany + '</textarea>\n' +
        '                            </div>\n' +
        '                            <div class="form-group">\n' +
        '                                <label for="tinEdit">ИНН Организации</label>\n' +
        '                                <input type="text" class="form-control" id="tinEdit" name="tinEdit" placeholder="10 цифр" pattern="[0-9]{10}" value="'
        + TinNumber +'" readonly>\n' +
        '                            </div>\n' +
        '                            <div class="form-group">\n' +
        '                                <label for="phoneNumberEdit">Номер телефона</label>\n' +
        '                                <input type="text" class="form-control" id="phoneNumberEdit" name="phoneNumberEdit" placeholder="###-##-##" pattern="[0-9]{3}-[0-9]{2}-[0-9]{2}" value="'
        + numberPhone + '">\n' +
        '                            </div>';

    return str;
}