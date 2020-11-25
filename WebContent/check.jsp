<script type="text/javascript">

function validateForm() {
	  var x = document.forms["myForm"]["fname"].value;
	  if (x == "") {
	    alert("Name must be filled out");
	    return false;
	  }
	}

</script >

<form name="myForm" action="/action_page.php" onsubmit="return validateForm()" method="post" required>
  Name: <input type="text" name="fname">
  <input type="submit" value="Submit">
</form>