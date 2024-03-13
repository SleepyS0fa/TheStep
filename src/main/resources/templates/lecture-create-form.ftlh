<#import "macro/common.ftlh" as c>
<@c.page>
<h1>Создать лекцию</h1>
<div class = 'container'>
  <form class='row' on method='post' action='/lecture/create'>
    <div class='m-2'>
      <label for='title' class='form-label'>Тема лекции</label>
      <input required type='text' class='form-control' id='title' name='title'>
    </div>
    <div class='m-2'>
      <label for='author' class='form-label'>Автор</label>
      <input required type='text' class='form-control' id='author' name='author'>
      <input type='hidden' class='form-control' id='groups' name='groups'>
    </div>
      <section class="editor__section">
        <textarea name='text' class="border rounded editor editor" id="editor"></textarea>
      </section>
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

    <button type='submitbtn' class='btn btn-primary m-3'>Сохранить</button>
  </form>
</div>
<script src="https://cdn.tiny.cloud/1/5b3toniyg7rdg6lkxnzmznhsru5bwxpzcqaal3chk9z3f53v/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
<script src='/js/editor.js'></script>
<script src='/js/form.js'></script>
</@c.page>