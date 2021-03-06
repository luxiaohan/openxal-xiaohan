/*
 * @(#)Main.java          0.9 05/21/2003
 *
 * Copyright (c) 2001-2002 Oak Ridge National Laboratory
 * Oak Ridge, Tenessee 37831, U.S.A.
 * All rights reserved.
 *
 */
package xal.app.extlatgenerator;

import java.util.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.net.*;

import xal.extension.application.*;
import xal.extension.application.smf.*;

/**
 * This is the main class for the external lattice file generation application.  
 *
 * @version   0.9  21 May 2003
 * @author  t6p
 * @author  Paul Chu
 */
 
public class Main extends ApplicationAdaptor {

    private URL url;
    
    //-------------Constructors-------------
    public Main() {url = null;}

    public Main(String str) {

	    try{
		url = new URL(str);
	    }
	    catch (MalformedURLException exception) {
		System.err.println(exception);
	    }
    }

    /** The main method of the application. */
    static public void main(String[] args) {
        try {
            System.out.println("Starting application...");
	    setOptions(args);
            AcceleratorApplication.launch( new Main() );
        }
        catch(Exception exception) {
            System.err.println( exception.getMessage() );
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, exception.getMessage(), exception.getClass().getName(), JOptionPane.WARNING_MESSAGE);
        }
    }

    public String applicationName() {
        return "extLatGenerator";
    }
    
    public XalDocument newDocument(java.net.URL url) {
        return new ExtGenDocument(url);
    }
    
    public XalDocument newEmptyDocument() {
        return new ExtGenDocument();
    }
    
    public String[] writableDocumentTypes() {
        return new String[] {"ext", "elg"};
    }
    
    public String[] readableDocumentTypes() {
        return new String[] {"ext", "elg"};
    }
    
}
