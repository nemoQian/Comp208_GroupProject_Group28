<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>homepage</title>
	<link rel="shortcut icon" href="picture/28logo.png">
	<link rel="stylesheet" href="./reset/reset.css">
	<link rel="stylesheet" type="text/css" href="./menu.css">
	<script src="https://cdn.staticfile.org/vue/2.6.9/vue.js"></script>
	<script src="https://unpkg.com/http-vue-loader"></script>
	<script src="js/echarts.min.js"></script>
	<script src="js/jquery-2.2.1.min.js"></script>
	<script src="js/echarts.helper.js"></script>
	<script src="chart_js/chart_1.js"></script>
	<script src="chart_js/chart_2.js"></script>
	<script src="chart_js/chart_3.js"></script>
	<script src="chart_js/chart_5.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<style>

</style>
<body>

<header>
	<img src="picture/28logo.png" width=25px height=25px class="logo">
	<img src="picture/download.png" width=25px height=25px class="download">
	<img src="picture/user.png" width=25px height=25px class="user">
	<img src="picture/exit.png" width=25px height=25px class="exit">

	<div class="title">City energy management and Computational Sustainability System</div>
	<div class="user"></div>
</header>
<div class="boxset">
	<div class="box1">
		<div class="box1_header">Power scatter diagram of electric facilities</div>
		<div id="chart_3" class="test2" style="width: 340px; height: 290px;"></div>


	</div>


	<div class="box2_header">Map</div>
	<div class="box2">

		<canvas width="829px" height="515px" id="myCanvas"></canvas>


	</div>


	<div class="box3">
		<div class="box3_header">Power generation and consumption</div>
		<div id="chart_2" class="test" style="width: 100%; height: 190px;"></div>
	</div>
	<div class="box4">
		<div class="box4_header">Facilities number and consumption</div>
		<div id="chart_4" class="test1" style="width: 100%;height:270px;"></div>
	</div>
	<div id='app' class="container">
		<div class="box5">
			<div class="box5_header">Add and modify facilities </div>
			<div class="select">
				<div class="raselect">
					<img src="picture/house.png" class="house" width="50px"  v-bind:title="messagehouse"><br><br>
					<input type="radio" name="type" id="house" value="Community" v-model="stype"> Community
				</div>

				<div class="hosselect">
					<img src="picture/hospital.png" class="hospital" width="50px"  v-bind:title="messagehospital"><br><br>
					<input type="radio" name="type" id="Hospital"  value="Hospital" v-model="stype"> Hospital
				</div>

				<div class="schoolselect">
					<img src="picture/school.png" class="school" width="60px"  v-bind:title="messageschool"><br><br>
					<input type="radio" name="type" id="school" value="School"  v-model="stype"> School
				</div>

				<div class="powerselect">
					<img src="picture/power%20station.png" class="power" width="60px"  v-bind:title="messagepower"><br><br>
					<input type="radio"  name="type" id="power" value=" Power station" v-model="stype"> Power station
				</div>

				<div class="shopselect">
					<img src="picture/shopping%20centre.png" class="shop" width="50px"  v-bind:title="messageshop"><br><br>
					<input type="radio" name="type" id="shop"  value="Shopping centre" v-model="stype"> Shopping <br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbspcentre
				</div>


			</div>
			<div class='operation' >
				<!--style="border-left:1px solid #d3d3d3;"-->
				<div class="input"><label >Name: &nbsp</label><input class="inputname" v-model='name' /></div>

				<div class="input"><label >X-coordinate: &nbsp</label><input class="inputx" v-model='x' type="text"   /></div>

				<div class="input"><label >Y-coordinate: &nbsp</label><input class="inputy" v-model='y' type="text"  /></div>

				Power level:
				<select class="consumption" v-model="consumption" >



					<option>low-level</option>

					<option>medium-level</option>

					<option>high-level</option>

				</select>

				<button class="add" type="submit" @click="addsubmit"> add </button>
				<button class="reset" type="submit" @click="clearCanvas"> reset </button>
				<button class="done" type="submit"  @click="done"  > done </button>
				<button class="rollback" type="submit"  @click="rollback"> rollback </button>

			</div>

		</div>
	</div>


	<div class="box6">
		<div class="box6_header">Energymonitor</div>
		<div id="chart_5" class="test3" style="width: 1320px;height:350px;"></div>

	</div>

</div>

