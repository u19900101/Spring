<%@ page contentType="text/html;charset=utf-8"%>
<html>
<body>
<h2><a href="hello" />Hello World!</h2>

<h2><a href="h2"></a>H2</h2>
<h2><a href="h5"></a>H5</h2>
<h2><a href="h3"></a>请求参数</h2>
<form action="h2" method="post">
    <input type="submit" value="H2"/>
</form>

<form action="book" method="post">
    <input type="hidden" name="id" value="1000"/>
    书 名： 西游记
    作 者： <input type="text" name="author"/><br/>
    价 格： <input type="text" name="price"/><br/>
    库 存： <input type="text" name="stock"/><br/>
    销 量： <input type="text" name="sales"/><br/>
    省： <input type="text" name="address.prov"/><br/>
    市： <input type="text" name="address.city"/><br/>
    街 道： <input type="text" name="address.street"/><br/>
    <input type="submit" value="添加图书"/>
</form>
</body>
</html>
