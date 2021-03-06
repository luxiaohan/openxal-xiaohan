package xal.smf.impl;

import xal.smf.*;
import xal.smf.attr.*;
import xal.smf.impl.qualify.*;
import xal.ca.*;

/** 
 * The CvgGauge Class element. This class contains
 * the Convectron Gauge implementation. This type of vacuum gauge
 * is for higher pressures (during rough pumpdown).
 * 
 * @author  J. Galambos
 * 
 */

public class CvgGauge extends Vacuum  {
  
    
    static {
        registerType();
    }
    
   /*
     *  Constants
     */
    
    public static final String      s_strType   = "CVG";
    
    /*
     * Register type for qualification
     */
    private static void registerType() {
        ElementTypeManager typeManager = ElementTypeManager.defaultManager();
        typeManager.registerType(CvgGauge.class, s_strType);
    }

    /** Override to provide type signature */
    public String getType()   { return s_strType; };
      
 
    public CvgGauge(String strId)     { 
        super(strId);    
    }
}













