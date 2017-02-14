<!-- count login -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/viewTrBalance">{{ 'TrBalance' | translate }} </a>&nbsp;
			<i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ "TrBalance" | translate }}</h2>
	</div>
</section>

<section class="content login">
	<div class="container">
		<div ng-show="trBalanceListSrc != null">
			<div class="clear clearfix"></div>
			<div class="table-responsive desktopScreen">
				<table class="table table-bordered table-striped"
					st-table="trBalanceList" st-safe-src="trBalanceListSrc">
					<thead>
						<tr>
							<th st-sort="trBalanceId" style="text-align:center">{{ 'TrBalance_Id' |
								translate }}</th>
							<th st-sort="balance" style="text-align:center">{{ 'TrBalance_Balance' |
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
						<tr class="bold" ng-repeat="trBalanceList in trBalanceList">
							<!-- <td align='right'>{{ trBalanceList.no | number}}</td> -->
							<td align='right'>{{ trBalanceList.balanceId}}</td>
							<td align='right'>{{ trBalanceList.balance}}</td>
							<td align='right'>{{ trBalanceList.createUserId}}</td>
							<td align='right'>{{ trBalanceList.createDate | date:"dd-MMM-yyyy"  || "N/A" }}</td>
							<td align='right'>{{ trBalanceList.updateUserId}}</td>
							<td align='right'>{{ trBalanceList.updateDate | date:"dd-MMM-yyyy"  || "N/A" }}</td>
						</tr>
						<tr ng-if="trBalanceList.length == 0">
							<td colspan="7" style="text-align:center">{{ 'PassionEmptyMessage' | translate
								}}</td>
						</tr>

					</tbody>
					<tfoot>
						<tr ng-if="trBalanceList.length != 0">
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
					st-table="trBalanceList" st-safe-src="trBalanceListSrc">
					<tbody>
						<tr ng-repeat="trBalanceList in trBalanceList">
							<td>
								<table width="100%">
									<tr>
										<th>{{ 'TrBalance_Id' | translate }}</th>
										<td>{{ trBalanceList.balanceId}}</td>
									</tr>
									<tr>
										<th>{{ 'TrBalance_Balance' | translate }}</th>
										<td>{{ trBalanceList.balance }}</td>
									</tr>
									<tr>
										<th>{{ 'CreateUserId' | translate }}</th>
										<td>{{ trBalanceList.createUserId}}</td>
									</tr>
																		<tr>
										<th>{{ 'CreateDate' | translate }}</th>
										<td>{{trBalanceList.createDate | date:"dd-MMM-yyyy"  || "N/A"  }}</td>
									</tr>
									<tr>
										<th>{{ 'UpdateUserId' | translate }}</th>
										<td>{{ trBalanceList.updateUserId }}</td>
									</tr>
									<tr>
										<th>{{ 'UpdateDate' | translate }}</th>
										<td>{{ trBalanceList.updateDate | date:"dd-MMM-yyyy"  || "N/A"  }}</td>
									</tr>
									
								</table>
							</td>
						</tr>
						<tr ng-if="trBalanceList.length == 0">
							<td colspan="7" style="text-align:center">{{ 'PassionEmptyMessage' | translate
								}}</td>
						</tr>
					</tbody>
					<tfoot>
						<tr ng-if="trBalanceList.length != 0">
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