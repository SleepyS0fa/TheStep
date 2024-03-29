<#import "/utility/common.ftlh" as c>
<@c.page>
  <div class = 'container'>
    <h2>Вход</h2>
    <form method="POST" action="/new-user">
      <div class="form-row">
        <div class="form-group col-md-6">
          <input required type="email" class="form-control" id="email" name="email" placeholder="Почта">
        </div>
      </div>
      <div class="form-group col-md-6">
        <label for="password">Пароль</label>
        <input required type="password" class="form-control" id="password" name="password" placeholder="Пароль">
      </div>
      <div class="form-row">
      <a class="btn-primary" href="/registration">регистрация</a>
      <button type="submit" class="btn btn-primary">Войти</button>
      </div>
      <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
  </div>
  <!--TODO validation login form user-side-->
  <script src="/js/validForm/login.js"></script>
</@c.page>