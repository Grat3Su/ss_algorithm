<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- /*
* Template Name: Blogy
* Template Author: Untree.co
* Template URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="author" content="Untree.co" />
    <link rel="shortcut icon" href="favicon.png" />

    <meta name="description" content="" />
    <meta name="keywords" content="bootstrap, bootstrap5" />

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;600;700&display=swap"
      rel="stylesheet"
    />

    <link rel="stylesheet" href="fonts/icomoon/style.css" />
    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css" />

    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css"
    />

    <link rel="stylesheet" href="css/tiny-slider.css" />
    <link rel="stylesheet" href="css/aos.css" />
    <link rel="stylesheet" href="css/glightbox.min.css" />
    <link rel="stylesheet" href="css/style.css" />

    <link rel="stylesheet" href="css/flatpickr.min.css" />

    <title>Blogy &mdash; Free Bootstrap 5 Website Template by Untree.co</title>

    <style>
      .login {
        display: flex;
        justify-content: center;
        align-items: center;
        /* background-color: lightgray; */ /* 컨테이너 영역 확인용 배경색 */
      }
      .Btnlogin {
        display: flex;
        justify-content: center;
        align-items: center;
        /* background-color: lightgray; */ /* 컨테이너 영역 확인용 배경색 */
      }
    </style>
  </head>
  <body>
    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close">
          <span class="icofont-close js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>

    <nav class="site-nav">
      <div class="container">
        <div class="menu-bg-wrap">
          <div class="site-navigation">
            <div class="row g-0 align-items-center">
              <div class="col-2">
                <a href="index.html" class="logo m-0 float-start"
                  >Blogy<span class="text-primary">.</span></a
                >
              </div>
              <div class="col-8 text-center">
                <form action="#" class="search-form d-inline-block d-lg-none">
                  <input type="text" class="form-control" placeholder="Search..." />
                  <span class="bi-search"></span>
                </form>

                <ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu mx-auto">
                  <li><a href="index.html">Home</a></li>
                  <li class="has-children active">
                    <a href="category.html">Pages</a>
                    <ul class="dropdown">
                      <li>
                        <a href="search-result.html">Search Result</a>
                      </li>
                      <li>
                        <a href="blog.html">Blog</a>
                      </li>
                      <li>
                        <a href="single.html">Blog Single</a>
                      </li>
                      <li>
                        <a href="category.html">Category</a>
                      </li>
                      <li class="active">
                        <a href="contact.html">Contact Us</a>
                      </li>
                      <li>
                        <a href="about.html">About</a>
                      </li>
                      <li><a href="#">Menu One</a></li>
                      <li><a href="#">Menu Two</a></li>
                      <li class="has-children">
                        <a href="#">Dropdown</a>
                        <ul class="dropdown">
                          <li>
                            <a href="#">Sub Menu One</a>
                          </li>
                          <li>
                            <a href="#">Sub Menu Two</a>
                          </li>
                          <li>
                            <a href="#">Sub Menu Three</a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                  <li><a href="category.html">Culture</a></li>
                  <li>
                    <a href="category.html">Business</a>
                  </li>
                  <li>
                    <a href="category.html">Politics</a>
                  </li>
                </ul>
              </div>
              <div class="col-2 text-end">
                <a
                  href="#"
                  class="burger ms-auto float-end site-menu-toggle js-menu-toggle d-inline-block d-lg-none light"
                >
                  <span></span>
                </a>
                <form action="#" class="search-form d-none d-lg-inline-block">
                  <input type="text" class="form-control" placeholder="Search..." />
                  <span class="bi-search"></span>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </nav>

    <div class="hero overlay inner-page bg-primary py-5">
      <div class="container">
        <div class="row align-items-center justify-content-center text-center pt-5">
          <div class="col-lg-6">
            <h1 class="heading text-white mb-3" data-aos="fade-up">Login</h1>
          </div>
        </div>
      </div>
    </div>

    <!-- 
