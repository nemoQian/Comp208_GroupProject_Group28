<%--
  Created by IntelliJ IDEA.
  User: finnik
  Date: 2022/3/5
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>City energy management and Computational Sustainability System</title>
    <link rel="icon" href="picture/28logo.png">

    <link rel="stylesheet" href="reset/reset.css">
    <link rel="stylesheet" href="style.css">

    <script src="https://cdn.staticfile.org/vue/2.6.9/vue.js"></script>
    <script src=”https://unpkg.com/axios/dist/axios.min.js”></script>

</head>

<body>

<div id='app' class="container">
    <img src="picture/log_background.png">
    <div class="panel">
        <div class="content login">
            <div class="switch">
                <br>
                <span :class='{"active": active === "login"}' @click='go("login")'>log in</span>
                <span>/</span>
                <span :class='{"active": active === "register"}' @click='go("register")'>register</span>
            </div>
            <div class='form' id="fromLogin">
                <template v-if='active === "register"'>
                    <div class="input"><input :class='{ hasValue: registerForm.email }' v-model='registerForm.email' type="text" name="email" id='email' /><label for="email">email</label></div>
                    <div class="input"><input :class='{ hasValue: registerForm.Username }' v-model='registerForm.Username' type="text" name="Username" id="username" /><label for="username">username</label></div>
                    <div class="input"><input :class='{ hasValue: registerForm.Password }' v-model='registerForm.Password' type="password" name="Password" id="Password" /><label for="Password">password</label></div>
                    <div class="input"><input :class='{ hasValue: registerForm.repeat }' v-model='registerForm.repeat' type="password" name="repeat" id="Passwordrepeat" /><label for="Passwordrepeat">repeat your password</label></div>
                    <button type="submit" @click='submit'>register</button>
                </template>

                <template v-if='active === "login"'>
                    <div class="input"><input :class='{ hasValue: loginForm.Username }' v-model='loginForm.Username' type="text" name="Username" id="username " onblur="a1()"/><label for="username">username</label></div>
                    <div class="input"><input :class='{ hasValue: loginForm.Password }' v-model='loginForm.Password' type="password" name="Password" id="Password " /><label for="Password">password</label></div>
                    <div class="remember"><br><input :class="remember" type="checkbox" name="rememberme" checked="checked">&nbsp remember me </div>
                    <span>forget your passport?</span>


                    <button type="submit" @click='submit'>log in </button>
                </template>

            </div>

        </div>

    </div>
    <div class="title">
            <span>
                City energy<br>management<br> and<br> Computational<br>Sustainability<br> System
            </span>
    </div>
    <div class="titlebelow">
            <span>
                Pressures on the energy system are not going to relent in<br> the coming decades. The energy sector is responsible for<br> almost three-quarters of the emissions that have already<br> pushed global average temperatures 1.1 °C higher since<br> the pre-industrial age, with visible impacts on weather<br> and climate extremes. The energy sector has to be at <br>the heart of the solution to climate change.
                <br>——World Energy Outlook
            </span>
    </div>
</div>



</body>



<script>
    var vue = new Vue({
        el: '#app',
        data: {
            active: 'login',
            registerForm: { email: '', Username: '', Password: '', repeat: '', },
            loginForm: { Username: '', Password: '', },
        },
        methods: {
            go (type) {
                this.active = type
            },


            submit() {
                if (type === 'login') {
                    console.log('login', this.loginForm)
                    axios({
                        methods: 'get',
                        url: "${pageContext.request.contextPath}/ajax/a1"
                    }).then(function(res){
                        console.log(res.data.name);
                    })
                }

                if (type === 'register') {
                    console.log('register', this.registerForm)
                }
            }

        },

    })
</script>


</html>