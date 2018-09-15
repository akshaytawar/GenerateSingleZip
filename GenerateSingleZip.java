import java.io.*; 
import java.util.zip.ZipEntry; 
import java.util.zip.ZipOutputStream;

public class GenerateSingleZip {

/**This method compresses the single file to zip format
 * @param file
 */
	public static void generateZip(File file) {
		
		File zipfile=new File(file.toString().replaceAll(".xlsx",".zip" ));
		FileOutputStream fos=null;
		ZipOutputStream zos=null;
		FileInputStream fin=null;
		ZipEntry ze=null; 
			
		if(!zipfile.exists()){
			try {
				zipfile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			
			//create ZipOutputStream to write to  the zipfile
       fos=new FileOutputStream(zipfile);
			   zos=new ZipOutputStream(fos);
			   
		//add a new Zip Entry to the ZipOutPutStream   
			   ze=new ZipEntry(file.getName());
			   zos.putNextEntry(ze);
			   
		//read the file and write to the ZipOutPutStream	   
			   fin=new FileInputStream(file);
			   int i;
			   
			   while((i=fin.read())!=-1){
				   zos.write(i);
			   }
			
			   
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
							
				if(zos!=null && fos!=null && fin!=null){
					try {
				    //close the zip entry to write to to zip file
						zos.closeEntry();
					//close Resources.	
						zos.close();
						fos.close();
						fin.close();
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			}
		}
	
public static void main(String[] args) {
		
	File file=new File("path of file");
	GenerateSingleZip.generateZip(file);
}
}