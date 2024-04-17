<#import "/utility/common.ftlh" as c>
<@c.page>
  <div class = 'container'>
    <form method="POST" action="/register">
      <div class="form-row">
        <div class="form-group col-md-6">
          <input required type="email" class="form-control m-2" id="email" name="email" placeholder="Почта">
        </div>
        <div class="form-group col-md-6">
          <input required type="text" class="form-control m-2" id="username" name="username" placeholder="Никнейм">
        </div>
      </div>
      <div class="form-group col-md-6">
        <input required type="password" class="form-control m-2" id="password" name="password" placeholder="Пароль">
      </div>
      <div class="form-group col-md-6">
        <input required type="password" class="form-control m-2" id="passwordValid" placeholder="Повторите пароль">
      </div>
      <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
      <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
    <#if errorMessage??>
      <h2>${errorMessage}</h2>
    </#if>
  </div>

  <script src="/js/validForm/regist.js"></script>
</@c.page>