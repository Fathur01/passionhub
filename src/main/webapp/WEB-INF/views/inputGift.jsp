<!-- Content -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/inputGift">{{ 'Input' | translate }} {{ 'Gift' | translate
				}} </a>&nbsp; <i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ 'Input' | translate }} {{ 'Gift' | translate }}</h2>
	</div>
</section>

<section class="content">
	<div class="container">
			<form name="inputGift">
				<div class="row" >
					<div class="table-responsive">
						<table class="table borderless " align="center">
							<tbody >
								<td class="bold">{{ 'Gift_Name' | translate
									}}</td>
								<td><input type="text" name="GiftName" 
										ng-model='request_giftName' id="GiftName"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'Gift_Desc' | translate
									}}</td>
								<td><input type="text" name="GiftDesc" 
										ng-model='request_giftDesc' id="GiftDesc"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'Gift_Point' | translate
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