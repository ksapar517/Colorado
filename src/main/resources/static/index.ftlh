<#import "blocks/template.ftlh" as t>
<@t.template user>

<h1>Добро пожаловать!</h1>
<!-- Button to create a new item -->
<form action="/admin/create" method="get">
    <button type="submit">+ Создать продавец</button>
</form>

<form action="/admin/createProduct" method="get">
    <button type="submit">+ Создать товар</button>
</form>
<form action="/user/all" method="get">
    <button type="submit">товари</button>
</form>

</@t.template>

