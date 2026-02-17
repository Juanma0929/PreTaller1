package org.example.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.context.AppContext;
import org.example.entity.Course;
import org.example.service.CourseService;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/courses")
public class CourseServlet extends HttpServlet {

    private CourseService courseService;



    //Recibo la información para insertar el curso
    //Siempre un constructor vacío para los beans, para que el ioc container pueda instanciarlos
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Course course = new Course();
        course.setId(Integer.parseInt(req.getParameter("id")));
        course.setName(req.getParameter("name"));
        course.setProfessorName(req.getParameter("professorName"));
        course.setSchedule(req.getParameter("schedule"));

        courseService.saveCourse(course);
        resp.sendRedirect("./courses");
    }

    //Le debo dar al cliente el formulario, para que pueda insertar el curso
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        InputStream is = getClass().getResourceAsStream("/courses.html");
        String content = new String(is.readAllBytes());
        resp.getWriter().println(content);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        courseService = (CourseService) AppContext.getContext().getBean("courseService");
    }
}
