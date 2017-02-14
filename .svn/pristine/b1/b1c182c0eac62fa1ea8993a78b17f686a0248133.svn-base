<!-- count login -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/viewPassion">{{ 'Passion' | translate }} </a>&nbsp;
			<i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ "Passion" | translate }}</h2>
	</div>
</section>

<section class="content login">
	<div class="container">
		<div ng-show="passionListSrc != null">
			<div class="clear clearfix"></div>
			<div class="table-responsive desktopScreen">
				<table class="table table-bordered table-striped"
					st-table="passionList" st-safe-src="passionListSrc">
					<thead>
						<tr>
							<th st-sort="passionCode" style="text-align:center">{{ 'Passion_Code' |
								translate }}</th>
							<th st-sort="passionDesc" style="text-align:center">{{ 'Passion_Desc' |
								translate }}</th>
							<th st-sort="passionType" style="text-align:center">{{ 'Passion_Type' |
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
						<tr class="bold" ng-repeat="passionList in passionList">
							<!-- <td align='right'>{{ passionList.no | number}}</td> -->
							<td align='right'>{{ passionList.passionCode}}</td>
							<td align='right'>{{ passionList.passionDesc}}</td>
							<td align='right'>{{ passionList.passionType}}</td>
							<td align='right'>{{ passionList.createUserId}}</td>
							<td align='right'>{{ passionList.createDate | date:"dd-MMM-yyyy"  || "N/A" }}</td>
							<td align='right'>{{ passionList.updateUserId}}</td>
							<td align='right'>{{ passionList.updateDate | date:"dd-MMM-yyyy"  || "N/A" }}</td>
						</tr>
						<tr ng-if="passionList.length == 0">
							<td colspan="7" style="text-align:center">{{ 'PassionEmptyMessage' | translate
								}}</td>
						</tr>

					</tbody>
					<tfoot>
						<tr ng-if="passionList.length != 0">
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
					st-table="passionList" st-safe-src="passionListSrc">
					<tbody>
						<tr ng-repeat="passionList in passionList">
							<td>
								<table width="100%">
									<tr>
										<th>{{ 'Passion_Code' | translate }}</th>
										<td>{{ passionList.passionCode}}</td>
									</tr>
									<tr>
										<th>{{ 'Passion_Desc' | translate }}</th>
										<td>{{ passionList.passionDesc }}</td>
									</tr>
									<tr>
										<th>{{ 'Passion_Type' | translate }}</th>
										<td>{{ passionList.passionType }}</td>
									</tr>
									<tr>
										<th>{{ 'CreateUserId' | translate }}</th>
										<td>{{ passionList.createUserId}}</td>
									</tr>
																		<tr>
										<th>{{ 'CreateDate' | translate }}</th>
										<td>{{passionList.createDate | date:"dd-MMM-yyyy"  || "N/A"  }}</td>
									</tr>
									<tr>
										<th>{{ 'UpdateUserId' | translate }}</th>
										<td>{{ passionList.updateUserId }}</td>
									</tr>
									<tr>
										<th>{{ 'UpdateDate' | translate }}</th>
										<td>{{ passionList.updateDate | date:"dd-MMM-yyyy"  || "N/A"  }}</td>
									</tr>
									
								</table>
							</td>
						</tr>
						<tr ng-if="passionList.length == 0">
							<td colspan="7" style="text-align:center">{{ 'PassionEmptyMessage' | translate
								}}</td>
						</tr>
					</tbody>
					<tfoot>
						<tr ng-if="passionList.length != 0">
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