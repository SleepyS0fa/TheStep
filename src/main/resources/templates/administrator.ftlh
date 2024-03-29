<#import "../utility/common.ftlh" as c>
<@c.page>
  <div class='container'>
    <div class='row m-2'>
     <p>Группы</p>
     <form class='m-2' method='POST' action='/create/group/'>
      <input type='text' class='form-control' id='name' name='name'></input>
      <button type='submit' class='btn btn-primary mt-2'>Создать группу</button>
     </form>
    </div>
    <div class='row m-2'>
      <p>Студенты</p>

    </div>
    <div class='row m-2'>
      <p>Еще..</p>

    </div>
  </div>
</@c.page>