<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
<jsp:include page="/common/page/header.jsp"/> 
<link href="common/js/conquer/assets/css/pages/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="logo" class="center">
    <img src="common/js/conquer/assets/img/logo.png" alt="logo" class="center" /> 
  </div>
  <!-- END LOGO -->
  <!-- BEGIN LOGIN -->
  <div id="login">
    <!-- BEGIN LOGIN FORM -->
    <form id="loginform" action="admin/login!login.action" method="post" class="form-vertical no-padding no-margin" >
      <p class="center">Enter your username and password.</p>
      <div class="control-group">
        <div class="controls">
          <div class="input-prepend">
            <span class="add-on"><i class="icon-user"></i></span><input id="input-username" name="user.userName" type="text" placeholder="Username" />
          </div>
        </div>
      </div>
      <div class="control-group">
        <div class="controls">
          <div class="input-prepend">
            <span class="add-on"><i class="icon-lock"></i></span><input id="input-password" name="user.password" type="password" placeholder="Password" />
          </div>
        </div>
      </div>
      <div class="control-group remember-me">
        <div class="controls">
          <label class="checkbox">
          <input type="checkbox" name="remember" value="1"/> Remember me
          </label>
          <a href="javascript:;" class="pull-right" id="forget-password">Forgot Password?</a>
        </div>
      </div>
      <input type="submit" id="login-btn" class="btn btn-block btn-inverse" value="Login" />
    </form>
    <!-- END LOGIN FORM -->        
    <!-- BEGIN FORGOT PASSWORD FORM -->
    <form id="forgotform" class="form-vertical no-padding no-margin hide" action="index.html">
      <p class="center">Enter your e-mail address below to reset your password.</p>
      <div class="control-group">
        <div class="controls">
          <div class="input-prepend">
            <span class="add-on"><i class="icon-envelope"></i></span><input id="input-email" type="text" placeholder="Email" />
          </div>
        </div>
        <div class="space10"></div>
      </div>
      <input type="button" id="forget-btn" class="btn btn-block btn-inverse" value="Submit" />
    </form>
    <!-- END FORGOT PASSWORD FORM -->
  </div>
  <!-- END LOGIN -->
  <!-- BEGIN COPYRIGHT -->
  <div id="login-copyright">
    2013 &copy; Conquer. Admin Dashboard Template.
  </div>
  <!-- END COPYRIGHT -->
  <jsp:include page="/common/page/footer.jsp"/> 
 <script src="common/js/conquer/assets/scripts/login.js"></script>
    <!-- BEGIN CORE PLUGINS -->
   <script>
    jQuery(document).ready(function() {  
      // initiate layout and plugins
      App.init();
      Login.init();
    });
  </script>
  <!-- END JAVASCRIPTS -->
<!--   <script type="text/javascript">
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-37564768-1']);
  _gaq.push(['_setDomainName', 'keenthemes.com']);
  _gaq.push(['_setAllowLinker', true]);
  _gaq.push(['_trackPageview']);
  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script> -->
</body>
</html>