package pers.cc.springCloud.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AccessTokenFilter extends ZuulFilter {
	// run：过滤器的具体逻辑。
	// 通过ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由，
	// 然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码，
	// 也可以进一步优化比如，通过ctx.setResponseBody(body)对返回body内容进行编辑等。
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		Object accessToken = request.getParameter("accessToken");
		System.out.println("accessToken:" + accessToken);
		if (accessToken == null) {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}
		return null;
	}

	// shouldFilter：判断该过滤器是否需要被执行。
	// true表示该过滤器对所有请求都会生效。
	// 实际运用中我们可以利用该函数来指定过滤器的有效范围。
	@Override
	public boolean shouldFilter() {
		return true;
	}

	// filterOrder：过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
	@Override
	public int filterOrder() {
		return 0;
	}

	// filterType：过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。
	// pre：可以在请求被路由之前调用
	// route：在路由请求时候被调用
	// post：在route和error过滤器之后被调用
	// error：处理请求时发生错误时被调用
	@Override
	public String filterType() {
		return "pre";
	}

}
