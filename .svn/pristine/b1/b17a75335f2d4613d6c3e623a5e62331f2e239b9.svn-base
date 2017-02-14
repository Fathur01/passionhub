<!-- count login -->
<section class="content login">
	<div class="container">
		<div class="breadcrumb">
			<a href="#/uploadAffinityMoment">{{ 'upload_affinity' | translate
				}} </a>&nbsp; <i class="fa fa-caret-right"></i>
		</div>
		<h2>{{ "upload_affinity" | translate }}</h2>
	</div>
</section>

<section class="content login">
	<div class="container">
		<center>
			<input type="file" class="affinity-upload" ngf-select="choiceFiles()" 
				ng-model="picFile" name="file"
				accept="image/jpg,image/jpeg,image/png,application/pdf"></input>
			<button class="affinity-upload" ng-show="submitShow"
				ng-click="uploadFiles('affinity', picFile)" 
				id="files" name="affinity"
				accept="image/jpg,image/jpeg,image/png,application/pdf">{{
				(submitFileMap['affinity'] != null ? submitFileMap['affinity'] :
				"upload_affinity") | translate }}</button>
		</center>
	</div>
</section>