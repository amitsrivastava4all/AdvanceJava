<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="id" type="java.lang.String" %>
<input type="text" id="${id}"/>
<script>
$(function() {
    $( "#${id}" ).datepicker({
      showWeek: true,
      firstDay: 1
    });
  });
</script>
  