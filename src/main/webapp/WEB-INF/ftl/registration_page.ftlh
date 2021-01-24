<#ftl encoding="UTF-8"/>
<!doctype html>
<html lang="en">
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
    <title>Registration</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/checkout/">

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

<body class="bg-light">
<div class="container">
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="/resources/img/icon_registration.png" width="85" height="85">
        <h3 style="color: white">Регистраниция</h3>
        <p class="lead">Заполните форму данными о Вас.</p>
    </div>

    <form class="registration text-center" method="post" action="/registration">
        <div class="form-group">
            <div class="text-right">
                <div class="form-group row">
                    <label for="firstName" class="col-sm-2 col-form-label text-reg">Имя</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="firstName" id="firstName"
                               placeholder="Введите ваше имя">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="lastName" class="col-sm-2 col-form-label text-reg">Фамилия</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="lastName" id="lastName"
                               placeholder="Введите вашу фамилию">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="age" class="col-sm-2 col-form-label text-reg">Возраст</label>
                    <div class="col-sm-8">
                        <input type="number" class="form-control" name="age" id="age" placeholder="Введите ваш возраст">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="login" class="col-sm-2 col-form-label text-reg">Логин</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="login" id="login" placeholder="Введите ваш логин">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="inputPassword" class="col-sm-2 col-form-label text-reg">Пароль</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" name="hashPassword" id="inputPassword"
                               placeholder="Введите ваш пароль">
                    </div>
                </div>
            </div>
            <input type="submit" class="btn btn-info" value="Зарегистрироваться!">
        </div>
    </form>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="../checkout/form-validation.js"></script>
</body>
</html>
