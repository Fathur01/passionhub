<!-- Content -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/inputTrBalance">{{ 'Input' | translate }} {{ 'TrBalance' | translate
				}} </a>&nbsp; <i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ 'Input' | translate }} {{ 'TrBalance' | translate }}</h2>
	</div>
</section>

<section class="content">
	<div class="container">
			<form name="inputTrBalance">
				<div class="row" >
					<div class="table-responsive">
						<table class="table borderless " align="center">
							<tbody >
								<td class="bold">{{ 'TrBalance_Balance' | translate
									}}</td>
								<td><input type="text" name="Balance" 
										ng-model='request_balance' id="Balance"
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