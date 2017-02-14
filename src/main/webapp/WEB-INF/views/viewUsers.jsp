<!-- count login -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/viewUsers">{{ 'Users' | translate }} </a>&nbsp;
			<i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ "Users" | translate }}</h2>
	</div>
</section>

<section class="content login">
	<div class="container">
		<div ng-show="usersListSrc != null">
			<div class="clear clearfix"></div>
			<div class="table-responsive desktopScreen">
				<table class="table table-bordered table-striped"
					st-table="usersList" st-safe-src="usersListSrc">
					<thead>
						<tr>
							<th st-sort="id" style="text-align:center">{{ 'Users_IdNo' |
								translate }}</th>
							<th st-sort="userId" style="text-align:center">{{ 'Users_Id' |
								translate }}</th>
							<th st-sort="roleCode" style="text-align:center">{{ 'Users_RoleCode' |
								translate }}</th>
							<th st-sort="status" style="text-align:center">{{ 'Users_Status' |
								translate }}</th>
							<th st-sort="createUserId" style="text-align:center">{{ 'CreateUserId' |
								translate }}</th>
							<th st-sort="createDate" style="text-align:center">{{ 'CreateDate' |
								translate }}</th>
							<th st-sort="updateUserId" style="text-align:center">{{ 'UpdateUserId' | translate
								}}</th>
							<th st-sort="updateDate" style="text-align:center">{{ 'UpdateDate' | translate
								}}</th>
						</tr>
					</thead>
					<tbody>
						<tr class="bold" ng-repeat="usersList in usersList">
							<!-- <td align='right'>{{ usersList.no | number}}</td> -->
							<td align='right'>{{ usersList.id}}</td>
							<td align='right'>{{ usersList.userId}}</td>
							<td align='right'>{{ usersList.roleCode}}</td>
							<td align='right'>{{ usersList.status}}</td>
							<td align='right'>{{ usersList.createUserId}}</td>
							<td align='right'>{{ usersList.createDate | date:"dd-MMM-yyyy"  || "N/A" }}</td>
							<td align='right'>{{ usersList.updateUserId}}</td>
							<td align='right'>{{ usersList.updateDate | date:"dd-MMM-yyyy"  || "N/A" }}</td>
						</tr>
						<tr ng-if="usersList.length == 0">
							<td colspan="7" style="text-align:center">{{ 'PassionEmptyMessage' | translate
								}}</td>
						</tr>

					</tbody>
					<tfoot>
						<tr ng-if="usersList.length != 0">
							<td colspan="12" class="text-center">
								<div st-items-by-page="10" st-pagination=""
									st-template="pagination.custom.html"></div>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
			<div class="table-responsive mobileScreen">
				<table class="table table-bordered table-striped"
					st-table="usersList" st-safe-src="usersListSrc">
					<tbody>
						<tr ng-repeat="usersList in usersList">
							<td>
								<table width="100%">
									<tr>
										<th>{{ 'Users_IdNo' | translate }}</th>
										<td>{{ usersList.id}}</td>
									</tr>
									<tr>
										<th>{{ 'Users_Id' | translate }}</th>
										<td>{{ usersList.userId }}</td>
									</tr>
									<tr>
										<th>{{ 'Users_RoleCode' | translate }}</th>
										<td>{{ usersList.roleCode }}</td>
									</tr>
									<tr>
										<th>{{ 'Users_Status' | translate }}</th>
										<td>{{ usersList.status }}</td>
									</tr>
									<tr>
										<th>{{ 'CreateUserId' | translate }}</th>
										<td>{{ usersList.createUserId}}</td>
									</tr>
																		<tr>
										<th>{{ 'CreateDate' | translate }}</th>
										<td>{{usersList.createDate | date:"dd-MMM-yyyy"  || "N/A"  }}</td>
									</tr>
									<tr>
										<th>{{ 'UpdateUserId' | translate }}</th>
										<td>{{ usersList.updateUserId }}</td>
									</tr>
									<tr>
										<th>{{ 'UpdateDate' | translate }}</th>
										<td>{{ usersList.updateDate | date:"dd-MMM-yyyy"  || "N/A"  }}</td>
									</tr>
									
								</table>
							</td>
						</tr>
						<tr ng-if="usersList.length == 0">
							<td colspan="7" style="text-align:center">{{ 'PassionEmptyMessage' | translate
								}}</td>
						</tr>
					</tbody>
					<tfoot>
						<tr ng-if="usersList.length != 0">
							<td colspan="8" class="text-center">
								<div st-items-by-page="10" st-pagination=""></div>
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</section>