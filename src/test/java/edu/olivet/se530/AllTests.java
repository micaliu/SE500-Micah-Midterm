package edu.olivet.se530;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HtmlCrawlerTest.class, HtmlParserTest.class, SellerHunterTest.class })
public class AllTests {

}
