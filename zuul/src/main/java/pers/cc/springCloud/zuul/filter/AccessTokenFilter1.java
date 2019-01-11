package pers.cc.springCloud.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AccessTokenFilter1 extends ZuulFilter {
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		Object accessToken = request.getParameter("accessToken");
		System.out.println("accessToken1:" + accessToken);
		if (accessToken == null || "zuul".equals(accessToken)) {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 2;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
