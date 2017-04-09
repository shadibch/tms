<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Welcome</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->

<script type="text/javascript" language="javascript"
	src="//code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />




<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</script>

</head>
<body>
	<h2>Tasks</h2>
	<div style="float: right">
		<button id="newButton" class="btn btn-primary active">New
			Task</button>
	</div>
	<div>
		<table id="tasks" class="table">
			<thead>

				<tr>
					<th><input type="text" id="token" name="token"
						placeholder="Search Name" /></th>
					<th></th>
					<th></th>
					<th><select id="statusfilter" name="statusfilter"
						class="updateable">
							<option value="empty">----Status----</option>
							<c:forEach items="${states}" var="status">
								<option value="${status}">${status}</option>
							</c:forEach>
					</select></th>
					<th></th>

				</tr>
			</thead>
			<thead class="thead-default">
				<tr>
					<th>Name</th>
					<th>Cubic Feet</th>
					<th>Moving Date</th>
					<th>Status</th>
					<th></th>

				</tr>
			</thead>

			<tbody>
				<c:forEach items="${tasks.content}" var="task">
					<tr id=${task.id } class="${task.status}">
						<td>${task.name}</td>
						<td>${task.cubicFeet}</td>
						<td>${task.movingDate}</td>
						<td>${task.status}</td>
						<td><button class="btn edit">Edit</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h2 style="float: right;">Page 1 of ${tasks.totalPages}</h2>
	</div>
	<div id="createupdate" style="display: none;">
		<input type="hidden" name="id" id="id" value="0" />
		<fieldset>
			<div class="control-group">
				<label class="control-label" for="titile">Title :*</label>
				<div class="controls">
					<select id="titile" name="titile">
						<c:forEach items="${titles}" var="title">
							<option>${title}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="firstName">First Name :*</label>
				<div class="controls">
					<input id="firstName" name="firstName" type="text"
						class="form-control" /> <span id="firstName.errors"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="lastName">Last Name :*</label>
				<div class="controls">
					<input id="lastName" name="lastName" class="form-control"
						type="text" /> <span id="lastName.errors"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="movingDate">Moving Date :*</label>
				<div class="controls">
					<input id="movingDate" name="movingDate" class="form-control"
						type="text" /> <span id="movingDate.errors"></span>
					<script type="text/javascript">
						$("#movingDate").datepicker({
							dateFormat : "yy-mm-dd"
						});
					</script>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="status">Status :*</label>
				<div class="controls">
					<select name="status" class="form-control" id="status">

						<c:forEach items="${states}" var="status">
							<option>${status}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="cubicFeet">Cubic Foot :*</label>
				<div class="controls">
					<input id="cubicFeet" name="cubicFeet" class="form-control"
						type="number" /> <span id="cubicFeet.errors"></span>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="notes">Notes :</label>

				<textarea rows="8" class="form-control" cols="40" id="notes"
					name="notes"></textarea>

			</div>
			<button type="button" id="addremove" class="btn btn-primary active">+</button>
			<div style="display: none;" id="address">
			<div class="control-group">
				<label class="control-label" for="addresLineOne">Address Line One :*</label>
				<div class="controls">
					<input id="addresLineOne" name="address.addresLineOne" class="form-control"
						type="text" /> <span id="address.addresLineOne.errors"></span>
				</div>
			</div>
			</div>
			<button type="button" id="save" class="btn btn-primary active">Save</button>
			<button type="button" class="btn">Close</button>


		</fieldset>
	</div>
	<script>
	$("#addremove").click(function(){
		if($(this).text() == '+') {
			$("#address").show();
			$(this).text("-");
		}else {
			$("#address").hide();
			$(this).text("+");
		}
	});
		$("#newButton").click(function() {
			$("#id").val(0);
			$("#address").hide();
			$(this).text("+");
			$("#createupdate input").each(function() {
				$(this).val("");
			});
			$("#createupdate #address input").each(function() {
				$(this).val("");
			});
			$("#createupdate select").each(function() {
				$(this).prop('selectedIndex', 0);

			});
			$("#createupdate textarea").each(function() {
				$(this).val("");
			});
			$("#createupdate").dialog({
				title : "Save"
			});
		});

		$("#save").click(function() {

			saveData();
		});
		function saveData() {
			var data = {};
			$("#createupdate input:visible").each(function() {
				var key = $(this).attr("name");
				
				data[$(this).attr("name")] = $(this).val();
				
			});
			$("#createupdate #address input:visible").each(function() {
				var key = $(this).attr("name");
				if(data["address"] == undefined) {
					data["address"] = {};
				}
				data["address"][$(this).attr("name")] = $(this).val();
				
			});
			$("#createupdate select").each(function() {
				data[$(this).attr("name")] = $(this).val();
			});
			$("#createupdate textarea").each(function() {
				data[$(this).attr("name")] = $(this).val();
			});
			var data = JSON.stringify(data);
			$.ajax({
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				},
				url : 'task/save',
				type : "post",
				data : data,
				dataType : "json",
				success : function(data_) {
					$(".alert").remove();
					if (data_.length > 0 && data_[0]["codes"] != 'undefined') {
						var html = "";
						$(data_).each(
								function() {
									error($(this)[0].field + " "
											+ $(this)[0].defaultMessage);
								});

					} else {
						$("#id").val(data_.id);
						$('#createupdate').dialog('close');
						inform("Item saved successfully");
						refreshTable();
					}

				}

			});
		}
		function inform(msg) {
			var al = $("<div class=\"alert alert-success\">");
			$(al)
					.append(
							$(" <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>"));
			$(al).append(msg);
			$("body").prepend(al);
		}
		function error(msg) {
			var al = $("<div class=\"alert alert-danger fade in\">");
			$(al)
					.append(
							$(" <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>"));
			$(al).append(msg);
			$("body").prepend(al);
		}
		$(".edit").click(function() {
			var id = $(this).parent("td").parent("tr").attr("id");
			edit(id);

		});
		function edit(id) {

			$.get("task/get/" + id, function(obj) {

				$("#createupdate input").each(function() {
					var key = $(this).attr("name");
					$(this).val(obj[key]);
				});
				$("#createupdate select").each(function() {
					var key = $(this).attr("name");
					$(this).val(obj[key]);
				});
				$("#createupdate textarea").each(function() {
					var key = $(this).attr("name");
					$(this).val(obj[key]);
				});
				$("#createupdate").dialog({
					title : "Save"
				});
			});
		}
		$(".updateable").change(function() {
			refreshTable();
		});
		function refreshTable() {

			var url = buildUrl();
			$
					.get(
							url,
							function(data) {
								$("#tasks tbody tr").remove();
								$(data.content)
										.each(
												function(i, d) {
													var tr = $("<tr> </tr>");
													$(tr).attr("id", d.id);
													$(tr).attr("class",
															d.status);
													var td = $("<td> </td>");
													$(td).text(d.name);
													$(tr).append(td);
													td = $("<td> </td>");
													$(td).text(d.cubicFeet);
													$(tr).append(td);
													td = $("<td> </td>");
													$(td).text(d.movingDate);
													$(tr).append(td);
													td = $("<td> </td>");
													$(td).text(d.status);
													$(tr).append(td);
													td = $("<td> </td>");
													var button = $("<button class=\"btn edit\" >Edit</button>");
													$(button)
															.click(
																	function() {
																		var id = $(
																				this)
																				.parent(
																						"td")
																				.parent(
																						"tr")
																				.attr(
																						"id");
																		edit(id);

																	});
													$(td).html(button);
													$(tr).append(td);
													$("#tasks").find("tbody")
															.append(tr);

												});
							});

		}

		function buildUrl() {
			var url = "task/find";
			var status = $("#statusfilter").val();
			var qm = false;
			if (status != 'empty') {
				url += '?statusfilter=' + status;
				qm = true;
			}
			var token = $("#token").val();
			if (token) {
				url += qm ? ("&token=" + token) : ("?token=" + token);
			}
			return url;

		}
		$("#token").keyup(function() {
			refreshTable();
		});
	</script>
</body>
</html>

