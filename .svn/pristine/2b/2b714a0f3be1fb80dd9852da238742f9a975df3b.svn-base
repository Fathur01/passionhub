<!-- count login -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/viewActivity">{{ 'Activity' | translate }} </a>&nbsp;
			<i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ "Activity" | translate }}</h2>
	</div>
</section>

<section class="content login">
	<div class="container">
		<div ng-show="activityListSrc != null">
			<div class="clear clearfix"></div>
			<div class="table-responsive desktopScreen">
				<table class="table table-bordered table-striped"
					st-table="activityList" st-safe-src="activityListSrc">
					<thead>
						<tr>
							<th st-sort="activityId" style="text-align:center">{{ 'Activity_Id' |
								translate }}</th>
							<th st-sort="activityDesc" style="text-align:center">{{ 'Activity_Desc' |
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
						<tr class="bold" ng-repeat="activityList in activityList">
							<!-- <td align='right'>{{ activityList.no | number}}</td> -->
							<td align='right'>{{ activityList.activityId}}</td>
							<td align='right'>{{ activityList.activityDesc}}</td>
							<td align='right'>{{ activityList.createUserId}}</td>
							<td align='right'>{{ activityList.createDate | date:"dd-MMM-yyyy"  || "N/A" }}</td>
							<td align='right'>{{ activityList.updateUserId}}</td>
							<td align='right'>{{ activityList.updateDate | date:"dd-MMM-yyyy"  || "N/A" }}</td>
						</tr>
						<tr ng-if="activityList.length == 0">
							<td colspan="7" style="text-align:center">{{ 'PassionEmptyMessage' | translate
								}}</td>
						</tr>

					</tbody>
					<tfoot>
						<tr ng-if="activityList.length != 0">
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
					st-table="activityList" st-safe-src="activityListSrc">
					<tbody>
						<tr ng-repeat="activityList in activityList">
							<td>
								<table width="100%">
									<tr>
										<th>{{ 'Activity_Id' | translate }}</th>
										<td>{{ activityList.activityId}}</td>
									</tr>
									<tr>
										<th>{{ 'Activity_Desc' | translate }}</th>
										<td>{{ activityList.activityDesc }}</td>
									</tr>
									<tr>
										<th>{{ 'CreateUserId' | translate }}</th>
										<td>{{ activityList.createUserId}}</td>
									</tr>
																		<tr>
										<th>{{ 'CreateDate' | translate }}</th>
										<td>{{activityList.createDate | date:"dd-MMM-yyyy"  || "N/A"  }}</td>
									</tr>
									<tr>
										<th>{{ 'UpdateUserId' | translate }}</th>
										<td>{{ activityList.updateUserId }}</td>
									</tr>
									<tr>
										<th>{{ 'UpdateDate' | translate }}</th>
										<td>{{ activityList.updateDate | date:"dd-MMM-yyyy"  || "N/A"  }}</td>
									</tr>
									
								</table>
							</td>
						</tr>
						<tr ng-if="activityList.length == 0">
							<td colspan="7" style="text-align:center">{{ 'PassionEmptyMessage' | translate
								}}</td>
						</tr>
					</tbody>
					<tfoot>
						<tr ng-if="activityList.length != 0">
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