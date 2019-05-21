function OptionSelector(objArray) {

    var array = typeof objArray != 'object' ? JSON.parse(objArray) : objArray;

    var str = '';
    for (var i = 0; i < array.length; i++) {                            //tr - строка, td - ячейка
        for (var index in array[i]) {
            str += '<option>' + array[i][index] + '</option>';
        }
    }

    return str;
}