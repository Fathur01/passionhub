package com.fwd.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.fwd.connector.PassionHubConnector;
import com.fwd.model.passion.Activity;
import com.fwd.model.passion.Content;
import com.fwd.model.passion.Gift;
import com.fwd.model.passion.History;
import com.fwd.model.passion.Member;
import com.fwd.model.passion.News;
import com.fwd.model.passion.TPassion;
import com.fwd.model.passion.TPoint;
import com.fwd.model.passion.TrBalance;
import com.fwd.model.passion.TrPoint;
import com.fwd.model.passion.TrRedeem;
import com.fwd.model.passion.Users;
import com.fwd.service.ActivityService;
import com.fwd.service.ContentService;
import com.fwd.service.GiftService;
import com.fwd.service.HistoryService;
import com.fwd.service.MemberService;
import com.fwd.service.NewsService;
import com.fwd.service.PassionService;
import com.fwd.service.PointService;
import com.fwd.service.TrBalanceService;
import com.fwd.service.TrPointService;
import com.fwd.service.TrRedeemService;
import com.fwd.service.UsersService;
import com.fwd.util.DateUtils;
import com.fwd.ws.request.ActivityRequest;
import com.fwd.ws.request.ContentRequest;
import com.fwd.ws.request.GiftRequest;
import com.fwd.ws.request.HistoryRequest;
import com.fwd.ws.request.MemberLoginRequest;
import com.fwd.ws.request.MemberRequest;
import com.fwd.ws.request.MemberValidateRequest;
import com.fwd.ws.request.NewsRequest;
import com.fwd.ws.request.PassionRequest;
import com.fwd.ws.request.PointRequest;
import com.fwd.ws.request.TrBalanceRequest;
import com.fwd.ws.request.TrPointRequest;
import com.fwd.ws.request.TrRedeemRequest;
import com.fwd.ws.request.UsersRequest;
import com.fwd.ws.response.ActivityCreateResponse;
import com.fwd.ws.response.ActivityResponse;
import com.fwd.ws.response.ContentCreateResponse;
import com.fwd.ws.response.ContentResponse;
import com.fwd.ws.response.DropdownItem;
import com.fwd.ws.response.DropdownListResponse;
import com.fwd.ws.response.GiftCreateResponse;
import com.fwd.ws.response.GiftResponse;
import com.fwd.ws.response.HistoryCreateResponse;
import com.fwd.ws.response.HistoryResponse;
import com.fwd.ws.response.MemberCreateResponse;
import com.fwd.ws.response.MemberLoginResponse;
import com.fwd.ws.response.MemberResponse;
import com.fwd.ws.response.MemberValidateResponse;
import com.fwd.ws.response.NewsCreateResponse;
import com.fwd.ws.response.NewsResponse;
import com.fwd.ws.response.PassionCreateResponse;
import com.fwd.ws.response.PassionResponse;
import com.fwd.ws.response.PointCreateResponse;
import com.fwd.ws.response.PointResponse;
import com.fwd.ws.response.TrBalanceCreateResponse;
import com.fwd.ws.response.TrBalanceResponse;
import com.fwd.ws.response.TrPointCreateResponse;
import com.fwd.ws.response.TrPointResponse;
import com.fwd.ws.response.TrRedeemCreateResponse;
import com.fwd.ws.response.TrRedeemResponse;
import com.fwd.ws.response.UsersCreateResponse;
import com.fwd.ws.response.UsersResponse;
import com.fwd.ws.response.WebServiceResponse;

@RestController
public class MainWebServiceWrapperImpl extends BaseWebServiceWrapperImpl {
	private final static Logger logger = LoggerFactory.getLogger(MainWebServiceWrapperImpl.class);
	
	@SuppressWarnings("unused")
	@Autowired
	private WebServiceEndPointSetting setting;
		
	@Autowired protected PassionHubConnector connector;
	
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private GiftService giftService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private PassionService passionService;
	
	@Autowired
	private PointService pointService;
	
	@Autowired
	private TrBalanceService trBalanceService;
	
	@Autowired
	private TrPointService trPointService;
	
