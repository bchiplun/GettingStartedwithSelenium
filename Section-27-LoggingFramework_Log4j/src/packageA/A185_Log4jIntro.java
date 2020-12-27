package packageA;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class A185_Log4jIntro {
	
	private static Logger log = LogManager.getLogger(A185_Log4jIntro.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log.debug("This is in debug mode.");
		
		log.error("This is in error mode.");
		
		log.error("This is in error mode2.");
		
		log.info("This is info.");
		
		log.fatal("This is Fatal.");

	}

}
