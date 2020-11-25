package servletss;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapter.Database;

/**
 *
 * @author Dharmesh Mourya
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/DownloadServlet"})
public class DownloadServlet extends HttpServlet {

	public static int BUFFER_SIZE = 1024 * 100;
	public static final String UPLOAD_DIR = "resources";
	public static String fileName = null;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * *** Get The Absolute Path Of The File To Be Downloaded ****
		 */
		fileName = request.getParameter("fileName");
		if (fileName == null || fileName.equals("")) {
			/**
			 * *** Set Response Content Type ****
			 */
			response.setContentType("text/html");

			/**
			 * *** Print The Response ****
			 */
			response.getWriter().println("<h3>File " + fileName + " Is Not Present .....!</h3>");
		} else {
			String applicationPath = getServletContext().getRealPath("");
			String downloadPath = applicationPath + File.separator + UPLOAD_DIR;
			String filePath = downloadPath + File.separator + fileName;
//			System.out.println(fileName);
//			System.out.println(filePath);
//			System.out.println("fileName:" + fileName);
//			System.out.println("filePath :" + filePath);
			File file = new File(filePath);
			OutputStream outStream = null;
			FileInputStream inputStream = null;

			HttpSession s=request.getSession(false);
			int j=0;
			try{
				j=Integer.parseInt((String)s.getAttribute("student"));
			}
			catch(Exception e)
			{
				
			}

			
			Connection con=Database.getCon();
			String A[]=new String[7];

			try
			{
				
			System.out.println(con.toString());
			PreparedStatement ps6=con.prepareStatement("select * from(SELECT id, name, email,course, submitted ,total ,remaining  FROM student s, fee p   WHERE s.id =p.F_id) as student where id=?  ");
			ps6.setString(1,Integer.toString(j));	
			ResultSet rs6=ps6.executeQuery();
			int total=0;
			while(rs6.next()){

				A[0]=Integer.toString(rs6.getInt(1));
				A[1]=rs6.getString(2);
				A[2]=rs6.getString(3);
				A[3]=rs6.getString(4);
				A[4]=rs6.getString(5);
				A[5]=rs6.getString(6);
				A[6]=rs6.getString(7);


			//out.print(A[1]+A[0]+ A[2]+ A[3]+ A[4]+ A[5]+A[6]);
			}
			}
			catch(Exception e)
			{
				
			}
            FileWriter fw = new FileWriter(filePath);  
            fw.write("Student Id          : " +A[0] +"\n" );
            fw.write("Student Name        : " +A[1] +"\n" );
            fw.write("Student Email       : " +A[2] +"\n" );
            fw.write("Student Course      : " +A[3] +"\n" );
            fw.write("Student Total       : " +A[5] +"\n" );
            fw.write("Student Submitted   : " +A[4] +"\n" );
            fw.write("Student Remaining   : " +A[6] +"\n" );


            
            
            fw.close();

			
			
			if (file.exists()) {

				/**
				 * ** Setting The Content Attributes For The Response Object
				 * ***
				 */
				String mimeType = "application/octet-stream";
				response.setContentType(mimeType);

				/**
				 * ** Setting The Headers For The Response Object ***
				 */
				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
				response.setHeader(headerKey, headerValue);

				try {

					/**
					 * ** Get The Output Stream Of The Response ***
					 */
					outStream = response.getOutputStream();
					inputStream = new FileInputStream(file);
					byte[] buffer = new byte[BUFFER_SIZE];
					int bytesRead = -1;

					/**
					 * ** Write Each Byte Of Data Read From The Input Stream
					 * Write Each Byte Of Data Read From The Input Stream Into
					 * The Output Stream ***
					 */
					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outStream.write(buffer, 0, bytesRead);
					}
				} catch (IOException ioExObj) {
					//System.out.println("Exception While Performing The I/O Operation?= " + ioExObj.getMessage());
				} finally {
					if (inputStream != null) {
						inputStream.close();
					}

					outStream.flush();
					if (outStream != null) {
						outStream.close();
					}
				}
			} else {

				/**
				 * *** Set Response Content Type ****
				 */
				response.setContentType("text/html");

				/**
				 * *** Print The Response ****
				 */
				//response.getWriter().println("<h3>File " + fileName + " Is Not Present .....!</h3>");
			}

		}
	}

}