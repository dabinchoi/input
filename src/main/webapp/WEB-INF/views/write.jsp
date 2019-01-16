<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Fonts -->
    <link rel="dns-prefetch" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <title>글쓰기</title>
    <style>
        .my-form {
            margin-top:20px;
        }
    </style>
</head>
<body>
<main class="my-form">
    <div class="container">
        <div class="row justify-content-center" >
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">글쓰기</div>

                    <div class="card-body">

                        <div class="card-body-center">
                            <form name="my-form" action="/write" method="post">
                                <div class="form-group row">
                                    <label for="user_name" class="col-md-2 col-form-label text-md-right">이름</label>
                                    <div class="col-md-9">
                                        <input type="text" id="user_name" class="form-control" name="user_name">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="user_id" class="col-md-2 col-form-label text-md-right">id</label>
                                    <div class="col-md-9">
                                        <input type="text" id="user_id" class="form-control"name = "user_id">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="title" class="col-md-2 col-form-label text-md-right" >제목</label>
                                    <div class="col-md-9">
                                        <input type="text" id="title" class="form-control" name="title">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="content" class="col-md-2 col-form-label text-md-right"name = "content">내용</label>
                                    <textarea class="col-md-9" id="content" rows="8" name = "content"></textarea>
                                </div>


                                <div class = "d-flex flex-row-reverse">
                                    <div class = "d-flex flex-row-reverse">



                                        <div class="p-2">
                                            <button type="botton" class="btn btn-primary" onClick="location.href='/list2'">
                                                등록
                                            </button>
                                            <input type="submit" class="btn btn-default" value="등록"/>
                                        </div>

                                        <div class="p-2">
                                            <a href = "/board/list"> <button type="button" class="btn btn-primary">
                                                목록
                                            </button></a>
                                        </div>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>



                </div>
                </form>
            </div>
        </div>
    </div>
    </div>
    </div>

</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>