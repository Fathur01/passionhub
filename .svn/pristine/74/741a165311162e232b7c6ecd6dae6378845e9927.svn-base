<!-- Content -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/inputMember">{{ 'Input' | translate }} {{ 'Member' |
				translate }} </a>&nbsp; <i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ 'Input' | translate }} {{ 'Member' | translate }}</h2>
	</div>
</section>

<section class="content">
	<div class="container">
		<form name="inputMember">
			<div class="row">
				<div class="table-responsive">
					<table class="table borderless " align="center">
						<tbody>
							<td class="bold">{{ 'Member_FirstName' | translate }}</td>
							<td><input type="text" name="FirstName"
								ng-model='request_firstName' id="FirstName" value="" max = "50" required>
								</textarea></td>
							<td class="bold">{{ 'Member_MiddleName' | translate }}</td>
							<td><input type="text" name="MiddleName"
								ng-model='request_middleName' id="MiddleName" value="" max = "50" required>
								</textarea></td>
							<td class="bold">{{ 'Member_LastName' | translate }}</td>
							<td><input type="text" name="LastName"
								ng-model='request_lastName' id="LastName" value="" max = "50" required>
								</textarea></td>
							<tr>
								<td class="bold">{{ 'Member_SurveyDate' | translate }}</td>
								<!-- date picker -->
								<td><input type="text" class="datepicker-default"
									name="SurveyDate" id="surveyDate"
									ng-model="request_surveyDate"
									datepicker-popup="{{datePicker.format}}" maxlength="10"
									placeholder="" datepicker-options="datePicker.options"
									is-open="datePicker.instances['SurveyDate']" close-text="Close" />

									<button type="button" class=""
										ng-click="datePicker.open($event, 'SurveyDate')">
										<i class="glyphicon glyphicon-calendar"></i>
									</button></td>
									
								<td class="bold">{{ 'Member_Email' | translate }}</td>
								<td><input type="text" name="Email"
									ng-model='request_email' id="Email" value="" max = "100" required>
									</textarea></td>
								<td class="bold">{{ 'Member_Address' | translate }}</td>
								<td><input type="text" name="Address"
									ng-model='request_address' id="Address" value="" max = "100" required>
									</textarea></td>
							<tr>
								<td class="bold">{{ 'Member_MobileNo' | translate }}</td>
								<td><input type="number" name="MobileNo"
									ng-model='request_mobileNo' id="MobileNo" value="" required>
									</textarea></td>

								<td class="bold">{{ 'Member_EntryDate' | translate }}</td>
								<!-- date picker -->
								<td><input type="text" class="datepicker-default"
									name="EntryDate" id="request_entryDate"
									ng-model="request_entryDate"
									datepicker-popup="{{datePicker.format}}" maxlength="10"
									placeholder="" datepicker-options="datePicker.options"
									is-open="datePicker.instances['EntryDate']" close-text="Close" />

									<button type="button" class=""
										ng-click="datePicker.open($event, 'EntryDate')">
										<i class="glyphicon glyphicon-calendar"></i>
									</button></td>
									
								<td class="bold">{{ 'Member_DOB' | translate }}</td>
								<!-- date picker -->
								<td><input type="text" class="datepicker-default"
									name="DOB" id="request_dOB" ng-model="request_dOB"
									datepicker-popup="{{datePicker.format}}" maxlength="10"
									placeholder="" datepicker-options="datePicker.options"
									is-open="datePicker.instances['DOB']" close-text="Close" />

									<button type="button" class=""
										ng-click="datePicker.open($event, 'DOB')">
										<i class="glyphicon glyphicon-calendar"></i>
									</button></td>
							<tr>
								<td class="bold">{{ 'Member_IsPolicyHolder' | translate }}</td> 
								<td><input type="checkbox" ng-model='request_isPolicyHolder' id="IsPolicyHolder" value="1">
								<!-- <input type="text" name="IsPolicyHolder"
									ng-model='request_isPolicyHolder' id="IsPolicyHolder" value=""
									required> </textarea> --></td>
								
								<td class="bold">{{ 'Member_IsEmployee' | translate }}</td>
								<td><input type="text" name="IsEmployee"
									ng-model='request_isEmployee' id="IsEmployee" value="" required>
									</textarea></td>
								<td class="bold">{{ 'Member_IsAgent' | translate }}</td>
								<td><input type="text" name="IsAgent"
									ng-model='request_isAgent' id="IsAgent" value="" required>
									</textarea></td>
							<tr>
								<td class="bold">{{ 'Member_GroupCode' | translate }}</td>
								<td><input type="text" name="GroupCode"
									ng-model='request_groupCode' id="GroupCode" value="" required>
									</textarea></td>
								<td class="bold">{{ 'Member_IsCorpCare' | translate }}</td>
								<td><input type="text" name="IsCorpCare"
									ng-model='request_isCorpCare' id="IsCorpCare" value="" required>
									</textarea></td>
								<td class="bold">{{ 'Member_ClientCode' | translate }}</td>
								<td><input type="text" name="ClientCode"
									ng-model='request_clientCode' id="ClientCode" value="" required>
									</textarea></td>
							<tr>
								<td class="bold">{{ 'Member_AgentCode' | translate }}</td>
								<td><input type="text" name="AgentCode"
									ng-model='request_agentCode' id="AgentCode" value="" required>
									</textarea></td>
																
								<td class="bold">{{ 'Member_Status' | translate }}</td>
								<td><input type="text" name="MemberStatus"
									ng-model='request_memberStatus' id="MemberStatus" value=""
									required> </textarea></td>

									<td class="bold">{{ "Member_serIdFk" | translate
										}}</td>
									<td>
										<select ng-model="request_userDrop"
											ng-options="users.key as users.value for users in UserDropList "
											id="UserIdFk" class="form-control">

										</select>
									</td>

								<!-- <td class="bold">{{ 'Member_serIdFk' | translate }}</td>
								<td><input type="text" name="UserIdFk"
									ng-model='request_userIdFk' id="UserIdFk" value="" required>
									</textarea></td> -->
<tr>
								<td class="bold">{{ 'Member_Password' | translate }}</td>
								<td><input type="text" name="Password"
									ng-model='request_password' id="Password" value="" required>
									</textarea></td>
						</tbody>
					</table>
				</div>

			</div>
			<div class="text-right">
				<button type="submit" ng-click="submit()"
					class="btn-primary bg-biru-light">{{ 'Input' | translate
					}}</button>
			</div>
		</form>

		<div class="enter clearfix"></div>
	</div>
</section>