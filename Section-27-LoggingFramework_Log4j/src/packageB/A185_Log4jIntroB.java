package packageB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class A185_Log4jIntroB {
	
	private static Logger log = LogManager.getLogger(A185_Log4jIntroB.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log.debug("This is in debug modeB.");
		
		log.error("This is in error modeB.");
		
		log.error("This is in error mode2B.");
		
		log.info("This is infoB.");
		
		log.fatal("This is FatalB.");

	}

}
