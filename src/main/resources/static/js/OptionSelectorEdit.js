function OptionSelectorEdit(tr, objArray) {

    var nameOfCompany = tr.getElementsByTagName("td")[0].innerText;

    var array = typeof objArray != 'object' ? JSON.parse(objArray) : objArray;

    var str = '';
    for (var i = 0; i < array.length; i++) {                            //tr - строка, td - ячейка
        for (var index in array[i]) {
            if (array[i][index].match(nameOfCompany)) {
                str += '<option>' + array[i][index] + '</option>';
            }
        }
    }
    for (var i = 0; i < array.length; i++) {                            //tr - строка, td - ячейка
        for (var index in array[i]) {
            if (!array[i][index].match(nameOfCompany)) {
                str += '<option>' + array[i][index] + '</option>';
            }
        }
    }

    return str;
}