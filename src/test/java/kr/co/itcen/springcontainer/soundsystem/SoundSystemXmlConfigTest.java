package kr.co.itcen.springcontainer.soundsystem;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
	Auto Configuration - XML Config(Annotation Scan)
	Component Scanning(@Component, @Named, @AutoWired, @Inject)
						@Servicd
						@Controller
						@Repository

	
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/soundsystem/SoundSystemConfig.xml"})
public class SoundSystemXmlConfigTest {
	
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	@Qualifier("highSchoolRapper3Final")
	private CompactDisc cd;
	
	@Autowired
	
	private CDPlayer cdPlayer;
	
	@Test
	public void testCDNull() {
		assertNotNull(cd);
	}
	
	@Test
	public void testCDPlayer() {
		assertNotNull(cdPlayer);
	}
	
	//@Ignore
	@Test
	public void testPlay() {
		cdPlayer.play();
		assertEquals("Playing 붕붕 by 김하은", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}
}
