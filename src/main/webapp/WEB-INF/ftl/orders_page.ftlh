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
    <title>Order</title>

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
                <li class="nav-item">
                    <a class="nav-link" href="/countries">Страны</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/create">Создать тур</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/comment">Отзывы</a>
                </li>
            </ul>

        </div>
    </nav>
</header>

<main>

    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="/resources/img/icon_create.png" width="85" height="85">
        <h3 style="color: white">Сделать заказ</h3>
        <p class="lead">Заполните форму, чтобы заказать тур.</p>
    </div>

    <form class="registration text-center" method="post" action="/create">
        <div class="form-group">
            <div class="text-right">
                <div class="form-group row">
                    <label for="userId" class="col-sm-2 col-form-label text-reg">Ваш id</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="userId" id="userId"
                               placeholder="Введите ваш id...">
                    </div>
                </div>

                <!-- hotel_stars -->
                <div class="form-group row">
                    <label for="countryId" class="col-sm-2 col-form-label text-reg">Страна</label>
                    <div class="col-sm-8">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="countryId">Страна</label>
                            </div>
                            <select class="custom-select" name="countryId" id="countryId">
                                <#list countries as country>
                                    <option value="${country.id}">${country.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                </div>

                <!-- hotel_stars -->
                <div class="form-group row">
                    <label for="hotelStars" class="col-sm-2 col-form-label text-reg">★★★★★</label>
                    <div class="col-sm-8">
                        <input type="range" class="custom-range" min="1" max="5" name="hotelStars" id="hotelStars">
                    </div>
                </div>

                <!-- shipping_id -->
                <div class="form-group row">
                    <label for="shippingId" class="col-sm-2 col-form-label text-reg">Способ передвижения</label>
                    <div class="col-sm-8">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="shippingId">Способ передвижения</label>
                            </div>
                            <select class="custom-select" name="shippingId" id="shippingId">
                                <#list shippings as shipping>
                                    <option value="${shipping.id}">${shipping.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                </div>

                <!-- preferences -->
                <div class="form-group row">
                    <label for="preferences" class="col-sm-2 col-form-label text-reg">Пожелания</label>
                    <div class="col-sm-8">
                        <div class="form-group">
                            <textarea class="form-control" id="preferences" name="preferences" rows="3"></textarea>
                        </div>
                    </div>
                </div>
            </div>
            <input type="submit" class="btn btn-info" value="Сделать заказ!">
        </div>
    </form>

    <div class="container">
        <table class="table table-light table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="row">Имя заказчика</th>
                <th scope="row">Страна</th>
                <th scope="row">★★★★★</th>
                <th scope="row">Способ передвижения</th>
                <th scope="row">Пожелания</th>
            </tr>
            </thead>
            <tbody>
            <#list orders as order>
                <tr>
                    <td>${order.user.login}</td>
                    <td>${order.country.name}</td>
                    <td><#if order.star == 1>
                            ☆☆☆☆★
                        <#elseif order.star == 2>
                            ☆☆☆★★
                        <#elseif order.star == 3>
                            ☆☆★★★
                        <#elseif order.star == 4>
                            ☆★★★★
                        <#elseif order.star == 5>
                            ★★★★★
                        </#if></td>
                    <td>${order.shipping.name}</td>
                    <td>${order.preferences}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>



</main>

</body>
</html>