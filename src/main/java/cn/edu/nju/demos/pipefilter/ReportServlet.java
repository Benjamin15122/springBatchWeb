package cn.edu.nju.demos.pipefilter;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class ReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String[] springConfig =
                {
                        "spring/batch/jobs/job-hello-world.xml"
                };
        ApplicationContext context =
                new ClassPathXmlApplicationContext(springConfig);
        String exitStatus = new String("");
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("helloWorldJob");

        try {

            JobExecution execution = jobLauncher.run(job, new JobParameters());
            exitStatus = "Exit Status: " + execution.getStatus();
            System.out.println(exitStatus);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>this is a web page</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1 styles=\"color:blue\">SpringBatch Exit Status is</h1>");
        response.getWriter().println("<p styles=\"color:read\">"+exitStatus+"</p>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }
}
