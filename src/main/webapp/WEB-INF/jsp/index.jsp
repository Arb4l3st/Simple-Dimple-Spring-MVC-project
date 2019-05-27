<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Companies and Workers</title>
    <script src="/js/TableView.js" type="text/javascript"></script>
    <script src="/js/OptionSelector.js" type="text/javascript"></script>
    <script src="/js/OptionSelectorEdit.js" type="text/javascript"></script>
    <script src="/js/companyModalEdit.js" type="text/javascript"></script>
    <script src="/js/userModalEdit.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <link href="/css/main.css" rel="stylesheet" type="text/css"/>
</head>

<body >
<div class="container-fluid">
    <div class="row container-fluid">
        <h1 class="display-4" style="font-size: 2rem">Companies and Workers</h1>
    </div>
    <div class="row">
        <div class="col-2">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary btn-block" data-toggle="modal" id="buttonModal">
                Создать
            </button>
            <div style="padding-top: 10px"></div>
            <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                <a class="nav-link active" id="companyButton" data-toggle="pill" href="#v-pills-company" role="tab" aria-controls="v-pills-home" aria-selected="true">Компании</a>
                <a class="nav-link" id="userButton" data-toggle="pill" href="#v-pills-user" role="tab" aria-controls="v-pills-profile" aria-selected="false">Участники</a>
            </div>
        </div>
        <div class="col">
            <div class="tab-content" id="v-pills-tabContent">
                <div class="tab-pane fade show active" id="v-pills-company" role="tabpanel" aria-labelledby="v-pills-home-tab">
                    <div id="v-pills-company-content">
                    </div>
                </div>
                <div class="tab-pane fade" id="v-pills-user" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                        <form method="post">
                            <button type="button" class="btn btn-primary filter-button" data-toggle="modal" data-target="#filterModal" id="filterUserButton" name="filterUserButton">
                                Фильтр
                            </button>
                            <button type="submit" class="btn btn-dark filter-button" id="undoFilterUsers" name="undoFilterUsers">
                                Сброс
                            </button>
                        </form>
                        <div style="padding-top: 10px"></div>
                        <div id="v-pills-user-content">
                        </div>
                </div>
            </div>
        </div>
        <!-- Modal for companies -->
        <div class="modal fade" id="companiesModal" tabindex="-1" role="dialog" aria-labelledby="companiesModal" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="companiesModalLabel">Создание организации</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post">
                            <div class="form-group">
                                <label for="companyName">Название организации</label>
                                <textarea class="form-control" id="companyName" name="companyName" rows="1"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="tin">ИНН Организации</label>
                                <input type="text" class="form-control" id="tin" name="tin" placeholder="10 цифр" pattern="[0-9]{10}">
                            </div>
                            <div class="form-group">
                                <label for="phoneNumber">Номер телефона</label>
                                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="###-##-##" pattern="[0-9]{3}-[0-9]{2}-[0-9]{2}">
                            </div>
                            <div class="button-footer">
                                <button type="submit" class="btn btn-primary" id="companyPostButton">Создать</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal for users -->
        <div class="modal fade" id="usersModal" tabindex="-1" role="dialog" aria-labelledby="usersModal" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="usersModalLabel">Создание работника</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post">
                            <div class="form-group">
                                <label for="fioUser">ФИО работника</label>
                                <input type="text" class="form-control" name = "fioUser" id="fioUser" placeholder="Иванов Иван Иванович">
                            </div>
                            <div class="form-group">
                                <label for="dateR">Дата Рождения</label>
                                <input type="text" class="form-control" name = "dateR" id="dateR"  placeholder="ДД-ММ-ГГГГ" pattern="[0-3]{1}[0-9]{1}-[0-1]{1}[0-9]{1}-[1-2]{1}[0-9]{3}">
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" name = "email" id="email"  placeholder="employee@company.com">
                            </div>
                            <div class="form-group">
                                <label for="companySelector">Компания</label>
                                <select class="form-control" id="companySelector" name="companyNameUser">
                                </select>
                            </div>
                            <div class="button-footer">
                                <button type="submit" class="btn btn-primary" id="userPostButton">Создать</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal for edit/delete -->
        <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="usersModal" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="editModalLable"></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post" id="editTableModal">
                            <div id="body-content">
                            </div>
                            <div class="button-footer">
                                <button type="submit" class="btn btn-primary" id="editPostButton" name="save">Сохранить</button>
                                <button type="submit" class="btn btn-primary" id="deleteButton" name="delete">Удалить</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal for filter in users -->
        <div class="modal fade" id="filterModal" tabindex="-1" role="dialog" aria-labelledby="usersModal" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="filterModalLable">Фильтр по работникам</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post">
                            <label for="optionalSelectorFilter">Компания:</label>
                            <select class="form-control" id="optionalSelectorFilter" name="companyNameUser">
                            </select>
                            <div class="button-footer">
                                <button type="submit" class="btn btn-primary" id="filterUser" name="filterUser">Применить</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    var variable = 1;
    var companyNameArr = { "d": ${companyNamesArray}};
    var companyArr = { "d": ${companyArray}};
    var userArr = { "d": ${userArray}};
    $(function() {
        $('#companySelector').html(OptionSelector(companyNameArr.d));
        $('#optionalSelectorFilter').html(OptionSelector(companyNameArr.d));
    });

    $(function() {
        if (companyArr.d.length > 0){
            $('#v-pills-company-content').html(TableView(companyArr.d, "table table-hover", true))
        }
        else{
            $('#v-pills-company-content').html("<h1 class=\"display-4\" style=\"font-size: 2rem\">Здесь пока ничего не создано.</h5>");
        }
        if (userArr.d.length > 0){
            $('#v-pills-user-content').html(TableView(userArr.d, "table table-hover", true));
        }
        else{
            $('#v-pills-user-content').html("<h1 class=\"display-4\" style=\"font-size: 2rem\">Здесь пока ничего не создано.</h5>");
        }
    });

    $(function() {
        $('#companyButton').click(function() {
            variable = 1;
        })
        $('#userButton').click(function() {
            variable = 0;
        })
    });

    $(function(){
        $('#buttonModal').click(function(){
            if (variable == 1) {
                $('#buttonModal').attr("data-target","#companiesModal");
            }
            else {
                $('#buttonModal').attr("data-target","#usersModal");
            }
        });
    });

    function showModal(tr) {
        $('#editModal').modal('show');
        if (variable == 1) {
            $('#editModalLable').html('Редактировать организацию');
            $('#body-content').html(companyModalEdit(tr));
        }
        else if (variable == 0) {
            $('#editModalLable').html('Редактировать работника');
            $('#body-content').html(userModalEdit(tr));
            $('#CompanySelectorEdit').html(OptionSelectorEdit(tr, companyNameArr.d));
        }
    }
</script>
</html>