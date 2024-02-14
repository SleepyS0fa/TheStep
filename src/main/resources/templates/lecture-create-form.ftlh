<#import "macro/common.ftlh" as c>
<@c.page>
<h1>Создать лекцию</h1>
<div class = 'container'>
  <form class='row' method='post' action='/lecture/create'>
    <div class='m-2'>
      <label for='title' class='form-label'>Тема лекции</label>
      <input type='text' class='form-control' id='title' name='title'>
    </div>
    <div class='m-2'>
      <label for='author' class='form-label'>Автор</label>
      <input type='text' class='form-control' id='author' name='author'>
      <input type='hidden' class='form-control' id='groups' name='groups'>
    </div>
    <div class='m-2'>
      <textarea class='form-control' rows='5' placeholder='Текст лекции' name='text'></textarea>
    </div>
    <div class='row p-2 m-2 border rounded'>
      <div class='col' id='terms'>
        <label for='termText' class='form-label'>Термин</label>
        <input type='text' class='form-control' id='termText' name='terms'>
      </div>
      <div class='col' id=def>
        <label for='defText' class='form-label'>Определение</label>
        <input type='text' class='form-control' id='defText' name='def'>
      </div>
      <div class='row'>
        <div class='col-6'>
          <input type='button' id='morebtn' class='btn btn-secondary mt-2'value='+'></button>
          <input type='button' id='lessbtn' class='btn btn-secondary mt-2' value='–'></button>
        </div>
      </div>
    </div>

    <button type='submit' class='btn btn-primary m-3'>Сохранить</button>
  </form>
</div>
<script src='/js/form.js' ></script>
</@c.page>