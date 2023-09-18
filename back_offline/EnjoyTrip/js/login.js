
var isLogin = false;
document.addEventListener("DOMContentLoaded", update);
// document.getElementById("submitButton").addEventListener("click", function(){
//   // alert(1);
  
//   let comment = document.querySelector("#commnet-comment");
//   comment.innerHTML += 
//   ' <li class="comment"> ' +
//       '<div class="vcard">' +
//           '<img src="https://images.emojiterra.com/google/android-10/512px/1f9d1.png" alt="Image placeholder">' +
      
//       '</div>' +
//       '<div class="comment-body">' +
//           '<h3>' + document.querySelector("#name").value + '</h3>' +
//           '<div class="meta">' + new Date() + '</div>' +
//           '<p>' + document.querySelector("#message").value +'</p>' +
//           '<p><a href="#" class="reply rounded">Reply</a></p>' +
//       '</div>' +
//   '</li>';
  
  
// })

function update() {
  const existingData = sessionStorage.getItem("curID");
  console.log(existingData);
  if (existingData) {
    isLogin = true; //로그인
    //마이페이지 이동
    const curID = JSON.parse(existingData);
    const linkLogin = document.getElementById("btnLogin");
    //document.querySelector("#name").value= curID.username;
    //document.querySelector("#userId").value = curID.id;
    linkLogin.innerHTML ="<button type='button' id='btnLogin' class='btn btn-primary' > My Page </button>";

    //로그아웃
    const linkRes = document.getElementById("btnRegister");
    linkRes.innerHTML ="<button type='button' id='btnRegister' class='btn btn-primary' > Log Out </button>";
  } else {
    isLogin = false;
  }
}

document.querySelector("#btnLogin").addEventListener("click", function (event) {
  //로그인 안되있음 로그인, 되있으면 마이페이지
  if (isLogin) {
    //마이페이지
    linkLogin = document.getElementById("btnLogin");
    linkLogin.innerHTML =
      "<button type='button' id='btnRegister' class='btn btn-primary'>My Page</button>";
    console.log("마이페이지");
    window.location.href = "./mypage.html";
  } else {
    
    linkLogin = document.getElementById("btnLogin");
    linkLogin.innerHTML =
      "<button type='button' id='btnRegister' class='btn btn-primary' > Log In </button>";
    window.location.href = "./login.html";
  }
});
document.querySelector("#btnRegister").addEventListener("click", function (event) {
  //로그인 안되있음 register, 되있으면 로그아웃
  if (isLogin) {
    isLogin = false;
    console.log("로그아웃");
    sessionStorage.removeItem("curID"); //현재 ID 삭제
    linkRes = document.getElementById("btnRegister");
    
    linkRes.innerHTML ="<button type='button' id='btnRegister' class='btn btn-primary' > Sign IN </button>";
    linkLogin = document.getElementById("btnLogin");
    linkLogin.innerHTML ="<button type='button' id='btnRegister' class='btn btn-primary' > Log In </button>";
    window.location.href = "./index.html";
  } else {
    linkRes = document.getElementById("btnRegister");
    // linkRes.innerHTML =
    //   "<button type='button' id='btnRegister' class='btn btn-primary' > Log Out </button>";
    window.location.href = "./register.html";
  }
});


 // 로그인 함수
 function login(ID, password) {
  // 로컬 스토리지에서 JSON 데이터 가져오기
  const existingData = localStorage.getItem("users");

  if (existingData) {
    const users = JSON.parse(existingData);
    // 사용자를 찾는 반복문
    for (let i = 0; i < users.length; i++) {
      if (users[i].id === ID && users[i].password === password) {
        alert("로그인 성공");

        const curUser = {
          id: ID,
          password: password,
          username: users[i].username,
        };
        // 배열을 로컬 스토리지에 저장
        sessionStorage.setItem("curID", JSON.stringify(curUser));

        console.log("로그인 아이디 저장");
        return {
          success: true,
          message: "로그인 성공",
          user: users[i],
        };
      }
    }
  }
  alert("로그인 실패");
  return { success: false, message: "로그인 실패" };
}

document.querySelector("#btnLogin").addEventListener("click", function (event) {
  // 로그인 시도
  //id값이 같은것의 value를 저장하고
  let userId = document.querySelector("#userID").value;
  let userPW = document.querySelector("#userPW").value;
  console.log(userId);
  console.log(userPW);

  //로그인 가능여부 체크
  const result = login(userId, userPW);

  // 결과 확인
  if (result.success) {
    console.log(result.message);
    console.log("사용자 ID:", result.user.id);

    //메인 화면으로 이동
    window.location.href = "./index.html";
  } else {
    //실패시 메세지
    console.log(result.message);
  }
});

document.getElementById("submitButton").addEventListener("click", function(){  
  let comment = document.querySelector("#commnet-comment");
  comment.innerHTML += 
  ' <li class="comment"> ' +
      '<div class="vcard">' +
          '<img src="https://images.emojiterra.com/google/android-10/512px/1f9d1.png" alt="Image placeholder">' +
      
      '</div>' +
      '<div class="comment-body">' +
          '<h3>' + document.querySelector("#name").value + '</h3>' +
          '<div class="meta">' + new Date() + '</div>' +
          '<p>' + document.querySelector("#message").value +'</p>' +
          '<p><a href="#" class="reply rounded">Reply</a></p>' +
      '</div>' +
  '</li>';
  document.querySelector("#message").value = "";
  
})
