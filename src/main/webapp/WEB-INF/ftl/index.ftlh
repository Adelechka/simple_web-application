<#ftl encoding="UTF-8"/>
<!doctype html>
<html lang="ru">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Главная страница</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/carousel/">

    <!-- Bootstrap core CSS -->
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

    <link rel="shortcut icon" href="/resources/img/icon.png" type="image/png">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="navbar-brand">Travel Mood</div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04"
                aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExample04">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Главная</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="/countries">Страны</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="/create">Создать тур</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/comment">Отзывы</a>
                </li>
            </ul>

        </div>
    </nav>
</header>

<main role="main" style="margin-top: 50px">

    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <svg class="bd-placeholder-img" width="100%" height="350px" xmlns="http://www.w3.org/2000/svg"
                     preserveAspectRatio="xMidYMid slice" focusable="false" role="img">
                    <rect width="100%" height="100%" fill="#C55855"/>
                </svg>
                <div class="container">
                    <div class="carousel-caption text-left">
                        <h1>Страны.</h1>
                        <p>В данном разделе вы можете ознакомиться со списком всех доступных стран</p>
                        <p><a class="btn btn-lg btn-secondary" href="/countries" role="button">Перейти к разделу</a></p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <svg class="bd-placeholder-img" width="100%" height="350px" xmlns="http://www.w3.org/2000/svg"
                     preserveAspectRatio="xMidYMid slice" focusable="false" role="img">
                    <rect width="100%" height="100%" fill="#59667E"/>
                </svg>
                <div class="container">
                    <div class="carousel-caption">
                        <h1>Заказ тура.</h1>
                        <p>В данном разделе вы можете создать тур, в который бы хотели отправиться.</p>
                        <p><a class="btn btn-lg btn-secondary" href="/create" role="button">Перейти к разделу</a></p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <svg class="bd-placeholder-img" width="100%" height="350px" xmlns="http://www.w3.org/2000/svg"
                     preserveAspectRatio="xMidYMid slice" focusable="false" role="img">
                    <rect width="100%" height="100%" fill="#B7B4BD"/>
                </svg>
                <div class="container">
                    <div class="carousel-caption text-right">
                        <h1>Отзывы.</h1>
                        <p>В данном разделе вы можете оставить отзыв на наш сервис.</p>
                        <p><a class="btn btn-lg btn-secondary" href="/comment" role="button">Перейти к разделу</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing" style="margin-top: 20px">

        <!-- Three columns of text below the carousel -->
        <div class="row">
            <div class="col-lg-4">
                <img src="/resources/img/icon_country.png">
                <h2>Страны</h2>
                <p>Подробное описание того, что вы встретите на своем отдыхе и чем сможете.</p>
                <p><a class="btn btn-secondary" href="/countries" role="button">Перейти &raquo;</a></p>
            </div><!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <img src="/resources/img/icon_create.png">
                <h2>Создать тур</h2>
                <p>Форма для выбора страны, варианта передвижения, место для пожеланий.</p>
                <p><a class="btn btn-secondary" href="/create" role="button">Перейти &raquo;</a></p>
            </div><!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <img src="/resources/img/icon_review.png">
                <h2>Отзывы</h2>
                <p>Место, где вы можете поделить своим мнением.</p>
                <p><a class="btn btn-secondary" href="/comment" role="button">Перейти &raquo;</a></p>
            </div><!-- /.col-lg-4 -->
        </div><!-- /.row -->

        <div class="row">
            <div class="col-lg-4">
                <img src="/resources/img/icon_reg.png">
                <h2>Регистрация</h2>
                <p><a class="btn btn-secondary" href="/registration" role="button">Перейти &raquo;</a></p>
            </div><!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <img src="/resources/img/icon_log.png">
                <h2>Авторизация</h2>
                <p><a class="btn btn-secondary" href="/login" role="button">Перейти &raquo;</a></p>
            </div><!-- /.col-lg-4 -->
    </div><!-- /.container -->


    <!-- FOOTER -->
</main>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
</html>
