<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hello World</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <style>
        #keyword {
            display:inline-table;
        }
        @media (max-width: 768px)  {
            #keyword {
                display:block;
            }
        }

    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h4>게시판</h4>
            <div class="table-responsive">
                <table id="mytable" class="table table-bordered table-hover col-sm-12">
                    <thead>
                    <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>글쓴이</th>
                    <th>등록일</th>
                    </tr>
                    </thead>
                    <tbody>



                    <tr>
                        <c:forEach items="${requestScope.list}" var="board">


                        <td class = board>${board.number}</td>
                            <td><a href = "/board/view">${board.title}</a></td>
                        <td>${board.name}</td>
                            <td>${board.regdate}</td></td>
                    </tr>
                        </c:forEach>



                    </tbody>
                </table>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div>
        <form class="form-inline" action="#" method="get">
            <select class="form-control" id="inlineFormInput">
                <option value="all">전체</option>
                <option value="subject">제목</option>
                <option value="content">내용</option>


            </select>

            <label class="sr-only" for="inlineFormInputGroup">Username</label>
            <div id="keyword" class="input-group">
                <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="search...">
            </div>
            <button type="submit" class="btn btn-primary">검색</button>
            <a href = "/board/write"><button type = "button" class="btn btn-write" >글쓰기</button></a>

        </form>

    </div>
</div>

    <!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
</div>
<!-- /.modal-dialog -->
</div>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</body>


</html>