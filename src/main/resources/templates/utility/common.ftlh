
<#macro page>
  <!DOCTYPE html>
  <html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel='icon' href='img/logo.png' type='image/png'>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <!-- Select2 -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/select2-bootstrap-5-theme@1.3.0/dist/select2-bootstrap-5-theme.min.css" />

        <title>Равные шансы</title>
    </head>
    <body>

      <nav class="p-2 navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/"> <img width="50" height="50" src="/img/logo.png">Равные шансы</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="/lecture">Лекции</a>
            </li>
            <li class="nav-item active">
              <a class="nav-link" href="/admin">Администраторская</a>
            </li>
          </ul>
        </div>
        <div class="navbar-nav ml-auto">
          <#if user??>
            <p>${user.username}</p>

            <a href="/me"><img class="rounded rounded-circle me-2" width="50" height="50" src="/img/account-icon.jpg"></a>
            <form class="form-inline my-2 my-lg-0" method="post" action="/logout">
              <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Выйти</button>
              <input type="hidden" name="_csrf" value="${_csrf.token}">
            </form>
          <#else>
            <form class="form-inline my-2 my-lg-0" method="post" action="/login">
              <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Войти</button>
              <input type="hidden" name="_csrf" value="${_csrf.token}">
            </form>
          </#if>
        </div>
      </nav>

      <#nested>

      <footer></footer>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </body>
    </html>
</#macro>