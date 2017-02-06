package mt.edu.um.cs.rv.demo.valour.external_triggers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;

import mt.edu.um.cs.rv.eventmanager.observers.ExternalEventObserver;

@Component
public class SpringMVCInterceptorExternalTrigger extends ExternalEventObserver<String, OnSuccessfulLoginTriggerData, Boolean> implements HandlerInterceptor {

	private static final String LOGIN = "/login/";
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String uri = request.getRequestURI();
		if (uri.startsWith(LOGIN)){
			String username = UriUtils.decode(uri, "UTF-8").replaceFirst(LOGIN, "");
			this.onMessage(username);
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//do nothing here
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//do nothing here	
	}
	
	
	@Override
	public OnSuccessfulLoginTriggerData generateTrigger(String username) {
		return new OnSuccessfulLoginTriggerData(username);
	}

	@Override
	public Boolean generateResponse(String m, OnSuccessfulLoginTriggerData t) {
		//TODO should this be expanded?
		return true;
	}

	@Override
	public void sendResponse(Boolean r) {
		//TODO nothing to do here at this point
	}
	
}
