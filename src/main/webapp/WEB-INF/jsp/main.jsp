<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="/css/lib/bootstrap.min.css">
<title>main</title>
</head>
<body>
<h1>웹 서비스</h1>

    <div class="col-md-12">
        <button id="selPost" type="button" class="btn btn-primary">조회</button>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#savePostsModal">등록</button>
        <button id="modPost" type="button" class="btn btn-primary">수정</button>
        <button id="delPost" type="button" class="btn btn-primary">삭제</button>
        <br/>
        <br/>
        <!-- 목록 출력 영역 -->
        <table class="table table-horizontal table-bordered">
            <thead class="thead-strong">
            <colcolgroup>
            	<col width="5%"/>
            	<col width="10%"/>
            	<col width="20%"/>
            	<col width="40%"/>
            	<col width="10%"/>
            	<col width="15%"/>
            </colcolgroup>
                <tr>
                    <th><input type="checkbox" id="allCheck"></th>
                    <th>게시글번호</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성자</th>
                    <th>최종수정일</th>
                </tr>
            </thead>
            <tbody id="tbody">
            <c:if test="${posts != null}">
            <c:forEach var="list" items="${posts}" varStatus="status">
            	<tr>
            		<td><input type="checkbox" name="checkBox" value="${list.id}"/></td>
            		<td>${list.id} </td>
            		<td>${list.title}  </td>
            		<td>${list.content} </td>
            		<td>${list.author}  </td>
            		<td>${list.modifiedDate} </td>
				</tr>
			</c:forEach>            
            </c:if>
            </tbody>
        </table>
    </div>

    <!-- Modal 영역 -->
    <div class="modal fade" id="savePostsModal" tabindex="-1" role="dialog" aria-labelledby="savePostsLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="savePostsLabel">게시글 등록</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <label for="title">제목</label>
                            <input type="text" class="form-control" id="title" placeholder="제목을 입력하세요">
                        </div>
                        <div class="form-group">
                            <label for="author">작성자</label>
                            <input type="text" class="form-control" id="author" placeholder="작성자를 입력하세요">
                        </div>
                        <div class="form-group">
                            <label for="content">내용</label>
                            <textarea class="form-control" id="content" placeholder="내용을 입력하세요"></textarea>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                    <button type="button" class="btn btn-primary" id="btn-save">등록</button>
                </div>
            </div>
        </div>
    </div>

    <!--부트스트랩 js, jquery 추가-->
    <script src="/js/lib/jquery.min.js"></script>
    <script src="/js/lib/bootstrap.min.js"></script>
    <!--custom js 추가-->
    <script src="/js/app/main.js"></script>
</body>
</html>