package my.examples.input;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BoardModifyServlet" , urlPatterns = "/board/modify")
public class BoardModifyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Board> list = new ArrayList<>();
        list.add(new Board("안녕","ㅇㅇㅇㅇㅇㅇㅇ", "최성헌" ,"dㄴㅇ"));
        req.setAttribute("list",list);

        RequestDispatcher requestDispatcher
                = req.getRequestDispatcher("/WEB-INF/views/modify.jsp");
        requestDispatcher.forward(req, resp);

    }
}