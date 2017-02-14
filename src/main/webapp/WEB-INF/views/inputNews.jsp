<!-- Content -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/inputNews">{{ 'Input' | translate }} {{ 'News' | translate
				}} </a>&nbsp; <i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ 'Input' | translate }} {{ 'News' | translate }}</h2>
	</div>
</section>

<section class="content">
	<div class="container">
			<form name="inputNews">
				<div class="row" >
					<div class="table-responsive">
						<table class="table borderless " align="center">
							<tbody >
								<td class="bold">{{ 'News_Title' | translate
									}}</td>
								<td><input type="text" name="NewsTitle" 
										ng-model='request_newsTitle' id="NewsTitle"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'News_Content' | translate
									}}</td>
								<td><input type="text" name="NewsContent" 
										ng-model='request_newsContent' id="NewsContent"
										value="" required>
										</textarea></td>
								<td class="bold">{{ 'News_ContentFk' | translate
									}}</td>
								<td><input type="text" name="ContentFk" 
										ng-model='request_contentFk' id="ContentFk"
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