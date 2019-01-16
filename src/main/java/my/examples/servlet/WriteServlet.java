package my.examples.servlet;

import my.examples.dao.BoardDao;
import my.examples.dao.BoardDaoImpl;
import my.examples.dto.Board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "WriteformServlet", urlPatterns = "/write")
public class WriteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/write.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String user_id = req.getParameter("user_id");
        String user_name = req.getParameter("user_name");
        String title = req.getParameter("title");
        String content = req.getParameter("content");


        BoardDao boardDao = new BoardDaoImpl();
        Board board = new Board(user_id,user_name,title,content);
        boardDao.addBoard(board);
        resp.sendRedirect("/list");
    }
}