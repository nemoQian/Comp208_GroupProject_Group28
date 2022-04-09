<%--
  Created by IntelliJ IDEA.
  User: finnik
  Date: 2022/3/5
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>City energy management and Computational Sustainability System</title>
    <link rel="icon" href="picture/28logo.png">


    <%--    <link rel="stylesheet" href="<c:url value='style.css'></c:url>"/>--%>
    <link rel="stylesheet" href="style.css">
    <script src="https://cdn.staticfile.org/vue/2.6.9/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

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
                    <div class="input"><input :class='{ hasValue: registerForm.email }' v-model='registerForm.email'
                                              type="text" name="email" id='email'/><label for="email">email</label>
                    </div>
                    <div class="input"><input :class='{ hasValue: registerForm.Username }'
                                              v-model='registerForm.Username' type="text" name="Username"
                                              id="registerusername"/><label for="username">username</label></div>
                    <div class="input"><input :class='{ hasValue: registerForm.Password }'
                                              v-model='registerForm.Password' type="password" name="Password"
                                              id="registerPassword"/><label for="Password">password</label></div>
                    <div class="input"><input :class='{ hasValue: registerForm.repeat }' v-model='registerForm.repeat'
                                              type="password" name="repeat" id="Passwordrepeat"/><label
                            for="Passwordrepeat">repeat your password</label></div>
                    <button type="submit" @click='registersubmit'>register</button>
                </template>

                <template v-if='active === "login"'>
                    <div class="input"><input :class='{ hasValue: loginForm.Username }' v-model='loginForm.Username'
                                              type="text" name="Username" id="loginusername"/><label for="username">username</label>
                    </div>
                    <div class="input"><input :class='{ hasValue: loginForm.Password }' v-model='loginForm.Password'
                                              type="password" name="Password" id="loginPassword"/><label for="Password">password</label>
                    </div>
                    <div class="rememberme"><br><input :class='{ hasValue: loginForm.rememberme }'
                                                       v-model='loginForm.rememberme' type="checkbox" name="rememberme"
                                                       checked="checked">&nbsp remember me
                    </div>
                    <span>forget your passport?</span>
                    <button type="submit" @click='loginsubmit'>log in</button>
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

<script src="https://cdn.bootcdn.net/ajax/libs/qs/6.9.4/qs.min.js"></script>

<script>
    var vue = new Vue({
        el: '#app',
        data: {
            active: 'login',
            registerForm: {email: '', Username: '', Password: '', repeat: '',},
            loginForm: {Username: '', Password: '', rememberme: ''}
        },
        methods: {
            go: function (type) {
                this.active = type
            },

            loginsubmit: function () {
                var lusername = this.loginForm.Username;
                var lpassword = this.loginForm.Password;
                console.log(lusername)
                if (lusername == null || lusername.trim() == "") {
                    alert("username is empty")
                }

                if (lpassword == null || lpassword.trim() == "") {
                    alert("password is empty")
                }

                let s = window.Qs.stringify(
                    {
                        Username: lusername,
                        password: lpassword
                    }
                );
                axios.post('ajax/login', s)
                    .then(function (res) {
                        // 因为层级比较深，匿名函数会导致this指向发生改变
                        // 这个时候使用箭头函数解决
                        console.log("o:" + res.data)
                        if (res.data == 200) {
                            window.alert("successs")
                            window.location.href = "toMenu"
                        } else {
                            alert(res.data)
                        }
                    }).catch(function () {
                    alert('网络超时, 请重新加载!')
                });

            },

            registersubmit: function () {

                var rusername = this.registerForm.Username;
                var rpassword = this.registerForm.Password;
                var email = this.registerForm.email;
                var repeat = this.registerForm.repeat;

                if (rusername == null || rusername.trim() == "") {
                    alert("username can not be empty")
                }

                if (rpassword == null || rpassword.trim() == "") {
                    alert("password can not be empty")
                }
                if (email == null || email.trim() == "") {
                    alert("email can not be empty")
                }
                if (repeat == null || repeat.trim() == "") {
                    alert("please repeat your password")
                }

                if (rpassword != repeat) {
                    alert("Repetitive password is different from the original one")
                }
                if (repeat.length < 8) {
                    alert("The length of the password must exceed 8")
                }
                let r = window.Qs.stringify(
                    {
                        Username: rusername,
                        password: rpassword,
                        email: email,
                    }
                );
                axios({
                    url: 'ajax/register',
                    data: r,
                    method: "post",
                    dataType: "json",
                    success: function (data) {
                        if (data.success()) {
                            alert("successs")
                        }
                    }
                })
            },
        },
    })
</script>


</html>