	@Autowired
	private TrRedeemService trRedeemService;
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value="/user/validate", method=RequestMethod.POST, consumes="application/json")
	public WebServiceResponse validate(
			HttpServletRequest httpRequest,
			@RequestBody MemberValidateRequest request) throws Exception {
		
		WebServiceResponse error = new WebServiceResponse();
		MemberValidateResponse response = connector.validateMemberInfo(request, this.newHttpHeaders(httpRequest), error);		
		if(response == null){
			return error;
		}else{
			// username = null for before login
			this.updateSession(httpRequest.getSession(), response.getSessionToken(), null);
			
			return response;
		}
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST, consumes="application/json")
	public WebServiceResponse login(
			HttpServletRequest httpRequest,
			@RequestBody MemberLoginRequest request) throws Exception {

		WebServiceResponse error = new WebServiceResponse();
		MemberLoginResponse response = connector.loginMember(request, this.newHttpHeaders(httpRequest), error);
		if(response == null){
			error.setErrMsg("null");
			error.setStatus("false");
			return error;
		}else{
			// update session
			this.updateSession(httpRequest.getSession(), response.getSessionToken(), request.getUserName());			
			return response;
		}
	}
	    
    @RequestMapping("/user/token")
    public WebServiceResponse validateSessionKey (
    		HttpServletRequest httpRequest
			) throws com.fwd.ws.InvalidTokenException {
    	
		this.validateSessionToken(httpRequest);
		WebServiceResponse response = new WebServiceResponse();
		response.setStatus("ok");
		return response;

    }
    
    @RequestMapping("/user/logout")	
    public WebServiceResponse logout(
			HttpServletRequest httpRequest
			) throws com.fwd.ws.InvalidTokenException {
        
		validateSessionToken(httpRequest);

		this.clearSession(httpRequest.getSession());
			
		WebServiceResponse response = new WebServiceResponse();
		response.setStatus("ok");
		return response;

    } 
    
  	@RequestMapping(value = "/activity/view", method = RequestMethod.POST, consumes = "application/json" )
  	public WebServiceResponse viewActivity(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	

  			ActivityResponse responseActivity = new ActivityResponse();
  			
  			List<Activity> activityList;
			try {
				activityList = activityService.getAllActivity();
				responseActivity.setActivityList(activityList);
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
			}
  			
			try {
				
  				ResponseEntity<ActivityResponse> responseEntity = new ResponseEntity<ActivityResponse>(responseActivity,HttpStatus.OK);
  				return responseEntity.getBody();
  			} catch (HttpClientErrorException e) {
  				logger.error(ExceptionUtils.getStackTrace(e));
  				String errMsg = e.getCause() + e.getMessage();
  				ResponseEntity<WebServiceResponse> responseEntity = new ResponseEntity<WebServiceResponse>(responseActivity,HttpStatus.OK);
  				responseEntity.getBody().setErrMsg(errMsg);
  				return responseEntity.getBody();
  			}

  	}
  	
  	@RequestMapping(value = "/activity/save", method = RequestMethod.POST, consumes = "application/json" )
  	public ActivityCreateResponse saveActivity(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language,
  			@RequestBody ActivityRequest request) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	
  			Activity activity = new Activity();
  			ActivityCreateResponse responseActivity = new ActivityCreateResponse();  			
			try {
				activity.setActivityDesc(request.getActivityDesc());
				activity.setActivityDesc(request.getActivityDesc());
				activity.setCreateDate(new Date());
				activity.setCreateUserId(userName);
				activity.setUpdateDate(new Date());
				activity.setUpdateUserId(userName);
				
				activity=activityService.saveActivity(activity);
				responseActivity.setActivity(activity);

				responseActivity.setStatus("ok");
				return responseActivity;				
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
  				String errMsg = e1.getCause() + e1.getMessage();
  				responseActivity.setStatus("error");
  				responseActivity.setErrMsg(errMsg);
  				return responseActivity;
			}

  	}
  	
  	@RequestMapping(value = "/content/view", method = RequestMethod.POST, consumes = "application/json" )
  	public WebServiceResponse viewContent(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	

  			ContentResponse responseContent = new ContentResponse();
  			
  			List<Content> contentList;
			try {
				contentList = contentService.getAllContent();
				responseContent.setContentList(contentList);
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
			}
  			
			try {
				
  				ResponseEntity<ContentResponse> responseEntity = new ResponseEntity<ContentResponse>(responseContent,HttpStatus.OK);
  				return responseEntity.getBody();
  			} catch (HttpClientErrorException e) {
  				logger.error(ExceptionUtils.getStackTrace(e));
  				String errMsg = e.getCause() + e.getMessage();
  				ResponseEntity<WebServiceResponse> responseEntity = new ResponseEntity<WebServiceResponse>(responseContent,HttpStatus.OK);
  				responseEntity.getBody().setErrMsg(errMsg);
  				return responseEntity.getBody();
  			}

  	}
  	
  	@RequestMapping(value = "/content/save", method = RequestMethod.POST, consumes = "application/json" )
  	public ContentCreateResponse saveContent(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language,
  			@RequestBody ContentRequest request) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	
  			Content content = new Content();
  			ContentCreateResponse responseContent = new ContentCreateResponse();  			
			try {
				content.setContentName(request.getContentName());
				content.setCreateDate(new Date());
				content.setCreateUserId(userName);
				content.setImageUrl(request.getImageUrl());/*
				content.setNewsId(request.getNewsId());
				content.setPassionCode(request.getPassionCode());*/
				content.setUpdateDate(new Date());
				content.setUpdateUserId(userName);
				
				content=contentService.saveContent(content);
				responseContent.setContent(content);

				responseContent.setStatus("ok");
				return responseContent;				
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
  				String errMsg = e1.getCause() + e1.getMessage();
  				responseContent.setStatus("error");
  				responseContent.setErrMsg(errMsg);
  				return responseContent;
			}

  	}
  	@RequestMapping(value = "/gift/view", method = RequestMethod.POST, consumes = "application/json" )
  	public WebServiceResponse viewGift(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	

  			GiftResponse responseGift = new GiftResponse();
  			
  			List<Gift> giftList;
			try {
				giftList = giftService.getAllGift();
				responseGift.setGiftList(giftList);
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
			}
  			
			try {
				
  				ResponseEntity<GiftResponse> responseEntity = new ResponseEntity<GiftResponse>(responseGift,HttpStatus.OK);
  				return responseEntity.getBody();
  			} catch (HttpClientErrorException e) {
  				logger.error(ExceptionUtils.getStackTrace(e));
  				String errMsg = e.getCause() + e.getMessage();
  				ResponseEntity<WebServiceResponse> responseEntity = new ResponseEntity<WebServiceResponse>(responseGift,HttpStatus.OK);
  				responseEntity.getBody().setErrMsg(errMsg);
  				return responseEntity.getBody();
  			}

  	}
  	
  	@RequestMapping(value = "/gift/save", method = RequestMethod.POST, consumes = "application/json" )
  	public GiftCreateResponse saveGift(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language,
  			@RequestBody GiftRequest request) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	
  			Gift gift = new Gift();
  			GiftCreateResponse responseGift = new GiftCreateResponse();  			
			try {
				gift.setCreateDate(new Date());
				gift.setCreateUserId(userName);
				gift.setGiftDesc(request.getGiftDesc());
				gift.setGiftName(request.getGiftName());/*
				gift.setPoint(request.getPoint());*/
				gift.setUpdateDate(new Date());
				gift.setUpdateUserId(userName);
				
				gift=giftService.saveGift(gift);
				responseGift.setGift(gift);

				responseGift.setStatus("ok");
				return responseGift;				
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
  				String errMsg = e1.getCause() + e1.getMessage();
  				responseGift.setStatus("error");
  				responseGift.setErrMsg(errMsg);
  				return responseGift;
			}

  	}
  	@RequestMapping(value = "/history/view", method = RequestMethod.POST, consumes = "application/json" )
  	public WebServiceResponse viewHistory(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	

  			HistoryResponse responseHistory = new HistoryResponse();
  			
  			List<History> historyList;
			try {
				historyList = historyService.getAllHistory();
				responseHistory.setHistoryList(historyList);
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
			}
  			
			try {
				
  				ResponseEntity<HistoryResponse> responseEntity = new ResponseEntity<HistoryResponse>(responseHistory,HttpStatus.OK);
  				return responseEntity.getBody();
  			} catch (HttpClientErrorException e) {
  				logger.error(ExceptionUtils.getStackTrace(e));
  				String errMsg = e.getCause() + e.getMessage();
  				ResponseEntity<WebServiceResponse> responseEntity = new ResponseEntity<WebServiceResponse>(responseHistory,HttpStatus.OK);
  				responseEntity.getBody().setErrMsg(errMsg);
  				return responseEntity.getBody();
  			}

  	}
  	
  	@RequestMapping(value = "/history/save", method = RequestMethod.POST, consumes = "application/json" )
  	public HistoryCreateResponse saveHistory(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language,
  			@RequestBody HistoryRequest request) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	
  			History history = new History();
  			HistoryCreateResponse responseHistory = new HistoryCreateResponse();  			
			try {
				history.setCollectPoint(request.getCollectPoint());
				history.setCreateDate(new Date());
				history.setCreateUserId(userName);
				history.setDescriptiion(request.getDescriptiion());
				history.setLastPoint(request.getLastPoint());
				history.setPointUse(request.getPointUse());
				history.setStartPoint(request.getStartPoint());
				history.setUpdateDate(new Date());
				history.setUpdateUserId(userName);
				
				history=historyService.saveHistory(history);
				responseHistory.setHistory(history);

				responseHistory.setStatus("ok");
				return responseHistory;				
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
  				String errMsg = e1.getCause() + e1.getMessage();
  				responseHistory.setStatus("error");
  				responseHistory.setErrMsg(errMsg);
  				return responseHistory;
			}

  	}
  	@RequestMapping(value = "/member/view", method = RequestMethod.POST, consumes = "application/json" )
  	public WebServiceResponse viewMember(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	

  			MemberResponse responseMember = new MemberResponse();
  			
  			List<Member> memberList;
			try {
				memberList = memberService.getAllMember();
				responseMember.setMemberList(memberList);
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
			}
  			
			try {
				
  				ResponseEntity<MemberResponse> responseEntity = new ResponseEntity<MemberResponse>(responseMember,HttpStatus.OK);
  				return responseEntity.getBody();
  			} catch (HttpClientErrorException e) {
  				logger.error(ExceptionUtils.getStackTrace(e));
  				String errMsg = e.getCause() + e.getMessage();
  				ResponseEntity<WebServiceResponse> responseEntity = new ResponseEntity<WebServiceResponse>(responseMember,HttpStatus.OK);
  				responseEntity.getBody().setErrMsg(errMsg);
  				return responseEntity.getBody();
  			}

  	}
  	
  	@RequestMapping(value = "/member/save", method = RequestMethod.POST, consumes = "application/json" )
  	public MemberCreateResponse saveMember(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language,
  			@RequestBody MemberRequest request) throws com.fwd.ws.InvalidTokenException 
  	{
  			
  			validateSessionToken(session, userName, token);  	
  			Member member = new Member();
  			MemberCreateResponse responseMember = new MemberCreateResponse();  			
			try {
				member.setAddress(request.getAddress());
				member.setAgentCode(request.getAgentCode());
				member.setClientCode(request.getClientCode());
				member.setDOB(DateUtils.toDate(request.getdOB()));
				member.setEmail(request.getEmail());
				member.setEntryDate(DateUtils.toDate(request.getEntryDate()));
				member.setFirstName(request.getFirstName());
				member.setGroupCode(request.getGroupCode());
				member.setIsAgent(request.getIsAgent());
				member.setIsCorpCare(request.getIsCorpCare());
				member.setIsEmployee(request.getIsEmployee());
				member.setIsPolicyHolder(request.getIsPolicyHolder());
				member.setLastName(request.getLastName());
				member.setMemberStatus(request.getMemberStatus());
				member.setMiddleName(request.getMiddleName());
				member.setMobileNo(Integer.valueOf(request.getMobileNo()));
				member.setPassword(request.getPassword());
				member.setSurveyDate(DateUtils.toDate(request.getSurveyDate()));
				member.setUseridFk(Integer.valueOf(request.getUseridFk()));
				
				member=memberService.saveMember(member);
				responseMember.setMember(member);

				responseMember.setStatus("ok");
				return responseMember;				
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
  				String errMsg = e1.getCause() + e1.getMessage();
  				responseMember.setStatus("error");
  				responseMember.setErrMsg(errMsg);
  				return responseMember;
			}

  	}
  	@RequestMapping(value = "/news/view", method = RequestMethod.POST, consumes = "application/json" )
  	public WebServiceResponse viewNews(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	

  			NewsResponse responseNews = new NewsResponse();
  			
  			List<News> newsList;
			try {
				newsList = newsService.getAllNews();
				responseNews.setNewsList(newsList);
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
			}
  			
			try {
				
  				ResponseEntity<NewsResponse> responseEntity = new ResponseEntity<NewsResponse>(responseNews,HttpStatus.OK);
  				return responseEntity.getBody();
  			} catch (HttpClientErrorException e) {
  				logger.error(ExceptionUtils.getStackTrace(e));
  				String errMsg = e.getCause() + e.getMessage();
  				ResponseEntity<WebServiceResponse> responseEntity = new ResponseEntity<WebServiceResponse>(responseNews,HttpStatus.OK);
  				responseEntity.getBody().setErrMsg(errMsg);
  				return responseEntity.getBody();
  			}

  	}
  	
  	@RequestMapping(value = "/news/save", method = RequestMethod.POST, consumes = "application/json" )
  	public NewsCreateResponse saveNews(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language,
  			@RequestBody NewsRequest request) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	
  			News news = new News();
  			NewsCreateResponse responseNews = new NewsCreateResponse();  			
			try {/*
				news.setContentFk(request.getContentFk());*/
				news.setCreateDate(new Date());
				news.setCreateUserId(userName);
				news.setNewsContent(request.getNewsContent());
				news.setNewsTitle(request.getNewsTitle());
				news.setUpdateDate(new Date());
				news.setUpdateUserId(userName);				
				
				news=newsService.saveNews(news);
				responseNews.setNews(news);

				responseNews.setStatus("ok");
				return responseNews;				
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
  				String errMsg = e1.getCause() + e1.getMessage();
  				responseNews.setStatus("error");
  				responseNews.setErrMsg(errMsg);
  				return responseNews;
			}

  	}
  	@RequestMapping(value = "/passion/view", method = RequestMethod.POST, consumes = "application/json" )
  	public WebServiceResponse viewPassion(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	

  			PassionResponse responsePassion = new PassionResponse();
  			
  			List<TPassion> passionList;
			try {
				passionList = passionService.getAllPassion();
				responsePassion.setPassionList(passionList);
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
			}
  			
			try {
				
  				ResponseEntity<PassionResponse> responseEntity = new ResponseEntity<PassionResponse>(responsePassion,HttpStatus.OK);
  				return responseEntity.getBody();
  			} catch (HttpClientErrorException e) {
  				logger.error(ExceptionUtils.getStackTrace(e));
  				String errMsg = e.getCause() + e.getMessage();
  				ResponseEntity<WebServiceResponse> responseEntity = new ResponseEntity<WebServiceResponse>(responsePassion,HttpStatus.OK);
  				responseEntity.getBody().setErrMsg(errMsg);
  				return responseEntity.getBody();
  			}

  	}
  	
  	@RequestMapping(value = "/passion/save", method = RequestMethod.POST, consumes = "application/json" )
  	public PassionCreateResponse savePassion(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language,
  			@RequestBody PassionRequest request) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	
  			TPassion passion = new TPassion();
  			PassionCreateResponse responsePassion = new PassionCreateResponse();  			
			try {
				passion.setCreateDate(new Date());
				passion.setCreateUserId(userName);
				passion.setPassionCode(request.getPassionCode());
				passion.setPassionDesc(request.getPassionDesc());
				passion.setPassionType(request.getPassionType());
				passion.setUpdateDate(new Date());
				passion.setUpdateUserId(userName);
				
				passion=passionService.savePassion(passion);
				responsePassion.setPassion(passion);

				responsePassion.setStatus("ok");
				return responsePassion;				
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
  				String errMsg = e1.getCause() + e1.getMessage();
  				responsePassion.setStatus("error");
  				responsePassion.setErrMsg(errMsg);
  				return responsePassion;
			}

  	}
  	@RequestMapping(value = "/point/view", method = RequestMethod.POST, consumes = "application/json" )
  	public WebServiceResponse viewPoint(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	

  			PointResponse responsePoint = new PointResponse();
  			
  			List<TPoint> pointList;
			try {
				pointList = pointService.getAllPoint();
				responsePoint.setPointList(pointList);
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
			}
  			
			try {
				
  				ResponseEntity<PointResponse> responseEntity = new ResponseEntity<PointResponse>(responsePoint,HttpStatus.OK);
  				return responseEntity.getBody();
  			} catch (HttpClientErrorException e) {
  				logger.error(ExceptionUtils.getStackTrace(e));
  				String errMsg = e.getCause() + e.getMessage();
  				ResponseEntity<WebServiceResponse> responseEntity = new ResponseEntity<WebServiceResponse>(responsePoint,HttpStatus.OK);
  				responseEntity.getBody().setErrMsg(errMsg);
  				return responseEntity.getBody();
  			}

  	}
  	
  	@RequestMapping(value = "/point/save", method = RequestMethod.POST, consumes = "application/json" )
  	public PointCreateResponse savePoint(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language,
  			@RequestBody PointRequest request) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	
  			TPoint point = new TPoint();
  			PointCreateResponse responsePoint = new PointCreateResponse();  			
			try {/*
				point.setActivityId(request.getActivityId());*/
				point.setCreateDate(new Date());
				point.setCreateUserId(userName);
/*				point.setMsPointId(request.getMsPointId());*/
				point.setPoint(request.getPoint());
				point.setUpdateDate(new Date());
				point.setUpdateUserId(userName);
				
				point=pointService.savePoint(point);
				responsePoint.setPoint(point);

				responsePoint.setStatus("ok");
				return responsePoint;				
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
  				String errMsg = e1.getCause() + e1.getMessage();
  				responsePoint.setStatus("error");
  				responsePoint.setErrMsg(errMsg);
  				return responsePoint;
			}

  	}
  	@RequestMapping(value = "/trBalance/view", method = RequestMethod.POST, consumes = "application/json" )
  	public WebServiceResponse viewTrBalance(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	

  			TrBalanceResponse responseTrBalance = new TrBalanceResponse();
  			
  			List<TrBalance> trBalanceList;
			try {
				trBalanceList = trBalanceService.getAllTrBalance();
				responseTrBalance.setTrBalanceList(trBalanceList);
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
			}
  			
			try {
				
  				ResponseEntity<TrBalanceResponse> responseEntity = new ResponseEntity<TrBalanceResponse>(responseTrBalance,HttpStatus.OK);
  				return responseEntity.getBody();
  			} catch (HttpClientErrorException e) {
  				logger.error(ExceptionUtils.getStackTrace(e));
  				String errMsg = e.getCause() + e.getMessage();
  				ResponseEntity<WebServiceResponse> responseEntity = new ResponseEntity<WebServiceResponse>(responseTrBalance,HttpStatus.OK);
  				responseEntity.getBody().setErrMsg(errMsg);
  				return responseEntity.getBody();
  			}

  	}
  	
  	@RequestMapping(value = "/trBalance/save", method = RequestMethod.POST, consumes = "application/json" )
  	public TrBalanceCreateResponse saveTrBalance(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language,
  			@RequestBody TrBalanceRequest request) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	
  			TrBalance trBalance = new TrBalance();
  			TrBalanceCreateResponse responseTrBalance = new TrBalanceCreateResponse();  			
			try {
				trBalance.setBalance(request.getBalance());
				trBalance.setCreateDate(new Date());
				trBalance.setCreateUserId(userName);
				trBalance.setUpdateDate(new Date());
				trBalance.setUpdateUserId(userName);
				
				trBalance=trBalanceService.saveTrBalance(trBalance);
				responseTrBalance.setTrBalance(trBalance);

				responseTrBalance.setStatus("ok");
				return responseTrBalance;				
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
  				String errMsg = e1.getCause() + e1.getMessage();
  				responseTrBalance.setStatus("error");
  				responseTrBalance.setErrMsg(errMsg);
  				return responseTrBalance;
			}

  	}
  	@RequestMapping(value = "/trPoint/view", method = RequestMethod.POST, consumes = "application/json" )
  	public WebServiceResponse viewTrPoint(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	

  			TrPointResponse responseTrPoint = new TrPointResponse();
  			
  			List<TrPoint> trPointList;
			try {
				trPointList = trPointService.getAllTrPoint();
				responseTrPoint.setTrPointList(trPointList);
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
			}
  			
			try {
				
  				ResponseEntity<TrPointResponse> responseEntity = new ResponseEntity<TrPointResponse>(responseTrPoint,HttpStatus.OK);
  				return responseEntity.getBody();
  			} catch (HttpClientErrorException e) {
  				logger.error(ExceptionUtils.getStackTrace(e));
  				String errMsg = e.getCause() + e.getMessage();
  				ResponseEntity<WebServiceResponse> responseEntity = new ResponseEntity<WebServiceResponse>(responseTrPoint,HttpStatus.OK);
  				responseEntity.getBody().setErrMsg(errMsg);
  				return responseEntity.getBody();
  			}

  	}
  	
  	@RequestMapping(value = "/trPoint/save", method = RequestMethod.POST, consumes = "application/json" )
  	public TrPointCreateResponse saveTrPoint(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language,
  			@RequestBody TrPointRequest request) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	
  			TrPoint trPoint = new TrPoint();
  			TrPointCreateResponse responseTrPoint = new TrPointCreateResponse();  			
			try {
				trPoint.setActivityDate(request.getActivityDate());
				/*trPoint.setActivityId(request.getActivityId());*/
				trPoint.setCreateDate(new Date());
				trPoint.setCreateUserId(userName);
				trPoint.setPoint(request.getPoint());
				trPoint.setUpdateDate(new Date());
				trPoint.setUpdateUserId(userName);
				
				trPoint=trPointService.saveTrPoint(trPoint);
				responseTrPoint.setTrPoint(trPoint);

				responseTrPoint.setStatus("ok");
				return responseTrPoint;				
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
  				String errMsg = e1.getCause() + e1.getMessage();
  				responseTrPoint.setStatus("error");
  				responseTrPoint.setErrMsg(errMsg);
  				return responseTrPoint;
			}

  	}
  	@RequestMapping(value = "/trRedeem/view", method = RequestMethod.POST, consumes = "application/json" )
  	public WebServiceResponse viewTrRedeem(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	

  			TrRedeemResponse responseTrRedeem = new TrRedeemResponse();
  			
  			List<TrRedeem> trRedeemList;
			try {
				trRedeemList = trRedeemService.getAllTrRedeem();
				responseTrRedeem.setTrRedeemList(trRedeemList);
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
			}
  			
			try {
				
  				ResponseEntity<TrRedeemResponse> responseEntity = new ResponseEntity<TrRedeemResponse>(responseTrRedeem,HttpStatus.OK);
  				return responseEntity.getBody();
  			} catch (HttpClientErrorException e) {
  				logger.error(ExceptionUtils.getStackTrace(e));
  				String errMsg = e.getCause() + e.getMessage();
  				ResponseEntity<WebServiceResponse> responseEntity = new ResponseEntity<WebServiceResponse>(responseTrRedeem,HttpStatus.OK);
  				responseEntity.getBody().setErrMsg(errMsg);
  				return responseEntity.getBody();
  			}

  	}
  	
  	@RequestMapping(value = "/trRedeem/save", method = RequestMethod.POST, consumes = "application/json" )
  	public TrRedeemCreateResponse saveTrRedeem(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language,
  			@RequestBody TrRedeemRequest request) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	
  			TrRedeem trRedeem = new TrRedeem();
  			TrRedeemCreateResponse responseTrRedeem = new TrRedeemCreateResponse();  			
			try {
				
				/*trRedeem.setBalanceId(request.getBalanceId());*/
				trRedeem.setCreateDate(new Date());
				trRedeem.setCreateUserId(userName);
				/*trRedeem.setGiftId(request.getGiftId());*/
				/*trRedeem.setHistoryId(request.getHistoryId());*/
				trRedeem.setRedeemDate(request.getRedeemDate());
				trRedeem.setRedeemPoint(request.getRedeemPoint());
				trRedeem.setUpdateDate(new Date());
				trRedeem.setUpdateUserId(userName);
				
				trRedeem=trRedeemService.saveTrRedeem(trRedeem);
				responseTrRedeem.setTrRedeem(trRedeem);

				responseTrRedeem.setStatus("ok");
				return responseTrRedeem;				
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
  				String errMsg = e1.getCause() + e1.getMessage();
  				responseTrRedeem.setStatus("error");
  				responseTrRedeem.setErrMsg(errMsg);
  				return responseTrRedeem;
			}

  	}
  	@RequestMapping(value = "/users/view", method = RequestMethod.POST, consumes = "application/json" )
  	public WebServiceResponse viewUsers(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	

  			UsersResponse responseUsers = new UsersResponse();
  			
  			List<Users> usersList;
			try {
				usersList = usersService.getAllUsers();
				responseUsers.setUsersList(usersList);
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
			}
  			
			try {
				
  				ResponseEntity<UsersResponse> responseEntity = new ResponseEntity<UsersResponse>(responseUsers,HttpStatus.OK);
  				return responseEntity.getBody();
  			} catch (HttpClientErrorException e) {
  				logger.error(ExceptionUtils.getStackTrace(e));
  				String errMsg = e.getCause() + e.getMessage();
  				ResponseEntity<WebServiceResponse> responseEntity = new ResponseEntity<WebServiceResponse>(responseUsers,HttpStatus.OK);
  				responseEntity.getBody().setErrMsg(errMsg);
  				return responseEntity.getBody();
  			}

  	}
  	
  	@RequestMapping(value = "/users/save", method = RequestMethod.POST, consumes = "application/json" )
  	public UsersCreateResponse saveUsers(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language,
  			@RequestBody UsersRequest request) throws com.fwd.ws.InvalidTokenException 
  	{

  			validateSessionToken(session, userName, token);  	
  			Users users = new Users();
  			UsersCreateResponse responseUsers = new UsersCreateResponse();  			
			try {
				users.setCreateDate(new Date());
				users.setCreateUserId(userName);
				users.setRoleCode(request.getRoleCode());
				users.setStatus(request.getStatus());
				users.setUpdateDate(new Date());
				users.setUpdateUserId(userName);
				users.setUserId(request.getUserId());
				
				users=usersService.saveUsers(users);
				responseUsers.setUsers(users);

				responseUsers.setStatus("ok");
				return responseUsers;				
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
  				String errMsg = e1.getCause() + e1.getMessage();
  				responseUsers.setStatus("error");
  				responseUsers.setErrMsg(errMsg);
  				return responseUsers;
			}

  	}
  	
  	@RequestMapping(value = "/users/list", method = RequestMethod.POST, consumes = "application/json",produces = "application/json" )
  	public DropdownListResponse listUsers(
  			HttpSession session/*,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language*/) throws com.fwd.ws.InvalidTokenException 
  	{
  		
/*  			validateSessionToken(session, userName, token);*/
  			DropdownListResponse response = new DropdownListResponse();
  			
  			List<DropdownItem> usersList = new ArrayList<>();
			for (Users users : usersService.getAllUsers()) {
				System.out.println(String.valueOf(users.getId())+" "+users.getRoleCode());
				usersList.add(new DropdownItem(String.valueOf(users.getId()), users.getRoleCode()));  				
			}		
			response.setResultList(usersList);
			return response;

  	}