</div>
</div> -->

    <!-- //로그인 -->
    <form action="Loginout" method="post">
    <input name = "job" value = "login" type = "hidden">
	    <div class="section">
	      <div class="container-md, login">
	        <div class="row">
	          <div class="col-lg-8" data-aos="fade-up" data-aos-delay="200">
	            <form action="#">
	              <div class="row" style="width: 500px">
	                <div class="mb-3">
	                  <input type="text" name = "loginID" placeholder="ID" value = "ssafy" />
	                </div>
	                <div class="mb-3">
	                  <input type="password" name = "loginPassword" placeholder="Password" value = "1234" />
	                </div>
	                <br />
	
	                <div class="col-12 Btnlogin">
	                <a><button type="submit" id="btnLogin" class="btn btn-primary">로그인</button></a>
	                </form>
	                  
	                  <!-- <input type="submit" id="btnLogin" value="로그인" class="btn btn-primary" /> -->
	                </div>
	              </div>
	          </div>
	        </div>
      </div>
    </div>
   </form>
    <!-- /.untree_co-section -->

    <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-lg-4">
            <div class="widget">
              <h3 class="mb-4">About</h3>
              <p>
                Far far away, behind the word mountains, far from the countries Vokalia and
                Consonantia, there live the blind texts.
              </p>
            </div>
            <!-- /.widget -->
            <div class="widget">
              <h3>Social</h3>
              <ul class="list-unstyled social">
                <li>
                  <a href="#"><span class="icon-instagram"></span></a>
                </li>
                <li>
                  <a href="#"><span class="icon-twitter"></span></a>
                </li>
                <li>
                  <a href="#"><span class="icon-facebook"></span></a>
                </li>
                <li>
                  <a href="#"><span class="icon-linkedin"></span></a>
                </li>
                <li>
                  <a href="#"><span class="icon-pinterest"></span></a>
                </li>
                <li>
                  <a href="#"><span class="icon-dribbble"></span></a>
                </li>
              </ul>
            </div>
            <!-- /.widget -->
          </div>
          <!-- /.col-lg-4 -->
          <div class="col-lg-4 ps-lg-5">
            <div class="widget">
              <h3 class="mb-4">Company</h3>
              <ul class="list-unstyled float-start links">
                <li><a href="#">About us</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Vision</a></li>
                <li><a href="#">Mission</a></li>
                <li><a href="#">Terms</a></li>
                <li><a href="#">Privacy</a></li>
              </ul>
              <ul class="list-unstyled float-start links">
                <li><a href="#">Partners</a></li>
                <li><a href="#">Business</a></li>
                <li><a href="#">Careers</a></li>
                <li><a href="#">Blog</a></li>
                <li><a href="#">FAQ</a></li>
                <li><a href="#">Creative</a></li>
              </ul>
            </div>
            <!-- /.widget -->
          </div>
          <!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <div class="widget">
              <h3 class="mb-4">Recent Post Entry</h3>
              <div class="post-entry-footer">
                <ul>
                  <li>
                    <a href="">
                      <img src="images/img_1_sq.jpg" alt="Image placeholder" class="me-4 rounded" />
                      <div class="text">
                        <h4>There’s a Cool New Way for Men to Wear Socks and Sandals</h4>
                        <div class="post-meta">
                          <span class="mr-2">March 15, 2018 </span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <li>
                    <a href="">
                      <img src="images/img_2_sq.jpg" alt="Image placeholder" class="me-4 rounded" />
                      <div class="text">
                        <h4>There’s a Cool New Way for Men to Wear Socks and Sandals</h4>
                        <div class="post-meta">
                          <span class="mr-2">March 15, 2018 </span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <li>
                    <a href="">
                      <img src="images/img_3_sq.jpg" alt="Image placeholder" class="me-4 rounded" />
                      <div class="text">
                        <h4>There’s a Cool New Way for Men to Wear Socks and Sandals</h4>
                        <div class="post-meta">
                          <span class="mr-2">March 15, 2018 </span>
                        </div>
                      </div>
                    </a>
                  </li>
                </ul>
              </div>
            </div>
            <!-- /.widget -->
          </div>
          <!-- /.col-lg-4 -->
        </div>
        <!-- /.row -->

        <div class="row mt-5">
          <div class="col-12 text-center">
            <!-- 
              **==========
              NOTE: 
              Please don't remove this copyright link unless you buy the license here https://untree.co/license/  
              **==========
            -->

            <p>
              Copyright &copy;
              <script>
                document.write(new Date().getFullYear());
              </script>
              . All Rights Reserved. &mdash; Designed with love by
              <a href="https://untree.co">Untree.co</a>
              Distributed by
              <a href="https://themewagon.com">ThemeWagon</a>
              <!-- License information: https://untree.co/license/ -->
            </p>
          </div>
        </div>
      </div>
      <!-- /.container -->
    </footer>
    <!-- /.site-footer -->

    <!-- Preloader -->
    <div id="overlayer"></div>
    <div class="loader">
      <div class="spinner-border text-primary" role="status">
        <span class="visually-hidden">Loading...</span>
      </div>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/tiny-slider.js"></script>

    <script src="js/flatpickr.min.js"></script>

    <script src="js/aos.js"></script>
    <script src="js/glightbox.min.js"></script>
    <script src="js/navbar.js"></script>
    <script src="js/counter.js"></script>
    <script src="js/custom.js"></script>

    <script>
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
    </script>
  </body>
</html>
