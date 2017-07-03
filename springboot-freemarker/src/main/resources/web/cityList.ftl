<!DOCTYPE html>

<html lang="en">

<body>
<#list cityList as city>

City: ${city.cityName}! <br>
Q:Which Province? <br>
A:${city.province}! <br>
Q:Why I like? <br>
A:${city.description}! <br><br>
</#list>
</body>

</html>