<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <!-- Select2 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/select2-bootstrap-5-theme@1.3.0/dist/select2-bootstrap-5-theme.min.css" />

    <title>Равные шансы</title>
  </head>
  <body>
    <div class = 'container'>
      <h2>Вход</h2>
      <#if error??>
        <div>
          Неверное имя пользователя или пароль
        </div>
      </#if>
      <#if logout??>
        <div>
          Вы вышли из аккаунта
        </div>
      </#if>
      <form method="post" action="/login">
        <div class="form-row">
          <div class="form-group col-md-6">
            <input required type="text" class="form-control" name="username" placeholder="Почта/Никнейм ">
          </div>
        </div>
        <div class="form-group col-md-6">
          <label for="password">Пароль</label>
          <input required type="password" class="form-control" id="password" name="password" placeholder="Пароль">
        </div>
        <div class="form-row p-2">
        <a class="btn-primary" href="/register">регистрация</a>
        <button type="submit" class="btn btn-primary">Войти</button>
        </div>
        <input type="hidden" id="_csrf" name="_csrf" value="${_csrf.token}">
      </form>
    </div>
    <!--TODO validation login form user-side-->
  </body>
</html>