/*	@RequestMapping(value = "/affinity/upload", produces="application/json")
	public WebServiceResponse doUpload(
  			HttpSession session,
  			@RequestHeader(value="userName") String userName, 
  			@RequestHeader(value="token") String token,
  			@RequestHeader(value="language") String language,
			@Context HttpServletRequest request) throws IOException, ServletException 
	{
		
			
		String fileName = "";
		String documentID = "";
		Map<String, String> fieldMap = new HashMap<>();
		
		try {
			validateSessionToken(session, userName, token);  
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {
					// Process regular form field (input
					// type="text|radio|checkbox|etc", select, etc).
					String fieldName = item.getFieldName();
					String fieldValue = item.getString();
					fieldMap.put(fieldName, fieldValue);
				} else {
					// Process form file field (input type="file").
					fileName = FilenameUtils.getName(item.getName());

					documentID = fileName.substring(0,fileName.indexOf("."))+"_"+DateUtils.formatDate(new Date(),"dd-MM-yyyy")+"_"+DateUtils.formatDate(new Date(),"HHmmss")+"_"+UUID.randomUUID().toString()+fileName.substring(fileName.indexOf("."));
					
                    InputStream input = item.getInputStream();
                    byte[] buffer = new byte[8 * 1024];
                    try {
                    	  OutputStream output = new FileOutputStream(setting.getReportPath() + documentID);
                    	  try {
                    	    int bytesRead;
                    	    while ((bytesRead = input.read(buffer)) != -1) {
                    	      output.write(buffer, 0, bytesRead);
                    	    }
                    	  } finally {
                    	    output.close();
                    	  }
                    } finally {
                    	input.close();
                    }
					//InputStream input = item.getInputStream();
					//documentID = awplService.addDocIDCopy(IOUtils.toByteArray(input), fieldMap.get("ApplicaitonDate"), fieldMap.get("ApplicationNumber"), fieldMap.get("CaptureDate"), fieldMap.get("PolicyNumber"), fieldMap.get("ReceivedDate"));
				}
			}
		} catch (Exception e) {
			WebServiceResponse response = new WebServiceResponse();
			response.setStatus("error");
			response.setErrMsg("Cannot parse multipart request.");
			return response;
			//throw new ServletException("Cannot parse multipart request.", e);
			
		}

		UploadResponse response = new UploadResponse();
        response.setFileId(documentID);
        response.setFileName(fileName);
        return response;

		//return Response.status(HTTP_OK).entity("OK : " + documentID).build();
	}*/
	
}