<#import "/utility/common.ftlh" as c>
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
    </div>
    <div class='m-2'>
      <label for='groups' class='form-label'>Группы</label>


      <select multiple id="groups" name="groups" class='form-select'>
        <#list groups as group>
          <option value='${group.id}'>${group.name}</option>
        </#list>
      </select>
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
  <a class='btn btn-primary' href='/lecture'>Назад</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.full.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/i18n/ru.js"></script>
<script src="https://cdn.tiny.cloud/1/5b3toniyg7rdg6lkxnzmznhsru5bwxpzcqaal3chk9z3f53v/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
<script src='/js/editor.js'></script>
<script src='/js/form.js'></script>
<script>
$( '#groups' ).select2( {
    language: "ru",
    theme: "bootstrap-5",
    width: $( this ).data( 'width' ) ? $( this ).data( 'width' ) : $( this ).hasClass( 'w-100' ) ? '100%' : 'style',
    placeholder: $( this ).data( 'placeholder' ),
    closeOnSelect: true,
} );
</script>
</@c.page>