<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
 <style>
   .fig {
    text-align: center; /* Выравнивание по центру */ 
   }
</style>
     
   
     
 <div class="row" style="background-color:black">	
					<div class="col-md-10 text-center col-md-offset-1" style="color:white">
						<h2 style="margin-top:40px"><b>Be sure to read</b></h2>
						<h4>Самолікування може бути шкідливим для вашого здоров’я.
						 Будь-ласка проконсультуйтесь з лікарем перед вживанням лікарських засобів. </h4>
						
					</div>	
				
					
					
			</div>	
			<hr>
			<div class="row">	
					<div class="col-md-10 text-left col-md-offset-1">
						
						
						<div class="row">
							<div style="margin-left:200px" class="col-md-6">
							<p class="fig">
								<img src="data:image/jpeg;base64,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"  width="100%">
							</p>
							</div>
							
						</div>
						<div class="col-md-6" style="margin-left:200px">
							<p><b> <h3>
							
							Як знизити ризик виникнення небажаних реакцій?
							
							</h3></b>
							</p>
							
							
						<hr>
						<h5>Уточніть у свого лікаря:</h5>
							<ul style="margin-left:50px">
								<li>показання до призначення даного препарату саме Вам;</li>
								<li>який терапевтичний ефект і в які терміни очікується;</li>
							   <li>як треба контролювати прийом препарату;</li>
								<li>коли відвідати лікаря для контролю стану;</li>
								<li>як і коли препарат може бути відмінений;</li>
								<li>які перші ознаки виникнення відомих побічних ефектів. </li>
							</ul>
						<hr>
						<h5>Повідомте лікаря, якщо:</h5>
						<ul style="margin-left:50px">
							<li>у Вас є супутні захворювання</li>
							<li>Ви постійно приймаєте будь-які препарати;</li>
							<li>в минулому були випадки алергічних реакцій;</li>
							<li>
							раніше Ви переносили побічні дії лікарських препаратів.
					Уважно і дбайливо ведіть свою медичну документацію, де повинна зберігатися вся інформація про
					 Ваш стан здоров'я, результати обстеження, консультаціях фахівців, можливу непереносимість 
					 деяких препаратів. Це допоможе лікарю з підібрати препарат саме Вам
							</li>
							<li>
							уважно вивчіть інструкцію до препарату;
							</li>
							<li>
							дотримуйтеся режиму прийому;
							</li>
							<li> уникайте прийому препаратів з доведеним несприятливим взаємодією.</li>
							</ul>
							
						<h5>До групи ризику щодо виникнення побічних ефектів становлять:</h5>	
							<ul style="margin-left:50px">
								<li>люди похилого та старечого віку;</li>
								<li>вагітні жінки, недоношені діти;</li>
								<li>пацієнти з тяжкими захворюваннями печінки, нирок, крові, нервової системи, тропічними захворюваннями, СНІД;</li>
								<li>пацієнти що приймають більше 4 препаратів одночасно</li>
								<li>одночасно лікують декілька захворювань;	</li>
								<li>отримують тривалі курси терапії. </li>
							</ul>
							<br>
							<br>
						<p><b><h4>   Уникайте самолікування. Будьте уважні до свого здоров'я і при появі нових ознак погіршення самопочуття зверніться за консультацією до лікаря.   </h4></b></p>
					</div>	
			</div>	
				
			
			<hr>    