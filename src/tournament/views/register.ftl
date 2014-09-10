<html>
    <head>
        <title>Register</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script>
            $(document).ready(function(){
                $("button").click(function(){
                    $.post("/register", {name:$("#name").text()},function(data,status){alert("Data: " + data + "\nStatus: " + status);});
                    window.location.replace("/contestant?id="+$("#name").text());
                });
            });
        </script>
    </head>
    <body>
        name: <input type="text" id="name"><br>
        <button>Register</button>
    </body>
</html>