<!-- Content -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/inputHistory">{{ 'Input' | translate }} {{ 'History' | translate
				}} </a>&nbsp; <i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ 'Input' | translate }} {{ 'History' | translate }}</h2>
	</div>
</section>

<section class="content">
	<div class="container">
			<form name="inputHistory">
				<div class="row" >
					<div class="table-responsive">
						<table class="table borderless " align="center">
							<tbody >
								<td class="bold">{{ 'History_Desc' | translate
									}}</td>
								<td><input type="text" name="HistoryDesc" 
										ng-model='request_descriptiion' id="HistoryDesc"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'History_StartPoint' | translate
									}}</td>
								<td><input type="text" name="StartPoint" 
										ng-model='request_startPoint' id="StartPoint"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'History_CollectPoint' | translate
									}}</td>
								<td><input type="text" name="CollectPoint" 
										ng-model='request_collectPoint' id="CollectPoint"
										value="" required>
										</textarea></td>								
								<td class="bold">{{ 'History_PointUse' | translate
									}}</td>
								<td><input type="text" name="PointUse" 
										ng-model='request_pointUse' id="PointUse"
										value="" required>
										</textarea></td>
								<tr>
								<td class="bold">{{ 'History_LastPoint' | translate
									}}</td>
								<td><input type="text" name="LastPoint" 
										ng-model='request_lastPoint' id="LastPoint"
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