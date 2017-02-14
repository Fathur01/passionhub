<!-- Content -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/inputUsers">{{ 'Input' | translate }} {{ 'Users' | translate
				}} </a>&nbsp; <i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ 'Input' | translate }} {{ 'Users' | translate }}</h2>
	</div>
</section>

<section class="content">
	<div class="container">
			<form name="inputUsers">
				<div class="row" >
					<div class="table-responsive">
						<table class="table borderless " align="center">
							<tbody >
								<td class="bold">{{ 'Users_Id' | translate
									}}</td>
								<td><input type="text" name="UserId" 
										ng-model='request_userId' id="UserId"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'Users_RoleCode' | translate
									}}</td>
								<td><input type="text" name="UsersRoleCode" 
										ng-model='request_roleCode' id="UsersRoleCode"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'Users_Status' | translate
									}}</td>
								<td><input type="text" name="UsersStatus" 
										ng-model='request_status' id="UsersStatus"
										value="" required>
										</textarea></td>								
							</tbody>
						</table>
					</div>

				</div>
				<div class="text-right">
					<button type="submit" ng-click="submit()" class="btn-primary bg-biru-light">{{
						'Input' | translate }}</button>
				</div>
			</form>

		<div class="enter clearfix"></div>
	</div>
</section>