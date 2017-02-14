<!-- count login -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/viewContent">{{ 'Content' | translate }} </a>&nbsp;
			<i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ "Content" | translate }}</h2>
	</div>
</section>

<section class="content login">
	<div class="container">
		<div ng-show="contentListSrc != null">
			<div class="clear clearfix"></div>
			<div class="table-responsive desktopScreen">
				<table class="table table-bordered table-striped"
					st-table="contentList" st-safe-src="contentListSrc">
					<thead>
						<tr>
							<th st-sort="contentId" style="text-align:center">{{ 'ContentId' |
								translate }}</th>
							<th st-sort="contentName" style="text-align:center">{{ 'ContentName' |
								translate }}</th>
							<th st-sort="ImageUrl" style="text-align:center">{{ 'ImageUrl' |
								translate }}</th>
							<th st-sort="NewsId" style="text-align:center">{{ 'NewsId' |
								translate }}</th>
							<th st-sort="PassionCode" style="text-align:center">{{ 'PassionCode' |
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
						<tr class="bold" ng-repeat="contentList in contentList">
							<!-- <td align='right'>{{ contentList.no | number}}</td> -->
							<td align='right'>{{ contentList.contentId}}</td>
							<td align='right'>{{ contentList.contentName}}</td>
							<td align='right'>{{ contentList.imageUrl}}</td>
							<td align='right'>{{ contentList.newsId}}</td>
							<td align='right'>{{ contentList.passionCode}}</td>
							<td align='right'>{{ contentList.createUserId}}</td>
							<td align='right'>{{ contentList.createDate | date:"dd-MMM-yyyy"  || "N/A" }}</td>
							<td align='right'>{{ contentList.updateUserId}}</td>
							<td align='right'>{{ contentList.updateDate | date:"dd-MMM-yyyy"  || "N/A" }}</td>
						</tr>
						<tr ng-if="contentList.length == 0">
							<td colspan="7" style="text-align:center">{{ 'PassionEmptyMessage' | translate
								}}</td>
						</tr>

					</tbody>
					<tfoot>
						<tr ng-if="contentList.length != 0">
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
					st-table="contentList" st-safe-src="contentListSrc">
					<tbody>
						<tr ng-repeat="contentList in contentList">
							<td>
								<table width="100%">
									<tr>
										<th>{{ 'contentId' | translate }}</th>
										<td>{{ contentList.contentId}}</td>
									</tr>
									<tr>
										<th>{{ 'contentName' | translate }}</th>
										<td>{{ contentList.contentName }}</td>
									</tr>
									<tr>
										<th>{{ 'imageUrl' | translate }}</th>
										<td>{{ contentList.imageUrl }}</td>
									</tr>
									<tr>
										<th>{{ 'newsId' | translate }}</th>
										<td>{{ contentList.newsId }}</td>
									</tr>
									<tr>
										<th>{{ 'passionCode' | translate }}</th>
										<td>{{ contentList.passionCode }}</td>
									</tr>
									<tr>
										<th>{{ 'CreateUserId' | translate }}</th>
										<td>{{ contentList.createUserId}}</td>
									</tr>
																		<tr>
										<th>{{ 'CreateDate' | translate }}</th>
										<td>{{contentList.createDate | date:"dd-MMM-yyyy"  || "N/A"  }}</td>
									</tr>
									<tr>
										<th>{{ 'UpdateUserId' | translate }}</th>
										<td>{{ contentList.updateUserId }}</td>
									</tr>
									<tr>
										<th>{{ 'UpdateDate' | translate }}</th>
										<td>{{ contentList.updateDate | date:"dd-MMM-yyyy"  || "N/A"  }}</td>
									</tr>
									
								</table>
							</td>
						</tr>
						<tr ng-if="contentList.length == 0">
							<td colspan="7" style="text-align:center">{{ 'PassionEmptyMessage' | translate
								}}</td>
						</tr>
					</tbody>
					<tfoot>
						<tr ng-if="contentList.length != 0">
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