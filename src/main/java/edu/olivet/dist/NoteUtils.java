package edu.olivet.dist;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.alibaba.fastjson.JSON;

public class NoteUtils {
	
	public static void main(String[] args) throws IOException {
		List<Release> releases = parseReleases();
		String json = JSON.toJSONString(releases, true);
		System.out.println(json);
		FileUtils.writeStringToFile(new File(SystemUtils.getUserHome() + "\\Desktop\\SE530", "releases.js"), json, "UTF-8");
	}

	public static List<Release> parseReleases() throws IOException {
		List<Release> result = new ArrayList<Release>();
		List<String> lines = IOUtils.readLines(NoteUtils.class.getResourceAsStream("/upgradehistory.txt"), "UTF-8");
		int i = 0;
		List<List<String>> releases = new ArrayList<List<String>>();
		int count = lines.size();
		int start = -1, end = -1;
		for (String s : lines) {
			if (s.startsWith("=================")) {
				if (start == -1) {
					start = i;
				} else {
					end = i;
				}
			}
			
			if (start != -1 && end != -1) {
				releases.add(lines.subList(start + 1, end));
				start = end;
				end = -1;
			} 
			i++;
		}
		
		if (start != -1) {
			releases.add(lines.subList(start + 1, count));
			start = end = -1;
		}
		
		for (Iterator<List<String>> iterator = releases.iterator(); iterator.hasNext();) {
			result.add(parseLines(iterator.next()));
		}
		
		return result;
	}

	public static Release parseLines(List<String> list) {
		Release release = new Release();
		Version ver = new Version();
		Note bugFix = new Note();
		
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String s = iterator.next();
			if (s.startsWith("版本：")) {
				if (ver.getMajorVersion() > 0) {
					continue;
				}
				
				String verCode = s.replace("版本：", StringUtils.EMPTY);
				String major = verCode.substring(0, verCode.indexOf('.'));
				ver.setMajorVersion(NumberUtils.toInt(major));
				String minor = verCode.substring(verCode.indexOf('.') + 1, verCode.indexOf('-'));
				ver.setMinorVersion(NumberUtils.toInt(minor));
				String patchNo = verCode.substring(verCode.lastIndexOf('.') + 1);
				ver.setPatchNo(NumberUtils.toInt(patchNo));
				String createDay = verCode.substring(verCode.indexOf('-') + 1, verCode.lastIndexOf('.'));
				try {
					ver.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").parse(createDay));
				} catch (ParseException e) {
					
				}
				
				continue;
			}
			
			if (s.startsWith("代号：")) {
				if (ver.getAlias() != null) {
					continue;
				}
				String alias = s.replace("代号：", StringUtils.EMPTY);
				ver.setAlias(alias);
				
				continue;
			}
			
			if (s.startsWith("更新内容")) {
				continue;
			}
			
			if (StringUtils.isNotBlank(s) && s.matches("[0-9]{1,2}[.][0-9]?.*")) {
				String content = s.replaceFirst("[0-9]{1,2}.[0-9]?", StringUtils.EMPTY).trim();
				if (content.startsWith("更新注意事项")) {
					break;
				}
				if (content.startsWith("新功能") || content.startsWith("增强、BUG修复及UI调整")) {
					continue;
				}
				bugFix.addContent(content);
			}
		}
		
		release.setVersion(ver);
		release.setVersionTxt(ver.code());
		release.setBugFixes(bugFix);
		return release;
	}
}
