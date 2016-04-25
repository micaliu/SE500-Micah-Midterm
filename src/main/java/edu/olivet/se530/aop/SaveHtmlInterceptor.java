package edu.olivet.se530.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.jsoup.nodes.Document;

import java.io.File;

/**
 * 保存亚马逊网页到本地文件夹，方便后续跟踪和排查问题
 * <a href="mailto:nathanaelibport@gmail.com">Nathanael Yang</a> Jan 21, 2015 10:30:59 AM
 */
public class SaveHtmlInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = invocation.proceed();
        Object[] arguments = invocation.getArguments();
        if (!(result instanceof Document) || ArrayUtils.isEmpty(arguments) || arguments.length < 2) {
            return result;
        }

        Document doc = (Document) result;
        String isbn = arguments[0].toString();
		String cond = arguments[1].toString();
		FileUtils.writeStringToFile(new File("webpages", isbn + "_" + cond + ".html"), doc.html(), "UTF-8");
		return doc;
	}
	
}