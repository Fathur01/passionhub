<!-- Content -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/inputTrRedeem">{{ 'Input' | translate }} {{ 'TrRedeem' | translate
				}} </a>&nbsp; <i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ 'Input' | translate }} {{ 'TrRedeem' | translate }}</h2>
	</div>
</section>

<section class="content">
	<div class="container">
			<form name="inputTrRedeem">
				<div class="row" >
					<div class="table-responsive">
						<table class="table borderless " align="center">
							<tbody >
								<td class="bold">{{ 'TrRedeem_Date' | translate
									}}</td>
								<td><input type="text" name="TrRedeemDate" 
										ng-model='request_trRedeemDate' id="TrRedeemDate"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'TrRedeem_GiftId' | translate
									}}</td>
								<td><input type="text" name="TrRedeemGiftId" 
										ng-model='request_trRedeemGiftId' id="TrRedeemGiftId"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'TrRedeem_Point' | translate
									}}</td>
								<td><input type="text" name="TrRedeemPoint" 
										ng-model='request_trRedeemPoint' id="TrRedeemPoint"
										value="" required>
										</textarea></td>	
								<td class="bold">{{ 'TrRedeem_BalanceId' | translate
									}}</td>
								<td><input type="text" name="TrRedeemBalanceId" 
										ng-model='request_trRedeemBalanceId' id="TrRedeemBalanceId"
										value="" required>
										</textarea></td>	
								<tr>
								<td class="bold">{{ 'TrRedeem_HistoryId' | translate
									}}</td>
								<td><input type="text" name="TrRedeemHistoryId" 
										ng-model='request_trRedeemHistoryId' id="TrRedeemHistoryId"
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