</body>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/qs/6.9.4/qs.min.js"></script>
<script type="text/javascript">

	var canvas=document.getElementById('myCanvas');
	var ctx=canvas.getContext('2d');
	var imagedata = ctx.getImageData(0,0,829,515);
	array=[]
	array.push(imagedata)

	function draw(fromx,fromy,tox,toy){
		ctx.moveTo(fromx,fromy);
		ctx.lineTo(tox,toy);
		ctx.stroke();
	}




	function communityposition(x,y){
		var img = new Image()
		img.src = 'picture/house.png'
		img.onload = function(){
			ctx.drawImage(this,x, y, 50, 45)
			imagedata = ctx.getImageData(0,0,829,515)
			array.push(imagedata)
		}




	}

	function houspitalposition(x,y){
		var img = new Image()
		img.src = 'picture/hospital.png'
		img.onload = function(){
			ctx.drawImage(this,x, y, 50, 50)
			imagedata = ctx.getImageData(0,0,829,515)
			array.push(imagedata)
		}


	}
	function shopposition(x,y){
		var img = new Image()
		img.src = 'picture/shopping centre.png'
		img.onload = function(){
			ctx.drawImage(this,x, y, 50, 50)
			imagedata = ctx.getImageData(0,0,829,515)
			array.push(imagedata)
		}


	}

	function schoolposition(x,y){
		var img = new Image()
		img.src = 'picture/school.png'
		img.onload = function(){
			ctx.drawImage(this,x, y, 50, 50)
			imagedata = ctx.getImageData(0,0,829,515)
			array.push(imagedata)
		}


	}

	function powerposition(x,y){
		var img = new Image()
		img.src = 'picture/power station.png'
		img.onload = function(){
			ctx.drawImage(this,x, y, 60, 60)
			imagedata = ctx.getImageData(0,0,829,515)
			array.push(imagedata)
		}


	}




	function isNumber(str){
		var n = Number(str);
		if (!isNaN(n)){
			return true;
		}else{
			return false;
		}
	}



	var vue = new Vue({
		el: '#app',
		data: {
			x:"",y:"",name:"",consumption:"",stype:"",array:[],imagedata,

			messagehouse:"low-level: medium-level: high-level: ",
			messagehospital:"low-level: medium-level: high-level: ",
			messageschool:"low-level: medium-level: high-level: ",
			messagepower:"low-level: medium-level: high-level: ",
			messageshop:"low-level: medium-level: high-level: ",


		},
		methods: {



			addword:function(){
				var len = this.name.length;
				var con=document.getElementById("myCanvas");
				var context=con.getContext("2d");
				context.font = 'italic 16px Calibri';
				context.fillText(this.name,(Number(this.x)*2+50)/2-4.5*len,Number(this.y)+68)
			},



			addsubmit:function(){
				var type = this.stype;
				var x = this.x;
				var y = this.y;


				if(isNumber(x)==false||isNumber(y)==false){alert("Please input the number.")}



				if(type==""){alert("Please choose the type first.")}
				else if(x==""){alert("Please enter the value of x.")}
				else if(y==""){alert("Please enter the value of y.")}
				else if (this.consumption==""){alert("Please choose the consumption level.")}
				else if(type=="Community"){
					communityposition(x,y)
					this.addword()
				}
				else if(type=="Shopping centre"){
					shopposition(x,y)
					this.addword(x,y)
				}else if(type=="Hospital"){
					houspitalposition(x,y)
					this.addword(x,y)
				}else if(type=="School"){
					schoolposition(x,y)
					this.addword(x,y)
				}else {
					powerposition(x,y)
					this.addword(x,y)
				}

				let p = window.Qs.stringify(
						{
							type:this.stype,
							name:this.name,
							x:this.x,
							y:this.y,
							consumption:this.consumption,
						}
				);
				console.log(p)
				axios.post('ajax/position',p)


			},


			clearCanvas:function (){
				var c=document.getElementById("myCanvas");
				var cxt=c.getContext("2d");
				cxt.clearRect(0,0,c.width,c.height);

				axios.post('ajax/reset')
			},

            rollback:function (){
				if(array.length==1) {
					alert("There is no previous operation.")
				}else{
					array.pop()
					ctx.putImageData(array[array.length - 1], 0, 0);
					axios.post('ajax/rollback')
				}
			},

			done:function (){

				axios.post('ajax/done').then(function (res) {

					console.log(res.data)
					for (let i = 0; i < res.data.length; i+=4) {

						draw(res.data[i],res.data[i+1],res.data[i+2],res.data[i+3])
					}
				})

			}
		}
	})



</script>

</html>

