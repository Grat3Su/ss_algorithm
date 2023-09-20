<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="css/overlay.css" />

    <link rel="stylesheet" href="css/flatpickr.min.css" />

    <title>Blogy &mdash; Free Bootstrap 5 Website Template by Untree.co</title>

    


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
                <a href="index.html" class="logo m-0 float-start">Blogy<span class="text-primary">.</span></a>
              </div>
              <div class="col-8 text-center">
                <form action="#" class="search-form d-inline-block d-lg-none">
                  <input type="text" class="form-control" placeholder="Search...">
                  <span class="bi-search"></span>
                </form>
  
                <ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu mx-auto">
                  <li><a href="index.html">Home</a></li>
                  <li>
                    <a href="single.html">Pages</a>
                   
                  <li><a href="category.html">Politics</a></li>
                </ul>
              </div>    
              <div class="col-2 text-end">            
                <!-- <input type="text" class="form-control" placeholder="Search..."> -->
                <a><button type="button" id="btnLogin" class="btn btn-primary">Log in</button></a>
                <a><button type="button" id="btnRegister" class="btn btn-primary">Sign in</button></a>
                <!-- <li><a href="contact.html">Contact Us</a></li> -->
              </div>  
            </div>
          </div>
        </div>
      </div>
    </nav>

    <!-- Start retroy layout blog posts -->
    <section class="section bg-light">
      <div class="container">
        <label for="destinationList" class="form-label">원하시는 곳을 입력해주세요</label>
        <div class="row">
          <div class="col-11">
            <input
              class="form-control"
              list="datalistOptions"
              id="exampleDataList"
              placeholder="Type to search..."
            />
            <datalist id="datalistOptions">
              <option value="서울"></option>
              <option value="대전"></option>
              <option value="광주"></option>
              <option value="구미"></option>
              <option value="부울경"></option>
            </datalist>
          </div>
          <div class="col-1">
            <button class="btn btn-primary" type="submit" id="keywordButton">Button</button>
          </div>
        </div>

        <div id="map" style="width: 100%; height: 600px"></div>     
      </div>
    </section>

    <section class="section posts-entry" style ="background-color: white;">
      <div class="container">
        <div class="row mb-4">
          <div class="col-sm-6">
            <h2 class="posts-entry-title">Business</h2>
          </div>
          <div class="col-sm-6 text-sm-end">
            
          </div>
        </div>
        <div class="row">
          <div class="col-md">
            <div class="row g">
              <div class="col-md">                
                  <a href="single.html" class="img-link">
                    <img src="https://www.visitbusan.net/uploadImgs/files/cntnts/20191229153530671_oen" alt="Image" class="img-fluid" />
                  </a>
                  <span class="date">Apr. 09th, 2023</span>
                  <h2>
                    <a href="single.html">뜨거운 여름 해운대에서 더위 피하세요</a>
                  </h2>
                  <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde, nobis ea quis
                    inventore vel voluptas.
                  </p>                              
          </div>
          <div class="col-md">
            <ul class="list-unstyled blog-entry-sm">
              <li>
                <span class="date">Apr. 09th, 2023</span>
                <h3>
                  <a href="single.html">선크림 바르는거 잊지마세요~</a>
                </h3>
                <p>
                  Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde, nobis ea quis
                  inventore vel voluptas.
                </p>
                <p>
                  Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde, nobis ea quis
                  inventore vel voluptas.
                </p>
                <p>
                  Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde, nobis ea quis
                  inventore vel voluptas.
                </p>
                <p>
                  Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde, nobis ea quis
                  inventore vel voluptas.
                </p>
                <p>
                  Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde, nobis ea quis
                  inventore vel voluptas.
                </p>
              </li>

              
        </div>
      </div>
    </section>

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
    <script src="js/keyword.js"></script>
    <script src="js/login.js"></script>
    <!-- 밑의 라인 반드시 암호화 해야돼 내 API KEY 는 내 민증이나 마찬가지야~~ -->
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20c3b4e0b8aa2fbaee9c815ada55dbfa&libraries=services"
    ></script>
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20c3b4e0b8aa2fbaee9c815ada55dbfa"
    ></script>

    <script></script>
    
  </body>
</html>
