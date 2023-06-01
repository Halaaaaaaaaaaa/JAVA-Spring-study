<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Demo 1</title>
		<meta name="description" content="Background scale animation as seen on DDD Hotel." />
		<meta name="keywords" content="clip-path, animation, scale, effect, background, hover" />
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../images/favicon.ico">
		<link rel="stylesheet" href="https://use.typekit.net/cze1cgq.css">
		<link rel="stylesheet" type="text/css" href="css/shopping.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.26/webfont.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/gsap@3.11/dist/gsap.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.7.1/gsap.min.js"></script>
		<script src="https://unpkg.com/imagesloaded@5/imagesloaded.pkgd.min.js"></script>
		<script>document.documentElement.className="js";var supportsCssVars=function(){var e,t=document.createElement("style");return t.innerHTML="root: { --tmp-var: bold; }",document.head.appendChild(t),e=!!(window.CSS&&window.CSS.supports&&window.CSS.supports("font-weight","var(--tmp-var)")),t.parentNode.removeChild(t),e};supportsCssVars()||alert("Please view this demo in a modern browser that supports CSS Variables.");</script>
	
	
	
	<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
	
	
	
	</head>
<body class="demo-1 loading">
	<main> 
	
	<nav role="navigation">
		<div id="menuToggle">
			<input type="checkbox" />
			<span></span>
			<span></span>
			<span></span>
			<ul id="menu">
				<a href="index"><li>Home</li></a>
				<a href="#"><li>About</li></a>
				<a href="#"><li>Info</li></a>
				<a href="#"><li>Contact</li></a>
				<a href="https://erikterwan.com/" target="_blank"><li>Show me more</li></a>
			</ul>
		</div>
	</nav>
	
  		<div class="frame">
				<h1 class="frame__pagetitle">11ty</h1>
				<dl class="frame__header frame__header--grid">
					<dt>topic: </dt><dd>11ty conferences</dd>
					<dt>year: </dt><dd>2020</dd>
					<dt>title: </dt><dd>Background Scale Hover Effect</dd>
					<dt>links: </dt><dd>[<a href="https://tympanus.net/Development/DistortedLinkEffects/">previous demo</a>, <a href="https://tympanus.net/codrops/?p=48414">article</a>, <a href="https://github.com/codrops/BackgroundScaleHoverEffect/">github</a>]</dd>
				</dl>
		</div>
		
		<div class="screens" aria-hidden="true">
			<div class="screen__item" style="--bg-img:url(../images/1.jpg);">
				<div class="screen screen--full"></div>
				<div class="screen screen--clip screen--clip-1"></div>
			</div>
			<div class="screen__item" style="--bg-img:url(../images/2.jpg);">
				<div class="screen screen--full"></div>
				<div class="screen screen--clip screen--clip-1"></div>
			</div>
			<div class="screen__item" style="--bg-img:url(../images/3.jpg);">
				<div class="screen screen--full"></div>
				<div class="screen screen--clip screen--clip-1"></div>
			</div>
			<div class="screen__item" style="--bg-img:url(../images/4.jpg);">
				<div class="screen screen--full"></div>
				<div class="screen screen--clip screen--clip-1"></div>
			</div>
		</div>
		
		<div class="content">
			<nav class="menu">
				<span class="menu__item" href="#">
					<span class="menu__item-tag">March, 26</span>
					<a class="menu__item-link">Manila</a>
				</span>
				<span class="menu__item" href="#">
					<span class="menu__item-tag">April, 12</span>
					<a class="menu__item-link">Jakarta</a>
				</span><br/>
				<span class="menu__item" href="#">
					<span class="menu__item-tag">June, 10</span>
					<a class="menu__item-link">Bangkok</a>
				</span>
				<span class="menu__item" href="#">
					<span class="menu__item-tag">September, 17</span>
					<a class="menu__item-link">Hanoi</a>
				</span>
			</nav>
		</div>
    
	</main>
	<script src="js/index.js" type="module"></script>
</body>
</html> 