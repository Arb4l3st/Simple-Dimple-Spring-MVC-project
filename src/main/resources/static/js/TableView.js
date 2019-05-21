function TableView(objArray, theme,needHeader) {

    // needHeader = true;

    var array = typeof objArray != 'object' ? JSON.parse(objArray) : objArray;
    var str = '<table class="' + theme + '">';

    // create table head if needHeader is true
    if (needHeader) {
        str += '<thead class="thead-dark"><tr>';
        for (var index in array[0]) {
            str += '<th scope="col">' + index + '</th>';
        }
        str += '</tr></thead>';
    }

    // table body
    var mark = 0;
    str += '<tbody id="tableView">';
    for (var i = 0; i < array.length; i++) {
        mark=0;
        //tr - строка, td - ячейка
        str += '<tr ondblclick="showModal(this)" id="';
        for (var index in array[i]) {
            if (mark == 0){
                str += array[i]["ИНН"]  +'">';
                mark = 1;
            }
                str += '<td>' + array[i][index] + '</td>';

        }
        str += '</tr>';
    }
    str += '</tbody>'
    str += '</table>';
    return str;
}