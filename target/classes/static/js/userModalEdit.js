function userModalEdit(tr) {
    var emailEdit = tr.getElementsByTagName("td")[1].innerText;
    var fioEdit = tr.getElementsByTagName("td")[2].innerText;
    var idNotEdit = tr.getElementsByTagName("td")[3].innerText;
    var dateREdit = tr.getElementsByTagName("td")[4].innerText;

    var str = '<div class="form-group">\n' +
        '                                <label for="fioUserEdit">ФИО работника</label>\n' +
        '                                <input type="text" class="form-control" name = "fioUserEdit" id="fioUserEdit" placeholder="Иванов Иван Иванович" value="'
        + fioEdit + '">\n' +
        '                            </div>\n' +
        '                            <div class="form-group">\n' +
        '                                <label for="dateREdit">Дата Рождения</label>\n' +
        '                                <input type="text" class="form-control" name = "dateREdit" id="dateREdit"  placeholder="ДД-ММ-ГГГГ" pattern="[0-3]{1}[0-9]{1}-[0-1]{1}[0-9]{1}-[1-2]{1}[0-9]{3}" value="'
        + dateREdit + '">\n' +
        '                            </div>\n' +
        '                            <div class="form-group">\n' +
        '                                <label for="emailEdit">Email</label>\n' +
        '                                <input type="email" class="form-control" name = "emailEdit" id="emailEdit"  placeholder="employee@company.com"  value="'
        + emailEdit + '">\n' +
        '                            </div>\n' +
        '                            <div class="form-group">\n' +
        '                                <label for="CompanySelectorEdit">Компания</label>\n' +
        '                                <select class="form-control" id="CompanySelectorEdit" name="companyNameUserEdit" >\n' +
        '                                </select>\n' +
        '                            </div>' +
        '<div style="display: none">\n' +
        '<input type="text" name="idNotEdit" value="'+ idNotEdit + '" readonly>\n' +
        '</div>';
    return str;
}