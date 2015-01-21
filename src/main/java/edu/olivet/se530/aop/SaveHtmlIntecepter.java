package edu.olivet.se530.aop;

import java.io.File;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;

/**
 * 保存亚马逊网页到本地文件夹，方便后续跟踪和排查问题
 * <a href="mailto:nathanaelibport@gmail.com">Nathanael Yang</a> Jan 21, 2015 10:30:59 AM
 */
public class SaveHtmlIntecepter implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Document doc = (Document) invocation.proceed();
		String isbn = invocation.getArguments()[0].toString();
		String cond = invocation.getArguments()[1].toString();
		String dir = new File(StringUtils.EMPTY).getAbsolutePath() + File.separator + "webpages";
		FileUtils.writeStringToFile(new File(dir, isbn + "_" + cond + ".html"), doc.html(), "UTF-8");
		return doc;
	}
	
}