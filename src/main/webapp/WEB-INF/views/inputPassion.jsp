<!-- Content -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/inputPassion">{{ 'Input' | translate }} {{ 'Passion' | translate
				}} </a>&nbsp; <i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ 'Input' | translate }} {{ 'Passion' | translate }}</h2>
	</div>
</section>

<section class="content">
	<div class="container">
			<form name="inputPassion">
				<div class="row" >
					<div class="table-responsive">
						<table class="table borderless " align="center">
							<tbody >
								<td class="bold">{{ 'Passion_Code' | translate
									}}</td>
								<td><input type="text" name="PassionCode" 
										ng-model='request_passionCode' id="PassionCode"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'Passion_Desc' | translate
									}}</td>
								<td><input type="text" name="PassionDesc" 
										ng-model='request_passionDesc' id="PassionDesc"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'Passion_Type' | translate
									}}</td>
								<td><input type="text" name="PassionType" 
										ng-model='request_passionType' id="PassionType"
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