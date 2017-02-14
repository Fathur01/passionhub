<!-- Content -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/inputPoint">{{ 'Input' | translate }} {{ 'Point' | translate
				}} </a>&nbsp; <i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ 'Input' | translate }} {{ 'Point' | translate }}</h2>
	</div>
</section>

<section class="content">
	<div class="container">
			<form name="inputPoint">
				<div class="row" >
					<div class="table-responsive">
						<table class="table borderless " align="center">
							<tbody >
								<td class="bold">{{ 'Point_ActivityId' | translate
									}}</td>
								<td><input type="text" name="ActivityId" 
										ng-model='request_activityId' id="ActivityId"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'Point_Point' | translate
									}}</td>
								<td><input type="text" name="Point" 
										ng-model='request_point' id="Point"
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