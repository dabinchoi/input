package my.examples.servlet;

import my.examples.dao.BoardDao;
import my.examples.dao.BoardDaoImpl;
import my.examples.dto.Board;
import my.examples.service.BoardService;
import my.examples.service.BoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "WriteformServlet", urlPatterns = "/write")
public class WriteformServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("logininfo");
        if (email == null) {
            System.out.println("-_-;;;;; 로그인 부탁!!");
            resp.sendRedirect("/login");
            return;
        } else {
            System.out.println("로그인 OK");
        }

        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/WEB-INF/views/write.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String user_id = req.getParameter("user_id");
        String user_name = req.getParameter("name");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        BoardService boardService = new BoardServiceImpl();
        Board board = new Board(user_id, user_name, title, content);
        boardService.addBoard(board);
        resp.sendRedirect("/list");
    }
}