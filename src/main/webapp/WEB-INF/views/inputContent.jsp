<!-- Content -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/inputContent">{{ 'Input' | translate }} {{ 'Content' | translate
				}} </a>&nbsp; <i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ 'Input' | translate }} {{ 'Content' | translate }}</h2>
	</div>
</section>

<section class="content">
	<div class="container">
			<form name="inputContent">
				<div class="row" >
					<div class="table-responsive">
						<table class="table borderless " align="center">
							<tbody >
								<td class="bold">{{ 'Content_Name' | translate
									}}</td>
								<td><input type="text" name="ContentName" 
										ng-model='request_contentName' id="ContentName"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'Content_ImageUrl' | translate
									}}</td>
								<td><input type="text" name="ImageUrl" 
										ng-model='request_imageUrl' id="ImageUrl"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'Content_NewsId' | translate
									}}</td>
								<td><input type="text" name="NewsId" 
										ng-model='request_newsId' id="NewsId"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'Content_PassionCode' | translate
									}}</td>
								<td><input type="text" name="PassionCode" 
										ng-model='request_passionCode' id="PassionCode"
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