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

    <meta charset="UTF-8">
    <title>Comments</title>

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

    <link rel="stylesheet" href="/resources/style/style.css">
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
                <li class="nav-item">
                    <a class="nav-link" href="/">Главная</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="/countries">Страны</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" href="/create">Создать тур</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/comment">Отзывы</a>
                </li>
            </ul>

        </div>
    </nav>
</header>

<div class="container">
    <div class="row row-cols-1 row-cols-md-4">
        <#list comments as comment>
            <div class="card shadow-sm bg-light" style="max-width: 16rem; margin: 10px">
                <div class="card-header">${comment.author}</div>
                <div class="card-body">
                    <p class="card-text">${comment.text}</p>
                </div>
            </div>
        </#list>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="alert alert-light">
                <form action="/comment" method="post">
                    <div class="form-group">
                        <div class="input-group input-group-sm mb-3">
                            <input class="form-control" type="text" name="author" placeholder="Введите ваше имя">
                        </div>
                        <div class="input-group input-group-sm mb-3">
                            <textarea class="form-control" type="text" name="text" placeholder="Введите ваш отзыв" rows="3"></textarea>
                        </div>

                        <input type="submit" class="btn btn-info">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>