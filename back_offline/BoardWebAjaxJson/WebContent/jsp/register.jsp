<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    String contextPath = request.getContextPath();
%>
<%-- 
Bootstrap 5
ajax with fetch
post with urlencoded
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- Bootstrap 5 버전 -->
    <!-- https://getbootstrap.com/docs/5.0/getting-started/introduction/ -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

    <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css"/>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css"/>
    <title>회원 가입</title>
</head>
<body>
    <div class="container">
        <div class="mb-3 mt-5 d-flex justify-content-center">
              <h1 class="display-4">하잉</h1>
        </div>
        <div class="mb-3">
            <h2>Register</h2>
        </div>
        <form novalidate>
            <div class="mb-3">
                <label for="userName">User Name:</label>
                <input type="text" class="form-control" id="userName" placeholder="Enter userName" name="userName" required>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Invalid.</div>
            </div>
            <div class="mb-3">
                <label for="userPassword">Password:</label>
                <input type="password" class="form-control" id="userPassword" placeholder="Enter password" name="userPassword" required>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">1개 이상의 특수문자, 대소문자 및 숫자를 포함하고 8자리 이상이여야 합니다.</div>
            </div>
            <div class="mb-3">
                <label for="userPassword2">Password Confirm:</label>
                <input type="password" class="form-control" id="userPassword2" placeholder="Confirm password" name="userPassword2" required>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="mb-3">
                <label for="userEmail">Email:</label>
                <input type="text" class="form-control" id="userEmail" placeholder="Enter email" name="userEmail" required>
                <div class="valid-feedback">Valid.</div>
                <div id="userEmailInvalidFeedback" class="invalid-feedback">Invalid.</div>
            </div>
        </form>
        <div>
            <button id="btnRegister" class="btn btn-primary">가입</button>
        </div>
    </div>

<script>
window.onload = function(){
    
    document.querySelector("#userName").focus();

    // manually check
    document.querySelector("#userName").onblur = function () {
        if (validateUserName( this.value )) {
            this.classList.remove("is-invalid");
            this.classList.add('is-valid');
        } else {
            this.classList.remove("is-valid");
            this.classList.add('is-invalid');
        }
    };

    document.querySelector("#userPassword").onblur = function () {
        if (validatePassword( this.value )) {
            this.classList.remove("is-invalid");
            this.classList.add('is-valid');
        } else {
            this.classList.remove("is-valid");
            this.classList.add('is-invalid');
        }
    };

    document.querySelector("#userPassword2").onblur = function () {
        if (validatePassword2( this.value )) {
            this.classList.remove("is-invalid");
            this.classList.add('is-valid');
        } else {
            this.classList.remove("is-valid");
            this.classList.add('is-invalid');
        }
    };

    document.querySelector("#userEmail").onblur = async function () { // async

        if ( validateEmail( this.value ) ) {
            
            let ret = await isEmailUnique();
            console.log( ret )
            if( ! ret ){
                this.classList.remove("is-valid");
                this.classList.add('is-invalid');
                document.querySelector("#userEmailInvalidFeedback").innerText = '이미 등록된 이메일입니다.';
                return;
            }
            
            // validate & unique
            this.classList.remove("is-invalid");
            this.classList.add('is-valid');
        } else {
            this.classList.remove("is-valid");
            this.classList.add('is-invalid');
        }
    };

     // email invalid feedback 초기화
    document.querySelector("#userEmail").onfocus = function (){
        document.querySelector("#userEmailInvalidFeedback").innerText = 'Invalid.'
    }
    
    document.querySelector('input').onfocus = function () {
        this.classList.remove('is-valid', 'is-invalid');
    };
    
    //submit
    document.querySelector("#btnRegister").onclick = function(){
        if( document.querySelectorAll("form .is-invalid").length > 0 ){
            alert("입력이 올바르지 않습니다.")
        }else{
            register();
        }
    };

}

// jQuery 버전과 비교해서 element 가 아니라 value 를 전달한다.
function validateUserName(userName) {

    if (userName.length >= 4) return true;
    else return false;
}

function validatePassword(userPassword) {

    let patternEngAtListOne = new RegExp(/[a-zA-Z]+/);// + for at least one
    let patternSpeAtListOne = new RegExp(/[~!@#$%^&*()_+|<>?:{}]+/);// + for at least one
    let patternNumAtListOne = new RegExp(/[0-9]+/);// + for at least one
    
    if( patternEngAtListOne.test( userPassword ) 
            && patternSpeAtListOne.test( userPassword )  
            && patternNumAtListOne.test( userPassword )
            && userPassword.length >= 8 ) return true;
    return false;
}

function validatePassword2(userPassword2) {
    if (userPassword2 == document.querySelector("#userPassword").value ) return true;
    return false;
}

function validateEmail(userEmail) {
    // ^ 시작일치, $ 끝 일치
    // {2, 3} 2개 ~ 3개
    // * 0회 이상, + 1회 이상
    // [-_.] - 또는 _ 또는 .
    // ? 없거나 1회
    let regexp = new RegExp(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i);
    if (regexp.test(userEmail)) return true;
    return false;
}

async function register() {
    
    let userName = document.querySelector("#userName").value;
    let userPassword = document.querySelector("#userPassword").value;    
    let userEmail = document.querySelector("#userEmail").value;    
    
    let urlParams = new URLSearchParams({
        userName: userName,
        userEmail: userEmail,
        userPassword: userPassword,
    });
    
    let fetchOptions = {
        method: "POST",
        body: urlParams,
    }
    
    let response = await fetch("<%=contextPath%>/user/register", fetchOptions);
    console.log(response);
    let data = await response.json();
    if( data.result == "success" ){
        alertify.alert('Welcome!', '회원가입을 축하합니다. 로그인 페이지로 이동합니다.', function(){
            window.location.href="<%= contextPath%>/jsp/login.jsp";
        });
    }else if( data.result == "fail" ){
        alert("서버 오류!!");
    }
}

async function isEmailUnique(){
    let userEmail = document.querySelector("#userEmail").value;
    let url = '<%=contextPath%>/user/isEmailUnique';
    let urlParams = '?userEmail=' + userEmail;
    let response = await fetch(url + urlParams);

    let data = await response.json();
    console.log(1)
    console.log(data);
    if( data.result == "success" ) return true;
    return false;
}
</script>
</body>
</html>