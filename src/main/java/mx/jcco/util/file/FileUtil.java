package mx.jcco.util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Esta clase proporciona funciones para manipular archivos
 * @author Carlos Cortés
 */
public class FileUtil{
    
    /**
     * Este metodo convierte un archivo a un arreglo de bytes
     * @param src - La dirreccion absoluta del archivo
     * @return byte[] - El archivo en bytes
     * @throws IOException - En caso de ocurrir una excepcion
     */
    @SuppressWarnings("resource")
    public static byte[] getBytesFromSourceFile(final String src) throws IOException{
	
	final File file = new File(src);
	final InputStream is = new FileInputStream(file);
	final long length = file.length();
	
	if(length > Long.MAX_VALUE){
	    throw new RuntimeException("File is too large");
	}
	
	final byte[] bytes = new byte[(int) length];
	
	int offset = 0;
	int numRead = 0;
	while(offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0){
	    offset += numRead;
	}
	
	if(offset < bytes.length){
	    throw new IOException("Could not completely read file " + file.getName());
	}
	
	is.close();
	return bytes;
    }
    
}