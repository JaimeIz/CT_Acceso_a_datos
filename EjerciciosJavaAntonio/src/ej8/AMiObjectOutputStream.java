package ej8;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AMiObjectOutputStream extends ObjectOutputStream{

	public AMiObjectOutputStream(OutputStream arg0) throws IOException {
		
		super(arg0);
		
	}

	protected void writeStreamHeader() throws IOException {}
	
}
