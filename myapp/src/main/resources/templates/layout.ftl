<#macro layout title>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
    <#include "header.ftl">
    
    <div class="content">
        <#nested>
    </div>
    
    <#include "footer.ftl">
</body>
</html>
</#macro>
